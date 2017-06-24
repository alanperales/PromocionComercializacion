package com.modulo.promoVentas.service;

import java.util.Collection;
import java.util.List;

import com.modulo.promoVentas.bean.FindPromocionesBean;
import com.modulo.promoVentas.bean.PromocionDatosBean;
import com.modulo.promoVentas.model.Cliente;
import com.modulo.promoVentas.model.DatosPromocion;
import com.modulo.promoVentas.model.Persona;
import com.modulo.promoVentas.model.Producto;
import com.modulo.promoVentas.model.Promocion;

public interface PromocionService {
	
	public Collection<Promocion> list();
	public void createPromocion(Promocion promocion, PromocionDatosBean datosPromocion);
	public Collection<DatosPromocion> findBy(FindPromocionesBean promocion);
	public void modifyPromocion(Promocion promocion, DatosPromocion selectedPromo);
	public void cancelPromocion(int id);
	public List<Persona> getClientesEspecificos(int pr_codigoPromocion);
	public List<Producto> getProductosEspecificos(int pr_codigoPromocion);

}
