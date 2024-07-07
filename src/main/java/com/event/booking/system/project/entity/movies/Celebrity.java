package com.event.booking.system.project.entity.movies;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "celebrities")
public class Celebrity {

    public Celebrity(String firstName, String lastName, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.id=0;
    }

    public Celebrity(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


    private String description;

    @ManyToMany(mappedBy = "actorList")
    private List<Movie> listMovies;

//    @ManyToMany(mappedBy = "directorList")
//    private List<Movie> directedMovie;

    public List<Movie> getListMovies() {
        return listMovies;
    }

    public void setListMovies(List<Movie> listMovies) {
        this.listMovies = listMovies;
    }

//    public List<Movie> getDirectedMovie() {
//        return directedMovie;
//    }

//    public void setDirectedMovie(List<Movie> directedMovie) {
//        this.directedMovie = directedMovie;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
