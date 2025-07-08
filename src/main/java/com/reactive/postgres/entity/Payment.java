package com.reactive.postgres.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import java.math.BigDecimal;
import java.time.OffsetDateTime;


@Entity
public class Payment {

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
    private Integer paymentId;

    @Column(nullable = false)
    private Integer customerId;

    @Column(nullable = false)
    private Integer staffId;

    @Column(nullable = false)
    private Integer rentalId;

    @Column(nullable = false, precision = 7, scale = 2)
    private BigDecimal amount;

    @Column(nullable = false)
    private OffsetDateTime paymentDate;

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(final Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(final Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(final Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getRentalId() {
        return rentalId;
    }

    public void setRentalId(final Integer rentalId) {
        this.rentalId = rentalId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(final BigDecimal amount) {
        this.amount = amount;
    }

    public OffsetDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(final OffsetDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

}
