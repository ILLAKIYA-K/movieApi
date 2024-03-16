/*
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */

// Write your code here

package com.example.movie;

import com.example.movie.MovieService;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class MovieController {

    MovieService service = new MovieService();

    @PutMapping("/movies/{movieId}")
    public Movie putMovie(@PathVariable("movieId") int movieId, @RequestBody Movie re) {
        return service.putMovie(movieId, re);
    }

    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie rec) {
        return service.addMovie(rec);
    }

    @GetMapping("/movies")
    public ArrayList<Movie> getMovie() {
        return service.getMovie();
    }

    @GetMapping("/movies/{movieId}")
    public Movie getMoviebyId(@PathVariable("movieId") int movieId) {
        return service.getMoviebyId(movieId);
    }

    @DeleteMapping("movies/{movieId}")

    public void delMovie(@PathVariable("movieId") int movieId) {
        service.delMovie(movieId);
    }
}