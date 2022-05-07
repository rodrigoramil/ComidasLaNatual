package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SentenciasSQL {

	static Connection connection = null;

	public SentenciasSQL() {

	}

	public static String iniciar_Sesion(String entrada_usuario, String entrada_contrasena) {
		String estado = "";
		Conexion conexion = new Conexion();
		connection = conexion.obtenerConexion();

		try {

			PreparedStatement sentencia = connection.prepareStatement(
					"SELECT NombreUsuario, Contrasena, Rol FROM Usuarios WHERE NombreUsuario= ? AND Contrasena = ?");
			sentencia.setNString(1, entrada_usuario);
			sentencia.setNString(2, entrada_contrasena);

			ResultSet rs = sentencia.executeQuery();
			while (rs.next()) {

				if (rs.getString("Rol").equals("Administrador")) {
					estado = "Administrador";

				} else if (rs.getString("Rol").equals("Cocina")) {
					estado = "Cocina";

				} else if (rs.getString("Rol").equals("Venta")) {
					estado = "Venta";

				}

			}
		} catch (SQLException e) {
			System.out.println("Error al realizar el listado de productos");
			System.out.println(e.getMessage());

		}

//		boolean loginCorrecto = true;
//		
//		System.out.println("Usuario: "+entrada_usuario+" - Contraseña: "+ entrada_contrasena);
//		
//				
//		String passcifrado =Criptografia.cifrado(entrada_contrasena);
//		
//		System.out.println("contraseña cifrada: "+passcifrado);
//		 
//		 
//		return loginCorrecto;
		return estado;

	}

}
