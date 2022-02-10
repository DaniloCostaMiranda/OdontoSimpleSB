package com.odontosimple.azulay.services;

import com.odontosimple.azulay.entities.Tratamento;
import com.odontosimple.azulay.entities.User;
import com.odontosimple.azulay.repositories.TratamentoRepository;
import com.odontosimple.azulay.repositories.UserRepository;
import com.odontosimple.azulay.services.exceptions.DatabaseException;
import com.odontosimple.azulay.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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


    public Tratamento insert(Tratamento obj) {
        return repository.save(obj);
    }

    public void delete(Long id){
        try {
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }catch(DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public Tratamento update(Long id, Tratamento obj) {
        try {
            Tratamento entity = repository.getOne(id);
            updateData(entity, obj);
            return repository.save(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Tratamento entity, Tratamento obj) {
        entity.setMoment(obj.getMoment());
        entity.setClient(obj.getClient());
        entity.setStatus(obj.getStatus());

    }
}
