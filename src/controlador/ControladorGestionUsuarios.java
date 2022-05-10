package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import vista.GestionUsuarios;
import vista.VentanaPrincipal;

public class ControladorGestionUsuarios implements ActionListener, MouseListener  {


	private GestionUsuarios panelGestionUsuarios;

	public ControladorGestionUsuarios(GestionUsuarios panelGestionUsuarios) {
		this.panelGestionUsuarios = panelGestionUsuarios;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == GestionUsuarios.getBtn_volver()) {
			VentanaPrincipal.getPanelMenuPrincipal().setVisible(true);
			VentanaPrincipal.getPanelGestionUsuarios().setVisible(false);
		}
		if (e.getSource() == GestionUsuarios.getBtn_nuevo()) {
			VentanaPrincipal.getPanelGestionUsuarios().setVisible(false);
			VentanaPrincipal.getPanelUsuario().setVisible(true);
		}
		if (e.getSource() == GestionUsuarios.getBtn_Modificar()) {
			VentanaPrincipal.getPanelGestionUsuarios().setVisible(false);
			VentanaPrincipal.getPanelUsuario().setVisible(true);
		}
		if (e.getSource() == GestionUsuarios.getBtn_eliminar()) {
			
			String eliminaUsuario = "Manolete";
			JOptionPane.showConfirmDialog(panelGestionUsuarios, "Quiere eleminar el usuario "+eliminaUsuario);
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
