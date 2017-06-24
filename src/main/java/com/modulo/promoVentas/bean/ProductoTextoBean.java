package com.modulo.promoVentas.bean;

import com.modulo.promoVentas.model.Producto;

public class ProductoTextoBean extends Producto {

	private String AT_Nombre;
	private String AT_ApellidoPaterno;
	private String AT_ApellidoMaterno;
	private String ED_Nombre;
	private String TX_Titulo;
	
	public String getAT_Nombre() {
		return AT_Nombre;
	}
	public void setAT_Nombre(String aT_Nombre) {
		AT_Nombre = aT_Nombre;
	}
	public String getAT_ApellidoPaterno() {
		return AT_ApellidoPaterno;
	}
	public void setAT_ApellidoPaterno(String aT_ApellidoPaterno) {
		AT_ApellidoPaterno = aT_ApellidoPaterno;
	}
	public String getAT_ApellidoMaterno() {
		return AT_ApellidoMaterno;
	}
	public void setAT_ApellidoMaterno(String aT_ApellidoMaterno) {
		AT_ApellidoMaterno = aT_ApellidoMaterno;
	}
	public String getED_Nombre() {
		return ED_Nombre;
	}
	public void setED_Nombre(String eD_Nombre) {
		ED_Nombre = eD_Nombre;
	}
	public String getNombreCompletoAutor(){
		return AT_Nombre+" "+AT_ApellidoPaterno+" "+AT_ApellidoMaterno;
	}
	public String getTX_Titulo() {
		return TX_Titulo;
	}
	public void setTX_Titulo(String tX_Titulo) {
		TX_Titulo = tX_Titulo;
	}
	
}
