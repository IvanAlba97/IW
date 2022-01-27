package es.reji.data.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import es.reji.data.AbstractEntity;

@Entity
public class Usuario extends AbstractEntity {
	
	private String nombre;
	private String apellidos;
	private String correo;
	private String contraseña;
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private Carrito carrito;

	public void setNombre(String nombre) { this.nombre = nombre; }
	public void setApellidos(String apellidos) { this.apellidos = apellidos; }
	public void setCorreo(String correo) { this.correo = correo; }
	public void setContraseña(String contraseña) { this.contraseña = contraseña; }
	public String getNombre() { return nombre; }
	public String getApellidos() { return apellidos; }
	public String getCorreo() { return correo; }
	public String getContraseña() { return contraseña; }
	public Carrito getCarrito() { return carrito; }

}
