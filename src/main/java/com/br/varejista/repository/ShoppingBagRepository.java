package com.br.varejista.repository;

import com.br.varejista.model.Product;
import com.br.varejista.model.ShoppingBag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ShoppingBagRepository extends JpaRepository<ShoppingBag, Integer> {

    @Query("SELECT s FROM ShoppingBag s WHERE s.client.id = :clientId")
    List<ShoppingBag> findAllByClientId(@Param("clientId") Integer clientId);

    @Query("SELECT s FROM ShoppingBag s JOIN s.products p WHERE :product MEMBER OF s.products")
    List<ShoppingBag> findAllByShoppingBagProducts(@Param("product") Product product);

}
