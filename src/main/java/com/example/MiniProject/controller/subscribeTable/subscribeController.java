package com.example.MiniProject.controller.subscribeTable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class subscribeController
{
    private static final Logger logger = LoggerFactory.getLogger(subscribeController.class);

    private final subscribeService subscribeService;

    @Autowired
    public subscribeController(subscribeService subscribeService) {
        this.subscribeService = subscribeService;
    }

    @PostMapping("/subscribe")
    public ResponseEntity<String> addSubscribe(@RequestBody subscribe _subscribe) {
         System.out.println(_subscribe.toString());

        // Log the houseOwner before and after setting
        try {
            // Add validation or additional logic if needed
            subscribeService.saveSubscribe(_subscribe);
            return ResponseEntity.ok("Property saved successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
//
//    @PostMapping("/areaById")
//    public ResponseEntity<Long> addAreaById(@RequestBody area _area) {
//        try {
//            Long areaIdToReturn = subscribeService.saveAreaById(_area);
//            return ResponseEntity.ok(areaIdToReturn); // Assuming getId() returns the ID of the saved entity
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(-1L); // Return -1 for error
//        }
//    }
//    @PutMapping("/area/{id}")
//    public ResponseEntity<String> updateHouse(@PathVariable Long id, @RequestBody area updatedArea) {
//        try {
//            area existingArea = subscribeService.getPropertiesById(id);
//
//            if (existingArea == null) {
//                return ResponseEntity.notFound().build();
//            }
//
//            // Update the existing house with new values
////            existingProperties.setLocation(updatedProperties.getLocation());
////            existingProperties.setHouseOwner(updatedProperties.getHouseOwner());
////            // Add other fields as needed
//
//            subscribeService.saveArea(existingArea);
//
//            return ResponseEntity.ok("Property updated successfully!");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
//        }
//    }

    @GetMapping("/subscribe-details/{id}")
    public ResponseEntity<?> getSubscribeDetails(@PathVariable Long id) {
        SubscribeDTO _subscribeDTO = subscribeService.getSubscribeDTOById(id);
        if (_subscribeDTO != null) {
            return ResponseEntity.ok(_subscribeDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/subscribe")
    public List<subscribe> getAllSubscribeProperties() {
        System.out.println("here");
        List<subscribe> subscribePropertiesList = new ArrayList<>();
        List<SubscribeDTO> subscribePropertyDTOList = subscribeService.getAllSubscribeProperties();

        for (SubscribeDTO dto : subscribePropertyDTOList) {
            subscribe subscribeProperty = new subscribe();
            subscribeProperty.setId(dto.getId());
            // Set other non-foreign key properties
            subscribeProperty.setLocation(dto.getLocation());
            subscribeProperty.setType(dto.getType());
            subscribeProperty.setPrice(dto.getPrice());
            subscribeProperty.setEmail(dto.getEmail());

            // Add the populated SubscribeProperty object to the list
            subscribePropertiesList.add(subscribeProperty);
        }

        return subscribePropertiesList;
    }

    @DeleteMapping("/subscribeRemoveByEmail")
    public ResponseEntity<String> deleteSubscribeByEmail(@RequestParam String email) {
        try {
            subscribeService.deleteSubscribeByEmail(email);
            return ResponseEntity.ok("Properties deleted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

    @DeleteMapping("/subscribe/{id}")
    public ResponseEntity<String> deleteSubscribe(@PathVariable Long id) {
        try {
            subscribeService.deletePropertiesById(id);
            return ResponseEntity.ok("Property deleted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }


}
