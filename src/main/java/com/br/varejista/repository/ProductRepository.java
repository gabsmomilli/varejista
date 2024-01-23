package com.br.varejista.repository;

import com.br.varejista.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT c FROM Product c WHERE c.name like :name")
    List<Product> findAllByProductName(@Param("name") String name);

    @Query("SELECT c FROM Product c WHERE c.description like :description")
    List<Product> findAllByClientDescription(@Param("description") String description);

    @Query("SELECT c FROM Product c WHERE c.price = :price")
    List<Product> findAllByProductPrice(@Param("price") Double price);

    @Query("SELECT c FROM Product c WHERE c.size = :size")
    List<Product> findAllByProductSize(@Param("size") Integer size);

    @Query("SELECT c FROM Product c WHERE c.quantityInStock = :quantityInStock")
    List<Product> findAllByProductQuantityInStock(@Param("quantityInStock") Integer quantityInStock);

    @Query("SELECT c FROM Product c WHERE c.color like :color")
    List<Product> findAllByProductColor(@Param("color") String color);

    @Query("SELECT c FROM Product c WHERE c.category like :category")
    List<Product> findAllByProductCategory(@Param("category") String category);

    @Query("SELECT c FROM Product c WHERE c.brand like :brand")
    List<Product> findAllByProductBrand(@Param("brand") String brand);

    @Query("SELECT c FROM Product c WHERE c.dateRegister = :dateRegister")
    List<Product> findAllByProductDateRegister(@Param("dateRegister") LocalDate dateRegister);

}
