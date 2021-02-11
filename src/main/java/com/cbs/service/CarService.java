package com.cbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbs.entity.Car;
import com.cbs.repository.CarRepository;

@Service
public class CarService implements ICarService {

	@Autowired
	private CarRepository carRepository;

	// new car booking
	@Override
	public Car addNewCar(Car car) {
		car = carRepository.save(car);
		return car;
	}
}
