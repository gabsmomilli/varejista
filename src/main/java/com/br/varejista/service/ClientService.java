package com.br.varejista.service;

import com.br.varejista.model.Client;

import java.time.LocalDate;
import java.util.List;

public interface ClientService extends GenericService<Client>{


    List<Client> findAllByClientName(final String name);

    List<Client> findAllByClientCpf(final String cpf);

    List<Client> findAllByClientPhone(final String phone);

    List<Client> findAllByClientEmail(final String email);

    List<Client> findAllByClientBirth(final LocalDate birth);

    List<Client> findAllByClientGender(final String gender);

}
