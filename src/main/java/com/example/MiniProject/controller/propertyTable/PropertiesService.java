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


    public ResponseEntity<Integer> savePropertiesRetId(properties properties) {
        try {
            // Save the property and get the ID
            properties savedProperty = propertiesRepository.save(properties);
            // Return the ID in the response
            return ResponseEntity.ok(savedProperty.getId().intValue());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(-1); // Or any error code you prefer
        }
    }


    public List<PropertiesDTO> getAllProperties() {
        List<properties> properties = propertiesRepository.findAll();
        return properties.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    private properties convertToEntity(PropertiesDTO dto) {
        properties _properties = new properties();
        _properties.setId(dto.getId());
        _properties.setTitle(dto.getTitle());

        // Convert user DTO to entity
        _properties.setUser(convertUserDTOToEntity(dto.getUser()));

        // Convert location DTO to entity
        _properties.setLocation(convertLocationDTOToEntity(dto.getLocation()));

        // Convert coordinate DTO to entity
        _properties.setCoordinate(convertCoordinateDTOToEntity(dto.getCoordinate()));

        // Convert area DTO to entity
        _properties.setArea(convertAreaDTOToEntity(dto.getArea()));

        _properties.setTitle(dto.getTitle());
        _properties.setType(dto.getType());
        _properties.setDescription(dto.getDescription());
        _properties.setImage(dto.getImage());
        _properties.setPrice(dto.getPrice());

        return _properties;
    }

    private users convertUserDTOToEntity(UserDTO userDTO) {
        users userEntity = new users();
        userEntity.setId(userDTO.getId());
        userEntity.setRole(convertRoleDTOToEntity(userDTO.getRole()));
        userEntity.setPhone(userDTO.getPhone());
        userEntity.setName(userDTO.getName());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setEmail(userDTO.getEmail());
        // Map other properties as needed
        return userEntity;
    }


    private roles convertRoleDTOToEntity(RoleDTO roleDTO){
        roles role = new roles();
        role.setId(roleDTO.getId());
        role.setName(roleDTO.getName());
        // Set other properties as needed
        return role;
    }
    private locations convertLocationDTOToEntity(LocationDTO locationDTO) {
        locations locationEntity = new locations();
        locationEntity.setId(locationDTO.getId());
        locationEntity.setAddress(locationDTO.getAddress());
      // Map other properties as needed
        return locationEntity;
    }

    private coordinates convertCoordinateDTOToEntity(CoordinateDTO coordinateDTO) {
        coordinates coordinateEntity = new coordinates();
        coordinateEntity.setId(coordinateDTO.getId());
        coordinateEntity.setLatitude(coordinateDTO.getLatitude());
        coordinateEntity.setLongitude(coordinateDTO.getLongitude());
        // Map other properties as needed
        return coordinateEntity;
    }

    private area convertAreaDTOToEntity(AreaDTO areaDTO) {
        area areaEntity = new area();
        areaEntity.setId(areaDTO.getId());
        areaEntity.setAana(areaDTO.getAana());
        areaEntity.setPaisa(areaDTO.getPaisa());
        areaEntity.setRopani(areaDTO.getRopani());
        areaEntity.setDaam(areaDTO.getDaam());
        // Map other properties as needed
        return areaEntity;
    }



    private PropertiesDTO convertToDTO(properties _properties) {
        PropertiesDTO dto = new PropertiesDTO();
        dto.setId(_properties.getId());

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

    public PropertiesDTO addProperty(PropertiesDTO propertiesDTO) {
        // Convert PropertiesDTO to Properties entity if needed
        properties _properties = convertToEntity(propertiesDTO);

        // Save the property
        properties savedProperty = propertiesRepository.save(_properties);

        // Convert the saved property entity back to DTO and return
        return convertToDTO(savedProperty);
    }


    public properties getPropertiesById(Long id) {
        return propertiesRepository.findById(id).orElse(null);
    }

    public void deletePropertiesById(Long id) {
        propertiesRepository.deleteById(id);
    }
}
