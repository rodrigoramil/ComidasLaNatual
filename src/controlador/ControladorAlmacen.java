package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import modelo_bbdd.BbddAlmacen;
import modelo_bbdd.BbddListasCompra;
import modelo_bbdd.BbddPrepararCompra;
import vista.Almacen;
import vista.DetalleProducto;
import vista.ListasCompra;
import vista.PrepararCompra;
import vista.Recetario;
import vista.VentanaPrincipal;

public class ControladorAlmacen implements ActionListener, MouseListener  {

private Almacen panelAlmacen;
private static boolean nuevoProducto=false;

	
	public ControladorAlmacen(Almacen panelAlmacen) {
		this.panelAlmacen = panelAlmacen;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Almacen.getBtn_Volver()) {
			VentanaPrincipal.getPanelMenuPrincipal().setVisible(true);
			VentanaPrincipal.getPanelAlmacen().setVisible(false);
		}
		
		if (e.getSource() == Almacen.getBtn_Modificar()) {
			VentanaPrincipal.getPanelAlmacen().setVisible(false);
			VentanaPrincipal.getPanelDetalleProducto().setVisible(true);
			nuevoProducto = false;	
			
			String productoSelecionado = Almacen.datoSeleccionadoTabla();
			for (int i = 0; i < BbddAlmacen.getArrayAlmacen().size(); i++) {
				if (BbddAlmacen.getArrayAlmacen().get(i).getNombreProducto().equals(productoSelecionado)) {
					DetalleProducto.getTfd_Nombre().setText(productoSelecionado);
					DetalleProducto.getTfd_Actual().setText(String.valueOf(BbddAlmacen.getArrayAlmacen().get(i).getCantidadActual()));
					DetalleProducto.getTfd_Minimo().setText(String.valueOf(BbddAlmacen.getArrayAlmacen().get(i).getCantidadMinima()));
					DetalleProducto.getTfd_Maximo().setText(String.valueOf(BbddAlmacen.getArrayAlmacen().get(i).getCantidadMaxima()));
					int tipo = BbddAlmacen.getArrayAlmacen().get(i).getTipo();
					int unidadMedida = BbddAlmacen.getArrayAlmacen().get(i).getUnidadMedida();	
					DetalleProducto.getTipo().select(tipo-1);
					DetalleProducto.getUnidadMedida().select(unidadMedida-1);					
				}				
			}
			
			
			
			
			
		}
		if (e.getSource() == Almacen.getBtn_Nuevo()) {
			nuevoProducto = true;			
			VentanaPrincipal.getPanelAlmacen().setVisible(false);
			VentanaPrincipal.getPanelDetalleProducto().setVisible(true);
		}
		
		if (e.getSource() == Almacen.getBtn_Realizar_Lista_Compra()) {
			VentanaPrincipal.getPanelAlmacen().setVisible(false);
			VentanaPrincipal.getPanelPrepararCompra().setVisible(true);
			PrepararCompra.listarProductos(BbddPrepararCompra.listarPrepararCompra());
		}
				
		if (e.getSource() == Almacen.getBtn_Ver_Listas_Compras()) {
			VentanaPrincipal.getPanelAlmacen().setVisible(false);
			VentanaPrincipal.getPanelListasCompra().setVisible(true);

			ListasCompra.listarCompras(BbddListasCompra.listarListasCompra());

			
			
		}
		
		if (e.getSource() == Almacen.getBtn_todos_los_Productos()) {
			
		}
		
		if (e.getSource() == Almacen.getBtn_Buscar()) {
			
		}
		
	}
		
		
	
	
	
	
	
	
			
			

	@Override
	public void mouseClicked(MouseEvent e) { // Al hacer clic con el raton

		
	}

	@Override
	public void mousePressed(MouseEvent e) { // Al pulsar raton
		if (e.getSource() == Almacen.getTabla()) {			
			Almacen.getBtn_Modificar().setEnabled(true);
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

	public static boolean isNuevoProducto() {
		return nuevoProducto;
	}

	public static void setNuevoProducto(boolean nuevoProducto) {
		ControladorAlmacen.nuevoProducto = nuevoProducto;
	}


}