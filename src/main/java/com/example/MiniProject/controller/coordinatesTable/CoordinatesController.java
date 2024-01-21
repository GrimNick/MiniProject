package com.example.MiniProject.controller.coordinatesTable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CoordinatesController {
    private static final Logger logger = LoggerFactory.getLogger(CoordinatesController.class);

    private final CoordinatesService coordinatesService;

    @Autowired
    public CoordinatesController(CoordinatesService coordinatesService) {
        this.coordinatesService = coordinatesService;
    }

    @PostMapping("/coordinates")
    public ResponseEntity<String> addHouse(@RequestBody coordinates coordinates) {
         System.out.println(coordinates.toString());

        // Log the houseOwner before and after setting
        try {
            // Add validation or additional logic if needed
            coordinatesService.saveProperties(coordinates);
            return ResponseEntity.ok("Coordinates saved successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
    @PutMapping("/coordinates/{id}")
    public ResponseEntity<String> updateHouse(@PathVariable Long id, @RequestBody coordinates updatedCoordinates) {
        try {
            coordinates existingCoordinates = coordinatesService.getPropertiesById(id);

            if (existingCoordinates == null) {
                return ResponseEntity.notFound().build();
            }

            // Update the existing house with new values
//            existingProperties.setLocation(updatedProperties.getLocation());
//            existingProperties.setHouseOwner(updatedProperties.getHouseOwner());
//            // Add other fields as needed

            coordinatesService.saveProperties(existingCoordinates);

            return ResponseEntity.ok("Coordinates updated successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
    @DeleteMapping("/coordinates/{id}")
    public ResponseEntity<String> deleteHouse(@PathVariable Long id) {
        try {
            coordinatesService.deletePropertiesById(id);
            return ResponseEntity.ok("Coordinates deleted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }


}
