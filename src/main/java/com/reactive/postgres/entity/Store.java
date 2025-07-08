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
public class Store {

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
    private Integer storeId;

    @Column(nullable = false)
    private Integer managerStaffId;

    @Column(nullable = false)
    private OffsetDateTime lastUpdate;

    @OneToMany(mappedBy = "store")
    private Set<Customer> storeCustomers;

    @OneToMany(mappedBy = "store")
    private Set<Inventory> storeInventories;

    @OneToMany(mappedBy = "store")
    private Set<Staff> storeStaffs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(final Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getManagerStaffId() {
        return managerStaffId;
    }

    public void setManagerStaffId(final Integer managerStaffId) {
        this.managerStaffId = managerStaffId;
    }

    public OffsetDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(final OffsetDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<Customer> getStoreCustomers() {
        return storeCustomers;
    }

    public void setStoreCustomers(final Set<Customer> storeCustomers) {
        this.storeCustomers = storeCustomers;
    }

    public Set<Inventory> getStoreInventories() {
        return storeInventories;
    }

    public void setStoreInventories(final Set<Inventory> storeInventories) {
        this.storeInventories = storeInventories;
    }

    public Set<Staff> getStoreStaffs() {
        return storeStaffs;
    }

    public void setStoreStaffs(final Set<Staff> storeStaffs) {
        this.storeStaffs = storeStaffs;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(final Address address) {
        this.address = address;
    }

}
