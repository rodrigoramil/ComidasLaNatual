package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import javax.swing.JOptionPane;

import vista.VentanaPrincipal;
public class BbddLogin {
	private static Connection connection = null;
	private static Conexion conexion = null;
	private static PreparedStatement sentencia = null;
	private static ArrayList<ModeloUsuario> arrayUsuarios = null;
		
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
		} catch (SQLException  | NullPointerException e) {
			
			JOptionPane.showMessageDialog(VentanaPrincipal.getPanelLogin(), "Error al iniciar Sesion");
			System.out.println("Error al iniciar Sesion SentenciasSQL");
		}
		return estado;
	}
	
	
	public static void listarUsuarios() {
		conexion = new Conexion();
		connection = conexion.obtenerConexion();
		arrayUsuarios = new ArrayList<ModeloUsuario>();
		try {
			
			sentencia = connection.prepareStatement("select NombreUsuario, Rol from Usuarios;");
			ResultSet rs = sentencia.executeQuery();			
			while (rs.next()) {				
				ModeloUsuario usuario = new ModeloUsuario(
						rs.getString("NombreUsuario"),
						rs.getString("Rol"));
				arrayUsuarios.add(usuario);				
			}
		} catch (SQLException | NullPointerException e) {
			
			JOptionPane.showMessageDialog(VentanaPrincipal.getPanelLogin(), "Error al acceder a los Usuarios de la Base de Datos");
			System.out.println("Error al acceder a los Usuarios de la Base de Datos");
		}
			
	}
	
	
	public static ArrayList<ModeloUsuario> getArrayUsuarios() {
		return arrayUsuarios;
	}

	
	
	
	
}
