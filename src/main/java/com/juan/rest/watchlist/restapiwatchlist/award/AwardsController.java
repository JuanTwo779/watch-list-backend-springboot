package com.juan.rest.watchlist.restapiwatchlist.award;

import com.juan.rest.watchlist.restapiwatchlist.movie.Movie;
import com.juan.rest.watchlist.restapiwatchlist.movie.MovieRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class AwardsController {

    private AwardsRepository awardsRepository;
    private MovieRepository movieRepository;

    public AwardsController(AwardsRepository awardsRepository, MovieRepository movieRepository) {
        this.awardsRepository = awardsRepository;
        this.movieRepository = movieRepository;
    }

    //get list of awards linked to the movie
    @GetMapping ("/users/{username}/movie-list/{id}/awards")
    public List<Award> getAwardList(@PathVariable int id){
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isEmpty()){throw new RuntimeException();}

        return movie.get().getAwards();
    }

    //create award
    @PostMapping("/users/{username}/movie-list/{id}/awards")
    public ResponseEntity<Object> createAwardForMovie(@PathVariable int id,
                                                      @Valid @RequestBody Award award){
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isEmpty()){throw new RuntimeException();}

        award.setMovie(movie.get());
        Award awardObj = awardsRepository.save(award);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(awardObj.getAwardId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    //get award
    @GetMapping ("/users/{username}/movie-list/{id}/awards/{awardId}")
    public Award getAward(@PathVariable int awardId){
        Optional<Award> award = awardsRepository.findById(awardId);
        if (award.isEmpty()){throw new RuntimeException();}

        return award.get();
    }

    //delete award
    @DeleteMapping("/users/{username}/movie-list/{id}/awards/{awardId}")
    public ResponseEntity<Void> deleteAward(@PathVariable int awardId){
        Optional<Award> award = awardsRepository.findById(awardId);
        if (award.isEmpty()){throw new RuntimeException();}

        awardsRepository.deleteById(awardId);
        return ResponseEntity.noContent().build();
    }

    //edit award
    @PutMapping("/users/{username}/movie-list/{id}/awards/{awardId}")
    public Award updateAward(@PathVariable int id, @PathVariable int awardId, @RequestBody Award award){
        Optional<Award> awardObj = awardsRepository.findById(awardId);
        if (awardObj.isEmpty()){throw new RuntimeException();}

        Optional<Movie> movieObj = movieRepository.findById(id);
        if (movieObj.isEmpty()){throw new RuntimeException();}

        award.setMovie(movieRepository.findById(id).get());
        awardsRepository.save(award);
        return award;
    }

}
