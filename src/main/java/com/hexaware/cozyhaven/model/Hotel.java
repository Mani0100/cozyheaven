package com.hexaware.cozyhaven.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotelid")
    private int hotelid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adminid")
    private Admin adminid; 
    
    @Column(name = "hotelname")
    private String hotelname;

    @Column(name = "hoteltype")
    private String hoteltype;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "email")
    private String email;

    @Column(name = "contactnumber")
    private long contactnumber;

    @Column(name = "facilities")
    private String facilities;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "address")
    private String address;

	public int getHotelid() {
		return hotelid;
	}

	public void setHotelid(int hotelid) {
		this.hotelid = hotelid;
	}

	public Admin getAdminid() {
		return adminid;
	}

	public void setAdminid(Admin adminid) {
		this.adminid = adminid;
	}

	public String getHotelname() {
		return hotelname;
	}

	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}

	public String getHoteltype() {
		return hoteltype;
	}

	public void setHoteltype(String hoteltype) {
		this.hoteltype = hoteltype;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getContactnumber() {
		return contactnumber;
	}

	public void setContactnumber(long contactnumber) {
		this.contactnumber = contactnumber;
	}

	public String getFacilities() {
		return facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Hotel(int hotelid, String hotelname, String hoteltype, String city, String state, String email,
			long contactnumber, String facilities, int capacity, String address) {
		super();
		this.hotelid = hotelid;
		this.hotelname = hotelname;
		this.hoteltype = hoteltype;
		this.city = city;
		this.state = state;
		this.email = email;
		this.contactnumber = contactnumber;
		this.facilities = facilities;
		this.capacity = capacity;
		this.address = address;
	}

	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}

    

}
