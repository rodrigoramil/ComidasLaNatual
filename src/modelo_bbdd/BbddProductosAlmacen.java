package modelo_bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.ModeloProductosAlmacen;
import modelo.ModeloRecetario;

public class BbddProductosAlmacen {
	
	private static Connection connection = null;
	private static Conexion conexion = null;
	private static PreparedStatement sentenciaProductosAlmacen = null;
	private static ArrayList<ModeloProductosAlmacen> arrayProductosAlmacen = null;

	public static ArrayList<ModeloProductosAlmacen> listarProductosAlmacen() {
		conexion = new Conexion();
		connection = conexion.obtenerConexion();		
		arrayProductosAlmacen = new ArrayList<ModeloProductosAlmacen>();		
		try {
			sentenciaProductosAlmacen = connection.prepareStatement("Select IdProducto, NombreProducto, Cantidad from almacen order by IdProducto");
			ResultSet rs = sentenciaProductosAlmacen.executeQuery();			

			while (rs.next()) {
				ModeloProductosAlmacen modelo = new ModeloProductosAlmacen(rs.getInt("IdProducto"), rs.getString("NombreProducto"), rs.getFloat("Cantidad"));
				arrayProductosAlmacen.add(modelo);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al listar las recetas SentenciasSQL");
			System.out.println(e.getMessage());
		}
		return arrayProductosAlmacen;			
	}

	// Sentencia para buscar un producto segun si nombre 		
	// "Select IdProducto, NombreProducto, Cantidad from Almacen where NombreProducto=?"
	
	// Sentencia para buscar un producto segun su id
	// "Select IdProducto, NombreProducto, Cantidad from Almacen where IdProducto=?"

	public static ArrayList<ModeloProductosAlmacen> getArrayAlmacen() {
		return arrayProductosAlmacen;
	}	
}
