package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BbddVentas {

	private static Connection connection = null;
	private static Conexion conexion = null;
	private static PreparedStatement sentencia = null;
	private static ArrayList<ModeloCliente> arrayClientes = null;
	private static ArrayList<ModeloReceta> arrayRecetas=null; // <---- BORRAR

	public static void listarRecetas() {
		conexion = new Conexion();
		connection = conexion.obtenerConexion();
		arrayClientes = new ArrayList<ModeloCliente>();
		arrayRecetas = new ArrayList<ModeloReceta>();  // <---- BORRAR
		try {
			sentencia = connection.prepareStatement("SELECT * FROM cliente ");
			ResultSet rs = sentencia.executeQuery();

			while (rs.next()) {
				
				ModeloCliente cliente = new ModeloCliente(
						rs.getInt("IdCliente"), 
						rs.getString("NombreCliente"),
						rs.getString("Telefono"));
				arrayClientes.add(cliente);
				
				// <---- BORRAR ----->
				ModeloReceta receta = new ModeloReceta(
						rs.getString("NombreCliente"), 
						rs.getString("Telefono"));
				arrayRecetas.add(receta);
				// <---- BORRAR ----->
				
			}

		} catch (SQLException e) {
			System.out.println("Error en gestionPedidosClientes SentenciasSQL");
			System.out.println(e.getMessage());
		}
	}

    
	public static void editarCliente(int id, String nombre, String telefono) {
    	
        conexion = new Conexion();
        connection = conexion.obtenerConexion();
 
        try {
            sentencia = connection.prepareStatement("update Cliente set NombreCliente = ?, Telefono = ?  where IdCliente = ?");
            sentencia.setString(1, nombre);
            sentencia.setString(2, telefono);
            sentencia.setInt(3, id+8);
            sentencia.executeUpdate();
            
            listarRecetas();            

        } catch (SQLException e) {
        	System.out.println("Error en editarCliente SentenciasSQL");
            System.out.println(e.getMessage());
        }
    }

	
	public static ArrayList<ModeloCliente> getArrayClientes() {
		return arrayClientes;
	}

	public static void insertarCliente(String nombre, String telefono) {
		conexion = new Conexion();
        connection = conexion.obtenerConexion();
 
        try {
            sentencia = connection.prepareStatement("INSERT INTO PERSONAS (NombreCliente, Telefono) VALUES (?, ?)"); 
            sentencia.setString(1, nombre);
            sentencia.setString(2, telefono);
     
            sentencia.executeQuery();
            listarRecetas();            

        } catch (SQLException e) {
        	System.out.println("Error en editarCliente SentenciasSQL");
            System.out.println(e.getMessage());
        }
	}


	public static ArrayList<ModeloReceta> getArrayRecetas() {
		return arrayRecetas;
	}
  

}
