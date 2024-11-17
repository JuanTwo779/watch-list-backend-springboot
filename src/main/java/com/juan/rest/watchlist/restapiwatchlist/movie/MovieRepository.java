package com.juan.rest.watchlist.restapiwatchlist.movie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Random;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Logger logger = LoggerFactory.getLogger(MovieRepository.class);
    List<Movie> findByUsername(String username);
    List<Movie> findByUsernameAndWatchedFalse(String username);

    default Movie findRandomMovie(String username){
        List<Movie> list = findByUsernameAndWatchedFalse(username);

        //Log the list of movies
//        logger.debug("Unwatched movies for {}: {}", username, list);
        Random rng = new Random();
        int randomMovie = rng.nextInt(list.size());

        return list.get(randomMovie);
    }
}
