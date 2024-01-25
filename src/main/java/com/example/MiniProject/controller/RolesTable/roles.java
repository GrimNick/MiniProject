package com.example.MiniProject.controller.RolesTable;


import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "roles")
public class roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

   //Make names :
    //Buyer:1

    //Seller:2

    //Admin:3
    @Column(name = "name", length = 15)
    private String name;

    public roles() {
        // You can leave it empty or initialize some default values if needed
    }
    public roles(String name) {
        this.name = name;
    }
}
