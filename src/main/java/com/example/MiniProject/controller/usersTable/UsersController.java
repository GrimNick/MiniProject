package com.example.MiniProject.controller.usersTable;

import com.example.MiniProject.controller.SignInRequest;
import com.example.MiniProject.controller.SignInResponse;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.tokenize.Tokenizer;


@RestController
public class UsersController {
    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

    private final UsersService usersService;
    private POSModel posModel;
    private POSTaggerME tagger;

    @Value("${pos.model.path}")
    private String posModelPath;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }
    @PostConstruct
    public void init() throws IOException {
        // Load the pre-trained model for part-of-speech tagging
        try (InputStream modelIn = new FileInputStream(posModelPath)) {
            posModel = new POSModel(modelIn);
            tagger = new POSTaggerME(posModel);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<String> addHouse(@RequestBody users users) {
         System.out.println(users.toString());

        // Log the houseOwner before and after setting
        try {
            // Add validation or additional logic if needed
            usersService.saveProperties(users);
            return ResponseEntity.ok("User saved successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
    @PostMapping("/check-email")
    public ResponseEntity<Map<String, Boolean>> checkEmailAvailability(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");
        Map<String, Boolean> response = new HashMap<>();
        response.put("available", usersService.isEmailAvailable(email));
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/verify-credentials")
    public ResponseEntity<?> verifyCredentials(@RequestBody SignInRequest signInRequest) {
        Optional<UserDTO> userOptional = usersService.getUserByEmail(signInRequest.getEmail());

        if (userOptional.isPresent()) {
            UserDTO user = userOptional.get();
            System.out.println(usersService.verifyPassword("c","12"));
            if (usersService.verifyPassword(signInRequest.getEmail(), signInRequest.getPassword())) {

                return ResponseEntity.ok(new SignInResponse(true, user.getId()));
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new SignInResponse(false, null));
    }




    @PutMapping("/users/{id}")
    public ResponseEntity<String> updateHouse(@PathVariable Long id, @RequestBody users updatedUsers) {
        try {
            users existingUsers = usersService.getPropertiesById(id);

            if (existingUsers == null) {
                return ResponseEntity.notFound().build();
            }

            // Update the existing house with new values
//            existingProperties.setLocation(updatedProperties.getLocation());
//            existingProperties.setHouseOwner(updatedProperties.getHouseOwner());
//            // Add other fields as needed

            usersService.saveProperties(existingUsers);

            return ResponseEntity.ok("User updated successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteHouse(@PathVariable Long id) {
        try {
            usersService.deletePropertiesById(id);
            return ResponseEntity.ok("User deleted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

    @GetMapping("/user-details/{id}")
    public ResponseEntity<?> getUsersDetails(@PathVariable Long id) {
        UserDTO userDTO = usersService.getUserDTOById(id);
        if (userDTO != null) {
            return ResponseEntity.ok(userDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/tokenize/{sentence}")
    public ResponseEntity<?> tokenizeSentence(@PathVariable String sentence) {
    Tokenizer tokenizer = SimpleTokenizer.INSTANCE;
    String[] tokens = tokenizer.tokenize(sentence);

    // Tag parts of speech in the sentence
    String[] tags = tagger.tag(tokens);

        System.out.println("Token\tPOS");
        for (int i = 0; i < tokens.length; i++) {
            System.out.println(tokens[i] + "\t" + tags[i]);
        }

        // Extract and return adjectives
    List<String> adjectives = new ArrayList<>();
        for (int i = 0; i < tokens.length; i++) {
        if ("ADJ".equals(tags[i]) || "NOUN".equals(tags[i]) || "JJS".equals(tags[i])) { // Common POS tags for adjectives
            adjectives.add(tokens[i]);
        }
    }

        return ResponseEntity.ok(adjectives);

}

}
