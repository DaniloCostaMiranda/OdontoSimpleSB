package com.odontosimple.azulay.resources;

import com.odontosimple.azulay.entities.Procedimento;
import com.odontosimple.azulay.entities.Tratamento;
import com.odontosimple.azulay.services.ProcedimentoService;
import com.odontosimple.azulay.services.TratamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/procedimentos")
public class ProcedimentoResource {

    @Autowired
    private ProcedimentoService service;

    @GetMapping
    public ResponseEntity<List<Procedimento>> findAll(){
        List<Procedimento> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Procedimento> findById(@PathVariable Long id) {
        Procedimento obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
