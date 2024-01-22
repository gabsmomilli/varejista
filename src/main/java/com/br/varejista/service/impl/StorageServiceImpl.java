package com.br.varejista.service.impl;

import com.br.varejista.model.Employee;
import com.br.varejista.model.Product;
import com.br.varejista.model.Storage;
import com.br.varejista.repository.StorageRepository;
import com.br.varejista.service.StorageService;
import com.br.varejista.validator.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StorageServiceImpl implements StorageService {

    private final StorageRepository repository;

    @Autowired
    public StorageServiceImpl(StorageRepository repository) {
        this.repository = repository;
    }

    @Override
    public Storage save(final Storage storage, Operation operation) {
        return repository.saveAndFlush(storage);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Storage> findAllByStorageProducts(Product products) {
        return repository.findAllByStorageProducts(products);
    }

    @Override
    public List<Storage> findAllByStorageEmployees(Employee employees) {
        return repository.findAllByStorageEmployees(employees);
    }

    @Override
    public List<Storage> findAllByStorageCnpj(String cnpj) {
        return repository.findAllByStorageCpnj(cnpj);
    }

    @Override
    public List<Storage> findAllByStorageFranchise(String franchise) {
        return repository.findAllByStorageFranchise(franchise);
    }

    @Override
    public List<Storage> findAllByStorageAddress(String address) {
        return repository.findAllByStorageAddress(address);
    }
}
