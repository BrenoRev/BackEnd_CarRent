package com.dev.rev.prova.Unit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.rev.prova.Entities.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
