package com.example.demo.User;

import java.util.List;

public class BookingRequest {

    private String username;
    private List<Integer> seats;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<Integer> getSeats() {
		return seats;
	}
	public void setSeats(List<Integer> seats) {
		this.seats = seats;
	}

    
}

