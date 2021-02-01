package com.cbs.entity;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "car_id", nullable = false)
	private Car car;
	private Instant booking_from_date;
	private Instant booking_to_date;
	
	public Booking() {
		super();
	}

	public Booking(User user, Car car, Instant booking_from_date, Instant booking_to_date) {
		super();
		this.user = user;
		this.car = car;
		this.booking_from_date = booking_from_date;
		this.booking_to_date = booking_to_date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
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
