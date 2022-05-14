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
	private static PreparedStatement sentenciaRecetas = null;
	private static ArrayList<ModeloListaGastos> arrayListaGastos = null;
	
	public static void listarListaGastos() {
		conexion = new Conexion();
		connection = conexion.obtenerConexion();		
		arrayListaGastos = new ArrayList<ModeloListaGastos>();		
		try {
			sentenciaRecetas = connection.prepareStatement("select G.IdCompraProductos,G.FechaCompra, G.CompraHecha, G.GastoCompra, U.NombreUsuario  from Gasto G, TrabajoUsuariosGastos T, Usuarios U where U.NombreUsuario=T.NombreUsuario AND T.IdCompraProductos=G.IdCompraProductos");
			ResultSet rs = sentenciaRecetas.executeQuery();			

			while (rs.next()) {
				ModeloListaGastos modelo = new ModeloListaGastos(rs.getInt("IdCompraProductos"), rs.getString("FechaCompra"), rs.getBoolean("CompraHecha"), rs.getFloat("GastoCompra"), rs.getString("NombreUsuario"));
				arrayListaGastos.add(modelo);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al listar las recetas SentenciasSQL");
			System.out.println(e.getMessage());
		}			
	}

	public static ArrayList<ModeloListaGastos> getArrayListaGastos() {
		return arrayListaGastos;
	}
	
}
