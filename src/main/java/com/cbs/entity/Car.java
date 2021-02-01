package com.cbs.entity;

import java.time.Instant;

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
	private int id;
	@Column(length = 25)
	private String model;
	@Column(length = 70)
	private Instant insurance_till;
	
	public Car() {
		super();
	}
	
	public Car(String model, Instant insurance_till) {
		super();
		this.model = model;
		this.insurance_till = insurance_till;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "Car [id=" + id + ", model=" + model + ", insurance_till=" + insurance_till + "]";
	}
	
}
