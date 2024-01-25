package com.br.varejista.service.impl;

import com.br.varejista.Utils;
import com.br.varejista.model.Storage;
import com.br.varejista.repository.StorageRepository;
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
public class StorageServiceImplTest extends Utils  {

    @Mock
    private StorageRepository repository;

    @InjectMocks
    private StorageServiceImpl  service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(ProductServiceImplTest.class);
    }

    @Test
    void save() {
        when(repository.saveAndFlush(any())).thenReturn(makeStorage(makeProducts()));
        Storage storage = service.save(any(), Operation.INSERT);
        assertNotNull(storage);
        assertEquals(makeStorage(makeProducts()), storage);
        verify(repository, times(1)).saveAndFlush(any());
    }

    @Test
    void delete() {
        service.delete(any());
        verify(repository, times(1)).deleteById(any());
    }


    @Test
    void findAllByStorageProducts() {
        when(repository.findAllByStorageProducts(any())).thenReturn(Arrays.asList(makeStorage(makeProducts())));
        List<Storage> storages = service.findAllByStorageProducts(any());
        assertNotNull(storages);
        assertFalse(storages.isEmpty());
        verify(repository, times(1)).findAllByStorageProducts(any());
    }
    @Test
    void findAllByStorageName() {
        when(repository.findAllByStorageName(any())).thenReturn(Arrays.asList(makeStorage(makeProducts())));
        List<Storage> storages = service.findAllByStorageName(any());
        assertNotNull(storages);
        assertFalse(storages.isEmpty());
        verify(repository, times(1)).findAllByStorageName(any());
    }

    @Test
    void findAllByStorageCnpj() {
        when(repository.findAllByStorageCnpj(any())).thenReturn(Arrays.asList(makeStorage(makeProducts())));
        List<Storage> storages = service.findAllByStorageCnpj(any());
        assertNotNull(storages);
        assertFalse(storages.isEmpty());
        verify(repository, times(1)).findAllByStorageCnpj(any());
    }

    @Test
    void findAllByStorageFranchise() {
        when(repository.findAllByStorageFranchise(any())).thenReturn(Arrays.asList(makeStorage(makeProducts())));
        List<Storage> storages = service.findAllByStorageFranchise(any());
        assertNotNull(storages);
        assertFalse(storages.isEmpty());
        verify(repository, times(1)).findAllByStorageFranchise(any());
    }

    @Test
    void findAllByStorageAddress() {
        when(repository.findAllByStorageAddress(any())).thenReturn(Arrays.asList(makeStorage(makeProducts())));
        List<Storage> storages = service.findAllByStorageAddress(any());
        assertNotNull(storages);
        assertFalse(storages.isEmpty());
        verify(repository, times(1)).findAllByStorageAddress(any());
    }
}
