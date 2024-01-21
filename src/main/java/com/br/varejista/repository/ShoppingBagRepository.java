package com.br.varejista.repository;

import com.br.varejista.model.ShoppingBag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingBagRepository extends JpaRepository<ShoppingBag, Integer> {}
