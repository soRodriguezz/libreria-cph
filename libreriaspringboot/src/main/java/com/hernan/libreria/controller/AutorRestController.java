package com.hernan.libreria.controller;

import com.hernan.libreria.dao.AutorRepository;
import com.hernan.libreria.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/autor")
@CrossOrigin
public class AutorRestController {

    @Autowired
    private AutorRepository autorRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Autor> findAll() {
        return autorRepository.findAll();
    }
    

    
	@RequestMapping(method = RequestMethod.POST)
    public Autor add(@RequestBody Autor autor) {
        return autorRepository.save(autor);
    }

	@RequestMapping(method = RequestMethod.PUT)
    public Autor update(@RequestBody Autor autor) {
        return autorRepository.save(autor);
    }
	
}

