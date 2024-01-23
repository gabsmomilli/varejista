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
@Tag(name = "Client Controller", description = "Operações de clientes")
public class ClientController {

    private final ClientService service;

    @Autowired
    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(description = "Salvar um novo cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso", content = @Content(schema = @Schema(implementation = Client.class)))
    })
    public ResponseEntity saveNew(@RequestBody final Client newClient) {
        Client savedClient = service.save(newClient, com.br.varejista.validator.Operation.INSERT);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
    }

    @Operation(description = "Deletar um cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente deletado com sucesso", content = @Content(schema = @Schema(implementation = Client.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Operation(description = "Encontrar um cliente pelo nome")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrado com sucesso", content = @Content(schema = @Schema(implementation = Client.class)))
    })
    @GetMapping("/find-by-name/{name}")
    public List<Client> findAllByClientName(@PathVariable("name") String name){
        return service.findAllByClientName(name);
    }

    @Operation(description = "Encontrar um cliente pelo cpf")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrado com sucesso", content = @Content(schema = @Schema(implementation = Client.class)))
    })
    @GetMapping("/find-by-cpf/{cpf}")
    public List<Client> findAllByClientCpf(@PathVariable("cpf") String cpf){
        return service.findAllByClientCpf(cpf);
    }

    @Operation(description = "Encontrar um cliente pelo telefone")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrado com sucesso", content = @Content(schema = @Schema(implementation = Client.class)))
    })
    @GetMapping("/find-by-phone/{phone}")
    public List<Client> findAllByClientPhone(@PathVariable("phone") String phone){
        return service.findAllByClientPhone(phone);
    }

    @Operation(description = "Encontrar um cliente pelo email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrado com sucesso", content = @Content(schema = @Schema(implementation = Client.class)))
    })
    @GetMapping("/find-by-email/{email}")
    public List<Client> findAllByClientEmail(@PathVariable("email") String email){
        return service.findAllByClientEmail(email);
    }

    @Operation(description = "Encontrar um cliente pela data de nascimento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrado com sucesso", content = @Content(schema = @Schema(implementation = Client.class)))
    })
    @GetMapping("/find-by-birth/{birth}")
    public List<Client> findAllByClientBirth(@PathVariable("birth") LocalDate birth){
        return service.findAllByClientBirth(birth);
    }

    @Operation(description = "Encontrar um cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrado com sucesso", content = @Content(schema = @Schema(implementation = Client.class)))
    })
    @GetMapping("/find-by-gender/{gender}")
    public List<Client> findAllByClientGender(@PathVariable("gender") String gender){
        return service.findAllByClientGender(gender);
    }
}
