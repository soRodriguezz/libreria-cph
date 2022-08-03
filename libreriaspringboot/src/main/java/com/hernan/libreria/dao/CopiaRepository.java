package com.hernan.libreria.dao;

import com.hernan.libreria.model.Copia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CopiaRepository extends JpaRepository<Copia, Long> {
    //User findByUsername(String username);
}
