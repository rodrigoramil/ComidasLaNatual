package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import modelo_bbdd.BbddCalculoGanancias;
import modelo_bbdd.BbddListaGastos;
import modelo_bbdd.BbddPrepararCompra;
import vista.Contabilidad;
import vista.ListaFacturaciones;
import vista.ListaGastos;
import vista.MenuPrincipal;
import vista.PrepararCompra;
import vista.VentanaPrincipal;

public class ControladorContabilidad implements ActionListener, MouseListener {

	
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == Contabilidad.getBtn_Facturacion()) {
			Contabilidad.getBtn_Facturacion().setBackground(VentanaPrincipal.getAzulOscuro());
			Contabilidad.getBtn_Facturacion().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == Contabilidad.getBtn_Gastos()) {
			Contabilidad.getBtn_Gastos().setBackground(VentanaPrincipal.getAzulOscuro());
			Contabilidad.getBtn_Gastos().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == Contabilidad.getBtn_volver()) {
			Contabilidad.getBtn_volver().setBackground(VentanaPrincipal.getAzulOscuro());
			Contabilidad.getBtn_volver().setForeground(VentanaPrincipal.getAzulClaro());;
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == Contabilidad.getBtn_Facturacion()) {
			Contabilidad.getBtn_Facturacion().setBackground(VentanaPrincipal.getAzulClaro());
			Contabilidad.getBtn_Facturacion().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == Contabilidad.getBtn_Gastos()) {
			Contabilidad.getBtn_Gastos().setBackground(VentanaPrincipal.getAzulClaro());
			Contabilidad.getBtn_Gastos().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == Contabilidad.getBtn_volver()) {
			Contabilidad.getBtn_volver().setBackground(VentanaPrincipal.getAzulClaro());
			Contabilidad.getBtn_volver().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
	}

}
