package com.br.varejista.service.impl;

import com.br.varejista.model.Client;
import com.br.varejista.model.Product;
import com.br.varejista.repository.ProductRepository;
import com.br.varejista.service.ProductService;
import com.br.varejista.validator.Operation;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product save(final Product product, Operation operation) {
        return repository.saveAndFlush(product);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Product> findAllByProductName(String nome) {
        return repository.findAllByProductName(nome);
    }

    @Override
    public List<Product> findAllByClientDescription(String description) {
        return repository.findAllByClientDescription(description);
    }

    @Override
    public List<Product> findAllByProductPrice(Double price) {
        return repository.findAllByProductPrice(price);
    }

    @Override
    public List<Product> findAllByProductSize(Integer size) {
        return repository.findAllByProductSize(size);
    }

    @Override
    public List<Product> findAllByProductQuantityInStock(Integer quantityInStock) {
        return repository.findAllByProductQuantityInStock(quantityInStock);
    }

    @Override
    public List<Product> findAllByProductColor(String color) {
        return repository.findAllByProductColor(color);
    }

    @Override
    public List<Product> findAllByProductCategory(String category) {
        return repository.findAllByProductCategory(category);
    }

    @Override
    public List<Product> findAllByProductBrand(String brand) {
        return repository.findAllByProductBrand(brand);
    }

    @Override
    public List<Product> findAllByProductDateRegister(LocalDate dateRegister) {
        return repository.findAllByProductDateRegister(dateRegister);
    }
}
