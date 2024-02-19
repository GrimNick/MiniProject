package com.example.MiniProject.controller.subscribeTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class subscribeService {

    private final subscribeRepository subscribeRepository;

    @Autowired
    public subscribeService(subscribeRepository subscribeRepository) {
        this.subscribeRepository = subscribeRepository;
    }

    public ResponseEntity<String> saveSubscribe(subscribe _subscribe) {
        try {
            subscribeRepository.save(_subscribe);
            return ResponseEntity.ok("subscribe saved successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

    public Long saveSubscribeById(subscribe _subscribe) {
        try {
            com.example.MiniProject.controller.subscribeTable.subscribe savedSubscribe = subscribeRepository.save(_subscribe);
            return savedSubscribe.getId(); // Assuming getId() returns the ID of the saved area
        } catch (Exception e) {
            e.printStackTrace();
            return -1L; // Or any error code you prefer
        }
    }

    public SubscribeDTO getSubscribeDTOById(Long id) {
        // Use the LocationRepository to fetch the location entity by ID
        subscribe _subscribe = subscribeRepository.findById(id).orElse(null);
        if (_subscribe != null) {
            return convertToDTO(_subscribe);
        } else {
            return null;
        }

    }

    public List<SubscribeDTO> getAllSubscribeProperties() {
        List<subscribe> subscribeProperties = subscribeRepository.findAll();
        return subscribeProperties.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }



    private SubscribeDTO convertToDTO(subscribe _subscribe) {
        // Implement conversion logic here
        // For example:
        SubscribeDTO subscribeDTO = new SubscribeDTO();
        subscribeDTO.setId(_subscribe.getId());
        subscribeDTO.setLocation(_subscribe.getLocation());
        subscribeDTO.setPrice(_subscribe.getPrice());
        subscribeDTO.setEmail(_subscribe.getEmail());
        subscribeDTO.setType(_subscribe.getType());
        // Set other properties as needed
        return subscribeDTO;
    }

    public void deleteSubscribeByEmail(String email) {
        subscribeRepository.deleteByEmail(email);
    }

    public subscribe getPropertiesById(Long id) {
        return subscribeRepository.findById(id).orElse(null);
    }

    public void deletePropertiesById(Long id) {
        subscribeRepository.deleteById(id);
    }

}
