package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import modelo_bbdd.BbddVentas;
import vista.Cliente;
import vista.GestionPedidos;
import vista.MenuPrincipal;
import vista.VentanaPrincipal;

public class ControladorCliente implements ActionListener, MouseListener{

	private Cliente panelCliente;

	public ControladorCliente(Cliente panelCliente) {
		this.panelCliente = panelCliente;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == Cliente.getBtn_volver()) {
			VentanaPrincipal.getPanelCliente().setVisible(false);
			VentanaPrincipal.getPanelGestionPedidos().setVisible(true);
			GestionPedidos.getListaCliente().clearSelection();
			GestionPedidos.getBtn_Editar_Cliente().setEnabled(false);
		}
		
		if (e.getSource() == Cliente.getBtn_Aceptar()) {			
			GestionPedidos.getBtn_Editar_Cliente().setEnabled(false);
			boolean nuevoCliente = ControladorGestionPedidos.getNuevoCliente(); //  -> true		
			String cajaTextoTlf="";
			String cajaTextoNombre = Cliente.getTfd_nombre().getText();
			cajaTextoTlf = Cliente.getTfd_telefono().getText();
			
			if (nuevoCliente) {				
				System.out.println("Nuevo Cliente");		
				try {
					BbddVentas.insertarCliente(cajaTextoNombre, cajaTextoTlf);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ControladorGestionPedidos.setMesa(false);
				GestionPedidos.creaListaClientes();
				ControladorGestionPedidos.setNuevoCliente(false);				
			} else {
				System.out.println("Editar Cliente");
				System.out.println(BbddVentas.getArrayClientes());
				System.out.println("Id: "+BbddVentas.getArrayClientes().get(GestionPedidos.clienteSeleccionado()).getId());
				System.out.println("Nombre: "+BbddVentas.getArrayClientes().get(GestionPedidos.clienteSeleccionado()).getNombre());
				
				String nombre = BbddVentas.getArrayClientes().get(GestionPedidos.clienteSeleccionado()).getNombre();
				String tlf = BbddVentas.getArrayClientes().get(GestionPedidos.clienteSeleccionado()).getTelefono();
				Cliente.getTfd_nombre().setText(nombre);
				Cliente.getTfd_telefono().setText(tlf);				
				
				BbddVentas.editarCliente(BbddVentas.getArrayClientes().get(GestionPedidos.clienteSeleccionado()).getId(), cajaTextoNombre, cajaTextoTlf);
				GestionPedidos.creaListaClientes();
			}
			
			VentanaPrincipal.getPanelCliente().setVisible(false);
			VentanaPrincipal.getPanelGestionPedidos().setVisible(true);
	//		BbddVentas.listarClientes();
			GestionPedidos.getListaCliente().clearSelection();
			

		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {

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
		if (e.getSource() == Cliente.getBtn_Aceptar()) {
			Cliente.getBtn_Aceptar().setBackground(VentanaPrincipal.getAzulOscuro());
			Cliente.getBtn_Aceptar().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == Cliente.getBtn_volver()) {
			Cliente.getBtn_volver().setBackground(VentanaPrincipal.getAzulOscuro());
			Cliente.getBtn_volver().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == Cliente.getBtn_Aceptar()) {
			Cliente.getBtn_Aceptar().setBackground(VentanaPrincipal.getAzulClaro());
			Cliente.getBtn_Aceptar().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == Cliente.getBtn_volver()) {
			Cliente.getBtn_volver().setBackground(VentanaPrincipal.getAzulClaro());
			Cliente.getBtn_volver().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		
	}
	

}
