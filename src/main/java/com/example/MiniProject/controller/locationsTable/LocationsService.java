package com.example.MiniProject.controller.locationsTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationsService {

    private final LocationsRepository locationsRepository;

    @Autowired
    public LocationsService(LocationsRepository locationsRepository) {
        this.locationsRepository = locationsRepository;
    }

    public LocationsService() {
        this.locationsRepository = null; // Or initialize it with a new instance, depending on your logic

    }

    public ResponseEntity<String> saveLocations(locations locations) {
        try {
            locationsRepository.save(locations);
            return ResponseEntity.ok("Locations saved successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

    public Long saveLocationsById(locations locations) {
        try {
            locations savedLocation = locationsRepository.save(locations);
            Long savedLocationId = savedLocation.getId(); // Assuming getId() returns the ID of the saved location
            return savedLocationId;
        } catch (Exception e) {
            e.printStackTrace();
            return -1L; // Or any error code you prefer
        }
    }

    public LocationDTO getLocationDTOById(Long id) {
        // Use the LocationRepository to fetch the location entity by ID
        locations _locations = locationsRepository.findById(id).orElse(null);
        if (_locations != null) {
            return convertToDTO(_locations);
        } else {
            return null;
        }

    }

    private LocationDTO convertToDTO(locations location) {
        // Implement conversion logic here
        // For example:
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId(location.getId());
        locationDTO.setCountry(location.getCountry());
        locationDTO.setAddress(location.getAddress());
        // Set other properties as needed
        return locationDTO;
    }


    public locations getPropertiesById(Long id) {
        return locationsRepository.findById(id).orElse(null);
    }
    public Optional<locations> getLocationById(Long id) {
        return locationsRepository.findById(id);
    }

    public void deletePropertiesById(Long id) {
        locationsRepository.deleteById(id);
    }

}
