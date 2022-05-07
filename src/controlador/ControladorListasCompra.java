package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import vista.ListasCompra;
import vista.VentanaPrincipal;

public class ControladorListasCompra implements ActionListener, MouseListener {

	
private ListasCompra panelListasCompra;
	
	public ControladorListasCompra(ListasCompra panelListasCompra) {
		this.panelListasCompra = panelListasCompra;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == ListasCompra.getBtn_Volver()) {			
			VentanaPrincipal.getPanelListasCompra().setVisible(false);
			VentanaPrincipal.getPanelAlmacen().setVisible(true);
		}
		
		if (e.getSource() == ListasCompra.getBtn_Ver()) {
			VentanaPrincipal.getPanelListasCompra().setVisible(false);
			VentanaPrincipal.getPanelPrepararCompra().setVisible(true);
			
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
