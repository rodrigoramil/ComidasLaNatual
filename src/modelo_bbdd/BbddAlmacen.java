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
	private static PreparedStatement sentenciaAlmacen = null;
	private static ArrayList<ModeloAlmacen> arrayAlmacen = null;

	public static void listarProductosAlmacen() {
		conexion = new Conexion();
		connection = conexion.obtenerConexion();		
		arrayAlmacen = new ArrayList<ModeloAlmacen>();		
		try {
			sentenciaAlmacen = connection.prepareStatement("Select NombreProducto, Cantidad, CantidadMinima, CantidadMaxima from Almacen");
			ResultSet rs = sentenciaAlmacen.executeQuery();			

			while (rs.next()) {
				ModeloAlmacen modelo = new ModeloAlmacen(rs.getString("NombreProducto"), rs.getInt("Tipo"), rs.getFloat("Cantidad"), rs.getInt("UnidadMedida"), rs.getFloat("CantidadMinima"), rs.getFloat("CantidadMaxima"));
				arrayAlmacen.add(modelo);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al listar las recetas SentenciasSQL");
			System.out.println(e.getMessage());
		}
			
	}
		
	public static void addPructoAlmacen(String nombreProducto, float cantidadActual, float cantidadMinima, float cantidadMaxima, int idTipoProducto, int unidadMedida) {
		arrayAlmacen = new ArrayList<ModeloAlmacen>();	
		try {
			sentenciaAlmacen = connection.prepareStatement("INSERT INTO Almacen (NombreProducto, idTipo, Cantidad, IdUnidadMedida, CantidadMinima, CantidadMaxima) VALUES (? ,? ,? ,? , ?, ?)");
			sentenciaAlmacen.setString(1, nombreProducto);
			sentenciaAlmacen.setInt(2, idTipoProducto);
			sentenciaAlmacen.setFloat(3, cantidadActual);
			sentenciaAlmacen.setInt(4, unidadMedida);
			sentenciaAlmacen.setFloat(5, cantidadMinima);
			sentenciaAlmacen.setFloat(6, cantidadMaxima);
			sentenciaAlmacen.executeUpdate();
			ResultSet rs = sentenciaAlmacen.executeQuery();			
			while (rs.next()) {
				ModeloAlmacen modelo = new ModeloAlmacen(rs.getString("NombreProducto"), rs.getInt("Tipo"), rs.getFloat("Cantidad"), rs.getInt("IdUnidadMedida"), rs.getFloat("CantidadMinima"), rs.getFloat("CantidadMaxima"));

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
