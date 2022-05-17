package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import modelo_bbdd.BbddAlmacen;
import modelo_bbdd.BbddLogin;
import modelo_bbdd.BbddRecetario;
import modelo_bbdd.BbddVentas;
import vista.VentanaPrincipal;
import vista.Almacen;
import vista.BuscarComidaBebida;
import vista.CalculoGanancias;
import vista.CalculoGastos;
import vista.DetalleFactura;
import vista.DetalleGasto;
import vista.Facturar;
import vista.GestionPedidos;
import vista.GestionUsuarios;
import vista.ListaFacturaciones;
import vista.ListaGastos;
import vista.ListasCompra;
import vista.MenuPrincipal;
import vista.Pedido;
import vista.PrepararCompra;
import vista.ProductosAlmacen;
import vista.Receta;
import vista.Recetario;

public class ControladorMenuPrincipal implements  ActionListener, MouseListener   {

	private MenuPrincipal panelMenuPrincipal;
	
	public ControladorMenuPrincipal(MenuPrincipal panelMenuPrincipal) {
		this.panelMenuPrincipal = panelMenuPrincipal;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource() == panelMenuPrincipal.getBtn_Ventas()) {
			VentanaPrincipal.getPanelMenuPrincipal().setVisible(false);
			VentanaPrincipal.getPanelGestionPedidos().setVisible(true);
			GestionPedidos.getBtn_Editar_Cliente().setEnabled(false);
			GestionPedidos.getBtn_Ver_Pedido().setEnabled(false);
			
		}
		
		if (e.getSource() == panelMenuPrincipal.getBtn_Recetario()) {
			
			VentanaPrincipal.getPanelMenuPrincipal().setVisible(false);
			VentanaPrincipal.getPanelRecetario().setVisible(true);
			
			Recetario.listarRecetas(BbddRecetario.listarRecetas());
			
		}
		
		if (e.getSource() == panelMenuPrincipal.getBtn_Almacen()) {
			VentanaPrincipal.getPanelMenuPrincipal().setVisible(false);
			VentanaPrincipal.getPanelAlmacen().setVisible(true);

			Almacen.listarProductos(BbddAlmacen.listarProductosAlmacen());
		}
		
		if (e.getSource() == panelMenuPrincipal.getBtn_Contabilidad()) {
			VentanaPrincipal.getPanelMenuPrincipal().setVisible(false);
			VentanaPrincipal.getPanelContabilidad().setVisible(true);

		}
		
		
		if (e.getSource() == panelMenuPrincipal.getBtn_Gestion_Usuario()) {
			VentanaPrincipal.getPanelMenuPrincipal().setVisible(false);
			VentanaPrincipal.getPanelGestionUsuarios().setVisible(true);

			GestionUsuarios.listarUsuarios(BbddLogin.listarUsuarios());
			
		}
		
		if (e.getSource() == panelMenuPrincipal.getBtn_Cerrar_Sesion()) {
			VentanaPrincipal.getPanelLogin().setVisible(true);
			VentanaPrincipal.getPanelMenuPrincipal().setVisible(false);
		
		}
	
	
	
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) { // Al hacer clic con el raton


			
		
	}

	@Override
	public void mousePressed(MouseEvent e) { // Al pulsar raton

		
	}

	@Override
	public void mouseReleased(MouseEvent e) { // al no interactuar con el

		
	}

	@Override
	public void mouseEntered(MouseEvent e) { // al tener el raton encima
		if (e.getSource() == MenuPrincipal.getBtn_Ventas()) {
			MenuPrincipal.getBtn_Ventas().setBackground(VentanaPrincipal.getAzulOscuro());
			MenuPrincipal.getBtn_Ventas().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == MenuPrincipal.getBtn_Recetario()) {
			MenuPrincipal.getBtn_Recetario().setBackground(VentanaPrincipal.getAzulOscuro());
			MenuPrincipal.getBtn_Recetario().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == MenuPrincipal.getBtn_Almacen()) {
			MenuPrincipal.getBtn_Almacen().setBackground(VentanaPrincipal.getAzulOscuro());
			MenuPrincipal.getBtn_Almacen().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == MenuPrincipal.getBtn_Contabilidad()) {
			MenuPrincipal.getBtn_Contabilidad().setBackground(VentanaPrincipal.getAzulOscuro());
			MenuPrincipal.getBtn_Contabilidad().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == MenuPrincipal.getBtn_Gestion_Usuario()) {
			MenuPrincipal.getBtn_Gestion_Usuario().setBackground(VentanaPrincipal.getAzulOscuro());
			MenuPrincipal.getBtn_Gestion_Usuario().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == MenuPrincipal.getBtn_Cerrar_Sesion()) {
			MenuPrincipal.getBtn_Cerrar_Sesion().setBackground(VentanaPrincipal.getAzulClaro());
			MenuPrincipal.getBtn_Cerrar_Sesion().setForeground(VentanaPrincipal.getAzulOscuro());;
		}

		
	}

	@Override
	public void mouseExited(MouseEvent e) { //al salir el raton de encima
		if (e.getSource() == MenuPrincipal.getBtn_Ventas()) {
			MenuPrincipal.getBtn_Ventas().setBackground(VentanaPrincipal.getAzulClaro());
			MenuPrincipal.getBtn_Ventas().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == MenuPrincipal.getBtn_Recetario()) {
			MenuPrincipal.getBtn_Recetario().setBackground(VentanaPrincipal.getAzulClaro());
			MenuPrincipal.getBtn_Recetario().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == MenuPrincipal.getBtn_Almacen()) {
			MenuPrincipal.getBtn_Almacen().setBackground(VentanaPrincipal.getAzulClaro());
			MenuPrincipal.getBtn_Almacen().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == MenuPrincipal.getBtn_Contabilidad()) {
			MenuPrincipal.getBtn_Contabilidad().setBackground(VentanaPrincipal.getAzulClaro());
			MenuPrincipal.getBtn_Contabilidad().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == MenuPrincipal.getBtn_Gestion_Usuario()) {
			MenuPrincipal.getBtn_Gestion_Usuario().setBackground(VentanaPrincipal.getAzulClaro());
			MenuPrincipal.getBtn_Gestion_Usuario().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == MenuPrincipal.getBtn_Cerrar_Sesion()) {
			MenuPrincipal.getBtn_Cerrar_Sesion().setBackground(MenuPrincipal.getAzulFondoBotonCerrar());
			MenuPrincipal.getBtn_Cerrar_Sesion().setForeground(MenuPrincipal.getAzulLetrasBotonCerrar());;
		}
		
	}
	
	

}
