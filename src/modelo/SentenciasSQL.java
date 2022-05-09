package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.result.StringValueFactory;

import vista.GestionPedidos;


public class SentenciasSQL {

	private static Connection connection = null;
	private static Conexion conexion = null;
	private static PreparedStatement sentencia = null;
	private static GestionPedidos gestionPedidos = null;
	private static ArrayList<String> arrayClientes = null;
	
//****************************PRUEBAS****************************************************    
	private static ArrayList<Cliente> array_clientes = null;
	private static Cliente cliente = null;
//****************************PRUEBAS****************************************************    	
	
	
	public static String iniciar_Sesion(String entrada_usuario, String entrada_contrasena) {
		String estado = "";
		conexion = new Conexion();
		connection = conexion.obtenerConexion();

		try {
			
			String passcifrado =Criptografia.cifrado(entrada_contrasena);
			//System.out.println("La contraseña "+entrada_contrasena+" debe de guardarse cifrada en la BBDD -> "+passcifrado);
			
			sentencia = connection.prepareStatement("SELECT NombreUsuario, Contrasena, Rol FROM Usuarios WHERE NombreUsuario= ? AND Contrasena = ?");
			sentencia.setNString(1, entrada_usuario);
			sentencia.setNString(2, entrada_contrasena); // <-- sustituir por la variable passcifrado
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
	
	

	
	public static void listarClientes() {
		
		array_clientes = new ArrayList<Cliente>();

        gestionPedidos = new GestionPedidos();
        conexion = new Conexion();
        connection = conexion.obtenerConexion();
        arrayClientes = new ArrayList<>();
        
        try {
        	sentencia = connection.prepareStatement("SELECT * FROM cliente ");
        	ResultSet rs = sentencia.executeQuery();
        	
            while (rs.next()) {
            			
				cliente = new Cliente ();
				cliente.id=rs.getString("IdCliente");
				cliente.nombre=rs.getString("NombreCliente");
				cliente.telefono=rs.getString("Telefono");
				
				getArray_clientes().add((Cliente) cliente);				
  
            }

            
            gestionPedidos.datosClientes(getArray_clientes());
            
        } catch (SQLException e) {
            System.out.println("Error en gestionPedidosClientes SentenciasSQL");
            System.out.println(e.getMessage());
        }
    }
	
    public static void editarCliente() {
    	
        gestionPedidos = new GestionPedidos();
        conexion = new Conexion();
        connection = conexion.obtenerConexion();
        gestionPedidos.clienteSeleccionado();
        
        try {
            sentencia = connection.prepareStatement(
                    "update NombreCliente, Telefono from Cliente values(?,?) where IdCliente = ?");
//            sentencia.setNString(1, entrada_usuario);
//            sentencia.setNString(2, entrada_usuario);
//            sentencia.setNString(3, entrada_usuario);
            ResultSet rs = sentencia.executeQuery();
            
            while (rs.next()) {

            
            	arrayClientes.add(rs.getString("IdCliente"));
                //System.out.println(rs.getString("NombreCliente"));
                
            
            }
            gestionPedidos.datosClientes(getArray_clientes());
            
        } catch (SQLException e) {
        	System.out.println("Error en editarCliente SentenciasSQL");
            System.out.println(e.getMessage());
        }
    }




	public static ArrayList<Cliente> getArray_clientes() {
		return array_clientes;
	} 
    
}

