package com.modulo.promoVentas.bean;

import com.modulo.promoVentas.model.Promocion;

public class FindPromocionesBean extends Promocion{
	
	private String cliente;
	private String tipoCliente;
	private String producto;
	private int tipoPromocion;
	private int estadoPromocion;
	
	public int getEstadoPromocion() {
		return estadoPromocion;
	}
	public void setEstadoPromocion(int estadoPromocion) {
		this.estadoPromocion = estadoPromocion;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public int getTipoPromocion() {
		return tipoPromocion;
	}
	public void setTipoPromocion(int tipoPromocion) {
		this.tipoPromocion = tipoPromocion;
	}
}
