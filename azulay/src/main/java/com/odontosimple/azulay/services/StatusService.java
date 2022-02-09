package com.odontosimple.azulay.services;

import com.odontosimple.azulay.entities.Status;
import com.odontosimple.azulay.entities.User;
import com.odontosimple.azulay.repositories.StatusRepository;
import com.odontosimple.azulay.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {

    @Autowired
    private StatusRepository repository;

    public List<Status> findAll(){
        return repository.findAll();
    }

    public Status findById(Long id) {
        Optional<Status> obj = repository.findById(id);
        return obj.get();
    }
}
