package com.dev.rev.prova.Repositories;


import com.dev.rev.prova.Entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {

    @Query("Select m from Model m Join Brand b on m.brand.id = b.id where b.name = :name")
    List<Model> getAllByBrand(@Param("name") String brand);
}
