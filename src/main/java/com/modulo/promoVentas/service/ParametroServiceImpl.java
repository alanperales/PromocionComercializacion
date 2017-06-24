package com.modulo.promoVentas.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modulo.promoVentas.mapper.ParametroMapper;
import com.modulo.promoVentas.model.Parametro;

@Service
public class ParametroServiceImpl implements ParametroService {

	@Autowired
	private ParametroMapper parametroMapper;
	
	@Override
	public Collection<Parametro> listAllGeneros() {
		return parametroMapper.listAllGeneros();
	}

	@Override
	public Collection<Parametro> listAllTiposProducto() {
		return parametroMapper.listAllTiposProducto();
	}

	@Override
	public Parametro getParametro(Integer id) {
		Collection<Parametro> pars = parametroMapper.getParametro(id);
		return (Parametro) pars.toArray()[0];
	}

	@Override
	public Collection<Parametro> listAllTiposCliente() {
		return parametroMapper.listAllTiposCliente();
	}

	@Override
	public Collection<Parametro> listAllTiposDocumento() {
		return parametroMapper.listAllTiposDocumento();
	}

	@Override
	public Collection<Parametro> listAllTiposPromocion() {
		return parametroMapper.listAllTiposPromocion();
	}

	@Override
	public Collection<Parametro> listAllEstadosPromocion() {
		return parametroMapper.listAllEstadosPromocion();
	}

	
}
