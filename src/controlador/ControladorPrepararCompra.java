package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PrinterException;
import javax.swing.JOptionPane;

import vista.Almacen;
import vista.PrepararCompra;
import vista.VentanaPrincipal;

public class ControladorPrepararCompra implements ActionListener, MouseListener  {

	private PrepararCompra panelPrepararCompra;
	
	public ControladorPrepararCompra(PrepararCompra panelPrepararCompra) {
		this.panelPrepararCompra = panelPrepararCompra;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == PrepararCompra.getBtn_volver()) {
			VentanaPrincipal.getPanelAlmacen().setVisible(true);
			VentanaPrincipal.getPanelPrepararCompra().setVisible(false);
			Almacen.getBtn_Modificar().setEnabled(false);
		}
		
		if (e.getSource() == PrepararCompra.getBtn_Guardar()) {
			VentanaPrincipal.getPanelAlmacen().setVisible(true);
			VentanaPrincipal.getPanelPrepararCompra().setVisible(false);
			Almacen.getBtn_Modificar().setEnabled(false);
		}
		
		if (e.getSource() == PrepararCompra.getBtn_Imprimir()) {
			
			try {				
				panelPrepararCompra.getTabla().print();
				
			} catch (PrinterException e1) {
				JOptionPane.showMessageDialog(panelPrepararCompra, "Error al imprimir la lista de la compra");
				System.out.println("Error al imprimir la lista de la compra");
				e1.printStackTrace();
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
