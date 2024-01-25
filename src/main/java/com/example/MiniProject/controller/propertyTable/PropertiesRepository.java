package com.example.MiniProject.controller.propertyTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PropertiesRepository extends JpaRepository<properties, Long> {
    Optional<properties> findById(Long id);

    // Custom queries can be added here if needed
}
