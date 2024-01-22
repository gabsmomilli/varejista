package com.br.varejista.controller;

import com.br.varejista.model.Product;
import com.br.varejista.service.ProductService;
import com.br.varejista.validator.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity saveNew(@RequestBody final Product newProduct) {
        Product savedProduct = service.save(newProduct, Operation.INSERT);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{description}")
    public List<Product> findAllByProductName(@PathVariable("description") String description){
        return service.findAllByProductName(description);
    }

    @GetMapping("/{price}")
    public List<Product> findAllByProductPrice(@PathVariable("price") Double price){
        return service.findAllByProductPrice(price);
    }

    @GetMapping("/{size}")
    public List<Product> findAllByProductSize(@PathVariable("size") Integer size){
        return service.findAllByProductSize(size);
    }

    @GetMapping("/{quantityInStock}")
    public List<Product> findAllByProductQuantityInStock(@PathVariable("quantityInStock") Integer quantityInStock){
        return service.findAllByProductQuantityInStock(quantityInStock);
    }

    @GetMapping("/{color}")
    public List<Product> findAllByProductColor(@PathVariable("color") String color){
        return service.findAllByProductColor(color);
    }

    @GetMapping("/{category}")
    public List<Product> findAllByProductCategory(@PathVariable("price") String category){
        return service.findAllByProductCategory(category);
    }

    @GetMapping("/{brand}")
    public List<Product> findAllByProductBrand(@PathVariable("brand") String brand){
        return service.findAllByProductBrand(brand);
    }

    @GetMapping("/{dateRegister}")
    public List<Product> findAllByProductDateRegister(@PathVariable("dateRegister") LocalDate dateRegister){
        return service.findAllByProductDateRegister(dateRegister);
    }
}
