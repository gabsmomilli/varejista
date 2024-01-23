package com.br.varejista.controller;

import com.br.varejista.model.Client;
import com.br.varejista.service.ClientService;
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

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class ClientControllerTest {
    @Mock
    private ClientService clientService;

    @InjectMocks
    private ClientController clientController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(ClientControllerTest.class);
    }

    @Test
    void saveNew() {
        Client client = makeClient();
        when(clientService.save(client, com.br.varejista.validator.Operation.INSERT)).thenReturn(client);
        ResponseEntity response = clientController.saveNew(client);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(client, response.getBody());
    }

    @Test
    void delete() {
        ResponseEntity response = clientController.delete(1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        Mockito.verify(clientService, times(1)).delete(1);
    }

    @Test
    void findAllByClientName() {
        String name = "Gabi";
        List<Client> expectedClients = Collections.singletonList(makeClient());
        when(clientService.findAllByClientName(name)).thenReturn(expectedClients);
        List<Client> actualClients = clientController.findAllByClientName(name);
        assertEquals(expectedClients, actualClients);
    }

    @Test
    void findAllByClientCpf() {
        String cpf = "1234567890";
        List<Client> expectedClients = Collections.singletonList(makeClient());
        when(clientService.findAllByClientCpf(cpf)).thenReturn(expectedClients);
        List<Client> actualClients = clientController.findAllByClientCpf(cpf);
        assertEquals(expectedClients, actualClients);
    }

    @Test
    void findAllByClientPhone() {
        String phone = "1298121312";
        List<Client> expectedClients = Collections.singletonList(makeClient());
        when(clientService.findAllByClientPhone(phone)).thenReturn(expectedClients);
        List<Client> actualClients = clientController.findAllByClientPhone(phone);
        assertEquals(expectedClients, actualClients);
    }

    @Test
    void findAllByClientEmail() {
        String email = "gabsmomilli@gmail.com";
        List<Client> expectedClients = Collections.singletonList(makeClient());
        when(clientService.findAllByClientPhone(email)).thenReturn(expectedClients);
        List<Client> actualClients = clientController.findAllByClientPhone(email);
        assertEquals(expectedClients, actualClients);
    }

    @Test
    void findAllByClientBirth() {
        LocalDate birth = LocalDate.now();
        List<Client> expectedClients = Collections.singletonList(makeClient());
        when(clientService.findAllByClientBirth(birth)).thenReturn(expectedClients);
        List<Client> actualClients = clientController.findAllByClientBirth(birth);
        assertEquals(expectedClients, actualClients);
    }

    @Test
    void findAllByClientGender() {
        String gender = "F";
        List<Client> expectedClients = Collections.singletonList(makeClient());
        when(clientService.findAllByClientGender(gender)).thenReturn(expectedClients);
        List<Client> actualClients = clientController.findAllByClientGender(gender);
        assertEquals(expectedClients, actualClients);
    }


    public Client makeClient(){
        return new Client(1,"Gabi","1234567890","129813245","gabsmomilli@gmail.com", LocalDate.now(), "F");
    }
}