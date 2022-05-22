package modelo_bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.ModeloAlmacen;
import modelo.ModeloListaGastos;

public class BbddListaGastos {
	private static Connection connection = null;
	private static Conexion conexion = null;
	private static PreparedStatement sentenciaGasto = null;
	private static ArrayList<ModeloListaGastos> arrayListaGastos = null;
	private static int IdCompraProductos;
	
	public static ArrayList<ModeloListaGastos> listarListaGastos() {
		conexion = new Conexion();
		connection = conexion.obtenerConexion();		
		arrayListaGastos = new ArrayList<ModeloListaGastos>();		
		try {
			sentenciaGasto = connection.prepareStatement("select G.IdCompraProductos, G.FechaCompra, G.CompraHecha, G.GastoCompra, U.NombreUsuario  from Gasto G, TrabajoUsuariosGastos T, Usuarios U where U.IdUsuario=T.IdUsuario AND T.IdCompraProductos=G.IdCompraProductos order by G.IdCompraProductos");
			ResultSet rs = sentenciaGasto.executeQuery();			

			while (rs.next()) {
				ModeloListaGastos modelo = new ModeloListaGastos(rs.getInt("IdCompraProductos"), rs.getString("FechaCompra"), rs.getBoolean("CompraHecha"), rs.getFloat("GastoCompra"), rs.getString("NombreUsuario"));
				arrayListaGastos.add(modelo);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al listar las recetas SentenciasSQL");
			System.out.println(e.getMessage());
		}
		return arrayListaGastos;			
	}

	public static ArrayList<ModeloListaGastos> getArrayListaGastos() {
		return arrayListaGastos;
	}
	
	//*******************
	

	private static java.sql.Timestamp getCurrentTimeStamp() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());
	}
	
	public static void addGasto() throws SQLException {
		conexion = new Conexion();
		connection = conexion.obtenerConexion();
		boolean compraHecha = false;
		float GastoCompra = 0;
		
		String sqlGasto = "Insert into Gasto (CompraHecha, FechaCompra, GastoCompra ) Values(?,?,?);";
		sentenciaGasto = connection.prepareStatement(sqlGasto);		
		sentenciaGasto.setBoolean(1, compraHecha);
		sentenciaGasto.setTimestamp(2, getCurrentTimeStamp());
		sentenciaGasto.setFloat(3, GastoCompra);
		sentenciaGasto.executeUpdate();
		

		int idUsuario = 0;
		BbddGestionUsuario.listarUsuarios();
		String nombreUsuario = BbddLogin.getUsuario();
		listarListaGastos();
		IdCompraProductos = arrayListaGastos.size()+1;
		
		for (int i = 0; i < BbddGestionUsuario.getArrayUsuarios().size(); i++) {
			if (nombreUsuario.equals(BbddGestionUsuario.getArrayUsuarios().get(i).getNombreUsuario())) {
				idUsuario = BbddGestionUsuario.getArrayUsuarios().get(i).getIdUsuario();
			}
		}

		String sqlTrabajoUsuarioGasto = "Insert into TrabajoUsuariosGastos(IdUsuario, IdCompraProductos) values (?, ?)";
		sentenciaGasto = connection.prepareStatement(sqlTrabajoUsuarioGasto);	
		sentenciaGasto.setInt(1, idUsuario);		
		sentenciaGasto.setInt(2, IdCompraProductos);
		sentenciaGasto.executeUpdate();
		

		
		
	}
	
	public static void addCompraProductos(int idProducto, float cantidadCompraProducto) throws SQLException {
		conexion = new Conexion();
		connection = conexion.obtenerConexion();
		
		String sqlCompraProductos = "Insert into compraproductos(IdCompraProductos, IdProducto, CantidadCompraProducto ) values (?, ?, ?);;";
		sentenciaGasto = connection.prepareStatement(sqlCompraProductos);		
		sentenciaGasto.setInt(1, IdCompraProductos);		
		sentenciaGasto.setInt(2, idProducto);		
		sentenciaGasto.setFloat(3, cantidadCompraProducto);
		sentenciaGasto.executeUpdate();
		
	}
	
	
	
	
	
}
