package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.table.TableColumn;

import modelo.ModeloReceta;
import modelo_bbdd.BbddProductosAlmacen;
import modelo_bbdd.BbddReceta;
import vista.BuscarComidaBebida;
import vista.ProductosAlmacen;
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
			} else if (ControladorRecetario.isVerDesdeRecetario()) {
				ControladorRecetario.setVerDesdeRecetario(false);
				VentanaPrincipal.getPanelReceta().setVisible(false);
				VentanaPrincipal.getPanelRecetario().setVisible(true);
			} else {
				VentanaPrincipal.getPanelReceta().setVisible(false);
				VentanaPrincipal.getPanelRecetario().setVisible(true);
			}
		}
		
		if (e.getSource() == Receta.getBtn_nuevo_ingrediente()) {

			
			VentanaPrincipal.getPanelProductosAlmacen().setVisible(true);
			VentanaPrincipal.getPanelReceta().setVisible(false);
			
			ProductosAlmacen.listarProductos(BbddProductosAlmacen.listarProductosAlmacen());
//			BbddProductosAlmacen.listarProductosAlmacen();
			
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
