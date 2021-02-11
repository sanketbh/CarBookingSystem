package com.cbs.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cbs.entity.Booking;
import com.cbs.entity.Car;
import com.cbs.entity.User;
import com.cbs.exception.NotFoundException;
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
		booking = bookingRepository.save(booking);
		return booking;
	}

	// get All users booking for specified date(duration)
	@Override
	public List<Booking> getAllUsersBooking(String email, LocalDateTime bookingFromDate, LocalDateTime bookingToDate,
			int pageNumber, int itemsPerPage) {
		User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new NotFoundException("User with email not Found"));

		Pageable pageable = PageRequest.of(pageNumber, itemsPerPage);

		return bookingRepository.findAllUserBooking(user, bookingFromDate, bookingToDate, pageable);
	}

	// get all car which are booked
	@Override
	public List<Booking> getAllCarBooking(int id, LocalDateTime bookingFromDate, LocalDateTime bookingToDate,
			int pageNumber, int itemsPerPage) {
		Car car = carRepository.findById(id).orElseThrow(() -> new NotFoundException("Car not Found"));

		Pageable pageable = PageRequest.of(pageNumber, itemsPerPage);

		return bookingRepository.findAllCarBooking(car, bookingFromDate, bookingToDate, pageable);
	}

	// get all car with valid insurance
	@Override
	public List<Car> getAllCarWithValidInsurance(LocalDateTime insuranceTill, int pageNumber, int itemsPerPage) {
		Pageable pageable = PageRequest.of(pageNumber, itemsPerPage);
		return carRepository.findAllCarWithValidInsurance(insuranceTill, pageable);
	}
}