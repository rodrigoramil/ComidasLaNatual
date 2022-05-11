package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import vista.GestionPedidos;

public class BbddVentas {

	private static Connection connection = null;
	private static Conexion conexion = null;
	private static PreparedStatement sentencia = null;
	private static GestionPedidos gestionPedidos = null;
	private static ArrayList<ModeloCliente> arrayClientes = null;

	public static void listarClientes() {
		conexion = new Conexion();
		connection = conexion.obtenerConexion();
		arrayClientes = new ArrayList<ModeloCliente>();

		try {
			sentencia = connection.prepareStatement("SELECT * FROM cliente ");
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
    	
        conexion = new Conexion();
        connection = conexion.obtenerConexion();
 
        try {
            sentencia = connection.prepareStatement("update Cliente set NombreCliente = ?, Telefono = ?  where IdCliente = ?");
            sentencia.setString(1, nombre);
            sentencia.setString(2, telefono);
            sentencia.setInt(3, id);
            sentencia.executeUpdate();
            
            System.out.println("llega: "+ nombre);
            System.out.println("llega: "+ id);
            listarClientes();            

        } catch (SQLException e) {
        	System.out.println("Error en editarCliente SentenciasSQL");
            System.out.println(e.getMessage());
        }
    }

	
	public static ArrayList<ModeloCliente> getArrayClientes() {
		return arrayClientes;
	}
  

}
