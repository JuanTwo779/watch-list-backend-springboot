package com.juan.rest.watchlist.restapiwatchlist.tmdbAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class TmdbApiController {
    private final TmdbApiService tmdbApiService;

    @Autowired
    public TmdbApiController(TmdbApiService tmdbApiService) {
        this.tmdbApiService = tmdbApiService;
    }

    @GetMapping("/movies/search")
    public ResponseEntity<String> searchMovies(
            @RequestParam String query,
            @RequestParam(required = false) String language,
            @RequestParam(required = false) String primaryReleaseYear,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) String region,
            @RequestParam(required = false) String year
    ) {
        try {
            String searchResult = tmdbApiService.searchMovies(query,language,primaryReleaseYear,page,region,year);
            return ResponseEntity.ok(searchResult);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error occurred: " + e.getMessage());
        }
    }

    //get movie credits
    @GetMapping("/movies/credits")
    public ResponseEntity<String> getMovieCredits(@RequestParam Integer movieId){
        try{
            String credits = tmdbApiService.getMovieCredits(movieId);
            return ResponseEntity.ok(credits);
        }catch (IOException e){
            return ResponseEntity.status(500).body("Error occurred: " + e.getMessage());
        }
    }

    //get movie details
    @GetMapping("/movies/details")
    public ResponseEntity<String> getMovieDetails(@RequestParam Integer movieId){
        try {
            String details = tmdbApiService.getMovieDetails(movieId);
            return  ResponseEntity.ok(details);
        } catch (IOException e){
            return ResponseEntity.status(500).body("Error occurred: " + e.getMessage());
        }
    }
}
