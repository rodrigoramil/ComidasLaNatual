package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.BbddVentas;
import vista.Cliente;
import vista.GestionPedidos;
import vista.Pedido;
import vista.VentanaPrincipal;

public class ControladorGestionPedidos implements ActionListener, MouseListener  {

	private GestionPedidos panelGestionPedidos;
	private static boolean nuevoCliente = false;
	
	public ControladorGestionPedidos(GestionPedidos panelGestionPedidos) {
		this.panelGestionPedidos = panelGestionPedidos;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == GestionPedidos.getBtn_Nuevo_Cliente()) {
			VentanaPrincipal.getPanelGestionPedidos().setVisible(false);
			VentanaPrincipal.getPanelCliente().setVisible(true);

			Cliente.getTfd_nombre().setText("");
			Cliente.getTfd_telefono().setText("");
			GestionPedidos.getListaCliente().clearSelection();
			nuevoCliente = true;
			
			
			for (int i = 0; i < BbddVentas.getArrayClientes().size(); i++) {
				
				
				
				
			}
			
			
		}
		if (e.getSource() == GestionPedidos.getBtn_Editar_Cliente()) {
			
				VentanaPrincipal.getPanelGestionPedidos().setVisible(false);
				VentanaPrincipal.getPanelCliente().setVisible(true);
				nuevoCliente = false;
			try {
				for (int i = 0; i < BbddVentas.getArrayClientes().size(); i++) {

					/**
					 * Nota: hay que restarle 1 al Id del cliente porque empieza en 1 y el array de Clientes empieza desde 0
					 * y hay que restarle también las 8 mesas de que se encuentran al inicio del array de clientes --> TOTAL -9
					 */	
					int clienteSelecionado = GestionPedidos.clienteSeleccionado();
					int clienteBBDD = BbddVentas.getArrayClientes().get(i).getId()-9;					
					
					if (clienteSelecionado==clienteBBDD) {	
						System.out.println("clienteSelecionado -> "+clienteSelecionado+" clienteBBDD -> "+clienteBBDD); // <-- BORRAR
						Cliente.getTfd_nombre().setText(BbddVentas.getArrayClientes().get(i).getNombre());
						Cliente.getTfd_telefono().setText(BbddVentas.getArrayClientes().get(i).getTelefono());
					}
				}											
			} catch (NullPointerException errorSelectorVacio) {				
				JOptionPane.showMessageDialog(panelGestionPedidos, "Selecciona cliente a editar");
			}			
		}
		
		
		if (e.getSource() == GestionPedidos.getBtn_Mesa_1()) {		
			VentanaPrincipal.getPanelGestionPedidos().setVisible(false);
			VentanaPrincipal.getPanelPedido().setVisible(true);
			
			GestionPedidos.getListaCliente().clearSelection();
			System.out.println(BbddVentas.getArrayClientes().get(0).getNombre());	
			Pedido.getLbl_Num_Mesa().setText(BbddVentas.getArrayClientes().get(0).getNombre());
		}
		
		if (e.getSource() == GestionPedidos.getBtn_Mesa_2()) {
			VentanaPrincipal.getPanelGestionPedidos().setVisible(false);
			VentanaPrincipal.getPanelPedido().setVisible(true);
			
			GestionPedidos.getListaCliente().clearSelection();
			System.out.println(BbddVentas.getArrayClientes().get(1).getNombre());
			Pedido.getLbl_Num_Mesa().setText(BbddVentas.getArrayClientes().get(1).getNombre());
		}
		
		if (e.getSource() == GestionPedidos.getBtn_Mesa_3()) {
			VentanaPrincipal.getPanelGestionPedidos().setVisible(false);
			VentanaPrincipal.getPanelPedido().setVisible(true);
			
			GestionPedidos.getListaCliente().clearSelection();
			System.out.println(BbddVentas.getArrayClientes().get(2).getNombre());
			Pedido.getLbl_Num_Mesa().setText(BbddVentas.getArrayClientes().get(2).getNombre());
		}
		
		if (e.getSource() == GestionPedidos.getBtn_Mesa_4()) {
			VentanaPrincipal.getPanelGestionPedidos().setVisible(false);
			VentanaPrincipal.getPanelPedido().setVisible(true);
			
			GestionPedidos.getListaCliente().clearSelection();
			System.out.println(BbddVentas.getArrayClientes().get(3).getNombre());
			Pedido.getLbl_Num_Mesa().setText(BbddVentas.getArrayClientes().get(3).getNombre());
		}
		
		if (e.getSource() == GestionPedidos.getBtn_Mesa_5()) {
			VentanaPrincipal.getPanelGestionPedidos().setVisible(false);
			VentanaPrincipal.getPanelPedido().setVisible(true);
			
			GestionPedidos.getListaCliente().clearSelection();
			System.out.println(BbddVentas.getArrayClientes().get(4).getNombre());
			Pedido.getLbl_Num_Mesa().setText(BbddVentas.getArrayClientes().get(4).getNombre());
		}
		
		if (e.getSource() == GestionPedidos.getBtn_Mesa_6()) {
			VentanaPrincipal.getPanelGestionPedidos().setVisible(false);
			VentanaPrincipal.getPanelPedido().setVisible(true);
			
			GestionPedidos.getListaCliente().clearSelection();
			System.out.println(BbddVentas.getArrayClientes().get(5).getNombre());			
			Pedido.getLbl_Num_Mesa().setText(BbddVentas.getArrayClientes().get(5).getNombre());
		}
		
		if (e.getSource() == GestionPedidos.getBtn_Mesa_7()) {
			VentanaPrincipal.getPanelGestionPedidos().setVisible(false);
			VentanaPrincipal.getPanelPedido().setVisible(true);
			
			GestionPedidos.getListaCliente().clearSelection();
			System.out.println(BbddVentas.getArrayClientes().get(6).getNombre());
			Pedido.getLbl_Num_Mesa().setText(BbddVentas.getArrayClientes().get(6).getNombre());
		}
		
		if (e.getSource() == GestionPedidos.getBtn_Mesa_8()) {
			VentanaPrincipal.getPanelGestionPedidos().setVisible(false);
			VentanaPrincipal.getPanelPedido().setVisible(true);
			
			GestionPedidos.getListaCliente().clearSelection();
			System.out.println(BbddVentas.getArrayClientes().get(7).getNombre());
			Pedido.getLbl_Num_Mesa().setText(BbddVentas.getArrayClientes().get(7).getNombre());
		}
		
		if (e.getSource() == GestionPedidos.getBtn_Ver_Pedido()) {
			VentanaPrincipal.getPanelGestionPedidos().setVisible(false);
			VentanaPrincipal.getPanelPedido().setVisible(true);
			Pedido.getLbl_Num_Mesa().setText(BbddVentas.getArrayClientes().get(8).getNombre());
		}
		
		if (e.getSource() == GestionPedidos.getBtn_volver()) {
			VentanaPrincipal.getPanelGestionPedidos().setVisible(false);
			VentanaPrincipal.getPanelMenuPrincipal().setVisible(true);
			GestionPedidos.getListaCliente().clearSelection();
			/*
			// ********* BORRAR ************
			for (int i = 0; i < BbddVentas.getArrayClientes().size(); i++) {
				
				System.out.println(i+" -> "+BbddVentas.getArrayClientes().get(i).getNombre());
				
				int clienteBBDD = BbddVentas.getArrayClientes().get(i).getId()-1;					
				System.out.println(clienteBBDD+" -> "+BbddVentas.getArrayClientes().get(clienteBBDD).getNombre());
			}
			// ********* BORRAR ************
			*/
		}
		
	}


	@Override
	public void mouseClicked(MouseEvent e) { // Al hacer clic con el raton

		
	}

	@Override
	public void mousePressed(MouseEvent e) { // Al pulsar raton
		if (!GestionPedidos.getListaCliente().isSelectionEmpty()) {
			GestionPedidos.getBtn_Editar_Cliente().setEnabled(true);
		}
		


		
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

	public static boolean getNuevoCliente() {
		return nuevoCliente;
	}

	public static void setNuevoCliente(boolean nuevoCliente) {
		ControladorGestionPedidos.nuevoCliente = nuevoCliente;
	}
	
	
}
	
	
	

