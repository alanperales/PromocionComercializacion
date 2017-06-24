package com.modulo.promoVentas.bean;

import java.util.Collection;

import com.modulo.promoVentas.model.Parametro;
import com.modulo.promoVentas.model.Persona;
import com.modulo.promoVentas.model.Producto;

public class PromocionDatosBean {
	public Collection<Producto> productoEspecifico;
	public Parametro tipoProducto;
	public Parametro generoLiterario;
	public Parametro tipoCliente;
	public Collection<Persona> clienteEspecifico;
	public int pr_opcionPromocion;
	public int promoPorCantCantidad = 1;
	public Double promoPorCantPrecio;
	public Double promoRebajaPrecio;
	public Double promoRebajaPorcentaje;
	public Double promoPorMontoMayor;
	public Double promoPorMontoMayorPrecio;

	public PromocionDatosBean(Double promoPorCantPrecio, Double promoRebajaPrecio, Double promoRebajaPorcentaje,
			Double promoPorMontoMayor, Double promoPorMontoMayorPrecio) {
		this.promoPorCantPrecio = promoPorCantPrecio;
		this.promoRebajaPrecio = promoRebajaPrecio;
		this.promoRebajaPorcentaje = promoRebajaPorcentaje;
		this.promoPorMontoMayor = promoPorMontoMayor;
		this.promoPorMontoMayorPrecio = promoPorMontoMayorPrecio;
	}
}