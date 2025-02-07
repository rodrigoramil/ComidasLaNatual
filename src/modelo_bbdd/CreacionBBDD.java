package modelo_bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class CreacionBBDD {	

	private Statement stmt=null;
	private String usuario = "root";
	private String pass = "";
	private static Connection connection = null;
	private static Conexion conexion = null;
	private static PreparedStatement sentencia = null;
	
	
	public void creacionBBDD() {
	
		Connection con = null;
		String sURL = "jdbc:mysql://localhost:3306/";
		
		try {
		  con = DriverManager.getConnection(sURL, usuario, pass);
		  stmt = con.createStatement();
		  crearBBDD();
		  crearTablaUsuarios();	
		  crearTablaCliente();		  
		  crearTablaPedidoCliente();		  
		  crearTablaGasto();		  
		  crearTablaUnidadMedidaProducto();		  
		  crearTablaTipoProducto();		  
		  crearTablaDisponibilidadReceta();		  
		  crearTablaRecetas();		  
		  crearTablaGanancias();		  
		  crearTablaPedidos();		  
		  crearTablaAlmacen();		  
		  crearTablaTrabajoUsuariosGastos();		  
		  crearTablaTrabajoUsuariosGanancias();		  
		  crearTablaCompraProductos();		  
		  crearTablaIngredientes();
		  crearDatosBase();
		  
		 

		  System.out.println("Se ha generado la base de datos");
		  
		} catch (SQLException e) {
			//JOptionPane.showMessageDialog(Vista_Login.getPanel_login(), "Error en la conexi�n con la Base de Datos");
			System.out.println("Error en la conexi�n:" + e.toString() );
		} finally {
		  try {
		    // Cerramos posibles conexiones abiertas
		    if (con!=null) con.close();
		  } catch (Exception e) {
			 // JOptionPane.showMessageDialog(Ventana.getPanel_login(), "Error cerrando conexiones con la Base de Datos");
			  System.out.println("Error cerrando conexiones: "+ e.toString());
		  } 
		}
	}
	
	public void crearBBDD() throws SQLException {
		stmt.execute("CREATE DATABASE IF NOT EXISTS bbdd_comidas_la_natural");
	
		stmt.execute("USE bbdd_comidas_la_natural;");
	}
	
	public void crearTablaUsuarios() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS Usuarios (IdUsuario INT NOT NULL AUTO_INCREMENT,NombreUsuario VARCHAR(45) NOT NULL, Contrasena VARCHAR(45) NOT NULL, Rol ENUM('Administrador', 'Cocina', 'Venta') NOT NULL, PRIMARY KEY(IdUsuario))ENGINE=INNODB;");
	}
	public void crearTablaCliente() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS Cliente(IdCliente INT NOT NULL AUTO_INCREMENT, NombreCliente VARCHAR(45) NOT NULL, Telefono VARCHAR(9) NULL, PRIMARY KEY(IdCliente))ENGINE=INNODB;");
	}
	public void crearTablaPedidoCliente() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS PedidoCliente(IdPedido INT NOT NULL AUTO_INCREMENT, IdCliente INT NOT NULL, constraint fkIdCliente foreign key(IdCliente) references Cliente(IdCliente), PRIMARY KEY(IdPedido))ENGINE=INNODB;");
	}
	public void crearTablaGasto() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS Gasto(IdCompraProductos INT NOT NULL AUTO_INCREMENT, CompraHecha boolean NOT NULL, FechaCompra datetime NOT NULL, GastoCompra FLOAT not null, PRIMARY KEY(IdCompraProductos))ENGINE=INNODB;");
	}
	public void crearTablaUnidadMedidaProducto() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS UnidadMedidaProducto(IdUnidadMedida INT NOT NULL AUTO_INCREMENT,UnidadMedida ENUM('Kg','Ud','L') NOT NULL , PRIMARY KEY(IdUnidadMedida))ENGINE=INNODB;");		
	}
	public void crearTablaTipoProducto() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS TipoProducto(IdTipo INT NOT NULL AUTO_INCREMENT, Tipo ENUM('Comida', 'Bebida') NOT NULL,PRIMARY KEY(IdTipo))ENGINE=INNODB;");		
	}
	public void crearTablaDisponibilidadReceta() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS DisponibilidadReceta(IdDisponibilidad INT NOT NULL AUTO_INCREMENT,Estado ENUM('Disponible', 'No Disponible','En Elaboraci�n') NOT NULL,PRIMARY KEY(IdDisponibilidad))ENGINE=INNODB;");			
	}
	public void crearTablaRecetas() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS Recetas(IdReceta INT NOT NULL AUTO_INCREMENT, IdTipo int NOT NULL, IdDisponibilidad int NOT NULL, NombreReceta VARCHAR(45) NOT NULL, PrecioVenta Float NULL, Elaboracion text NULL, PRIMARY KEY(IdReceta))ENGINE=INNODB;");
	}
	public void crearTablaGanancias() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS Ganancias(IdPedido INT NOT NULL AUTO_INCREMENT, FechaPedido DATETIME NOT NULL, GananciaPedido FLOAT NULL, constraint fkIdPedido foreign key(IdPedido) references PedidoCliente(IdPedido))ENGINE=INNODB;");
	}
	public void crearTablaPedidos() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS Pedidos(IdReceta INT NOT NULL ,IdPedido INT NOT NULL,CantidadRecetaVenta int not null,constraint fkPedidos foreign key(IdPedido) references PedidoCliente(IdPedido),constraint fkIdrecetas foreign key (IdReceta) references Recetas(IdReceta))ENGINE=INNODB;");
	}
	public void crearTablaAlmacen() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS Almacen(IdProducto INT NOT NULL AUTO_INCREMENT,NombreProducto VARCHAR(45) NOT NULL UNIQUE,Cantidad FLOAT NOT NULL,IdUnidadMedida Int NULL,CantidadMinima FLOAT NOT NULL,CantidadMaxima FLOAT NOT NULL,IdTipo INT NOT NULL,PRIMARY KEY(idProducto),constraint fkUnidadMedida foreign key(IdUnidadMedida) references UnidadMedidaProducto(IdUnidadMedida),constraint fkTipoProducto foreign key(IdTipo) references TipoProducto(IdTipo))ENGINE=INNODB;");
	}
	public void crearTablaTrabajoUsuariosGastos() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS TrabajoUsuariosGastos(IdUsuario INT NOT NULL,IdCompraProductos int NOT NULL,constraint fkIdUsuarioGastos foreign key(IdUsuario) references Usuarios(IdUsuario), constraint fkIdCompraProductos foreign key(IdCompraProductos) references Gasto(IdCompraProductos) )ENGINE=INNODB;");
	}
	public void crearTablaTrabajoUsuariosGanancias() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS TrabajoUsuariosGanancias(IdUsuario INT NOT NULL, IdPedido INT NOT NULL , constraint fkIdUsuarioGanancia foreign key(IdUsuario) references Usuarios(IdUsuario), constraint fkIdPedidoGanancias foreign key(IdPedido) references PedidoCliente(IdPedido) )ENGINE=INNODB;");
	}
	public void crearTablaCompraProductos() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS CompraProductos( IdCompraProductos INT NOT NULL , IdProducto INT NOT NULL , CantidadCompraProducto float NOT NULL, PrecioCompraProducto float NULL, PrecioUnitarioProducto float NULL, constraint fkIdCompraProductosGastos  foreign key(IdCompraProductos) references Gasto(IdCompraProductos),constraint fkIdProductoAlmacen foreign key(IdProducto) references Almacen(IdProducto))ENGINE=INNODB;");
	}
	public void crearTablaIngredientes() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS Ingredientes( IdReceta INT NOT NULL ,IdProducto INT NOT NULL , Cantidad float not null, constraint fkIdReceta foreign key(IdReceta) references Recetas(IdReceta), constraint fkIdIdProductoAlmacenes foreign key(IdProducto) references Almacen(IdProducto) )ENGINE=INNODB;");
	}
	
	
	public void crearDatosBase() throws SQLException {
		conexion = new Conexion();
		connection = conexion.obtenerConexion();
		sentencia = connection.prepareStatement("Select * from cliente");
		ResultSet rs = sentencia.executeQuery();
		
		if (!rs.next()) {
			stmt.execute("INSERT IGNORE INTO tipoproducto (Tipo) values ('Bebida');");
			stmt.execute("INSERT IGNORE INTO tipoproducto (Tipo) values ('Comida');");
			
			stmt.execute("INSERT IGNORE INTO DisponibilidadReceta (Estado) values ('Disponible');");
			stmt.execute("INSERT IGNORE INTO DisponibilidadReceta (Estado) values ('No Disponible');");
			stmt.execute("INSERT IGNORE INTO DisponibilidadReceta (Estado) values ('En Elaboracion');");
			
			stmt.execute("INSERT IGNORE INTO Cliente (NombreCliente) values ('Mesa 1');");
			stmt.execute("INSERT IGNORE INTO Cliente (NombreCliente) values ('Mesa 2');");
			stmt.execute("INSERT IGNORE INTO Cliente (NombreCliente) values ('Mesa 3');");
			stmt.execute("INSERT IGNORE INTO Cliente (NombreCliente) values ('Mesa 4');");
			stmt.execute("INSERT IGNORE INTO Cliente (NombreCliente) values ('Mesa 5');");
			stmt.execute("INSERT IGNORE INTO Cliente (NombreCliente) values ('Mesa 6');");
			stmt.execute("INSERT IGNORE INTO Cliente (NombreCliente) values ('Mesa 7');");
			stmt.execute("INSERT IGNORE INTO Cliente (NombreCliente) values ('Mesa 8');");
			
			stmt.execute("INSERT IGNORE INTO UnidadMedidaProducto(UnidadMedida) values('Ud')");
			stmt.execute("INSERT IGNORE INTO UnidadMedidaProducto(UnidadMedida) values('Kg')");
			stmt.execute("INSERT IGNORE INTO UnidadMedidaProducto(UnidadMedida) values('L')");
			
			// Usuario Admin para la primera vez que se instala la apliaci�n			
			stmt.execute("INSERT IGNORE INTO Usuarios(NombreUsuario, Contrasena, Rol) values('Admin','','Administrador')");
			/*
			// Ingredientes y receta e prueba
			stmt.execute("INSERT IGNORE INTO  Almacen (NombreProducto, Cantidad, IdUnidadMedida, CantidadMinima, CantidadMaxima, IdTipo) VALUES ('Huevos', 24, 1, 6, 32, 1)");
			stmt.execute("INSERT IGNORE INTO  Almacen (NombreProducto, Cantidad, IdUnidadMedida, CantidadMinima, CantidadMaxima, IdTipo) VALUES ('Cebollas', 8, 1, 5, 15, 1)");
			stmt.execute("INSERT IGNORE INTO  Almacen (NombreProducto, Cantidad, IdUnidadMedida, CantidadMinima, CantidadMaxima, IdTipo) VALUES ('Patatas', 30, 1, 20, 50, 1)");
			stmt.execute("INSERT IGNORE INTO  Almacen (NombreProducto, Cantidad, IdUnidadMedida, CantidadMinima, CantidadMaxima, IdTipo) VALUES ('Aceite de Girasol', 6, 3, 5, 10, 1)");
			stmt.execute("INSERT IGNORE INTO  Almacen (NombreProducto, Cantidad, IdUnidadMedida, CantidadMinima, CantidadMaxima, IdTipo) VALUES ('Sal', 1, 2, 0.500, 2, 1)");
			
			stmt.execute("INSERT IGNORE INTO  recetas(IdTipo, IdDisponibilidad, NombreReceta, PrecioVenta, Elaboracion) values(2, 1, 'Tortilla de patatas', 4, 'Pelamos y lavamos las patatas, las cortamos en rodajas finas al igual que la cebolla. Ponemos ambas cosas en una sart�n y cubrimos de aceite de oliva virgen extra, dejamos que se hagan a fuego medio-suave hasta que comiencen a dorarse. Sabr�is que las patatas est�n hechas cuando comiencen a romperse, con la paleta. Para que la tortilla est� jugosa es importante que las patatas se hagan bien y se confiten, porque no hay nada peor que una tortilla con las patatas medio crudas. Por lo tanto, paciencia con este paso. Las sacamos de la sart�n y escurrimos bien. Ponemos en un cuenco grande, aparte batimos los huevos y los a�adimos a las patatas y a la cebolla, a�adimos un poco de sal y mezclamos. Dejamos un par de minutos que se mezclen bien. Aqu� hay quien prefiere dejar las patatas enteras y quien prefiere machacarlas un poco con la paleta para que se mezclen bien con el huevo Ponemos en la sart�n un par de cucharadas de aceite de oliva virgen extra y vertemos todo. Al principio rompemos un poco, como si fu�ramos a hacer un revuelto, luego vamos d�ndole forma  por los bordes. Cuando veamos que ya est� cuajada por abajo ponemos un plato o una tapa encima de la sart�n y le damos la vuelta r�pidamente. Ponemos de nuevo la sart�n en el fuego y deslizamos la tortilla desde el plato a la sart�n. Dejamos unos minutos m�s (2 o 3 si te gusta m�s cuajada, menos si te gusta jugosa) para que se termine de hacer y ya tenemos lista nuestra tortilla de patatas.')");
			
			stmt.execute("INSERT IGNORE INTO  ingredientes (IdReceta,IdProducto, Cantidad) values (1, 1, 6)");
			stmt.execute("INSERT IGNORE INTO  ingredientes (IdReceta,IdProducto, Cantidad) values (1, 2, 1)");
			stmt.execute("INSERT IGNORE INTO  ingredientes (IdReceta,IdProducto, Cantidad) values (1, 3, 5)");
			stmt.execute("INSERT IGNORE INTO  ingredientes (IdReceta,IdProducto, Cantidad) values (1, 4, 0.500)");
			stmt.execute("INSERT IGNORE INTO  ingredientes (IdReceta,IdProducto, Cantidad) values (1, 5, 0.005)");
			*/
		}
	}		
}

