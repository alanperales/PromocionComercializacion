package com.modulo.promoVentas.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.modulo.promoVentas.model.Cliente;
import com.modulo.promoVentas.model.Parametro;
import com.modulo.promoVentas.model.Persona;
import com.modulo.promoVentas.model.Producto;
import com.modulo.promoVentas.model.VentaDetalle;
import com.modulo.promoVentas.service.ClienteService;
import com.modulo.promoVentas.service.ParametroService;
import com.modulo.promoVentas.service.ProductoService;
import com.modulo.promoVentas.service.VentaService;
import com.modulo.promoVentas.utils.Constantes;

@Component
@ManagedBean(name = "ventasManagedBean")
@RequestScoped
public class VentasManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	ProductoService productoService;
	@Autowired
	VentaService ventaService;
	@Autowired
	ParametroService parametroService;
	@Autowired
	ClienteService clienteService;

	InsertVentaBean data = new InsertVentaBean();
	private Collection<VentaSuspendidaBean> ventasSuspendidas;
	private VentaSuspendidaBean selectedVentaSuspendida;
	private ProductoVentaBean selectedProducto;
	private int cantidadModificada;

	
	public int getCantidadModificada() {
		return cantidadModificada;
	}

	public void setCantidadModificada(int cantidadModificada) {
		this.cantidadModificada = cantidadModificada;
	}

	public String getCodOrden() {
		return ventaService.calculateCodOrden();
	}

	public ProductoVentaBean getSelectedProducto() {
		return selectedProducto;
	}

	public void setSelectedProducto(ProductoVentaBean selectedProducto) {
		this.selectedProducto = selectedProducto;
	}

	public VentaSuspendidaBean getSelectedVentaSuspendida() {
		return selectedVentaSuspendida;
	}

	public void setSelectedVentaSuspendida(VentaSuspendidaBean selectedVentaSuspendida) {
		this.selectedVentaSuspendida = selectedVentaSuspendida;
	}

	public Collection<VentaSuspendidaBean> getVentasSuspendidas() {
		return ventasSuspendidas;
	}

	public void setVentasSuspendidas(Collection<VentaSuspendidaBean> ventasSuspendidas) {
		this.ventasSuspendidas = ventasSuspendidas;
	}

	public void setCliente(Cliente cliente) {
		data.cliente = cliente;
	}

	public Double getSubtotal() {
		return data.subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.data.subtotal = subtotal;
	}

	public Double getIgv() {
		return data.igv;
	}

	public void setIgv(Double igv) {
		this.data.igv = igv;
	}

	public Double getTotal() {
		return data.total;
	}

	public void setTotal(Double total) {
		this.data.total = total;
	}

	public String getTipoComprobante() {
		return data.tipoComprobante;
	}

	public void setTipoComprobante(String tipoComprobante) {
		this.data.tipoComprobante = tipoComprobante;
	}

	public int getCodigoProducto() {
		return data.codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.data.codigoProducto = codigoProducto;
	}

	public String getDescripcion() {
		return data.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.data.descripcion = descripcion;
	}

	public String getEditorial() {
		return data.editorial;
	}

	public void setEditorial(String editorial) {
		this.data.editorial = editorial;
	}

	public Double getPrecio() {
		return data.Precio;
	}

	public void setPrecio(Double precio) {
		data.Precio = precio;
	}

	public Parametro getTipoDocumento() {
		return data.tipoDocumento;
	}

	public void setTipoDocumento(Parametro tipoDocumento) {
		this.data.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return data.numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.data.numeroDocumento = numeroDocumento;
	}

	public String getDescripcionCliente() {
		return data.descripcionCliente;
	}

	public void setDescripcionCliente(String descripcionCliente) {
		this.data.descripcionCliente = descripcionCliente;
	}

	public String findProducto() {
		return "listadoProductos.xhtml";
	}

	public String addCliente() {
		return "nuevoCliente.xhtml";
	}

	public Collection<ProductoVentaBean> getProductos() {
		return data.productos;
	}

	public void setProductos(Collection<ProductoVentaBean> productos) {
		this.data.productos = productos;
	}

	public void addProducto() {
		if (data.productos == null)
			data.productos = new ArrayList<ProductoVentaBean>();
		else
			for (ProductoVentaBean produ : data.productos) {
				if (produ.getPD_CodigoProducto() == data.codigoProducto)
					return;
			}
		ProductoVentaBean prod = productoService.getProductoVenta(data.codigoProducto);

		data.productos.add(prod);

		ventaService.calculateTotal(data);
	}

	public void generarOrdenCompra() {	
		ventaService.generarOrdenCompra(data);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Orden Generada", "Su orden de compra se generó exitosamente"));

		cancelarOrdenCompra();
	}

	public void cancelarOrdenCompra() {
		data.productos = null;
		data.codigoProducto = 0;
		data.descripcion = null;
		data.editorial = null;
		data.Precio = null;
		data.tipoDocumento = null;
		data.numeroDocumento = null;
		data.descripcionCliente = null;
		data.igv = 0.00;
		data.subtotal = 0.00;
		data.total = 0.00;
	}

	public void suspenderVenta() {
		ventaService.suspenderVenta(data);

	}

	public void modificarCantidad() {
		ventaService.calculateTotal(data);
	}

	public void reanudarVenta() {
		setNumeroDocumento(selectedVentaSuspendida.getPE_NumeroDocIdentidad());
		setDescripcionCliente(selectedVentaSuspendida.getNombreCompleto());
		setIgv(selectedVentaSuspendida.getVT_ValorIGV());
		setSubtotal(selectedVentaSuspendida.getVT_SubTotal());
		setTotal(selectedVentaSuspendida.getVT_Total());
		Collection<VentaDetalle> detallesSuspendidas = ventaService
				.getDetalleVentaSuspendida(selectedVentaSuspendida.getVT_CodigoVenta());

		Collection<ProductoVentaBean> productosSuspendidos = new ArrayList<ProductoVentaBean>();
		for (VentaDetalle ventaDetalle : detallesSuspendidas) {
			ProductoVentaBean prod = new ProductoVentaBean();
			prod.setPD_CodigoProducto(ventaDetalle.getPD_CodigoProducto());
			prod.setCantidad(ventaDetalle.getVD_Cantidad());
			prod.setPD_PrecioUnitario(ventaDetalle.getVD_PrecioUnit());
			prod.setTotal(ventaDetalle.getVD_PrecioTotal());
			Producto producto = productoService.getProducto(ventaDetalle.getPD_CodigoProducto());
			prod.setPD_Descripcion(producto.getPD_Descripcion());
			productosSuspendidos.add(prod);
		}
		data.productos = productosSuspendidos;
		data.idVentaSuspendida = selectedVentaSuspendida.getVT_CodigoVenta();
	}

	public void buscarSuspendidas() {
		ventasSuspendidas = ventaService.buscarSuspendidas();
	}
	
	public void validarOrden() {
		Boolean haserror = false;
		if (data.productos == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", "debe ingresar al menos un producto "));
			haserror = true;
		}
		
		if (data.cliente == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", "debe ingresar un cliente"));
			haserror = true;
		}

		if (!data.tipoComprobante.equals(Constantes.FACTURA) && !data.tipoComprobante.equals(Constantes.BOLETA_VENTA)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", "debe ingresar un tipo de comprobante"));
			haserror = true;
		}
		if(haserror)
			return;
		else
			RequestContext.getCurrentInstance().execute("PF('dlg3').show()");
	}

	public String onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();
		return "ventas.xhtml";
	}

	public void eliminarProducto() {
		Collection<ProductoVentaBean> prodActualizado = new ArrayList<ProductoVentaBean>();
		for (ProductoVentaBean prod : data.productos) {
			if (prod.getPD_CodigoProducto() != selectedProducto.getPD_CodigoProducto()) {
				prodActualizado.add(prod);
			}
		}
		data.productos = prodActualizado;
		ventaService.calculateTotal(data);
	}

	public Collection<Parametro> listTipoDocumento(String query) {
		return parametroService.listAllTiposDocumento();
	}

	public void buscarPorDocumento() {
		if (getNumeroDocumento().length() > 7) {
			if (getTipoDocumento() == null) {
				Parametro par = new Parametro();
				par.setPD_CodigoParametroDet(1);
				par.setPD_NombreElemento("DNI");
				setTipoDocumento(par);
			}
			Persona persona = clienteService.getByDNI(getNumeroDocumento(),
					getTipoDocumento().getPD_CodigoParametroDet());
			setDescripcionCliente(persona.getPE_Nombre() + " " + persona.getPE_ApellidoPaterno() + " "
					+ persona.getPE_ApellidoMaterno());
			data.cliente = persona;
		}
	}

	public void buscarProducto() {
		FindProductosBean req = new FindProductosBean();
		req.setFrase(String.valueOf(getCodigoProducto()));
		req.setIdCampo(Constantes.BUSQ_POR_ID);
		Collection<ProductoTextoBean> producto = productoService.findBy(req);
		if (producto != null && !producto.isEmpty()) {
			ProductoTextoBean pr = (ProductoTextoBean) producto.toArray()[0];
			setDescripcion(pr.getPD_Descripcion());
			setPrecio(pr.getPD_PrecioUnitario());
			setEditorial(pr.getED_Nombre());
		}
	}

}
