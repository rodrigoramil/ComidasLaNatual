package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PrinterException;

import javax.swing.JOptionPane;

import vista.DetalleFactura;
import vista.VentanaPrincipal;


public class ControladorDetalleFactura implements ActionListener, MouseListener{

	private DetalleFactura panelDetalleFactura;
	
	public ControladorDetalleFactura(DetalleFactura panelDetalleFactura) {
		this.panelDetalleFactura = panelDetalleFactura;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == DetalleFactura.getBtn_Volver()) {
			VentanaPrincipal.getPanelDetalleFactura().setVisible(false);
			VentanaPrincipal.getPanelListaFacturaciones().setVisible(true);			
		}
		if (e.getSource() == DetalleFactura.getBtn_Imprimir()) {
			// Imprime solo la Tabla, debería imprimir el panel completo			
			try {				
				panelDetalleFactura.getTable().print();				
			} catch (PrinterException e1) {
				JOptionPane.showMessageDialog(panelDetalleFactura, "Error al imprimir el Detalle del gasto");
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
