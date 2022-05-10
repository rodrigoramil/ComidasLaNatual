package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PrinterException;

import javax.swing.JOptionPane;

import vista.CalculoGastos;
import vista.VentanaPrincipal;

public class ControladorCalculoGastos implements ActionListener, MouseListener  {

	private CalculoGastos panelCalculoGastos;
	
	public ControladorCalculoGastos(CalculoGastos panelCalculoGastos) {
		this.panelCalculoGastos = panelCalculoGastos;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == CalculoGastos.getBtn_Volver()) {
			VentanaPrincipal.getPanelCalculoGastos().setVisible(false);
			VentanaPrincipal.getPanelListaGastos().setVisible(true);			
		}
		
		if (e.getSource() == CalculoGastos.getBtn_Imprimir()) {
			// Imprime solo la Tabla, debería imprimir el panel completo			
			try {				
				panelCalculoGastos.getTable().print();				
			} catch (PrinterException e1) {
				JOptionPane.showMessageDialog(panelCalculoGastos, "Error al imprimir el Detalle del gasto");
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

		
	}

	@Override
	public void mouseExited(MouseEvent e) { //al salir el raton de encima

		
	}
	
}
