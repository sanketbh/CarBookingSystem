package com.cbs.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int carId;
	@Column(length = 25)
	private String model;
	@Column(length = 70)
	private Date insurance_till;
	
	public Car() {
		super();
	}
	
	public Car(String model, Date insurance_till) {
		super();
		this.model = model;
		this.insurance_till = insurance_till;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Date getInsurance_till() {
		return insurance_till;
	}

	public void setInsurance_till(Date insurance_till) {
		this.insurance_till = insurance_till;
	}

	@Override
	public String toString() {
		return "Car [carId=" + carId + ", model=" + model + ", insurance_till=" + insurance_till + "]";
	}

}
