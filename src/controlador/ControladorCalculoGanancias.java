package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import vista.CalculoGanancias;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}	
}
