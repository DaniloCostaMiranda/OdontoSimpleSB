package com.odontosimple.azulay.resources;

import com.odontosimple.azulay.entities.Tratamento;
import com.odontosimple.azulay.entities.User;
import com.odontosimple.azulay.services.TratamentoService;
import com.odontosimple.azulay.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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


    @PostMapping
    public ResponseEntity<Tratamento> insert(@RequestBody Tratamento obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Tratamento> update(@PathVariable Long id, @RequestBody Tratamento obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
