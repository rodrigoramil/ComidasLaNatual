package modelo_bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import modelo.ModeloAlmacen;
import modelo.ModeloCalculoGanancias;


public class BbddCalculoGanancias {
	private static Connection connection = null;
	private static Conexion conexion = null;
	private static PreparedStatement sentenciaRecetas = null;
	private static ArrayList<ModeloCalculoGanancias> arrayCalculoGanancias = null;
	private static float sumaGanancias;
	
	public static ArrayList<ModeloCalculoGanancias>  listarCalculoGanancias() {
		conexion = new Conexion();
		connection = conexion.obtenerConexion();		
		arrayCalculoGanancias = new ArrayList<ModeloCalculoGanancias>();		
		try {
			sentenciaRecetas = connection.prepareStatement("Select G.IdPedido, G.FechaPedido, G.GananciaPedido, U.NombreUsuario from Ganancias G, Trabajousuariosganancias T, Usuarios U where T.IdPedido = G.IdPedido AND U.IdUsuario=T.IdUsuario;");
			ResultSet rs = sentenciaRecetas.executeQuery();			

			while (rs.next()) {
				ModeloCalculoGanancias modelo = new ModeloCalculoGanancias(rs.getInt("IdPedido"), rs.getString("FechaPedido"), rs.getFloat("GananciaPedido"), rs.getString("NombreUsuario"));
				arrayCalculoGanancias.add(modelo);
			}
			
		} catch (SQLException e) {
			System.out.println("Error en la consulta a Base de Datos");
			System.out.println(e.getMessage());
		}
		return arrayCalculoGanancias;			
	}
	
	
	// Metodo el método falla al guardar el resultado en la variable
	public static Float sumaGanancias () {
		conexion = new Conexion();
		connection = conexion.obtenerConexion();		
		arrayCalculoGanancias = new ArrayList<ModeloCalculoGanancias>();		
		try {
			sentenciaRecetas = connection.prepareStatement("select SUM(GananciaPedido) from Ganancias");
			ResultSet rs = sentenciaRecetas.executeQuery();			
			while (rs.next()) {
				sumaGanancias = rs.getFloat("GananciaPedido");
				System.out.println(sumaGanancias);
			}
			
		} catch (SQLException e) {
			System.out.println("Error en la consulta a Base de Datos");
			System.out.println(e.getMessage());
		}
		return sumaGanancias;			
	}
	
	
	
	public static void addGanancia(float ganancia) throws SQLException {

		String SQL = "INSERT INTO Ganancias (IdPedido, FechaPedido , GananciaPedido ) VALUES ( ?, ?, ?)";
		sentenciaRecetas = connection.prepareStatement(SQL);		
		sentenciaRecetas.setInt(1, BbddPedido.getIdPedido());
		sentenciaRecetas.setQueryTimeout(2);
		sentenciaRecetas.setFloat(3, ganancia);
		sentenciaRecetas.executeUpdate();
	}
	
	
	
	public static ArrayList<ModeloCalculoGanancias> getArrayCalculoGanancias() {
		return arrayCalculoGanancias;
	}

	public static Float getSumaGanancias() {
		return sumaGanancias;
	}

	
}
