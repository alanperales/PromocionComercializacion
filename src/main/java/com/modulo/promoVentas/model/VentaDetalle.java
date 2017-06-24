package com.modulo.promoVentas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaDetalle {

	private int VD_VentaDetalle;
	private int PV_CodigoVenta;
	private int PD_CodigoProducto;
	private int VD_Cantidad;
	private Double VD_PrecioUnit;
	private Double VD_PrecioTotal;

	
	public int getPD_CodigoProducto() {
		return PD_CodigoProducto;
	}

	public void setPD_CodigoProducto(int pD_CodigoProducto) {
		PD_CodigoProducto = pD_CodigoProducto;
	}

	public int getVD_VentaDetalle() {
		return VD_VentaDetalle;
	}

	public void setVD_VentaDetalle(int vD_VentaDetalle) {
		VD_VentaDetalle = vD_VentaDetalle;
	}

	public int getPV_CodigoVenta() {
		return PV_CodigoVenta;
	}

	public void setPV_CodigoVenta(int pV_CodigoVenta) {
		PV_CodigoVenta = pV_CodigoVenta;
	}

	public int getVD_Cantidad() {
		return VD_Cantidad;
	}

	public void setVD_Cantidad(int vD_Cantidad) {
		VD_Cantidad = vD_Cantidad;
	}

	public Double getVD_PrecioUnit() {
		return VD_PrecioUnit;
	}

	public void setVD_PrecioUnit(Double vD_PrecioUnit) {
		VD_PrecioUnit = vD_PrecioUnit;
	}

	public Double getVD_PrecioTotal() {
		return VD_PrecioTotal;
	}

	public void setVD_PrecioTotal(Double vD_PrecioTotal) {
		VD_PrecioTotal = vD_PrecioTotal;
	}

}
