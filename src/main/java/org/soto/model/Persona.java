package org.soto.model;

public class Persona {
	
	private String nombre;
	private String apellidoP;
	private String apellidoM;
	private Boolean vivo;
	private Integer edad;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoP() {
		return apellidoP;
	}
	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}
	public String getApellidoM() {
		return apellidoM;
	}
	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}
	public Boolean getVivo() {
		return vivo;
	}
	public void setVivo(Boolean vivo) {
		this.vivo = vivo;
	}
	
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidoP=" + apellidoP + ", apellidoM=" + apellidoM + ", vivo=" + vivo
				+ ", edad=" + edad + "]";
	}
}
