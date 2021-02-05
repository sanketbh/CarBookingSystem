package com.cbs.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbs.entity.Booking;
import com.cbs.entity.Car;
import com.cbs.service.IBookingService;

@RestController
@RequestMapping("/api")
public class BookingController {

	@Autowired
	private IBookingService bookingService;

	// get all users booking in given time
	@GetMapping("/booking/user")
	public ResponseEntity<List<Booking>> getAllUsersBooking(@RequestParam String email,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime booking_from_date,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime booking_to_date) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(bookingService.getAllUsersBooking(email, booking_from_date, booking_to_date));
	}

	// get all card booking in given time
	@GetMapping("/booking/car")
	public ResponseEntity<List<Booking>> getAllCarsBooking(@RequestParam int id,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime booking_from_date,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime booking_to_date) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(bookingService.getAllCarBooking(id, booking_from_date, booking_to_date));
	}

	// get all cars which has valid insurance in given specified time
	@GetMapping("/car/validinsurance")
	public ResponseEntity<List<Car>> getAllCarWithValidInsurance(
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime insurance_till) {
		return ResponseEntity.status(HttpStatus.OK).body(bookingService.getAllCarWithValidInsurance(insurance_till));
	}
}