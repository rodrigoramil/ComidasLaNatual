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
