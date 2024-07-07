package com.event.booking.system.project.entity.movies;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "role")
public class Roles {

    @Column(name = "name")
    private String roleName;

    public Roles(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



    public Roles(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


}
