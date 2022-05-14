package modelo_bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.ModeloAlmacen;

public class BbddAlmacen {
	
	private static Connection connection = null;
	private static Conexion conexion = null;
	private static PreparedStatement sentenciaRecetas = null;
	private static ArrayList<ModeloAlmacen> arrayAlmacen = null;
	
	public static void listarProductosAlmacen() {
		conexion = new Conexion();
		connection = conexion.obtenerConexion();		
		arrayAlmacen = new ArrayList<ModeloAlmacen>();		
		try {
			sentenciaRecetas = connection.prepareStatement("Select NombreProducto, Cantidad, CantidadMinima, CantidadMaxima from Almacen");
			ResultSet rs = sentenciaRecetas.executeQuery();			

			while (rs.next()) {
				ModeloAlmacen modelo = new ModeloAlmacen(rs.getString("NombreProducto"), rs.getFloat("Cantidad"), rs.getFloat("CantidadMinima"), rs.getFloat("CantidadMaxima"));
				arrayAlmacen.add(modelo);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al listar las recetas SentenciasSQL");
			System.out.println(e.getMessage());
		}
			
	}
		
	public static ArrayList<ModeloAlmacen> getArrayAlmacen() {
		return arrayAlmacen;
	}
}
