package com.modulo.promoVentas.mapper;

import java.util.Collection;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.modulo.promoVentas.model.Cliente;
import com.modulo.promoVentas.model.Persona;

@Mapper
public interface ClienteMapper {
	@Select("Select * from tb_persona")
	public Collection<Persona> listAll();

	@Select("Select * from tb_persona where PE_CodigoPersona = #{id}")
	public Collection<Persona> getCliente(Integer id);

	@Insert("Insert into in_cliente (PE_CodigoPersona,US_EstadoCliente) values (#{personaId},1)")
	public void insertCliente(@Param("personaId") int personaId);

	public void insertPersona(Cliente cliente);
	
	@Select("Select * from tb_persona where PD_CodigoTipoDocIdentidad = #{tipo} and PE_NumeroDocIdentidad = #{numero}")
	public Collection<Persona> getByDNI(@Param("tipo") int tipo, @Param("numero") String numero);

	@Insert("Insert into lb_trabajador (PE_CodigoPersona,TJ_CorreoCorporativo,TJ_EstadoTrabajador) values (#{PE_CodigoPersona},#{PE_EmailPersonal},1)")
	public void insertTrabajador(Cliente cliente);

	@Select("Select * from tb_persona where PE_Nombre like #{query} OR PE_ApellidoPaterno like #{query} OR PE_ApellidoMaterno like #{query} ")
	public Collection<Persona> listClientes(String query);
}