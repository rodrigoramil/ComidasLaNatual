package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import modelo.ModeloReceta;
import modelo_bbdd.BbddReceta;
import vista.BuscarComidaBebida;
import vista.Receta;
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
			
			
			if (ControladorBuscarComidaBebida.getDesdeVentas()) {
				VentanaPrincipal.getPanelReceta().setVisible(false);
				VentanaPrincipal.getPanelBuscarComidaBebida().setVisible(true);
				ControladorBuscarComidaBebida.setDesdeVentas(false);
				Receta.getBtn_nuevo_ingrediente().setEnabled(true);
				Receta.getBtn_modificar_cantidad().setEnabled(true);
				Receta.getBtn_borrar_ingrediente().setEnabled(true);
				Receta.getBtn_guardar().setEnabled(true);
				
			} else {
				VentanaPrincipal.getPanelReceta().setVisible(false);
				VentanaPrincipal.getPanelRecetario().setVisible(true);
			}
			
			
		}
		
		if (e.getSource() == Receta.getBtn_nuevo_ingrediente()) {

			VentanaPrincipal.getPanelProductosAlmacen().setVisible(true);
			VentanaPrincipal.getPanelReceta().setVisible(false);
		}
		
		if (e.getSource() == Receta.getBtn_modificar_cantidad()) {
			
		}
		
		if (e.getSource() == Receta.getBtn_borrar_ingrediente()) {
			
		}
		
		if (e.getSource() == Receta.getBtn_guardar()) {
			try {
				BbddReceta.insertarReceta();
				System.out.println("Se ha creado una nueva receta");
			} catch (SQLException e1) {				
				e1.printStackTrace();
			}
			
			VentanaPrincipal.getPanelRecetario().setVisible(true);
			VentanaPrincipal.getPanelReceta().setVisible(false);
			
//			System.out.println(Receta.getArrayIngredientes().get(indiceSeleccionado).getNombreReceta());
//			System.out.println(Receta.getArrayIngredientes().get(indiceSeleccionado).getNombreProducto());
		/*	
			for (int i = 0; i < Receta.getArrayIngredientes().size(); i++) {
				
//				System.out.println(Receta.getArrayIngredientes().get(i).getNombreReceta()+" <-------RECETA");
//				System.out.println(Receta.getArrayIngredientes().get(i).getNombreProducto());
				
				System.out.println(Receta.getArrayIngredientes().get(i).getIdProducto());
				System.out.println(Receta.getArrayIngredientes().get(i).getIdReceta());
				System.out.println(Receta.getArrayIngredientes().get(i).getCantidad());
				System.out.println(Receta.getArrayIngredientes().get(i).getElaboracion());
				System.out.println(Receta.getArrayIngredientes().get(i).getNombreReceta());
				System.out.println(Receta.getArrayIngredientes().get(i).getNombreProducto());
				System.out.println(Receta.getArrayIngredientes().get(i).getPrecioVenta());
				

				Receta.getArrayIngredientes().get(i).getIdProducto();
				Receta.getArrayIngredientes().get(i).getIdReceta();
				Receta.getArrayIngredientes().get(i).getCantidad();
				Receta.getArrayIngredientes().get(i).getElaboracion();
				Receta.getArrayIngredientes().get(i).getNombreReceta();
				Receta.getArrayIngredientes().get(i).getNombreProducto();
				Receta.getArrayIngredientes().get(i).getPrecioVenta();
			
			}
			
			*/
			
		}
		
		
		
	}

	
	
	@Override
	public void mouseClicked(MouseEvent e) { // Al hacer clic con el raton

		if (e.getSource() == Receta.getBtn_guardar()) {

			
			for (int i = 0; i < Receta.getArrayIngredientes().size(); i++) {			
				System.out.println(Receta.getArrayIngredientes().get(i).getNombreReceta()+" <-------RECETA");
				System.out.println(Receta.getArrayIngredientes().get(i).getNombreProducto());

		
			}
		
		}

	}

	@Override
	public void mousePressed(MouseEvent e) { // Al pulsar raton
		
//		indiceSeleccionado = Receta.getTabla().getSelectedRow();
//		System.out.println("indiceSeleccionado -> "+indiceSeleccionado);
/*		
		for (int i = 0; i < Receta.getArrayIngredientes().size(); i++) {

		int idProducto = Receta.getArrayIngredientes().get(i).getIdProducto();
		String nombreProducto = Receta.getArrayIngredientes().get(i).getNombreProducto();
		int idReceta = Receta.getArrayIngredientes().get(i).getIdReceta();
		String nombreReceta = Receta.getArrayIngredientes().get(i).getNombreReceta();
		float cantidad = Receta.getArrayIngredientes().get(i).getCantidad();
		String elaboracion = Receta.getArrayIngredientes().get(i).getElaboracion();
		
			if (indiceSeleccionado==i) {				
				System.out.println(idProducto);
				System.out.println(nombreProducto);
				System.out.println(idReceta);
				System.out.println(nombreReceta);
				System.out.println(cantidad);
				System.out.println(elaboracion);
			}
		}
		*/	 

		
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



	public static int getIndiceSeleccionado() {
		return indiceSeleccionado;
	}





}
