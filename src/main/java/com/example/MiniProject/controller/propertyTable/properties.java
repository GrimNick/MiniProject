package com.example.MiniProject.controller.propertyTable;
import com.example.MiniProject.controller.areaTable.AreaDTO;
import com.example.MiniProject.controller.coordinatesTable.CoordinateDTO;
import com.example.MiniProject.controller.usersTable.users;
import com.example.MiniProject.controller.locationsTable.locations;
import com.example.MiniProject.controller.coordinatesTable.coordinates;
import com.example.MiniProject.controller.areaTable.area;


import com.example.MiniProject.controller.RolesTable.roles;
import jakarta.persistence.*;

import lombok.Data;
@Data
@Entity
@Table(name = "properties")
public class properties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    private users user;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private locations location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coordinate_id", referencedColumnName = "id")
    private coordinates coordinate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id", referencedColumnName = "id")
    private area _area;

    @Column(name = "title", length = 30)
    private String title;

    //if property is 0 - > land, 1->house , 2->both
    @Column(name = "type")
    private int type;

    @Column(name = "description", length = 100)
    private String description;

    @Lob
    @Column(name = "images", columnDefinition="LONGBLOB")
    private byte[] image;

//    @Column(name = "house_owner", length = 255)
//    private String house_owner;

    @Column(name = "price")
    private double price;

    //images ********* baki
    //created_at ***** timestamp baki
    //updated_at ***** timestamp baki



    public properties() {
        // You can leave it empty or initialize some default values if needed
    }

    public properties(users seller_id, locations location_id,
                      coordinates coordinate_id, area area_id,
                      String title, int type,
                      String description, double price,
                      byte[] image) {
        this.user = seller_id;
        this.location = location_id;
        this.price = price;
        this.coordinate=coordinate_id;
        this._area=area_id;
        this.title = title;
        this.type = type;
        this.description = description;
        this.image = image;

    }

    private boolean isPNGImage(byte[] imageData) {
        return (imageData.length >= 8 &&
                imageData[0] == (byte) 0x89 &&
                imageData[1] == 'P' &&
                imageData[2] == 'N' &&
                imageData[3] == 'G' &&
                imageData[4] == (byte) 0x0D &&
                imageData[5] == (byte) 0x0A &&
                imageData[6] == (byte) 0x1A &&
                imageData[7] == (byte) 0x0A);
    }

    // Method to check if the byte array represents a JPEG image
    private boolean isJPEGImage(byte[] imageData) {
        return (imageData.length >= 3 &&
                imageData[0] == (byte) 0xFF &&
                imageData[1] == (byte) 0xD8 &&
                imageData[2] == (byte) 0xFF);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public users getUser() {
        return user;
    }

    public void setUser(users user) {
        this.user = user;
    }

    public locations getLocation() {
        return location;
    }

    public void setLocation(locations location) {
        this.location = location;
    }

    public coordinates getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(coordinates coordinate) {
        this.coordinate = coordinate;
    }

    public area getArea() {
        return _area;
    }

    public void setArea(area area) {
        this._area = area;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }




    // Getters and setters

//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//   }
//
//    public String getHouseOwner() {
//        return house_owner;
//    }
//
//    public void setHouseOwner(String house_owner) {
//        this.house_owner = house_owner;
//    }

//    public float getPrice() {
//        return price;
//    }
//
//    public void setPrice(float price) {
//        this.price = price;
//    }
//
//    public float getRopani() {
//        return ropani;
//    }
//
//    public void setRopani(float ropani) {
//        this.ropani = ropani;
//    }
//
//    public float getAana() {
//        return aana;
//    }
//
//    public void setAana(float aana) {
//        this.aana = aana;
//    }
//
//    public float getPaisa() {
//        return paisa;
//    }
//
//    public void setPaisa(float paisa) {
//        this.paisa = paisa;
//    }
//
//    public float getDaam() {
//        return daam;
//    }
//
//    public void setDaam(float daam) {
//        this.daam = daam;
//    }

    //This is only to see the values being hit by api.
//    @Override
//    public String toString() {
//        return "House{" +
//                "houseId=" + house_id +
//                ", location='" + location + '\'' +
//                ", houseOwner='" + house_owner + '\'' +
//                ", price ="+price+", ropani ="+ropani
//                +",aana ="+aana +", paisa = "+paisa
//                +", daam ="+ daam +
//                '}';
//    }


}
