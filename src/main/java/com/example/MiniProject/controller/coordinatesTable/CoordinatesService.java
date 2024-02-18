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

    public ResponseEntity<String> saveCoordinates(coordinates coordinates) {
        try {
            coordinatesRepository.save(coordinates);
            return ResponseEntity.ok("Coordinates saved successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

    public Long saveCoordinatesById(coordinates coordinates) {
        try {
            coordinates savedCoordinates = coordinatesRepository.save(coordinates);
            return savedCoordinates.getId(); // Assuming getId() returns the ID of the saved entity
        } catch (Exception e) {
            e.printStackTrace();
            return -1L; // Or any error code you prefer
        }
    }



    public coordinates getPropertiesById(Long id) {
        return coordinatesRepository.findById(id).orElse(null);
    }

    public void deletePropertiesById(Long id) {
        coordinatesRepository.deleteById(id);
    }

}
