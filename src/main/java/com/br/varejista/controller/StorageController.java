package com.br.varejista.controller;

import com.br.varejista.model.Employee;
import com.br.varejista.model.Product;
import com.br.varejista.model.Storage;
import com.br.varejista.service.StorageService;
import com.br.varejista.validator.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/storage")
public class StorageController {

    private final StorageService service;

    @Autowired
    public StorageController(StorageService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity saveNew(@RequestBody final Storage newStorage) {
        Storage savedStorage = service.save(newStorage, Operation.INSERT);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStorage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/find-all-products/{products}")
    public List<Storage> findAllByStorageProducts(@PathVariable("products") Product products){
        return service.findAllByStorageProducts(products);
    }

    @GetMapping("/find-all-employees/{employees}")
    public List<Storage> findAllByStorageEmployees(@PathVariable("employees") Employee employees){
        return service.findAllByStorageEmployees(employees);
    }

    @GetMapping("/find-by-cnpj/{cnpj}")
    public List<Storage> findAllByStorageCnpj(@PathVariable("cnpj") String cnpj){
        return service.findAllByStorageCnpj(cnpj);
    }

    @GetMapping("/find-by-franchise/{franchise}")
    public List<Storage> findAllByStorageFranchise(@PathVariable("franchise") String franchise){
        return service.findAllByStorageFranchise(franchise);
    }

    @GetMapping("/find-by-address/{address}")
    public List<Storage> findAllByStorageAddress(@PathVariable("address") String address){
        return service.findAllByStorageAddress(address);
    }
}
