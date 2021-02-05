package com.cbs.dto;

import java.time.Instant;
import java.time.LocalDateTime;


public class BookingDTO {

	private UserDTO user;
	private CarDTO car;
	private LocalDateTime booking_from_date;
	private LocalDateTime booking_to_date;
	public BookingDTO() {
		super();
	}

	public BookingDTO( LocalDateTime booking_from_date, LocalDateTime booking_to_date) {
		super();
		this.booking_from_date = booking_from_date;
		this.booking_to_date = booking_to_date;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public CarDTO getCar() {
		return car;
	}

	public void setCar(CarDTO car) {
		this.car = car;
	}

	public LocalDateTime getBooking_from_date() {
		return booking_from_date;
	}

	public void setBooking_from_date(LocalDateTime booking_from_date) {
		this.booking_from_date = booking_from_date;
	}

	public LocalDateTime getBooking_to_date() {
		return booking_to_date;
	}

	public void setBooking_to_date(LocalDateTime booking_to_date) {
		this.booking_to_date = booking_to_date;
	}

	@Override
	public String toString() {
		return "Booking [user=" + user + ", car=" + car + ", booking_from_date=" + booking_from_date
				+ ", booking_to_date=" + booking_to_date + "]";
	}
}
