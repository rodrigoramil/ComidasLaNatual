package modelo_bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.ModeloAlmacen;
import modelo.ModeloComidaBebida;

public class BbddComidaBebida {
	private static Connection connection = null;
	private static Conexion conexion = null;
	private static PreparedStatement sentenciaAlmacen = null;
	private static ArrayList<ModeloComidaBebida> arrayComidaBebida = null;
	
	public static void listarComidaBebida() {
		conexion = new Conexion();
		connection = conexion.obtenerConexion();		
		arrayComidaBebida = new ArrayList<ModeloComidaBebida>();		
		try {
			sentenciaAlmacen = connection.prepareStatement("Select R.NombreReceta, R.PrecioVenta, D.Estado from recetas R, disponibilidadreceta D where D.IdDisponibilidad = R.IdDisponibilidad order by Estado");
			ResultSet rs = sentenciaAlmacen.executeQuery();			

			while (rs.next()) {
				ModeloComidaBebida modelo = new ModeloComidaBebida(rs.getString("NombreReceta"), rs.getFloat("PrecioVenta"), rs.getString("Estado"));
				arrayComidaBebida.add(modelo);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al listar las recetas SentenciasSQL");
			System.out.println(e.getMessage());
		}	
	}

	public static ArrayList<ModeloComidaBebida> getArrayComidaBebida() {
		return arrayComidaBebida;
	}

}
