package com.example.demo.Entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="cuentas")
public class Cuenta {		
		
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column
	    private int idcuenta;

	    @Column
	    private String numero;

	    @Column
	    private String tipo;
	    
	    @Column
	    private Double saldo;
	    
	    @Column
	    private int estado;
	    
	    @ManyToOne()
	    @JoinColumn(name = "idcliente")
	    private Cliente cliente;

		public int getIdcuenta() {
			return idcuenta;
		}
		
		

		public void setIdcuenta(int idcuenta) {
			this.idcuenta = idcuenta;
		}

		public String getNumero() {
			return numero;
		}

		public void setNumero(String numero) {
			this.numero = numero;
		}

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		public Double getSaldo() {
			return saldo;
		}

		public void setSaldo(Double saldo) {
			this.saldo = saldo;
		}

		public int getEstado() {
			return estado;
		}

		public void setEstado(int estado) {
			this.estado = estado;
		}



		public Cliente getCliente() {
			return cliente;
		}



		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}

		
		@OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL, orphanRemoval = true)
	    private Collection<Movimiento> movimientos;

		
	    
}
