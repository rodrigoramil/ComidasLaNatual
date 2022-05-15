package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import modelo_bbdd.BbddReceta;
import vista.Receta;
import vista.Recetario;
import vista.VentanaPrincipal;

public class ControladorRecetario implements ActionListener, MouseListener  {
	

	
	private Recetario panelRecetario;
	
	public ControladorRecetario(Recetario panelRecetario) {
		this.panelRecetario = panelRecetario;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == Recetario.getBtn_volver()) {
			VentanaPrincipal.getPanelMenuPrincipal().setVisible(true);
			VentanaPrincipal.getPanelRecetario().setVisible(false);
		}
		
		if (e.getSource() == Recetario.getBtn_listadoRecetas()) {
			System.out.println("listadoRecetas");
		}
		
		if (e.getSource() == Recetario.getBtn_buscar()) {
			System.out.println("buscarRecetas");
		}
		
		if (e.getSource() == Recetario.getBtn_ver_recetas()) {
			VentanaPrincipal.getPanelRecetario().setVisible(false);
			VentanaPrincipal.getPanelReceta().setVisible(true);
			
			Receta.listarRecetas();
		}
		
		if (e.getSource() == Recetario.getBtn_nueva_receta()) {
			System.out.println("nuevaReceta");
			//implementar desabilitar boton cuando el usuario tenga rol venta
			VentanaPrincipal.getPanelRecetario().setVisible(false);
			VentanaPrincipal.getPanelReceta().setVisible(true);
			
		}		
		
		if (e.getSource() == Recetario.getBtn_modificar_receta()) {
			System.out.println("modificarReceta");
			//implementar desabilitar boton cuando el usuario tenga rol venta 
			VentanaPrincipal.getPanelRecetario().setVisible(false);
			VentanaPrincipal.getPanelReceta().setVisible(true);
		}
		
		
		if (e.getSource() == Recetario.getBtn_cambiar_estado()) {
	        String[] opcionEscogida = {"Disponible", "NO disponible", "En elaboración"};
	        int x = JOptionPane.showOptionDialog(null, 
	        		"¿Que estado de disponibilidad deseas cambiar el estado esta receta?",
	                "Estado de la receta",
	                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionEscogida, opcionEscogida[0]);
// eliminar Syso	        
	        System.out.println(x); // 0="Disponible", 1="NO disponible", 2="En elaboración", -1=cancelar en X
	        
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
