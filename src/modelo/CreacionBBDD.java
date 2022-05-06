package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;



public class CreacionBBDD {	

	private Statement stmt=null;
	private String usuario = "root";
	private String pass = "";
	
	public void creacionBBDD() {
	
		Connection con = null;
		String sURL = "jdbc:mysql://localhost:3306/";
		
		try {
		  con = DriverManager.getConnection(sURL, usuario, pass);
		  stmt = con.createStatement();
		  crearBBDD();
		  
		  crearTablaAlmacen();
		  crearTablaRecetas();
		  crearTablaUsuarios();
		  crearTablaGanancias();
		  crearTablaCliente();
		  crearTablaGasto();
		  crearTablaTrabajoUsuariosGastos();
		  crearTablaTrabajoUsuariosGanancias();
		  crearTablaPedidoCliente();
		  crearTablaPedido();
		  crearTablaCompraProductos();
		  crearTablaIngredientes();
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
	
	public void crearTablaAlmacen() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS Almacen("
				+ "IdProducto INT NOT NULL AUTO_INCREMENT, "
				+ "NombreProducto VARCHAR(45) NOT NULL UNIQUE, "
				+ "Cantidad REAL NOT NULL, "
				+ "UnidadMedida ENUM('Kg', 'L', 'Ud') NOT NULL, "
				+ "CantidadMinima REAL NOT NULL, "
				+ "CantidadMaxima REAL NOT NULL, "
				+ "PRIMARY KEY(idProducto)"
				+ ")ENGINE=INNODB;");
	}
	
	public void crearTablaRecetas() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS Recetas("
				+ "IdReceta INT NOT NULL AUTO_INCREMENT, "
				+ "Tipo VARCHAR(45) NOT NULL, "
				+ "NombreReceta VARCHAR(45) NOT NULL, "
				+ "Estado ENUM('Disponible', 'No Disponible') NOT NULL, "
				+ "PrecioVenta REAL NOT NULL, "
				+ "Elaboracion TEXT NULL, "
				+ "PRIMARY KEY(IdReceta)"
				+ ")ENGINE=INNODB;");
	}
	
	public void crearTablaUsuarios() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS Usuarios("
				+ "NombreUsuario VARCHAR(45) NOT NULL, "
				+ "Contrasena VARCHAR(45) NOT NULL, "
				+ "Rol ENUM('Administrador', 'Cocina', 'Venta') NOT NULL, "
				+ "PRIMARY KEY(NombreUsuario)"
				+ ")ENGINE=INNODB;");
	}
	
	public void crearTablaGanancias() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS Ganancias("
				+ "IdPedido INT NOT NULL AUTO_INCREMENT, "
				+ "FechaPedido DATETIME NOT NULL, "
				+ "HoraPedido  DATETIME NOT NULL, "
				+ "GananciaPedido REAL NOT NULL, "
				+ "PRIMARY KEY(IdPedido)"
				+ ")ENGINE=INNODB;");
	}
	
	public void crearTablaCliente() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS Cliente("
				+ "IdCliente INT NOT NULL AUTO_INCREMENT, "
				+ "NombreCliente VARCHAR(45) NOT NULL, "
				+ "Telefono INT(9) NOT NULL, "
				+ "PRIMARY KEY(IdCliente)"
				+ ")ENGINE=INNODB;");
	}

	public void crearTablaGasto() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS Gasto("
				+ "IdCompraProductos INT NOT NULL AUTO_INCREMENT, "
				+ "CompraHecha boolean NOT NULL, "
				+ "FechaCompra datetime NOT NULL, "
				+ "GastoCompra real not null, "
				+ "PRIMARY KEY(IdCompraProductos)"
				+ ")ENGINE=INNODB;");
	}
	
	public void crearTablaTrabajoUsuariosGastos() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS TrabajoUsuariosGastos("
				+ "NombreUsuario VARCHAR(45) NOT NULL, "
				+ "IdCompraProductos int NOT NULL, "
				+ "constraint fkNombreUsuarioGastos foreign key(NombreUsuario) references Usuarios(NombreUsuario), "
				+ "constraint fkIdCompraProductos foreign key(IdCompraProductos) references Gasto(IdCompraProductos)"
				+ ")ENGINE=INNODB;");
	}
	
	public void crearTablaTrabajoUsuariosGanancias() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS TrabajoUsuariosGanancias("
				+ "NombreUsuario VARCHAR(45) NOT NULL, "
				+ "IdPedido INT NOT NULL, "
				+ "constraint fkNombreUsuarioGanancia foreign key(NombreUsuario) references Usuarios(NombreUsuario), "
				+ "constraint fkIdPedidoGanancias foreign key(IdPedido) references Ganancias(IdPedido)"
				+ ")ENGINE=INNODB;");
	}
	
	public void crearTablaPedidoCliente() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS PedidoCliente("
				+ "IdPedido INT NOT NULL, "
				+ "IdCliente INT NOT NULL, "
				+ "constraint fkIdPedido foreign key(IdPedido) references Ganancias(IdPedido), "
				+ "constraint fkIdCliente foreign key(IdCliente) references Cliente(IdCliente)"
				+ ")ENGINE=INNODB;");
	}
	
	public void crearTablaPedido() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS Pedido("
				+ "IdReceta INT NOT NULL, "
				+ "IdPedido INT NOT NULL, "
				+ "CantidadRecetaVenta int not null, "
				+ "constraint fkIdReceta foreign key(IdReceta) references Recetas(IdReceta), "
				+ "constraint fkIdPedidos foreign key(IdPedido)references Ganancias(IdPedido)"
				+ ")ENGINE=INNODB;");
	}
	
	public void crearTablaCompraProductos() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS CompraProductos("
				+ "IdCompraProductos INT NOT NULL, "
				+ "IdProducto INT NOT NULL, "
				+ "CantidadCompraProducto real not null, "
				+ "PrecioCompraProducto real not null, "
				+ "PrecioMedioCompraProducto real not null, "
				+ "constraint fkIdCompraProductosGastos foreign key(IdCompraProductos) references Gasto(IdCompraProductos), "
				+ "constraint fkIdProductoAlmacen foreign key(IdProducto)  references Almacen(IdProducto)"
				+ ")ENGINE=INNODB;");
	}
	
	public void crearTablaIngredientes() throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS Ingredientes("
				+ "IdReceta INT NOT NULL, "
				+ "IdProducto INT NOT NULL, "
				+ "Cantidad real not null, "
				+ "constraint fkIdRecetas foreign key(IdReceta) references Recetas(IdReceta), "
				+ "constraint fkIdIdProductoAlmacenes foreign key(IdProducto) references Almacen(IdProducto)"
				+ ") ENGINE=INNODB;");
	}
}
	


/*
	stmt.execute("CREATE DATABASE IF NOT EXISTS bbdd_comidas_la_natural");
	stmt.execute("USE bbdd_comidas_la_natural;");
	stmt.execute("CREATE TABLE IF NOT EXISTS Almacen(IdProducto INT NOT NULL AUTO_INCREMENT, NombreProducto VARCHAR(45) NOT NULL UNIQUE, Cantidad REAL NOT NULL, UnidadMedida ENUM('Kg', 'L', 'Ud') NOT NULL, CantidadMinima REAL NOT NULL, CantidadMaxima REAL NOT NULL, PRIMARY KEY(idProducto))ENGINE=INNODB;");
	stmt.execute("CREATE TABLE IF NOT EXISTS Recetas(IdReceta INT NOT NULL AUTO_INCREMENT,Tipo VARCHAR(45) NOT NULL, NombreReceta VARCHAR(45) NOT NULL, Estado ENUM('Disponible', 'No Disponible') NOT NULL, PrecioVenta REAL NOT NULL, Elaboracion VARCHAR(254) NOT NULL, PRIMARY KEY(IdReceta))ENGINE=INNODB;");		
	stmt.execute("CREATE TABLE IF NOT EXISTS Usuarios(NombreUsuario VARCHAR(45) NOT NULL,Contrasena VARCHAR(45) NOT NULL,Rol ENUM('Administrador', 'Cocina', 'Venta') NOT NULL,PRIMARY KEY(NombreUsuario))ENGINE=INNODB;");
	stmt.execute("CREATE TABLE IF NOT EXISTS Ganancias(IdPedido INT NOT NULL AUTO_INCREMENT,FechaPedido DATETIME NOT NULL,HoraPedido  DATETIME NOT NULL,GananciaPedido REAL NOT NULL,PRIMARY KEY(IdPedido))ENGINE=INNODB;");
	stmt.execute("CREATE TABLE IF NOT EXISTS Cliente(IdCliente INT NOT NULL AUTO_INCREMENT,NombreCliente VARCHAR(45) NOT NULL,Telefono INT(9) NOT NULL,PRIMARY KEY(IdCliente))ENGINE=INNODB;");
	stmt.execute("CREATE TABLE IF NOT EXISTS Gasto(IdCompraProductos INT NOT NULL AUTO_INCREMENT,CompraHecha boolean NOT NULL,FechaCompra datetime NOT NULL,GastoCompra real not null,PRIMARY KEY(IdCompraProductos))ENGINE=INNODB;");
	stmt.execute("CREATE TABLE IF NOT EXISTS TrabajoUsuariosGastos(NombreUsuario VARCHAR(45) NOT NULL, IdCompraProductos int NOT NULL, constraint fkNombreUsuarioGastos foreign key(NombreUsuario) references Usuarios(NombreUsuario), constraint fkIdCompraProductos foreign key(IdCompraProductos) references Gasto(IdCompraProductos))ENGINE=INNODB;");
	stmt.execute("CREATE TABLE IF NOT EXISTS TrabajoUsuariosGanancias(NombreUsuario VARCHAR(45) NOT NULL, IdPedido INT NOT NULL, constraint fkNombreUsuarioGanancia foreign key(NombreUsuario) references Usuarios(NombreUsuario), constraint fkIdPedidoGanancias foreign key(IdPedido) references Ganancias(IdPedido))ENGINE=INNODB;");
	stmt.execute("CREATE TABLE IF NOT EXISTS PedidoCliente(IdPedido INT NOT NULL, IdCliente INT NOT NULL, constraint fkIdPedido foreign key(IdPedido) references Ganancias(IdPedido), constraint fkIdCliente foreign key(IdCliente) references Cliente(IdCliente))ENGINE=INNODB;");
	stmt.execute("CREATE TABLE IF NOT EXISTS Pedido(IdReceta INT NOT NULL, IdPedido INT NOT NULL, CantidadRecetaVenta int not null, constraint fkIdReceta foreign key(IdReceta) references Recetas(IdReceta), constraint fkIdPedidos foreign key(IdPedido)references Ganancias(IdPedido))ENGINE=INNODB;");
	stmt.execute("CREATE TABLE IF NOT EXISTS CompraProductos(IdCompraProductos INT NOT NULL, IdProducto INT NOT NULL , CantidadCompraProducto real not null, PrecioCompraProducto real not null, PrecioMedioCompraProducto real not null, constraint fkIdCompraProductosGastos foreign key(IdCompraProductos) references Gasto(IdCompraProductos), constraint fkIdProductoAlmacen foreign key(IdProducto)  references Almacen(IdProducto))ENGINE=INNODB;");
	stmt.execute("CREATE TABLE IF NOT EXISTS Ingredientes(IdReceta INT NOT NULL, IdProducto INT NOT NULL, Cantidad real not null, constraint fkIdRecetas foreign key(IdReceta) references Recetas(IdReceta), constraint fkIdIdProductoAlmacenes foreign key(IdProducto) references Almacen(IdProducto)) ENGINE=INNODB;");
*/
