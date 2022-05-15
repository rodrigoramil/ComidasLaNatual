package modelo_bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.ModeloCliente;
import modelo.ModeloPRUEBA;
import modelo.ModeloRecetario;

public class BbddRecetario {

	private static Connection connection = null;
	private static Conexion conexion = null;
	private static PreparedStatement sentenciaRecetas = null;
	private static ArrayList<ModeloRecetario> arrayRecetario = null;


	public static void listarRecetas() {
		conexion = new Conexion();
		connection = conexion.obtenerConexion();
		arrayRecetario = new ArrayList<ModeloRecetario>();
	
		try {
			
			sentenciaRecetas = connection.prepareStatement("Select R.NOMBRERECETA, D.ESTADO from Recetas R, disponibilidadReceta D where R.IdDisponibilidad=D.IdDisponibilidad order by Estado");
			ResultSet rs = sentenciaRecetas.executeQuery();

			while (rs.next()) {
				
				ModeloRecetario recetas = new ModeloRecetario(
						rs.getString("NombreReceta"), 
						rs.getString("Estado"));
				arrayRecetario.add(recetas);
				
				
			}

		} catch (SQLException e) {
			System.out.println("Error en gestionPedidosClientes SentenciasSQL");
			System.out.println(e.getMessage());
		}
	}

	
	
	public static ArrayList<ModeloRecetario> getarrayRecetario() {
		return arrayRecetario;
	}

}
