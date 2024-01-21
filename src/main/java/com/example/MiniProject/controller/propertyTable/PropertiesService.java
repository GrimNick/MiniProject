package com.example.MiniProject.controller.propertyTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PropertiesService {

    private final PropertiesRepository propertiesRepository;

    @Autowired
    public PropertiesService(PropertiesRepository propertiesRepository) {
        this.propertiesRepository = propertiesRepository;
    }

    public ResponseEntity<String> saveProperties(properties properties) {
        try {
            propertiesRepository.save(properties);
            return ResponseEntity.ok("Property saved successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
    public properties getPropertiesById(Long id) {
        return propertiesRepository.findById(id).orElse(null);
    }

    public void deletePropertiesById(Long id) {
        propertiesRepository.deleteById(id);
    }

}
