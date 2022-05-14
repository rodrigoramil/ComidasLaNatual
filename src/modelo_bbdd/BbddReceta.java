package modelo_bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.ModeloReceta;

public class BbddReceta {

	private static Connection connection = null;
	private static Conexion conexion = null;
	private static PreparedStatement sentenciaRecetas = null;
	private static ArrayList<ModeloReceta> arrayVentanaReceta = null;
	
	
	private static String nombreRecetaSeleccionada; 	// <--- BORRAR

	
	public static void listarRecetas() {
		conexion = new Conexion();
		connection = conexion.obtenerConexion();
		arrayVentanaReceta = new ArrayList<ModeloReceta>();
		
		try {
			nombreRecetaSeleccionada="Paella";  		// <--- BORRAR
			sentenciaRecetas = connection.prepareStatement("Select A.NombreProducto, I.Cantidad  from Recetas R, Ingredientes I, Almacen A where r.NombreReceta=? and R.IdReceta = I.IdReceta and I.IDPRODUCTO = A.IDPRODUCTO");
			sentenciaRecetas.setString(1, nombreRecetaSeleccionada);
			ResultSet rsReceta = sentenciaRecetas.executeQuery();

			while (rsReceta.next()) {
				ModeloReceta recetas = new ModeloReceta(rsReceta.getString("NombreProducto"),rsReceta.getInt("Cantidad"));
				arrayVentanaReceta.add(recetas);
			}
		}

		 catch (SQLException e) {
			System.out.println("Error en gestionPedidosClientes SentenciasSQL");
			System.out.println(e.getMessage());
		}
	}

	public static ArrayList<ModeloReceta> getArrayVentanaReceta() {
		return arrayVentanaReceta;
	}
	
	
	

}
