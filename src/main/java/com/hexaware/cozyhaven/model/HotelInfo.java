package com.hexaware.cozyhaven.model;

import jakarta.persistence.*;

@Entity
@Table(name = "hotelinfo")
public class HotelInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "infoid")
    private int infoid;

    @ManyToOne
    @JoinColumn(name = "hotelid")
    private Hotel hotel;

    @Column(name = "roomtype")
    private String roomtype;

    @Column(name = "noofrooms")
    private int noofrooms;

    @Column(name = "availablerooms")
    private int availablerooms;

    @Column(name = "rent")
    private double rent;

    @Column(name = "roomsize")
    private String roomsize;

    @Column(name = "bedtype")
    private String bedtype;

	public int getInfoid() {
		return infoid;
	}

	public void setInfoid(int infoid) {
		this.infoid = infoid;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public int getNoofrooms() {
		return noofrooms;
	}

	public void setNoofrooms(int noofrooms) {
		this.noofrooms = noofrooms;
	}

	public int getAvailablerooms() {
		return availablerooms;
	}

	public void setAvailablerooms(int availablerooms) {
		this.availablerooms = availablerooms;
	}

	public double getRent() {
		return rent;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}

	public String getRoomsize() {
		return roomsize;
	}

	public void setRoomsize(String roomsize) {
		this.roomsize = roomsize;
	}

	public String getBedtype() {
		return bedtype;
	}

	public void setBedtype(String bedtype) {
		this.bedtype = bedtype;
	}

	public HotelInfo(int infoid, Hotel hotel, String roomtype, int noofrooms, int availablerooms, double rent,
			String roomsize, String bedtype) {
		super();
		this.infoid = infoid;
		this.hotel = hotel;
		this.roomtype = roomtype;
		this.noofrooms = noofrooms;
		this.availablerooms = availablerooms;
		this.rent = rent;
		this.roomsize = roomsize;
		this.bedtype = bedtype;
	}

	public HotelInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
