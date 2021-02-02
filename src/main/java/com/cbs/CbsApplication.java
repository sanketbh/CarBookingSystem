package com.cbs;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cbs.entity.Car;
import com.cbs.service.ICarService;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CbsApplication implements CommandLineRunner {

	@Autowired
	private ICarService carService; //car service
	
	public static void main(String[] args) {
		SpringApplication.run(CbsApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public Docket api() {
		return 
				new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.cbs.controller"))    //selecting handler
				.paths(PathSelectors.any())                //selecting request mapping
				.build();        
	}
	@Override
	public void run(String... args) throws Exception {
		//date provided by the end user
		String userDate = "2022-01-02";
		String[] str = userDate.split("-");
		//to get an instant of 
		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(str[0]), (Integer.parseInt(str[1])-1),Integer.parseInt(str[2]), 23,00,00);
		//converting into localDateTime Format
		LocalDateTime date = cal.getTime() //return date()
				.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDateTime();
		//new car Object
		Car car = new Car("Hyundai Verna",date); 
		carService.addNewCar(car); //saving the 
	}

}
