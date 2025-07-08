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
public class Staff {

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
    private Integer staffId;

    @Column(nullable = false, columnDefinition = "text")
    private String firstName;

    @Column(nullable = false, columnDefinition = "text")
    private String lastName;

    @Column(columnDefinition = "text")
    private String email;

    @Column(nullable = false)
    private Boolean active;

    @Column(nullable = false, columnDefinition = "text")
    private String username;

    @Column(columnDefinition = "text")
    private String password;

    @Column(nullable = false)
    private OffsetDateTime lastUpdate;

    @Column(columnDefinition = "text")
    private String picture;

    @OneToMany(mappedBy = "staff")
    private Set<Rental> staffRentals;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(final Integer staffId) {
        this.staffId = staffId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(final Boolean active) {
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public OffsetDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(final OffsetDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(final String picture) {
        this.picture = picture;
    }

    public Set<Rental> getStaffRentals() {
        return staffRentals;
    }

    public void setStaffRentals(final Set<Rental> staffRentals) {
        this.staffRentals = staffRentals;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(final Address address) {
        this.address = address;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(final Store store) {
        this.store = store;
    }

}
