package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import vista.ProductosAlmacen;
import vista.VentanaPrincipal;

public class ControladorProductosAlmacen  implements ActionListener, MouseListener  {

private ProductosAlmacen panelProductosAlmacen;
	
	public ControladorProductosAlmacen (ProductosAlmacen panelProductosAlmacen) {
		this.panelProductosAlmacen = panelProductosAlmacen;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == ProductosAlmacen.getBtn_volver()) {
			VentanaPrincipal.getPanelProductosAlmacen().setVisible(false);
			VentanaPrincipal.getPanelReceta().setVisible(true);			
		}
		
		if (e.getSource() == ProductosAlmacen.getBtn_add_receta()) {
			VentanaPrincipal.getPanelProductosAlmacen().setVisible(false);
			VentanaPrincipal.getPanelReceta().setVisible(true);	
		}
		
		if (e.getSource() == ProductosAlmacen.getBtn_todos_productos()) {
			
		}
		
		if (e.getSource() == ProductosAlmacen.getBtn_buscar()) {
			
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
