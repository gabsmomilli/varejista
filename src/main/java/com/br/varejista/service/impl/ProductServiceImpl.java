package com.br.varejista.service.impl;

import com.br.varejista.model.Product;
import com.br.varejista.repository.ProductRepository;
import com.br.varejista.service.ProductService;
import com.br.varejista.validator.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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
    public Product findById(Integer id) {
        Optional<Product> optionalProduct = repository.findById(id);
        return optionalProduct.orElse(null);
    }

    @Override
    public Product updateProduct(Integer id, Product updatedProduct) {
        Optional<Product> optionalProduct = repository.findById(id);

        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();

            existingProduct.setName(updatedProduct.getName());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setSize(updatedProduct.getSize());
            existingProduct.setQuantityInStock(updatedProduct.getQuantityInStock());
            existingProduct.setColor(updatedProduct.getColor());
            existingProduct.setCategory(updatedProduct.getCategory());
            existingProduct.setBrand(updatedProduct.getBrand());
            existingProduct.setDateRegister(updatedProduct.getDateRegister());

            return repository.save(existingProduct);
        } else {
            return null;
        }
    }

    @Override
    public List<Product> findAllByProductName(String nome) {
        return repository.findAllByProductName(nome);
    }

    @Override
    public List<Product> findAllByProductDescription(String description) {
        return repository.findAllByProductDescription(description);
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

    @Override
    public List<Product> findAllByCombinedFilter(String name, String description, Double price,
                                                 Integer size, Integer quantityInStock, String color,
                                                 String category, String brand, LocalDate dateRegister) {
        List<Product> products = repository.findAll();

        return products.stream().filter(
                product ->
                        (name == null || product.getName().equals(name)) &&
                                (description == null || product.getDescription().equals(description)) &&
                                (price == null || product.getPrice().equals(price)) &&
                                (size == null || product.getSize().equals(size)) &&
                                (quantityInStock == null || product.getQuantityInStock().equals(quantityInStock)) &&
                                (color == null || product.getColor().equals(color)) &&
                                (category == null || product.getCategory().equals(category)) &&
                                (brand == null || product.getBrand().equals(brand)) &&
                                (dateRegister == null || product.getDateRegister().equals(dateRegister))).collect(Collectors.toList());
    }
}
