package src.main.java.com.example.demo.service;

import com.example.demo.model.Movie;
import src.main.java.com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    // Simulated Rating DB fetch
    private double fetchRatingForMovie(String imdbId) {
        // Normally you'd call another DB or service
        return Math.random() * 5 + 5; // mock rating between 5-10
    }

    public Page<MovieDTO> getAllMovies(int page) {
        Pageable pageable = PageRequest.of(page, 50, Sort.by("releaseDate").ascending());

        Page<Movie> movies = movieRepository.findAll(pageable);

        return movies.map(movie -> new MovieDTO(
                movie.getImdbId(),
                movie.getTitle(),
                movie.getGenres(),
                movie.getReleaseDate(),
                movie.getBudget()
        ));
    }

    public Optional<Movie> getMovieById(String imdbId) {
        Optional<Movie> movieOpt = movieRepository.findById(imdbId);
        movieOpt.ifPresent(movie -> movie.setAverageRating(fetchRatingForMovie(imdbId)));
        return movieOpt;
    }

    public Page<MovieDTO> getMoviesByYear(int year, int page, String sortOrder) {
        Calendar cal = Calendar.getInstance();

        cal.set(year, Calendar.JANUARY, 1);
        Date startDate = cal.getTime();

        cal.set(year, Calendar.DECEMBER, 31);
        Date endDate = cal.getTime();

        Sort.Direction direction = sortOrder.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, 50, Sort.by(direction, "releaseDate"));

        Page<Movie> movies = movieRepository.findByReleaseDateBetween(startDate, endDate, pageable);

        return movies.map(movie -> new MovieDTO(
                movie.getImdbId(),
                movie.getTitle(),
                movie.getGenres(),
                movie.getReleaseDate(),
                movie.getBudget()
        ));
    }

    public Page<MovieDTO> getMoviesByGenre(String genre, int page) {
        Pageable pageable = PageRequest.of(page, 50, Sort.by("releaseDate").ascending());

        Page<Movie> movies = movieRepository.findByGenre(genre, pageable);

        return movies.map(movie -> new MovieDTO(
                movie.getImdbId(),
                movie.getTitle(),
                movie.getGenres(),
                movie.getReleaseDate(),
                movie.getBudget()
        ));
    }
}

