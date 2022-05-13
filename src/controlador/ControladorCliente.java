package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.BbddVentas;
import vista.Cliente;
import vista.GestionPedidos;
import vista.VentanaPrincipal;

public class ControladorCliente implements ActionListener{

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

			String cajaTextoNombre = Cliente.getTfd_nombre().getText();
			String cajaTextoTlf = Cliente.getTfd_telefono().getText();
			
			if (nuevoCliente) {				
				System.out.println("Nuevo Cliente");
//				System.out.println(BbddVentas.getArrayClientes().toString());
				
				BbddVentas.insertarCliente(cajaTextoNombre, cajaTextoTlf);
				
				
				
//********************************************************************************************************	
				
				// Hay que hacer un método en la clase BbddVentas que realice una sentencia SQL Insert 
				//y pasarle las dos variables cajaTextoNombre y cajaTextoTlf
				
//********************************************************************************************************				
				
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
			BbddVentas.listarClientes();
			GestionPedidos.getListaCliente().clearSelection();
			

		}
		
	}
	

}
