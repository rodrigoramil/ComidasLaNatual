package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vista.GestionPedidos;

public class SentenciasSQL {

	static Connection connection = null;

	public SentenciasSQL() {

	}

	public static String iniciar_Sesion(String entrada_usuario, String entrada_contrasena) {
		String estado = "";
		Conexion conexion = new Conexion();
		connection = conexion.obtenerConexion();

		try {
			
			String passcifrado =Criptografia.cifrado(entrada_contrasena);
			System.out.println("La contraseña "+entrada_contrasena+" debe de guardarse cifrada en la BBDD -> "+passcifrado);
			
			PreparedStatement sentencia = connection.prepareStatement(
					"SELECT NombreUsuario, Contrasena, Rol FROM Usuarios WHERE NombreUsuario= ? AND Contrasena = ?");
			sentencia.setNString(1, entrada_usuario);
			sentencia.setNString(2, entrada_contrasena); // <-- sustituir por la variable passcifrado

			ResultSet rs = sentencia.executeQuery();
			
			while (rs.next()) {

				if (rs.getString("Rol").equals("Administrador")) {
					estado = "Administrador";

				} else if (rs.getString("Rol").equals("Cocina")) {
					estado = "Cocina";

				} else if (rs.getString("Rol").equals("Venta")) {
					estado = "Venta";

				}

			}
		} catch (SQLException e) {
			System.out.println("Error al realizar el listado de productos");
			System.out.println(e.getMessage());

		}

//		boolean loginCorrecto = true;
//		
//		System.out.println("Usuario: "+entrada_usuario+" - Contraseña: "+ entrada_contrasena);
//		
//				
//		String passcifrado =Criptografia.cifrado(entrada_contrasena);
//		
//		System.out.println("contraseña cifrada: "+passcifrado);
//		 
//		 
//		return loginCorrecto;
		return estado;

	}
	
	
	
	
//**********************************************************************************************	
	
	public static void gestionPedidosClientes() {
        GestionPedidos gestionPedidos = new GestionPedidos();
        Conexion conexion = new Conexion();
        connection = conexion.obtenerConexion();

        ArrayList<String> prueba = new ArrayList<>();

        try {

            PreparedStatement sentencia = connection.prepareStatement(
                    "SELECT NombreCliente FROM cliente ");

            ResultSet rs = sentencia.executeQuery();

            while (rs.next()) {
                prueba.add(rs.getString("NombreCliente"));

            }
            gestionPedidos.datosClientes(prueba);
        } catch (SQLException e) {
            System.out.println("Error al realizar el listado de productos");
            System.out.println(e.getMessage());

        }





    }
	
	
	
    public static void editarCliente() {
        GestionPedidos gestionPedidos = new GestionPedidos();
        Conexion conexion = new Conexion();
        connection = conexion.obtenerConexion();

        gestionPedidos.obtenerCliente();
        ArrayList<String> prueba = new ArrayList<>();

        try {

            PreparedStatement sentencia = connection.prepareStatement(
                    "Update NombreCliente from cliente where NombreCliente = ?");

            ResultSet rs = sentencia.executeQuery();

            while (rs.next()) {
                prueba.add(rs.getString("NombreCliente"));
                System.out.println(rs.getString("NombreCliente"));


            }
            gestionPedidos.datosClientes(prueba);
            
        } catch (SQLException e) {
            System.out.println("Error al realizar el listado de productos");
            System.out.println(e.getMessage());

        }

    } 
    
 //**********************************************************************************************
  
    
    
}
