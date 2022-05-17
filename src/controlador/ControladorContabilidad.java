package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo_bbdd.BbddCalculoGanancias;
import modelo_bbdd.BbddListaGastos;
import modelo_bbdd.BbddPrepararCompra;
import vista.Contabilidad;
import vista.ListaFacturaciones;
import vista.ListaGastos;
import vista.PrepararCompra;
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
			
			ListaGastos.listarGastos(BbddListaGastos.listarListaGastos());
		}
		
		if (e.getSource() == Contabilidad.getBtn_Facturacion()) {
			VentanaPrincipal.getPanelContabilidad().setVisible(false);
			VentanaPrincipal.getPanelListaFacturaciones().setVisible(true);
			
			ListaFacturaciones.listarFacturaciones(BbddCalculoGanancias.listarCalculoGanancias());    	
			
		}
		
	}

}
