package com.cbs.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cbs.entity.Car;
import com.cbs.entity.User;

public interface CarRepository extends JpaRepository<Car, Integer> {

	// get all cars with valid insurance
	@Query("SELECT c FROM Car c WHERE c.insurance_till>=:current_time AND c.insurance_till <=:insurance_till")
	public List<Car> findAllCarWithValidInsurance(@Param("current_time") LocalDateTime current_time, @Param("insurance_till") LocalDateTime insurance_till);

	public Optional<Car> findByCarId(int carId);
}
