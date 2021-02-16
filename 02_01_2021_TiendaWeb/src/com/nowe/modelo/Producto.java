package com.nowe.modelo;

public class Producto {
	private int idproducto;
	private String nombre;
	private double precio;
	private int CantidadExistencia;
	private String rutaImagen;
	
	
	


	@Override
	public String toString() {
		return "Producto [idproducto=" + idproducto + ", nombre=" + nombre + ", precio=" + precio
				+ ", CantidadExistencia=" + CantidadExistencia + ", rutaImagen=" + rutaImagen + "]";
	}


	public Producto() {
		
	}


	public Producto(int idproducto, String nombre, double precio, int cantidadExistencia) {
		super();
		this.idproducto = idproducto;
		this.nombre = nombre;
		this.precio = precio;
		CantidadExistencia = cantidadExistencia;
	}
	


	public Producto(int idproducto, String nombre, double precio, int cantidadExistencia, String rutaImagen) {
		super();
		this.idproducto = idproducto;
		this.nombre = nombre;
		this.precio = precio;
		CantidadExistencia = cantidadExistencia;
		this.rutaImagen = rutaImagen;
	}


	public int getIdproducto() {
		return idproducto;
	}


	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getCantidadExistencia() {
		return CantidadExistencia;
	}


	public void setCantidadExistencia(int cantidadExistencia) {
		CantidadExistencia = cantidadExistencia;
	}


	public String getRutaImagen() {
		return rutaImagen;
	}


	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}
	
	
	
	

}
