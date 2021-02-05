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
		newBooking.setBooking_from_date(newBooking.getBooking_from_date());
		newBooking.setBooking_to_date(newBooking.getBooking_to_date());
		newBooking = bookingRepository.save(newBooking);
		return newBooking;
	}
}
