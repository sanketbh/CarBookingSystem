package com.cbs.testcase;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
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
import com.cbs.service.IUserService;
import com.cbs.service.UserService;



public class UserTest {

	@InjectMocks
	private UserService userService;
	
	@Mock
	private BookingRepository bookingRepository;
	
	@Mock
	private UserRepository userRepository;
	
	@Mock
	private CarRepository carRepository;
	
	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}
	
	
	@Test
	public void createBookingTest() {
		User u = new User();
		u.setUserId(0);
		u.setName("sanket");
		u.setEmail("sanket@gmail.com");
		Optional<User> user = Optional.of(u);
		Car c = new Car();
		c.setCarId(0);
		c.setModel("Hyundai Elentra");
		c.setInsurance_till(LocalDateTime.now());
		Optional<Car> car = Optional.of(c);
		Booking newBooking = new Booking();
		newBooking.setUser(u);
		newBooking.setCar(c);
		newBooking.setBooking_from_date(LocalDateTime.now());
		newBooking.setBooking_to_date(LocalDateTime.now());
		when(userRepository.findByUserId(u.getUserId())).thenReturn(user);
		when(carRepository.findByCarId(c.getCarId())).thenReturn(car);
		when(bookingRepository.save(newBooking)).thenReturn(newBooking);
		Booking booking1 = userService.addNewBooking(newBooking); 
		System.out.println(booking1);
		//assertEquals(car.get().getModel(), booking.getCar().getModel());
		assertEquals(newBooking, booking1);
	}
}
