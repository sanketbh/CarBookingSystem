package com.cbs.testcase;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cbs.entity.Booking;
import com.cbs.entity.Car;
import com.cbs.entity.User;
import com.cbs.exception.NotFoundException;
import com.cbs.repository.BookingRepository;
import com.cbs.repository.CarRepository;
import com.cbs.repository.UserRepository;
import com.cbs.service.BookingService;

public class BookingTest {

	@InjectMocks
	private BookingService bookingService;

	@Mock
	private BookingRepository bookingRepository;

	@Mock
	private UserRepository userRepository;

	@Mock
	CarRepository carRepository;

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

//	@Test
//	public void getAllUsersBooking() {
//		User u = new User();
//		u.setName("sanket");
//		u.setEmail("sanket@gmail.com");
//
//		Optional<User> user = Optional.of(u);
//		Car c = new Car();
//		c.setModel("Hyundai Elentra");
//		c.setInsuranceTill(LocalDateTime.now());
//
//		Optional<Car> car = Optional.of(c);
//
//		Booking booking = new Booking();
//		booking.setBookingFromDate(LocalDateTime.now());
//		booking.setBookingToDate(LocalDateTime.now());
//
//		List<Booking> bookings = new ArrayList<>();
//		booking.setUser(u);
//		booking.setCar(c);
//		bookings.add(booking);
//		when(userRepository.findByEmail(user.get().getEmail())).thenReturn(user);
//
//		when(bookingRepository.findAllUserBooking(u, booking.getBookingFromDate(), booking.getBookingFromDate()))
//				.thenReturn(bookings);
//
//		List<Booking> bookings1 = new ArrayList<>();
//		bookings1 = bookingService.getAllUsersBooking(u.getEmail(), booking.getBookingFromDate(),
//				booking.getBookingToDate());
//
//		assertEquals(bookings, bookings1);
//	}
//
//	@Test
//	public void getAllCarBooking() {
//		User u = new User();
//		u.setName("sanket");
//		u.setEmail("sanket@gmail.com");
//
//		Optional<User> user = Optional.of(u);
//
//		Car c = new Car();
//		c.setModel("Hyundai Elentra");
//		c.setInsuranceTill(LocalDateTime.now());
//
//		Optional<Car> car = Optional.of(c);
//		Booking booking = new Booking();
//		booking.setBookingFromDate(LocalDateTime.now());
//		booking.setBookingToDate(LocalDateTime.now());
//
//		List<Booking> bookings = new ArrayList<>();
//		booking.setUser(u);
//		booking.setCar(c);
//		bookings.add(booking);
//
//		when(carRepository.findById(car.get().getCarId())).thenReturn(car);
//
//		when(bookingRepository.findAllCarBooking(c, booking.getBookingFromDate(), booking.getBookingToDate()))
//				.thenReturn(bookings);
//
//		List<Booking> bookings1 = new ArrayList<>();
//		bookings1 = bookingService.getAllCarBooking(c.getCarId(), booking.getBookingFromDate(),
//				booking.getBookingToDate());
//		assertEquals(bookings, bookings1);
//	}

//	// car with valid insurance
//	@Test
//	public void getAllCarWithValidInsurance() {
//		Car c = new Car();
//		c.setModel("Hyundai Elentra");
//		c.setInsuranceTill(LocalDateTime.now());
//
//		List<Car> cars = new ArrayList<>();
//		cars.add(c);
//
//		when(carRepository.findAllCarWithValidInsurance(c.getInsuranceTill(), c.getInsuranceTill())).thenReturn(cars);
//
//		List<Car> cars_check = new ArrayList<>();
//		cars_check = bookingService.getAllCarWithValidInsurance(c.getInsuranceTill());
//		assertEquals(cars, cars_check);
//	}

	// checking for Exception with wrong user_id.
	@Test
	public void UserNotFoundException() {
		User user = new User();
		user.setName("sanket");
		user.setEmail("sanket@gmail.com");

		Optional u = Optional.of(user);

		Assertions.assertThrows(NotFoundException.class, () -> {
			userRepository.findByUserId(0).orElseThrow(() -> new NotFoundException("message"));
			//when(userRepository.findByUserId(user.getUserId())).thenThrow(new NotFoundException("me"));
			//throw new NotFoundException("Not found Exception");
		});
	}

}
