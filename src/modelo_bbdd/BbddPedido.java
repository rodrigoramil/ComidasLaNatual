package modelo_bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ModeloPedido;



public class BbddPedido {

	private static Connection connection = null;
	private static Conexion conexion = null;
	private static PreparedStatement sentenciaPedido = null;
	private static ArrayList<ModeloPedido> arrayPedido;
	private static int idPedido;
	
	public static ArrayList<ModeloPedido> listarPedido() {
		conexion = new Conexion();
		connection = conexion.obtenerConexion();
		arrayPedido = new ArrayList<ModeloPedido>();
		try {
			
			sentenciaPedido = connection.prepareStatement("Select I.IdReceta, R.NombreReceta, I.IdProducto, A.NombreProducto, I.Cantidad from Ingredientes I, Recetas R, Almacen A where R.NombreReceta=? and R.IdReceta = I.IdReceta and I.IdProducto = A.IdProducto");
			sentenciaPedido.setInt(1, idPedido);
			ResultSet rsPedido = sentenciaPedido.executeQuery();

			while (rsPedido.next()) {
				ModeloPedido recetas = new ModeloPedido(rsPedido.getInt("IdPedido"), rsPedido.getInt("IdCliente"), rsPedido.getString("NombreCliente"), rsPedido.getInt("IdReceta"), rsPedido.getString("NombreReceta"), rsPedido.getInt("CantidadRecetaVenta"), rsPedido.getFloat("PrecioVenta"));
				arrayPedido.add(recetas);
			}
		}

		 catch (SQLException e) {
			System.out.println("Error en gestionPedidosClientes SentenciasSQL");
			System.out.println(e.getMessage());
		}

		return arrayPedido;
	}

/*

	private static Connection connection = null;
	private static Conexion conexion = null;
	private static PreparedStatement sentencia = null;
	private static ArrayList<ModeloPedido> arrayPedidos = null;
	
	public static void listarPedidos(int IdCliente) {
		conexion = new Conexion();
		connection = conexion.obtenerConexion();
		arrayPedidos = new ArrayList<ModeloPedido>();
	
		try {
			sentencia = connection.prepareStatement("Select R.NombreReceta, R.PrecioVenta, P.CantidadRecetaVenta,C.NombreCliente from Recetas R, Pedidos P, Cliente C, PedidoCliente PC where C.IdCliente=?");
			ResultSet rs = sentencia.executeQuery();

			while (rs.next()) {
				
				ModeloPedido cliente = new ModeloPedido(
						rs.getString("NombreReceta"), 
						rs.getFloat("PrecioVenta"),
						rs.getInt("CantidadRecetaVenta"),
						rs.getString("NombreCliente"));	
						arrayPedidos.add(cliente);
				
				
			}

		} catch (SQLException e) {
			System.out.println("Error en gestionPedidosClientes SentenciasSQL");
			System.out.println(e.getMessage());
		}
	}

    
	


  	public static ArrayList<ModeloPedido> getArrayPedidos() {
		return arrayPedidos;
	}

<<<<<<< HEAD



	

=======
>>>>>>> pruebas
*/
}
