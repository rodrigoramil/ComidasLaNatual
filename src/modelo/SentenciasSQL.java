package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

import vista.GestionPedidos;
import vista.Pedido;


public class SentenciasSQL {

	private static Connection connection = null;
	private static Conexion conexion = null;
	private static PreparedStatement sentencia = null;
	private static GestionPedidos gestionPedidos = null;
	private static ArrayList<ModeloCliente> arrayClientes = null;
	private static ModeloCliente cliente = null;

	public static String iniciar_Sesion(String entrada_usuario, String entrada_contrasena) {
		String estado = "";
		conexion = new Conexion();
		connection = conexion.obtenerConexion();

		try {			
			String passcifrado =Base64.getEncoder().encodeToString(entrada_contrasena.getBytes());
			sentencia = connection.prepareStatement("SELECT NombreUsuario, Contrasena, Rol FROM Usuarios WHERE NombreUsuario= ? AND Contrasena = ?");
			sentencia.setNString(1, entrada_usuario);
			sentencia.setNString(2, passcifrado); //
//			sentencia.setNString(2, entrada_contrasena); // <-- BORRAR
			ResultSet rs = sentencia.executeQuery();			
			while (rs.next()) {
				if (rs.getString("Rol").equals("Administrador")) {estado = "Administrador";} 
				else if (rs.getString("Rol").equals("Cocina")) {estado = "Cocina";} 
				else if (rs.getString("Rol").equals("Venta")) {	estado = "Venta";}
			}
		} catch (SQLException e) {
			System.out.println("Error al iniciar_Sesion SentenciasSQL");
			System.out.println(e.getMessage());
		}
		return estado;
	}

	public static void leerClientesBBDD() {
		arrayClientes = new ArrayList<ModeloCliente>();

        conexion = new Conexion();

        connection = conexion.obtenerConexion();
        arrayClientes = new ArrayList<ModeloCliente>();        
        try {
        	sentencia = connection.prepareStatement("SELECT * FROM cliente ");
        	ResultSet rs = sentencia.executeQuery();        	
            while (rs.next()) {	
				cliente = new ModeloCliente ();

				cliente.id=rs.getString("IdCliente");
				cliente.nombre=rs.getString("NombreCliente");
				cliente.telefono=rs.getString("Telefono");				
				arrayClientes.add((ModeloCliente) cliente);
            }

        } catch (SQLException e) {
            System.out.println("Error en gestionPedidosClientes SentenciasSQL");
        }        
    }
	

    public static void editarCliente() {
    	
        gestionPedidos = new GestionPedidos();
        conexion = new Conexion();
        connection = conexion.obtenerConexion();        
        int seleccionado = gestionPedidos.clienteSeleccionado();        

        try {
            sentencia = connection.prepareStatement(
                    "update NombreCliente, Telefono from Cliente values(?,?) where IdCliente = ?");
//            sentencia.setNString(1, entrada_usuario);
//            sentencia.setNString(2, entrada_usuario);
//            sentencia.setNString(3, entrada_usuario);
            ResultSet rs = sentencia.executeQuery();
            
            while (rs.next()) {  
				cliente = new ModeloCliente ();
				cliente.id=rs.getString("IdCliente");
				cliente.nombre=rs.getString("NombreCliente");
				cliente.telefono=rs.getString("Telefono");			
				arrayClientes.add((ModeloCliente) cliente);       

            }

        } catch (SQLException e) {
        	System.out.println("Error en editarCliente SentenciasSQL");
            System.out.println(e.getMessage());
        }
    }


	public static ArrayList<ModeloCliente> getArrayClientes() {
		return arrayClientes;
	}


}

