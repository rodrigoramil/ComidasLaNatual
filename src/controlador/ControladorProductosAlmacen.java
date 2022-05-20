package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import modelo_bbdd.BbddProductosAlmacen;
import modelo_bbdd.BbddReceta;
import vista.MenuPrincipal;
import vista.ProductosAlmacen;
import vista.Receta;
import vista.VentanaPrincipal;

public class ControladorProductosAlmacen  implements ActionListener, MouseListener  {

	private ProductosAlmacen panelProductosAlmacen;
	private static float cantidad;
	
	public ControladorProductosAlmacen (ProductosAlmacen panelProductosAlmacen) {
		this.panelProductosAlmacen = panelProductosAlmacen;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == ProductosAlmacen.getBtn_volver()) {
			VentanaPrincipal.getPanelProductosAlmacen().setVisible(false);
			VentanaPrincipal.getPanelReceta().setVisible(true);			
		}
		
		if (e.getSource() == ProductosAlmacen.getBtn_add_receta()) {
			VentanaPrincipal.getPanelProductosAlmacen().setVisible(false);
			VentanaPrincipal.getPanelReceta().setVisible(true);
			cantidad=0;
			String respuesta = JOptionPane.showInputDialog("¿Que cantidad desea añadir?");
			if (respuesta != null) {
				if (!respuesta.equals("")) {
					try {	
						cantidad = Float.parseFloat(respuesta);
					} catch (NumberFormatException e2) {
						cantidad=1;
						JOptionPane.showMessageDialog(panelProductosAlmacen, "No ha introducido un número, por defecto se a añadido uno");
					}
				}
				else {
					cantidad=1;				
				}				
				try {
					BbddReceta.addProductoReceta();
					Receta.listarReceta(BbddReceta.listarRecetas());			
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(panelProductosAlmacen, "Error al realizar la accion con la Base de Datos");
				}
				
			}	
			
			
	
		}
		
		if (e.getSource() == ProductosAlmacen.getBtn_todos_productos()) {
			ProductosAlmacen.listarProductos(BbddProductosAlmacen.getArrayAlmacen());
		}
		
		if (e.getSource() == ProductosAlmacen.getBtn_buscar()) {
			
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
		if (e.getSource() == ProductosAlmacen.getBtn_add_receta()) {
			ProductosAlmacen.getBtn_add_receta().setBackground(VentanaPrincipal.getAzulOscuro());
			ProductosAlmacen.getBtn_add_receta().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == ProductosAlmacen.getBtn_buscar()) {
			ProductosAlmacen.getBtn_buscar().setBackground(VentanaPrincipal.getAzulOscuro());
			ProductosAlmacen.getBtn_buscar().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == ProductosAlmacen.getBtn_todos_productos()) {
			ProductosAlmacen.getBtn_todos_productos().setBackground(VentanaPrincipal.getAzulOscuro());
			ProductosAlmacen.getBtn_todos_productos().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == ProductosAlmacen.getBtn_volver()) {
			ProductosAlmacen.getBtn_volver().setBackground(VentanaPrincipal.getAzulOscuro());
			ProductosAlmacen.getBtn_volver().setForeground(VentanaPrincipal.getAzulClaro());;
		}
	}

	@Override
	public void mouseExited(MouseEvent e) { //al salir el raton de encima
		if (e.getSource() == ProductosAlmacen.getBtn_add_receta()) {
			ProductosAlmacen.getBtn_add_receta().setBackground(VentanaPrincipal.getAzulClaro());
			ProductosAlmacen.getBtn_add_receta().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == ProductosAlmacen.getBtn_buscar()) {
			ProductosAlmacen.getBtn_buscar().setBackground(VentanaPrincipal.getAzulClaro());
			ProductosAlmacen.getBtn_buscar().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == ProductosAlmacen.getBtn_todos_productos()) {
			ProductosAlmacen.getBtn_todos_productos().setBackground(VentanaPrincipal.getAzulClaro());
			ProductosAlmacen.getBtn_todos_productos().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == ProductosAlmacen.getBtn_volver()) {
			ProductosAlmacen.getBtn_volver().setBackground(VentanaPrincipal.getAzulClaro());
			ProductosAlmacen.getBtn_volver().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
	}

	public static float getCantidad() {
		return cantidad;
	}
		
	
	
	
}
