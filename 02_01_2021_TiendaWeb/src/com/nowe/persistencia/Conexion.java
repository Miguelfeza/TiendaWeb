package com.nowe.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	protected Connection miConexion;

	public void abrirConexion() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		miConexion = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/tiendaweb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false",
				"root", "miguel1976");
		System.out.println("Éxito al abrir la conexión");
	}

	public void cerrarConexion() throws SQLException {
		miConexion.close();
	}

}
