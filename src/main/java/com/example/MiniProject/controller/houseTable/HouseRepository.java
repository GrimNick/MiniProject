package com.example.MiniProject.controller.houseTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House, Long> {

    // Custom queries can be added here if needed
}
