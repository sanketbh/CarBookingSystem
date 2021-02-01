package com.cbs.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int bookingId;
	@ManyToOne(fetch = FetchType.LAZY, optional = true,cascade= {CascadeType.ALL})
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	@ManyToOne(fetch = FetchType.LAZY,  optional = true,cascade= {CascadeType.ALL})
	@JoinColumn(name = "car_id", nullable = false)
	private Car car;
	private Date booking_from_date;
	private Date booking_to_date;
	
	public Booking() {
		super();
	}
  
	public Booking(User user, Car car, Date booking_from_date, Date booking_to_date) {
		super();
		this.booking_from_date = booking_from_date;
		this.booking_to_date = booking_to_date;
	}

	
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

	public Date getBooking_from_date() {
		return booking_from_date;
	}

	public void setBooking_from_date(Date booking_from_date) {
		this.booking_from_date = booking_from_date;
	}

	public Date getBooking_to_date() {
		return booking_to_date;
	}

	public void setBooking_to_date(Date booking_to_date) {
		this.booking_to_date = booking_to_date;
	}

	@Override
	public String toString() {
		return "Booking [user=" + user + ", car=" + car + ", booking_from_date=" + booking_from_date
				+ ", booking_to_date=" + booking_to_date + "]";
	}
	
}
