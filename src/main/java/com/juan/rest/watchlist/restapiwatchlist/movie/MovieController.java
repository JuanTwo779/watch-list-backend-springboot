package com.juan.rest.watchlist.restapiwatchlist.movie;

import com.juan.rest.watchlist.restapiwatchlist.award.AwardsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MovieController {

    private MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    //get the movies list
    @GetMapping("/users/{username}/movie-list")
    public List<Movie> retrieveMovies(@PathVariable String username){
        return movieRepository.findByUsername(username);
    }

    //get details of individual movie
    @GetMapping("/users/{username}/movie-list/{id}")
    public Movie retriveMovie(@PathVariable int id){
        return movieRepository.findById(id).get();
    }

    //remove a movie from the list
    @DeleteMapping("/users/{username}/movie-list/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable int id){
        movieRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //edit details of movie object
    @PutMapping("/users/{username}/movie-list/{id}")
    public Movie updateMovie(@PathVariable String username,
                             @PathVariable int id, @RequestBody Movie movie){
        movieRepository.save(movie);
        return movie;
    }

    //create movie object/add to the list
    @PostMapping("/users/{username}/movie-list")
    public Movie createMovie(@PathVariable String username,
                             @RequestBody Movie movie){
        movie.setUsername(username);
        movie.setId(null);
        movie.setWatched(false);
        movieRepository.save(movie);
        return movie;
    }

    //get a random movie
    @GetMapping("/users/{username}/random-movie")
    public Movie retrieveRandomMovie(@PathVariable String username){
        return movieRepository.findRandomMovie(username);
    }

}
