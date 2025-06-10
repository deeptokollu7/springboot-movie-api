package src.main.java.com.example.demo.repository;

import com.example.demo.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, String> {
    Page<Movie> findByReleaseDateBetween(Date startDate, Date endDate, Pageable pageable);

    @Query("SELECT m FROM Movie m JOIN m.genres g WHERE g = :genre")
    Page<Movie> findByGenre(@Param("genre") String genre, Pageable pageable);
}
