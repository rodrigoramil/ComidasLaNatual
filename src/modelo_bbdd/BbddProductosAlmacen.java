package modelo_bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.ModeloProductosAlmacen;

public class BbddProductosAlmacen {
	
	private static Connection connection = null;
	private static Conexion conexion = null;
	private static PreparedStatement sentenciaProductosAlmacen = null;
	private static ArrayList<ModeloProductosAlmacen> arrayProductosAlmacen = null;

	public static void listarProductosAlmacen() {
		conexion = new Conexion();
		connection = conexion.obtenerConexion();		
		arrayProductosAlmacen = new ArrayList<ModeloProductosAlmacen>();		
		try {
			sentenciaProductosAlmacen = connection.prepareStatement("Select NombreProducto, Cantidad from almacen");
			ResultSet rs = sentenciaProductosAlmacen.executeQuery();			

			while (rs.next()) {
				ModeloProductosAlmacen modelo = new ModeloProductosAlmacen(rs.getString("NombreProducto"), rs.getFloat("Cantidad"));
				arrayProductosAlmacen.add(modelo);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al listar las recetas SentenciasSQL");
			System.out.println(e.getMessage());
		}
			
	}
		
	

	public static ArrayList<ModeloProductosAlmacen> getArrayAlmacen() {
		return arrayProductosAlmacen;
	}	
}
