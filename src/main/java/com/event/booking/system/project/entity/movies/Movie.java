package com.event.booking.system.project.entity.movies;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "movie")
public class Movie {
    public Movie(String name, String desc, List<Celebrity> actorList, List<Celebrity> directorList,
                 List<Genre> genreList, List<Feature> featureList, List<MovieAudio> audioAvailable) {
        this.name = name;
        this.description = desc;
        this.actorList = actorList;
        this.directorList = directorList;
        this.genreList = genreList;
        this.featureList = featureList;
        this.audioAvailable = audioAvailable;
    }

    public Movie(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "movie")
    private List<Show>shwList;

    public List<Show> getShwList() {
        return shwList;
    }

    public void setShwList(List<Show> shwList) {
        this.shwList = shwList;
    }

    @ManyToMany
    @JoinTable(
            name = "movie_actors",
            joinColumns = @JoinColumn(name = "movie"),
            inverseJoinColumns = @JoinColumn(name = "actor")
    )
    private List<Celebrity> actorList;

    @ManyToMany
    @JoinTable(
            name = "movie_directors",
            joinColumns = @JoinColumn(name = "movie"),
            inverseJoinColumns = @JoinColumn(name = "director")
    )
    private List<Celebrity> directorList;

    @ElementCollection(targetClass = Genre.class)
    @CollectionTable(name = "movie_genre",joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "genre")
    private List<Genre>genreList;

    @ElementCollection(targetClass = Feature.class)
    @CollectionTable(name = "movie_features",joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "feature")
    private List<Feature> featureList;

    @ElementCollection(targetClass = MovieAudio.class)
    @CollectionTable(name = "movie_audios",joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "audio")
    private List<MovieAudio> audioAvailable;

    public List<Celebrity> getDirectorList() {
        return directorList;
    }

    public void setDirectorList(List<Celebrity> directorList) {
        this.directorList = directorList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Celebrity> getActorList() {
        return actorList;
    }

    public void setActorList(List<Celebrity> actorList) {
        this.actorList = actorList;
    }

    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }

    public List<Feature> getFeatureList() {
        return featureList;
    }

    public void setFeatureList(List<Feature> featureList) {
        this.featureList = featureList;
    }

    public List<MovieAudio> getAudioAvailable() {
        return audioAvailable;
    }

    public void setAudioAvailable(List<MovieAudio> audioAvailable) {
        this.audioAvailable = audioAvailable;
    }
}
