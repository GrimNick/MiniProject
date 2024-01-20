package com.example.MiniProject.controller.houseTable;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Column;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.math.BigInteger;

import lombok.Data;
@Data bbbbbbbbbbbbb
@Entity
@Table(name = "House")
public class House {aaaaaa
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "house_id")
    private Long house_id;

    @Column(name = "location", length = 255)
    private String location;

    @Column(name = "house_owner", length = 255)
    private String house_owner;

    @Column(name = "price")
    private float price;

    @Column(name = "ropani")
    private float ropani;
    @Column(name = "aana")
    private float aana;

    @Column(name = "paisa")
    private float paisa;

    @Column(name = "daam")
    private float daam;


    public House() {
        // You can leave it empty or initialize some default values if needed
    }

    public House(String location, String houseOwner, float price, float ropani, float aana, float paisa,float daam) {
        this.location = location;
        this.house_owner = houseOwner;
        this.price = price;
        this.ropani=ropani;
        this.aana=aana;
        this.paisa = paisa;
        this.daam = daam;
    }




    // Getters and setters

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
   }

    public String getHouseOwner() {
        return house_owner;
    }

    public void setHouseOwner(String house_owner) {
        this.house_owner = house_owner;
    }

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
