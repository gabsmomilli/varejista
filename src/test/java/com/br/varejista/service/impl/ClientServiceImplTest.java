package com.br.varejista.service.impl;

import com.br.varejista.model.Client;
import com.br.varejista.repository.ClientRepository;
import com.br.varejista.Utils;
import com.br.varejista.validator.Operation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClientServiceImplTest extends Utils {

    @Mock
    private ClientRepository repository;

    @InjectMocks
    private ClientServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(ClientServiceImplTest.class);
    }

    @Test
    void save() {

        when(repository.saveAndFlush(any())).thenReturn(makeClient());
        Client savedClient = service.save(any(), Operation.INSERT);
        assertNotNull(savedClient);
        assertEquals(makeClient(), savedClient);
        verify(repository, times(1)).saveAndFlush(any());
    }

    @Test
    void delete() {
        service.delete(any());
        verify(repository, times(1)).deleteById(any());
    }

    @Test
    void findAllByClientName() {
        when(repository.findAllByClientName(any())).thenReturn(Arrays.asList(makeClient()));
        List<Client> clients = service.findAllByClientName(any());
        assertNotNull(clients);
        assertFalse(clients.isEmpty());
        verify(repository, times(1)).findAllByClientName(any());
    }

    @Test
    void findAllByClientCpf() {
        when(repository.findAllByClientCpf(any())).thenReturn(Arrays.asList(makeClient()));
        List<Client> clients = service.findAllByClientCpf(any());
        assertNotNull(clients);
        assertFalse(clients.isEmpty());
        verify(repository, times(1)).findAllByClientCpf(any());
    }

    @Test
    void findAllByClientPhone() {
        when(repository.findAllByClientPhone(any())).thenReturn(Arrays.asList(makeClient()));
        List<Client> clients = service.findAllByClientPhone(any());
        assertNotNull(clients);
        assertFalse(clients.isEmpty());
        verify(repository, times(1)).findAllByClientPhone(any());
    }

    @Test
    void findAllByClientEmail() {
        when(repository.findAllByClientEmail(any())).thenReturn(Arrays.asList(makeClient()));
        List<Client> clients = service.findAllByClientEmail(any());
        assertNotNull(clients);
        assertFalse(clients.isEmpty());
        verify(repository, times(1)).findAllByClientEmail(any());
    }

    @Test
    void findAllByClientBirth() {
        when(repository.findAllByClientBirth(any())).thenReturn(Arrays.asList(makeClient()));
        List<Client> clients = service.findAllByClientBirth(any());
        assertNotNull(clients);
        assertFalse(clients.isEmpty());
        verify(repository, times(1)).findAllByClientBirth(any());
    }

    @Test
    void findAllByClientGender() {
        when(repository.findAllByClientGender(any())).thenReturn(Arrays.asList(makeClient()));
        List<Client> clients = service.findAllByClientGender(any());
        assertNotNull(clients);
        assertFalse(clients.isEmpty());
        verify(repository, times(1)).findAllByClientGender(any());
    }
}