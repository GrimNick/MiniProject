package com.example.MiniProject.controller.locationsTable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

public interface LocationsRepository extends JpaRepository<locations, Long> {

    // Custom queries can be added here if needed
}
