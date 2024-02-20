package com.example.MiniProject.controller.subscribeTable;


import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "subscribe")
public class subscribe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    //images ********* baki
    //created_at ***** timestamp baki
    //updated_at ***** timestamp baki

    @Column(name = "email")
    private String email;
    @Column(name = "price")
    private double price;

    @Column(name = "location")
    private String location;

    @Column(name = "type")
    private int type;

    //Can later add bigha kattha dhur?
    public subscribe() {
        // You can leave it empty or initialize some default values if needed
    }

    public subscribe(String email,double price,
                     String location,int type) {
        this.email = email;
        this.price = price;
        this.location = location;
        this.type=type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
