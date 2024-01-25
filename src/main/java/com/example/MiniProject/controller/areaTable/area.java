package com.example.MiniProject.controller.areaTable;


import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "area")
public class area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    //images ********* baki
    //created_at ***** timestamp baki
    //updated_at ***** timestamp baki

    @Column(name = "ropani")
    private float ropani;
    @Column(name = "aana")
    private float aana;

    @Column(name = "paisa")
    private float paisa;

    @Column(name = "daam")
    private float daam;

    //Can later add bigha kattha dhur?
    public area() {
        // You can leave it empty or initialize some default values if needed
    }

    public area(float ropani,float aana,
                float paisa,float daam) {
        this.ropani = ropani;
        this.aana = aana;
        this.paisa = paisa;
        this.daam=daam;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
