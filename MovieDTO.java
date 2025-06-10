package src.main.java.com.example.demo.dto;

import java.util.Date;
import java.util.List;
import java.text.NumberFormat;
import java.util.Locale;

public class MovieDTO {
    private String imdbId;
    private String title;
    private List<String> genres;
    private Date releaseDate;
    private Long budget;

    public MovieDTO(String imdbId, String title, List<String> genres, Date releaseDate, Long budget) {
        this.imdbId = imdbId;
        this.title = title;
        this.genres = genres;
        this.releaseDate = releaseDate;
        this.budget = budget;
    }

    // Getters and setters

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public String getBudgetFormatted() {
        if (budget == null) return null;
        return NumberFormat.getCurrencyInstance(Locale.US).format(budget);
    }
}
