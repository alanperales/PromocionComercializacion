package com.modulo.promoVentas.bean;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.modulo.promoVentas.model.DatosCliente;
import com.modulo.promoVentas.model.DatosProducto;
import com.modulo.promoVentas.model.DatosPromocion;
import com.modulo.promoVentas.model.Parametro;
import com.modulo.promoVentas.model.Persona;
import com.modulo.promoVentas.model.Producto;
import com.modulo.promoVentas.service.ClienteService;
import com.modulo.promoVentas.service.ParametroService;
import com.modulo.promoVentas.service.ProductoService;
import com.modulo.promoVentas.service.PromocionService;

@Component
@ManagedBean(name = "listadoPromocionManagedBean")
@ViewScoped
public class ListadoPromocionManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	PromocionService promocionService;
	@Autowired
	ProductoService productoService;
	@Autowired
	ClienteService clienteService;
	@Autowired
	ParametroService parametroService;
	
	private String nombrePromocion;
	private Date pr_fechaInicio;
	private Date pr_fechaVenc;
	private String nombreCliente;
	private String nombreProducto;
	private String tipoCliente;
	private Parametro tipoPromocion;
	private Parametro estadoPromocion;
	private Collection<DatosPromocion> promociones;
	private DatosPromocion selectedPromo;
	private DatosProducto datosProductoSelectedPromo = new DatosProducto();
	private DatosCliente datosClienteSelectedPromo = new DatosCliente();
	
	
	public DatosProducto getDatosProductoSelectedPromo() {
		return datosProductoSelectedPromo;
	}
	public void setDatosProductoSelectedPromo(DatosProducto datosProductoSelectedPromo) {
		this.datosProductoSelectedPromo = datosProductoSelectedPromo;
	}
	public DatosCliente getDatosClienteSelectedPromo() {
		return datosClienteSelectedPromo;
	}
	public void setDatosClienteSelectedPromo(DatosCliente datosClienteSelectedPromo) {
		this.datosClienteSelectedPromo = datosClienteSelectedPromo;
	}
	public Parametro getEstadoPromocion() {
		return estadoPromocion;
	}
	public void setEstadoPromocion(Parametro estadoPromocion) {
		this.estadoPromocion = estadoPromocion;
	}
	public DatosPromocion getSelectedPromo() {
		return selectedPromo;
	}
	public void setSelectedPromo(DatosPromocion selectedPromo) {
		this.selectedPromo = selectedPromo;
	}
	public Collection<Producto> listProductos(String query){
		return productoService.listAll();
	}
	public Collection<Persona> listClientes(String query){
		return clienteService.listAll();
	}
	public Collection<Parametro> listGeneros(String query){
		return parametroService.listAllGeneros();
	}
	public Collection<Parametro> listTiposProducto(String query){
		return parametroService.listAllTiposProducto();
	}
	public Collection<Parametro> listTipoClientes(String query){
		return parametroService.listAllTiposCliente();
	}
	public Collection<Parametro> listTipoPromocion(String query){
		return parametroService.listAllTiposPromocion();
	}
	public Collection<Parametro> listEstadoPromocion(String query){
		return parametroService.listAllEstadosPromocion();
	}
	public void findPromocion(){
		FindPromocionesBean promocion = new FindPromocionesBean();
		promocion.setPr_nombre(getNombrePromocion());
		promocion.setPr_fechaInicio(getPr_fechaInicio());
		promocion.setPr_fechaVenc(getPr_fechaVenc());
		promocion.setCliente(getNombreCliente());
		promocion.setProducto(getNombreProducto());
		promocion.setTipoCliente(getTipoCliente());
		if(getTipoPromocion()!=null)
			promocion.setTipoPromocion(getTipoPromocion().getPD_CodigoParametroDet());
		if(getEstadoPromocion()!=null)
			promocion.setEstadoPromocion(getEstadoPromocion().getPD_CodigoParametroDet());
		promociones = promocionService.findBy(promocion);
	}

	public String createPromocion(){
		return "nuevaPromocion.xhtml";
	}
	
	public Parametro getTipoPromocion() {
		return tipoPromocion;
	}
	public void setTipoPromocion(Parametro tipoPromocion) {
		this.tipoPromocion = tipoPromocion;
	}
	public String getNombrePromocion() {
		return nombrePromocion;
	}
	public void setNombrePromocion(String nombrePromocion) {
		this.nombrePromocion = nombrePromocion;
	}
	public Date getPr_fechaInicio() {
		return pr_fechaInicio;
	}
	public void setPr_fechaInicio(Date pr_fechaInicio) {
		this.pr_fechaInicio = pr_fechaInicio;
	}
	public Date getPr_fechaVenc() {
		return pr_fechaVenc;
	}
	public void setPr_fechaVenc(Date pr_fechaVenc) {
		this.pr_fechaVenc = pr_fechaVenc;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	public Collection<DatosPromocion> getPromociones() {
		return promociones;
	}
	public void setPromociones(Collection<DatosPromocion> promociones) {
		this.promociones = promociones;
	}
	public void clear() {
		nombrePromocion = null;
		pr_fechaInicio = null;
		pr_fechaVenc= null;
		nombreCliente= null;
		nombreProducto= null;
		tipoCliente= null;
		tipoPromocion= null;
		promociones= null;
		estadoPromocion= null;
	}
	public void obtenerInfoPromocion(){

		if(selectedPromo.getPr_opcionCliente()==2){
			datosClienteSelectedPromo.setTipoCliente(parametroService.getParametro(selectedPromo.getRL_TipoCliente()).getPD_NombreElemento());
			datosClienteSelectedPromo.setTipoClienteParam(parametroService.getParametro(selectedPromo.getRL_TipoCliente()));
		}
		
		if(selectedPromo.getPr_opcionCliente()==3){
			datosClienteSelectedPromo.setTipoCliente(parametroService.getParametro(selectedPromo.getRL_TipoCliente()).getPD_NombreElemento());
			datosClienteSelectedPromo.setTipoClienteParam(parametroService.getParametro(selectedPromo.getRL_TipoCliente()));
			datosClienteSelectedPromo.setClientes(promocionService.getClientesEspecificos(selectedPromo.getPr_codigoPromocion()));
		}
				
		if(selectedPromo.getPr_opcionProducto()==2){
			datosProductoSelectedPromo.setGeneroLiterario(parametroService.getParametro(selectedPromo.getRL_ProdGenero()).getPD_NombreElemento());
			datosProductoSelectedPromo.setGeneroLiterarioParam(parametroService.getParametro(selectedPromo.getRL_ProdGenero()));
		}
			
		if(selectedPromo.getPr_opcionProducto()==3){
			datosProductoSelectedPromo.setTipoProducto(parametroService.getParametro(selectedPromo.getRL_TipoProducto()).getPD_NombreElemento());
			datosProductoSelectedPromo.setTipoProductoParam(parametroService.getParametro(selectedPromo.getRL_TipoProducto()));
			datosProductoSelectedPromo.setProductos(promocionService.getProductosEspecificos(selectedPromo.getPr_codigoPromocion()));
		}
	}

	public void cargarInfoPromocion(){

		FacesContext context = FacesContext.getCurrentInstance();
		PromocionManagedBean promoManagedBean = context.getApplication().evaluateExpressionGet(context, "#{promocionManagedBean}", PromocionManagedBean.class);
		
		selectedPromo.setClientes(promocionService.getClientesEspecificos(selectedPromo.getPr_codigoPromocion()));
		selectedPromo.setProductos(promocionService.getProductosEspecificos(selectedPromo.getPr_codigoPromocion()));
		promoManagedBean.setSelectedPromo(getSelectedPromo());
		promoManagedBean.setGeneroLiterario(datosProductoSelectedPromo.getGeneroLiterarioParam());
		promoManagedBean.setTipoProducto(datosProductoSelectedPromo.getTipoProductoParam());
		promoManagedBean.setTipoCliente(datosClienteSelectedPromo.getTipoClienteParam());
	}
	
	
	
}
