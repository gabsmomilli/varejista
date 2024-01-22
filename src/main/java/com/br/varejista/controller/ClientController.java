package com.br.varejista.controller;

import com.br.varejista.model.Client;
import com.br.varejista.model.Cupom;
import com.br.varejista.model.ShoppingBag;
import com.br.varejista.service.ClientService;
import com.br.varejista.validator.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService service;

    @Autowired
    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity saveNew(@RequestBody final Client newClient) {
        Client savedClient = service.save(newClient, Operation.INSERT);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{name}")
    public List<Client> findAllByClientName(@PathVariable("name") String name){
        return service.findAllByClientName(name);
    }

    @GetMapping("/{cpf}")
    public List<Client> findAllByClientCpf(@PathVariable("cpf") String cpf){
        return service.findAllByClientCpf(cpf);
    }

    @GetMapping("/{phone}")
    public List<Client> findAllByClientPhone(@PathVariable("phone") String phone){
        return service.findAllByClientPhone(phone);
    }

    @GetMapping("/{email}")
    public List<Client> findAllByClientEmail(@PathVariable("email") String email){
        return service.findAllByClientEmail(email);
    }

    @GetMapping("/{birth}")
    public List<Client> findAllByClientBirth(@PathVariable("birth") LocalDate birth){
        return service.findAllByClientBirth(birth);
    }

    @GetMapping("/{gender}")
    public List<Client> findAllByClientGender(@PathVariable("gender") String gender){
        return service.findAllByClientGender(gender);
    }

    @GetMapping("/{cupom}")
    public List<Client> findAllByClientCupom(@PathVariable("cupomId") Cupom cupomId){
        return service.findAllByClientCupom(cupomId);
    }

    @PutMapping("{clientId}/add-coupon")
    public ResponseEntity<?> addCoupon(@PathVariable Integer clientId, @RequestParam Cupom coupon){
        service.addCoupon(clientId, coupon);
        return ResponseEntity.status(HttpStatus.OK).body("coupon added successfully");
    }
}
