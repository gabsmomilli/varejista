package com.br.varejista.service.impl;

import com.br.varejista.Utils;
import com.br.varejista.model.ShoppingBag;
import com.br.varejista.repository.ShoppingBagRepository;
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
public class ShoppingBagServiceImplTest extends Utils {

    @Mock
    private ShoppingBagRepository repository;

    @InjectMocks
    private ShoppingBagServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(ProductServiceImplTest.class);
    }

    @Test
    void save() {
        when(repository.saveAndFlush(any())).thenReturn(makeShoppingBag(makeProducts()));
        ShoppingBag shoppingBag = service.save(any(), Operation.INSERT);
        assertNotNull(shoppingBag);
        assertEquals(makeShoppingBag(makeProducts()), shoppingBag);
        verify(repository, times(1)).saveAndFlush(any());
    }

    @Test
    void delete() {
        service.delete(any());
        verify(repository, times(1)).deleteById(any());
    }

    @Test
    void findAllByClientId() {
        when(repository.findAllByClientId(any())).thenReturn(Arrays.asList(makeShoppingBag(makeProducts())));
        List<ShoppingBag> shoppingBags = service.findAllByClientId(any());
        assertNotNull(shoppingBags);
        assertFalse(shoppingBags.isEmpty());
        verify(repository, times(1)).findAllByClientId(any());
    }

    @Test
    void findAllByShoppingBagProducts() {
        when(repository.findAllByShoppingBagProducts(any())).thenReturn(Arrays.asList(makeShoppingBag(makeProducts())));
        List<ShoppingBag> shoppingBags = service.findAllByShoppingBagProducts(any());
        assertNotNull(shoppingBags);
        assertFalse(shoppingBags.isEmpty());
        verify(repository, times(1)).findAllByShoppingBagProducts(any());
    }
}
