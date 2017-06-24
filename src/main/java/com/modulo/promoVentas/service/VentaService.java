package com.modulo.promoVentas.service;

import java.util.Collection;

import com.modulo.promoVentas.bean.InsertVentaBean;
import com.modulo.promoVentas.bean.VentaSuspendidaBean;
import com.modulo.promoVentas.model.VentaDetalle;

public interface VentaService {
	
	public void generarOrdenCompra(InsertVentaBean datosVenta);

	public void suspenderVenta(InsertVentaBean data);

	public Collection<VentaSuspendidaBean> buscarSuspendidas();

	Collection<VentaDetalle> getDetalleVentaSuspendida(int idVenta);

	void calculateTotal(InsertVentaBean data);

	String calculateCodOrden();

}
