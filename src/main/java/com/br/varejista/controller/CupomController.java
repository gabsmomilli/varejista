package com.br.varejista.controller;


import com.br.varejista.model.Cupom;
import com.br.varejista.service.CupomService;
import com.br.varejista.validator.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cupom")
public class CupomController {

    private final CupomService service;

    @Autowired
    public CupomController(CupomService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity saveNew(@RequestBody final Cupom newCupom) {
        Cupom savedCupom = service.save(newCupom, Operation.INSERT);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCupom);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{name}")
    public List<Cupom> findAllByCupomName(@PathVariable("name") String name){
        return service.findAllByCupomName(name);
    }

    @GetMapping("/{value}")
    public List<Cupom> findAllByCupomValue(@PathVariable("value") Double value){
        return service.findAllByCupomValue(value);
    }

    @GetMapping("/{description}")
    public List<Cupom> findAllByCupomDescription(@PathVariable("description") String description){
        return service.findAllByCupomDescription(description);
    }
}
