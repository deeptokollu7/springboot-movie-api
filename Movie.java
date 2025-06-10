package src.main.java.com.example.demo.dto;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Movie {
    @Id
    private String imdbId;

    private String title;
    private String description;
    private Date releaseDate;
    private Long budget;
    private Integer runtime;
    private String originalLanguage;

    @ElementCollection
    private List<String> genres;

    @ElementCollection
    private List<String> productionCompanies;

    @Transient
    private Double averageRating; // populated from Ratings DB

    // Getters and Setters
}
    @Transient
    private String budgetFormatted;

    public String getBudgetFormatted() {
        return budgetFormatted;
    }

    public void setBudgetFormatted(String budgetFormatted) {
        this.budgetFormatted = budgetFormatted;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<String> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(List<String> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }
