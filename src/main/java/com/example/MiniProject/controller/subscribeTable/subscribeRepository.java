package com.example.MiniProject.controller.subscribeTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface subscribeRepository extends JpaRepository<subscribe, Long> {
    void deleteByEmail(String email);

    // Custom queries can be added here if needed
}
