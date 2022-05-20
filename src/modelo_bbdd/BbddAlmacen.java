package modelo_bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

import modelo.ModeloAlmacen;
import vista.Almacen;
import vista.GestionUsuarios;

public class BbddAlmacen {
	
	private static Connection connection = null;
	private static Conexion conexion = null;
	private static PreparedStatement sentenciaAlmacen = null;
	private static ArrayList<ModeloAlmacen> arrayAlmacen = null;

	public static ArrayList<ModeloAlmacen> listarProductosAlmacen() {
		conexion = new Conexion();
		connection = conexion.obtenerConexion();		
		arrayAlmacen = new ArrayList<ModeloAlmacen>();		
		try {
			sentenciaAlmacen = connection.prepareStatement("Select IdProducto, NombreProducto, Cantidad, IdUnidadMedida, CantidadMinima, CantidadMaxima, IdTipo from Almacen");
			ResultSet rs = sentenciaAlmacen.executeQuery();			

			while (rs.next()) {
				ModeloAlmacen modelo = new ModeloAlmacen(rs.getInt("IdProducto"), rs.getString("NombreProducto"), rs.getFloat("Cantidad"), rs.getInt("IdUnidadMedida"), rs.getFloat("CantidadMinima"), rs.getFloat("CantidadMaxima"), rs.getInt("IdTipo"));
				arrayAlmacen.add(modelo);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al listar las recetas SentenciasSQL");
			System.out.println(e.getMessage());
		}
		return arrayAlmacen;
			
	}
		
	public static void addPructoAlmacen(String nombreProducto, float cantidadActual,int idUnidadMedida, float cantidadMinima, float cantidadMaxima, int idTipoProducto) throws SQLException {
			String SQL = "INSERT INTO Almacen (NombreProducto, Cantidad, IdUnidadMedida, CantidadMinima, CantidadMaxima, IdTipo) VALUES ( ?, ?, ?, ?, ?, ?)";
			sentenciaAlmacen = connection.prepareStatement(SQL);
			sentenciaAlmacen.setString(1, nombreProducto);
			sentenciaAlmacen.setFloat(2, cantidadActual);
			sentenciaAlmacen.setInt(3, idUnidadMedida);
			sentenciaAlmacen.setFloat(4, cantidadMinima);
			sentenciaAlmacen.setFloat(5, cantidadMaxima);
			sentenciaAlmacen.setInt(6, idTipoProducto); 
			sentenciaAlmacen.executeUpdate();
	}
	


	public static void updatePructoAlmacen(String nombreProducto, float cantidadActual, int idunidadMedida,	float cantidadMinima, float cantidadMaxima, int idTipoProducto) throws SQLException {
		listarProductosAlmacen();
		conexion = new Conexion();
        connection = conexion.obtenerConexion();	        
		     
        for (int i = 0; i < arrayAlmacen.size(); i++) {        	
			if (arrayAlmacen.get(i).getNombreProducto().equals(Almacen.datoSeleccionadoTabla())) {
				int idProducto = arrayAlmacen.get(i).getIdProducto();
				
				sentenciaAlmacen= connection.prepareStatement("UPDATE Almacen SET NombreProducto = ? , Cantidad  = ? , IdUnidadMedida =? , CantidadMinima =? , CantidadMaxima =? , IdTipo =? WHERE IdProducto = ?");
				sentenciaAlmacen.setString(1, nombreProducto);
				sentenciaAlmacen.setFloat(2, cantidadActual);
				sentenciaAlmacen.setInt(3, idunidadMedida);
				sentenciaAlmacen.setFloat(4, cantidadMinima);
				sentenciaAlmacen.setFloat(5, cantidadMaxima);
				sentenciaAlmacen.setInt(6, idTipoProducto);
				sentenciaAlmacen.setInt(7, idProducto);
				sentenciaAlmacen.executeUpdate();
			}
		}
	}

	public static void borrarProducto() throws SQLException{
		listarProductosAlmacen();
        conexion = new Conexion();
        connection = conexion.obtenerConexion();
        String nombreProducto = Almacen.datoSeleccionadoTabla();        
        for (int i = 0; i < arrayAlmacen.size(); i++) {
			if (arrayAlmacen.get(i).getNombreProducto().equals(nombreProducto)) {
				int idProducto = arrayAlmacen.get(i).getIdProducto();
				sentenciaAlmacen= connection.prepareStatement("DELETE FROM Almacen WHERE IdProducto = ?;");
				sentenciaAlmacen.setInt(1, idProducto);
				sentenciaAlmacen.executeUpdate();
			}
		}    
    }
	

	public static ArrayList<ModeloAlmacen> getArrayAlmacen() {
		return arrayAlmacen;
	}	
}
