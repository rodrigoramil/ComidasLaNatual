package modelo_bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ModeloCalculoGanancias;


public class BbddCalculoGanancias {
	private static Connection connection = null;
	private static Conexion conexion = null;
	private static PreparedStatement sentenciaRecetas = null;
	private static ArrayList<ModeloCalculoGanancias> arrayCalculoGanancias = null;
	
	public static void listarCalculoGanancias() {
		conexion = new Conexion();
		connection = conexion.obtenerConexion();		
		arrayCalculoGanancias = new ArrayList<ModeloCalculoGanancias>();		
		try {
			sentenciaRecetas = connection.prepareStatement("Select IdPedido, FechaPedido, GananciaPedido from ganancias");
			ResultSet rs = sentenciaRecetas.executeQuery();			

			while (rs.next()) {
				ModeloCalculoGanancias modelo = new ModeloCalculoGanancias(rs.getInt("IdPedido"), rs.getString("FechaPedido"), rs.getFloat("GananciaPedido"));
				arrayCalculoGanancias.add(modelo);
			}
			
		} catch (SQLException e) {
			System.out.println("Error en la consulta a Base de Datos");
			System.out.println(e.getMessage());
		}			
	}

	public static ArrayList<ModeloCalculoGanancias> getArrayCalculoGanancias() {
		return arrayCalculoGanancias;
	}
	
}
