package com.example.MiniProject.controller.propertyTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertiesRepository extends JpaRepository<properties, Long> {

    // Custom queries can be added here if needed
}
