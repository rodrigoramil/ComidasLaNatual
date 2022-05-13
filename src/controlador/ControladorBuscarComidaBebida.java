package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import vista.BuscarComidaBebida;
import vista.Receta;
import vista.VentanaPrincipal;

public class ControladorBuscarComidaBebida implements ActionListener, MouseListener  {

	private BuscarComidaBebida panelBuscarComidaBebida;
	private static boolean desdeVentas;
	
	public ControladorBuscarComidaBebida(BuscarComidaBebida panelBuscarComidaBebida) {
		this.panelBuscarComidaBebida = panelBuscarComidaBebida;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == BuscarComidaBebida.getBtn_volver()) {
			VentanaPrincipal.getPanelBuscarComidaBebida().setVisible(false);
			VentanaPrincipal.getPanelPedido().setVisible(true);
		}
		if (e.getSource() == BuscarComidaBebida.getBtn_anadir()) {
			
		}
		
		if (e.getSource() == BuscarComidaBebida.getBtn_bebidas_disponibles()) {
			
		}
		
		if (e.getSource() == BuscarComidaBebida.getBtn_comidas_disponibles()) {
			
		}
		
		if (e.getSource() == BuscarComidaBebida.getBtn_listar_todo()) {
			
		}
	
		if (e.getSource() == BuscarComidaBebida.getBtn_buscar()) {
			
		}
	
		if (e.getSource() == BuscarComidaBebida.getBtn_ver_receta()) {
			VentanaPrincipal.getPanelBuscarComidaBebida().setVisible(false);
			VentanaPrincipal.getPanelReceta().setVisible(true);
			Receta.getBtn_nuevo_ingrediente().setEnabled(false);
			Receta.getBtn_modificar_cantidad().setEnabled(false);
			Receta.getBtn_borrar_ingrediente().setEnabled(false);
			Receta.getBtn_guardar().setEnabled(false);
			desdeVentas = true;
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

	
	
	public static boolean getDesdeVentas() {
		return desdeVentas;
	}

	public static void setDesdeVentas(boolean desdeVentas) {
		ControladorBuscarComidaBebida.desdeVentas = desdeVentas;
	}
		
	
	
	
	
}