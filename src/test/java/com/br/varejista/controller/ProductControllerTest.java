package com.br.varejista.controller;

import com.br.varejista.model.Product;
import com.br.varejista.service.ProductService;
import com.br.varejista.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest extends Utils {

    @Mock
    private ProductService service;

    @InjectMocks
    private ProductController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(ProductControllerTest.class);
    }

    @Test
    void saveNew() {
        Product product = makeProduct();
        when(service.save(product, com.br.varejista.validator.Operation.INSERT)).thenReturn(product);
        ResponseEntity response = controller.saveNew(product);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(product, response.getBody());
    }

    @Test
    void delete() {
        ResponseEntity response = controller.delete(1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        Mockito.verify(service, times(1)).delete(1);
    }

    @Test
    void findAllByProductName() {
        String name = "Scarpin";
        List<Product> expectedProduct = Collections.singletonList(makeProduct());
        when(service.findAllByProductName(name)).thenReturn(expectedProduct);
        List<Product> actualProduct = controller.findAllByProductName(name);
        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    void findAllByProductDescription() {
        String description = "Material sem origem animal";
        List<Product> expectedProduct = Collections.singletonList(makeProduct());
        when(service.findAllByProductDescription(description)).thenReturn(expectedProduct);
        List<Product> actualProduct = controller.findAllByProductDescription(description);
        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    void findAllByProductPrice() {
        Double price = 300.0;
        List<Product> expectedProduct = Collections.singletonList(makeProduct());
        when(service.findAllByProductPrice(price)).thenReturn(expectedProduct);
        List<Product> actualProduct = controller.findAllByProductPrice(price);
        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    void findAllByProductSize() {
        Integer size = 36;
        List<Product> expectedProduct = Collections.singletonList(makeProduct());
        when(service.findAllByProductSize(size)).thenReturn(expectedProduct);
        List<Product> actualProduct = controller.findAllByProductSize(size);
        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    void findAllByProductQuantityInStock() {
        Integer quantityInStock = 1;
        List<Product> expectedProduct = Collections.singletonList(makeProduct());
        when(service.findAllByProductQuantityInStock(quantityInStock)).thenReturn(expectedProduct);
        List<Product> actualProduct = controller.findAllByProductQuantityInStock(quantityInStock);
        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    void findAllByProductColor() {
        String color = "Preto";
        List<Product> expectedProduct = Collections.singletonList(makeProduct());
        when(service.findAllByProductColor(color)).thenReturn(expectedProduct);
        List<Product> actualProduct = controller.findAllByProductColor(color);
        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    void findAllByProductCategory() {
        String category = "Salto";
        List<Product> expectedProduct = Collections.singletonList(makeProduct());
        when(service.findAllByProductCategory(category)).thenReturn(expectedProduct);
        List<Product> actualProduct = controller.findAllByProductCategory(category);
        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    void findAllByProductBrand() {
        String brand = "Arezzo";
        List<Product> expectedProduct = Collections.singletonList(makeProduct());
        when(service.findAllByProductBrand(brand)).thenReturn(expectedProduct);
        List<Product> actualProduct = controller.findAllByProductBrand(brand);
        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    void findAllByProductDateRegister() {
        LocalDate dateRegister = LocalDate.of(2024, 1, 23);
        List<Product> expectedProduct = Collections.singletonList(makeProduct());
        when(service.findAllByProductDateRegister(dateRegister)).thenReturn(expectedProduct);
        List<Product> actualProduct = controller.findAllByProductDateRegister(dateRegister);
        assertEquals(expectedProduct, actualProduct);
    }
}
