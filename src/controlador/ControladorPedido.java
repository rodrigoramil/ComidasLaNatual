package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import vista.GestionPedidos;
import vista.Pedido;
import vista.VentanaPrincipal;

public class ControladorPedido  implements ActionListener, MouseListener {

	private Pedido panelPedido;

	public ControladorPedido (Pedido panelPedido) {
		this.panelPedido = panelPedido;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == Pedido.getBtn_Volver()) {			
			VentanaPrincipal.getPanelGestionPedidos().setVisible(true);
			VentanaPrincipal.getPanelPedido().setVisible(false);
			GestionPedidos.getBtn_Editar_Cliente().setEnabled(false);
			GestionPedidos.getBtn_Ver_Pedido().setEnabled(false);
		}
		if (e.getSource() == Pedido.getBtn_Guardar()) {
			VentanaPrincipal.getPanelGestionPedidos().setVisible(true);
			VentanaPrincipal.getPanelPedido().setVisible(false);
			GestionPedidos.getBtn_Editar_Cliente().setEnabled(false);
			GestionPedidos.getBtn_Ver_Pedido().setEnabled(false);
		}
		if (e.getSource() == Pedido.getBtn_Nuevo()) {
			VentanaPrincipal.getPanelPedido().setVisible(false);
			VentanaPrincipal.getPanelBuscarComidaBebida().setVisible(true);	
		}
		
		if (e.getSource() == Pedido.getBtn_Modificar()) {
			
		}
		
		if (e.getSource() == Pedido.getBtn_Eliminar()) {
			
		}
		
		if (e.getSource() == Pedido.getBtn_Facturar()) {
			VentanaPrincipal.getPanelPedido().setVisible(false);
			VentanaPrincipal.getPanelFacturar().setVisible(true);	
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
