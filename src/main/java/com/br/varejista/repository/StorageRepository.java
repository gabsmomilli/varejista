package com.br.varejista.repository;

import com.br.varejista.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StorageRepository extends JpaRepository<Storage, Integer> {

    @Query("SELECT s FROM Storage s JOIN s.products p WHERE :product MEMBER OF s.products")
    List<Storage> findAllByStorageProducts(@Param("product") Product product);


    @Query("SELECT c FROM Storage c WHERE c.cnpj like :cnpj")
    List<Storage> findAllByStorageCpnj(@Param("cnpj") String cnpj);

    @Query("SELECT c FROM Storage c WHERE c.franchise like :franchise")
    List<Storage> findAllByStorageFranchise(@Param("franchise") String franchise);

    @Query("SELECT c FROM Storage c WHERE c.address like :address")
    List<Storage> findAllByStorageAddress(@Param("address") String address);


}
