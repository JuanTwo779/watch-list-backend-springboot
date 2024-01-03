package com.juan.rest.watchlist.restapiwatchlist.award;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.juan.rest.watchlist.restapiwatchlist.movie.Movie;
import jakarta.persistence.*;

import java.time.Year;

@Entity
public class Award {

    @Id
    @GeneratedValue
    private Integer awardId;

    private Year year;
    private String organisation;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Movie movie;

    public Award(){}

    public Award(Integer awardId, Year year, String organisation, String description, Movie movie) {
        this.awardId = awardId;
        this.year = year;
        this.organisation = organisation;
        this.description = description;
        this.movie = movie;
    }

    public Integer getAwardId() {
        return awardId;
    }

    public void setAwardId(Integer awardId) {
        this.awardId = awardId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }


}
