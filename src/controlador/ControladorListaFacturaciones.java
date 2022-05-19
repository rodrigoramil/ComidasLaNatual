package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import modelo_bbdd.BbddCalculoGanancias;
import vista.CalculoGanancias;
import vista.ListaFacturaciones;
import vista.MenuPrincipal;
import vista.VentanaPrincipal;

public class ControladorListaFacturaciones implements ActionListener, MouseListener {

private ListaFacturaciones panelListaFacturaciones;
	
	public ControladorListaFacturaciones(ListaFacturaciones panelListaFacturaciones) {
		this.panelListaFacturaciones = panelListaFacturaciones;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == ListaFacturaciones.getBtn_Volver()) {
			VentanaPrincipal.getPanelListaFacturaciones().setVisible(false);
			VentanaPrincipal.getPanelContabilidad().setVisible(true);			
		}
		
		if (e.getSource() == ListaFacturaciones.getBtn_Ver()) {
			VentanaPrincipal.getPanelListaFacturaciones().setVisible(false);
			VentanaPrincipal.getPanelDetalleFactura().setVisible(true);	
		}
		
		if (e.getSource() == ListaFacturaciones.getBtn_Calcular_Ganancias()) {
			VentanaPrincipal.getPanelListaFacturaciones().setVisible(false);
			VentanaPrincipal.getPanelCalculoGanancias().setVisible(true);	
			
			CalculoGanancias.listarGanancias(BbddCalculoGanancias.listarCalculoGanancias());
			CalculoGanancias.getLbl_Calculo_Ganancias().setText(String.valueOf(BbddCalculoGanancias.sumaGanancias()));
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
		if (e.getSource() == ListaFacturaciones.getBtn_Calcular_Ganancias()) {
			ListaFacturaciones.getBtn_Calcular_Ganancias().setBackground(VentanaPrincipal.getAzulOscuro());
			ListaFacturaciones.getBtn_Calcular_Ganancias().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == ListaFacturaciones.getBtn_Ver()) {
			ListaFacturaciones.getBtn_Ver().setBackground(VentanaPrincipal.getAzulOscuro());
			ListaFacturaciones.getBtn_Ver().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == ListaFacturaciones.getBtn_Volver()) {
			ListaFacturaciones.getBtn_Volver().setBackground(VentanaPrincipal.getAzulOscuro());
			ListaFacturaciones.getBtn_Volver().setForeground(VentanaPrincipal.getAzulClaro());;
		}
	}

	@Override
	public void mouseExited(MouseEvent e) { //al salir el raton de encima
		if (e.getSource() == ListaFacturaciones.getBtn_Calcular_Ganancias()) {
			ListaFacturaciones.getBtn_Calcular_Ganancias().setBackground(VentanaPrincipal.getAzulClaro());
			ListaFacturaciones.getBtn_Calcular_Ganancias().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == ListaFacturaciones.getBtn_Ver()) {
			ListaFacturaciones.getBtn_Ver().setBackground(VentanaPrincipal.getAzulClaro());
			ListaFacturaciones.getBtn_Ver().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == ListaFacturaciones.getBtn_Volver()) {
			ListaFacturaciones.getBtn_Volver().setBackground(VentanaPrincipal.getAzulClaro());
			ListaFacturaciones.getBtn_Volver().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
	}
		
}
