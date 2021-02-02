package com.cbs.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cbs.dto.BookingDTO;
import com.cbs.entity.Booking;
import com.cbs.entity.Car;
import com.cbs.service.IBookingService;

import net.bytebuddy.asm.Advice.Local;

@RestController
@RequestMapping("/api")
public class BookingController {
	
	@Autowired
	private IBookingService bookingService;
	
	//get all users booking in given time
	@GetMapping("/booking/user")
	public ResponseEntity<List<BookingDTO>> getAllUsersBooking(@RequestParam String email, @RequestParam @DateTimeFormat(pattern =  "yyyy-MM-dd HH:mm") LocalDateTime booking_from_date, @RequestParam @DateTimeFormat(pattern =  "yyyy-MM-dd HH:mm") LocalDateTime booking_to_date){
		List<BookingDTO> bookings = bookingService.getAllUsersBooking(email, booking_from_date, booking_to_date);
		if(bookings.size() >=0) {
			return ResponseEntity.status(HttpStatus.OK).body(bookings);
		}
		throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Due to Server Error we are unable to process request, Please try again later");
	}
	
	//get all card booking in given time
	@GetMapping("/booking/car")
	public ResponseEntity<List<BookingDTO>> getAllCarsBooking(@RequestParam int id, @RequestParam @DateTimeFormat(pattern =  "yyyy-MM-dd HH:mm") LocalDateTime booking_from_date, @RequestParam @DateTimeFormat(pattern =  "yyyy-MM-dd HH:mm") LocalDateTime booking_to_date){
		List<BookingDTO> bookings = bookingService.getAllCarBooking(id, booking_from_date, booking_to_date);
		if(bookings.size() >=0) {
			return ResponseEntity.status(HttpStatus.OK).body(bookings);
		}
		throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Due to Server Error we are unable to process request, Please try again later");
	}
	
	//get all cars which has valid insurance in given specified time
	@GetMapping("/car/validinsurance")
	public List<Car> getAllCarWithValidInsurance(@RequestParam @DateTimeFormat(pattern =  "yyyy-MM-dd HH:mm") LocalDateTime insurance_till){
		List<Car> cars = bookingService.getAllCarWithValidInsurance(insurance_till);
		return cars;
	}
}
