package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BbddRecetario {

	private static Connection connection = null;
	private static Conexion conexion = null;
	private static PreparedStatement sentenciaRecetas = null;
	private static PreparedStatement sentenciaIngredientes = null;
	private static PreparedStatement sentenciaAlmacen = null;
	private static ArrayList<ModeloRecetario> arrayRecetario = null;
	private static ArrayList<ModeloIngredientes> arrayIngredientes = null;
	private static ArrayList<ModeloAlmacen> arrayAlmacen = null;

	public static void listarRecetas() {
		conexion = new Conexion();
		connection = conexion.obtenerConexion();
		
		arrayRecetario = new ArrayList<ModeloRecetario>();
		arrayIngredientes = new ArrayList<ModeloIngredientes>();
		arrayAlmacen = new ArrayList<ModeloAlmacen>();
		
		try {
			sentenciaRecetas = connection.prepareStatement("SELECT * FROM recetas ");
			ResultSet rsReceta = sentenciaRecetas.executeQuery();
			
			sentenciaIngredientes = connection.prepareStatement("SELECT * FROM Ingredientes ");
			ResultSet rsIngredientes = sentenciaIngredientes.executeQuery();
			
			sentenciaAlmacen = connection.prepareStatement("SELECT * FROM almacen ");
			ResultSet rsAlmacen = sentenciaAlmacen.executeQuery();

			//Recetas
			while (rsReceta.next()) {
				ModeloRecetario recetas = new ModeloRecetario(rsReceta.getInt("IdTipo"), rsReceta.getString("Disponibilidad"), rsReceta.getString("NombreReceta"), rsReceta.getInt("PrecioVenta"), rsReceta.getString("Elaboracion"));
				arrayRecetario.add(recetas);
			}
			
			//Ingredientes
			while (rsIngredientes.next()) {
				ModeloIngredientes ingredientes = new ModeloIngredientes(rsIngredientes.getInt("IdReceta"), rsIngredientes.getInt("IdProducto"), rsIngredientes.getFloat("Cantidad"));
				arrayIngredientes.add(ingredientes);
			}
			//Almacen
			while (rsAlmacen.next()) {
				ModeloAlmacen almacen = new ModeloAlmacen(rsAlmacen.getInt("IdProducto"), rsAlmacen.getString("NombreProducto"), rsAlmacen.getInt("Cantidad"), rsAlmacen.getInt("IdUnidadMedida"), rsAlmacen.getInt("CantidadMinima"), rsAlmacen.getInt("CantidadMaxima"));
				arrayAlmacen.add(almacen);
			}
			
			System.out.println(arrayRecetario.toString());
			System.out.println(arrayIngredientes.toString());
			System.out.println(arrayAlmacen.toString());
			
			for (ModeloRecetario iReceta : arrayRecetario) {
				System.out.println(iReceta.getNombreReceta());
				System.out.println(iReceta.getIdTipo());
			}
			for (ModeloAlmacen c4 : arrayAlmacen) {
				
				
			}
		}
			//Almacen
		 catch (SQLException e) {
			System.out.println("Error en gestionPedidosClientes SentenciasSQL");
			System.out.println(e.getMessage());
		}
	}

//	public static void editarCliente(int id, String nombre, String telefono) {
//
//		conexion = new Conexion();
//		connection = conexion.obtenerConexion();
//
//		try {
//			sentencia = connection
//					.prepareStatement("update Cliente set NombreCliente = ?, Telefono = ?  where IdCliente = ?");
//			sentencia.setString(1, nombre);
//			sentencia.setString(2, telefono);
//			sentencia.setInt(3, id + 8);
//			sentencia.executeUpdate();
//
//			System.out.println("llega: " + nombre);
//			System.out.println("llega: " + id);
//			listarRecetas();
//
//		} catch (SQLException e) {
//			System.out.println("Error en editarCliente SentenciasSQL");
//			System.out.println(e.getMessage());
//		}
//	}

	public static ArrayList<ModeloRecetario> getarrayRecetario() {
		return arrayRecetario;
	}
	
	public static ArrayList<ModeloIngredientes> getarrayIngredientes() {
		return arrayIngredientes;
	}
	
	public static ArrayList<ModeloAlmacen> getarrayAlmacen() {
		return arrayAlmacen;
	}

//	public static void insertarCliente(String nombre, String telefono) {
//		conexion = new Conexion();
//		connection = conexion.obtenerConexion();
//
//		try {
//			sentencia = connection.prepareStatement("INSERT INTO PERSONAS (NombreCliente, Telefono) VALUES (?, ?)");
//			sentencia.setString(1, nombre);
//			sentencia.setString(2, telefono);
//
//			sentencia.executeQuery();
//			listarRecetas();
//
//		} catch (SQLException e) {
//			System.out.println("Error en editarCliente SentenciasSQL");
//			System.out.println(e.getMessage());
	

	public static ArrayList<ModeloRecetario> arrayRecetario() {
		return arrayRecetario;
	}

}
