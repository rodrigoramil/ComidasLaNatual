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
			sentenciaAlmacen = connection.prepareStatement("Select NombreProducto, Cantidad, IdUnidadMedida, CantidadMinima, CantidadMaxima, IdTipo from Almacen");
			ResultSet rs = sentenciaAlmacen.executeQuery();			

			while (rs.next()) {
				ModeloAlmacen modelo = new ModeloAlmacen(rs.getString("NombreProducto"), rs.getFloat("Cantidad"), rs.getInt("IdUnidadMedida"), rs.getFloat("CantidadMinima"), rs.getFloat("CantidadMaxima"), rs.getInt("IdTipo"));
				arrayAlmacen.add(modelo);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al listar las recetas SentenciasSQL");
			System.out.println(e.getMessage());
		}
			
	}
		
	public static void addPructoAlmacen(String nombreProducto, float cantidadActual, int unidadMedida, float cantidadMinima, float cantidadMaxima, int idTipoProducto) {
//		arrayAlmacen = new ArrayList<ModeloAlmacen>();	

		
		try {
//			sentenciaAlmacen = connection.prepareStatement("INSERT INTO Almacen (NombreProducto, Cantidad, IdUnidadMedida, CantidadMinima, CantidadMaxima, IdTipo) VALUES ( ?, ?, ?, ?, ?, ?);");
		
			sentenciaAlmacen = connection.prepareStatement("INSERT INTO Almacen (NombreProducto, Cantidad, IdUnidadMedida, CantidadMinima, CantidadMaxima, IdTipo) VALUES ( ?, ?, ?, ?, ?, ?);");
			sentenciaAlmacen.setString(1, nombreProducto);
			sentenciaAlmacen.setFloat(2, cantidadActual);
			sentenciaAlmacen.setInt(3, 1);
			sentenciaAlmacen.setInt(2, idTipoProducto);
			sentenciaAlmacen.setFloat(4, cantidadMinima);
			sentenciaAlmacen.setFloat(5, cantidadMaxima);
			sentenciaAlmacen.setInt(6, 1);
			sentenciaAlmacen.setInt(4, unidadMedida);
			
			
			sentenciaAlmacen.executeUpdate();
			
			
			ResultSet rs = sentenciaAlmacen.executeQuery();			

			
		} catch (SQLException e) {
			System.out.println("Error al listar las recetas SentenciasSQL");
			System.out.println(e.getMessage());
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	/*
	String vNombreProducto="salchichon";
	String vCantidad = "2";
	int vIdUnidadMedida = 1;
	String vCantidadMinima ="3";
	String vCantidadMaxima="2";
	int vIdTipo=1;
	
	float v = Float.parseFloat(vCantidad);
	float v1 = Float.parseFloat(vCantidadMinima);
	float v2 = Float.parseFloat(vCantidadMaxima);
	
	
	
	try {
		sentenciaAlmacen = connection.prepareStatement("INSERT INTO Almacen (NombreProducto, Cantidad, IdUnidadMedida, CantidadMinima, CantidadMaxima, IdTipo) VALUES ( ?, ?, ?, ?, ?, ?);");
		sentenciaAlmacen.setString(1, vNombreProducto);
		sentenciaAlmacen.setFloat(2, v);
		sentenciaAlmacen.setInt(3, vIdUnidadMedida); // Unidad Medida
		sentenciaAlmacen.setFloat(4, v1);
		sentenciaAlmacen.setFloat(5, v2);
		sentenciaAlmacen.setInt(6, vIdTipo); // Tipo
*/
	
	
	
	
	
	
	
	
	
	
	
	public static ArrayList<ModeloAlmacen> getArrayAlmacen() {
		return arrayAlmacen;
	}
}
