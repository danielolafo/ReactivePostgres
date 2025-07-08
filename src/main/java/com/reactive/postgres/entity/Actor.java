package com.reactive.postgres.entity;

import java.time.OffsetDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Actor {

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
    private Integer actorId;

    @Column(nullable = false, columnDefinition = "text")
    private String firstName;

    @Column(nullable = false, columnDefinition = "text")
    private String lastName;

    @Column(nullable = false)
    private OffsetDateTime lastUpdate;

    @OneToMany(mappedBy = "actor")
    private Set<FilmActor> actorFilmActors;

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(final Integer actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public OffsetDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(final OffsetDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<FilmActor> getActorFilmActors() {
        return actorFilmActors;
    }

    public void setActorFilmActors(final Set<FilmActor> actorFilmActors) {
        this.actorFilmActors = actorFilmActors;
    }

}
