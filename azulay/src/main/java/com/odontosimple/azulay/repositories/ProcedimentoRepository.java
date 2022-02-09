package com.odontosimple.azulay.repositories;

import com.odontosimple.azulay.entities.Procedimento;
import com.odontosimple.azulay.entities.Tratamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedimentoRepository extends JpaRepository<Procedimento, Long> {

}
