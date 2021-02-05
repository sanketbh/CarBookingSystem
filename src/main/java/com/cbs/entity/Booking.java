package com.cbs.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;

	@ManyToOne()
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToOne()
	@JoinColumn(name = "car_id", nullable = false)
	private Car car;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
	private LocalDateTime booking_from_date;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
	private LocalDateTime booking_to_date;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
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
		return "Booking [bookingId=" + bookingId + ", user=" + user + ", car=" + car + ", booking_from_date="
				+ booking_from_date + ", booking_to_date=" + booking_to_date + "]";
	}

}
