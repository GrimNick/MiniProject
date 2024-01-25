package com.example.MiniProject.controller.usersTable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UsersController {
    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
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


}
