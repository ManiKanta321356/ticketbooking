package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.User.BookingRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BookingController {

    // Map to store booked seats per user
    private Map<String, List<Integer>> bookedSeatsMap1 = new HashMap<>();

    // Endpoint to handle user login
    @PostMapping("/login")
    public String login(@RequestBody String username) {
        // For simplicity, let's assume all logins are successful
        return "Login successful for user: " + username;
    }

    // Endpoint to handle booking submission
    @PostMapping("/book")
    public String bookSeats(@RequestBody BookingRequest bookingRequest) {
        bookedSeatsMap1.putIfAbsent(bookingRequest.getUsername(), new ArrayList<>());
        bookedSeatsMap1.get(bookingRequest.getUsername()).addAll(bookingRequest.getSeats());
        return "Booking confirmed for user: " + bookingRequest.getUsername() + ", Seats: " + bookingRequest.getSeats();
    }

    // Endpoint to retrieve booked seats for a specific user
    @GetMapping("/booked-seats")
    public List<Integer> getBookedSeats(@RequestParam String username) {
        return bookedSeatsMap1.getOrDefault(username, new ArrayList<>());
    }

    // Endpoint to retrieve all booked seats
    @GetMapping("/all-booked-seats")
    public Map<String, List<Integer>> getAllBookedSeats() {
        return bookedSeatsMap1;
    }
    private final Map<String, List<Integer>> bookedSeatsMap = new HashMap<>();

    }
