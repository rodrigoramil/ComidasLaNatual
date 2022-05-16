package modelo_bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.ModeloGestionUsuarios;


public class BbddGestionUsuario {

	private static Connection connection = null;
	private static Conexion conexion = null;
	private static PreparedStatement sentencia = null;
	private static ArrayList<ModeloGestionUsuarios> arrayUsuarios = null;
	

	
	public static void insertarUsuarios(String nombreUsuario, String contrasena, String rol)  throws SQLException{
		
		String SQL = "INSERT INTO Usuarios (nombreUsuario, contrasena,rol ) VALUES ( ?, ?, ?)";
		sentencia = connection.prepareStatement(SQL);
		
		sentencia.setString(1, nombreUsuario);
		sentencia.setString(2, contrasena );
		sentencia.setString(3, rol);
		sentencia.executeUpdate();
	}

	
	public static void editarUsuario(int IdUsuario,String nombreUsuario, String contrasena, String rol) {
        conexion = new Conexion();
        connection = conexion.obtenerConexion();
 
        try {
        	
			sentencia= connection.prepareStatement("update Cliente set nombreUsuario = ?, contrasena = ? rol=? where IdCliente = ?");
            sentencia.setString(1, nombreUsuario);
            sentencia.setString(2, contrasena);
            sentencia.setString(3, rol);
            sentencia.setInt(4, IdUsuario);
            
            sentencia.executeUpdate();
//              
//
        } catch (SQLException e) {
        	System.out.println("Error en editarCliente SentenciasSQL");
            System.out.println(e.getMessage());
        }
    }
	
	public static void borrarUsuario(int IdUsuario) {
        conexion = new Conexion();
        connection = conexion.obtenerConexion();
 
        try {
        	
			sentencia= connection.prepareStatement("DELETE FROM Usuarios WHERE IdUsuario = ?;");
            sentencia.setInt(1, IdUsuario);
            
            sentencia.executeUpdate();

        } catch (SQLException e) {
        	System.out.println("Error en editarCliente SentenciasSQL");
            System.out.println(e.getMessage());
        }
    }
	
	
  	public static ArrayList<ModeloGestionUsuarios> getArrayClientes() {
		return arrayUsuarios;
	}




	

}
