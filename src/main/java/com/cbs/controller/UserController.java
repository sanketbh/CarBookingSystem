package com.cbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cbs.dto.BookingDTO;
import com.cbs.dto.NewBookingDTO;
import com.cbs.entity.Booking;
import com.cbs.service.IUserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private IUserService userService;
	
	//new booking
	@PostMapping(value="user/booking")
	public ResponseEntity<String> addNewBooking(@RequestBody NewBookingDTO newBooking) {
		BookingDTO booking = userService.addNewBooking(newBooking);
		if(booking !=null) {
			return ResponseEntity.status(HttpStatus.OK).body("Booking created Successfully");
		}
		throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to create booking");
	}
}
