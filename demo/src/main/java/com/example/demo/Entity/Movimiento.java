package com.example.demo.Entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="movimientos")
public class Movimiento {		
		
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column
	    private int idmovimiento;

	    @Column
	    private Date fecha;

	    @Column
	    private String tipo;
	    
	    @Column
	    private Double saldo;
	    
	    @Column
	    private Double valor;
	    
	    @ManyToOne()
	    @JoinColumn(name = "idcuenta")
	    private Cuenta cuenta;

		public int getIdmovimiento() {
			return idmovimiento;
		}

		public void setIdmovimiento(int idmovimiento) {
			this.idmovimiento = idmovimiento;
		}

		public Date getFecha() {
			return fecha;
		}

		public void setFecha(Date fecha) {
			this.fecha = fecha;
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

		public Double getValor() {
			return valor;
		}

		public void setValor(Double valor) {
			this.valor = valor;
		}

		public Cuenta getCuenta() {
			return cuenta;
		}

		public void setCuenta(Cuenta cuenta) {
			this.cuenta = cuenta;
		}
}

		