package com.modulo.promoVentas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

	private int PD_CodigoProducto;
	private String PD_Descripcion;
	private int PD_TipoProducto;
	private Double PD_PrecioUnitario;
	private Double PD_PrecioMayor;
	private int PD_CantidadMinima;
	private int TX_CodigoTexto;

	public int getPD_CodigoProducto() {
		return PD_CodigoProducto;
	}

	public void setPD_CodigoProducto(int pD_CodigoProducto) {
		PD_CodigoProducto = pD_CodigoProducto;
	}

	public String getPD_Descripcion() {
		return PD_Descripcion;
	}

	public void setPD_Descripcion(String pD_Descripcion) {
		PD_Descripcion = pD_Descripcion;
	}

	public int getPD_TipoProducto() {
		return PD_TipoProducto;
	}

	public void setPD_TipoProducto(int pD_TipoProducto) {
		PD_TipoProducto = pD_TipoProducto;
	}

	public Double getPD_PrecioUnitario() {
		return PD_PrecioUnitario;
	}

	public void setPD_PrecioUnitario(Double pD_PrecioUnitario) {
		PD_PrecioUnitario = pD_PrecioUnitario;
	}

	public Double getPD_PrecioMayor() {
		return PD_PrecioMayor;
	}

	public void setPD_PrecioMayor(Double pD_PrecioMayor) {
		PD_PrecioMayor = pD_PrecioMayor;
	}

	public int getPD_CantidadMinima() {
		return PD_CantidadMinima;
	}

	public void setPD_CantidadMinima(int pD_CantidadMinima) {
		PD_CantidadMinima = pD_CantidadMinima;
	}

	public int getTX_CodigoTexto() {
		return TX_CodigoTexto;
	}

	public void setTX_CodigoTexto(int tX_CodigoTexto) {
		TX_CodigoTexto = tX_CodigoTexto;
	}

}
