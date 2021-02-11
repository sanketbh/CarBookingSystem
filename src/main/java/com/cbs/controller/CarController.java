package com.cbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cbs.entity.Car;
import com.cbs.service.ICarService;

@RestController
public class CarController {

	@Autowired
	private ICarService carService;

	@PostMapping(value = "/cars")
	public ResponseEntity<Car> addNewCar(@RequestBody Car car) {
		return ResponseEntity.status(HttpStatus.OK).body(carService.addNewCar(car));
	}
}
