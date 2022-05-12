package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.BbddVentas;
import vista.VentanaPrincipal;
import vista.GestionPedidos;
import vista.MenuPrincipal;
import vista.ProductosAlmacen;
import vista.Receta;
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
			GestionPedidos.getBtn_Editar_Cliente().setEnabled(false);

		}
		
		if (e.getSource() == panelMenuPrincipal.getBtn_Recetario()) {
			
			Recetario.datosReceta();
			Receta.datosIngredientes();
			ProductosAlmacen.datosIngredientes();
			
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
