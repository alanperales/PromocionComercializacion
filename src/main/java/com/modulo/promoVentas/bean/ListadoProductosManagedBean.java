package com.modulo.promoVentas.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.modulo.promoVentas.model.DatosPromocion;
import com.modulo.promoVentas.model.Parametro;
import com.modulo.promoVentas.model.Producto;
import com.modulo.promoVentas.service.ParametroService;
import com.modulo.promoVentas.service.ProductoService;
import com.modulo.promoVentas.utils.Constantes;

@Component
@ManagedBean(name = "listadoProductosManagedBean")
@RequestScoped
public class ListadoProductosManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";

	private String frase;
	private Parametro campo;
	private Parametro tipoProducto;
	private Collection<ProductoTextoBean> productos;
	private ProductoTextoBean selectedProd;

	@Autowired
	ParametroService parametroService;
	@Autowired
	ProductoService productoService;

	public ProductoTextoBean getSelectedProd() {
		return selectedProd;
	}

	public void setSelectedProd(ProductoTextoBean selectedProd) {
		this.selectedProd = selectedProd;
	}

	public Parametro getCampo() {
		return campo;
	}

	public void setCampo(Parametro campo) {
		this.campo = campo;
	}

	public Parametro getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(Parametro tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public String getFrase() {
		return frase;
	}

	public void setFrase(String frase) {
		this.frase = frase;
	}

	public Collection<ProductoTextoBean> getProductos() {
		return productos;
	}

	public void setProductos(Collection<ProductoTextoBean> productos) {
		this.productos = productos;
	}

	public Collection<Parametro> listTiposProducto(String query) {
		return parametroService.listAllTiposProducto();
	}

	public void findProducto() {
		FindProductosBean prod = new FindProductosBean();
		prod.setFrase(getFrase());
		prod.setIdCampo(getCampo().getPD_CodigoParametroDet());
		prod.setIdTipoProducto(getTipoProducto().getPD_CodigoParametroDet());
		productos = productoService.findBy(prod);
	}

	public Collection<Parametro> listCampo(String query) {
		Collection<Parametro> tiposPromos = new ArrayList<Parametro>();
		Parametro promo = new Parametro();
		promo.setPD_CodigoParametroDet(Constantes.BUSQ_POR_AUTOR);
		promo.setPD_NombreElemento("Autor");
		tiposPromos.add(promo);
		promo = new Parametro();
		promo.setPD_CodigoParametroDet(Constantes.BUSQ_POR_EDITORIAL);
		promo.setPD_NombreElemento("Editorial");
		tiposPromos.add(promo);
		promo = new Parametro();
		promo.setPD_CodigoParametroDet(Constantes.BUSQ_POR_TEMA);
		promo.setPD_NombreElemento("Tema");
		tiposPromos.add(promo);
		promo = new Parametro();
		promo.setPD_CodigoParametroDet(Constantes.BUSQ_POR_TITULO);
		promo.setPD_NombreElemento("Titulo");
		tiposPromos.add(promo);
		return tiposPromos;
	}

	public void cargarProducto() {
		FindProductosBean prod = new FindProductosBean();
		prod.setFrase(getFrase());
		prod.setIdCampo(getCampo().getPD_CodigoParametroDet());
		prod.setIdTipoProducto(getTipoProducto().getPD_CodigoParametroDet());
		productoService.findBy(prod);

		FacesContext context = FacesContext.getCurrentInstance();
		VentasManagedBean ventasManagedBean = context.getApplication().evaluateExpressionGet(context,
				"#{ventasManagedBean}", VentasManagedBean.class);

		ventasManagedBean.setDescripcion(getSelectedProd().getPD_Descripcion());
		ventasManagedBean.setPrecio(getSelectedProd().getPD_PrecioUnitario());
		ventasManagedBean.setEditorial(getSelectedProd().getED_Nombre());
		ventasManagedBean.setCodigoProducto(getSelectedProd().getPD_CodigoProducto());
	}
}
