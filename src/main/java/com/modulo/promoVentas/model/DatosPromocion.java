package com.modulo.promoVentas.model;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatosPromocion extends Promocion{

	private int RL_CodigoRegla;
	private int RL_PorCada;
	private BigDecimal RL_CostoBajaEn;
	private BigDecimal RL_BajarPrecioUnitEn;
	private BigDecimal RL_DescontarEn;
	private BigDecimal RL_MontoMayorA;
	private BigDecimal RL_DescuentoDe;
	private int RL_TipoUnidadDesc;
	private String tipoPromo;
	private String estadoPromo;
	private int RL_TipoCliente;
	private int RL_ProdGenero;
	private int RL_TipoProducto;
	private List<Producto> productos;
	private List<Persona> clientes;
	
	
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	public List<Persona> getClientes() {
		return clientes;
	}
	public void setClientes(List<Persona> clientes) {
		this.clientes = clientes;
	}
	public int getRL_TipoCliente() {
		return RL_TipoCliente;
	}
	public void setRL_TipoCliente(int rL_TipoCliente) {
		RL_TipoCliente = rL_TipoCliente;
	}
	public int getRL_ProdGenero() {
		return RL_ProdGenero;
	}
	public void setRL_ProdGenero(int rL_ProdGenero) {
		RL_ProdGenero = rL_ProdGenero;
	}
	public int getRL_TipoProducto() {
		return RL_TipoProducto;
	}
	public void setRL_TipoProducto(int rL_TipoProducto) {
		RL_TipoProducto = rL_TipoProducto;
	}
	public BigDecimal getRL_MontoMayorA() {
		return RL_MontoMayorA;
	}
	public void setRL_MontoMayorA(BigDecimal rL_MontoMayorA) {
		RL_MontoMayorA = rL_MontoMayorA;
	}
	public BigDecimal getRL_DescuentoDe() {
		return RL_DescuentoDe;
	}
	public void setRL_DescuentoDe(BigDecimal rL_DescuentoDe) {
		RL_DescuentoDe = rL_DescuentoDe;
	}
	public String getEstadoPromo() {
		return estadoPromo;
	}
	public void setEstadoPromo(String estadoPromo) {
		this.estadoPromo = estadoPromo;
	}
	public String getTipoPromo() {
		return tipoPromo;
	}
	public void setTipoPromo(String tipoPromo) {
		this.tipoPromo = tipoPromo;
	}
	public int getRL_CodigoRegla() {
		return RL_CodigoRegla;
	}
	public void setRL_CodigoRegla(int rL_CodigoRegla) {
		RL_CodigoRegla = rL_CodigoRegla;
	}
	public int getRL_PorCada() {
		return RL_PorCada;
	}
	public void setRL_PorCada(int rL_PorCada) {
		RL_PorCada = rL_PorCada;
	}
	public BigDecimal getRL_CostoBajaEn() {
		return RL_CostoBajaEn;
	}
	public void setRL_CostoBajaEn(BigDecimal rL_CostoBajaEn) {
		RL_CostoBajaEn = rL_CostoBajaEn;
	}
	public BigDecimal getRL_BajarPrecioUnitEn() {
		return RL_BajarPrecioUnitEn;
	}
	public void setRL_BajarPrecioUnitEn(BigDecimal rL_BajarPrecioUnitEn) {
		RL_BajarPrecioUnitEn = rL_BajarPrecioUnitEn;
	}
	public BigDecimal getRL_DescontarEn() {
		return RL_DescontarEn;
	}
	public void setRL_DescontarEn(BigDecimal rL_DescontarEn) {
		RL_DescontarEn = rL_DescontarEn;
	}
	public int getRL_TipoUnidadDesc() {
		return RL_TipoUnidadDesc;
	}
	public void setRL_TipoUnidadDesc(int rL_TipoUnidadDesc) {
		RL_TipoUnidadDesc = rL_TipoUnidadDesc;
	}
}
