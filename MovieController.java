package src.main.java.com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import src.main.java.com.example.demo.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public Page<MovieDTO> getAllMovies(
            @RequestParam(defaultValue = "0") int page
    ) {
        return movieService.getAllMovies(page);
    }


    @GetMapping("/{imdbId}")
    public ResponseEntity<?> getMovieDetails(@PathVariable String imdbId) {
        return movieService.getMovieById(imdbId)
                .map(movie -> {
                    movie.setBudgetFormatted("$" + String.format("%,d", movie.getBudget())); // Custom getter optional
                    return ResponseEntity.ok(movie);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/year/{year}")
    public Page<MovieDTO> getMoviesByYear(
            @PathVariable int year,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "asc") String sort
    ) {
        return movieService.getMoviesByYear(year, page, sort);
    }

    @GetMapping("/genre/{genre}")
    public Page<MovieDTO> getMoviesByGenre(
            @PathVariable String genre,
            @RequestParam(defaultValue = "0") int page
    ) {
        return movieService.getMoviesByGenre(genre, page);
    }
}
