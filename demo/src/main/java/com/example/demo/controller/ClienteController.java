package com.example.demo.controller;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Cliente;
import com.example.demo.Entity.Persona;
import com.example.demo.exception.NFException;
import com.example.demo.objetos.Mensaje;
import com.example.demo.objetos.Usuario;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.PersonaRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
	@Autowired
	ClienteRepository repository ;
	@Autowired
	PersonaRepository repositoryp;
	
    @GetMapping(value="/obtener/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Cliente> obtenerClientes() {
    	Collection<Cliente> mod = repository.findAll();
        return mod;
    }
    
    @GetMapping(value="/obtener/cliente/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuario obtenerClientes(@PathVariable int id) {
    	Persona p = new Persona();
    	Cliente c = new Cliente();
    	Usuario usr= new Usuario();
    	Optional<Cliente> cl = repository.findById(id);
    	if(cl.isPresent()) {
    		usr.setDireccion(cl.get().getPersona().getDireccion());
	    	usr.setEdad(cl.get().getPersona().getEdad());
	    	usr.setGenero(cl.get().getContraseña());
	    	usr.setIdentificacion(cl.get().getPersona().getIdentificacion());
	    	usr.setNombre(cl.get().getPersona().getNombre());
	    	usr.setTelefono(cl.get().getPersona().getTelefono());
	    	usr.setContraseña(cl.get().getContraseña());
	    	usr.setEstado(cl.get().getEstado());
	    	usr.setIdCliente(cl.get().getIdcliente());
	    	usr.setIdPersona(cl.get().getPersona().getIdpersona());
    	}
    	return usr;
    }
    
    
    @PostMapping(value="/crear/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mensaje crearCliente(@RequestBody Usuario usr) {
    	Persona p = new Persona();
    	Cliente c = new Cliente();
    	Mensaje mensaje = new Mensaje();
    	mensaje.setFecha(new Date());
    	try {
	    	p.setDireccion(usr.getDireccion());
	    	p.setEdad(usr.getEdad());
	    	p.setGenero(usr.getContraseña());
	    	p.setIdentificacion(usr.getIdentificacion());
	    	p.setNombre(usr.getNombre());
	    	p.setTelefono(usr.getTelefono());
	    	p = repositoryp.save(p);
	    	c.setContraseña(usr.getContraseña());
	    	c.setEstado(usr.getEstado());
	    	c.setPersona(p);
	    	c=repository.save(c);
	    	usr.setIdCliente(c.getIdcliente());
	    	usr.setIdPersona(p.getIdpersona());
	    	mensaje.setMsj("Cliente creado");
    	}catch(NFException ex) {
    		mensaje.setMsj(ex.toString());
    	}
    	return mensaje;
    }
    
    @PutMapping(value="/actualizar/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mensaje actualizarCliente(@RequestBody Usuario usr) {
    	Optional<Persona> p ;
    	Optional<Cliente> c ;
    	Mensaje mensaje = new Mensaje();
    	mensaje.setFecha(new Date());
    	try {
    		p = repositoryp.findById(usr.getIdPersona());
    		if(p.isPresent()) {
    			p.get().setDireccion(usr.getDireccion());
    	    	p.get().setEdad(usr.getEdad());
    	    	p.get().setGenero(usr.getContraseña());
    	    	p.get().setIdentificacion(usr.getIdentificacion());
    	    	p.get().setNombre(usr.getNombre());
    	    	p.get().setTelefono(usr.getTelefono());
    	    	repositoryp.save(p.get());
    	    	c = repository.findById(usr.getIdCliente());
    	    	if(c.isPresent()) {
    	    		c.get().setContraseña(usr.getContraseña());
    	    		c.get().setEstado(usr.getEstado());
        	    	repository.save(c.get());
        	    	usr.setIdCliente(c.get().getIdcliente());
        	    	usr.setIdPersona(p.get().getIdpersona());
    	    	}
    	    	
    	    	mensaje.setMsj("Cliente actualizado");
    		}else {
    			mensaje.setMsj("No existe el cliente");
    		}
    	}catch(NFException ex) {
    		mensaje.setMsj(ex.toString());
    	}
    	
    	return mensaje;
    }
    
    @DeleteMapping(value="/borrar/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mensaje borrarCliente(@RequestBody Usuario usr) {
    	Optional<Persona> p;
    	Optional<Cliente> c;
    	Mensaje mensaje = new Mensaje();
    	mensaje.setFecha(new Date());
    	try {
    		p = repositoryp.findById(usr.getIdPersona());
    		if(p.isPresent()) {
    			c = repository.findById(usr.getIdCliente());
    			if(c.isPresent())
    				repository.delete(c.get());
    			repositoryp.delete(p.get());
    		}
	    	mensaje.setMsj("Cliente eliminado");
    	}catch(NFException ex) {
    		mensaje.setMsj(ex.toString());
    	}
    	
    	return mensaje;
    }
    
    
    
    
    



}
