package com.hexaware.cozyhaven.dto;

public class RoomAvailabilityDTO {
    private String roomType;
    private int availableRooms;
    
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public int getAvailableRooms() {
		return availableRooms;
	}
	public void setAvailableRooms(int availableRooms) {
		this.availableRooms = availableRooms;
	}
	public RoomAvailabilityDTO(String roomType, int availableRooms) {
		super();
		this.roomType = roomType;
		this.availableRooms = availableRooms;
	}
	public RoomAvailabilityDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
