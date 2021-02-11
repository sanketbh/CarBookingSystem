package com.cbs.testcase;




import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import com.cbs.repository.CarRepository;
import com.cbs.service.CarService;


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
