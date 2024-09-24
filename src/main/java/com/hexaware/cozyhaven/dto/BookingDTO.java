package com.hexaware.cozyhaven.dto;

import java.time.LocalDate;

public class BookingDTO {
    private int bookingid;
//    private int customerid;
//    private int hotelid;
    private LocalDate bookingstartdate;
    private LocalDate bookingenddate;
    private double advanceamount;
    private LocalDate bookingdate;
    private String comments;
    private String roomtype;
    private String bedtype;
    private int noofrooms;
    private int noofadults;
    private int noofchildren;
    private String status;

  
    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

//    public int getCustomerid() {
//        return customerid;
//    }
//
//    public void setCustomerid(int customerid) {
//        this.customerid = customerid;
//    }
//
//    public int getHotelid() {
//        return hotelid;
//    }
//
//    public void setHotelid(int hotelid) {
//        this.hotelid = hotelid;
//    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
