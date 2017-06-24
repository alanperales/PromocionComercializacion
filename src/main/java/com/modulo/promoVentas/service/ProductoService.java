package com.modulo.promoVentas.service;

import java.util.Collection;

import com.modulo.promoVentas.bean.FindProductosBean;
import com.modulo.promoVentas.bean.ProductoTextoBean;
import com.modulo.promoVentas.bean.ProductoVentaBean;
import com.modulo.promoVentas.model.Producto;

public interface ProductoService {
	public Collection<Producto> listAll();
	public Producto getProducto(Integer id);
	public Collection<ProductoTextoBean> findBy(FindProductosBean prod);
	public ProductoVentaBean getProductoVenta(int codigoProducto);
	Collection<Producto> listProductos(String descripcion);
}
	
