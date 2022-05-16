package modelo_bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ModeloCalculoGanancias;
import modelo.ModeloCalculoGastos;


public class BbddCalculoGastos {
	private static Connection connection = null;
	private static Conexion conexion = null;
	private static PreparedStatement sentenciaRecetas = null;
	private static ArrayList<ModeloCalculoGastos> arrayCalculoGastos = null;
	
	public static void listarCalculoGasto() {
		conexion = new Conexion();
		connection = conexion.obtenerConexion();		
		arrayCalculoGastos = new ArrayList<ModeloCalculoGastos>();		
		try {
			sentenciaRecetas = connection.prepareStatement("Select IdCompraProductos, CompraHecha, FechaCompra, GastoCompra from gasto");
			ResultSet rs = sentenciaRecetas.executeQuery();			

			while (rs.next()) {
				
				ModeloCalculoGastos modelo = new ModeloCalculoGastos(rs.getInt("IdCompraProductos"), rs.getBoolean("CompraHecha"), rs.getDate("FechaCompra"), rs.getFloat("GastoCompra"));
				arrayCalculoGastos.add(modelo);
				
			}
			
		} catch (SQLException e) {
			System.out.println("Error en la consulta a Base de Datos");
			System.out.println(e.getMessage());
		}			
	}
	
	public static void sumaGasto(float gastoCompra) {
		conexion = new Conexion(); // se ha de asociar al Lbl total ganancias 
		connection = conexion.obtenerConexion();		
		//arrayCalculoGanancias = new ArrayList<ModeloCalculoGanancias>();		
		try {
			sentenciaRecetas = connection.prepareStatement("select sum(gastoCompra) from gasto");
			ResultSet rs = sentenciaRecetas.executeQuery();			

			while (rs.next()) {
				ModeloCalculoGastos modelo = new ModeloCalculoGastos( rs.getFloat("GananciaPedido"));
				arrayCalculoGastos.add(modelo);
			}
			
		} catch (SQLException e) {
			System.out.println("Error en la consulta a Base de Datos");
			System.out.println(e.getMessage());
		}			
	}
	
	public static ArrayList<ModeloCalculoGastos> getCalculoGastos() {
		return arrayCalculoGastos;
	}
	
}
