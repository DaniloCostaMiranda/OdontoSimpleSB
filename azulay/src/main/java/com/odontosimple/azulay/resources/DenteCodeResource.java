package com.odontosimple.azulay.resources;

import com.odontosimple.azulay.entities.DenteCode;
import com.odontosimple.azulay.entities.Procedimento;
import com.odontosimple.azulay.entities.Status;
import com.odontosimple.azulay.services.DenteCodeService;
import com.odontosimple.azulay.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/dentecodes")
public class DenteCodeResource {

    @Autowired
    private DenteCodeService service;

    @GetMapping
    public ResponseEntity<List<DenteCode>> findAll(){
        List<DenteCode> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DenteCode> findById(@PathVariable Long id) {
        DenteCode obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }


    @PostMapping
    public ResponseEntity<DenteCode> insert(@RequestBody DenteCode obj) {
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
    public ResponseEntity<DenteCode> update(@PathVariable Long id, @RequestBody DenteCode obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
