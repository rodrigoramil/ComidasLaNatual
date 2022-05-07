package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.Vista_Menu_Principal;

public class Controlador_Menu_Principal2 implements ActionListener {
	
	
	
	private Vista_Menu_Principal vistaMenuPrincipal;



	public Controlador_Menu_Principal2(Vista_Menu_Principal vista_Menu_Principal) {
		this.vistaMenuPrincipal = vista_Menu_Principal;
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vistaMenuPrincipal.getBtn_Ventas()) {
			
		}
		
		if (e.getSource() == vistaMenuPrincipal.getBtn_Recetario()) {
			
		}
		
		if (e.getSource() == vistaMenuPrincipal.getBtn_Almacen()) {
			
		}
		
		if (e.getSource() == vistaMenuPrincipal.getBtn_Contabilidad()) {
			
		}
		
		if (e.getSource() == vistaMenuPrincipal.getBtn_Gestion_Usuario()) {
			
		}
		
		if (e.getSource() == vistaMenuPrincipal.getBtn_Cerrar_Sesion()) {
			
		}
	
	
	
	}

}
