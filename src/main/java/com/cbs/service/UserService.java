package com.cbs.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cbs.dto.BookingDTO;
import com.cbs.dto.NewBookingDTO;
import com.cbs.entity.Booking;
import com.cbs.entity.Car;
import com.cbs.entity.User;
import com.cbs.exception.CarException;
import com.cbs.exception.UserException;
import com.cbs.repository.BookingRepository;
import com.cbs.repository.CarRepository;
import com.cbs.repository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private ModelMapper modelMapper; //modal mapper to map entity with the DTO (This reduces the use of setter)

	//new car booking
	@Override
	public BookingDTO addNewBooking(NewBookingDTO newBooking) {
		User user = userRepository.findById(newBooking.getUserId()).orElseThrow(()-> new UserException("User not Found", HttpStatus.NOT_FOUND));
		Car car = carRepository.findById(newBooking.getCarId()).orElseThrow(()-> new CarException("Car not Found", HttpStatus.NOT_FOUND)); 
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT); //modal mapper to map object with DTO
		Booking booking = new Booking();
		booking.setUser(user);
		booking.setCar(car);
		booking.setBooking_from_date(newBooking.getBooking_from_date());
		booking.setBooking_to_date(newBooking.getBooking_to_date());
		booking = bookingRepository.save(booking);
		BookingDTO bookingDTO = new BookingDTO();
		if(booking != null) {
			bookingDTO = modelMapper.map(booking, BookingDTO.class);
		}
		return bookingDTO;
	}
}
