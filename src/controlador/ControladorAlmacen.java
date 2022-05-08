package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import vista.Almacen;
import vista.VentanaPrincipal;

public class ControladorAlmacen implements ActionListener, MouseListener  {

private Almacen panelAlmacen;
	
	public ControladorAlmacen(Almacen panelAlmacen) {
		this.panelAlmacen = panelAlmacen;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Almacen.getBtn_Volver()) {
			VentanaPrincipal.getPanelMenuPrincipal().setVisible(true);
			VentanaPrincipal.getPanelAlmacen().setVisible(false);
		}
		
		if (e.getSource() == Almacen.getBtn_Modificar()) {
			VentanaPrincipal.getPanelAlmacen().setVisible(false);
			VentanaPrincipal.getPanelDetalleProducto().setVisible(true);
		}
		if (e.getSource() == Almacen.getBtn_Nuevo()) {
			VentanaPrincipal.getPanelAlmacen().setVisible(false);
			VentanaPrincipal.getPanelDetalleProducto().setVisible(true);
		}
		
		if (e.getSource() == Almacen.getBtn_Realizar_Lista_Compra()) {
			VentanaPrincipal.getPanelAlmacen().setVisible(false);
			VentanaPrincipal.getPanelPrepararCompra().setVisible(true);
		}
				
		if (e.getSource() == Almacen.getBtn_Ver_Listas_Compras()) {
			VentanaPrincipal.getPanelAlmacen().setVisible(false);
			VentanaPrincipal.getPanelListasCompra().setVisible(true);
		}
		
		if (e.getSource() == Almacen.getBtn_todos_los_Productos()) {
			
		}
		
		if (e.getSource() == Almacen.getBtn_Buscar()) {
			
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

		
	}

	@Override
	public void mouseExited(MouseEvent e) { //al salir el raton de encima

		
	}
		
			
			
			

			
			
		
			
	
}