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
import java.time.OffsetDateTime;
import java.util.Set;


@Entity
public class City {

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
    private Integer cityId;

    @Column(nullable = false, columnDefinition = "text")
    private String city;

    @Column(nullable = false)
    private OffsetDateTime lastUpdate;

    @OneToMany(mappedBy = "city")
    private Set<Address> cityAddresses;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(final Integer cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public OffsetDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(final OffsetDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<Address> getCityAddresses() {
        return cityAddresses;
    }

    public void setCityAddresses(final Set<Address> cityAddresses) {
        this.cityAddresses = cityAddresses;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(final Country country) {
        this.country = country;
    }

}
