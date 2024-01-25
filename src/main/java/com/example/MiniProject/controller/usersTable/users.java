package com.example.MiniProject.controller.usersTable;


import com.example.MiniProject.controller.RolesTable.RoleDTO;
import com.example.MiniProject.controller.RolesTable.roles;
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

    //FOREGIGNGNGN KEY implemented finally
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private roles role;

    @Column(name = "phone")
    private Long phone;

    @Column(name = "name", length = 15)
    private String name;

    //if property is 0 - > land, 1->house , 2->both
    @Column(name = "password", length =20)
    private String password;

    //This unique doesnt seem to be setting
    //uniqueness. Prolly dmbs has no unique attribute.
    @Column(name = "email", length = 100, unique = true)
    private String email;

    //Don't think address of individuals is necessary


    public users() {
        // You can leave it empty or initialize some default values if needed
    }

    public users(roles role_id, Long phone,
                 String name, String password,
                 String email) {
        this.role = role_id;
        this.phone = phone;
        this.name = name;
        this.password=password;
        this.email=email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public roles getRole() {
        return role;
    }

    public void setRole(roles role) {
        this.role = role;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
