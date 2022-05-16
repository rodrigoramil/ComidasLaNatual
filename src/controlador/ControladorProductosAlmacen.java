package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo_bbdd.BbddProductosAlmacen;
import vista.ProductosAlmacen;
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
			}	
			
			
			
			
			
			
			
			
			
			/*	
			
			BbddReceta.listarIngredientes();
			System.out.println(BbddReceta.listarIngredientes());
//			Receta.listarReceta(BbddReceta.listarRecetas());;
			
			for (int i = 0; i < ProductosAlmacen.getArrayProductos().size(); i++) {

				if (ProductosAlmacen.productoSeleccionado()==i) {
					
System.out.println(ProductosAlmacen.getArrayProductos().get(i).getProductos());
System.out.println("productoSeleccionado -> "+ProductosAlmacen.productoSeleccionado());
					String nombreProducto = ProductosAlmacen.getArrayProductos().get(i).getProductos();
				
					for (int j = 0; j < .size(); j++) {
						
					}
					
					
					int idReceta;
					
					if (ProductosAlmacen.getArrayProductos().get(i).getProductos().equals()) {
						
					}
					
					
					
					
					
					idReceta = BbddReceta.getArrayIngredientes().get(i).getIdReceta();
					System.out.println("idReceta -> "+idReceta);
					int idProducto;
					idProducto=BbddReceta.getArrayReceta().get(i).getIdProducto();
					System.out.println("idProducto -> "+idProducto);
					


				

				}				
			}
			
			
			
			
			
			System.out.println(BbddReceta.getArrayIngredientes());
			
			
			for (int j = 0; j < BbddReceta.getArrayIngredientes().size(); j++) {
				System.out.println("J - > "+j);
				
				ModeloIngredientes modeloIngredientes = new ModeloIngredientes(
						idReceta,
						idProducto,
						cantidad
						);
				
//				BbddReceta.listarIngredientes();
				BbddReceta.getArrayIngredientes().add(modeloIngredientes);
				System.out.println(BbddReceta.getArrayIngredientes());
			}
			
			
	
	*/					
			
			
			
			
			
			
			
			
			
			
			
			/* En boton Guardar de Receta hacer sentencia SQL Update 
			 * enviado el array guardado en BbddReceta -> ArrayIngredientesReceta */
			
			
			
			
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

		
	}

	@Override
	public void mouseExited(MouseEvent e) { //al salir el raton de encima

		
	}
		
	
	
	
}
