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
	private static PreparedStatement sentenciaGanancias = null;
	private static ArrayList<ModeloCalculoGanancias> arrayCalculoGanancias = null;

	public static ArrayList<ModeloCalculoGanancias>  listarCalculoGanancias() {
		conexion = new Conexion();
		connection = conexion.obtenerConexion();		
		arrayCalculoGanancias = new ArrayList<ModeloCalculoGanancias>();		
		try {
			sentenciaGanancias = connection.prepareStatement("Select G.IdPedido, G.FechaPedido, G.GananciaPedido, U.NombreUsuario from Ganancias G, Trabajousuariosganancias T, Usuarios U where T.IdPedido = G.IdPedido AND U.IdUsuario=T.IdUsuario;");
			ResultSet rs = sentenciaGanancias.executeQuery();			

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
	
	private static java.sql.Timestamp getCurrentTimeStamp() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());
	}
	
	public static void addGanancia(float ganancia) throws SQLException {
		conexion = new Conexion();
		connection = conexion.obtenerConexion();
		int idpedido = BbddPedido.getIdPedido();
		
		String sqlGanancias = "INSERT INTO Ganancias (IdPedido, FechaPedido , GananciaPedido) VALUES ( ?, ?, ?)";
		sentenciaGanancias = connection.prepareStatement(sqlGanancias);		
		sentenciaGanancias.setInt(1, idpedido);
		sentenciaGanancias.setTimestamp(2, getCurrentTimeStamp());
		sentenciaGanancias.setFloat(3, ganancia);
		sentenciaGanancias.executeUpdate();
		
		int idUsuario = 0;
		BbddGestionUsuario.listarUsuarios();
		String nombreUsuario = BbddLogin.getUsuario();		
		for (int i = 0; i < BbddGestionUsuario.getArrayUsuarios().size(); i++) {
			if (nombreUsuario.equals(BbddGestionUsuario.getArrayUsuarios().get(i).getNombreUsuario())) {
				idUsuario = BbddGestionUsuario.getArrayUsuarios().get(i).getIdUsuario();
			}
		}
		
		
		String sqlTrabajoUsuarioGanancias = "INSERT INTO trabajousuariosganancias (IdUsuario, IdPedido) VALUES ( ?, ?)";
		sentenciaGanancias = connection.prepareStatement(sqlTrabajoUsuarioGanancias);	
		sentenciaGanancias.setInt(1, idUsuario);
		sentenciaGanancias.setInt(2, idpedido);
		sentenciaGanancias.executeUpdate();
		
	}
	
	
	
	public static ArrayList<ModeloCalculoGanancias> getArrayCalculoGanancias() {
		return arrayCalculoGanancias;
	}

	
}
