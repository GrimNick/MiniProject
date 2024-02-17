package com.example.MiniProject.controller.propertyTable;

import com.example.MiniProject.controller.areaTable.area;
import com.example.MiniProject.controller.coordinatesTable.coordinates;
import com.example.MiniProject.controller.locationsTable.locations;
import com.example.MiniProject.controller.usersTable.users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @PostMapping("/add-property")
    public ResponseEntity<PropertiesDTO> addProperty(@RequestBody PropertiesDTO propertiesDTO) {
        PropertiesDTO addedProperty = propertiesService.addProperty(propertiesDTO);
        return new ResponseEntity<>(addedProperty, HttpStatus.CREATED);
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
    @GetMapping("/properties")
    public List<properties> getAllProperties() {
        List<properties> propertiesList = new ArrayList<>();
        List<PropertiesDTO> propertiesDTOList = propertiesService.getAllProperties();

        for (PropertiesDTO dto : propertiesDTOList) {
            properties prop = new properties();
            prop.setId(dto.getId());
            // Set user (foreign key)
            if (dto.getUser() != null) {
                users user = new users();
                user.setId(dto.getUser().getId());
                // Set other user properties if needed
                prop.setUser(user);
            }

            // Set location (foreign key)
            if (dto.getLocation() != null) {
                locations location = new locations();
                location.setId(dto.getLocation().getId());
                // Set other location properties if needed
                prop.setLocation(location);
            }

            // Set coordinate (foreign key)
            if (dto.getCoordinate() != null) {
                coordinates coordinate = new coordinates();
                coordinate.setId((dto.getCoordinate()).getId());
                // Set other coordinate properties if needed
                prop.setCoordinate(coordinate);
            }

            // Set area (foreign key)
            if (dto.getArea() != null) {
                area _area = new area();
                _area.setId(dto.getArea().getId()); // Notice the change here
                // Set other area properties if needed
                prop.setArea(_area);
            }

            // Set other non-foreign key properties
            prop.setTitle(dto.getTitle());
            prop.setType(dto.getType());
            prop.setDescription(dto.getDescription());
            prop.setImage(dto.getImage());
            prop.setPrice(dto.getPrice());

            // Add the populated Properties object to the list
            propertiesList.add(prop);
        }

        return propertiesList;
    }

    @GetMapping("/property-details/{id}")
    public ResponseEntity<?> getPropertyDetails(@PathVariable Long id) {
        PropertiesDTO propertyDTO = propertiesService.getPropertiesDTOById(id);
        if (propertyDTO != null) {
            return ResponseEntity.ok(propertyDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
