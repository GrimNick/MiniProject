package com.example.MiniProject.controller.propertyTable;
import com.example.MiniProject.controller.RolesTable.RoleDTO;
import com.example.MiniProject.controller.RolesTable.roles;
import com.example.MiniProject.controller.areaTable.AreaDTO;
import com.example.MiniProject.controller.areaTable.area;
import com.example.MiniProject.controller.coordinatesTable.CoordinateDTO;
import com.example.MiniProject.controller.coordinatesTable.coordinates;
import com.example.MiniProject.controller.locationsTable.LocationDTO;
import com.example.MiniProject.controller.locationsTable.locations;
import com.example.MiniProject.controller.usersTable.UserDTO;
import com.example.MiniProject.controller.usersTable.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        dto.setPropertyName(_properties.getTitle());

        // Convert users entity to DTO
        dto.setUser(userToDTO(_properties.getUser()));

        // Convert locations entity to DTO
        dto.setLocation(locationToDTO(_properties.getLocation()));

        // Convert coordinates entity to DTO
        dto.setCoordinate(coordinatesToDTO(_properties.getCoordinate()));

        // Convert area entity to DTO
        dto.setArea(areaToDTO(_properties.getArea()));

        dto.setTitle(_properties.getTitle());
        dto.setType(_properties.getType());
        dto.setDescription(_properties.getDescription());
        dto.setImage(_properties.getImage());
        dto.setPrice(_properties.getPrice());
        return dto;
    }

    // Helper methods to convert entities to DTOs
    private UserDTO userToDTO(users user) {
        if (user == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        // Assuming RoleDTO has been implemented
        userDTO.setRole(roleToDTO(user.getRole()));
        return userDTO;
    }

    private RoleDTO roleToDTO(roles role) {
        if (role == null) {
            return null;
        }
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(role.getId());
        roleDTO.setName(role.getName());
        return roleDTO;
    }

    private LocationDTO locationToDTO(locations location) {
        if (location == null) {
            return null;
        }
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId(location.getId());
        locationDTO.setCountry(location.getCountry());
        locationDTO.setAddress(location.getAddress());
        return locationDTO;
    }

    private CoordinateDTO coordinatesToDTO(coordinates coordinate) {
        if (coordinate == null) {
            return null;
        }
        CoordinateDTO coordinateDTO = new CoordinateDTO();
        coordinateDTO.setId(coordinate.getId());
        coordinateDTO.setLatitude(coordinate.getLatitude());
        coordinateDTO.setLongitude(coordinate.getLongitude());
        return coordinateDTO;
    }

    private AreaDTO areaToDTO(area _area) {
        if (_area == null) {
            return null;
        }
        AreaDTO areaDTO = new AreaDTO();
        areaDTO.setId(_area.getId());
        areaDTO.setRopani(_area.getRopani());
        areaDTO.setAana(_area.getAana());
        areaDTO.setPaisa(_area.getPaisa());
        areaDTO.setDaam(_area.getDaam());
        return areaDTO;
    }
    public PropertiesDTO getPropertiesDTOById(Long id) {
        properties _properties = propertiesRepository.findById(id)
                .orElse(null);
        if (_properties != null) {
            return convertToDTO(_properties);
        } else {
            return null;
        }
    }

    public properties getPropertiesById(Long id) {
        return propertiesRepository.findById(id).orElse(null);
    }

    public void deletePropertiesById(Long id) {
        propertiesRepository.deleteById(id);
    }
}
