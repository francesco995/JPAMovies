package com.objectway.stage.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "MOVIE")
@NamedQueries({
        @NamedQuery(name = Movie.FIND_ALL, query = "SELECT m FROM Movie m order by m.name "),
})
public class Movie implements Serializable {

    public static final String FIND_ALL = "com.objectway.stage.crud.Movie.find_all";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "YEAR")
    private Date year;

    @Column(name = "COST")
    private Long cost;

    @Column(name = "EARNINGS")
    private Long earnings;

    @ManyToMany
    private Set<Actor> actors;


    public Movie() {
    }

    public Movie(String name, Date year, Long cost, Long earnings) {
        this.name = name;
        this.year = year;
        this.cost = cost;
        this.earnings = earnings;
        actors = new HashSet<Actor>();
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
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

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Long getEarnings() {
        return earnings;
    }

    public void setEarnings(Long earnings) {
        this.earnings = earnings;
    }


    public Movie id(Long id) {
        this.id = id;
        return this;
    }

    public Movie name(String name) {
        this.name = name;
        return this;
    }

    public Movie year(Date year) {
        this.year = year;
        return this;
    }

    public Movie cost(Long cost) {
        this.cost = cost;
        return this;
    }

    public Movie earnings(Long earnings) {
        this.earnings = earnings;
        return this;
    }

    public Movie actors(Set<Actor> actors) {
        this.actors = actors;
        return this;
    }
}
