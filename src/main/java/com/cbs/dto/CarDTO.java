package com.cbs.dto;

import java.time.Instant;


public class CarDTO {
	
	private String model;
	private Instant insurance_till;
	
	public CarDTO() {
		super();
	}
	
	public CarDTO(String model, Instant insurance_till) {
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

	public Instant getInsurance_till() {
		return insurance_till;
	}

	public void setInsurance_till(Instant insurance_till) {
		this.insurance_till = insurance_till;
	}

	@Override
	public String toString() {
		return "Car [ model=" + model + ", insurance_till=" + insurance_till + "]";
	}
	
}
