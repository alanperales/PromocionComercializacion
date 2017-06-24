package com.modulo.promoVentas.mapper;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.modulo.promoVentas.bean.FindPromocionesBean;
import com.modulo.promoVentas.model.Cliente;
import com.modulo.promoVentas.model.DatosPromocion;
import com.modulo.promoVentas.model.Persona;
import com.modulo.promoVentas.model.Producto;
import com.modulo.promoVentas.model.Promocion;

@Mapper
public interface PromocionMapper {
	@Select("Select * from co_promocion")
	public Collection<Promocion> listAll();
	public void insertPromocion(Promocion promocion);
	public Collection<DatosPromocion> findPromocionesByDate(FindPromocionesBean promocion);
	public Collection<DatosPromocion> findPromocionesByDateAndClient(FindPromocionesBean promocion);
	public Collection<DatosPromocion> findPromocionesByDateAndProduct(FindPromocionesBean promocion);
	public Collection<DatosPromocion> findPromocionesByAll(FindPromocionesBean promocion);
	@Insert("insert into co_promocionprod (PR_CodigoPromocion, PD_CodigoProducto) values (#{promoId}, #{prodId})")
	public void insertProductosPromocion(@Param("promoId") int pr_codigoPromocion, @Param("prodId") int pd_CodigoProducto);
	@Insert("insert into co_promociocliente (PR_CodigoPromocion, PE_CodigoPersona) values (#{promoId}, #{clteId})")
	public void insertClientesPromocion(@Param("promoId") int pr_codigoPromocion, @Param("clteId") int PE_CodigoPersona);
	@Select("Select top 10 from co_promocion order by PR_fechaInsercion")
	public Collection<DatosPromocion> findPromocionesLastTen();
	@Update("update co_promocion set PR_Nombre = #{pr_nombre}, PR_FechaInicio = #{pr_fechaInicio}, "
			+ "PR_FechaVenc = #{pr_fechaVenc}, pr_opcionCliente	= #{pr_opcionCliente}, pr_opcionProducto = #{pr_opcionProducto} "
			+ "where pr_codigoPromocion = #{pr_codigoPromocion}")
	public void editPromocion(Promocion promocion);
	@Update("update co_promocion set PR_EstadoPromocion = 31 where pr_codigoPromocion = #{id}")
	public void cancelPromocion(int id);
	@Select("Select * from co_promociocliente cli, tb_persona per where cli.PE_CodigoPersona= per.PE_CodigoPersona and "
			+ "PR_CodigoPromocion = #{pr_codigoPromocion}")
	public List<Persona> getClientesEspecificos(int pr_codigoPromocion);
	@Select("Select * from co_promocionprod cpp where cpp.PR_CodigoPromocion = #{pr_codigoPromocion}")
	public List<Producto> getProductosEspecificos(int pr_codigoPromocion);
}
