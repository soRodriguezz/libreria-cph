package com.hernan.libreria.dao;

import com.hernan.libreria.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    //User findByUsername(String username);
}
