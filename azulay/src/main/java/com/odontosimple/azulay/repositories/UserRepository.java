package com.odontosimple.azulay.repositories;

import com.odontosimple.azulay.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
