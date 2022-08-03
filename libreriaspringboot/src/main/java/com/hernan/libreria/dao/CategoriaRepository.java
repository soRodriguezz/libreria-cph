package com.hernan.libreria.dao;

import com.hernan.libreria.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    //User findByUsername(String username);
}
