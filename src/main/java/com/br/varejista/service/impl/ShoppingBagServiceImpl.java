package com.br.varejista.service.impl;

import com.br.varejista.model.Product;
import com.br.varejista.model.ShoppingBag;
import com.br.varejista.repository.ShoppingBagRepository;
import com.br.varejista.service.ShoppingBagService;
import com.br.varejista.validator.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ShoppingBagServiceImpl implements ShoppingBagService {

    private final ShoppingBagRepository repository;

    @Autowired
    public ShoppingBagServiceImpl(ShoppingBagRepository repository) {
        this.repository = repository;
    }

    @Override
    public ShoppingBag save(final ShoppingBag shoppingBag, Operation operation) {
        return repository.saveAndFlush(shoppingBag);
    }

    @Override
    public void delete(Integer id) {

        repository.deleteById(id);
    }

    @Override
    public void deleteByClientId(Integer id) {
        repository.findAllByClientId(id);
    }

    @Override
    public List<ShoppingBag> findAllByShoppingBagProducts(Product products) {
        return repository.findAllByShoppingBagProducts(products);
    }

    @Override
    public List<ShoppingBag> findAllByClientId(Integer clientId) {
        return repository.findAllByClientId(clientId);
    }
}
