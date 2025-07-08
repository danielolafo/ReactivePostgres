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
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Set;


@Entity
public class Customer {

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
    private Integer customerId;

    @Column(nullable = false, columnDefinition = "text")
    private String firstName;

    @Column(nullable = false, columnDefinition = "text")
    private String lastName;

    @Column(columnDefinition = "text")
    private String email;

    @Column(nullable = false)
    private Boolean activebool;

    @Column(nullable = false)
    private LocalDate createDate;

    @Column
    private OffsetDateTime lastUpdate;

    @Column
    private Integer active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @OneToMany(mappedBy = "customer")
    private Set<Rental> customerRentals;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(final Integer customerId) {
        this.customerId = customerId;
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

    public Boolean getActivebool() {
        return activebool;
    }

    public void setActivebool(final Boolean activebool) {
        this.activebool = activebool;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(final LocalDate createDate) {
        this.createDate = createDate;
    }

    public OffsetDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(final OffsetDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(final Integer active) {
        this.active = active;
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

    public Set<Rental> getCustomerRentals() {
        return customerRentals;
    }

    public void setCustomerRentals(final Set<Rental> customerRentals) {
        this.customerRentals = customerRentals;
    }

}
