package com.hernan.libreria.controller;

import com.hernan.libreria.dao.CategoriaRepository;
import com.hernan.libreria.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/categoria")
@CrossOrigin
public class CategoriaRestController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }
    

    
	@RequestMapping(method = RequestMethod.POST)
    public Categoria add(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

	@RequestMapping(method = RequestMethod.PUT)
    public Categoria update(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
	
	
	
}

