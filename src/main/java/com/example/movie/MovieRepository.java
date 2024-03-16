// Write your code here

package com.example.movie;

import java.util.*;

public interface MovieRepository {
    ArrayList<Movie> getMovie();

    Movie addMovie(Movie rec);

    Movie getMoviebyId(int movieId);

    Movie putMovie(int movieId, Movie re);

    void delMovie(int movieId);

}