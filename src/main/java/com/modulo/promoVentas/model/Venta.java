package com.modulo.promoVentas.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venta {

	private int VT_CodigoVenta;
	private int VT_TipoDocumentoVenta;
	private String VT_DocumentoSerie;
	private int PE_CodigoPersonaCliente;
	private int PE_CodigoPersonaTrabajador;
	private Date VT_FechaVenta;
	private int VT_EstadoVenta;
	private Double VT_SubTotal;
	private Double VT_ValorIGV;
	private Double VT_Total;

	public int getVT_CodigoVenta() {
		return VT_CodigoVenta;
	}

	public void setVT_CodigoVenta(int vT_CodigoVenta) {
		VT_CodigoVenta = vT_CodigoVenta;
	}

	public int getVT_TipoDocumentoVenta() {
		return VT_TipoDocumentoVenta;
	}

	public void setVT_TipoDocumentoVenta(int vT_TipoDocumentoVenta) {
		VT_TipoDocumentoVenta = vT_TipoDocumentoVenta;
	}

	public String getVT_DocumentoSerie() {
		return VT_DocumentoSerie;
	}

	public void setVT_DocumentoSerie(String vT_DocumentoSerie) {
		VT_DocumentoSerie = vT_DocumentoSerie;
	}

	public int getPE_CodigoPersonaCliente() {
		return PE_CodigoPersonaCliente;
	}

	public void setPE_CodigoPersonaCliente(int pE_CodigoPersonaCliente) {
		PE_CodigoPersonaCliente = pE_CodigoPersonaCliente;
	}

	public int getPE_CodigoPersonaTrabajador() {
		return PE_CodigoPersonaTrabajador;
	}

	public void setPE_CodigoPersonaTrabajador(int pE_CodigoPersonaTrabajador) {
		PE_CodigoPersonaTrabajador = pE_CodigoPersonaTrabajador;
	}

	public Date getVT_FechaVenta() {
		return VT_FechaVenta;
	}

	public void setVT_FechaVenta(Date vT_FechaVenta) {
		VT_FechaVenta = vT_FechaVenta;
	}

	public int getVT_EstadoVenta() {
		return VT_EstadoVenta;
	}

	public void setVT_EstadoVenta(int vT_EstadoVenta) {
		VT_EstadoVenta = vT_EstadoVenta;
	}

	public Double getVT_SubTotal() {
		return VT_SubTotal;
	}

	public void setVT_SubTotal(Double vT_SubTotal) {
		VT_SubTotal = vT_SubTotal;
	}

	public Double getVT_ValorIGV() {
		return VT_ValorIGV;
	}

	public void setVT_ValorIGV(Double vT_ValorIGV) {
		VT_ValorIGV = vT_ValorIGV;
	}

	public Double getVT_Total() {
		return VT_Total;
	}

	public void setVT_Total(Double vT_Total) {
		VT_Total = vT_Total;
	}

}
