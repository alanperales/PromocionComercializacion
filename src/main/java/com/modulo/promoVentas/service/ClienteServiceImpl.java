package com.modulo.promoVentas.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.modulo.promoVentas.mapper.ClienteMapper;
import com.modulo.promoVentas.model.Cliente;
import com.modulo.promoVentas.model.Persona;

@Service
public class ClienteServiceImpl  implements ClienteService {

	@Autowired
	ClienteMapper clienteMapper;
	
	@Override
	public Collection<Persona> listAll() {
		return clienteMapper.listAll();
	}

	@Override
	public Persona getCliente(Integer id) {
		return (Persona) clienteMapper.getCliente(id).toArray()[0];
	}

	@Override
	@Transactional
	public void createCliente(Cliente cliente) {
		clienteMapper.insertPersona(cliente);
		clienteMapper.insertCliente(cliente.getPE_CodigoPersona());
		clienteMapper.insertTrabajador(cliente);
	}

	@Override
	public Persona getByDNI(String numeroDocumento, int tipoDoc) {
		return (Persona) clienteMapper.getByDNI(tipoDoc, numeroDocumento).toArray()[0];
	}

	@Override
	public Collection<Persona> listClientes(String query) {
		return clienteMapper.listClientes(query);
	}
	
}