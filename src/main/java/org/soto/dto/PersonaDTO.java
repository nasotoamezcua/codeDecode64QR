package org.soto.dto;

public class PersonaDTO {
	
	private String nombre;
	private String apellidoP;
	private String apellidoM;
	private Boolean vivo;
	
	public PersonaDTO(String nombre, String apellidoP, String apellidoM, Boolean vivo) {
		super();
		this.nombre = nombre;
		this.apellidoP = apellidoP;
		this.apellidoM = apellidoM;
		this.vivo = vivo;
	}
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
	
	@Override
	public String toString() {
		return "PersonaDTO [nombre=" + nombre + ", apellidoP=" + apellidoP + ", apellidoM=" + apellidoM + ", vivo="
				+ vivo + "]";
	}
}
