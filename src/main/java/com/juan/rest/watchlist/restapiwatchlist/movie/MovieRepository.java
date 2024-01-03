package com.juan.rest.watchlist.restapiwatchlist.movie;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Random;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findByUsername(String username);

    default Movie findRandomMovie(String username){
        List<Movie> list = findByUsername(username);

        Random rng = new Random();
        int randomMovie = rng.nextInt(list.size());

        return list.get(randomMovie);
    }
}
