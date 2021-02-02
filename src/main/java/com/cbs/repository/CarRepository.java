package com.cbs.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cbs.entity.Car;

public interface CarRepository extends JpaRepository<Car, Integer>{

	//	get all cars with valid insurance 
	@Query("SELECT c FROM Car c WHERE c.insurance_till >=:insurance_till")
	public List<Car> FindAllCarWithValidInsurance(@Param("insurance_till") LocalDateTime insurance_till);
}
