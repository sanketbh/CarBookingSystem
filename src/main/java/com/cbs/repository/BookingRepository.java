package com.cbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbs.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
