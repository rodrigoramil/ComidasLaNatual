package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BbddReceta {

	private static Connection connection = null;
	private static Conexion conexion = null;
	private static PreparedStatement sentenciaRecetas = null;
	private static PreparedStatement sentenciaIngredientes = null;
	private static PreparedStatement sentenciaAlmacen = null;
	/**
	 * 
	 */
	private static ArrayList<ModeloReceta> arrayReceta = null;
	private static ArrayList<ModeloIngredientes> arrayIngredientes = null;
	private static ArrayList<ModeloAlmacen> arrayAlmacen = null;
	private static ArrayList<ModeloVentanaReceta> arrayVentanaReceta = null;
	
	private static String nombreRecetaSeleccionada; //                            iGUALAR al SELECCIONADO EN RECETARIO
	private static int IdProductosDeRecetaSeleccionada;
	private static int IdDeRecetaSeleccionada;
	private static String nombreProductoSeleccionado;

	
	public static void listarRecetas() {
		conexion = new Conexion();
		connection = conexion.obtenerConexion();
		
		arrayReceta = new ArrayList<ModeloReceta>();
		arrayIngredientes = new ArrayList<ModeloIngredientes>();
		arrayAlmacen = new ArrayList<ModeloAlmacen>();
		
		arrayVentanaReceta = new ArrayList<ModeloVentanaReceta>();

		try {
			nombreRecetaSeleccionada="Paella";
			
			//Buscamos el IdReceta Para relacionarlo con los ingredientes
			sentenciaRecetas = connection.prepareStatement("SELECT IDRECETA FROM RECETAS WHERE NOMBRERECETA = ?");
			sentenciaRecetas.setString(1, nombreRecetaSeleccionada);
			ResultSet rsReceta = sentenciaRecetas.executeQuery();
			System.out.println(rsReceta.toString());
			ModeloReceta recetas = rsReceta.getInt("IDRECETA");
			
			IdProductosDeRecetaSeleccionada = rsReceta.getInt("IDRECETA");
			
			// Con el IdReceta obtenemos el IdProducto y la cantidad a utilizar
			sentenciaIngredientes = connection.prepareStatement("SELECT IDPRODUCTO,CANTIDAD FROM INGREDIENTES WHERE IDRECETA = ?"); // Pendiente de utilizar Cantidad de ingredientes por recetas
			sentenciaIngredientes.setInt(1, IdProductosDeRecetaSeleccionada);
			ResultSet rsIngredientes = sentenciaIngredientes.executeQuery();
			IdDeRecetaSeleccionada= rsIngredientes.getInt("IDPRODUCTO");
			
			// Con el IdProducto vemos el nombre en el almacen
			sentenciaAlmacen = connection.prepareStatement("SELECT NOMBREPRODUCTO FROM ALMACEN WHERE IDPRODUCTO = ?");
			sentenciaAlmacen.setString(1, nombreProductoSeleccionado);
			ResultSet rsAlmacen = sentenciaAlmacen.executeQuery();
			nombreProductoSeleccionado= rsAlmacen.getString("NOMBREPRODUCTO");
			
			System.out.println("IdProductosDeRecetaSeleccionada: "+IdProductosDeRecetaSeleccionada);
			System.out.println("IdDeRecetaSeleccionada: "+IdDeRecetaSeleccionada);
			System.out.println("nombreProductoSeleccionado: "+nombreProductoSeleccionado);
			
			
			/*
			while (rsReceta.next()) {
				
				ModeloVentanaReceta recetas = new ModeloVentanaReceta(rsReceta.getString("NombreReceta"), null, null);
				arrayReceta.add(recetas);
		
			}
			
			*/
			
			
			//Recetas
//			while (rsReceta.next()) {
//				ModeloReceta recetas = new ModeloReceta(rsReceta.getInt("IdReceta"),rsReceta.getInt("IdTipo"), rsReceta.getInt("IdDisponibilidad"), rsReceta.getString("NombreReceta"), rsReceta.getFloat("PrecioVenta"), rsReceta.getString("Elaboracion"));
//				arrayReceta.add(recetas);
		
//			}
//			
//			//Ingredientes
//			while (rsIngredientes.next()) {
//				ModeloIngredientes ingredientes = new ModeloIngredientes(rsIngredientes.getInt("IdReceta"), rsIngredientes.getInt("IdProducto"), rsIngredientes.getFloat("Cantidad"));
//				arrayIngredientes.add(ingredientes);
//			}
//			
//			//Almacen
//			while (rsAlmacen.next()) {
//				ModeloAlmacen almacen = new ModeloAlmacen(rsAlmacen.getInt("IdProducto"), rsAlmacen.getString("NombreProducto"), rsAlmacen.getInt("Cantidad"), rsAlmacen.getInt("IdUnidadMedida"), rsAlmacen.getInt("CantidadMinima"), rsAlmacen.getInt("CantidadMaxima"));
//				arrayAlmacen.add(almacen);
//			}
//			
//		
//			for (ModeloReceta iReceta : arrayReceta) {
//				System.out.println(iReceta.getNombreReceta());
//				System.out.println(iReceta.getIdTipo());
//			}
//			
		}
			//Almacen
		 catch (SQLException e) {
			System.out.println("Error en gestionPedidosClientes SentenciasSQL");
			System.out.println(e.getMessage());
		}
	}

	public static ArrayList<ModeloReceta> getarrayReceta() {
		return arrayReceta;
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
	

	public static ArrayList<ModeloReceta> arrayReceta() {
		return arrayReceta;
	}

}
