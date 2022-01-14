package com.dev.rev.prova.Unit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.rev.prova.Entities.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

    Brand findByName(String name);

}
