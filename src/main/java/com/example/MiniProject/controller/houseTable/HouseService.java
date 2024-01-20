package com.example.MiniProject.controller.houseTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HouseService {

    private final HouseRepository houseRepository;

    @Autowired
    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public ResponseEntity<String> saveHouse(House house) {
        try {
            houseRepository.save(house);
            return ResponseEntity.ok("House saved successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
    public House getHouseById(Long id) {
        return houseRepository.findById(id).orElse(null);
    }

    public void deleteHouseById(Long id) {
        houseRepository.deleteById(id);
    }

}
