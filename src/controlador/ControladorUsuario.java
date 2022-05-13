package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Usuario;
import vista.VentanaPrincipal;

public class ControladorUsuario implements ActionListener {

	private Usuario panelUsuario;

	public ControladorUsuario(Usuario panelUsuario) {
		this.panelUsuario = panelUsuario;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Usuario.getBtn_volver()) {
			VentanaPrincipal.getPanelGestionUsuarios().setVisible(true);
			VentanaPrincipal.getPanelUsuario().setVisible(false);
			
			
		}
		
		if (e.getSource() == Usuario.getBtn_Aceptar()) {
			VentanaPrincipal.getPanelGestionUsuarios().setVisible(true);
			VentanaPrincipal.getPanelUsuario().setVisible(false);
			
		}
	}

}
