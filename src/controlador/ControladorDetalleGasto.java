package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PrinterException;

import javax.swing.JOptionPane;

import vista.DetalleGasto;
import vista.MenuPrincipal;
import vista.VentanaPrincipal;

public class ControladorDetalleGasto implements ActionListener, MouseListener{

	private DetalleGasto panelDetalleGasto;
	
	public ControladorDetalleGasto(DetalleGasto panelDetalleGasto) {
		this.panelDetalleGasto = panelDetalleGasto;
	}	


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == DetalleGasto.getBtn_Volver()) {
			VentanaPrincipal.getPanelDetalleGasto().setVisible(false);
			VentanaPrincipal.getPanelListaGastos().setVisible(true);			
		}
		
		if (e.getSource() == DetalleGasto.getBtn_Guardar()) {
			VentanaPrincipal.getPanelDetalleGasto().setVisible(false);
			VentanaPrincipal.getPanelListaGastos().setVisible(true);
		}
		
		if (e.getSource() == DetalleGasto.getBtn_Imprimir()) {
			
			// Imprime solo la Tabla, debería imprimir el panel completo	
			
			try {				
			DetalleGasto.getTabla().print();				
			} catch (PrinterException e1) {
				JOptionPane.showMessageDialog(panelDetalleGasto, "Error al imprimir el Detalle del gasto");
			}
			
	

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
		if (e.getSource() == DetalleGasto.getBtn_Guardar()) {
			DetalleGasto.getBtn_Guardar().setBackground(VentanaPrincipal.getAzulOscuro());
			DetalleGasto.getBtn_Guardar().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == DetalleGasto.getBtn_Imprimir()) {
			DetalleGasto.getBtn_Imprimir().setBackground(VentanaPrincipal.getAzulOscuro());
			DetalleGasto.getBtn_Imprimir().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == DetalleGasto.getBtn_Volver()) {
			DetalleGasto.getBtn_Volver().setBackground(VentanaPrincipal.getAzulOscuro());
			DetalleGasto.getBtn_Volver().setForeground(VentanaPrincipal.getAzulClaro());;
		}
	}

	@Override
	public void mouseExited(MouseEvent e) { //al salir el raton de encima
		if (e.getSource() == DetalleGasto.getBtn_Guardar()) {
			DetalleGasto.getBtn_Guardar().setBackground(VentanaPrincipal.getAzulClaro());
			DetalleGasto.getBtn_Guardar().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == DetalleGasto.getBtn_Imprimir()) {
			DetalleGasto.getBtn_Imprimir().setBackground(VentanaPrincipal.getAzulClaro());
			DetalleGasto.getBtn_Imprimir().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == DetalleGasto.getBtn_Volver()) {
			DetalleGasto.getBtn_Volver().setBackground(VentanaPrincipal.getAzulClaro());
			DetalleGasto.getBtn_Volver().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
	}
	
}
