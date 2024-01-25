package com.example.MiniProject.controller.usersTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<users, Long> {
    users findByEmail(String email);

    // Custom queries can be added here if needed
}
