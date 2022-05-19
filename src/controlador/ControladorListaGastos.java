package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import vista.ListaGastos;
import vista.MenuPrincipal;
import vista.VentanaPrincipal;

public class ControladorListaGastos implements ActionListener, MouseListener{

	
private ListaGastos panelListaGastos;
	
	public ControladorListaGastos(ListaGastos panelListaGastos) {
		this.panelListaGastos = panelListaGastos;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == ListaGastos.getBtn_Volver()) {
			VentanaPrincipal.getPanelListaGastos().setVisible(false);
			VentanaPrincipal.getPanelContabilidad().setVisible(true);			
		}
		
		if (e.getSource() == ListaGastos.getBtn_Ver()) {
			VentanaPrincipal.getPanelListaGastos().setVisible(false);
			VentanaPrincipal.getPanelDetalleGasto().setVisible(true);
			
		}
		
		if (e.getSource() == ListaGastos.getBtn_Calcular_Gastos()) {
			VentanaPrincipal.getPanelListaGastos().setVisible(false);
			VentanaPrincipal.getPanelCalculoGastos().setVisible(true);
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
		if (e.getSource() == ListaGastos.getBtn_Calcular_Gastos()) {
			ListaGastos.getBtn_Calcular_Gastos().setBackground(VentanaPrincipal.getAzulOscuro());
			ListaGastos.getBtn_Calcular_Gastos().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == ListaGastos.getBtn_Ver()) {
			ListaGastos.getBtn_Ver().setBackground(VentanaPrincipal.getAzulOscuro());
			ListaGastos.getBtn_Ver().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == ListaGastos.getBtn_Volver()) {
			ListaGastos.getBtn_Volver().setBackground(VentanaPrincipal.getAzulOscuro());
			ListaGastos.getBtn_Volver().setForeground(VentanaPrincipal.getAzulClaro());;
		}
	}

	@Override
	public void mouseExited(MouseEvent e) { //al salir el raton de encima
		if (e.getSource() == ListaGastos.getBtn_Calcular_Gastos()) {
			ListaGastos.getBtn_Calcular_Gastos().setBackground(VentanaPrincipal.getAzulClaro());
			ListaGastos.getBtn_Calcular_Gastos().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == ListaGastos.getBtn_Ver()) {
			ListaGastos.getBtn_Ver().setBackground(VentanaPrincipal.getAzulClaro());
			ListaGastos.getBtn_Ver().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == ListaGastos.getBtn_Volver()) {
			ListaGastos.getBtn_Volver().setBackground(VentanaPrincipal.getAzulClaro());
			ListaGastos.getBtn_Volver().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
	}	
}
