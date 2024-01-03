package com.juan.rest.watchlist.restapiwatchlist.movie;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.juan.rest.watchlist.restapiwatchlist.award.Award;
import jakarta.persistence.*;

import java.time.Year;
import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Integer id;
    private String username;

    private String title;
    private Year year;
    private String director;
    private String country;
    private Integer rating;
    private Boolean watched;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.REMOVE)
    private List<Award> awards;

    public Movie(){}

    public Movie(Integer id, String username, String title, Year year, String director, Integer rating, String country, Boolean watched) {
        super();
        this.id = id;
        this.username = username;
        this.title = title;
        this.year = year;
        this.director = director;
        this.country = country;
        this.rating = rating;
        this.watched = watched;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean getWatched() {
        return watched;
    }

    public void setWatched(Boolean watched) {
        this.watched = watched;
    }

    public List<Award> getAwards() {
        return awards;
    }

    public void setAwards(List<Award> awards) {
        this.awards = awards;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", director='" + director + '\'' +
                ", country='" + country + '\'' +
                ", rating=" + rating +
                ", watched=" + watched +
                ", awards=" + awards +
                '}';
    }
}
