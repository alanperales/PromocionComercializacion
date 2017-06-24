package com.modulo.promoVentas.service;

import java.util.Collection;

import com.modulo.promoVentas.model.Cliente;
import com.modulo.promoVentas.model.Persona;

public interface ClienteService {

	Collection<Persona> listAll();

	Persona getCliente(Integer id);

	void createCliente(Cliente cliente);

	Persona getByDNI(String numeroDocumento, int tipoDoc);

	Collection<Persona> listClientes(String query);

}
