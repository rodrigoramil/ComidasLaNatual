package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import vista.GestionPedidos;
import vista.Pedido;


public class SentenciasSQL {

	private static Connection connection = null;
	private static Conexion conexion = null;
	private static PreparedStatement sentencia = null;
	private static GestionPedidos gestionPedidos = null;
	private static ArrayList<String> arrayClientes = null;
	
//****************************PRUEBAS****************************************************    
	private static ArrayList<Cliente> array_clientes = null;
	private static Cliente cliente = null;
	private static Pedido pedidos;
//	private static FilasTabla filasTabla;
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
	
	

	
	public static ArrayList<Cliente> listarClientes() {
		
//		pedidos = new Pedido();
		
		
//      gestionPedidos = new GestionPedidos();
		
		array_clientes = new ArrayList<Cliente>();
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
				array_clientes.add((Cliente) cliente);				
  
            }
 //           pedidos.datosClientes(array_clientes);
 //           gestionPedidos.datosClientes(array_clientes);
            
        } catch (SQLException e) {
            System.out.println("Error en gestionPedidosClientes SentenciasSQL");
 //           System.out.println(e.getMessage());
        }
        return array_clientes;
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
            	arrayClientes.add(rs.getString("IdCliente"));
                //System.out.println(rs.getString("NombreCliente"));
            
            //******************* MODIFICAR *******************************
				cliente = new Cliente ();
				cliente.id=rs.getString("IdCliente");
				cliente.nombre=rs.getString("NombreCliente");
				cliente.telefono=rs.getString("Telefono");			
				array_clientes.add((Cliente) cliente);	
             //****************** ^^^^^^^^^^ ********************************   
            

            }
            gestionPedidos.datosClientes(array_clientes);
            
        } catch (SQLException e) {
        	System.out.println("Error en editarCliente SentenciasSQL");
            System.out.println(e.getMessage());
        }
    }

    
	public static ArrayList<Cliente> getArray_clientes() {
		return array_clientes;
	} 
    
	
	
	  
//*************************************************************************	
//************************ TABLA ******************************************	  
//*************************************************************************	
/*	
	
	static ArrayList<String> arrayStrings;
	static ArrayList<ModeloPedido> lista;
	static Object[][] objetoTabla;
	
	// implementada en forma de prueba en la clase ListaFacturaciones
	
	public static Object[][] listarTabla() {
		
		arrayStrings = new ArrayList<String>();
        gestionPedidos = new GestionPedidos();
        conexion = new Conexion();
        connection = conexion.obtenerConexion();

        lista=new ArrayList<>();
        try {
        	sentencia = connection.prepareStatement("SELECT * FROM cliente ");
        	ResultSet rs = sentencia.executeQuery();
        	
            while (rs.next()) {

				arrayStrings.add(rs.getString("IdCliente"));
				arrayStrings.add(rs.getString("NombreCliente"));
				arrayStrings.add(rs.getString("Telefono"));

				lista.add(new ModeloPedido(
						rs.getString("IdCliente"), 
						rs.getString("NombreCliente"),
						rs.getString("Telefono"))); 
            }

            objetoTabla = obtenerMatrizDatos(arrayStrings);

        } catch (SQLException e) {
            System.out.println("Error en gestionPedidosClientes SentenciasSQL");
            System.out.println(e.getMessage());
        }
		return objetoTabla;
    }

	private static Object[][] obtenerMatrizDatos(ArrayList<String> titulosList) {
		
		String informacion[][] = new String[lista.size()][titulosList.size()];
		
		final int COMIDABEBIDA=0;
		final int CANTIDAD=1;
		final int PRECIO=3;	
		
		for (int x = 0; x < informacion.length; x++) {			
			informacion[x][COMIDABEBIDA] = lista.get(x).getComidaBebida()+ "";
			informacion[x][CANTIDAD] = lista.get(x).getCantidad()+ "";
			informacion[x][PRECIO] = lista.get(x).getPrecio()+ "";
		}
		return informacion;
	}
	
	static JTable table;
	public static JTable crearTablaPedido (JTable tabla) {		
		
		try {
			table.setModel(new DefaultTableModel(
				SentenciasSQL.listarTabla(),new String[] 
				{"Bebida/Comida", "Cantidad", "Precio"}));
			table.setBounds(47, 48, 343, 134);
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return table;		
	}
*/	
	
	
	
	
}

