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
import com.example.demo.Entity.Cuenta;
import com.example.demo.Entity.Movimiento;
import com.example.demo.exception.NFException;
import com.example.demo.objetos.Mensaje;
import com.example.demo.objetos.MovimientoO;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.CuentaRepository;
import com.example.demo.repository.MovimientoRepository;

@RestController
@RequestMapping("/movimientos")
public class MovimentoController {
    
	@Autowired
	ClienteRepository repository ;
	@Autowired
	CuentaRepository repositoryc;
	@Autowired
	MovimientoRepository repositorym;
	
    @GetMapping(value="/obtener/movimientos", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Movimiento> obtenerMovimientos() {
    	Collection<Movimiento> mod = repositorym.findAll();
        return mod;
    }
    
    @GetMapping(value="/obtener/movimiento/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Movimiento> obtenerMovimiento(@PathVariable int id) {
    	return repositorym.findById(id);
    }
    
    
    @PostMapping(value="/crear/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mensaje crearMovimiento(@RequestBody MovimientoO m) {
    	Mensaje mensaje = new Mensaje();
    	mensaje.setFecha(new Date());
    	Movimiento mov =new Movimiento();;
    	Optional<Cuenta> c;
    	try {
    		c = repositoryc.findById(m.getIdcuenta());
    		if(c.isPresent()) {
    			mov.setCuenta(c.get());
    			mov.setFecha(m.getFecha());
    			mov.setSaldo(m.getSaldo());
    			mov.setTipo(m.getTipo());
    			mov.setValor(m.getValor());
    			repositorym.save(mov);
    			mensaje.setMsj("Movimiento creado");
    		}else {
    			mensaje.setMsj("Cuenta no existe");
    		}
	    	
	    	
    	}catch(NFException ex) {
    		mensaje.setMsj(ex.toString());
    	}
    	return mensaje;
    }
    
    @PutMapping(value="/actualizar/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mensaje actualizarMovimiento(@RequestBody Movimiento m) {
    	Mensaje mensaje = new Mensaje();
    	mensaje.setFecha(new Date());
    	Optional<Movimiento> mov;
    	try {
    		mov=repositorym.findById(m.getIdmovimiento());
	    	if(mov.isPresent()) {
	    		repositorym.save(m);
	    		mensaje.setMsj("Movimiento actualizada");
	    	}else {
	    		mensaje.setMsj("Movimiento inexistente");
	    	}
    	}catch(NFException ex) {
    		mensaje.setMsj(ex.toString());
    	}
    	
    	return mensaje;
    }
    
    @DeleteMapping(value="/borrar/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mensaje borrarMovimiento(@RequestBody Movimiento m) {
    	Mensaje mensaje = new Mensaje();
    	mensaje.setFecha(new Date());
    	Optional<Movimiento> mov;
    	try {
    		mov = repositorym.findById(m.getIdmovimiento());
    		if(mov.isPresent()) {
    			
    			repositorym.delete(mov.get());
    		}
	    	mensaje.setMsj("Cuenta eliminada");
    	}catch(NFException ex) {
    		mensaje.setMsj(ex.toString());
    	}
    	
    	return mensaje;
    }
}

