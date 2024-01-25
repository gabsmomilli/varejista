package com.br.varejista.controller;

import com.br.varejista.model.ShoppingBag;
import com.br.varejista.service.ShoppingBagService;
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
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import com.br.varejista.Utils;

@ExtendWith(MockitoExtension.class)
class ShoppingBagControllerTest extends Utils{

    @Mock
    private ShoppingBagService service;

    @InjectMocks
    private ShoppingBagController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(ClientControllerTest.class);
    }

    @Test
    void saveNew() {
        ShoppingBag shoppingBag = makeShoppingBag(makeProducts());
        when(service.save(shoppingBag, com.br.varejista.validator.Operation.INSERT)).thenReturn(shoppingBag);
        ResponseEntity response = controller.saveNew(shoppingBag);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(shoppingBag, response.getBody());
    }

    @Test
    void delete() {
        ResponseEntity response = controller.delete(1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        Mockito.verify(service, times(1)).delete(1);
    }

    @Test
    void findAllByClientId() {
        List<ShoppingBag> expectedShoppingBag = Collections.singletonList(makeShoppingBag(makeProducts()));
        when(service.findAllByClientId(any())).thenReturn(expectedShoppingBag);
        List<ShoppingBag> actualShoppingBag = controller.findAllByClientId(any());
        assertEquals(expectedShoppingBag, actualShoppingBag);
    }

    @Test
    void findAllByShoppingBagProducts() {
        List<ShoppingBag> expectedShoppingBag = Collections.singletonList(makeShoppingBag(makeProducts()));
        when(service.findAllByShoppingBagProducts(any())).thenReturn(expectedShoppingBag);
        List<ShoppingBag> actualShoppingBag = controller.findAllByShoppingBagProducts(any());
        assertEquals(expectedShoppingBag, actualShoppingBag);
    }
}
