package com.example.MiniProject.controller.locationsTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LocationsService {

    private final LocationsRepository locationsRepository;

    @Autowired
    public LocationsService(LocationsRepository locationsRepository) {
        this.locationsRepository = locationsRepository;
    }

    public ResponseEntity<String> saveProperties(locations locations) {
        try {
            locationsRepository.save(locations);
            return ResponseEntity.ok("Locations saved successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
    public locations getPropertiesById(Long id) {
        return locationsRepository.findById(id).orElse(null);
    }

    public void deletePropertiesById(Long id) {
        locationsRepository.deleteById(id);
    }

}
