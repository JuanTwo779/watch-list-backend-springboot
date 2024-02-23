package com.juan.rest.watchlist.restapiwatchlist.tmdbAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
            // Return the search result as a ResponseEntity with status code 200 (OK)
            return ResponseEntity.ok(searchResult);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error occurred: " + e.getMessage());
        }
    }
}
