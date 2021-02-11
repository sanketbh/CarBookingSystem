package com.cbs.dto;

import java.time.Instant;
import java.time.LocalDateTime;


public class CarDTO {
	
	private String model;
	private LocalDateTime insurance_till;
	
	public CarDTO() {
		super();
	}
	
	public CarDTO(String model, LocalDateTime insurance_till) {
		super();
		this.model = model;
		this.insurance_till = insurance_till;
	}


	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public LocalDateTime getInsurance_till() {
		return insurance_till;
	}

	public void setInsurance_till(LocalDateTime insurance_till) {
		this.insurance_till = insurance_till;
	}

	@Override
	public String toString() {
		return "Car [ model=" + model + ", insurance_till=" + insurance_till + "]";
	}
	
}
