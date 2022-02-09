package com.odontosimple.azulay.services;

import com.odontosimple.azulay.entities.Procedimento;
import com.odontosimple.azulay.entities.Tratamento;
import com.odontosimple.azulay.repositories.ProcedimentoRepository;
import com.odontosimple.azulay.repositories.TratamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProcedimentoService {

    @Autowired
    private ProcedimentoRepository repository;

    public List<Procedimento> findAll(){
        return repository.findAll();
    }

    public Procedimento findById(Long id) {
        Optional<Procedimento> obj = repository.findById(id);
        return obj.get();
    }
}
