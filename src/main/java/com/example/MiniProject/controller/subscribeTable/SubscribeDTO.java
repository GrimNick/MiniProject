package com.example.MiniProject.controller.subscribeTable;

public class SubscribeDTO {
    private Long id;

    private String email;

    private double price;


    private String location;

    private int type;

    public SubscribeDTO(){}
    public SubscribeDTO(String email,double price,
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