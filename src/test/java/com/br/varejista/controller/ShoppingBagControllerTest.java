//package com.br.varejista.controller;
//
//import com.br.varejista.model.Client;
//import com.br.varejista.model.Product;
//import com.br.varejista.model.ShoppingBag;
//import com.br.varejista.service.ClientService;
//import com.br.varejista.service.ShoppingBagService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.time.LocalDate;
//import java.util.Collections;
//import java.util.List;
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//class ShoppingBagControllerTest {
//
//    @Mock
//    private ShoppingBagService service;
//
//    @InjectMocks
//    private ShoppingBagController controller;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(ClientControllerTest.class);
//    }
//
//    @Test
//    void saveNew() {
//        ShoppingBag shoppingBag = makeShoppingBag();
//        when(service.save(shoppingBag, com.br.varejista.validator.Operation.INSERT)).thenReturn(shoppingBag);
//        ResponseEntity response = controller.saveNew(shoppingBag);
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
//        assertEquals(shoppingBag, response.getBody());
//    }
//
//    @Test
//    void delete() {
//        ResponseEntity response = controller.delete(1);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        Mockito.verify(service, times(1)).delete(1);
//    }
//
//    @Test
//    void findAllByClientId() {
//        Integer clientId = 1;
//        List<ShoppingBag> expectedShoppingBag = Collections.singletonList(makeShoppingBag());
//        when(service.findAllByClientId(clientId)).thenReturn(expectedShoppingBag);
//        List<ShoppingBag> actualShoppingBag = controller.findAllByClientId(clientId);
//        assertEquals(expectedShoppingBag, actualShoppingBag);
//    }
//
//    @Test
//    void findAllByShoppingBagProducts() {
//        Product product = 1;
//        List<ShoppingBag> expectedShoppingBag = Collections.singletonList(makeShoppingBag());
//        when(service.findAllByShoppingBagProducts(product)).thenReturn(expectedShoppingBag);
//        List<ShoppingBag> actualShoppingBag = controller.findAllByShoppingBagProducts(product);
//        assertEquals(expectedShoppingBag, actualShoppingBag);
//    }
//
//    public Product makeProduct(){
//        return new Product(1,"Scarpin","Material sem origem animal", 300.0, 36,
//                1, "Preto", "Salto", "Arezzo",
//                LocalDate.of(2024, 1, 23));
//    }
//
//    public ShoppingBag makeShoppingBag(Set<Product> products){
//        Product product = makeProduct();
//        products.add(product);
//        return new ShoppingBag(1, products, 100.0, 0.0);
//    }
//
//}
