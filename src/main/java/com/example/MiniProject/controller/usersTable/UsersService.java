package com.example.MiniProject.controller.usersTable;
import com.example.MiniProject.controller.RolesTable.RoleDTO;
import com.example.MiniProject.controller.RolesTable.roles;
import com.example.MiniProject.controller.propertyTable.properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public ResponseEntity<String> saveProperties(users users) {
        try {
            usersRepository.save(users);
            return ResponseEntity.ok("User saved successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }


    public users getPropertiesById(Long id) {
        return usersRepository.findById(id).orElse(null);
    }

    public void deletePropertiesById(Long id) {
        usersRepository.deleteById(id);
    }

    public boolean isEmailAvailable(String email) {
        Optional<users> user = usersRepository.findByEmail(email);
        return user.isEmpty();
    }

    public Optional<UserDTO> getUserByEmail(String email) {
        Optional<users> userOptional = usersRepository.findByEmail(email);
        return userOptional.map(user -> {
            // Convert users entity to UserDTO
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setRole(mapRoleDTO(user.getRole().getId())); // Assuming getRoleId() returns the role ID
            userDTO.setPhone(user.getPhone());
            userDTO.setName(user.getName());
            userDTO.setPassword(user.getPassword());
            userDTO.setEmail(user.getEmail());
            return userDTO;
        });
    }

    private RoleDTO mapRoleDTO(Long roleId) {
        // Here, you need to implement logic to fetch the RoleDTO based on the roleId
        // This logic might involve querying the database or some other data source
        // For demonstration, let's assume a simple method to create a RoleDTO object
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(roleId);
        if (roleId == 1) {
            roleDTO.setName("Buyer");
        } else if (roleId == 2) {
            roleDTO.setName("Seller");
        } else if (roleId == 3) {
            roleDTO.setName("Admin");
        } else {
            roleDTO.setName("Unknown");
        }
        return roleDTO;
    }

    public boolean verifyPassword(String email, String password) {
        Optional<UserDTO> userOptional = getUserByEmail(email);
        if (userOptional.isPresent()) {
            UserDTO user = userOptional.get();

            return user.getPassword().equals(password);
        }
        return false; // User not found
    }
    private UserDTO convertToDTO(users user) {
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

    public UserDTO getUserDTOById(Long id) {
        Optional<users> userOptional;
        userOptional = usersRepository.findById(id);
        return userOptional.map(this::convertToDTO).orElse(null);
    }






}
