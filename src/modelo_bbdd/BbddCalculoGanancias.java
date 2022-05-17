package modelo_bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.ModeloAlmacen;
import modelo.ModeloCalculoGanancias;


public class BbddCalculoGanancias {
	private static Connection connection = null;
	private static Conexion conexion = null;
	private static PreparedStatement sentenciaRecetas = null;
	private static ArrayList<ModeloCalculoGanancias> arrayCalculoGanancias = null;
	private static Double sumaGanancias;
	
	public static ArrayList<ModeloCalculoGanancias>  listarCalculoGanancias() {
		conexion = new Conexion();
		connection = conexion.obtenerConexion();		
		arrayCalculoGanancias = new ArrayList<ModeloCalculoGanancias>();		
		try {
			sentenciaRecetas = connection.prepareStatement("Select G.IdPedido, G.FechaPedido, G.GananciaPedido, T.NombreUsuario from Ganancias G, Trabajousuariosganancias T where T.IdPedido = G.IdPedido");
			ResultSet rs = sentenciaRecetas.executeQuery();			

			while (rs.next()) {
				ModeloCalculoGanancias modelo = new ModeloCalculoGanancias(rs.getInt("IdPedido"), rs.getDate("FechaPedido"), rs.getFloat("GananciaPedido"), rs.getString("NombreUsuario"));
				arrayCalculoGanancias.add(modelo);
			}
			
		} catch (SQLException e) {
			System.out.println("Error en la consulta a Base de Datos");
			System.out.println(e.getMessage());
		}
		return arrayCalculoGanancias;			
	}
	
	public static Double sumaGanancias () {
		conexion = new Conexion(); // se ha de asociar al Lbl total ganancias 
		connection = conexion.obtenerConexion();		
		arrayCalculoGanancias = new ArrayList<ModeloCalculoGanancias>();		
		try {
			sentenciaRecetas = connection.prepareStatement("select sum(gananciaPedido) from ganancias");
			ResultSet rs = sentenciaRecetas.executeQuery();			

			// falla al meterlo en una variable
			while (rs.next()) {
				sumaGanancias = rs.getDouble("GananciaPedido");

			}
			
		} catch (SQLException e) {
			System.out.println("Error en la consulta a Base de Datos");
			System.out.println(e.getMessage());
		}
		return sumaGanancias;			
	}
	
	public static ArrayList<ModeloCalculoGanancias> getArrayCalculoGanancias() {
		return arrayCalculoGanancias;
	}

	public static Double getSumaGanancias() {
		return sumaGanancias;
	}
	
}
