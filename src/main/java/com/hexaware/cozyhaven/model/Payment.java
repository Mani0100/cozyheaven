package com.hexaware.cozyhaven.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentid")
    private int paymentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookingid", referencedColumnName = "bookingid")
    private Booking booking;

    @Column(name = "billamount")
    private double billAmount;

    @Column(name = "advanceamount")
    private double advanceAmount;

    @Column(name = "noofdays")
    private int noOfDays;

    @Column(name = "balanceamount")
    private double balanceAmount;

    @Column(name = "paymentdate")
    private LocalDate paymentDate;

    @Column(name = "comments")
    private String comments;

    // Default constructor
    public Payment() {
    }

    // Constructor with fields
    public Payment(Booking booking, double billAmount, double advanceAmount, int noOfDays, double balanceAmount, LocalDate paymentDate, String comments) {
        this.booking = booking;
        this.billAmount = billAmount;
        this.advanceAmount = advanceAmount;
        this.noOfDays = noOfDays;
        this.balanceAmount = balanceAmount;
        this.paymentDate = paymentDate;
        this.comments = comments;
    }

    // Getters and Setters
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public double getAdvanceAmount() {
        return advanceAmount;
    }

    public void setAdvanceAmount(double advanceAmount) {
        this.advanceAmount = advanceAmount;
    }

    public int getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }

    public double getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}

