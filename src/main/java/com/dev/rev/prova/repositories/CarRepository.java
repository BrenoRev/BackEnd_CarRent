package com.dev.rev.prova.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.rev.prova.entities.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
