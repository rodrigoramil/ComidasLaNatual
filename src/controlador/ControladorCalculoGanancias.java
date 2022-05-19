package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PrinterException;

import javax.swing.JOptionPane;

import vista.CalculoGanancias;
import vista.MenuPrincipal;
import vista.VentanaPrincipal;

public class ControladorCalculoGanancias implements ActionListener, MouseListener {

	private CalculoGanancias panelCalculoGanancias;
	
	public ControladorCalculoGanancias(CalculoGanancias panelCalculoGanancias) {
		this.panelCalculoGanancias = panelCalculoGanancias;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == CalculoGanancias.getBtn_Volver()) {
			VentanaPrincipal.getPanelCalculoGanancias().setVisible(false);
			VentanaPrincipal.getPanelListaFacturaciones().setVisible(true);			
		}
		
		if (e.getSource() == CalculoGanancias.getBtn_Imprimir()) {
			
			// Imprime solo la Tabla, debería imprimir el panel completo
			
			try {				
				CalculoGanancias.getTabla().print();				
			} catch (PrinterException e1) {
				JOptionPane.showMessageDialog(panelCalculoGanancias, "Error al imprimir el Detalle del gasto");
			}
			
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
		if (e.getSource() == CalculoGanancias.getBtn_Imprimir()) {
			CalculoGanancias.getBtn_Imprimir().setBackground(VentanaPrincipal.getAzulOscuro());
			CalculoGanancias.getBtn_Imprimir().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == CalculoGanancias.getBtn_Volver()) {
			CalculoGanancias.getBtn_Volver().setBackground(VentanaPrincipal.getAzulOscuro());
			CalculoGanancias.getBtn_Volver().setForeground(VentanaPrincipal.getAzulClaro());;
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == CalculoGanancias.getBtn_Imprimir()) {
			CalculoGanancias.getBtn_Imprimir().setBackground(VentanaPrincipal.getAzulClaro());
			CalculoGanancias.getBtn_Imprimir().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == CalculoGanancias.getBtn_Volver()) {
			CalculoGanancias.getBtn_Volver().setBackground(VentanaPrincipal.getAzulClaro());
			CalculoGanancias.getBtn_Volver().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		
	}	
}
