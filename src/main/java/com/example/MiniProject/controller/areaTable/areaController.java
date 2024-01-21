package com.example.MiniProject.controller.areaTable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class areaController {
    private static final Logger logger = LoggerFactory.getLogger(areaController.class);

    private final areaService areaService;

    @Autowired
    public areaController(areaService areaService) {
        this.areaService = areaService;
    }

    @PostMapping("/properties")
    public ResponseEntity<String> addHouse(@RequestBody area area) {
         System.out.println(area.toString());

        // Log the houseOwner before and after setting
        try {
            // Add validation or additional logic if needed
            areaService.saveProperties(area);
            return ResponseEntity.ok("Property saved successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
    @PutMapping("/properties/{id}")
    public ResponseEntity<String> updateHouse(@PathVariable Long id, @RequestBody area updatedArea) {
        try {
            area existingArea = areaService.getPropertiesById(id);

            if (existingArea == null) {
                return ResponseEntity.notFound().build();
            }

            // Update the existing house with new values
//            existingProperties.setLocation(updatedProperties.getLocation());
//            existingProperties.setHouseOwner(updatedProperties.getHouseOwner());
//            // Add other fields as needed

            areaService.saveProperties(existingArea);

            return ResponseEntity.ok("Property updated successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
    @DeleteMapping("/properties/{id}")
    public ResponseEntity<String> deleteHouse(@PathVariable Long id) {
        try {
            areaService.deletePropertiesById(id);
            return ResponseEntity.ok("Property deleted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }


}
