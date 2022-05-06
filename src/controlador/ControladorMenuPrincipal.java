package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VentanaPrincipal;
import vista.MenuPrincipal;

public class ControladorMenuPrincipal implements ActionListener {
	
	
	
	private MenuPrincipal panelMenuPrincipal;
	
	public ControladorMenuPrincipal(MenuPrincipal panelMenuPrincipal) {
		this.panelMenuPrincipal = panelMenuPrincipal;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == MenuPrincipal.getBtn_Ventas()) {
			
		}
		
		if (e.getSource() == MenuPrincipal.getBtn_Recetario()) {
			
		}
		
		if (e.getSource() == MenuPrincipal.getBtn_Almacen()) {
			
		}
		
		if (e.getSource() == MenuPrincipal.getBtn_Contabilidad()) {
			
		}
		
		if (e.getSource() == MenuPrincipal.getBtn_Gestion_Usuario()) {
			
		}
		
		if (e.getSource() == MenuPrincipal.getBtn_Cerrar_Sesion()) {
			VentanaPrincipal.getPanelLogin().setVisible(true);
			VentanaPrincipal.getPanelMenuPrincipal().setVisible(false);
		}
	
	
	
	}

}
