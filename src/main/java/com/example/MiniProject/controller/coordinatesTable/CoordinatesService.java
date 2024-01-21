package com.example.MiniProject.controller.coordinatesTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CoordinatesService {

    private final CoordinatesRepository coordinatesRepository;

    @Autowired
    public CoordinatesService(CoordinatesRepository coordinatesRepository) {
        this.coordinatesRepository = coordinatesRepository;
    }

    public ResponseEntity<String> saveProperties(coordinates coordinates) {
        try {
            coordinatesRepository.save(coordinates);
            return ResponseEntity.ok("Coordinates saved successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
    public coordinates getPropertiesById(Long id) {
        return coordinatesRepository.findById(id).orElse(null);
    }

    public void deletePropertiesById(Long id) {
        coordinatesRepository.deleteById(id);
    }

}
