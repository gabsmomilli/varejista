package com.br.varejista.service;

import com.br.varejista.model.Employee;
import com.br.varejista.model.Product;
import com.br.varejista.model.Storage;

import java.util.List;

public interface StorageService extends GenericService<Storage>{

    List<Storage> findAllByStorageProducts(final Product product);

    List<Storage> findAllByStorageEmployees(final Employee employees);

    List<Storage> findAllByStorageCnpj(final String cnpj);

    List<Storage> findAllByStorageFranchise(final String franchise);

    List<Storage> findAllByStorageAddress(final String address);
}
