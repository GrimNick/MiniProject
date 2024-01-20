package com.example.MiniProject.controller.houseTable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HouseController {
    private static final Logger logger = LoggerFactory.getLogger(HouseController.class);

    private final HouseService houseService;

    @Autowired
    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @PostMapping("/houses")
    public ResponseEntity<String> addHouse(@RequestBody House house) {
         System.out.println(house.toString());

        // Log the houseOwner before and after setting
        try {
            // Add validation or additional logic if needed
            houseService.saveHouse(house);
            return ResponseEntity.ok("House saved successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
    @PutMapping("/houses/{id}")
    public ResponseEntity<String> updateHouse(@PathVariable Long id, @RequestBody House updatedHouse) {
        try {
            House existingHouse = houseService.getHouseById(id);

            if (existingHouse == null) {
                return ResponseEntity.notFound().build();
            }

            // Update the existing house with new values
            existingHouse.setLocation(updatedHouse.getLocation());
            existingHouse.setHouseOwner(updatedHouse.getHouseOwner());
            // Add other fields as needed

            houseService.saveHouse(existingHouse);

            return ResponseEntity.ok("House updated successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
    @DeleteMapping("/houses/{id}")
    public ResponseEntity<String> deleteHouse(@PathVariable Long id) {
        try {
            houseService.deleteHouseById(id);
            return ResponseEntity.ok("House deleted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }


}
