package com.dev.rev.prova.Entities;

import com.dev.rev.prova.Enums.CarColor;
import com.dev.rev.prova.Enums.CarFuel;
import com.dev.rev.prova.Enums.CarTransmission;
import com.dev.rev.prova.Enums.CarType;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
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
    @NotNull(message = "The model can't be null")
    private Model model;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "brand_id")
    @NotNull(message = "The Brand can't be null")
    private Brand brand;

    @Column(name= "car_type")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Car type can't be null")
    private CarType carType;

    @Column(name = "car_transmission")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Car's tramission type can't be null")
    private CarTransmission carTransmission;

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

    @Column(name = "car_color")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Car's color can't be null")
    private CarColor color;

    @Column(name = "car_fuel")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "The type of car's fuel can't be null")
    private CarFuel fuel;

    @Column(name = "car_reserved")
    @NotNull(message = "If the car is already reserved put true, else put false")
    private Boolean reserved;

    @Column(name = "car_photo")
    @NotNull(message = "Car must have a photo")
    private String foto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Car car = (Car) o;
        return id != null && Objects.equals(id, car.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
