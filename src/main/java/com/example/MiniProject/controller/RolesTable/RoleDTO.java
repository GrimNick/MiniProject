package com.example.MiniProject.controller.RolesTable;

public class RoleDTO {
    private Long id;
    private String roleName;
    public RoleDTO() {
    }

    public RoleDTO(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return roleName;
    }

    public void setName(String roleName) {
        this.roleName = roleName;
    }

}
