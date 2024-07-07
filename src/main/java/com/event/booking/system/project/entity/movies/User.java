package com.event.booking.system.project.entity.movies;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User{

    public User(String firstName, String lastName, City city, String email, String phoneNo,String userName,String pwd) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.userName=userName;
        this.pwd=pwd;
        this.email = email;

        this.phoneNo = phoneNo;
        this.rolesList = new ArrayList<>();
        this.id=0;
    }

    public User(String firstName, String lastName, String email, String phoneNo,String userName,String pwd) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.userName=userName;
        this.pwd=pwd;
        this.email = email;

        this.phoneNo = phoneNo;
        this.rolesList = new ArrayList<>();
        this.id=0;
    }

    public User(){

    }

    public List<Roles> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Roles> rolesList) {
        this.rolesList = rolesList;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user"),
            inverseJoinColumns = @JoinColumn(name = "role")
            )
    private List<Roles> rolesList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NotBlank
    @NotEmpty
    @Column(name="first_name")
    private String firstName;

    @NotNull
    @NotBlank
    @NotEmpty
    @Column(name="last_name")
    private String lastName;

    @NotNull
    @NotBlank
    @NotEmpty
    @Column(name="user_name")
    private String userName;


    private String pwd;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;



    @Email
    private String email;

    @Column(name="phone_no")
    private String phoneNo;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
