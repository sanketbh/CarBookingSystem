package com.cbs.dto;

import java.time.Instant;


public class BookingDTO {

	private UserDTO user;
	private CarDTO car;
	private Instant booking_from_date;
	private Instant booking_to_date;
	
	public BookingDTO() {
		super();
	}

	public BookingDTO( Instant booking_from_date, Instant booking_to_date) {
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

	public Instant getBooking_from_date() {
		return booking_from_date;
	}

	public void setBooking_from_date(Instant booking_from_date) {
		this.booking_from_date = booking_from_date;
	}

	public Instant getBooking_to_date() {
		return booking_to_date;
	}

	public void setBooking_to_date(Instant booking_to_date) {
		this.booking_to_date = booking_to_date;
	}

	@Override
	public String toString() {
		return "Booking [user=" + user + ", car=" + car + ", booking_from_date=" + booking_from_date
				+ ", booking_to_date=" + booking_to_date + "]";
	}
}
