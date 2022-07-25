package com.example.demo.objetos;

import java.sql.Date;


public class MovimientoO {

	
	private int idcuenta;
	private int idmovimiento;
	private Date fecha;
    private String tipo;
    private Double saldo;
    private Double valor;
	public int getIdcuenta() {
		return idcuenta;
	}
	public void setIdcuenta(int idcuenta) {
		this.idcuenta = idcuenta;
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
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
    
	
    
}
