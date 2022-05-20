package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;

import modelo.ModeloReceta;
import modelo_bbdd.BbddProductosAlmacen;
import modelo_bbdd.BbddReceta;
import modelo_bbdd.BbddRecetario;
import vista.BuscarComidaBebida;
import vista.MenuPrincipal;
import vista.ProductosAlmacen;
import vista.Receta;
import vista.Recetario;
import vista.VentanaPrincipal;

public class ControladorReceta implements ActionListener, MouseListener  {

	private Receta panelReceta;
	private static int indiceSeleccionado;

	public ControladorReceta(Receta panelReceta) {
		this.panelReceta = panelReceta;
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Receta.getBtn_volver()) {
			Recetario.getBtn_modificar_receta().setEnabled(false);
			Recetario.getBtn_eliminar_receta().setEnabled(false);
			if (ControladorBuscarComidaBebida.getDesdeVentas()) {
				VentanaPrincipal.getPanelReceta().setVisible(false);
				VentanaPrincipal.getPanelBuscarComidaBebida().setVisible(true);
				ControladorBuscarComidaBebida.setDesdeVentas(false);
				
				activaBotonesReceta ();
			} else if (ControladorRecetario.isVerDesdeRecetario()) {
				ControladorRecetario.setVerDesdeRecetario(false);
				VentanaPrincipal.getPanelReceta().setVisible(false);
				VentanaPrincipal.getPanelRecetario().setVisible(true);
				activaBotonesReceta ();
			} else {
				VentanaPrincipal.getPanelReceta().setVisible(false);
				VentanaPrincipal.getPanelRecetario().setVisible(true);
			}
		}
		
		if (e.getSource() == Receta.getBtn_nuevo_ingrediente()) {

			
			VentanaPrincipal.getPanelProductosAlmacen().setVisible(true);
			VentanaPrincipal.getPanelReceta().setVisible(false);
			
			ProductosAlmacen.listarProductos(BbddProductosAlmacen.listarProductosAlmacen());
			
		}
		
		if (e.getSource() == Receta.getBtn_modificar_cantidad()) {
			float cantidad = 0;
			String respuesta = JOptionPane.showInputDialog("¿Que cantidad desea añadir?");
			if (respuesta != null) {
				if (!respuesta.equals("")) {
					try {	
						cantidad = Float.parseFloat(respuesta);
					} catch (NumberFormatException e2) {
						cantidad=1;
						JOptionPane.showMessageDialog(panelReceta, "No ha introducido un número, por defecto se a modificado a uno");
					}
				}
				else {
					cantidad=1;				
				}
				
				try {
					BbddReceta.editarIngrediente(cantidad);
					Receta.listarReceta(BbddReceta.listarRecetas());			
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(panelReceta, "Error al realizar la accion con la Base de Datos");
				}
				
			}	

		}
		
		if (e.getSource() == Receta.getBtn_borrar_ingrediente()) {
			
			 // si = 0 / no = 1 / cancelar = 2 / X = -1
			int respuestaEliminar = JOptionPane.showConfirmDialog(panelReceta, "¿Esta seguro de que quiere eliminar este ingrediente?");

			if (respuestaEliminar == 0) {
				try {
					BbddReceta.borrarIngrediente();
					Receta.listarReceta(BbddReceta.listarRecetas());				
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(panelReceta, "Error al realizar la accion con la Base de Datos");
					e1.printStackTrace();
				}
			}
			
			

		}
		
		if (e.getSource() == Receta.getBtn_guardar()) {
			Recetario.getBtn_modificar_receta().setEnabled(false);
			Recetario.getBtn_eliminar_receta().setEnabled(false);
			VentanaPrincipal.getPanelReceta().setVisible(false);
			VentanaPrincipal.getPanelRecetario().setVisible(true);
			
			try {
				if (ControladorRecetario.isNuevaReceta()) {
					BbddRecetario.insertarNuevaReceta();
					Recetario.listarRecetas(BbddRecetario.listarRecetas());					
				} else {
					BbddRecetario.modificarReceta();
					Recetario.listarRecetas(BbddRecetario.listarRecetas());
				}				
				
			} catch (SQLException e1) {				
				JOptionPane.showMessageDialog(panelReceta, "Error al realizar la accion con la Base de Datos");
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(panelReceta, "Error por no haber introducido un número en el precio");
				e1.printStackTrace();
			}

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
		if (e.getSource() == Receta.getBtn_borrar_ingrediente()) {
			Receta.getBtn_borrar_ingrediente().setBackground(VentanaPrincipal.getAzulOscuro());
			Receta.getBtn_borrar_ingrediente().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == Receta.getBtn_guardar()) {
			Receta.getBtn_guardar().setBackground(VentanaPrincipal.getAzulOscuro());
			Receta.getBtn_guardar().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == Receta.getBtn_modificar_cantidad()) {
			Receta.getBtn_modificar_cantidad().setBackground(VentanaPrincipal.getAzulOscuro());
			Receta.getBtn_modificar_cantidad().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == Receta.getBtn_nuevo_ingrediente()) {
			Receta.getBtn_nuevo_ingrediente().setBackground(VentanaPrincipal.getAzulOscuro());
			Receta.getBtn_nuevo_ingrediente().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == Receta.getBtn_volver()) {
			Receta.getBtn_volver().setBackground(VentanaPrincipal.getAzulOscuro());
			Receta.getBtn_volver().setForeground(VentanaPrincipal.getAzulClaro());;
		}
	}

	@Override
	public void mouseExited(MouseEvent e) { //al salir el raton de encima
		if (e.getSource() == Receta.getBtn_borrar_ingrediente()) {
			Receta.getBtn_borrar_ingrediente().setBackground(VentanaPrincipal.getAzulClaro());
			Receta.getBtn_borrar_ingrediente().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == Receta.getBtn_guardar()) {
			Receta.getBtn_guardar().setBackground(VentanaPrincipal.getAzulClaro());
			Receta.getBtn_guardar().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == Receta.getBtn_modificar_cantidad()) {
			Receta.getBtn_modificar_cantidad().setBackground(VentanaPrincipal.getAzulClaro());
			Receta.getBtn_modificar_cantidad().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == Receta.getBtn_nuevo_ingrediente()) {
			Receta.getBtn_nuevo_ingrediente().setBackground(VentanaPrincipal.getAzulClaro());
			Receta.getBtn_nuevo_ingrediente().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == Receta.getBtn_volver()) {
			Receta.getBtn_volver().setBackground(VentanaPrincipal.getAzulClaro());
			Receta.getBtn_volver().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
	}

	public void activaBotonesReceta () {
		
		Receta.getBtn_nuevo_ingrediente().setEnabled(true);
		Receta.getBtn_modificar_cantidad().setEnabled(true);
		Receta.getBtn_borrar_ingrediente().setEnabled(true);
		Receta.getBtn_guardar().setEnabled(true);
		
		
	}

	public static int getIndiceSeleccionado() {
		return indiceSeleccionado;
	}





}
