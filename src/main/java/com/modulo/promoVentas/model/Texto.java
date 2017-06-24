package com.modulo.promoVentas.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Texto {
	
	private String tituloTexto;
	private String ISBN;
	private String numeroEdicion;
	private int anoEdicion;
	private String observacion;
	private String estado;
	private int tipoTexto;
	private String genero;
	private Date fechaRegistro;
	
	public String getTituloTexto() {
		return tituloTexto;
	}
	public void setTituloTexto(String tituloTexto) {
		this.tituloTexto = tituloTexto;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getNumeroEdicion() {
		return numeroEdicion;
	}
	public void setNumeroEdicion(String numeroEdicion) {
		this.numeroEdicion = numeroEdicion;
	}
	public int getAnoEdicion() {
		return anoEdicion;
	}
	public void setAnoEdicion(int anoEdicion) {
		this.anoEdicion = anoEdicion;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getTipoTexto() {
		return tipoTexto;
	}
	public void setTipoTexto(int tipoTexto) {
		this.tipoTexto = tipoTexto;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	

}
