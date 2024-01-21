package com.br.varejista.repository;

import com.br.varejista.model.Employee;
import com.br.varejista.model.Product;
import com.br.varejista.model.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StorageRepository extends JpaRepository<Storage, Integer> {

    @Query("SELECT c FROM Storage c WHERE c.products like :products")
    List<Storage> findAllByStorageProducts(@Param("products") Product products);

    @Query("SELECT c FROM Storage c WHERE c.employees like :employees")
    List<Storage> findAllByStorageEmployee(@Param("products") Employee employees);

    @Query("SELECT c FROM Storage c WHERE c.cpnj like :cpnj")
    List<Storage> findAllByStorageCpnj(@Param("cpnj") String cpnj);

    @Query("SELECT c FROM Storage c WHERE c.franchise like :franchise")
    List<Storage> findAllByStorageFranchise(@Param("franchise") String franchise);

    @Query("SELECT c FROM Storage c WHERE c.address like :address")
    List<Storage> findAllByStorageAddress(@Param("address") String address);


}
