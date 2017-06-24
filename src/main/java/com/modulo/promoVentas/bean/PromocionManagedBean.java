package com.modulo.promoVentas.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.modulo.promoVentas.model.DatosPromocion;
import com.modulo.promoVentas.model.Parametro;
import com.modulo.promoVentas.model.Persona;
import com.modulo.promoVentas.model.Producto;
import com.modulo.promoVentas.model.Promocion;
import com.modulo.promoVentas.service.ClienteService;
import com.modulo.promoVentas.service.ParametroService;
import com.modulo.promoVentas.service.ProductoService;
import com.modulo.promoVentas.service.PromocionService;
import com.modulo.promoVentas.utils.Constantes;

@Component
@ManagedBean(name = "promocionManagedBean")
@RequestScoped
public class PromocionManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	PromocionService promocionService;
	@Autowired
	ParametroService parametroService;
	@Autowired
	ProductoService productoService;
	@Autowired
	ClienteService clienteService;

	private int id;
	private String nombre = null;
	private Date pr_fechaInicio = new Date();
	private Date pr_fechaVenc = new Date();
	private int pr_opcionCliente;
	private int pr_opcionProducto;
	private Producto productoEspecifico;
	private Persona clienteEspecifico;
	private DatosPromocion selectedPromo = new DatosPromocion();
	private String nombreRadio;
	private String valorRadio;

	private PromocionDatosBean datosPromocion = new PromocionDatosBean(new Double(1), new Double(1), new Double(1),
			new Double(1), new Double(1));

	public String addPromocion() {
		Promocion promocion = new Promocion();
		promocion.setPr_codigoPromocion(getId());
		promocion.setPr_nombre(getNombre());
		promocion.setPr_opcionCliente(getPr_opcionCliente());
		promocion.setPr_opcionProducto(getPr_opcionProducto());
		promocion.setPr_fechaInicio(getPr_fechaInicio());
		promocion.setPr_fechaVenc(getPr_fechaVenc());
		promocion.setPr_tipoPromocion(datosPromocion.pr_opcionPromocion);
		promocion.setPr_fechaInsercion(new Date());
		promocionService.createPromocion(promocion, datosPromocion);
		clear();
		
		FacesContext context = FacesContext.getCurrentInstance();
		ListadoPromocionManagedBean listadoPromoManagedBean = context.getApplication().evaluateExpressionGet(context, "#{listadoPromocionManagedBean}", ListadoPromocionManagedBean.class);
		listadoPromoManagedBean.findPromocion();
		return "listadoPromociones.xhtml";
	}

	public String editPromocion() {
		Promocion promocion = new Promocion();
		promocion.setPr_codigoPromocion(getSelectedPromo().getPr_codigoPromocion());
		promocion.setPr_nombre(getSelectedPromo().getPr_nombre());
		promocion.setPr_fechaInicio(getSelectedPromo().getPr_fechaInicio());
		promocion.setPr_fechaVenc(getSelectedPromo().getPr_fechaVenc());
		promocion.setPr_opcionCliente(getSelectedPromo().getPr_opcionCliente());
		promocion.setPr_opcionProducto(getSelectedPromo().getPr_opcionProducto());
		promocion.setPr_tipoPromocion(getSelectedPromo().getPr_tipoPromocion());
		if(getTipoCliente()!=null)
			selectedPromo.setRL_TipoCliente(getTipoCliente().getPD_CodigoParametroDet());
		if(getTipoProducto()!=null)
			selectedPromo.setRL_TipoProducto(getTipoProducto().getPD_CodigoParametroDet());
		if(getGeneroLiterario()!=null)
			selectedPromo.setRL_ProdGenero(getGeneroLiterario().getPD_CodigoParametroDet());
		promocionService.modifyPromocion(promocion, selectedPromo);
		clear();
		
		return "listadoPromociones.xhtml";
	}

	public String cancelPromocion() {
		promocionService.cancelPromocion(getSelectedPromo().getPr_codigoPromocion());
		
		clear();
		
		FacesContext context = FacesContext.getCurrentInstance();
		ListadoPromocionManagedBean listadoPromoManagedBean = context.getApplication().evaluateExpressionGet(context, "#{listadoPromocionManagedBean}", ListadoPromocionManagedBean.class);
		
		listadoPromoManagedBean.findPromocion();
		
		return "listadoPromociones.xhtml";
	}
	
	public void validar() {
		Boolean haserror = false;
		
		if(getNombre()==null || getNombre()==""){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", "Debe ingresar un nombre de promoción "));
			haserror = true;
		}
		
		if(getPr_fechaInicio()==null){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", "Debe ingresar una fecha de validez inicial"));
			haserror = true;
		}
		
		if(getPr_fechaVenc()==null){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", "Debe ingresar una fecha de validez final"));
			haserror = true;
		}
		
		if(getPr_fechaInicio()!=null && getPr_fechaVenc()!=null && getPr_fechaInicio().after(getPr_fechaVenc())){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", "La fecha de validez final debe ser mayor a la fecha inicial"));
			haserror = true;
		}
			
			
		if (getPr_opcionProducto() == 0) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", "Debe seleccionar una opción de Producto"));
			haserror = true;
		}
		
		if (getPr_opcionCliente() == 0) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", "Debe seleccionar una opción de Cliente"));
			haserror = true;
		}
		
		if (getPr_opcionPromocion() == 0) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", "Debe seleccionar una opción de Promoción"));
			haserror = true;
		}
		
		if(haserror)
			return;
		else
			RequestContext.getCurrentInstance().execute("PF('dlg3').show()");
	}
	
	public DatosPromocion getSelectedPromo() {
		return selectedPromo;
	}

	public void setSelectedPromo(DatosPromocion selectedPromo) {
		this.selectedPromo = selectedPromo;
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

	public int getPr_opcionCliente() {
		return pr_opcionCliente;
	}
	
	public String getNombreRadio() {
		return nombreRadio;
	}

	public void setNombreRadio(String nombreRadio) {
		this.nombreRadio = nombreRadio;
	}

	public String getValorRadio() {
		return valorRadio;
	}

	public void setValorRadio(String valorRadio) {
		this.valorRadio = valorRadio;
	}

	public void setPr_opcionCliente(int pr_opcionCliente) {
		this.pr_opcionCliente = pr_opcionCliente;
	}

	public int getPr_opcionProducto() {
		return pr_opcionProducto;
	}

	public void setPr_opcionProducto(int pr_opcionProducto) {
		this.pr_opcionProducto = pr_opcionProducto;
	}

	public Collection<Parametro> listGeneros(String query) {
		return parametroService.listAllGeneros();
	}

	public Collection<Parametro> listTiposProducto(String query) {
		return parametroService.listAllTiposProducto();
	}

	public Collection<Parametro> listTiposCliente(String query) {
		return parametroService.listAllTiposCliente();
	}

	public Producto getProductoEspecifico() {
		return productoEspecifico;
	}

	public void setProductoEspecifico(Producto productoEspecifico) {
		this.productoEspecifico = productoEspecifico;
	}

	public Collection<Producto> getListaProductoEspecifico() {
		return datosPromocion.productoEspecifico;
	}

	public Collection<Persona> getListaClienteEspecifico() {
		return datosPromocion.clienteEspecifico;
	}

	public Persona getClienteEspecifico() {
		return clienteEspecifico;
	}

	public void setClienteEspecifico(Persona clienteEspecifico) {
		this.clienteEspecifico = clienteEspecifico;
	}

	public int getPr_opcionPromocion() {
		return datosPromocion.pr_opcionPromocion;
	}

	public void setPr_opcionPromocion(int pr_opcionPromocion) {
		this.datosPromocion.pr_opcionPromocion = pr_opcionPromocion;
	}

	public Collection<Producto> listProductos(String query) {
		return productoService.listProductos(query);
	}

	public Collection<Persona> listClientes(String query) {
		return clienteService.listClientes(query);
	}

	public Parametro getTipoProducto() {
		return datosPromocion.tipoProducto;
	}

	public void setTipoProducto(Parametro tipoProducto) {
		this.datosPromocion.tipoProducto = tipoProducto;
	}

	public Parametro getGeneroLiterario() {
		return datosPromocion.generoLiterario;
	}

	public void setGeneroLiterario(Parametro generoLiterario) {
		this.datosPromocion.generoLiterario = generoLiterario;
	}

	public Parametro getTipoCliente() {
		return datosPromocion.tipoCliente;
	}

	public void setTipoCliente(Parametro tipoCliente) {
		this.datosPromocion.tipoCliente = tipoCliente;
	}

	public int getPromoPorCantCantidad() {
		return datosPromocion.promoPorCantCantidad;
	}

	public void setPromoPorCantCantidad(int promoPorCantCantidad) {
		this.datosPromocion.promoPorCantCantidad = promoPorCantCantidad;
	}

	public Double getPromoPorCantPrecio() {
		return datosPromocion.promoPorCantPrecio;
	}

	public void setPromoPorCantPrecio(Double promoPorCantPrecio) {
		this.datosPromocion.promoPorCantPrecio = promoPorCantPrecio;
	}

	public Double getPromoRebajaPrecio() {
		return datosPromocion.promoRebajaPrecio;
	}

	public void setPromoRebajaPrecio(Double promoRebajaPrecio) {
		this.datosPromocion.promoRebajaPrecio = promoRebajaPrecio;
	}

	public Double getPromoRebajaPorcentaje() {
		return datosPromocion.promoRebajaPorcentaje;
	}

	public void setPromoRebajaPorcentaje(Double promoRebajaPorcentaje) {
		this.datosPromocion.promoRebajaPorcentaje = promoRebajaPorcentaje;
	}

	public Double getPromoPorMontoMayor() {
		return datosPromocion.promoPorMontoMayor;
	}

	public void setPromoPorMontoMayor(Double promoPorMontoMayor) {
		this.datosPromocion.promoPorMontoMayor = promoPorMontoMayor;
	}

	public Double getPromoPorMontoMayorPrecio() {
		return datosPromocion.promoPorMontoMayorPrecio;
	}

	public void setPromoPorMontoMayorPrecio(Double promoPorMontoMayorPrecio) {
		this.datosPromocion.promoPorMontoMayorPrecio = promoPorMontoMayorPrecio;
	}

	public void agregarProducto() {
		if (datosPromocion.productoEspecifico == null)
			datosPromocion.productoEspecifico = new ArrayList<Producto>();
		else
			for (Producto produ : datosPromocion.productoEspecifico) {
				if (produ.getPD_CodigoProducto() == getProductoEspecifico().getPD_CodigoProducto())
					return;
			}
		datosPromocion.productoEspecifico.add(getProductoEspecifico());
	}

	public void agregarCliente() {
		if (datosPromocion.clienteEspecifico == null)
			datosPromocion.clienteEspecifico = new ArrayList<Persona>();
		else
			for (Persona clte : datosPromocion.clienteEspecifico) {
				if (clte.getPE_CodigoPersona() == getClienteEspecifico().getPE_CodigoPersona())
					return;
			}
		datosPromocion.clienteEspecifico.add(getClienteEspecifico());
	}
	
	public void agregarClienteModificado() {
		if (selectedPromo.getClientes() == null)
			selectedPromo.setClientes(new ArrayList<Persona>());
		else
			for (Persona clte : selectedPromo.getClientes()) {
				if (clte.getPE_CodigoPersona() == getClienteEspecifico().getPE_CodigoPersona())
					return;
			}
		List<Persona> clientes = selectedPromo.getClientes();
		clientes.add(getClienteEspecifico());
		selectedPromo.setClientes(clientes);
	}
	
	public void agregarProductoModificado() {
		if (selectedPromo.getProductos() == null)
			selectedPromo.setProductos(new ArrayList<Producto>());
		else
			for (Producto produ : selectedPromo.getProductos()) {
				if (produ.getPD_CodigoProducto() == getProductoEspecifico().getPD_CodigoProducto())
					return;
			}
		List<Producto> productos = selectedPromo.getProductos();
		productos.add(getProductoEspecifico());
		selectedPromo.setProductos(productos);
	}
	
	public void clear(){
		id = 0;
		nombre = null;
		pr_fechaInicio = null;
		pr_fechaVenc = null;
		pr_opcionCliente = 0;
		pr_opcionProducto = 0;
		productoEspecifico = null;
		clienteEspecifico = null;
		selectedPromo = new DatosPromocion();
	}
	
	public void actualizarRadioProd2(){
		pr_opcionProducto = 2;		
	}
	public void actualizarRadioProd3(){
		pr_opcionProducto = 3;		
	}
	public void actualizarRadioProd4(){
			pr_opcionProducto = 4;		
	}
	public void actualizarRadioCli1(){
		pr_opcionCliente = 1;		
	}
	public void actualizarRadioCli2(){
		pr_opcionCliente = 2;		
	}
	public void actualizarRadioProm20(){
		datosPromocion.pr_opcionPromocion = 20;		
	}
	public void actualizarRadioProm19(){
		datosPromocion.pr_opcionPromocion = 19;		
	}
	public void actualizarRadioProm21(){
		datosPromocion.pr_opcionPromocion = 21;		
	}
	public void actualizarRadioProm22(){
		datosPromocion.pr_opcionPromocion = 22;		
	}
}
