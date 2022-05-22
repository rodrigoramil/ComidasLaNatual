package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.ModeloReceta;
import modelo_bbdd.BbddReceta;
import modelo_bbdd.BbddRecetario;
import vista.GestionPedidos;
import vista.MenuPrincipal;
import vista.Receta;
import vista.Recetario;
import vista.VentanaPrincipal;

public class ControladorRecetario implements ActionListener, MouseListener  {
	

	
	private Recetario panelRecetario;
	private static boolean listarTodo = false;
	private static boolean nuevaReceta;
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
		
		if (e.getSource() == Recetario.getBtn_listar_todo()) {
			listarTodo = true;
			Recetario.listarRecetas(BbddRecetario.listarRecetas());
		}
		
		if (e.getSource() == Recetario.getBtn_buscar()) {
			System.out.println("buscarRecetas");
		}
		
		if (e.getSource() == Recetario.getBtn_ver_recetas()) {
			VentanaPrincipal.getPanelRecetario().setVisible(false);
			VentanaPrincipal.getPanelReceta().setVisible(true);
			
			botonVerReceta ();			
			Receta.listarReceta(BbddReceta.listarRecetas());		

			if (BbddReceta.getArrayReceta()==null) {
				Receta.getTexto_elaboracion().setText("");
				Receta.getPrecio_receta().setText("");
			} else {
				Receta.getTexto_elaboracion().setText(BbddReceta.getElaboracion());
				Receta.getPrecio_receta().setText(BbddReceta.getPrecioVenta());
			}

		}
		
		if (e.getSource() == Recetario.getBtn_nueva_receta()) {
			VentanaPrincipal.getPanelRecetario().setVisible(false);
			VentanaPrincipal.getPanelReceta().setVisible(true);
			Receta.listarReceta(new ArrayList<ModeloReceta>());
			Receta.getNombre_receta().setText("");
			Receta.getTexto_elaboracion().setText("");
			Receta.getPrecio_receta().setText("");
			Receta.getBtn_nuevo_ingrediente().setEnabled(false);
			Receta.getBtn_modificar_cantidad().setEnabled(false);
			Receta.getBtn_borrar_ingrediente().setEnabled(false);
			nuevaReceta = true;
		}		
		
		if (e.getSource() == Recetario.getBtn_modificar_receta()) {
			VentanaPrincipal.getPanelRecetario().setVisible(false);
			VentanaPrincipal.getPanelReceta().setVisible(true);
			Receta.getBtn_nuevo_ingrediente().setEnabled(true);
			Receta.getBtn_modificar_cantidad().setEnabled(true);
			Receta.getBtn_borrar_ingrediente().setEnabled(true);
			nuevaReceta = false;
			Receta.listarReceta(BbddReceta.listarRecetas());
			
			if (BbddReceta.getArrayReceta()==null) {
				Receta.getTexto_elaboracion().setText("");
				Receta.getPrecio_receta().setText("");
			} else {
				Receta.getTexto_elaboracion().setText(BbddReceta.getElaboracion());
				Receta.getPrecio_receta().setText(BbddReceta.getPrecioVenta());
			}

		}
		if (e.getSource() == Recetario.getBtn_eliminar_receta()) {
			
			 // si = 0 / no = 1 / cancelar = 2 / X = -1
			int respuestaEliminar = JOptionPane.showConfirmDialog(panelRecetario, "¿Esta seguro de que quiere eliminar la receta selecionada?");

			if (respuestaEliminar == 0) {
				try {
					BbddRecetario.borrarReceta();
					Recetario.listarRecetas(BbddRecetario.listarRecetas());				
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(panelRecetario, "Error al realizar la accion con la Base de Datos");
					e1.printStackTrace();
				}
			}
			

			
		}
		
		
		if (e.getSource() == Recetario.getBtn_cambiar_estado()) {
	        String[] opcionEscogida = {"Disponible", "NO disponible", "En elaboración"};
	        int x = JOptionPane.showOptionDialog(null, 
	        		"¿Que estado de disponibilidad deseas cambiar el estado esta receta?",
	                "Estado de la receta",
	                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionEscogida, opcionEscogida[0]);
	        
	        BbddRecetario.setIdDisponibilidad(x+1);
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
			Recetario.getBtn_modificar_receta().setEnabled(true);
			Recetario.getBtn_eliminar_receta().setEnabled(true);
		}
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) { // al no interactuar con el

		
	}

	@Override
	public void mouseEntered(MouseEvent e) { // al tener el raton encima
		if (e.getSource() == Recetario.getBtn_buscar()) {
			Recetario.getBtn_buscar().setBackground(VentanaPrincipal.getAzulOscuro());
			Recetario.getBtn_buscar().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == Recetario.getBtn_cambiar_estado()) {
			Recetario.getBtn_cambiar_estado().setBackground(VentanaPrincipal.getAzulOscuro());
			Recetario.getBtn_cambiar_estado().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == Recetario.getBtn_eliminar_receta()) {
			Recetario.getBtn_eliminar_receta().setBackground(VentanaPrincipal.getAzulOscuro());
			Recetario.getBtn_eliminar_receta().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == Recetario.getBtn_listar_todo()) {
			Recetario.getBtn_listar_todo().setBackground(VentanaPrincipal.getAzulOscuro());
			Recetario.getBtn_listar_todo().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == Recetario.getBtn_modificar_receta()) {
			Recetario.getBtn_modificar_receta().setBackground(VentanaPrincipal.getAzulOscuro());
			Recetario.getBtn_modificar_receta().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == Recetario.getBtn_nueva_receta()) {
			Recetario.getBtn_nueva_receta().setBackground(VentanaPrincipal.getAzulOscuro());
			Recetario.getBtn_nueva_receta().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == Recetario.getBtn_ver_recetas()) {
			Recetario.getBtn_ver_recetas().setBackground(VentanaPrincipal.getAzulOscuro());
			Recetario.getBtn_ver_recetas().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == Recetario.getBtn_volver()) {
			Recetario.getBtn_volver().setBackground(VentanaPrincipal.getAzulOscuro());
			Recetario.getBtn_volver().setForeground(VentanaPrincipal.getAzulClaro());;
		}
	}

	@Override
	public void mouseExited(MouseEvent e) { //al salir el raton de encima
		if (e.getSource() == Recetario.getBtn_buscar()) {
			Recetario.getBtn_buscar().setBackground(VentanaPrincipal.getAzulClaro());
			Recetario.getBtn_buscar().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == Recetario.getBtn_cambiar_estado()) {
			Recetario.getBtn_cambiar_estado().setBackground(VentanaPrincipal.getAzulClaro());
			Recetario.getBtn_cambiar_estado().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == Recetario.getBtn_eliminar_receta()) {
			Recetario.getBtn_eliminar_receta().setBackground(VentanaPrincipal.getAzulClaro());
			Recetario.getBtn_eliminar_receta().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == Recetario.getBtn_listar_todo()) {
			Recetario.getBtn_listar_todo().setBackground(VentanaPrincipal.getAzulClaro());
			Recetario.getBtn_listar_todo().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == Recetario.getBtn_modificar_receta()) {
			Recetario.getBtn_modificar_receta().setBackground(VentanaPrincipal.getAzulClaro());
			Recetario.getBtn_modificar_receta().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == Recetario.getBtn_nueva_receta()) {
			Recetario.getBtn_nueva_receta().setBackground(VentanaPrincipal.getAzulClaro());
			Recetario.getBtn_nueva_receta().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == Recetario.getBtn_ver_recetas()) {
			Recetario.getBtn_ver_recetas().setBackground(VentanaPrincipal.getAzulClaro());
			Recetario.getBtn_ver_recetas().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == Recetario.getBtn_volver()) {
			Recetario.getBtn_volver().setBackground(VentanaPrincipal.getAzulClaro());
			Recetario.getBtn_volver().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
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

	public static boolean isNuevaReceta() {
		return nuevaReceta;
	}

	public void setNuevaReceta(boolean nuevaReceta) {
		ControladorRecetario.nuevaReceta = nuevaReceta;
	}

	public static boolean isListarTodo() {
		return listarTodo;
	}

	public static void setListarTodo(boolean listarTodo) {
		ControladorRecetario.listarTodo = listarTodo;
	}
	
}
