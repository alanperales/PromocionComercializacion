package com.modulo.promoVentas.model;

import java.util.List;

public class DatosCliente {

	private Parametro tipoClienteParam;
	private String tipoCliente;
	private List<Persona> clientes;
	
	
	public Parametro getTipoClienteParam() {
		return tipoClienteParam;
	}
	public void setTipoClienteParam(Parametro tipoClienteParam) {
		this.tipoClienteParam = tipoClienteParam;
	}
	public String getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	public List<Persona> getClientes() {
		return clientes;
	}
	public void setClientes(List<Persona> clientes) {
		this.clientes = clientes;
	}
	
	
}
