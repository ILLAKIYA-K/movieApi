/*
 * You can use the following import statements
 * 
 * import org.springframework.web.server.ResponseStatusException;
 * import org.springframework.http.HttpStatus;
 * 
 */

package com.example.movie;

import com.example.movie.Movie;
import com.example.movie.MovieRepository;

import java.util.*;

// Do not modify the below code

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

public class MovieService implements MovieRepository {

        private static HashMap<Integer, Movie> movieList = new HashMap<>();
        int uniqueId = 6;
        public MovieService() {
                movieList.put(1, new Movie(1, "Avengers: Endgame", "Robert Downey Jr."));
                movieList.put(2, new Movie(2, "Avatar", "Sam Worthington"));
                movieList.put(3, new Movie(3, "Titanic", "Leonardo DiCaprio"));
                movieList.put(4, new Movie(4, "Star Wars: The Force Awakens", "Daisy Ridley"));
                movieList.put(5, new Movie(5, "Jurassic World", "Chris Pratt"));
        }

        // Do not modify the above code

        // Write your code here
        @Override
        public void delMovie(int movieId) {
                Movie d = movieList.get(movieId);
                if (d == null) {
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                } else {
                        movieList.remove(movieId);
                        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
                }

        }

        @Override
        public Movie putMovie(int movieId, Movie re) {
                Movie s = movieList.get(movieId);
                if (s == null) {
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }

                if (re.getMovieName() != null) {
                        s.setMovieName(re.getMovieName());

                }

                if (re.getLeadActor() != null) {
                        s.setLeadActor(re.getLeadActor());

                }

                return s;
        }

        @Override

        public Movie getMoviebyId(int movieId) {
                Movie s = movieList.get(movieId);
                if (s == null) {
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
                return s;
        }

        @Override
        public Movie addMovie(Movie rec) {
                rec.setMovieId(uniqueId);
                movieList.put(uniqueId, rec);
                uniqueId += 1;
                return rec;
        }

        @Override
        public ArrayList<Movie> getMovie() {
                Collection<Movie> movieCollection = movieList.values();
                ArrayList<Movie> arr = new ArrayList<>(movieCollection);
                return arr;
        }

}
