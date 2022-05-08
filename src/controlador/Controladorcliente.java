package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.Cliente;
import vista.VentanaPrincipal;

public class Controladorcliente implements ActionListener{

	private Cliente panelCliente;

	public Controladorcliente(Cliente panelCliente) {
		this.panelCliente = panelCliente;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == Cliente.getBtn_volver()) {
			VentanaPrincipal.getPanelCliente().setVisible(false);
			VentanaPrincipal.getPanelGestionPedidos().setVisible(true);
		}
		
		if (e.getSource() == Cliente.getBtn_Aceptar()) {
			VentanaPrincipal.getPanelCliente().setVisible(false);
			VentanaPrincipal.getPanelGestionPedidos().setVisible(true);
		}
		
	}
	

}
