package com.modulo.promoVentas.service;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.modulo.promoVentas.bean.InsertVentaBean;
import com.modulo.promoVentas.bean.ProductoVentaBean;
import com.modulo.promoVentas.bean.VentaSuspendidaBean;
import com.modulo.promoVentas.mapper.VentaMapper;
import com.modulo.promoVentas.model.Venta;
import com.modulo.promoVentas.model.VentaDetalle;
import com.modulo.promoVentas.utils.Constantes;

@Service
public class VentaServiceImpl implements VentaService {

	@Autowired
	VentaMapper ventaMapper;
	
	@Override
	@Transactional
	public void generarOrdenCompra(InsertVentaBean datosVenta) {
		datosVenta.codigoVenta = calculateCodOrden();
		datosVenta.fechaCreacion = new Date();
		
		if(datosVenta.tipoComprobante.equals(Constantes.FACTURA))
			datosVenta.tipoComprobanteId=1;
		if(datosVenta.tipoComprobante.equals(Constantes.BOLETA_VENTA))
			datosVenta.tipoComprobanteId=2;
		
		ventaMapper.insertVenta(datosVenta);
		
		for (ProductoVentaBean prod : datosVenta.productos) 
			ventaMapper.insertVentaDetalle(datosVenta.VT_CodigoVenta,prod);

		ventaMapper.deleteVentaTmp(datosVenta.idVentaSuspendida);
	}

	@Override
	public String calculateCodOrden() {
		Collection<Venta> ventas = ventaMapper.getUltimaVenta();
		String codigoUltimaVenta = "00001";
		if(!ventas.isEmpty()){
			Venta v = (Venta) ventas.toArray()[0];
			codigoUltimaVenta = v.getVT_DocumentoSerie();
			Integer codigo = Integer.parseInt(codigoUltimaVenta.split("-")[1])+1;
			codigoUltimaVenta = codigo.toString();
			Integer longitud = codigoUltimaVenta.length();
			if(longitud<6)
				for(int i=0; i<(5-longitud); i++)
					codigoUltimaVenta = "0"+codigoUltimaVenta;
		}
		return Calendar.getInstance().get(Calendar.YEAR)+"-"+codigoUltimaVenta;
	}

	@Override
	@Transactional
	public void suspenderVenta(InsertVentaBean datosVenta) {
		datosVenta.fechaCreacion = new Date();
		if(datosVenta.tipoComprobante.equals(Constantes.FACTURA))
			datosVenta.tipoComprobanteId=1;
		if(datosVenta.tipoComprobante.equals(Constantes.BOLETA_VENTA))
			datosVenta.tipoComprobanteId=2;
		
		ventaMapper.insertVentaTmp(datosVenta);
		
		for (ProductoVentaBean prod : datosVenta.productos) 
			ventaMapper.insertVentaDetalleTmp(datosVenta.VT_CodigoVenta,prod);
	}

	@Override
	public Collection<VentaSuspendidaBean> buscarSuspendidas() {
		return ventaMapper.getOrdenesSuspendidas();
	}

	@Override
	public Collection<VentaDetalle> getDetalleVentaSuspendida(int idVenta){
		return ventaMapper.getDetalleOrdenSuspendida(idVenta);
	}

	@Override
	public void calculateTotal(InsertVentaBean data) {
		Double subt = 0.00;
		for (ProductoVentaBean prod : data.productos) {
				subt = subt + (prod.getPD_PrecioUnitario()*prod.getCantidad());
		}
		data.subtotal = subt;
		data.igv = subt * 0.18;
		data.total = subt + data.igv;
	}
	

}
