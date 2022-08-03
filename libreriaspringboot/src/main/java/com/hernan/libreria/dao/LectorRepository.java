package com.hernan.libreria.dao;

import com.hernan.libreria.model.Lector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectorRepository extends JpaRepository<Lector, Long> {
    //User findByUsername(String username);
}
