package com.cbs.service;

import java.time.LocalDateTime;
import java.util.List;

import com.cbs.entity.Booking;
import com.cbs.entity.Car;

public interface IBookingService {
	public Booking addNewBooking(Booking booking); // method to add new booking
	// get All the booking of users whose email is provided

	public List<Booking> getAllUsersBooking(String email, LocalDateTime bookingFromDate, LocalDateTime bookingToDate,
			int pageNumber, int itemsPerpage);

	// get All the booking of car whose id is provided
	public List<Booking> getAllCarBooking(int id, LocalDateTime bookingFromDate, LocalDateTime bookingToDate,
			int pageNumber, int itemsPerpage);

	// get All cars which has valid insurance in specified time
	public List<Car> getAllCarWithValidInsurance(LocalDateTime insuranceTill, int pageNumber, int itemsPerpage);
}
