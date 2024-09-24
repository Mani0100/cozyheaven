package com.hexaware.cozyhaven.model;

import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookingid")
    private int bookingid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerid")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "infoid")
    private HotelInfo hotelinfo;

    @Column(name = "bookingstartdate")
    private LocalDate bookingstartdate;

    @Column(name = "bookingenddate")
    private LocalDate bookingenddate;

    @Column(name = "advanceamount")
    private double advanceamount;

    @Column(name = "bookingdate")
    private LocalDate bookingdate;

    @Column(name = "comments")
    private String comments;

    @Column(name = "noofrooms")
    private int noofrooms;

    @Column(name = "noofadults")
    private int noofadults;

    @Column(name = "noofchildren")
    private int noofchildren;
    
    @Column(name= "status")
    private String status;
    
    @Column(name = "roomtype")
    private String roomtype;

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public String getBedtype() {
		return bedtype;
	}

	public void setBedtype(String bedtype) {
		this.bedtype = bedtype;
	}

	@Column(name = "bedtype")
    private String bedtype;


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public HotelInfo getHotelinfo() {
		return hotelinfo;
	}

	public void setHotelinfo(HotelInfo hotelinfo) {
		this.hotelinfo = hotelinfo;
	}

	public LocalDate getBookingstartdate() {
		return bookingstartdate;
	}

	public void setBookingstartdate(LocalDate bookingstartdate) {
		this.bookingstartdate = bookingstartdate;
	}

	public LocalDate getBookingenddate() {
		return bookingenddate;
	}

	public void setBookingenddate(LocalDate bookingenddate) {
		this.bookingenddate = bookingenddate;
	}

	public double getAdvanceamount() {
		return advanceamount;
	}

	public void setAdvanceamount(double advanceamount) {
		this.advanceamount = advanceamount;
	}

	public LocalDate getBookingdate() {
		return bookingdate;
	}

	public void setBookingdate(LocalDate bookingdate) {
		this.bookingdate = bookingdate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getNoofrooms() {
		return noofrooms;
	}

	public void setNoofrooms(int noofrooms) {
		this.noofrooms = noofrooms;
	}

	public int getNoofadults() {
		return noofadults;
	}

	public void setNoofadults(int noofadults) {
		this.noofadults = noofadults;
	}

	public int getNoofchildren() {
		return noofchildren;
	}

	public void setNoofchildren(int noofchildren) {
		this.noofchildren = noofchildren;
	}

	public Booking(int bookingid, Customer customer, HotelInfo hotelinfo, LocalDate bookingstartdate,
			LocalDate bookingenddate, double advanceamount, LocalDate bookingdate, String comments, int noofrooms,
			int noofadults, int noofchildren, String status, String roomtype, String bedtype) {
		super();
		this.bookingid = bookingid;
		this.customer = customer;
		this.hotelinfo = hotelinfo;
		this.bookingstartdate = bookingstartdate;
		this.bookingenddate = bookingenddate;
		this.advanceamount = advanceamount;
		this.bookingdate = bookingdate;
		this.comments = comments;
		this.noofrooms = noofrooms;
		this.noofadults = noofadults;
		this.noofchildren = noofchildren;
		this.status = status;
		this.roomtype = roomtype;
		this.bedtype = bedtype;
	}

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
