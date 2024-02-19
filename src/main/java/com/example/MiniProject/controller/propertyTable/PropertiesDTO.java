package com.example.MiniProject.controller.propertyTable;

import com.example.MiniProject.controller.areaTable.AreaDTO;
import com.example.MiniProject.controller.coordinatesTable.CoordinateDTO;
import com.example.MiniProject.controller.locationsTable.LocationDTO;
import com.example.MiniProject.controller.usersTable.UserDTO;

public class PropertiesDTO {
    private Long id;
    private UserDTO user;
    private LocationDTO location;
    private CoordinateDTO coordinate;
    private AreaDTO area;
    private String title;
    private int type;
    private String description;
    private byte[] image;
    private double price;

    public PropertiesDTO(){
    }
    public PropertiesDTO(String title, String description, double budget, int aana, int paisa, int ropani, int daam, int type, Long userId, float latitude, float longitude, byte[] image) {
        this.title = title;
        this.description = description;
        this.price = budget; // Assuming budget corresponds to price
        System.out.println("aana is "+aana+ paisa + ropani + daam );
        this.area = new AreaDTO(aana, paisa, ropani, daam); // Assuming AreaDTO has a constructor that accepts these parameters
        this.type = type;
        this.user = new UserDTO(userId); // Assuming UserDTO has a constructor that accepts userId
        this.coordinate = new CoordinateDTO(latitude, longitude); // Assuming CoordinateDTO has a constructor that accepts these parameters
        this.image = image;
    }

    // Getter and setter methods for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and setter methods for user
    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    // Getter and setter methods for location
    public LocationDTO getLocation() {
        return location;
    }

    public void setLocation(LocationDTO location) {
        this.location = location;
    }

    // Getter and setter methods for coordinate
    public CoordinateDTO getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(CoordinateDTO coordinate) {
        this.coordinate = coordinate;
    }

    // Getter and setter methods for area
    public AreaDTO getArea() {
        return area;
    }

    public void setArea(AreaDTO area) {
        this.area = area;
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
}
