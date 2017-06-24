package com.modulo.promoVentas.service;

import java.util.Collection;

import com.modulo.promoVentas.model.Parametro;

public interface ParametroService {
	public Collection<Parametro> listAllGeneros();
	public Collection<Parametro> listAllTiposProducto();
	public Parametro getParametro(Integer id);
	public Collection<Parametro> listAllTiposCliente();
	public Collection<Parametro> listAllTiposDocumento();
	public Collection<Parametro> listAllTiposPromocion();
	public Collection<Parametro> listAllEstadosPromocion();
}
