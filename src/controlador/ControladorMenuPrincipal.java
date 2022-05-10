package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import modelo.ModeloCliente;
import modelo.SentenciasSQL;
import vista.VentanaPrincipal;
import vista.GestionPedidos;
import vista.MenuPrincipal;
import vista.Recetario;

public class ControladorMenuPrincipal implements ActionListener {

	private MenuPrincipal panelMenuPrincipal;
	
	public ControladorMenuPrincipal(MenuPrincipal panelMenuPrincipal) {
		this.panelMenuPrincipal = panelMenuPrincipal;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource() == panelMenuPrincipal.getBtn_Ventas()) {
			GestionPedidos.creaListaClientes();			
			
			VentanaPrincipal.getPanelMenuPrincipal().setVisible(false);
			VentanaPrincipal.getPanelGestionPedidos().setVisible(true);

		}
		
		if (e.getSource() == panelMenuPrincipal.getBtn_Recetario()) {
			
			Recetario.creaListaRecetas(); 
			
			VentanaPrincipal.getPanelMenuPrincipal().setVisible(false);
			VentanaPrincipal.getPanelRecetario().setVisible(true);
		}
		
		if (e.getSource() == panelMenuPrincipal.getBtn_Almacen()) {
			VentanaPrincipal.getPanelMenuPrincipal().setVisible(false);
			VentanaPrincipal.getPanelAlmacen().setVisible(true);
		}
		
		if (e.getSource() == panelMenuPrincipal.getBtn_Contabilidad()) {
			VentanaPrincipal.getPanelMenuPrincipal().setVisible(false);
			VentanaPrincipal.getPanelContabilidad().setVisible(true);
		}
		
		if (e.getSource() == panelMenuPrincipal.getBtn_Gestion_Usuario()) {
			VentanaPrincipal.getPanelMenuPrincipal().setVisible(false);
			VentanaPrincipal.getPanelGestionUsuarios().setVisible(true);
		}
		
		if (e.getSource() == panelMenuPrincipal.getBtn_Cerrar_Sesion()) {
			VentanaPrincipal.getPanelLogin().setVisible(true);
			VentanaPrincipal.getPanelMenuPrincipal().setVisible(false);
		}
	
	
	
	}

}
