package com.odontosimple.azulay.resources;

import com.odontosimple.azulay.entities.Tratamento;
import com.odontosimple.azulay.entities.User;
import com.odontosimple.azulay.services.TratamentoService;
import com.odontosimple.azulay.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/tratamentos")
public class TratamentoResource {

    @Autowired
    private TratamentoService service;

    @GetMapping
    public ResponseEntity<List<Tratamento>> findAll(){
        List<Tratamento> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Tratamento> findById(@PathVariable Long id) {
        Tratamento obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
