package com.modulo.promoVentas.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modulo.promoVentas.bean.FindProductosBean;
import com.modulo.promoVentas.bean.ProductoTextoBean;
import com.modulo.promoVentas.bean.ProductoVentaBean;
import com.modulo.promoVentas.mapper.ProductoMapper;
import com.modulo.promoVentas.model.Producto;
import com.modulo.promoVentas.utils.Constantes;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	ProductoMapper productoMapper;

	@Override
	public Collection<Producto> listAll() {
		return productoMapper.listAll();
	}

	@Override
	public Collection<Producto> listProductos(String descripcion) {
		return productoMapper.listProductos(descripcion);
	}

	@Override
	public Producto getProducto(Integer id) {
		Collection<Producto> prods = productoMapper.getProducto(id);
		if (prods != null)
			return (Producto) prods.toArray()[0];
		else
			return null;
	}

	@Override
	public Collection<ProductoTextoBean> findBy(FindProductosBean prod) {
		if(prod.getIdCampo()==Constantes.BUSQ_POR_TITULO)
			return productoMapper.findByTitulo(prod);
		if(prod.getIdCampo()==Constantes.BUSQ_POR_ID)
			return productoMapper.findByID(prod);
		if(prod.getIdCampo()==Constantes.BUSQ_POR_AUTOR)
			return productoMapper.findByAutor(prod);
		if(prod.getIdCampo()==Constantes.BUSQ_POR_EDITORIAL)
			return productoMapper.findByEditorial(prod);
		else return null;
	}

	@Override
	public ProductoVentaBean getProductoVenta(int codigoProducto) {
		Collection<ProductoVentaBean> prods = productoMapper.getProductoVenta(codigoProducto);
		if (prods != null)
			return (ProductoVentaBean) prods.toArray()[0];
		else
			return null;
	}

}
