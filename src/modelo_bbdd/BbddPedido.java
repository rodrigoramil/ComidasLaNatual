package modelo_bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controlador.ControladorGestionPedidos;
import modelo.ModeloPedido;



public class BbddPedido {

	private static Connection connection = null;
	private static Conexion conexion = null;
	private static PreparedStatement sentenciaPedido = null;
	private static ArrayList<ModeloPedido> arrayPedido;
	private static int idPedido;
	private static ArrayList<ModeloPedido> arrayPedidosCliente;
	
	public static ArrayList<ModeloPedido> listarPedido() {
		
		conexion = new Conexion();
		connection = conexion.obtenerConexion();
		arrayPedido = new ArrayList<ModeloPedido>();
		
		idPedido = ControladorGestionPedidos.getIdPedido();
		
		try {
			sentenciaPedido = connection.prepareStatement("Select R.IdReceta, R.NombreReceta, R.PrecioVenta, P.CantidadRecetaVenta, C.NombreCliente, PC.IdPedido, C.IdCliente from Recetas R, Pedidos P, Cliente C, PedidoCliente PC where C.IdCliente = PC.IdCliente AND PC.IdPedido = P.IdPedido And R.IdReceta = P.IdReceta and PC.IdPedido =?");

			sentenciaPedido.setInt(1, idPedido);
			ResultSet rsPedido = sentenciaPedido.executeQuery();

			while (rsPedido.next()) {
				ModeloPedido recetas = new ModeloPedido(rsPedido.getInt("IdReceta"), rsPedido.getString("NombreReceta"), rsPedido.getFloat("PrecioVenta"), rsPedido.getInt("CantidadRecetaVenta"), rsPedido.getString("NombreCliente"), rsPedido.getInt("IdPedido"), rsPedido.getInt("IdCliente"));
				arrayPedido.add(recetas);
			}
		}

		 catch (SQLException e) {
			System.out.println("Error en gestionPedidosClientes SentenciasSQL");
			System.out.println(e.getMessage());
		}

		return arrayPedido;
	}

	
	public static ArrayList<ModeloPedido> listarTodosPedidos() {
		conexion = new Conexion();
		connection = conexion.obtenerConexion();
		arrayPedido = new ArrayList<ModeloPedido>();
		try {
			sentenciaPedido = connection.prepareStatement("Select R.IdReceta, R.NombreReceta, R.PrecioVenta, P.CantidadRecetaVenta, C.NombreCliente, PC.IdPedido, C.IdCliente from Recetas R, Pedidos P, Cliente C, PedidoCliente PC where C.IdCliente = PC.IdCliente AND PC.IdPedido = P.IdPedido And R.IdReceta = P.IdReceta order by IdPedido");
			ResultSet rsPedido = sentenciaPedido.executeQuery();

			while (rsPedido.next()) {
				ModeloPedido recetas = new ModeloPedido(rsPedido.getInt("IdReceta"), rsPedido.getString("NombreReceta"), rsPedido.getFloat("PrecioVenta"), rsPedido.getInt("CantidadRecetaVenta"), rsPedido.getString("NombreCliente"), rsPedido.getInt("IdPedido"), rsPedido.getInt("IdCliente"));
				arrayPedido.add(recetas);
			}
		}
		 catch (SQLException e) {
			System.out.println("Error en gestionPedidosClientes SentenciasSQL");
			System.out.println(e.getMessage());
		}
		return arrayPedido;
	}


	public static void addComidaBebida(int idCliente, int idReceta, int cantidadRecetaVenta)  throws SQLException{
		idPedido = ControladorGestionPedidos.getIdPedido();
		if (idPedido==0) {
			addPedido(idCliente);
			idPedido = todosPedidos().size()+1;
		}
		
		String SQLPedidos = "INSERT INTO Pedidos (IdReceta, IdPedido, CantidadRecetaVenta ) VALUES ( ?, ?, ?)";
		sentenciaPedido = connection.prepareStatement(SQLPedidos);
		sentenciaPedido.setInt(1, idReceta);
		sentenciaPedido.setInt(2, idPedido);
		sentenciaPedido.setInt(3, cantidadRecetaVenta);
		sentenciaPedido.executeUpdate();
	}
		
	
	public static void addPedido(int idCliente)  throws SQLException{

		String SQLPedidoCliente = "insert into PedidoCliente(IdCliente) values (?);";
		sentenciaPedido = connection.prepareStatement(SQLPedidoCliente);
		sentenciaPedido.setInt(1, idCliente );
		sentenciaPedido.executeUpdate();
		

	}	
	

	public static ArrayList<ModeloPedido> todosPedidos() throws SQLException{
		arrayPedidosCliente = new ArrayList<ModeloPedido>();
		
		sentenciaPedido = connection.prepareStatement("Select PC.IdPedido, C.IdCliente, C.NombreCliente from Cliente C, PedidoCliente PC where C.IdCliente = PC.IdCliente order by IdPedido");
		ResultSet rsPedido = sentenciaPedido.executeQuery();

		while (rsPedido.next()) {
			ModeloPedido recetas = new ModeloPedido (rsPedido.getInt("IdPedido"), rsPedido.getInt("IdCliente"), rsPedido.getString("NombreCliente"));
			arrayPedidosCliente.add(recetas);
		}
		return arrayPedidosCliente;		
	}
	
	public static void editarPedido(int idReceta,int cantidadRecetaVenta) throws SQLException {
        conexion = new Conexion();
        connection = conexion.obtenerConexion();
    	sentenciaPedido= connection.prepareStatement("update Pedidos set CantidadRecetaVenta = ? where IdReceta = ? and IdPedido = ?");
    	sentenciaPedido.setInt(1, cantidadRecetaVenta);
        sentenciaPedido.setInt(2, idReceta);
        sentenciaPedido.setInt(3, idPedido);            
        sentenciaPedido.executeUpdate();

    }
	
	public static void borrarComidaBebida(int idReceta) throws SQLException{
        conexion = new Conexion();
        connection = conexion.obtenerConexion();
        
        // Nota: no deber�amos borrar el pedido cuando lo pagamos, para que podamos verlo en DetalleFactura de la secci�n Contabilidad
        
    	sentenciaPedido= connection.prepareStatement("DELETE FROM Pedidos WHERE IdReceta = ? AND IdPedido = ?;");
    	sentenciaPedido.setInt(1, idReceta);
    	sentenciaPedido.setInt(2, idPedido);            
    	sentenciaPedido.executeUpdate();

    }

	public static void borrarPedido () throws SQLException{
        conexion = new Conexion();
        connection = conexion.obtenerConexion();        	
    	sentenciaPedido= connection.prepareStatement("DELETE FROM Pedidos WHERE IdPedido = ?;");
    	sentenciaPedido.setInt(1, idPedido);            
    	sentenciaPedido.executeUpdate();

    }
	
	public static ArrayList<ModeloPedido> getArrayPedido() {
		return arrayPedido;
	}

	public static int getIdPedido() {
		return idPedido;
	}

	public static void setIdPedido(int idPedido) {
		BbddPedido.idPedido = idPedido;
	}


	public static ArrayList<ModeloPedido> getArrayPedidosCliente() {
		return arrayPedidosCliente;
	}

	
}
