package com.example.MiniProject.controller.coordinatesTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordinatesRepository extends JpaRepository<coordinates, Long> {

    // Custom queries can be added here if needed
}
