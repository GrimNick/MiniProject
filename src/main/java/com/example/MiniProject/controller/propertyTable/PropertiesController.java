package com.example.MiniProject.controller.propertyTable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PropertiesController {
    private static final Logger logger = LoggerFactory.getLogger(PropertiesController.class);

    private final PropertiesService propertiesService;

    @Autowired
    public PropertiesController(PropertiesService propertiesService) {
        this.propertiesService = propertiesService;
    }

    @PostMapping("/properties")
    public ResponseEntity<String> addHouse(@RequestBody properties properties) {
         System.out.println(properties.toString());

        // Log the houseOwner before and after setting
        try {
            // Add validation or additional logic if needed
            propertiesService.saveProperties(properties);
            return ResponseEntity.ok("Property saved successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
    @PutMapping("/properties/{id}")
    public ResponseEntity<String> updateHouse(@PathVariable Long id, @RequestBody properties updatedProperties) {
        try {
            properties existingProperties = propertiesService.getPropertiesById(id);

            if (existingProperties == null) {
                return ResponseEntity.notFound().build();
            }

            // Update the existing house with new values
//            existingProperties.setLocation(updatedProperties.getLocation());
//            existingProperties.setHouseOwner(updatedProperties.getHouseOwner());
//            // Add other fields as needed

            propertiesService.saveProperties(existingProperties);

            return ResponseEntity.ok("Property updated successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
    @DeleteMapping("/properties/{id}")
    public ResponseEntity<String> deleteHouse(@PathVariable Long id) {
        try {
            propertiesService.deletePropertiesById(id);
            return ResponseEntity.ok("Property deleted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }


}
