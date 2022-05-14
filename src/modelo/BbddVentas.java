package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BbddVentas {

	private static Connection connection = null;
	private static Conexion conexion = null;
	private static PreparedStatement sentencia = null;
	private static ArrayList<ModeloCliente> arrayClientes = null;
	private static ArrayList<ModeloPRUEBA> arrayRecetas=null; // <---- BORRAR

	public static void listarClientes() {
		conexion = new Conexion();
		connection = conexion.obtenerConexion();
		arrayClientes = new ArrayList<ModeloCliente>();
		arrayRecetas = new ArrayList<ModeloPRUEBA>();  // <---- BORRAR
		try {
			sentencia = connection.prepareStatement("SELECT * FROM cliente ");
			ResultSet rs = sentencia.executeQuery();

			while (rs.next()) {
				// <---- BORRAR ----->
				ModeloCliente cliente = new ModeloCliente(
						rs.getInt("IdCliente"), 
						rs.getString("NombreCliente"),
						rs.getString("Telefono"));
				arrayClientes.add(cliente);
				// <---- BORRAR ----->
				
				ModeloPRUEBA receta = new ModeloPRUEBA(
						rs.getString("NombreCliente"), 
						rs.getString("Telefono"));
				arrayRecetas.add(receta);
				
				
			}
//			cumpruebaMesas();
		} catch (SQLException e) {
			System.out.println("Error en gestionPedidosClientes SentenciasSQL");
			System.out.println(e.getMessage());
		}
	}

    
	public static void editarCliente(int id, String nombre, String telefono) {
		System.out.println("esta entrando por en editar");
        conexion = new Conexion();
        connection = conexion.obtenerConexion();
 
        try {
            sentencia = connection.prepareStatement("update Cliente set NombreCliente = ?, Telefono = ?  where IdCliente = ?");
            sentencia.setString(1, nombre);
            sentencia.setString(2, telefono);
            sentencia.setInt(3, id+8);
            sentencia.executeUpdate();
            
            listarClientes();            

        } catch (SQLException e) {
        	System.out.println("Error en editarCliente SentenciasSQL");
            System.out.println(e.getMessage());
        }
    }

	

	public static void insertarCliente(String nombre, String telefono) {
		System.out.println("esta entrando por en insert");
		conexion = new Conexion();
        connection = conexion.obtenerConexion();
 
        try {
            sentencia = connection.prepareStatement("INSERT INTO Cliente (NombreCliente, Telefono) VALUES (?, ?)"); 
            sentencia.setString(1, nombre);
            sentencia.setString(2, telefono);
            
            sentencia.executeQuery();
            listarClientes();            

        } catch (SQLException e) {
        	System.out.println("Error en insertarCliente SentenciasSQL");
            System.out.println(e.getMessage());
            
        }
	}

	
	
	public void cumpruebaMesas() throws SQLException  {
		conexion = new Conexion();
        connection = conexion.obtenerConexion();
        
        
        for (int i = 0; i < 8; i++) {
        	String mesa = "Mesa "+1;
			if (!arrayClientes.get(i).nombre.equals(mesa)) {
				 try {
					sentencia = connection.prepareStatement("INSERT INTO PERSONAS (NombreCliente, Telefono) VALUES (?, ?)");             
					sentencia.setString(1, mesa);            
					sentencia.executeQuery();
				
				
				} catch (SQLException e) {
					System.out.println("Error en gestionPedidosClientes SentenciasSQL");
					System.out.println(e.getMessage());
				}
			}
		}

   }
		
		
		
		
		/*
		stmt.execute("INSERT INTO Cliente (NombreCliente) values ('Mesa 1');");
		stmt.execute("INSERT INTO Cliente (NombreCliente) values ('Mesa 2');");
		stmt.execute("INSERT INTO Cliente (NombreCliente) values ('Mesa 3');");
		stmt.execute("INSERT INTO Cliente (NombreCliente) values ('Mesa 4');");
		stmt.execute("INSERT INTO Cliente (NombreCliente) values ('Mesa 5');");
		stmt.execute("INSERT INTO Cliente (NombreCliente) values ('Mesa 6');");
		stmt.execute("INSERT INTO Cliente (NombreCliente) values ('Mesa 7');");
		stmt.execute("INSERT INTO Cliente (NombreCliente) values ('Mesa 8');");
		
	}
*/
	
	

	public static ArrayList<ModeloPRUEBA> getArrayRecetas() {
		return arrayRecetas;
	}
	
  	public static ArrayList<ModeloCliente> getArrayClientes() {
		return arrayClientes;
	}

	

}
