package modelo_bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.ModeloCliente;
import modelo.ModeloPRUEBA;
import vista.Cliente;

public class BbddVentas {

	private static Connection connection = null;
	private static Conexion conexion = null;
	private static PreparedStatement sentencia = null;
	private static ArrayList<ModeloCliente> arrayClientes = null;
	private static ArrayList<ModeloPRUEBA> arrayRecetas=null; // <---- BORRAR

	public static void listarClientes() {
		conexion = new Conexion();
		connection = conexion.obtenerConexion();
		arrayClientes = new ArrayList<ModeloCliente>();
		arrayRecetas = new ArrayList<ModeloPRUEBA>();  // <---- BORRAR
		try {
			sentencia = connection.prepareStatement("Select * from cliente where nombreCliente not like '%Mesa %'  order by IdCliente");
			ResultSet rs = sentencia.executeQuery();

			while (rs.next()) {
				
				ModeloCliente cliente = new ModeloCliente(
						rs.getInt("IdCliente"), 
						rs.getString("NombreCliente"),
						rs.getString("Telefono"));
				arrayClientes.add(cliente);
				
				
			}

		} catch (SQLException e) {
			System.out.println("Error en gestionPedidosClientes SentenciasSQL");
			System.out.println(e.getMessage());
		}
	}

    
	public static void editarCliente(int id, String nombre, String telefono) {
		System.out.println("esta entrando por en editar");
        conexion = new Conexion();
        connection = conexion.obtenerConexion();
        try {
        	
			sentencia= connection.prepareStatement("update Cliente set NombreCliente = ?, Telefono = ?  where IdCliente = ?");
            sentencia.setString(1, nombre);
            sentencia.setString(2, telefono);
            sentencia.setInt(3, id);
            sentencia.executeUpdate();
//          
            listarClientes();            
//
        } catch (SQLException e) {
        	System.out.println("Error en editarCliente SentenciasSQL");
            System.out.println(e.getMessage());
        }
    }

	

	public static void insertarCliente(String nombre, String telefono)  throws SQLException{
		
		String SQL = "INSERT INTO Cliente (NombreCliente, telefono) VALUES ( ?, ?)";
		sentencia = connection.prepareStatement(SQL);
		
		sentencia.setString(1, nombre);
		sentencia.setInt(2, Integer.parseInt(telefono));
		sentencia.executeUpdate();
	}


	public static ArrayList<ModeloPRUEBA> getArrayRecetas() {
		return arrayRecetas;
	}
	
  	public static ArrayList<ModeloCliente> getArrayClientes() {
		return arrayClientes;
	}




	

}

