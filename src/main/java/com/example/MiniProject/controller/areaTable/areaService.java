package com.example.MiniProject.controller.areaTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class areaService {

    private final areaRepository areaRepository;

    @Autowired
    public areaService(areaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public ResponseEntity<String> saveArea(area area) {
        try {
            areaRepository.save(area);
            return ResponseEntity.ok("Property saved successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

    public Long saveAreaById(area area) {
        try {
            area savedArea = areaRepository.save(area);
            return savedArea.getId(); // Assuming getId() returns the ID of the saved area
        } catch (Exception e) {
            e.printStackTrace();
            return -1L; // Or any error code you prefer
        }
    }

    public AreaDTO getAreaDTOById(Long id) {
        // Use the LocationRepository to fetch the location entity by ID
        area _area = areaRepository.findById(id).orElse(null);
        if (_area != null) {
            return convertToDTO(_area);
        } else {
            return null;
        }

    }


    private AreaDTO convertToDTO(area _area) {
        // Implement conversion logic here
        // For example:
        AreaDTO areaDTO = new AreaDTO();
        areaDTO.setId(_area.getId());
        areaDTO.setPaisa(_area.getPaisa());
        areaDTO.setAana(_area.getAana());
        areaDTO.setDaam(_area.getDaam());
        areaDTO.setRopani(_area.getRopani());
        // Set other properties as needed
        return areaDTO;
    }

    public area getPropertiesById(Long id) {
        return areaRepository.findById(id).orElse(null);
    }

    public void deletePropertiesById(Long id) {
        areaRepository.deleteById(id);
    }

}
