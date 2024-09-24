package com.hexaware.cozyhaven.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "refund")
public class Refund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "refundid")
    private int refundId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookingid", referencedColumnName = "bookingid")
    private Booking booking;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "custid", referencedColumnName = "customerid")
    private Customer customer;

    @Column(name = "refundamount")
    private int refundAmount;

    @Column(name = "canceldate", nullable = false)
    private LocalDate cancelDate;

    @Column(name = "refunddate", nullable = false)
    private LocalDate refundDate;

    // Default constructor
    public Refund() {
    }

    // Constructor with fields
    public Refund(Booking booking, Customer customer, int refundAmount, LocalDate cancelDate, LocalDate refundDate) {
        this.booking = booking;
        this.customer = customer;
        this.refundAmount = refundAmount;
        this.cancelDate = cancelDate;
        this.refundDate = refundDate;
    }

    // Getters and Setters
    public int getRefundId() {
        return refundId;
    }

    public void setRefundId(int refundId) {
        this.refundId = refundId;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(int refundAmount) {
        this.refundAmount = refundAmount;
    }

    public LocalDate getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(LocalDate cancelDate) {
        this.cancelDate = cancelDate;
    }

    public LocalDate getRefundDate() {
        return refundDate;
    }

    public void setRefundDate(LocalDate refundDate) {
        this.refundDate = refundDate;
    }
}

