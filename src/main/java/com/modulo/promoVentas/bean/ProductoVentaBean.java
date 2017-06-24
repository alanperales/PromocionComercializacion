package com.modulo.promoVentas.bean;

import com.modulo.promoVentas.model.Producto;

public class ProductoVentaBean extends Producto{
	
	private int cantidad = 1;
	private Double descuento = 0.00;
	private Double total;
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Double getTotal() {
		return  (cantidad * this.getPD_PrecioUnitario()) - descuento;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Double getDescuento() {
		return descuento;
	}
	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

}
