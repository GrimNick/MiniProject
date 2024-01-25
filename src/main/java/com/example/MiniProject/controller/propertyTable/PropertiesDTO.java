package com.example.MiniProject.controller.propertyTable;


import com.example.MiniProject.controller.areaTable.area;
import com.example.MiniProject.controller.areaTable.area;
import com.example.MiniProject.controller.coordinatesTable.coordinates;
import com.example.MiniProject.controller.coordinatesTable.coordinates;
import com.example.MiniProject.controller.locationsTable.locations;
import com.example.MiniProject.controller.locationsTable.locations;
import com.example.MiniProject.controller.usersTable.users;
import com.example.MiniProject.controller.usersTable.users;

public class PropertiesDTO {
    private Long id;
    private users user;
    private locations location;
    private coordinates coordinate;
    private area _area;
    private String title;
    private int type;
    private String description;
    private byte[] image;
    private double price;
    private String propertyName;

    // Getter and setter methods for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and setter methods for user
    public users getUser() {
        return user;
    }

    public void setUser(users user) {
        this.user = user;
    }

    // Getter and setter methods for location
    public locations getLocation() {
        return location;
    }

    public void setLocation(locations location) {
        this.location = location;
    }

    // Getter and setter methods for coordinate
    public coordinates getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(coordinates coordinate) {
        this.coordinate = coordinate;
    }

    // Getter and setter methods for _area
    public area getArea() {
        return _area;
    }

    public void setArea(area _area) {
        this._area = _area;
    }

    // Getter and setter methods for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and setter methods for type
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    // Getter and setter methods for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and setter methods for image
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    // Getter and setter methods for price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Getter and setter methods for propertyName
    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
}
