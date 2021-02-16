package com.nowe.persistencia;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nowe.modelo.Producto;
import com.nowe.modelo.Usuario;



public class AccesoTiendaWeb extends Conexion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Usuario obtenerPassword(String usuario) throws ClassNotFoundException, SQLException {
		// Declaracion variable
		Usuario u1=null;
		CallableStatement st;
		ResultSet rs;
		// Abrir la conexion
		abrirConexion();
		// Obtener statement de la conexion
		st = miConexion.prepareCall("call tiendaweb.verificar_usuario (?)");
		st.setString(1, usuario);
		;
		// Ejecutar el statement
		rs = st.executeQuery();
		// Obtener el resultado
		if (rs.next()) {
			 String password = rs.getString("password");
			 String nombre = rs.getString("nombre");
			 u1 = new Usuario(password, nombre);

		}
		rs.close();
		st.close();
		cerrarConexion();
		return u1;
	}
	
	public List<Producto> obtenerTodos() throws ClassNotFoundException, SQLException{
		// 1. Definir variable
		
		//1a. variables
		List <Producto> productos = new ArrayList<Producto>();
		String sql = "Select idproducto, nombre, precio, cantidadExistencia, rutaImagen from productos";
		//1b. variable propias de la bbdd
		Statement query;
		ResultSet rs;
		//2. Abrir conexion
		abrirConexion();
		//3. Obtener el Statement de la conexion
		query = miConexion.createStatement();
		//4. Ejecutar el statement (Query)
		rs = query.executeQuery(sql);
		//5. Recorrer el resultset para generar la coleccion de productos
		while (rs.next()) {
			//Recoger los daots del reslt set
			int idproducto = rs.getInt("idproducto");
			String nombre = rs.getString("nombre");
			double precio = rs.getDouble("precio");
			int cExistencia = rs.getInt("cantidadExistencia");
			String rImagen = rs.getString("rutaImagen");
			//Instanciar un producto
			Producto p1 = new Producto(idproducto, nombre, precio, cExistencia, rImagen);
			//Añadir a la coleccion
			productos.add(p1);
		}
		//6. Cerrar resultset, statement y conexion
		rs.close();
		query.close();
		cerrarConexion();
		
		//7. devolver la coleccion de productos
		return productos;
	}
	public Producto buscar (int id) throws ClassNotFoundException, SQLException {
		
		Producto p1 = null;
		String sql="select nombre, precio, cantidadExistencia from productos where idproducto = ?";
		
		PreparedStatement query;
		ResultSet rs;
		
		abrirConexion();
		
		query = miConexion.prepareStatement(sql);
		
		query.setInt(1,id);
		
		rs = query.executeQuery(); 
		
		if (rs.next()) {
			//recoger los datos
			String nombre = rs.getString("nombre");
			double precio = rs.getDouble("precio");
			int cantidadExistencia = rs.getInt("cantidadExistencia");
			p1= new Producto(id, nombre, precio, cantidadExistencia);
		}
			rs.close();
			query.close();
			cerrarConexion();
			
			//7. devolver la coleccion de productos
			return p1;
		
		
	}

}
