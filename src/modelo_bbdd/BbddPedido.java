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




	

}
