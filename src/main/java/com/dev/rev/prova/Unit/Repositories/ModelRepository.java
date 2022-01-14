package com.dev.rev.prova.Unit.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dev.rev.prova.Entities.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {

	@Query("Select m from Model m Join Brand b on m.brand.id = b.id where b.name = :name")
	List<Model> getAllByBrand(@Param("name") String brand);
}
