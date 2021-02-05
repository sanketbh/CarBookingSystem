package com.cbs.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cbs.entity.Booking;
import com.cbs.entity.Car;
import com.cbs.entity.User;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

	@Query("SELECT b FROM Booking b WHERE b.user =:user and b.booking_from_date >=:booking_from_date and b.booking_to_date <=:booking_to_date")
	public List<Booking> findAllUserBooking(@Param("user") User user,
			@Param("booking_from_date") LocalDateTime booking_from_date,
			@Param("booking_to_date") LocalDateTime booking_to_date);

	@Query("SELECT b FROM Booking b WHERE b.car =:car and b.booking_from_date >=:booking_from_date and b.booking_to_date <=:booking_to_date")
	public List<Booking> findAllCarBooking(@Param("car") Car car,
			@Param("booking_from_date") LocalDateTime booking_from_date,
			@Param("booking_to_date") LocalDateTime booking_to_date);
}
