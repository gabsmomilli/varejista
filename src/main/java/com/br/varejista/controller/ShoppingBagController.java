package com.br.varejista.controller;

import com.br.varejista.model.Client;
import com.br.varejista.model.Product;
import com.br.varejista.model.ShoppingBag;
import com.br.varejista.service.ShoppingBagService;
import com.br.varejista.validator.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/shopping_bag")
public class ShoppingBagController {

    private final ShoppingBagService service;

    @Autowired
    public ShoppingBagController(ShoppingBagService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity saveNew(@RequestBody final ShoppingBag newShoppingBag) {
        ShoppingBag savedShoppingBag = service.save(newShoppingBag, Operation.INSERT);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedShoppingBag);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/find-all-products/{products}")
    public List<ShoppingBag> findAllByShoppingBagProducts(@PathVariable("products") Product products){
     return service.findAllByShoppingBagProducts(products);
    }

    @GetMapping("/{clientId}")
        public List<ShoppingBag> findAllByClientId(@PathVariable("clientId") Integer clientId){
        return service.findAllByClientId(clientId);
    }
}
