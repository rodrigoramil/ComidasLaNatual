package modelo_bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.ModeloListasCompra;

public class BbddListasCompra {
	private static Connection connection = null;
	private static Conexion conexion = null;
	private static PreparedStatement sentenciaRecetas = null;
	private static ArrayList<ModeloListasCompra> arrayListasCompra = null;
	
	public static void listarListasCompra() {
		conexion = new Conexion();
		connection = conexion.obtenerConexion();		
		arrayListasCompra = new ArrayList<ModeloListasCompra>();		
		try {
			sentenciaRecetas = connection.prepareStatement("select IdCompraProductos, FechaCompra, CompraHecha from gasto");
			ResultSet rs = sentenciaRecetas.executeQuery();			

			while (rs.next()) {
				ModeloListasCompra modelo = new ModeloListasCompra(rs.getInt("IdCompraProductos"), rs.getString("FechaCompra"), rs.getBoolean("CompraHecha"));
				arrayListasCompra.add(modelo);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al listar las recetas SentenciasSQL");
			System.out.println(e.getMessage());
		}			
	}

	public static ArrayList<ModeloListasCompra> getArrayListasCompra() {
		return arrayListasCompra;
	}
	
}
