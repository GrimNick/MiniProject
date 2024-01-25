package com.example.MiniProject.controller.propertyTable;


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


    @Column(name = "seller_id")
    private int seller_id;

    @Column(name = "location_id")
    private int location_id;

    @Column(name = "coordinate_id")
    private int coordinate_id;

    @Column(name = "area_id")
    private int area_id;

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
    private float price;

    //images ********* baki
    //created_at ***** timestamp baki
    //updated_at ***** timestamp baki



    public properties() {
        // You can leave it empty or initialize some default values if needed
    }

    public properties(int seller_id, int location_id,
                      int coordinate_id, int area_id,
                      String title, int type,
                      String description, float price,
                      byte[] image) {
        this.seller_id = seller_id;
        this.location_id = location_id;
        this.price = price;
        this.coordinate_id=coordinate_id;
        this.area_id=area_id;
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
