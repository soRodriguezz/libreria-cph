package com.hernan.libreria.controller;

import com.hernan.libreria.dao.LibroRepository;
import com.hernan.libreria.model.Libro;
import com.hernan.libreria.model.LibroTotal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/libro")
@CrossOrigin
public class LibroRestController {

    @Autowired
    private LibroRepository libroRepository;


    @RequestMapping(method = RequestMethod.GET)
    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    @GetMapping("/{id}")
    public Libro findLibroById(@PathVariable Long id) {
        return libroRepository.findLibroById(id);
    }

    @PutMapping("/")
    public Libro updateById(@RequestBody Libro libro) {
        return libroRepository.save(libro);
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public List<LibroTotal> findAll() {
//        List<LibroTotal> libroTotals = new ArrayList<>();
//        List<Libro> list = libroRepository.findAll();
//
//        for(Libro libro : list){
//            libroTotals.add(new LibroTotal(libro, libro.getCategoria(), libro.getAutor()));
//        }
//        return libroTotals;
//    }

	@RequestMapping(method = RequestMethod.POST)
    public Libro add(@RequestBody Libro libro) {
        return libroRepository.save(libro);
    }

	@RequestMapping(method = RequestMethod.PUT)
    public Libro update(@RequestBody Libro libro) {
        return libroRepository.save(libro);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        libroRepository.deleteById(id);
    }

	
}

