package com.cbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cbs.entity.Booking;
import com.cbs.service.IUserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private IUserService userService;

	// new booking
	@PostMapping(value = "/user/booking")
	public ResponseEntity<Booking> addNewBooking(@RequestBody Booking newBooking) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.addNewBooking(newBooking));
	}
}
