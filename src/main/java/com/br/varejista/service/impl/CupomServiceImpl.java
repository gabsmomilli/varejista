package com.br.varejista.service.impl;

import com.br.varejista.model.Cupom;
import com.br.varejista.repository.CupomRepository;
import com.br.varejista.service.CupomService;
import com.br.varejista.validator.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CupomServiceImpl implements CupomService {

    private final CupomRepository repository;

    @Autowired
    public CupomServiceImpl(CupomRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cupom save(final Cupom cupom, Operation operation) {
        try{
           return repository.saveAndFlush(cupom);
        }catch (RuntimeException exception){
            throw new RuntimeException();
        }
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Cupom> findAllByCupomName(String nome) {
        return repository.findAllByCupomName(nome);
    }

    @Override
    public List<Cupom> findAllByCupomValue(Double value) {
        return repository.findAllByCupomValue(value);
    }

    @Override
    public List<Cupom> findAllByCupomDescription(String description) {
        return repository.findAllByCupomDescription(description);
    }
}
