package com.dev.rev.prova.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import lombok.*;
import org.hibernate.Hibernate;

import com.dev.rev.prova.enums.CarColor;
import com.dev.rev.prova.enums.CarFuel;
import com.dev.rev.prova.enums.CarTransmission;
import com.dev.rev.prova.enums.CarType;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "Car")
public class Car implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "model_id")
	@NotNull(message = "The model can't be null")
	private Model model;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "brand_id")
	@NotNull(message = "The Brand can't be null")
	private Brand brand;

	@Column(name = "car_name")
	@NotNull(message = "Car's name is required")
	private String name;

	@Column(name = "car_age")
	@Max(value = 2022, message = "Car's manufacturing date can't be over than 2022")
	@NotNull(message = "Car's manufacturing date is required")
	private Long ageCar;

	@Column(name = "car_km")
	@NotNull(message = "Car's mileage can't be null")
	private Double km;

	@Column(name = "car_price")
	@NotNull(message = "Car's price can't be null")
	private Double price;

	@Column(name = "car_ipva")
	@NotNull(message = "Car's ipva can't be null")
	private Boolean ipva;

	@Column(name = "car_reserved")
	@NotNull(message = "If the car is already reserved put true, else put false")
	private Boolean reserved;

	@Column(name = "car_photo")
	@NotNull(message = "Car must have a photo")
	private String photo;

	@Column(name = "car_type")
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Car type can't be null")
	private CarType carType;

	@Column(name = "car_transmission")
	@Enumerated(EnumType.STRING)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private CarTransmission carTransmission;

	@Column(name = "car_color")
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Car's color can't be null")
	private CarColor carColor;

	@Column(name = "car_fuel")
	@Enumerated(EnumType.STRING)
	@NotNull(message = "The type of car's fuel can't be null")
	private CarFuel carFuel;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		Car car = (Car) o;
		return id != null && Objects.equals(id, car.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
