package com.cbs.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "car")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_id")
	private int carId;

	@Column(name = "model", length = 25)
	@NotEmpty(message = "model name cant be empty")
	private String model;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
	@Column(name = "insurance_till")
	private LocalDateTime insuranceTill;

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

	public LocalDateTime getInsuranceTill() {
		return insuranceTill;
	}

	public void setInsuranceTill(LocalDateTime insuranceTill) {
		this.insuranceTill = insuranceTill;
	}

	@Override
	public String toString() {
		return "Car [carId=" + carId + ", model=" + model + ", insuranceTill=" + insuranceTill + "]";
	}

}
