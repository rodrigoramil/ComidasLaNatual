package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import modelo.SentenciasSQL;
import vista.GestionPedidos;
import vista.VentanaPrincipal;

public class ControladorGestionPedidos implements ActionListener, MouseListener  {

	private GestionPedidos panelGestionPedidos;
	
	public ControladorGestionPedidos(GestionPedidos panelGestionPedidos) {
		this.panelGestionPedidos = panelGestionPedidos;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == GestionPedidos.getBtn_volver()) {
			VentanaPrincipal.getPanelGestionPedidos().setVisible(false);
			VentanaPrincipal.getPanelMenuPrincipal().setVisible(true);			
		}
		if (e.getSource() == GestionPedidos.getBtn_Nuevo_Cliente()) {
			VentanaPrincipal.getPanelGestionPedidos().setVisible(false);
			VentanaPrincipal.getPanelCliente().setVisible(true);			
		}
		if (e.getSource() == GestionPedidos.getBtn_Editar_Cliente()) {
			VentanaPrincipal.getPanelGestionPedidos().setVisible(false);
			VentanaPrincipal.getPanelCliente().setVisible(true);	

		}
		
		if (e.getSource() == GestionPedidos.getBtn_Mesa_1()) {
			VentanaPrincipal.getPanelGestionPedidos().setVisible(false);
			VentanaPrincipal.getPanelPedido().setVisible(true);
		}
		
		if (e.getSource() == GestionPedidos.getBtn_Mesa_2()) {
			VentanaPrincipal.getPanelGestionPedidos().setVisible(false);
			VentanaPrincipal.getPanelPedido().setVisible(true);
		}
		
		if (e.getSource() == GestionPedidos.getBtn_Mesa_3()) {
			VentanaPrincipal.getPanelGestionPedidos().setVisible(false);
			VentanaPrincipal.getPanelPedido().setVisible(true);
		}
		
		if (e.getSource() == GestionPedidos.getBtn_Mesa_4()) {
			VentanaPrincipal.getPanelGestionPedidos().setVisible(false);
			VentanaPrincipal.getPanelPedido().setVisible(true);
		}
		
		if (e.getSource() == GestionPedidos.getBtn_Mesa_5()) {
			VentanaPrincipal.getPanelGestionPedidos().setVisible(false);
			VentanaPrincipal.getPanelPedido().setVisible(true);
		}
		
		if (e.getSource() == GestionPedidos.getBtn_Mesa_6()) {
			VentanaPrincipal.getPanelGestionPedidos().setVisible(false);
			VentanaPrincipal.getPanelPedido().setVisible(true);
		}
		
		if (e.getSource() == GestionPedidos.getBtn_Mesa_7()) {
			VentanaPrincipal.getPanelGestionPedidos().setVisible(false);
			VentanaPrincipal.getPanelPedido().setVisible(true);
		}
		
		if (e.getSource() == GestionPedidos.getBtn_Mesa_8()) {
			VentanaPrincipal.getPanelGestionPedidos().setVisible(false);
			VentanaPrincipal.getPanelPedido().setVisible(true);
		}
		
		if (e.getSource() == GestionPedidos.getBtn_Ver_Pedido()) {
			VentanaPrincipal.getPanelGestionPedidos().setVisible(false);
			VentanaPrincipal.getPanelPedido().setVisible(true);
		}
		
		
	}
	
	
	
	
	
	
	

	@Override
	public void mouseClicked(MouseEvent e) { // Al hacer clic con el raton

		
	}

	@Override
	public void mousePressed(MouseEvent e) { // Al pulsar raton

		SentenciasSQL.editarCliente();
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
