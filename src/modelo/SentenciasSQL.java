package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SentenciasSQL {
	
	static Connection connection = null;
	public SentenciasSQL() {

	}
	
	
	
	public static boolean iniciar_Sesion(String entrada_usuario, String entrada_contrasena) {
		boolean estado = true;
		Conexion conexion = new Conexion(); 
		connection = conexion.obtenerConexion();
			
		try {
			
			PreparedStatement sentencia = connection.prepareStatement("SELECT NombreUsuario, Contrasena, Rol FROM Usuarios WHERE NombreUsuario= ?");
			sentencia.setNString(1, entrada_usuario);
			
			ResultSet rs = sentencia.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getInt("NombreUsuario"));
				System.out.print(" - "); 
				System.out.print(rs.getString("Contrasena"));
				System.out.print(" - "); 
				System.out.print(rs.getInt("Rol"));				
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
