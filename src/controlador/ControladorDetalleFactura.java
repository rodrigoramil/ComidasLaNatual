package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PrinterException;

import javax.swing.JOptionPane;

import vista.DetalleFactura;
import vista.MenuPrincipal;
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
				DetalleFactura.getTabla().print();				
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
		if (e.getSource() == DetalleFactura.getBtn_Imprimir()) {
			DetalleFactura.getBtn_Imprimir().setBackground(VentanaPrincipal.getAzulOscuro());
			DetalleFactura.getBtn_Imprimir().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == DetalleFactura.getBtn_Volver()) {
			DetalleFactura.getBtn_Volver().setBackground(VentanaPrincipal.getAzulOscuro());
			DetalleFactura.getBtn_Volver().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) { //al salir el raton de encima
		if (e.getSource() == DetalleFactura.getBtn_Imprimir()) {
			DetalleFactura.getBtn_Imprimir().setBackground(VentanaPrincipal.getAzulClaro());
			DetalleFactura.getBtn_Imprimir().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == DetalleFactura.getBtn_Volver()) {
			DetalleFactura.getBtn_Volver().setBackground(VentanaPrincipal.getAzulClaro());
			DetalleFactura.getBtn_Volver().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		
	}
	
	
}
