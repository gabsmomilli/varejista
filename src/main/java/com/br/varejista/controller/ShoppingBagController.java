package com.br.varejista.controller;

import com.br.varejista.model.Client;
import com.br.varejista.model.Product;
import com.br.varejista.model.ShoppingBag;
import com.br.varejista.service.ShoppingBagService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/shopping_bag")
@Tag(name = "Shopping Bag Controller", description = "Shopping Bag operations")
public class ShoppingBagController {

    private final ShoppingBagService service;

    @Autowired
    public ShoppingBagController(ShoppingBagService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(description = "Save new shopping bag")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Shopping bag created sucessfully", content = @Content(schema = @Schema(implementation = Client.class)))
    })
    public ResponseEntity saveNew(@RequestBody final ShoppingBag newShoppingBag) {
        ShoppingBag savedShoppingBag = service.save(newShoppingBag, com.br.varejista.validator.Operation.INSERT);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedShoppingBag);
    }

    @Operation(description = "Delete shopping bag")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shopping bag deleted successfully", content = @Content(schema = @Schema(implementation = Client.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @Operation(description = "Find all products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Products successfully found", content = @Content(schema = @Schema(implementation = Client.class)))
    })
    @GetMapping("/find-all-products/{products}")
    public List<ShoppingBag> findAllByShoppingBagProducts(@PathVariable("products") Product products){
     return service.findAllByShoppingBagProducts(products);
    }

    @Operation(description = "Find client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client successfully found", content = @Content(schema = @Schema(implementation = Client.class)))
    })
    @GetMapping("/{clientId}")
        public List<ShoppingBag> findAllByClientId(@PathVariable("clientId") Integer clientId){
        return service.findAllByClientId(clientId);
    }
}
