package com.odontosimple.azulay.services;

import com.odontosimple.azulay.entities.Procedimento;
import com.odontosimple.azulay.entities.Status;
import com.odontosimple.azulay.entities.Tratamento;
import com.odontosimple.azulay.repositories.ProcedimentoRepository;
import com.odontosimple.azulay.repositories.TratamentoRepository;
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


    public Procedimento insert(Procedimento obj) {
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

    public Procedimento update(Long id, Procedimento obj) {
        try {
            Procedimento entity = repository.getOne(id);
            updateData(entity, obj);
            return repository.save(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Procedimento entity, Procedimento obj) {
        entity.setName(obj.getName());
        entity.setPrice(obj.getPrice());
    }
}
