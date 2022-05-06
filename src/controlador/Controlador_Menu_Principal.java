package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.VentanaPrincipal;
import vista.Vista_Menu_Principal;

public class Controlador_Menu_Principal implements ActionListener {
	
	
	
	private Vista_Menu_Principal vistaMenuPrincipal;
	
	public Controlador_Menu_Principal(Vista_Menu_Principal vista_Menu_Principal) {
		this.vistaMenuPrincipal = vista_Menu_Principal;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Vista_Menu_Principal.getBtn_Ventas()) {
			
		}
		
		if (e.getSource() == Vista_Menu_Principal.getBtn_Recetario()) {
			
		}
		
		if (e.getSource() == Vista_Menu_Principal.getBtn_Almacen()) {
			
		}
		
		if (e.getSource() == Vista_Menu_Principal.getBtn_Contabilidad()) {
			
		}
		
		if (e.getSource() == Vista_Menu_Principal.getBtn_Gestion_Usuario()) {
			
		}
		
		if (e.getSource() == Vista_Menu_Principal.getBtn_Cerrar_Sesion()) {
			VentanaPrincipal.getPanelLogin().setVisible(true);
			VentanaPrincipal.getPanelMenuPrincipal().setVisible(false);
		}
	
	
	
	}

}
