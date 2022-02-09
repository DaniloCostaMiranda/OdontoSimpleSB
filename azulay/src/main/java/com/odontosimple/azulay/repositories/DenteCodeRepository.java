package com.odontosimple.azulay.repositories;

import com.odontosimple.azulay.entities.DenteCode;
import com.odontosimple.azulay.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DenteCodeRepository extends JpaRepository<DenteCode, Long> {

}
