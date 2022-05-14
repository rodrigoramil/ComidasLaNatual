package modelo_bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import vista.VentanaPrincipal;

public class Conexion {
	Connection con = null;

	public Connection obtenerConexion() {
		
			String cadenaConexion = "jdbc:mysql://localhost:3306/bbdd_comidas_la_natural";
			String user = "root";
			String pass = ""; 
			
			try {
				con = DriverManager.getConnection(cadenaConexion, user, pass);
				System.out.println("Se ha establecido la conexión con la Base de datos");
				return con;
				
			} catch (SQLException | NullPointerException e ) {
				JOptionPane.showMessageDialog(VentanaPrincipal.getPanelLogin(), "No se ha podido establecer la conexión con la Base de Datos");
				System.out.println("No se ha podido establecer la conexión con la Base de Datos");
//				System.out.println(e.getMessage());
				return null;
			}
			
		
	}
	public Connection cerrarConexion() {
			
			try {
				con.close();
				System.out.println("Se ha cerrado la base de datos");
				return con;
			} catch (SQLException e) {
				System.out.println("No se ha podido cerrar la conexión con la BD");
				System.out.println(e.getMessage());
				return null;
			}
			
		}
	public static PreparedStatement prepareStatement(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}

