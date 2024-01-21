package com.example.MiniProject.controller.RolesTable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RolesController {
    private static final Logger logger = LoggerFactory.getLogger(RolesController.class);

    private final RolesService rolesService;

    @Autowired
    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @PostMapping("/roles")
    public ResponseEntity<String> addHouse(@RequestBody roles roles) {
         System.out.println(roles.toString());

        // Log the houseOwner before and after setting
        try {
            // Add validation or additional logic if needed
            rolesService.saveProperties(roles);
            return ResponseEntity.ok("Roles saved successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
    @PutMapping("/roles/{id}")
    public ResponseEntity<String> updateHouse(@PathVariable Long id, @RequestBody roles updatedRoles) {
        try {
            roles existingRoles = rolesService.getPropertiesById(id);

            if (existingRoles == null) {
                return ResponseEntity.notFound().build();
            }

            // Update the existing house with new values
//            existingProperties.setLocation(updatedProperties.getLocation());
//            existingProperties.setHouseOwner(updatedProperties.getHouseOwner());
//            // Add other fields as needed

            rolesService.saveProperties(existingRoles);

            return ResponseEntity.ok("Roles updated successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
    @DeleteMapping("/roles/{id}")
    public ResponseEntity<String> deleteHouse(@PathVariable Long id) {
        try {
            rolesService.deletePropertiesById(id);
            return ResponseEntity.ok("Roles deleted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }


}
