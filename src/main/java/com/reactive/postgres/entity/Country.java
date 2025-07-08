package com.reactive.postgres.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import java.time.OffsetDateTime;
import java.util.Set;


@Entity
public class Country {

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
    private Integer countryId;

    @Column(nullable = false, columnDefinition = "text")
    private String country;

    @Column(nullable = false)
    private OffsetDateTime lastUpdate;

    @OneToMany(mappedBy = "country")
    private Set<City> countryCities;

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(final Integer countryId) {
        this.countryId = countryId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public OffsetDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(final OffsetDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<City> getCountryCities() {
        return countryCities;
    }

    public void setCountryCities(final Set<City> countryCities) {
        this.countryCities = countryCities;
    }

}
