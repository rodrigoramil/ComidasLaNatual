package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import vista.DetalleGasto;
import vista.VentanaPrincipal;

public class ControladorDetalleGasto implements ActionListener, MouseListener{

	private DetalleGasto panelDetalleGasto;
	
	public ControladorDetalleGasto(DetalleGasto panelDetalleGasto) {
		this.panelDetalleGasto = panelDetalleGasto;
	}	


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == DetalleGasto.getBtn_Volver()) {
			VentanaPrincipal.getPanelDetalleGasto().setVisible(false);
			VentanaPrincipal.getPanelListaGastos().setVisible(true);			
		}
		
		if (e.getSource() == DetalleGasto.getBtn_Guardar()) {
			VentanaPrincipal.getPanelDetalleGasto().setVisible(false);
			VentanaPrincipal.getPanelListaGastos().setVisible(true);
		}
		
		if (e.getSource() == DetalleGasto.getBtn_Imprimir()) {
			
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
