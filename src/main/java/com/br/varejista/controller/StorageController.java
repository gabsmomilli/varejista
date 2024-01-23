package com.br.varejista.controller;

import com.br.varejista.model.Client;
import com.br.varejista.model.Product;
import com.br.varejista.model.Storage;
import com.br.varejista.service.StorageService;
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
@RequestMapping("/storage")
@Tag(name = "Storage Controller", description = "Storage operations")
public class StorageController {

    private final StorageService service;

    @Autowired
    public StorageController(StorageService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(description = "Save new storage")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Storage created sucessfully", content = @Content(schema = @Schema(implementation = Client.class)))
    })
    public ResponseEntity saveNew(@RequestBody final Storage newStorage) {
        Storage savedStorage = service.save(newStorage, com.br.varejista.validator.Operation.INSERT);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStorage);
    }

    @Operation(description = "Delete storage")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Storage deleted successfully", content = @Content(schema = @Schema(implementation = Client.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Operation(description = "Find all products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Products of storage successfully found", content = @Content(schema = @Schema(implementation = Client.class)))
    })
    @GetMapping("/find-all-products/{products}")
    public List<Storage> findAllByStorageProducts(@PathVariable("products") Product products){
        return service.findAllByStorageProducts(products);
    }

    @Operation(description = "Find storage by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Storage successfully found", content = @Content(schema = @Schema(implementation = Client.class)))
    })
    @GetMapping("/find-by-name/{name}")
    public List<Storage> findAllByStorageName(@PathVariable("name") String name){
        return service.findAllByStorageName(name);
    }

    @Operation(description = "Find storage by cnpj")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Storage successfully found", content = @Content(schema = @Schema(implementation = Client.class)))
    })
    @GetMapping("/find-by-cnpj/{cnpj}")
    public List<Storage> findAllByStorageCnpj(@PathVariable("cnpj") String cnpj){
        return service.findAllByStorageCnpj(cnpj);
    }

    @Operation(description = "Find storage by franchise")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Storage successfully found", content = @Content(schema = @Schema(implementation = Client.class)))
    })
    @GetMapping("/find-by-franchise/{franchise}")
    public List<Storage> findAllByStorageFranchise(@PathVariable("franchise") String franchise){
        return service.findAllByStorageFranchise(franchise);
    }

    @Operation(description = "Find storage by address")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Storage successfully found", content = @Content(schema = @Schema(implementation = Client.class)))
    })
    @GetMapping("/find-by-address/{address}")
    public List<Storage> findAllByStorageAddress(@PathVariable("address") String address){
        return service.findAllByStorageAddress(address);
    }
}
