package com.modulo.promoVentas.bean;

import com.modulo.promoVentas.model.Venta;

public class VentaSuspendidaBean extends Venta {

	private String PE_Nombre;
	private String PE_ApellidoPaterno;
	private String PE_ApellidoMaterno;
	private int PD_CodigoTipoDocIdentidad;
	private String PE_NumeroDocIdentidad;
	private String PD_NombreElemento;
	
	public String getTipoDocumento() {
		return PD_NombreElemento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.PD_NombreElemento = tipoDocumento;
	}

	public String getNombreCompleto() {
		return PE_Nombre +" "+PE_ApellidoPaterno+" "+PE_ApellidoMaterno;
	}

	public String getPE_Nombre() {
		return PE_Nombre;
	}

	public void setPE_Nombre(String pE_Nombre) {
		PE_Nombre = pE_Nombre;
	}

	public String getPE_ApellidoPaterno() {
		return PE_ApellidoPaterno;
	}

	public void setPE_ApellidoPaterno(String pE_ApellidoPaterno) {
		PE_ApellidoPaterno = pE_ApellidoPaterno;
	}

	public String getPE_ApellidoMaterno() {
		return PE_ApellidoMaterno;
	}

	public void setPE_ApellidoMaterno(String pE_ApellidoMaterno) {
		PE_ApellidoMaterno = pE_ApellidoMaterno;
	}

	public int getPD_CodigoTipoDocIdentidad() {
		return PD_CodigoTipoDocIdentidad;
	}

	public void setPD_CodigoTipoDocIdentidad(int pD_CodigoTipoDocIdentidad) {
		PD_CodigoTipoDocIdentidad = pD_CodigoTipoDocIdentidad;
	}

	public String getPE_NumeroDocIdentidad() {
		return PE_NumeroDocIdentidad;
	}

	public void setPE_NumeroDocIdentidad(String pE_NumeroDocIdentidad) {
		PE_NumeroDocIdentidad = pE_NumeroDocIdentidad;
	}

}
