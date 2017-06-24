package com.modulo.promoVentas.mapper;

import java.util.Collection;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.modulo.promoVentas.model.Parametro;
import com.modulo.promoVentas.model.Producto;

@Mapper
public interface ParametroMapper {
	@Select("Select * from lb_parametricadet where PR_CodigoParametroCab = 5 order by PD_NombreElemento desc")
	public Collection<Parametro> listAllGeneros();
	
	@Select("Select * from lb_parametricadet where PR_CodigoParametroCab = 8 order by PD_NombreElemento desc")
	public Collection<Parametro> listAllTiposProducto();
	
	@Select("Select * from lb_parametricadet where PD_CodigoParametroDet = #{id}")
	public Collection<Parametro> getParametro(Integer id);

	@Select("Select * from lb_parametricadet where PR_CodigoParametroCab = 9 order by PD_NombreElemento desc")
	public Collection<Parametro> listAllTiposCliente();

	@Select("Select * from lb_parametricadet where PR_CodigoParametroCab = 1 order by PD_NombreElemento desc")
	public Collection<Parametro> listAllTiposDocumento();

	@Select("Select * from lb_parametricadet where PR_CodigoParametroCab = 10 order by PD_NombreElemento desc")
	public Collection<Parametro> listAllTiposPromocion();
	
	@Select("Select * from lb_parametricadet where PR_CodigoParametroCab = 11 order by PD_NombreElemento desc")
	public Collection<Parametro> listAllEstadosPromocion();
}