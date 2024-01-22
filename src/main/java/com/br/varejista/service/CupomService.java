package com.br.varejista.service;

import com.br.varejista.model.Cupom;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CupomService extends GenericService<Cupom>{

    List<Cupom> findAllByCupomName(final String name);

    List<Cupom> findAllByCupomValue(final Double value);

    List<Cupom> findAllByCupomDescription(final String description);

}
