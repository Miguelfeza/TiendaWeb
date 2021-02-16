package com.nowe.modelo;

public class Usuario {
//Atributos
	String idUsuario, password, nombre;

	
	
	//metodos
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", password=" + password + ", nombre=" + nombre + "]";
	}



	public String getIdUsuario() {
		return idUsuario;
	}



	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Usuario() {
		super();
	}



	public Usuario(String password, String nombre) {
		super();
		this.password = password;
		this.nombre = nombre;
	}



	public Usuario(String idUsuario, String password, String nombre) {
		super();
		this.idUsuario = idUsuario;
		this.password = password;
		this.nombre = nombre;
	}
	
	
}
