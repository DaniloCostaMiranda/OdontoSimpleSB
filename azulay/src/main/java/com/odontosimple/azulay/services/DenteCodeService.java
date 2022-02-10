package com.odontosimple.azulay.services;

import com.odontosimple.azulay.entities.DenteCode;
import com.odontosimple.azulay.entities.Status;
import com.odontosimple.azulay.entities.User;
import com.odontosimple.azulay.repositories.DenteCodeRepository;
import com.odontosimple.azulay.repositories.StatusRepository;
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

    public DenteCode insert(DenteCode obj) {
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

    public DenteCode update(Long id, DenteCode obj) {
        try {
            DenteCode entity = repository.getOne(id);
            updateData(entity, obj);
            return repository.save(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(DenteCode entity, DenteCode obj) {
        entity.setNumber(obj.getNumber());
        entity.setName(obj.getName());
    }
}
