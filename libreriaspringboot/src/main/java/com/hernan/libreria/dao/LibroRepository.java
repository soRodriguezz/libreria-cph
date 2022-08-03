package com.hernan.libreria.dao;

import com.hernan.libreria.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public interface LibroRepository extends JpaRepository<Libro, Long> {
    //User findByUsername(String username);

    List<Libro> findAll();

    Libro findLibroById(Long id);

    void deleteById(Long id);

}
