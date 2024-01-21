package com.example.MiniProject.controller.usersTable;


import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "users")
public class users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "role_id")
    private int role_id;

    @Column(name = "phone")
    private Long phone;

    @Column(name = "name", length = 15)
    private String name;

    //if property is 0 - > land, 1->house , 2->both
    @Column(name = "password", length =20)
    private String password;

    //This unique doesnt seem to be setting
    //uniqueness. Prolly dmbs has no unique attribute.
    @Column(name = "email", length = 20, unique = true)
    private String email;

    //Don't think address of individuals is necessary


    public users() {
        // You can leave it empty or initialize some default values if needed
    }

    public users(int role_id, Long phone,
                 String name, String password,
                 String email) {
        this.role_id = role_id;
        this.phone = phone;
        this.name = name;
        this.password=password;
        this.email=email;
    }

}
