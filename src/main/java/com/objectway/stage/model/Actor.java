package com.objectway.stage.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ACTOR")
@NamedQueries({
        @NamedQuery(name = Actor.FIND_ALL, query = "SELECT a FROM Actor a order by a.name "),
})
public class Actor {

    public static final String FIND_ALL = "com.objectway.stage.crud.Actor.find_all";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @Column(name = "WAGE")
    private Long wage;

    @ManyToMany(mappedBy = "actors")
    private Set<Movie> movies;


    public Actor() {
    }

    public Actor(String name, Date birthDate, Long wage) {
        this.name = name;
        this.birthDate = birthDate;
        this.wage = wage;
        movies = new HashSet<Movie>();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Long getWage() {
        return wage;
    }

    public void setWage(Long wage) {
        this.wage = wage;
    }

    public Actor id(Long id) {
        this.id = id;
        return this;
    }

    public Actor name(String name) {
        this.name = name;
        return this;
    }

    public Actor birthDate(Date birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public Actor wage(Long wage) {
        this.wage = wage;
        return this;
    }

    public Actor movies(Set<Movie> movies) {
        this.movies = movies;
        return this;
    }
}
