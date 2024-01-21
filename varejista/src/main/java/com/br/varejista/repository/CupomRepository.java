package com.br.varejista.repository;

import com.br.varejista.model.Cupom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CupomRepository extends JpaRepository<Cupom, Integer> {

    @Query("SELECT c FROM Cupom c WHERE c.name like :name")
    List<Cupom> findAllByCupomName(@Param("name") String name);
    @Query("SELECT c FROM Cupom c WHERE c.value like :value")
    List<Cupom> findAllByCupomValue(@Param("value") Double value);

    @Query("SELECT c FROM Cupom c WHERE c.description like :description")
    List<Cupom> findAllByCupomDescription(@Param("description") String description);
}


