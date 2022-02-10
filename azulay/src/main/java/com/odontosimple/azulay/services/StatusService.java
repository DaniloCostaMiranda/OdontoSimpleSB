package com.odontosimple.azulay.services;

import com.odontosimple.azulay.entities.Status;
import com.odontosimple.azulay.entities.User;
import com.odontosimple.azulay.repositories.StatusRepository;
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


    public Status insert(Status obj) {
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

    public Status update(Long id, Status obj) {
        try {
            Status entity = repository.getOne(id);
            updateData(entity, obj);
            return repository.save(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Status entity, Status obj) {
        entity.setName(obj.getName());
    }
}
