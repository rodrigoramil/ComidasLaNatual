package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import vista.Receta;
import vista.VentanaPrincipal;

public class ControladorReceta implements ActionListener, MouseListener  {

	private Receta panelReceta;

	public ControladorReceta(Receta panelReceta) {
		this.panelReceta = panelReceta;
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Receta.getBtn_volver()) {
			VentanaPrincipal.getPanelRecetario().setVisible(true);
			VentanaPrincipal.getPanelReceta().setVisible(false);
		}
		
		if (e.getSource() == Receta.getBtn_nuevo_ingrediente()) {

			VentanaPrincipal.getPanelProductosAlmacen().setVisible(true);
			VentanaPrincipal.getPanelReceta().setVisible(false);
		}
		
		if (e.getSource() == Receta.getBtn_modificar_cantidad()) {
			
		}
		
		if (e.getSource() == Receta.getBtn_borrar_ingrediente()) {
			
		}
		
		if (e.getSource() == Receta.getBtn_guardar()) {
			VentanaPrincipal.getPanelRecetario().setVisible(true);
			VentanaPrincipal.getPanelReceta().setVisible(false);
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
