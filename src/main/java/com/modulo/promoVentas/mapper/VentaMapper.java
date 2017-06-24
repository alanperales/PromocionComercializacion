package com.modulo.promoVentas.mapper;

import java.util.Collection;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.modulo.promoVentas.bean.InsertVentaBean;
import com.modulo.promoVentas.bean.ProductoVentaBean;
import com.modulo.promoVentas.bean.VentaSuspendidaBean;
import com.modulo.promoVentas.model.Venta;
import com.modulo.promoVentas.model.VentaDetalle;

@Mapper
public interface VentaMapper {
	
	public void insertVenta(InsertVentaBean venta);
	
	@Insert("Insert into co_ventadetalle (PV_CodigoVenta,VD_Cantidad, VD_PrecioUnit, VD_PrecioTotal) values (#{idVenta},#{producto.cantidad},#{producto.PD_PrecioUnitario},#{producto.total})")
	public void insertVentaDetalle(@Param("idVenta") int idVenta, @Param("producto")ProductoVentaBean producto);

	@Select("Select * from co_venta order by VT_CodigoVenta desc")
	public Collection<Venta> getUltimaVenta();

	public void insertVentaTmp(InsertVentaBean datosVenta);

	@Insert("Insert into co_ventadetalle_tmp (PV_CodigoVenta,PD_CodigoProducto, VD_Cantidad, VD_PrecioUnit, "
			+ "VD_PrecioTotal) values (#{idVenta},#{producto.PD_CodigoProducto},#{producto.cantidad},#{producto.PD_PrecioUnitario},#{producto.total})")
	public void insertVentaDetalleTmp(@Param("idVenta") int idVenta, @Param("producto")ProductoVentaBean producto);
	
	@Select("Select * from co_venta_tmp vta, tb_persona pers, lb_parametricadet par "
			+ "where vta.PE_CodigoPersonaCliente = pers.PE_CodigoPersona "
			+ "and par.PD_CodigoParametroDet = pers.PD_CodigoTipoDocIdentidad "
			+ "order by VT_CodigoVenta desc")
	public Collection<VentaSuspendidaBean> getOrdenesSuspendidas();

	@Select("Select * from co_ventadetalle_tmp where PV_CodigoVenta=#{idVenta}")
	public Collection<VentaDetalle> getDetalleOrdenSuspendida(@Param("idVenta") int idVenta);

	@Delete("Delete from co_venta_tmp where VT_CodigoVenta=#{idVenta}")
	public void deleteVentaTmp(@Param("idVenta") int idVenta);
}

