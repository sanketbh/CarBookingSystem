package com.cbs.dto;

import java.time.Instant;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class NewBookingDTO {
	private int userId;
	private int carId;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
	private LocalDateTime booking_from_date;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
	private LocalDateTime booking_to_date;
	public NewBookingDTO() {
		super();
	}
	
	public NewBookingDTO(int userId, int carId, LocalDateTime booking_from_date, LocalDateTime booking_to_date) {
		super();
		this.userId = userId;
		this.carId = carId;
		this.booking_from_date = booking_from_date;
		this.booking_to_date = booking_to_date;
	}


	public NewBookingDTO(LocalDateTime booking_from_date, LocalDateTime booking_to_date) {
		super();
		this.booking_from_date = booking_from_date;
		this.booking_to_date = booking_to_date;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
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
		return "NewBookingDTO [userId=" + userId + ", carId=" + carId + ", booking_from_date=" + booking_from_date
				+ ", booking_to_date=" + booking_to_date + "]";
	}
	
}
