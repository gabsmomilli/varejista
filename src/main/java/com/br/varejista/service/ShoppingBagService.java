package com.br.varejista.service;

import com.br.varejista.model.Product;
import com.br.varejista.model.ShoppingBag;

import java.util.List;

public interface ShoppingBagService extends GenericService<ShoppingBag>{

    void deleteByClientId(final Integer id);

    List<ShoppingBag> findAllByShoppingBagProducts(final Product product);

    List<ShoppingBag> findAllByClientId(final Integer clientId);
}
