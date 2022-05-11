package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

import com.mysql.cj.result.StringValueFactory;

import vista.GestionPedidos;
public class BbddLogin {
	private static Connection connection = null;
	private static Conexion conexion = null;
	private static PreparedStatement sentencia = null;
	private static GestionPedidos gestionPedidos = null;
	private static ArrayList<String> arrayClientes = null;
	
//****************************PRUEBAS****************************************************    
	private static ArrayList<String> array_clientes = null;
	private static String cliente = null;
//****************************PRUEBAS****************************************************    	
	
	public static String iniciar_Sesion(String entrada_usuario, String entrada_contrasena) {
		String estado = "";
		conexion = new Conexion();
		connection = conexion.obtenerConexion();

		try {
			String passcifrado =Base64.getEncoder().encodeToString(entrada_contrasena.getBytes());
			sentencia = connection.prepareStatement("SELECT NombreUsuario, Contrasena, Rol FROM Usuarios WHERE NombreUsuario= ? AND Contrasena = ?");
			sentencia.setNString(1, entrada_usuario);
			sentencia.setNString(2, passcifrado); // <-- PASS YA CIFRADA
			ResultSet rs = sentencia.executeQuery();			
			while (rs.next()) {
				if (rs.getString("Rol").equals("Administrador")) {estado = "Administrador";} 
				else if (rs.getString("Rol").equals("Cocina")) {estado = "Cocina";} 
				else if (rs.getString("Rol").equals("Venta")) {	estado = "Venta";}
			}
		} catch (SQLException e) {
			System.out.println("Error al iniciar_Sesion SentenciasSQL");
			System.out.println(e.getMessage());
		}
		return estado;
	}
	
}
