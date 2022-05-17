package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.ModeloReceta;
import modelo_bbdd.BbddReceta;
import modelo_bbdd.BbddRecetario;
import vista.Receta;
import vista.Recetario;
import vista.VentanaPrincipal;

public class ControladorRecetario implements ActionListener, MouseListener  {
	

	
	private Recetario panelRecetario;
	private static boolean verDesdeRecetario;
	
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
			
			botonVerReceta ();
			
			Receta.listarReceta(BbddReceta.listarRecetas());

			if (BbddReceta.getArrayReceta().isEmpty()) {
				Receta.getTexto_elaboracion().setText("");
				Receta.getPrecio_receta().setText("");
			}

		}
		
		if (e.getSource() == Recetario.getBtn_nueva_receta()) {
			VentanaPrincipal.getPanelRecetario().setVisible(false);
			VentanaPrincipal.getPanelReceta().setVisible(true);
			Receta.listarReceta(new ArrayList<ModeloReceta>());
			Receta.getNombre_receta().setText("");
			Receta.getTexto_elaboracion().setText("");
			Receta.getPrecio_receta().setText("");
		}		
		
		if (e.getSource() == Recetario.getBtn_modificar_receta()) {
			VentanaPrincipal.getPanelRecetario().setVisible(false);
			VentanaPrincipal.getPanelReceta().setVisible(true);

			Receta.listarReceta(BbddReceta.listarRecetas());
	
			if (BbddReceta.getArrayReceta().isEmpty()) {
				Receta.getTexto_elaboracion().setText("");
				Receta.getPrecio_receta().setText("");
			}

		}
		
		
		if (e.getSource() == Recetario.getBtn_cambiar_estado()) {
	        String[] opcionEscogida = {"Disponible", "NO disponible", "En elaboración"};
	        int x = JOptionPane.showOptionDialog(null, 
	        		"¿Que estado de disponibilidad deseas cambiar el estado esta receta?",
	                "Estado de la receta",
	                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionEscogida, opcionEscogida[0]);
	        
	        BbddRecetario.setIdDisponibilidad(x+1);
	        
	        System.out.println(x+1); // 0="Disponible", 1="NO disponible", 2="En elaboración", -1=cancelar en X

	        BbddRecetario.updateDisponibilidadReceta();
	        Recetario.listarRecetas(BbddRecetario.getarrayRecetario());
	        
		}		

		
	}
	
	
	
	
	
	
	
	


	@Override
	public void mouseClicked(MouseEvent e) { // Al hacer clic con el raton

		
	}

	@Override
	public void mousePressed(MouseEvent e) { // Al pulsar raton
		
		if (e.getSource() == Recetario.getTabla()) {			
			Recetario.datoSeleccionadoTabla();
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
		
	
	public void botonVerReceta () {
		Receta.getBtn_guardar().setEnabled(false);
		Receta.getBtn_borrar_ingrediente().setEnabled(false);
		Receta.getBtn_modificar_cantidad().setEnabled(false);
		Receta.getBtn_nuevo_ingrediente().setEnabled(false);
		verDesdeRecetario = true;
	}

	public static boolean isVerDesdeRecetario() {
		return verDesdeRecetario;
	}

	public static void setVerDesdeRecetario(boolean verDesdeRecetario) {
		ControladorRecetario.verDesdeRecetario = verDesdeRecetario;
	}
	
}
