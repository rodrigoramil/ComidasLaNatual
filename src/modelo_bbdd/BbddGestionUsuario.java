package modelo_bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

import javax.swing.JOptionPane;

import modelo.ModeloGestionUsuarios;
import modelo.ModeloUsuario;
import vista.GestionUsuarios;
import vista.Recetario;
import vista.VentanaPrincipal;


public class BbddGestionUsuario {

	private static Connection connection = null;
	private static Conexion conexion = null;
	private static PreparedStatement sentencia = null;
	private static ArrayList<ModeloGestionUsuarios> arrayUsuarios = null;
	static int idUsuario;
	
	
	public static ArrayList<ModeloGestionUsuarios> listarUsuarios() {
		conexion = new Conexion();
		connection = conexion.obtenerConexion();
		arrayUsuarios = new ArrayList<ModeloGestionUsuarios>();
		try {
			
			sentencia = connection.prepareStatement("select IdUsuario, NombreUsuario, Rol from Usuarios order by IdUsuario;");
			ResultSet rs = sentencia.executeQuery();			
			while (rs.next()) {				
				ModeloGestionUsuarios usuario = new ModeloGestionUsuarios(
				rs.getInt("IdUsuario"),
				rs.getString("NombreUsuario"),
				rs.getString("Rol"));
				arrayUsuarios.add(usuario);				
			}
		} catch (SQLException | NullPointerException e) {
			
			JOptionPane.showMessageDialog(VentanaPrincipal.getPanelLogin(), "Error al acceder a los Usuarios de la Base de Datos");
			System.out.println("Error al acceder a los Usuarios de la Base de Datos");
		}
		return arrayUsuarios;			
	}
	

	
	public static void insertarUsuarios(String nombreUsuario, String pass, String rol) throws SQLException{
		String passcifrado =Base64.getEncoder().encodeToString(pass.getBytes());
		String SQL = "INSERT INTO Usuarios (nombreUsuario, contrasena, rol ) VALUES ( ?, ?, ?)";
		sentencia = connection.prepareStatement(SQL);		
		sentencia.setString(1, nombreUsuario);
		sentencia.setString(2, passcifrado );
		sentencia.setString(3, rol);
		sentencia.executeUpdate();
	}

	
	public static void editarUsuario(String nombreUsuario, String pass, String rol) throws SQLException {
		listarUsuarios();
        conexion = new Conexion();
        connection = conexion.obtenerConexion();
        String passcifrada =Base64.getEncoder().encodeToString(pass.getBytes());
		     
        for (int i = 0; i < arrayUsuarios.size(); i++) {        	
			if (arrayUsuarios.get(i).getNombreUsuario().equals(GestionUsuarios.datoSeleccionadoTabla())) {
				idUsuario = arrayUsuarios.get(i).getIdUsuario();
				sentencia= connection.prepareStatement("UPDATE Usuarios SET NombreUsuario = ?, Contrasena = ?, Rol = ? WHERE IdUsuario = ?");
				sentencia.setString(1, nombreUsuario);
				sentencia.setString(2, passcifrada);
            	sentencia.setString(3, rol);
            	sentencia.setInt(4, idUsuario);
            	sentencia.executeUpdate();
			}
		}
    }
	
	public static void borrarUsuario() throws SQLException{
		listarUsuarios();
        conexion = new Conexion();
        connection = conexion.obtenerConexion();
        String nombreUsuario = GestionUsuarios.datoSeleccionadoTabla();        
        for (int i = 0; i < arrayUsuarios.size(); i++) {
			if (arrayUsuarios.get(i).getNombreUsuario().equals(nombreUsuario)) {
				idUsuario = arrayUsuarios.get(i).getIdUsuario();
				sentencia= connection.prepareStatement("DELETE FROM Usuarios WHERE IdUsuario = ?;");
				sentencia.setInt(1, idUsuario);
				sentencia.executeUpdate();
			}
		}    
    }
	
	
  	public static ArrayList<ModeloGestionUsuarios> getArrayUsuarios() {
		return arrayUsuarios;
	}




	

}
