package com.example.MiniProject.controller.usersTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public ResponseEntity<String> saveProperties(users users) {
        try {
            usersRepository.save(users);
            return ResponseEntity.ok("User saved successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
    public users getPropertiesById(Long id) {
        return usersRepository.findById(id).orElse(null);
    }

    public void deletePropertiesById(Long id) {
        usersRepository.deleteById(id);
    }

}
