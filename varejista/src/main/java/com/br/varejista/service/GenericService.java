package com.br.varejista.service;

import com.br.varejista.validator.Operation;

public interface GenericService<T>{
    T save(T t, Operation operation);

    void delete(final Integer id);
}