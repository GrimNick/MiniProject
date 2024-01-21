package com.example.MiniProject.controller.locationsTable;


import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "locations")
public class locations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "country")
    private int country;

    @Column(name = "address", length = 100)
    private String address;


    public locations() {
        // You can leave it empty or initialize some default values if needed
    }

    public locations(String address) {
        this.address = address;
    }

}
