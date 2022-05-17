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
		  crearTablaGanancias();
		  crearTablaCliente();
		  crearTablaGasto();
		  crearTablaUnidadMedidaProducto();
		  crearTablaTipoProducto();
		  crearTablaDisponibilidadReceta();
		  crearTablaPedidos();
		  crearTablaRecetas();
		  crearTablaAlmacen();
		  crearTablaTrabajoUsuariosGastos();
		  crearTablaTrabajoUsuariosGanancias();
		  crearTablaPedidoCliente();
		  crearTablaCompraProductos();
		  crearTablaIngredientes();

		  crearDatosBase();

		  System.out.println("Se ha generado la base de datos");
		  
		} catch (SQLException e) {
			//JOptionPane.showMessageDialog(Vista_Login.getPanel_login(), "Error en la conexión con la Base de Datos");
			System.out.println("Error en la conexión:" + e.toString() );
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
	
	public void crearTablaUnidadMedidaProducto() throws SQLException {
	
		stmt.execute("CREATE TABLE IF NOT EXISTS UnidadMedidaProducto(IdUnidadMedida INT NOT NULL AUTO_INCREMENT,UnidadMedida ENUM('Kg','Ud','L') NOT NULL , PRIMARY KEY(IdUnidadMedida))ENGINE=INNODB;");		
	}
	
	public void crearTablaTipoProducto() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS TipoProducto(IdTipo INT NOT NULL AUTO_INCREMENT, Tipo ENUM('Comida', 'Bebida') NOT NULL,PRIMARY KEY(IdTipo))ENGINE=INNODB;");		
	}
	
	public void crearTablaDisponibilidadReceta() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS DisponibilidadReceta(IdDisponibilidad INT NOT NULL AUTO_INCREMENT,Estado ENUM('Disponible', 'No Disponible','En Elaboración') NOT NULL,PRIMARY KEY(IdDisponibilidad))ENGINE=INNODB;");			
	}
	
	public void crearTablaAlmacen() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS Almacen(IdProducto INT NOT NULL AUTO_INCREMENT,NombreProducto VARCHAR(45) NOT NULL UNIQUE,Cantidad FLOAT NOT NULL,IdUnidadMedida Int NULL,CantidadMinima FLOAT NOT NULL,CantidadMaxima FLOAT NOT NULL,IdTipo INT NOT NULL,PRIMARY KEY(idProducto),constraint fkUnidadMedida foreign key(IdUnidadMedida) references UnidadMedidaProducto(IdUnidadMedida),constraint fkTipoProducto foreign key(IdTipo) references TipoProducto(IdTipo))ENGINE=INNODB;");
	}
	
	public void crearTablaRecetas() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS Recetas(IdReceta INT NOT NULL AUTO_INCREMENT,IdTipo int NOT NULL,IdDisponibilidad int NOT NULL,NombreReceta VARCHAR(45) NOT NULL,PrecioVenta Float NOT NULL,Elaboracion text NOT NULL,PRIMARY KEY(IdReceta))ENGINE=INNODB;");
	}
	
	public void crearTablaUsuarios() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS Usuarios (NombreUsuario VARCHAR(45) NOT NULL, Contrasena VARCHAR(45) NOT NULL, Rol ENUM('Administrador', 'Cocina', 'Venta') NOT NULL, PRIMARY KEY(NombreUsuario))ENGINE=INNODB;");
	}
	
	public void crearTablaGanancias() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS Ganancias(IdPedido INT NOT NULL AUTO_INCREMENT, FechaPedido DATETIME NOT NULL, HoraPedido  DATETIME NOT NULL, GananciaPedido REAL NOT NULL, PRIMARY KEY(IdPedido))ENGINE=INNODB;");
	}
	
	public void crearTablaCliente() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS Cliente(IdCliente INT NOT NULL AUTO_INCREMENT, NombreCliente VARCHAR(45) NOT NULL, Telefono VARCHAR(9) NULL, PRIMARY KEY(IdCliente))ENGINE=INNODB;");
	}

	public void crearTablaGasto() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS Gasto(IdCompraProductos INT NOT NULL AUTO_INCREMENT, CompraHecha boolean NOT NULL, FechaCompra datetime NOT NULL, GastoCompra real not null, PRIMARY KEY(IdCompraProductos))ENGINE=INNODB;");
	}
	
	public void crearTablaTrabajoUsuariosGastos() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS TrabajoUsuariosGastos(NombreUsuario VARCHAR(45) NOT NULL,IdCompraProductos int NOT NULL,constraint fkNombreUsuarioGastos foreign key(NombreUsuario) references Usuarios(NombreUsuario), constraint fkIdCompraProductos foreign key(IdCompraProductos) references Gasto(IdCompraProductos) )ENGINE=INNODB;");
	}
	
	public void crearTablaTrabajoUsuariosGanancias() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS TrabajoUsuariosGanancias(NombreUsuario VARCHAR(45) NOT NULL, IdPedido INT NOT NULL , constraint fkNombreUsuarioGanancia foreign key(NombreUsuario) references Usuarios(NombreUsuario), constraint fkIdPedidoGanancias foreign key(IdPedido) references Ganancias(IdPedido) )ENGINE=INNODB;");
	}
	
	public void crearTablaPedidoCliente() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS PedidoCliente( IdPedido INT NOT NULL , IdCliente INT NOT NULL , constraint fkIdPedido foreign key(IdPedido) references Ganancias(IdPedido), constraint fkIdCliente foreign key(IdCliente) references Cliente(IdCliente) )ENGINE=INNODB;");
	}
	
	public void crearTablaPedidos() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS Pedidos(IdReceta INT NOT NULL ,IdPedido INT NOT NULL,CantidadRecetaVenta int not null,constraint fkPedidos foreign key(IdPedido) references UnidadMedidaProducto(IdUnidadMedida))ENGINE=INNODB;");
	}
	
	public void crearTablaCompraProductos() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS CompraProductos( IdCompraProductos INT NOT NULL , IdProducto INT NOT NULL , CantidadCompraProducto float not null, PrecioCompraProducto float, PrecioUnitarioProducto float, constraint fkIdCompraProductosGastos  foreign key(IdCompraProductos) references Gasto(IdCompraProductos),constraint fkIdProductoAlmacen foreign key(IdProducto) references Almacen(IdProducto))ENGINE=INNODB;");
	}
	
	public void crearTablaIngredientes() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS Ingredientes( IdReceta INT NOT NULL ,IdProducto INT NOT NULL , Cantidad real not null, constraint fkIdRecetas foreign key(IdReceta) references Recetas(IdReceta), constraint fkIdIdProductoAlmacenes foreign key(IdProducto) references Almacen(IdProducto) )ENGINE=INNODB;");
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
			
			// Usuario Admin para la primera vez que se instala la apliación			
			stmt.execute("INSERT IGNORE INTO Usuarios(NombreUsuario, Contrasena, Rol) values('Admin','','Administrador')");
			
			// Ingredientes y receta e prueba
			stmt.execute("INSERT IGNORE INTO  Almacen (NombreProducto, Cantidad, IdUnidadMedida, CantidadMinima, CantidadMaxima, IdTipo) VALUES ('Huevos', 24, 1, 6, 32, 1)");
			stmt.execute("INSERT IGNORE INTO  Almacen (NombreProducto, Cantidad, IdUnidadMedida, CantidadMinima, CantidadMaxima, IdTipo) VALUES ('Cebollas', 8, 1, 5, 15, 1)");
			stmt.execute("INSERT IGNORE INTO  Almacen (NombreProducto, Cantidad, IdUnidadMedida, CantidadMinima, CantidadMaxima, IdTipo) VALUES ('Patatas', 30, 1, 20, 50, 1)");
			stmt.execute("INSERT IGNORE INTO  Almacen (NombreProducto, Cantidad, IdUnidadMedida, CantidadMinima, CantidadMaxima, IdTipo) VALUES ('Aceite de Girasol', 6, 3, 5, 10, 1)");
			stmt.execute("INSERT IGNORE INTO  Almacen (NombreProducto, Cantidad, IdUnidadMedida, CantidadMinima, CantidadMaxima, IdTipo) VALUES ('Sal', 1, 2, 0.500, 2, 1)");
			
			stmt.execute("INSERT IGNORE INTO  recetas(IdTipo, IdDisponibilidad, NombreReceta, PrecioVenta, Elaboracion) values(2, 1, 'Tortilla de patatas', 4, 'Pelamos y lavamos las patatas, las cortamos en rodajas finas al igual que la cebolla. Ponemos ambas cosas en una sartén y cubrimos de aceite de oliva virgen extra, dejamos que se hagan a fuego medio-suave hasta que comiencen a dorarse. Sabréis que las patatas están hechas cuando comiencen a romperse, con la paleta. Para que la tortilla esté jugosa es importante que las patatas se hagan bien y se confiten, porque no hay nada peor que una tortilla con las patatas medio crudas. Por lo tanto, paciencia con este paso. Las sacamos de la sartén y escurrimos bien. Ponemos en un cuenco grande, aparte batimos los huevos y los añadimos a las patatas y a la cebolla, añadimos un poco de sal y mezclamos. Dejamos un par de minutos que se mezclen bien. Aquí hay quien prefiere dejar las patatas enteras y quien prefiere machacarlas un poco con la paleta para que se mezclen bien con el huevo Ponemos en la sartén un par de cucharadas de aceite de oliva virgen extra y vertemos todo. Al principio rompemos un poco, como si fuéramos a hacer un revuelto, luego vamos dándole forma  por los bordes. Cuando veamos que ya está cuajada por abajo ponemos un plato o una tapa encima de la sartén y le damos la vuelta rápidamente. Ponemos de nuevo la sartén en el fuego y deslizamos la tortilla desde el plato a la sartén. Dejamos unos minutos más (2 o 3 si te gusta más cuajada, menos si te gusta jugosa) para que se termine de hacer y ya tenemos lista nuestra tortilla de patatas.')");
			
			stmt.execute("INSERT IGNORE INTO  ingredientes (IdReceta,IdProducto, Cantidad) values (1, 1, 6)");
			stmt.execute("INSERT IGNORE INTO  ingredientes (IdReceta,IdProducto, Cantidad) values (1, 2, 1)");
			stmt.execute("INSERT IGNORE INTO  ingredientes (IdReceta,IdProducto, Cantidad) values (1, 3, 5)");
			stmt.execute("INSERT IGNORE INTO  ingredientes (IdReceta,IdProducto, Cantidad) values (1, 4, 0.500)");
			stmt.execute("INSERT IGNORE INTO  ingredientes (IdReceta,IdProducto, Cantidad) values (1, 5, 0.005)");
			
		}
	}		
}
	
