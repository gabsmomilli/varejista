package com.br.varejista.controller;

import com.br.varejista.model.Storage;
import com.br.varejista.service.StorageService;
import com.br.varejista.Utils;
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

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StorageControllerTest extends Utils {

    @Mock
    private StorageService service;

    @InjectMocks
    private StorageController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(StorageControllerTest.class);
    }

    @Test
    void saveNew() {
        Storage storage = makeStorage(makeProducts());
        when(service.save(storage, com.br.varejista.validator.Operation.INSERT)).thenReturn(storage);
        ResponseEntity response = controller.saveNew(storage);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(storage, response.getBody());
    }

    @Test
    void delete() {
        ResponseEntity response = controller.delete(1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        Mockito.verify(service, times(1)).delete(1);
    }

    @Test
    void findAllByStorageProducts() {
        List<Storage> expectedStorage = Collections.singletonList(makeStorage(makeProducts()));
        when(service.findAllByStorageProducts(any())).thenReturn(expectedStorage);
        List<Storage> actualStorage = controller.findAllByStorageProducts(any());
        assertEquals(expectedStorage, actualStorage);
    }

    @Test
    void findAllByStorageCnpj() {
        List<Storage> expectedStorage = Collections.singletonList(makeStorage(makeProducts()));
        when(service.findAllByStorageCnpj(any())).thenReturn(expectedStorage);
        List<Storage> actualStorage = controller.findAllByStorageCnpj(any());
        assertEquals(expectedStorage, actualStorage);
    }

    @Test
    void findAllByStorageFranchise() {
        List<Storage> expectedStorage = Collections.singletonList(makeStorage(makeProducts()));
        when(service.findAllByStorageFranchise(any())).thenReturn(expectedStorage);
        List<Storage> actualStorage = controller.findAllByStorageFranchise(any());
        assertEquals(expectedStorage, actualStorage);
    }

    @Test
    void findAllByStorageAddress() {
        List<Storage> expectedStorage = Collections.singletonList(makeStorage(makeProducts()));
        when(service.findAllByStorageAddress(any())).thenReturn(expectedStorage);
        List<Storage> actualStorage = controller.findAllByStorageAddress(any());
        assertEquals(expectedStorage, actualStorage);
    }

    @Test
    void findAllByStorageName() {
        List<Storage> expectedStorage = Collections.singletonList(makeStorage(makeProducts()));
        when(service.findAllByStorageName(any())).thenReturn(expectedStorage);
        List<Storage> actualStorage = controller.findAllByStorageName(any());
        assertEquals(expectedStorage, actualStorage);
    }
}

