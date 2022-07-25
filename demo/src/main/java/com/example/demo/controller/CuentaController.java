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
import com.example.demo.Entity.Cuenta;
import com.example.demo.exception.NFException;
import com.example.demo.objetos.CuentaO;
import com.example.demo.objetos.Mensaje;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.CuentaRepository;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {
    
	@Autowired
	ClienteRepository repository ;
	@Autowired
	CuentaRepository repositoryc;
	
    @GetMapping(value="/obtener/cuentas", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Cuenta> obtenerCuentas() {
    	Collection<Cuenta> mod = repositoryc.findAll();
        return mod;
    }
    
    @GetMapping(value="/obtener/cuenta/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Cuenta> obtenerCuenta(@PathVariable int id) {
    	return repositoryc.findById(id);
    }
    
    
    @PostMapping(value="/crear/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mensaje crearCuentas(@RequestBody CuentaO c) {
    	Mensaje mensaje = new Mensaje();
    	mensaje.setFecha(new Date());
    	Cuenta cr = new Cuenta();
    	Optional<Cliente> cl;
    	try {
    		cl = repository.findById(c.getIdcliente());
    		if(cl.isPresent()) {
    			cr.setCliente(cl.get());
    			cr.setEstado(c.getEstado());
    			cr.setNumero(c.getNumero());
    			cr.setSaldo(c.getSaldo());
    			cr.setTipo(c.getTipo());
    			repositoryc.save(cr);
    			mensaje.setMsj("Cuenta creada");
    		}else {
    			mensaje.setMsj("Cliente no existe");
    		}
	    	
	    	
    	}catch(NFException ex) {
    		mensaje.setMsj(ex.toString());
    	}
    	return mensaje;
    }
    
    @PutMapping(value="/actualizar/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mensaje actualizarCuentas(@RequestBody Cuenta c) {
    	Mensaje mensaje = new Mensaje();
    	mensaje.setFecha(new Date());
    	Optional<Cuenta> cr;
    	try {
    		cr=repositoryc.findById(c.getIdcuenta());
	    	if(cr.isPresent()) {
	    		repositoryc.save(c);
	    		mensaje.setMsj("Cuenta actualizada");
	    	}else {
	    		mensaje.setMsj("Cuenta inexistente");
	    	}
    	}catch(NFException ex) {
    		mensaje.setMsj(ex.toString());
    	}
    	
    	return mensaje;
    }
    
    @DeleteMapping(value="/borrar/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mensaje borrarCuentas(@RequestBody Cuenta c) {
    	Mensaje mensaje = new Mensaje();
    	mensaje.setFecha(new Date());
    	Optional<Cuenta> cr;
    	try {
    		cr = repositoryc.findById(c.getIdcuenta());
    		if(cr.isPresent()) {
    			
    			repositoryc.delete(cr.get());
    		}
	    	mensaje.setMsj("Cuenta eliminada");
    	}catch(NFException ex) {
    		mensaje.setMsj(ex.toString());
    	}
    	
    	return mensaje;
    }
}
