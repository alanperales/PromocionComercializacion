package com.modulo.promoVentas.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Promocion {

	private int pr_codigoPromocion;
	private String pr_nombre;
	private int pr_opcionCliente;
	private String pr_opcionClienteDescr;
	private int pr_opcionProducto;
	private String pr_opcionProductoDescr;
	private Date pr_fechaInicio;
	private Date pr_fechaVenc;
	private int pr_tipoPromocion;
	private Date pr_fechaInsercion;
	private int pr_estadoPromocion;
	
	public int getPr_estadoPromocion() {
		return pr_estadoPromocion;
	}
	public void setPr_estadoPromocion(int pr_estadoPromocion) {
		this.pr_estadoPromocion = pr_estadoPromocion;
	}
	public Date getPr_fechaInsercion() {
		return pr_fechaInsercion;
	}
	public void setPr_fechaInsercion(Date pr_fechaInsercion) {
		this.pr_fechaInsercion = pr_fechaInsercion;
	}
	public int getPr_tipoPromocion() {
		return pr_tipoPromocion;
	}
	public void setPr_tipoPromocion(int pr_tipoPromocion) {
		this.pr_tipoPromocion = pr_tipoPromocion;
	}
	public String getPr_opcionClienteDescr() {
		return pr_opcionClienteDescr;
	}
	public void setPr_opcionClienteDescr(String pr_opcionClienteDescr) {
		this.pr_opcionClienteDescr = pr_opcionClienteDescr;
	}
	public String getPr_opcionProductoDescr() {
		return pr_opcionProductoDescr;
	}
	public void setPr_opcionProductoDescr(String pr_opcionProductoDescr) {
		this.pr_opcionProductoDescr = pr_opcionProductoDescr;
	}
	public int getPr_codigoPromocion() {
		return pr_codigoPromocion;
	}
	public void setPr_codigoPromocion(int pr_codigoPromocion) {
		this.pr_codigoPromocion = pr_codigoPromocion;
	}
	public String getPr_nombre() {
		return pr_nombre;
	}
	public void setPr_nombre(String pr_nombre) {
		this.pr_nombre = pr_nombre;
	}
	public int getPr_opcionCliente() {
		return pr_opcionCliente;
	}
	public void setPr_opcionCliente(int pr_opcionCliente) {
		this.pr_opcionCliente = pr_opcionCliente;
	}
	public int getPr_opcionProducto() {
		return pr_opcionProducto;
	}
	public void setPr_opcionProducto(int pr_opcionProducto) {
		this.pr_opcionProducto = pr_opcionProducto;
	}
	public Date getPr_fechaInicio() {
		return pr_fechaInicio;
	}
	public void setPr_fechaInicio(Date pr_fechaInicio) {
		this.pr_fechaInicio = pr_fechaInicio;
	}
	public Date getPr_fechaVenc() {
		return pr_fechaVenc;
	}
	public void setPr_fechaVenc(Date pr_fechaVenc) {
		this.pr_fechaVenc = pr_fechaVenc;
	}
	
}
