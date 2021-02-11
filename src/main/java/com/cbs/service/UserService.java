package com.cbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbs.entity.Booking;
import com.cbs.entity.Car;
import com.cbs.entity.User;
import com.cbs.exception.NotFoundException;
import com.cbs.repository.BookingRepository;
import com.cbs.repository.CarRepository;
import com.cbs.repository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CarRepository carRepository;

	// new car booking
	@Override
	public Booking addNewBooking(Booking newBooking) {
		User user = userRepository.findByUserId(newBooking.getUser().getUserId())
				.orElseThrow(() -> new NotFoundException("User not Found"));

		Car car = carRepository.findByCarId(newBooking.getCar().getCarId())
				.orElseThrow(() -> new NotFoundException("Car not Found"));

		newBooking.setUser(user);
		newBooking.setCar(car);
		newBooking.setBookingFromDate(newBooking.getBookingFromDate());
		newBooking.setBookingFromDate(newBooking.getBookingToDate());
		newBooking = bookingRepository.save(newBooking);
		return newBooking;
	}

	@Override
	public Booking updateBooking(int bookingId, Booking booking) {
		booking = bookingRepository.findById(bookingId).orElseThrow(() -> new NotFoundException("Booking Not Found"));

		Car car = carRepository.findByCarId(booking.getCar().getCarId())
				.orElseThrow(() -> new NotFoundException("Car not found"));

		booking.setCar(car);
		booking = bookingRepository.save(booking);
		return booking;
	}

}
