package com.example.MiniProject.controller.RolesTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RolesService {

    private final RolesRepository rolesRepository;

    @Autowired
    public RolesService(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    public ResponseEntity<String> saveProperties(roles roles) {
        try {
            rolesRepository.save(roles);
            return ResponseEntity.ok("Roles saved successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
    public roles getPropertiesById(Long id) {
        return rolesRepository.findById(id).orElse(null);
    }

    public void deletePropertiesById(Long id) {
        rolesRepository.deleteById(id);
    }

}
