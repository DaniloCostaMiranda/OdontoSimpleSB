package com.odontosimple.azulay.resources;

import com.odontosimple.azulay.entities.DenteCode;
import com.odontosimple.azulay.entities.Status;
import com.odontosimple.azulay.services.DenteCodeService;
import com.odontosimple.azulay.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
