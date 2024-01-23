package com.br.varejista.service;

import com.br.varejista.model.Product;

import java.time.LocalDate;
import java.util.List;

public interface ProductService extends GenericService<Product>{

    List<Product> findAllByProductName(final String name);

    List<Product> findAllByProductDescription(final String description);

    List<Product> findAllByProductPrice(final Double price);

    List<Product> findAllByProductSize(final Integer size);

    List<Product> findAllByProductQuantityInStock(final Integer quantityInStock);

    List<Product> findAllByProductColor(final String cor);

    List<Product> findAllByProductCategory(final String category);

    List<Product> findAllByProductBrand(final String brand);

    List<Product> findAllByProductDateRegister(final LocalDate dateRegister);
}
