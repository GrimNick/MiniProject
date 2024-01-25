package com.example.MiniProject.controller.propertyTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<PropertiesDTO> getAllProperties() {
        List<properties> properties = propertiesRepository.findAll();
        return properties.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private PropertiesDTO convertToDTO(properties _properties) {
        PropertiesDTO dto = new PropertiesDTO();
        dto.setId(_properties.getId());
        dto.setPropertyName(_properties.getPropertyName());
        dto.setUser(_properties.getUser()); // Assuming user is already a DTO
        dto.setLocation(_properties.getLocation()); // Assuming location is already a DTO
        dto.setCoordinate(_properties.getCoordinate()); // Assuming coordinate is already a DTO
        dto.setArea(_properties.getArea()); // Assuming area is already a DTO
        dto.setTitle(_properties.getTitle());
        dto.setType(_properties.getType());
        dto.setDescription(_properties.getDescription());
        dto.setImage(_properties.getImage());
        dto.setPrice(_properties.getPrice());
        return dto;
    }

    public properties getPropertiesById(Long id) {
        return propertiesRepository.findById(id).orElse(null);
    }

    public void deletePropertiesById(Long id) {
        propertiesRepository.deleteById(id);
    }
}
