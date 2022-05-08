package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import vista.ListaFacturaciones;
import vista.VentanaPrincipal;

public class ControladorListaFacturaciones implements ActionListener, MouseListener {

private ListaFacturaciones panelListaFacturaciones;
	
	public ControladorListaFacturaciones(ListaFacturaciones panelListaFacturaciones) {
		this.panelListaFacturaciones = panelListaFacturaciones;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == ListaFacturaciones.getBtn_Volver()) {
			VentanaPrincipal.getPanelListaFacturaciones().setVisible(false);
			VentanaPrincipal.getPanelContabilidad().setVisible(true);			
		}
		
		if (e.getSource() == ListaFacturaciones.getBtn_Ver()) {
			VentanaPrincipal.getPanelListaFacturaciones().setVisible(false);
			VentanaPrincipal.getPanelDetalleFactura().setVisible(true);	
		}
		
		if (e.getSource() == ListaFacturaciones.getBtn_Calcular_Ganancias()) {
			VentanaPrincipal.getPanelListaFacturaciones().setVisible(false);
			VentanaPrincipal.getPanelCalculoGanancias().setVisible(true);	
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
