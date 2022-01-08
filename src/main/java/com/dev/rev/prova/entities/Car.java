package com.dev.rev.prova.entities;

import com.dev.rev.prova.Enums.CarColor;
import com.dev.rev.prova.Enums.CarFuel;
import com.dev.rev.prova.Enums.CarTransmission;
import com.dev.rev.prova.Enums.CarType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "Car")
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "model_id")
    private Model model;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Column(name= "car_type")
    @Enumerated(EnumType.STRING)
    private CarType carType;

    @Column(name = "car_transmission")
    @Enumerated(EnumType.STRING)
    private CarTransmission carTransmission;

    @Column(name = "car_age")
    private int ageCar;

    @Column(name = "car_km")
    private Double km;

    @Column(name = "car_price")
    private Double price;

    @Column(name = "car_ipva")
    private Boolean ipva;

    @Column(name = "car_color")
    @Enumerated(EnumType.STRING)
    private CarColor color;

    @Column(name = "car_fuel")
    @Enumerated(EnumType.STRING)
    private CarFuel fuel;

    @Column(name = "car_reserved")
    private Boolean reserved;

    @Column(name = "car_photo")
    private String foto;
}
