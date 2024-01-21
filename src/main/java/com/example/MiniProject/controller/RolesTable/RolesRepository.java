package com.example.MiniProject.controller.RolesTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<roles, Long> {

    // Custom queries can be added here if needed
}
