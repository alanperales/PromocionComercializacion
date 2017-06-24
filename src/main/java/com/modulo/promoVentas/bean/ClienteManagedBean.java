package com.modulo.promoVentas.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.modulo.promoVentas.model.Cliente;
import com.modulo.promoVentas.model.Parametro;
import com.modulo.promoVentas.service.ClienteService;
import com.modulo.promoVentas.service.ParametroService;

@Component
@ManagedBean(name = "clienteManagedBean")
@RequestScoped
public class ClienteManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	ClienteService clienteService;
	@Autowired
	ParametroService parametroService;
	
	private Parametro tipoCliente;
	private String nombres;
	private String apellidos;
	private Parametro tipoDocumento;
	private String numeroDocumento;
	private String direccion;
	private String departamento;
	private String provincia;
	private String distrito;
	private String telefono;
	private String email;
	private String minorista;
	
	
	public String getMinorista() {
		return minorista;
	}
	public void setMinorista(String minorista) {
		this.minorista = minorista;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Parametro getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(Parametro tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public Parametro getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(Parametro tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void addCliente(){
		Cliente cliente = new Cliente();
		cliente.setPE_Nombre(getNombres());
		cliente.setPE_ApellidoPaterno(getApellidos());
		cliente.setPD_CodigoTipoDocIdentidad(getTipoDocumento().getPD_CodigoParametroDet());
		cliente.setPE_NumeroDocIdentidad(getNumeroDocumento());
		cliente.setPE_Direccion(getDireccion());
		cliente.setPE_Urbanizacion(getDepartamento()+getDistrito()+getProvincia());
		cliente.setPE_Celular(getTelefono());
		cliente.setPE_EmailPersonal(getEmail());
		
		clienteService.createCliente(cliente);
		
		FacesContext context = FacesContext.getCurrentInstance();
		VentasManagedBean ventasManagedBean = context.getApplication().evaluateExpressionGet(context, "#{ventasManagedBean}", VentasManagedBean.class);
		ventasManagedBean.setDescripcionCliente(getNombres()+" "+getApellidos());
		ventasManagedBean.setCliente(cliente);
	}

	public Collection<Parametro> listTipoClientes(String query){
		Collection<Parametro> tiposPromos = new ArrayList<Parametro>();
		Parametro promo = new Parametro();
		promo.setPD_CodigoParametroDet(1);
		promo.setPD_NombreElemento("Natural");
		tiposPromos.add(promo);
		promo = new Parametro();
		promo.setPD_CodigoParametroDet(2);
		promo.setPD_NombreElemento("Jurídico");
		tiposPromos.add(promo);
		return tiposPromos;
	}

	public Collection<Parametro> listTipoDocumento(String query){
		return parametroService.listAllTiposDocumento();
	}
}
