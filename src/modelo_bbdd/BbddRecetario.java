package modelo_bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import controlador.ControladorRecetario;
import modelo.ModeloRecetario;
import vista.Receta;
import vista.Recetario;
public class BbddRecetario {

	private static Connection connection = null;
	private static Conexion conexion = null;
	private static PreparedStatement sentenciaRecetas = null;
	private static ArrayList<ModeloRecetario> arrayRecetario = null;
	private static int idDisponibilidad;
	private static int idReceta;
	private static String datoSelecionado;
	private static int idTipo;


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

				if (ControladorRecetario.isListarTodo()) {
					arrayRecetario.add(recetas);
						
				} else if (!ControladorRecetario.isListarTodo()){
					if (recetas.getTipo().equals("Comida")) {
						arrayRecetario.add(recetas);	
					}									
				}			
			}
			ControladorRecetario.setListarTodo(false);
			
		} catch (SQLException e) {
			System.out.println("Error en gestionPedidosClientes SentenciasSQL");
			System.out.println(e.getMessage());
		}
		return arrayRecetario;
	}	
	
	public static void updateDisponibilidadReceta() {		
        conexion = new Conexion();
        connection = conexion.obtenerConexion();        
		datoSelecionado = Recetario.datoSeleccionadoTabla();        
        if (idDisponibilidad > 0) {
	        for (int i = 0; i < arrayRecetario.size(); i++) {
				if (arrayRecetario.get(i).getNombreReceta().equals(datoSelecionado)) {
					idReceta = arrayRecetario.get(i).getIdReceta();
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
        }			
	}
	
	
	public static void insertarNuevaReceta() throws SQLException , NumberFormatException{
		int idDisponibilidad = 3;
		String nombreReceta = Receta.getNombre_receta().getText();
		float precioVenta = 0;

		try {
			precioVenta = Float.parseFloat(Receta.getPrecio_receta().getText());
		} catch (NumberFormatException e) {
			precioVenta = 0;
		}

		String elaboracion = Receta.getTexto_elaboracion().getText();		
		
		conexion = new Conexion();
		connection = conexion.obtenerConexion();
		String SQLReceta = "Insert into recetas(IdTipo, IdDisponibilidad, NombreReceta, PrecioVenta, Elaboracion) values ( ?, ?, ?, ?, ? )";
		sentenciaRecetas = connection.prepareStatement(SQLReceta);
		sentenciaRecetas.setInt(1, idTipo);
		sentenciaRecetas.setInt(2, idDisponibilidad);
		sentenciaRecetas.setString(3, nombreReceta);
		sentenciaRecetas.setFloat(4, precioVenta);
		sentenciaRecetas.setString(5, elaboracion);
		sentenciaRecetas.executeUpdate();
	}
	
	public static void modificarReceta() throws SQLException , NumberFormatException {
				
		int idReceta;
		String nombreReceta = Receta.getNombre_receta().getText();
		float precioVenta = 0;
		precioVenta = Float.parseFloat(Receta.getPrecio_receta().getText());	
		String elaboracion = Receta.getTexto_elaboracion().getText();	

        conexion = new Conexion();        
        connection = conexion.obtenerConexion(); 
        
        for (int i = 0; i < BbddRecetario.getarrayRecetario().size(); i++) {
			if (BbddRecetario.getarrayRecetario().get(i).getNombreReceta().equals(Recetario.datoSeleccionadoTabla())) {
				idReceta=BbddRecetario.getarrayRecetario().get(i).getIdReceta();
				sentenciaRecetas= connection.prepareStatement("update recetas set NombreReceta = ?, PrecioVenta = ?, Elaboracion= ? where IdReceta = ?");
				sentenciaRecetas.setString(1, nombreReceta);
				sentenciaRecetas.setFloat(2, precioVenta);
				sentenciaRecetas.setString(3, elaboracion);
				sentenciaRecetas.setInt(4, idReceta);
				sentenciaRecetas.executeUpdate();
			}
		}

	}
	
	
	public static void borrarReceta() throws SQLException {
        conexion = new Conexion();
        connection = conexion.obtenerConexion();
        
        String nombreReceta = Recetario.datoSeleccionadoTabla();
        for (int i = 0; i < arrayRecetario.size(); i++) {
			if (arrayRecetario.get(i).getNombreReceta().equals(nombreReceta)) {
				idReceta = arrayRecetario.get(i).getIdReceta();
			}
		}    
        sentenciaRecetas= connection.prepareStatement("DELETE FROM Ingredientes WHERE IdReceta = ?;");
    	sentenciaRecetas.setInt(1, idReceta);         
    	sentenciaRecetas.executeUpdate();
        	
        sentenciaRecetas= connection.prepareStatement("DELETE FROM Recetas WHERE IdReceta = ?;");
    	sentenciaRecetas.setInt(1, idReceta);         
    	sentenciaRecetas.executeUpdate();
		
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

	public static int getIdTipo() {
		return idTipo;
	}

	public static void setIdTipo(int idTipo) {
		BbddRecetario.idTipo = idTipo;
	}


}
