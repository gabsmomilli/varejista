package com.br.varejista.service.impl;

import com.br.varejista.repository.ClientRepository;
import com.br.varejista.service.ClientService;
import com.br.varejista.validator.Operation;
import com.br.varejista.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    @Autowired
    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Client save(final Client client, Operation operation) {
        return repository.saveAndFlush(client);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Client> findAllByClientName(String name) {
        return repository.findAllByClientName(name);
    }

    @Override
    public List<Client> findAllByClientCpf(String cpf) {
        return repository.findAllByClientCpf(cpf);
    }

    @Override
    public List<Client> findAllByClientPhone(String phone) {
        return repository.findAllByClientPhone(phone);
    }

    @Override
    public List<Client> findAllByClientEmail(String email) {
        return repository.findAllByClientEmail(email);
    }

    @Override
    public List<Client> findAllByClientBirth(LocalDate birth) {
        return repository.findAllByClientBirth(birth);
    }

    public List<Client> findAllByClientGender(String gender) {
        return repository.findAllByClientGender(gender);
    }

}
