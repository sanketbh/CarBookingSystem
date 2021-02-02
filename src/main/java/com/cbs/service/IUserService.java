package com.cbs.service;

import com.cbs.dto.BookingDTO;
import com.cbs.dto.NewBookingDTO;
import com.cbs.entity.Booking;

public interface IUserService {
	public BookingDTO addNewBooking(NewBookingDTO newBooking); //method to add new booking

}
