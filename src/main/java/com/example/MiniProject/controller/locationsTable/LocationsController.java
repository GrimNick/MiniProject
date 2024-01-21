package com.example.MiniProject.controller.locationsTable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LocationsController {
    private static final Logger logger = LoggerFactory.getLogger(LocationsController.class);

    private final LocationsService locationsService;

    @Autowired
    public LocationsController(LocationsService locationsService) {
        this.locationsService = locationsService;
    }

    @PostMapping("/locations")
    public ResponseEntity<String> addHouse(@RequestBody locations locations) {
         System.out.println(locations.toString());

        // Log the houseOwner before and after setting
        try {
            // Add validation or additional logic if needed
            locationsService.saveProperties(locations);
            return ResponseEntity.ok("Locations saved successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
    @PutMapping("/locations/{id}")
    public ResponseEntity<String> updateHouse(@PathVariable Long id, @RequestBody locations updatedLocations) {
        try {
            locations existingLocations = locationsService.getPropertiesById(id);

            if (existingLocations == null) {
                return ResponseEntity.notFound().build();
            }

            // Update the existing house with new values
//            existingProperties.setLocation(updatedProperties.getLocation());
//            existingProperties.setHouseOwner(updatedProperties.getHouseOwner());
//            // Add other fields as needed

            locationsService.saveProperties(existingLocations);

            return ResponseEntity.ok("Locations updated successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
    @DeleteMapping("/locations/{id}")
    public ResponseEntity<String> deleteHouse(@PathVariable Long id) {
        try {
            locationsService.deletePropertiesById(id);
            return ResponseEntity.ok("Locations deleted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }


}
