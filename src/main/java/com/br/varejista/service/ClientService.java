package com.br.varejista.service;

import com.br.varejista.model.Client;
import com.br.varejista.model.Cupom;
import com.br.varejista.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

public interface ClientService extends GenericService<Client>{


    List<Client> findAllByClientName(final String name);

    List<Client> findAllByClientCpf(final String cpf);

    List<Client> findAllByClientPhone(final String phone);

    List<Client> findAllByClientEmail(final String email);

    List<Client> findAllByClientBirth(final LocalDate birth);

    List<Client> findAllByClientGender(final String gender);

    List<Client> findAllByClientCupom(final Cupom cupom);

    void addCoupon(Integer clientId, Cupom newCupomId);
}
