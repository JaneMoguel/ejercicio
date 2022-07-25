package com.example.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Persona;
import com.example.demo.repository.PersonaRepository;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    
	@Autowired
	PersonaRepository repository ;
	
    @GetMapping(value="/obtener/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Persona> obtenerPersonas() {
    	Collection<Persona> mod = repository.findAll();
        return mod;
    }
    
    
    



}
