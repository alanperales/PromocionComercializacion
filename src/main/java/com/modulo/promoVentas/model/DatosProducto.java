package com.modulo.promoVentas.model;

import java.util.List;

public class DatosProducto {

	private Parametro tipoProductoParam;
	private Parametro generoLiterarioParam;
	private String generoLiterario;
	private String tipoProducto;
	private List<Producto> productos;
	
	public Parametro getTipoProductoParam() {
		return tipoProductoParam;
	}
	public void setTipoProductoParam(Parametro tipoProductoParam) {
		this.tipoProductoParam = tipoProductoParam;
	}
	public Parametro getGeneroLiterarioParam() {
		return generoLiterarioParam;
	}
	public void setGeneroLiterarioParam(Parametro generoLiterarioParam) {
		this.generoLiterarioParam = generoLiterarioParam;
	}
	public String getGeneroLiterario() {
		return generoLiterario;
	}
	public void setGeneroLiterario(String generoLiterario) {
		this.generoLiterario = generoLiterario;
	}
	public String getTipoProducto() {
		return tipoProducto;
	}
	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	
}
