package com.br.varejista.service.impl;

import com.br.varejista.Utils;
import com.br.varejista.model.Client;
import com.br.varejista.model.Product;
import com.br.varejista.repository.ClientRepository;
import com.br.varejista.repository.ProductRepository;
import com.br.varejista.validator.Operation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest extends Utils {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(ProductServiceImplTest.class);
    }

    @Test
    void save() {
        when(repository.saveAndFlush(any())).thenReturn(makeProduct());
        Product product = productService.save(any(), Operation.INSERT);
        assertNotNull(product);
        assertEquals(makeProduct(), product);
        verify(repository, times(1)).saveAndFlush(any());
    }

    @Test
    void delete() {
        productService.delete(any());
        verify(repository, times(1)).deleteById(any());
    }

    @Test
    void findAllByProductName() {
        when(repository.findAllByProductName(any())).thenReturn(Arrays.asList(makeProduct()));
        List<Product> products = productService.findAllByProductName(any());
        assertNotNull(products);
        assertFalse(products.isEmpty());
        verify(repository, times(1)).findAllByProductName(any());
    }

    @Test
    void findAllByProductDescription() {
        when(repository.findAllByProductDescription(any())).thenReturn(Arrays.asList(makeProduct()));
        List<Product> products = productService.findAllByProductDescription(any());
        assertNotNull(products);
        assertFalse(products.isEmpty());
        verify(repository, times(1)).findAllByProductDescription(any());
    }

    @Test
    void findAllByProductPrice() {
        when(repository.findAllByProductPrice(any())).thenReturn(Arrays.asList(makeProduct()));
        List<Product> products = productService.findAllByProductPrice(any());
        assertNotNull(products);
        assertFalse(products.isEmpty());
        verify(repository, times(1)).findAllByProductPrice(any());
    }

    @Test
    void findAllByProductSize() {
        when(repository.findAllByProductSize(any())).thenReturn(Arrays.asList(makeProduct()));
        List<Product> products = productService.findAllByProductSize(any());
        assertNotNull(products);
        assertFalse(products.isEmpty());
        verify(repository, times(1)).findAllByProductSize(any());
    }

    @Test
    void findAllByProductQuantityInStock() {
        when(repository.findAllByProductQuantityInStock(any())).thenReturn(Arrays.asList(makeProduct()));
        List<Product> products = productService.findAllByProductQuantityInStock(any());
        assertNotNull(products);
        assertFalse(products.isEmpty());
        verify(repository, times(1)).findAllByProductQuantityInStock(any());
    }

    @Test
    void findAllByProductColor() {
        when(repository.findAllByProductColor(any())).thenReturn(Arrays.asList(makeProduct()));
        List<Product> products = productService.findAllByProductColor(any());
        assertNotNull(products);
        assertFalse(products.isEmpty());
        verify(repository, times(1)).findAllByProductColor(any());
    }

    @Test
    void findAllByProductCategory() {
        when(repository.findAllByProductCategory(any())).thenReturn(Arrays.asList(makeProduct()));
        List<Product> products = productService.findAllByProductCategory(any());
        assertNotNull(products);
        assertFalse(products.isEmpty());
        verify(repository, times(1)).findAllByProductCategory(any());
    }

    @Test
    void findAllByProductBrand() {
        when(repository.findAllByProductBrand(any())).thenReturn(Arrays.asList(makeProduct()));
        List<Product> products = productService.findAllByProductBrand(any());
        assertNotNull(products);
        assertFalse(products.isEmpty());
        verify(repository, times(1)).findAllByProductBrand(any());
    }

    @Test
    void findAllByProductDateRegister() {
        when(repository.findAllByProductDateRegister(any())).thenReturn(Arrays.asList(makeProduct()));
        List<Product> products = productService.findAllByProductDateRegister(any());
        assertNotNull(products);
        assertFalse(products.isEmpty());
        verify(repository, times(1)).findAllByProductDateRegister(any());
    }
}