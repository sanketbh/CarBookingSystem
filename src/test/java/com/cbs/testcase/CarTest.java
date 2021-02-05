package com.cbs.testcase;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cbs.dto.CarDTO;
import com.cbs.dto.NewBookingDTO;
import com.cbs.entity.Booking;
import com.cbs.entity.Car;
import com.cbs.entity.User;
import com.cbs.repository.BookingRepository;
import com.cbs.repository.CarRepository;
import com.cbs.service.CarService;
import com.cbs.service.ICarService;
import com.cbs.service.IUserService;


public class CarTest {

	@InjectMocks
	private CarService carService;
	
	@Mock
	private CarRepository carRepository;
	
	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

//	@Test
//	public void addCar() {
//		Car car = new Car("Hyundai Elentra", LocalDateTime.now());
//		when(carRepository.save(car)).thenReturn(car);
//		Car car1 = carService.addNewCar(car);
//		assertEquals(car, car1);
//	}
}
