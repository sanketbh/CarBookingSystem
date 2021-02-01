package com.cbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbs.entity.Car;

public interface CarRepository extends JpaRepository<Car, Integer>{

}
