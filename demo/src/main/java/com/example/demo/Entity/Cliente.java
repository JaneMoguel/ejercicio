package com.example.demo.Entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name="cliente")
public class Cliente {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idcliente;

    @Column
    private String contraseña;

    @Column
    private String estado;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    private Persona persona;

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
   
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Cuenta> cuentas;

	
	
    
    
}
