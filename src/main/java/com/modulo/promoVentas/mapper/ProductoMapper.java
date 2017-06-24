package com.modulo.promoVentas.mapper;

import java.util.Collection;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.modulo.promoVentas.bean.FindProductosBean;
import com.modulo.promoVentas.bean.ProductoTextoBean;
import com.modulo.promoVentas.bean.ProductoVentaBean;
import com.modulo.promoVentas.model.Producto;

@Mapper
public interface ProductoMapper {
	@Select("Select * from co_producto")
	public Collection<Producto> listAll();
	@Select("Select * from co_producto where PD_Descripcion like #{%descripcion%}")
	public Collection<Producto> listProductos(String descripcion);
	@Select("Select * from co_producto where PD_CodigoProducto = #{id}")
	public Collection<Producto> getProducto(Integer id);
	@Select("Select * from co_producto where PD_CodigoProducto = #{id}")
	public Collection<Producto> findBy(FindProductosBean prod);
	@Select("Select * from co_producto where PD_CodigoProducto = #{id}")
	public Collection<ProductoVentaBean> getProductoVenta(Integer id);
	@Select("Select cp.*,ct. TX_Titulo, ca.AT_Nombre, ca.AT_ApellidoPaterno, ca.AT_ApellidoMaterno, ce.ED_Nombre"
			+ " from co_producto cp, co_texto ct, co_autor ca, co_editorial ce "
			+ "where cp.TX_CodigoTexto = ct.TX_CodigoTexto "
			+ "and ca.AT_CodigoAutor = ct.AT_CodigoAutor "
			+ "and ce.ED_CodigoEditorial = ct.ED_CodigoEditorial "
			+ "and cp.PD_TipoProducto = #{idTipoProducto} and ct.TX_Titulo like #{frase}")
	public Collection<ProductoTextoBean> findByTitulo(FindProductosBean prod);
	@Select("Select cp.*,ct. TX_Titulo, ca.AT_Nombre, ca.AT_ApellidoPaterno, ca.AT_ApellidoMaterno, ce.ED_Nombre"
			+ " from co_producto cp, co_texto ct, co_autor ca, co_editorial ce "
			+ "where cp.TX_CodigoTexto = ct.TX_CodigoTexto "
			+ "and ca.AT_CodigoAutor = ct.AT_CodigoAutor "
			+ "and ce.ED_CodigoEditorial = ct.ED_CodigoEditorial "
			+ "and cp.PD_CodigoProducto = #{frase} ")
	public Collection<ProductoTextoBean> findByID(FindProductosBean prod);
	@Select("Select cp.*,ct. TX_Titulo, ca.AT_Nombre, ca.AT_ApellidoPaterno, ca.AT_ApellidoMaterno, ce.ED_Nombre"
			+ " from co_producto cp, co_texto ct, co_autor ca, co_editorial ce "
			+ "where cp.TX_CodigoTexto = ct.TX_CodigoTexto "
			+ "and ca.AT_CodigoAutor = ct.AT_CodigoAutor "
			+ "and ce.ED_CodigoEditorial = ct.ED_CodigoEditorial "
			+ "and cp.PD_TipoProducto = #{idTipoProducto} and (ca.AT_Nombre like #{frase} or ca.AT_ApellidoPaterno like #{frase} "
			+ "or ca.AT_ApellidoMaterno like #{frase}) ")
	public Collection<ProductoTextoBean> findByAutor(FindProductosBean prod);
	@Select("Select cp.*,ct. TX_Titulo, ca.AT_Nombre, ca.AT_ApellidoPaterno, ca.AT_ApellidoMaterno, ce.ED_Nombre"
			+ " from co_producto cp, co_texto ct, co_autor ca, co_editorial ce "
			+ "where cp.TX_CodigoTexto = ct.TX_CodigoTexto "
			+ "and ca.AT_CodigoAutor = ct.AT_CodigoAutor "
			+ "and ce.ED_CodigoEditorial = ct.ED_CodigoEditorial "
			+ "and cp.PD_TipoProducto = #{idTipoProducto} and ce.ED_Nombre like #{frase} ")
	public Collection<ProductoTextoBean> findByEditorial(FindProductosBean prod);
}
