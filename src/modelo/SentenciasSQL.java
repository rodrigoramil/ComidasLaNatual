package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vista.GestionPedidos;

public class SentenciasSQL {

	private static Connection connection = null;
	private static GestionPedidos gestionPedidos = null;
	private static Conexion conexion = null;
	private static PreparedStatement sentencia = null;
	private static ResultSet rs = null;
	

	
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

			rs = sentencia.executeQuery();
			
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
	
	
	public static void listarClientes() {
        gestionPedidos = new GestionPedidos();
        conexion = new Conexion();
        connection = conexion.obtenerConexion();
        ArrayList<String> arrayCliente = new ArrayList<>();
        
        try {
            sentencia = connection.prepareStatement("SELECT NombreCliente FROM cliente ");
            rs = sentencia.executeQuery();

            while (rs.next()) {
                arrayCliente.add(rs.getString("NombreCliente"));



            }
            gestionPedidos.DatosClientes(arrayCliente);
        } catch (SQLException e) {
            System.out.println("Error en gestionPedidosClientes SentenciasSQL");
            System.out.println(e.getMessage());

        }





    }
    public static void editarCliente() {
        gestionPedidos = new GestionPedidos();
        Conexion conexion = new Conexion();
        connection = conexion.obtenerConexion();
        gestionPedidos.clienteSeleccionado();
        ArrayList<String> arrayClienteModificar = new ArrayList<>();




        try {

            PreparedStatement sentencia = connection.prepareStatement("Update NombreCliente from cliente where NombreCliente = ?");
            rs = sentencia.executeQuery();

            while (rs.next()) {
                arrayClienteModificar.add(rs.getString("NombreCliente"));
                System.out.println(rs.getString("NombreCliente"));


            }
            gestionPedidos.DatosClientes(arrayClienteModificar);
        } catch (SQLException e) {
        	System.out.println("Error en editarCliente SentenciasSQL");
            //System.out.println(e.getMessage());

        }

    } 
    
    
}
