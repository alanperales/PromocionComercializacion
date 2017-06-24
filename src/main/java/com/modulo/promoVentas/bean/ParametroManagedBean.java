package com.modulo.promoVentas.bean;

import java.io.Serializable;
import java.util.Collection;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.modulo.promoVentas.model.Parametro;
import com.modulo.promoVentas.service.ParametroService;

@Component
@ManagedBean(name = "parametroMB")
@RequestScoped
public class ParametroManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	ParametroService parametroService;

	private int id;
	private String nombre;
	
	public Collection<Parametro> listGeneros(String query) {
		return parametroService.listAllGeneros();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}