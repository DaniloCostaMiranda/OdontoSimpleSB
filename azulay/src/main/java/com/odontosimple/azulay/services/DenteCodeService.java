package com.odontosimple.azulay.services;

import com.odontosimple.azulay.entities.DenteCode;
import com.odontosimple.azulay.entities.Status;
import com.odontosimple.azulay.repositories.DenteCodeRepository;
import com.odontosimple.azulay.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DenteCodeService {

    @Autowired
    private DenteCodeRepository repository;

    public List<DenteCode> findAll(){
        return repository.findAll();
    }

    public DenteCode findById(Long id) {
        Optional<DenteCode> obj = repository.findById(id);
        return obj.get();
    }
}
