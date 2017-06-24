package com.modulo.promoVentas.bean;

import java.util.Collection;
import java.util.Date;
import com.modulo.promoVentas.model.Parametro;
import com.modulo.promoVentas.model.Persona;

public class InsertVentaBean {
	
	public int codigoProducto;
	public String descripcion;
	public String editorial;
	public Double Precio;
	public Parametro tipoDocumento;
	public String numeroDocumento;
	public String descripcionCliente;
	public int idCliente;
	public String tipoComprobante;
	public Double subtotal = 0.00;
	public Double igv = 0.00;
	public Double total = 0.00;
	public String codigoVenta;
	public int VT_CodigoVenta;
	public Date fechaCreacion;
	public Persona cliente;
	public int tipoComprobanteId;
	public Collection<ProductoVentaBean> productos;
	public int idVentaSuspendida = 0;
	public String codOrden;

	public InsertVentaBean() {
	}
}