package com.reactive.postgres.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Set;


@Entity
public class Film {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Integer filmId;

    @Column(nullable = false, columnDefinition = "text")
    private String title;

    @Column(columnDefinition = "text")
    private String description;

    @Column
    private Integer releaseYear;

    @Column(nullable = false)
    private Integer rentalDuration;

    @Column(nullable = false, precision = 6, scale = 2)
    private BigDecimal rentalRate;

    @Column
    private Integer length;

    @Column(nullable = false, precision = 7, scale = 2)
    private BigDecimal replacementCost;

    @Column
    private String rating;

    @Column(nullable = false)
    private OffsetDateTime lastUpdate;

    @Column(columnDefinition = "text")
    private String specialFeatures;

    @Column(nullable = false)
    private String fulltext;

    @OneToMany(mappedBy = "film")
    private Set<FilmActor> filmFilmActors;

    @OneToMany(mappedBy = "film")
    private Set<FilmCategory> filmFilmCategories;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "original_language_id")
    private Language originalLanguage;

    @OneToMany(mappedBy = "film")
    private Set<Inventory> filmInventories;

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(final Integer filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(final Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(final Integer rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(final BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(final Integer length) {
        this.length = length;
    }

    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(final BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(final String rating) {
        this.rating = rating;
    }

    public OffsetDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(final OffsetDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(final String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public String getFulltext() {
        return fulltext;
    }

    public void setFulltext(final String fulltext) {
        this.fulltext = fulltext;
    }

    public Set<FilmActor> getFilmFilmActors() {
        return filmFilmActors;
    }

    public void setFilmFilmActors(final Set<FilmActor> filmFilmActors) {
        this.filmFilmActors = filmFilmActors;
    }

    public Set<FilmCategory> getFilmFilmCategories() {
        return filmFilmCategories;
    }

    public void setFilmFilmCategories(final Set<FilmCategory> filmFilmCategories) {
        this.filmFilmCategories = filmFilmCategories;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(final Language language) {
        this.language = language;
    }

    public Language getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(final Language originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public Set<Inventory> getFilmInventories() {
        return filmInventories;
    }

    public void setFilmInventories(final Set<Inventory> filmInventories) {
        this.filmInventories = filmInventories;
    }

}
