package com.example.MiniProject.controller.coordinatesTable;


import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "coordinates")
public class coordinates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "latitude")
    private float latitude;

    @Column(name = "longitude")
    private float longitude;

    public coordinates() {
        // You can leave it empty or initialize some default values if needed
    }

    public coordinates(float latitude,
                       float longitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

}
