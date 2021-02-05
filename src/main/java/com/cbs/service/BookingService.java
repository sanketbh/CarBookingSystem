package com.cbs.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cbs.dto.BookingDTO;
import com.cbs.entity.Booking;
import com.cbs.entity.Car;
import com.cbs.entity.User;
import com.cbs.exception.CarException;
import com.cbs.exception.NotFoundException;
import com.cbs.exception.UserException;
import com.cbs.repository.BookingRepository;
import com.cbs.repository.CarRepository;
import com.cbs.repository.UserRepository;

@Service
public class BookingService implements IBookingService {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CarRepository carRepository;

	// new car booking
	@Override
	public Booking addNewBooking(Booking booking) {
		return bookingRepository.save(booking);
	}

	// get All users booking for specified date(duration)
	@Override
	public List<Booking> getAllUsersBooking(String email, LocalDateTime booking_from_date,
			LocalDateTime booking_to_date) {
		User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new NotFoundException("User with email not Found"));
		List<Booking> bookings = bookingRepository.findAllUserBooking(user, booking_from_date, booking_to_date);
		return bookings;
	}

	// get all car which are booked
	@Override
	public List<Booking> getAllCarBooking(int id, LocalDateTime booking_from_date, LocalDateTime booking_to_date) {
		Car car = carRepository.findById(id).orElseThrow(() -> new NotFoundException("Car not Found"));
		List<Booking> bookings = bookingRepository.findAllCarBooking(car, booking_from_date, booking_to_date);
		return bookings;
	}

	// get all car with valid insurance
	@Override
	public List<Car> getAllCarWithValidInsurance(LocalDateTime insurance_till) {
		LocalDateTime currentDateTime = LocalDateTime.now();
		List<Car> cars = carRepository.findAllCarWithValidInsurance(currentDateTime, insurance_till);
		return cars;
	}
}