package com.modulo.promoVentas.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

	private int PE_CodigoPersona;
	private String PE_Nombre;
	private String PE_ApellidoPaterno;
	private String PE_ApellidoMaterno;
	private Date PE_FechaNacimiento;
	private String PE_NumeroDocIdentidad;
	private String PE_EmailPersonal;
	private String PE_Direccion;
	private String PE_Urbanizacion;
	private String PE_ReferenciaDomiciliaria;
	private String PE_TelefonoCasa;
	private String PE_Celular;
	private int PE_Sexo;
	private int PD_CodigoEstadoCivil;
	private int UB_CodigoUbigeo;
	private int PD_CodigoTipoDocIdentidad;
	private String PE_RutaFoto;
	private Date PE_FechaRegistro;
	private String PE_FechaActualizacion;
	
	public int getPE_CodigoPersona() {
		return PE_CodigoPersona;
	}
	public void setPE_CodigoPersona(int pE_CodigoPersona) {
		PE_CodigoPersona = pE_CodigoPersona;
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
	public Date getPE_FechaNacimiento() {
		return PE_FechaNacimiento;
	}
	public void setPE_FechaNacimiento(Date pE_FechaNacimiento) {
		PE_FechaNacimiento = pE_FechaNacimiento;
	}
	public String getPE_NumeroDocIdentidad() {
		return PE_NumeroDocIdentidad;
	}
	public void setPE_NumeroDocIdentidad(String pE_NumeroDocIdentidad) {
		PE_NumeroDocIdentidad = pE_NumeroDocIdentidad;
	}
	public String getPE_EmailPersonal() {
		return PE_EmailPersonal;
	}
	public void setPE_EmailPersonal(String pE_EmailPersonal) {
		PE_EmailPersonal = pE_EmailPersonal;
	}
	public String getPE_Direccion() {
		return PE_Direccion;
	}
	public void setPE_Direccion(String pE_Direccion) {
		PE_Direccion = pE_Direccion;
	}
	public String getPE_Urbanizacion() {
		return PE_Urbanizacion;
	}
	public void setPE_Urbanizacion(String pE_Urbanizacion) {
		PE_Urbanizacion = pE_Urbanizacion;
	}
	public String getPE_ReferenciaDomiciliaria() {
		return PE_ReferenciaDomiciliaria;
	}
	public void setPE_ReferenciaDomiciliaria(String pE_ReferenciaDomiciliaria) {
		PE_ReferenciaDomiciliaria = pE_ReferenciaDomiciliaria;
	}
	public String getPE_TelefonoCasa() {
		return PE_TelefonoCasa;
	}
	public void setPE_TelefonoCasa(String pE_TelefonoCasa) {
		PE_TelefonoCasa = pE_TelefonoCasa;
	}
	public String getPE_Celular() {
		return PE_Celular;
	}
	public void setPE_Celular(String pE_Celular) {
		PE_Celular = pE_Celular;
	}
	public int getPE_Sexo() {
		return PE_Sexo;
	}
	public void setPE_Sexo(int pE_Sexo) {
		PE_Sexo = pE_Sexo;
	}
	public int getPD_CodigoEstadoCivil() {
		return PD_CodigoEstadoCivil;
	}
	public void setPD_CodigoEstadoCivil(int pD_CodigoEstadoCivil) {
		PD_CodigoEstadoCivil = pD_CodigoEstadoCivil;
	}
	public int getUB_CodigoUbigeo() {
		return UB_CodigoUbigeo;
	}
	public void setUB_CodigoUbigeo(int uB_CodigoUbigeo) {
		UB_CodigoUbigeo = uB_CodigoUbigeo;
	}
	public int getPD_CodigoTipoDocIdentidad() {
		return PD_CodigoTipoDocIdentidad;
	}
	public void setPD_CodigoTipoDocIdentidad(int pD_CodigoTipoDocIdentidad) {
		PD_CodigoTipoDocIdentidad = pD_CodigoTipoDocIdentidad;
	}
	public String getPE_RutaFoto() {
		return PE_RutaFoto;
	}
	public void setPE_RutaFoto(String pE_RutaFoto) {
		PE_RutaFoto = pE_RutaFoto;
	}
	public Date getPE_FechaRegistro() {
		return PE_FechaRegistro;
	}
	public void setPE_FechaRegistro(Date pE_FechaRegistro) {
		PE_FechaRegistro = pE_FechaRegistro;
	}
	public String getPE_FechaActualizacion() {
		return PE_FechaActualizacion;
	}
	public void setPE_FechaActualizacion(String pE_FechaActualizacion) {
		PE_FechaActualizacion = pE_FechaActualizacion;
	}
	public String getNombreCompleto() {
		return PE_Nombre+" "+PE_ApellidoPaterno+" "+PE_ApellidoMaterno;
	}
	
}
