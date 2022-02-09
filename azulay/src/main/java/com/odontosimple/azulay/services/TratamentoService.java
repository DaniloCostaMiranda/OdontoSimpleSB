package com.odontosimple.azulay.services;

import com.odontosimple.azulay.entities.Tratamento;
import com.odontosimple.azulay.entities.User;
import com.odontosimple.azulay.repositories.TratamentoRepository;
import com.odontosimple.azulay.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TratamentoService {

    @Autowired
    private TratamentoRepository repository;

    public List<Tratamento> findAll(){
        return repository.findAll();
    }

    public Tratamento findById(Long id) {
        Optional<Tratamento> obj = repository.findById(id);
        return obj.get();
    }
}
