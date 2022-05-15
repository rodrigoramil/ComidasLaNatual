package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import vista.GestionPedidos;
import vista.Pedido;
import vista.VentanaPrincipal;

public class ControladorPedido  implements ActionListener, MouseListener {

	private Pedido panelPedido;
	private int cantidad;

	public ControladorPedido (Pedido panelPedido) {
		this.panelPedido = panelPedido;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == Pedido.getBtn_Volver()) {			
			VentanaPrincipal.getPanelGestionPedidos().setVisible(true);
			VentanaPrincipal.getPanelPedido().setVisible(false);
			GestionPedidos.getBtn_Editar_Cliente().setEnabled(false);
			GestionPedidos.getBtn_Ver_Pedido().setEnabled(false);
		}
		if (e.getSource() == Pedido.getBtn_Guardar()) {
			VentanaPrincipal.getPanelGestionPedidos().setVisible(true);
			VentanaPrincipal.getPanelPedido().setVisible(false);
			GestionPedidos.getBtn_Editar_Cliente().setEnabled(false);
			GestionPedidos.getBtn_Ver_Pedido().setEnabled(false);
		}
		if (e.getSource() == Pedido.getBtn_Nuevo()) {
			VentanaPrincipal.getPanelPedido().setVisible(false);
			VentanaPrincipal.getPanelBuscarComidaBebida().setVisible(true);	
		}
		
		if (e.getSource() == Pedido.getBtn_Modificar()) {
			cantidad=0;
			String respuesta = JOptionPane.showInputDialog("¿Que cantidad quieres introducir?");
			if (respuesta != null) {
				if (!respuesta.equals("")) {
					try {	
						cantidad = Integer.parseInt(respuesta);
					} catch (NumberFormatException e2) {
						cantidad=1;
						JOptionPane.showMessageDialog(panelPedido, "No ha introducido un número, por defecto será uno");
					}
				}
				else {
					cantidad=1;
				}
			}
			System.out.println("cantidad modificada --> "+cantidad);
			
			
			
			
			
			
		}
		
		if (e.getSource() == Pedido.getBtn_Eliminar()) {
			
		}
		
		if (e.getSource() == Pedido.getBtn_Facturar()) {
			VentanaPrincipal.getPanelPedido().setVisible(false);
			VentanaPrincipal.getPanelFacturar().setVisible(true);	
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
