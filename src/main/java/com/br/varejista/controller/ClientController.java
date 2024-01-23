package com.br.varejista.controller;

import com.br.varejista.model.Client;
import com.br.varejista.service.ClientService;
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

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/client")
@Tag(name = "Client Controller", description = "Client operations")
public class ClientController {

    private final ClientService service;

    @Autowired
    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(description = "Save new client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Client created sucessfully", content = @Content(schema = @Schema(implementation = Client.class)))
    })
    public ResponseEntity saveNew(@RequestBody final Client newClient) {
        Client savedClient = service.save(newClient, com.br.varejista.validator.Operation.INSERT);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
    }

    @Operation(description = "Delete client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client deleted successfully", content = @Content(schema = @Schema(implementation = Client.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Operation(description = "Find client by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client successfully found", content = @Content(schema = @Schema(implementation = Client.class)))
    })
    @GetMapping("/find-by-name/{name}")
    public List<Client> findAllByClientName(@PathVariable("name") String name){
        return service.findAllByClientName(name);
    }

    @Operation(description = "Find client by cpf")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client successfully found", content = @Content(schema = @Schema(implementation = Client.class)))
    })
    @GetMapping("/find-by-cpf/{cpf}")
    public List<Client> findAllByClientCpf(@PathVariable("cpf") String cpf){
        return service.findAllByClientCpf(cpf);
    }

    @Operation(description = "Find client by phone")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client successfully found", content = @Content(schema = @Schema(implementation = Client.class)))
    })
    @GetMapping("/find-by-phone/{phone}")
    public List<Client> findAllByClientPhone(@PathVariable("phone") String phone){
        return service.findAllByClientPhone(phone);
    }

    @Operation(description = "Find client by email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client successfully found", content = @Content(schema = @Schema(implementation = Client.class)))
    })
    @GetMapping("/find-by-email/{email}")
    public List<Client> findAllByClientEmail(@PathVariable("email") String email){
        return service.findAllByClientEmail(email);
    }

    @Operation(description = "Find client by birth")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client successfully found", content = @Content(schema = @Schema(implementation = Client.class)))
    })
    @GetMapping("/find-by-birth/{birth}")
    public List<Client> findAllByClientBirth(@PathVariable("birth") LocalDate birth){
        return service.findAllByClientBirth(birth);
    }

    @Operation(description = "Find client by gender")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client successfully found", content = @Content(schema = @Schema(implementation = Client.class)))
    })
    @GetMapping("/find-by-gender/{gender}")
    public List<Client> findAllByClientGender(@PathVariable("gender") String gender){
        return service.findAllByClientGender(gender);
    }
}
