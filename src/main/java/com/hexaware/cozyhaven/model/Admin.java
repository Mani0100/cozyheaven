package com.hexaware.cozyhaven.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin {

	@Id
	@Column(name = "adminid")
	private int adminid;
	
	@Column(name = "adminname")
	private String adminname;
	
	@Column(name="city")
	private String city;
	
	@Column(name="email")
	private String email;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="mobile")
	private long mobile;
	public int getAdminid() {
		return adminid;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public Admin(int adminid, String adminname, String city, String email, String username, String password,
			long mobile) {
		super();
		this.adminid = adminid;
		this.adminname = adminname;
		this.city = city;
		this.email = email;
		this.username = username;
		this.password = password;
		this.mobile = mobile;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
