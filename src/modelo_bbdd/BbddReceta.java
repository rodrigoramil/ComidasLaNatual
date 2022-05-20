package modelo_bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controlador.ControladorBuscarComidaBebida;
import controlador.ControladorProductosAlmacen;
import modelo.ModeloProductosAlmacen;
import modelo.ModeloReceta;
import modelo.ModeloRecetario;
import vista.BuscarComidaBebida;
import vista.ProductosAlmacen;
import vista.Receta;
import vista.Recetario;

public class BbddReceta {

	private static Connection connection = null;
	private static Conexion conexion = null;
	private static PreparedStatement sentenciaRecetas = null;
	private static String nombreRecetaSeleccionada;
	private static ArrayList<ModeloReceta> arrayReceta;
	private static String precioVenta;
	private static String elaboracion;
	private static String datoSelecionado;
	private static int idProducto;
	private static int idReceta;
	private static float cantidad;

	
	public static ArrayList<ModeloReceta> listarRecetas() {
		conexion = new Conexion();
		connection = conexion.obtenerConexion();
		arrayReceta = new ArrayList<ModeloReceta>();
		
		try {
			
			if (ControladorBuscarComidaBebida.getDesdeVentas()) {
				nombreRecetaSeleccionada = BuscarComidaBebida.datoSeleccionadoTabla();
			} else {			
				int recetaSelecionada = Recetario.recetaSeleccionada();			
				for (int i = 0; i < Recetario.getArrayRecetas().size(); i++) {
					if (recetaSelecionada==i) {
						nombreRecetaSeleccionada=Recetario.getArrayRecetas().get(i).getNombreReceta();
						precioVenta = String.valueOf(Recetario.getArrayRecetas().get(i).getPrecioVenta());
						elaboracion = Recetario.getArrayRecetas().get(i).getElaboracion();
					}
				}
			}
			
			sentenciaRecetas = connection.prepareStatement("Select I.IdReceta, R.NombreReceta, I.IdProducto, A.NombreProducto, I.Cantidad from Ingredientes I, Recetas R, Almacen A where R.NombreReceta=? and R.IdReceta = I.IdReceta and I.IdProducto = A.IdProducto");
			sentenciaRecetas.setString(1, nombreRecetaSeleccionada);
			ResultSet rsReceta = sentenciaRecetas.executeQuery();

			while (rsReceta.next()) {
				ModeloReceta recetas = new ModeloReceta(rsReceta.getInt("IdReceta"), rsReceta.getString("NombreReceta"), rsReceta.getInt("IdProducto"), rsReceta.getString("NombreProducto"), rsReceta.getFloat("Cantidad"));
				arrayReceta.add(recetas);
			}
		}

		 catch (SQLException e) {
			System.out.println("Error en gestionPedidosClientes SentenciasSQL");
			System.out.println(e.getMessage());
		}
		return arrayReceta;
	}

	
	public static void addProductoReceta() throws SQLException{

		cantidad = ControladorProductosAlmacen.getCantidad();		
		datoSelecionado = ProductosAlmacen.datoSeleccionadoTabla();
	
        for (int i = 0; i < ProductosAlmacen.getArrayProductos().size(); i++) {     	
			if (ProductosAlmacen.getArrayProductos().get(i).getNombreProducto().equals(datoSelecionado)) {					
				idProducto = ProductosAlmacen.getArrayProductos().get(i).getIdProducto();
			}
		}

        for (int i = 0; i < Recetario.getArrayRecetas().size(); i++) {
			if (Recetario.getArrayRecetas().get(i).getNombreReceta().equals(Recetario.datoSeleccionadoTabla())) {
				idReceta = Recetario.getArrayRecetas().get(i).getIdReceta();
				String SQLReceta = "INSERT INTO Ingredientes (IdReceta, IdProducto, Cantidad ) VALUES ( ?, ?, ?)";
				sentenciaRecetas = connection.prepareStatement(SQLReceta);
				sentenciaRecetas.setInt(1, idReceta);
				sentenciaRecetas.setInt(2, idProducto);
				sentenciaRecetas.setFloat(3, cantidad);
				sentenciaRecetas.executeUpdate();
				arrayReceta = listarRecetas();
			}
		}   
  

			
	}
	
	public static void editarIngrediente(float cantidad) throws SQLException {
        conexion = new Conexion();
        
        connection = conexion.obtenerConexion();
 
        String nombreIngrediente = Receta.datoSeleccionadoTabla();
        for (int i = 0; i < arrayReceta.size(); i++) {
			if (arrayReceta.get(i).getNombreProducto().equals(nombreIngrediente)) {
				idProducto=arrayReceta.get(i).getIdProducto();
				idReceta = arrayReceta.get(i).getIdReceta();
			}
		}
        sentenciaRecetas= connection.prepareStatement("update Ingredientes set Cantidad = ? where IdReceta = ? and IdProducto = ?");
    	sentenciaRecetas.setFloat(1, cantidad);
    	sentenciaRecetas.setInt(2, idReceta);
    	sentenciaRecetas.setInt(3, idProducto);            
    	sentenciaRecetas.executeUpdate();

    }
	
	public static void borrarIngrediente () throws SQLException{
        conexion = new Conexion();
        connection = conexion.obtenerConexion();
        
        String nombreIngrediente = Receta.datoSeleccionadoTabla();
        for (int i = 0; i < arrayReceta.size(); i++) {
			if (arrayReceta.get(i).getNombreProducto().equals(nombreIngrediente)) {
				idProducto=arrayReceta.get(i).getIdProducto();
				idReceta = arrayReceta.get(i).getIdReceta();
			}
		}      
        	
        sentenciaRecetas= connection.prepareStatement("DELETE FROM Ingredientes WHERE IdReceta = ? AND IdProducto = ?;");
    	sentenciaRecetas.setInt(1, idReceta);
    	sentenciaRecetas.setInt(2, idProducto);            
    	sentenciaRecetas.executeUpdate();

    }
	

	public static ArrayList<ModeloReceta> getArrayReceta() {
		return arrayReceta;
	}


	public static String getNombreRecetaSeleccionada() {
		return nombreRecetaSeleccionada;
	}

	public static void setNombreRecetaSeleccionada(String nombreRecetaSeleccionada) {
		BbddReceta.nombreRecetaSeleccionada = nombreRecetaSeleccionada;
	}



	public static String getPrecioVenta() {
		return precioVenta;
	}

	public static String getElaboracion() {
		return elaboracion;
	}

}
	
	
	
	
	
	
	
	
	
	
	
/*	
	
	
	
	
	
	public static void insertarReceta() throws SQLException{
		
		int idProducto = 0;
		int idReceta = 0;
		float cantidad = 0;
		String elaboracion = "";
		String nombreReceta = "";
//		String nombreProducto = "";
		float precio = 0;
		
		for (int i = 0; i < Receta.getArrayIngredientes().size(); i++) {
			
			idReceta = Receta.getArrayIngredientes().get(i).getIdReceta();
			System.out.println("idReceta - "+ idReceta);
			
//			elaboracion = Receta.getArrayIngredientes().get(i).getElaboracion();
			System.out.println("elaboracion - "+ elaboracion);
			
			nombreReceta = Receta.getArrayIngredientes().get(i).getNombreReceta();
			System.out.println("nombreReceta - "+ nombreReceta);
			
//			nombreProducto = Receta.getArrayIngredientes().get(i).getNombreProducto();
//			precio = Receta.getArrayIngredientes().get(i).getPrecioVenta();
//			System.out.println("precio - "+precio);
			
		}

		// crea la receta 
		String SQLReceta = "insert into recetas(IdReceta, IdTipo, IdDisponibilidad, NombreReceta, PrecioVenta, Elaboracion) values (?,?,?,?,?,?))";
		sentenciaRecetas = connection.prepareStatement(SQLReceta);
		sentenciaRecetas.setInt(1, idReceta);
		sentenciaRecetas.setInt(2, 1);
		sentenciaRecetas.setInt(3, 2);
		sentenciaRecetas.setString(4, nombreReceta);
		sentenciaRecetas.setFloat(5, precio);
		sentenciaRecetas.setString(6, elaboracion);
		sentenciaRecetas.executeUpdate();
	
		
		// aqui se busca idreceta al cual asociar los ingredientes
		String SQLIdReceta = "Select idReceta from recetas where nombreReceta = ?";
		sentenciaRecetas = connection.prepareStatement(SQLIdReceta);
		sentenciaRecetas.setString(1, nombreReceta);
		
		int bbddIdReceta = sentenciaRecetas.executeUpdate();
		
		
		for (int i = 0; i < Receta.getArrayIngredientes().size(); i++) {
			
				
			idReceta = Receta.getArrayIngredientes().get(i).getIdReceta();
			System.out.println("idReceta - "+idReceta);
			
			idProducto = Receta.getArrayIngredientes().get(i).getIdProducto();
			System.out.println("idProducto - "+idProducto);

			cantidad = Receta.getArrayIngredientes().get(i).getCantidad();
			System.out.println("cantidad - "+cantidad);
			
			String SQLIngrediente = "insert into ingredientes(IdReceta, IdProducto, Cantidad) values (?,?,?))";
			sentenciaRecetas = connection.prepareStatement(SQLIngrediente);
			sentenciaRecetas.setInt(1, idReceta);
			sentenciaRecetas.setInt(2, idProducto);			
			sentenciaRecetas.setFloat(3, cantidad);
			sentenciaRecetas.executeUpdate();
			
		}
		
		
	
		//con el idreceta, agregamos ingredientes
		String SQLIngrediente = "insert into ingredientes(IdReceta, IdProducto, Cantidad) values (?,?,?))";
		sentenciaRecetas = connection.prepareStatement(SQLIngrediente);
		sentenciaRecetas.setInt(1, idProducto);
		sentenciaRecetas.setInt(2, idReceta);
		sentenciaRecetas.setFloat(3, cantidad);
		sentenciaRecetas.executeUpdate();
	
	}
	
	public static ArrayList<ModeloReceta> listarIngredientes() {
		conexion = new Conexion();
		connection = conexion.obtenerConexion();
		arrayReceta = new ArrayList<ModeloReceta>();
		try {
			// la seleción debe provenir del controlado
			
			int productoSelecionado = ProductosAlmacen.productoSeleccionado();			

			sentenciaIngredientes = connection.prepareStatement("Select  I.IdReceta, I.IdProducto, I.Cantidad from Ingredientes I where I.IdReceta=? ");
			sentenciaIngredientes.setInt(1, productoSelecionado);
			ResultSet rsReceta = sentenciaIngredientes.executeQuery();

			while (rsReceta.next()) {
				ModeloReceta ingredientes = new ModeloReceta(rsReceta.getInt("IdProducto"), rsReceta.getInt("IdReceta"), rsReceta.getFloat("Cantidad"));
				arrayReceta.add(ingredientes);
			}
			
			System.out.println(arrayReceta);
			
		} catch (SQLException e) {
			System.out.println("Error en gestionPedidosClientes SentenciasSQL");
			System.out.println(e.getMessage());
		}
		
		return arrayReceta;		
	}
	
	public static void insertarIngredientes () throws SQLException {
		
		int idProducto = 0;
		int idReceta = 0;
		float cantidad = 0;
		
		for (int i = 0; i < Receta.getArrayIngredientes().size(); i++) {			
			
			idReceta = Receta.getArrayIngredientes().get(i).getIdReceta();
			System.out.println("idReceta - "+idReceta);
			
			idProducto = Receta.getArrayIngredientes().get(i).getIdProducto();
			System.out.println("idProducto - "+idProducto);

			cantidad = Receta.getArrayIngredientes().get(i).getCantidad();
			System.out.println("cantidad - "+cantidad);
			
			String SQLIngrediente = "insert into ingredientes(IdReceta, IdProducto, Cantidad) values (?,?,?))";
			sentenciaIngredientes = connection.prepareStatement(SQLIngrediente);
			sentenciaIngredientes.setInt(1, idReceta);
			sentenciaIngredientes.setInt(2, idProducto);			
			sentenciaIngredientes.setFloat(3, cantidad);
			sentenciaIngredientes.executeUpdate();
			
		}
		
	}
	
	*/
	
