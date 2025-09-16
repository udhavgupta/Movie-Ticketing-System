package org.example.controller;


import org.example.entity.Movie;
import org.example.reposistory.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/movies")
@CrossOrigin(origins = "*")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) String language) {

        List<Movie> movies;

        if (city != null) {
            movies = movieRepository.findMoviesByCity(city);
        } else if (genre != null) {
            movies = movieRepository.findByGenreIgnoreCase(genre);
        } else if (language != null) {
            movies = movieRepository.findByLanguageIgnoreCase(language);
        } else {
            movies = movieRepository.findAll();
        }

        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
        return movieRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
