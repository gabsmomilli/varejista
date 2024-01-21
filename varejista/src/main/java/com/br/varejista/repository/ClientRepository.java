package com.br.varejista.repository;

import com.br.varejista.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query("SELECT c FROM Client c WHERE c.name like :name")
    List<Client> findAllByClientName(@Param("name") String name);
    @Query("SELECT c FROM Client c WHERE c.cpf like :cpf")
    List<Client> findAllByClientCpf(@Param("cpf") String cpf);

    @Query("SELECT c FROM Client c WHERE c.phone like :phone")
    List<Client> findAllByClientPhone(@Param("phone") String phone);

    @Query("SELECT c FROM Client c WHERE c.email like :email")
    List<Client> findAllByClientEmail(@Param("email") String email);

    @Query("SELECT c FROM Client c WHERE c.birth like :birth")
    List<Client> findAllByClientBirth(@Param("birth") LocalDate birth);

    @Query("SELECT c FROM Client c WHERE c.gender like :gender")
    List<Client> findAllByClientGender(@Param("gender") String gender);
}
