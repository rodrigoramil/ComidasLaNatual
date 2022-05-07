package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.Contabilidad;
import vista.VentanaPrincipal;

public class ControladorContabilidad implements ActionListener {

	
	private Contabilidad panelContabilidad;

	public ControladorContabilidad(Contabilidad panelContabilidad) {
		this.panelContabilidad = panelContabilidad;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Contabilidad.getBtn_volver()) {
			VentanaPrincipal.getPanelMenuPrincipal().setVisible(true);
			VentanaPrincipal.getPanelContabilidad().setVisible(false);
		}
		
	}

}
