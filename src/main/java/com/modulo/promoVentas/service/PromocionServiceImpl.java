package com.modulo.promoVentas.service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.modulo.promoVentas.bean.FindPromocionesBean;
import com.modulo.promoVentas.bean.PromocionDatosBean;
import com.modulo.promoVentas.mapper.PromocionMapper;
import com.modulo.promoVentas.mapper.ReglaMapper;
import com.modulo.promoVentas.model.Cliente;
import com.modulo.promoVentas.model.DatosPromocion;
import com.modulo.promoVentas.model.Persona;
import com.modulo.promoVentas.model.Producto;
import com.modulo.promoVentas.model.Promocion;
import com.modulo.promoVentas.model.Regla;
import com.modulo.promoVentas.utils.Constantes;

@Service
public class PromocionServiceImpl implements PromocionService {

	@Autowired
	private PromocionMapper promocionMapper;
	@Autowired
	private ReglaMapper reglaMapper;

	@Override
	public Collection<Promocion> list() {
		return promocionMapper.listAll();
	}

	@Override
	public Collection<DatosPromocion> findBy(FindPromocionesBean promocion) {
		if (promocion.getProducto() != null  && promocion.getProducto() != "" 
				&& promocion.getCliente() != "" && promocion.getCliente() != null)
			 return promocionMapper.findPromocionesByAll(promocion);
		if (promocion.getCliente() != null && promocion.getCliente() != "")
			return promocionMapper.findPromocionesByDateAndClient(promocion);
		if (promocion.getProducto() != null && promocion.getProducto() != "")
			return promocionMapper.findPromocionesByDateAndProduct(promocion);
		if (promocion.getProducto() != null  && promocion.getProducto() != "" 
				&& promocion.getCliente() != "" && promocion.getCliente() != null
				&& promocion.getTipoPromocion()!= 0 
				&& promocion.getPr_nombre()!= "" && promocion.getPr_nombre() != null
				&& promocion.getTipoCliente()!= "" && promocion.getTipoCliente() != null
				&& promocion.getPr_fechaInicio() != null
				&& promocion.getPr_fechaVenc() != null)
			return promocionMapper.findPromocionesLastTen();
		return promocionMapper.findPromocionesByDate(promocion);
	}

	@Override
	@Transactional
	public void createPromocion(Promocion promocion, PromocionDatosBean datosPromocion) {

		promocionMapper.insertPromocion(promocion);
		if (promocion.getPr_opcionProducto() == Constantes.PROD_POR_ESPECIFICO) 			
			for (Producto prod : datosPromocion.productoEspecifico)
				promocionMapper.insertProductosPromocion(promocion.getPr_codigoPromocion(),
						prod.getPD_CodigoProducto());

		if (promocion.getPr_opcionCliente() == Constantes.CLTE_SOLO_UN_CLIENTE) 
			for (Persona pers : datosPromocion.clienteEspecifico)
			promocionMapper.insertClientesPromocion(promocion.getPr_codigoPromocion(),
					pers.getPE_CodigoPersona());

		Regla regla = new Regla();
		regla.setPR_CodigoPromocion(promocion.getPr_codigoPromocion());
		regla.setRL_PorCada(datosPromocion.promoPorCantCantidad);
		regla.setRL_CostoBajaEn(new BigDecimal(datosPromocion.promoPorCantPrecio));
		regla.setRL_BajarPrecioUnitEn(new BigDecimal(datosPromocion.promoRebajaPrecio));
		regla.setRL_DescontarEn(new BigDecimal(datosPromocion.promoRebajaPorcentaje));
		regla.setRL_PorCada(datosPromocion.promoPorCantCantidad);
		regla.setRL_MontoMayorA(new BigDecimal(datosPromocion.promoPorMontoMayor));
		regla.setRL_DescuentoDe(new BigDecimal(datosPromocion.promoPorMontoMayorPrecio));
		if(datosPromocion.tipoProducto!=null)
		regla.setRL_TipoProducto(datosPromocion.tipoProducto.getPD_CodigoParametroDet());
		if(datosPromocion.tipoCliente!=null)
		regla.setRL_TipoCliente(datosPromocion.tipoCliente.getPD_CodigoParametroDet());
		if(datosPromocion.generoLiterario!=null)
		regla.setRL_ProdGenero(datosPromocion.generoLiterario.getPD_CodigoParametroDet());
		reglaMapper.insertReglaPromocion(regla);
	}

	@Override
	public void modifyPromocion(Promocion promocion, DatosPromocion selectedPromo) {
		promocionMapper.editPromocion(promocion);
	
		if(selectedPromo.getPr_opcionProducto() == Constantes.PROD_POR_ESPECIFICO) 
			for (Producto prod : selectedPromo.getProductos()){
				List<Producto> productosAnteriores = promocionMapper.getProductosEspecificos(promocion.getPr_codigoPromocion());
				Boolean yaExiste = false;
				for (Producto producto : productosAnteriores) {
					if(prod.getPD_CodigoProducto()==producto.getPD_CodigoProducto()){
						yaExiste = true;
						break;
					}
				}
				if(!yaExiste)
					promocionMapper.insertProductosPromocion(promocion.getPr_codigoPromocion(),
							prod.getPD_CodigoProducto());	
			}
				
		if (selectedPromo.getPr_opcionCliente() == Constantes.CLTE_SOLO_UN_CLIENTE) 
			for (Persona pers : selectedPromo.getClientes()){
				List<Persona> clientesAnteriores = promocionMapper.getClientesEspecificos(promocion.getPr_codigoPromocion());
				Boolean yaExiste = false;
				for (Persona persona : clientesAnteriores) {
					if(persona.getPE_CodigoPersona()==pers.getPE_CodigoPersona()){
						yaExiste = true;
					break;
					}
				}
			
				if(!yaExiste)
					promocionMapper.insertClientesPromocion(promocion.getPr_codigoPromocion(),
						pers.getPE_CodigoPersona());
			}
			
		
		Regla regla = new Regla();
		regla.setPR_CodigoPromocion(promocion.getPr_codigoPromocion());
		regla.setRL_PorCada(selectedPromo.getRL_PorCada());
		regla.setRL_CostoBajaEn(selectedPromo.getRL_CostoBajaEn());
		regla.setRL_BajarPrecioUnitEn(selectedPromo.getRL_BajarPrecioUnitEn());
		regla.setRL_DescontarEn(selectedPromo.getRL_DescontarEn());
		regla.setRL_MontoMayorA(selectedPromo.getRL_MontoMayorA());
		regla.setRL_DescuentoDe(selectedPromo.getRL_DescuentoDe());
		regla.setRL_TipoProducto(selectedPromo.getRL_TipoProducto());
		regla.setRL_TipoCliente(selectedPromo.getRL_TipoCliente());
		regla.setRL_ProdGenero(selectedPromo.getRL_ProdGenero());
		reglaMapper.editarReglaPromocion(regla);
	}

	@Override
	public void cancelPromocion(int id) {
		promocionMapper.cancelPromocion(id);
	}

	@Override
	public List<Persona> getClientesEspecificos(int pr_codigoPromocion) {
		return promocionMapper.getClientesEspecificos(pr_codigoPromocion);
	}

	@Override
	public List<Producto> getProductosEspecificos(int pr_codigoPromocion) {
		return promocionMapper.getProductosEspecificos(pr_codigoPromocion);
	}
	
	

}
