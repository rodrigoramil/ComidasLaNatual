package modelo_bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import javax.swing.JOptionPane;

import modelo.ModeloReceta;
import modelo.ModeloUsuario;
import vista.VentanaPrincipal;

public class BbddLogin {
	private static Connection connection = null;
	private static Conexion conexion = null;
	private static PreparedStatement sentencia = null;
	private static String usuario;	
	
	public static String iniciar_Sesion(String entrada_usuario, String entrada_pass) {
		String estado = "";
		usuario = entrada_usuario;
		conexion = new Conexion();
		connection = conexion.obtenerConexion();
		try {
			String pass_cifrado =Base64.getEncoder().encodeToString(entrada_pass.getBytes());
			sentencia = connection.prepareStatement("SELECT NombreUsuario, Contrasena, Rol FROM Usuarios WHERE NombreUsuario= ? AND Contrasena = ?");
			sentencia.setNString(1, entrada_usuario);
			sentencia.setNString(2, pass_cifrado);
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

	public static String getUsuario() {
		return usuario;
	}

}
