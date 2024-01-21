package com.br.varejista.repository;

import com.br.varejista.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT c FROM Product c WHERE c.name like :name")
    List<Product> findAllByProductName(@Param("name") String name);

    @Query("SELECT c FROM Product c WHERE c.description like :description")
    List<Product> findAllByClientDescription(@Param("description") String description);

    @Query("SELECT c FROM Product c WHERE c.price like :price")
    List<Product> findAllByProductPrice(@Param("price") Double price);

    @Query("SELECT c FROM Product c WHERE c.size like :size")
    List<Product> findAllByProductSize(@Param("size") Integer size);

    @Query("SELECT c FROM Product c WHERE c.quantityInStock like :quantityInStock")
    List<Product> findAllByProductQuantityInStock(@Param("quantityInStock") Integer quantityInStock);

    @Query("SELECT c FROM Product c WHERE c.color like :color")
    List<Product> findAllByProductColor(@Param("color") String color);
}
