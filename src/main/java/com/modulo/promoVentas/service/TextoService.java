package com.modulo.promoVentas.service;

import java.util.Collection;

import com.modulo.promoVentas.model.Texto;

public interface TextoService  {

	public Collection<Texto> list();

	public Collection<String> listGeneros();
}