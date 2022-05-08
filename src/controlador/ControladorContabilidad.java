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
			VentanaPrincipal.getPanelContabilidad().setVisible(false);
			VentanaPrincipal.getPanelMenuPrincipal().setVisible(true);			
		}
		
		if (e.getSource() == Contabilidad.getBtn_Gastos()) {
			VentanaPrincipal.getPanelContabilidad().setVisible(false);
			VentanaPrincipal.getPanelListaGastos().setVisible(true);
		}
		
		if (e.getSource() == Contabilidad.getBtn_Facturacion()) {
			VentanaPrincipal.getPanelContabilidad().setVisible(false);
			VentanaPrincipal.getPanelListaFacturaciones().setVisible(true);
		}
		
	}

}
