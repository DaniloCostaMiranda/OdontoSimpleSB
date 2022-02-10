package com.odontosimple.azulay.resources;

import com.odontosimple.azulay.entities.Status;
import com.odontosimple.azulay.entities.User;
import com.odontosimple.azulay.services.StatusService;
import com.odontosimple.azulay.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/status")
public class StatusResource {

    @Autowired
    private StatusService service;

    @GetMapping
    public ResponseEntity<List<Status>> findAll(){
        List<Status> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Status> findById(@PathVariable Long id) {
        Status obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }


    @PostMapping
    public ResponseEntity<Status> insert(@RequestBody Status obj) {
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
    public ResponseEntity<Status> update(@PathVariable Long id, @RequestBody Status obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
