package com.modulo.promoVentas.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import com.modulo.promoVentas.model.Regla;

@Mapper
public interface ReglaMapper {
	@Insert("insert into co_regla (PR_CodigoPromocion, RL_PorCada, RL_CostoBajaEn, RL_BajarPrecioUnitEn,"
			+ "RL_DescontarEn, RL_TipoUnidadDesc, RL_MontoMayorA, RL_DescuentoDe, RL_TipoProducto, RL_TipoCliente, RL_ProdGenero) "
			+ "values (#{PR_CodigoPromocion}, "
			+ "#{RL_PorCada}, #{RL_CostoBajaEn}, #{RL_BajarPrecioUnitEn}, #{RL_DescontarEn}, #{RL_TipoUnidadDesc}, "
			+ "#{RL_MontoMayorA}, #{RL_DescuentoDe}, #{RL_TipoProducto}, #{RL_TipoCliente}, #{RL_ProdGenero})")
	public void insertReglaPromocion(Regla regla);

	@Update("update co_regla set RL_PorCada=#{RL_PorCada}, RL_CostoBajaEn=#{RL_CostoBajaEn}, RL_BajarPrecioUnitEn=#{RL_BajarPrecioUnitEn}"
			+ ", RL_DescontarEn=#{RL_DescontarEn}, RL_MontoMayorA=#{RL_MontoMayorA}, RL_DescuentoDe=#{RL_DescuentoDe}, "
			+ "RL_TipoProducto=#{RL_TipoProducto}, RL_TipoCliente=#{RL_TipoCliente}, RL_ProdGenero=#{RL_ProdGenero} "
			+ "where PR_CodigoPromocion = #{PR_CodigoPromocion}")
	public void editarReglaPromocion(Regla regla);
}
