package com.nowe.negocio;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nowe.modelo.Producto;
import com.nowe.persistencia.AccesoTiendaWeb;

public class Carrito implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Producto> contenido= new ArrayList<Producto>();
	private double importe;
	
	public Carrito() {
		
	}
	public void addProducto (int id) throws ClassNotFoundException, SQLException {
		AccesoTiendaWeb atw1= new AccesoTiendaWeb();
		Producto p = atw1.buscar(id);
		System.out.println("Producto de la BBDD" + p.toString());
		contenido.add(p);
		importe += p.getPrecio();
	}
	public void removeCarrito (int id) {
		//declarar variables
		Producto pEliminar = null;
		//recorrer el contenido de carrito para buscar el producto a eliminar
		for (Producto p : contenido) {
			if (p.getIdproducto()==id) {
				pEliminar = p;
				break;
			}
			
		}
		contenido.remove(pEliminar);
		importe -= pEliminar.getPrecio();
		}
	public List<Producto> getContenido() {
		return contenido;
	}
	public void setContenido(List<Producto> contenido) {
		this.contenido = contenido;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
