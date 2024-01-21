package com.example.MiniProject.controller.areaTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface areaRepository extends JpaRepository<area, Long> {

    // Custom queries can be added here if needed
}
