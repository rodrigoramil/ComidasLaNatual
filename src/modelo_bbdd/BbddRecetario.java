package modelo_bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.ModeloCliente;
import modelo.ModeloPRUEBA;
import modelo.ModeloReceta;
import modelo.ModeloRecetario;
import vista.Recetario;

public class BbddRecetario {

	private static Connection connection = null;
	private static Conexion conexion = null;
	private static PreparedStatement sentenciaRecetas = null;
	private static ArrayList<ModeloRecetario> arrayRecetario = null;
	private static int idDisponibilidad;
	private static int idReceta;
	private static String datoSelecionado;


	public static ArrayList<ModeloRecetario>  listarRecetas() {
		conexion = new Conexion();
		connection = conexion.obtenerConexion();
		arrayRecetario = new ArrayList<ModeloRecetario>();
	
		try {			
			sentenciaRecetas = connection.prepareStatement("Select R.IdReceta, R.NombreReceta, R.PrecioVenta, T.Tipo , D.Estado, R.Elaboracion from Recetas R, Tipoproducto T, DisponibilidadReceta D where R.IdDisponibilidad=D.IdDisponibilidad and R.IdTipo=T.IdTipo order by Estado");
			ResultSet rs = sentenciaRecetas.executeQuery();
			while (rs.next()) {				
				ModeloRecetario recetas = new ModeloRecetario(
						rs.getInt("IdReceta"),
						rs.getString("NombreReceta"),
						rs.getFloat("PrecioVenta"),
						rs.getString("Tipo"),
						rs.getString("Estado"),
						rs.getString("Elaboracion"));				
				arrayRecetario.add(recetas);				
			}

		} catch (SQLException e) {
			System.out.println("Error en gestionPedidosClientes SentenciasSQL");
			System.out.println(e.getMessage());
		}
		return arrayRecetario;
	}	
	
	public static void updateDisponibilidadReceta() {		
		System.out.println("esta entrando por en editar"); //-> BORRAR
        conexion = new Conexion();
        connection = conexion.obtenerConexion();
		datoSelecionado = Recetario.datoSeleccionadoTabla();       
        
        if (idDisponibilidad > 0) {
	        for (int i = 0; i < arrayRecetario.size(); i++) {
				if (arrayRecetario.get(i).getNombreReceta().equals(datoSelecionado)) {
					idReceta = arrayRecetario.get(i).getIdReceta();
				}
			}
	
	        try {        	
	        	sentenciaRecetas= connection.prepareStatement("update Recetas set IdDisponibilidad = ? where IdReceta = ?");
	        	sentenciaRecetas.setInt(1, idDisponibilidad);
	            sentenciaRecetas.setInt(2, idReceta);
	            sentenciaRecetas.executeUpdate();      
	            listarRecetas();
	        } catch (SQLException e) {
	        	System.out.println("Error en editarCliente SentenciasSQL");
	            System.out.println(e.getMessage());        
	        }
        }			
	}
	
	
	
	
	
	
	
	
	
	
	public static ArrayList<ModeloRecetario> getarrayRecetario() {
		return arrayRecetario;
	}



	public static int getIdDisponibilidad() {
		return idDisponibilidad;
	}



	public static void setIdDisponibilidad(int idDisponibilidad) {
		BbddRecetario.idDisponibilidad = idDisponibilidad;
	}



	public static int getIdReceta() {
		return idReceta;
	}



	public static void setIdReceta(int idReceta) {
		BbddRecetario.idReceta = idReceta;
	}

}
