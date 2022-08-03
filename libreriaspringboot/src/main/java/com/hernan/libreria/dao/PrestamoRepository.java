package com.hernan.libreria.dao;

import com.hernan.libreria.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
    //User findByUsername(String username);
}
