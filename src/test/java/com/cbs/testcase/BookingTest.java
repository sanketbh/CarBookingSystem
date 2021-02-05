package com.cbs.testcase;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.DynamicTest.stream;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cbs.dto.BookingDTO;
import com.cbs.dto.NewBookingDTO;
import com.cbs.entity.Booking;
import com.cbs.entity.Car;
import com.cbs.entity.User;
import com.cbs.repository.BookingRepository;
import com.cbs.repository.CarRepository;
import com.cbs.repository.UserRepository;
import com.cbs.service.BookingService;
import com.cbs.service.IBookingService;


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
	

	@Test
	public void getAllUsersBooking() {
		User u = new User();
		u.setName("sanket");
		u.setEmail("sanket@gmail.com");
		Optional<User> user = Optional.of(u);
		Car c = new Car();
		c.setModel("Hyundai Elentra");
		c.setInsurance_till(LocalDateTime.now());
		Optional<Car> car = Optional.of(c);
		Booking booking = new Booking();
		booking.setBooking_from_date(LocalDateTime.now());
		booking.setBooking_to_date(LocalDateTime.now());
		List<Booking> bookings = new ArrayList<>();
		booking.setUser(u);
		booking.setCar(c);
		bookings.add(booking);
		when(userRepository.findByEmail(user.get().getEmail())).thenReturn(user);
		when(bookingRepository.findAllUserBooking(u, booking.getBooking_from_date(), booking.getBooking_to_date())).thenReturn(bookings);
		List<Booking> bookings1 = new ArrayList<>();
		bookings1 = bookingService.getAllUsersBooking(u.getEmail(),  booking.getBooking_from_date(), booking.getBooking_to_date());
		assertEquals(bookings, bookings1);
	}
	
	@Test
	public void getAllCarBooking() {
		User u = new User();
		u.setName("sanket");
		u.setEmail("sanket@gmail.com");
		Optional<User> user = Optional.of(u);
		Car c = new Car();
		c.setModel("Hyundai Elentra");
		c.setInsurance_till(LocalDateTime.now());
		Optional<Car> car = Optional.of(c);
		Booking booking = new Booking();
		booking.setBooking_from_date(LocalDateTime.now());
		booking.setBooking_to_date(LocalDateTime.now());
		List<Booking> bookings = new ArrayList<>();
		booking.setUser(u);
		booking.setCar(c);
		bookings.add(booking);
		when(carRepository.findById(car.get().getCarId())).thenReturn(car);
		when(bookingRepository.findAllCarBooking(c, booking.getBooking_from_date(),  booking.getBooking_from_date())).thenReturn(bookings);
		List<Booking> bookings1 = new ArrayList<>();
		bookings1 = bookingService.getAllCarBooking(c.getCarId(), booking.getBooking_from_date(), booking.getBooking_from_date());
		System.out.println(bookings1);
		assertEquals(bookings, bookings1);
	}
	
	@Test
	public void getAllCarWithValidInsurance() {
		Car c = new Car();
		c.setModel("Hyundai Elentra");
		c.setInsurance_till(LocalDateTime.now());
		List<Car> cars = new ArrayList<>();
		cars.add(c);
		when(carRepository.findAllCarWithValidInsurance(LocalDateTime.now() ,c.getInsurance_till())).thenReturn(cars);
		List<Car> cars_check = new ArrayList<>();
		cars_check = bookingService.getAllCarWithValidInsurance(c.getInsurance_till());
		assertEquals(cars, cars_check);
	}
}
