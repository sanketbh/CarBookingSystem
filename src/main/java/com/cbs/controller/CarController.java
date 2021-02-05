package com.cbs.controller;

import java.time.LocalDateTime;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbs.dto.CarDTO;
import com.cbs.entity.Car;
import com.cbs.service.ICarService;

@RestController
@RequestMapping("/api")
public class CarController {

	@Autowired
	private ICarService carService;

	@PostMapping(value = "/car")
	public ResponseEntity<Car> addNewCar(@RequestBody Car car) {
		return ResponseEntity.status(HttpStatus.OK).body(carService.addNewCar(car));
	}
}
