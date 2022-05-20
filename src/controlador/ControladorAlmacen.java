package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo_bbdd.BbddAlmacen;
import modelo_bbdd.BbddGestionUsuario;
import modelo_bbdd.BbddListasCompra;
import modelo_bbdd.BbddPrepararCompra;
import vista.Almacen;
import vista.DetalleProducto;
import vista.GestionUsuarios;
import vista.ListasCompra;
import vista.MenuPrincipal;
import vista.PrepararCompra;
import vista.Recetario;
import vista.VentanaPrincipal;

public class ControladorAlmacen implements ActionListener, MouseListener  {

private Almacen panelAlmacen;
private String productoSelecionado;
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
		
		if (e.getSource() == Almacen.getBtn_Nuevo()) {
			nuevoProducto = true;			
			VentanaPrincipal.getPanelAlmacen().setVisible(false);
			VentanaPrincipal.getPanelDetalleProducto().setVisible(true);
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
		
		if (e.getSource() == Almacen.getBtn_Eliminar()) {
			try {	
				productoSelecionado = Almacen.datoSeleccionadoTabla();

				 // si = 0 / no = 1 / cancelar = 2 / X = -1
				int respuestaEliminar = JOptionPane.showConfirmDialog(panelAlmacen, "Quiere eleminar el producto "+productoSelecionado);
				if (respuestaEliminar == 0) {
					
					try {						
						BbddAlmacen.borrarProducto();
						Almacen.listarProductos(BbddAlmacen.listarProductosAlmacen());
						Almacen.getBtn_Modificar().setEnabled(false);
						Almacen.getBtn_Eliminar().setEnabled(false);
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(panelAlmacen, "Error con la Base de Datos");
					}					
				}				
			} catch (NullPointerException errorSelectorVacio) {				
				JOptionPane.showMessageDialog(panelAlmacen, "Selecciona un producto a eliminar");
			}	
			
			Almacen.getTabla().clearSelection();
			
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
			Almacen.getBtn_Eliminar().setEnabled(true);
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) { // al no interactuar con el

		
	}

	@Override
	public void mouseEntered(MouseEvent e) { // al tener el raton encima
		if (e.getSource() == Almacen.getBtn_Buscar()) {
			Almacen.getBtn_Buscar().setBackground(VentanaPrincipal.getAzulOscuro());
			Almacen.getBtn_Buscar().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == Almacen.getBtn_Eliminar()) {
			Almacen.getBtn_Eliminar().setBackground(VentanaPrincipal.getAzulOscuro());
			Almacen.getBtn_Eliminar().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == Almacen.getBtn_Modificar()) {
			Almacen.getBtn_Modificar().setBackground(VentanaPrincipal.getAzulOscuro());
			Almacen.getBtn_Modificar().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == Almacen.getBtn_Nuevo()) {
			Almacen.getBtn_Nuevo().setBackground(VentanaPrincipal.getAzulOscuro());
			Almacen.getBtn_Nuevo().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == Almacen.getBtn_Realizar_Lista_Compra()) {
			Almacen.getBtn_Realizar_Lista_Compra().setBackground(VentanaPrincipal.getAzulOscuro());
			Almacen.getBtn_Realizar_Lista_Compra().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == Almacen.getBtn_todos_los_Productos()) {
			Almacen.getBtn_todos_los_Productos().setBackground(VentanaPrincipal.getAzulOscuro());
			Almacen.getBtn_todos_los_Productos().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == Almacen.getBtn_Ver_Listas_Compras()) {
			Almacen.getBtn_Ver_Listas_Compras().setBackground(VentanaPrincipal.getAzulOscuro());
			Almacen.getBtn_Ver_Listas_Compras().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == Almacen.getBtn_Volver()) {
			Almacen.getBtn_Volver().setBackground(VentanaPrincipal.getAzulOscuro());
			Almacen.getBtn_Volver().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) { //al salir el raton de encima
		if (e.getSource() == Almacen.getBtn_Buscar()) {
			Almacen.getBtn_Buscar().setBackground(VentanaPrincipal.getAzulClaro());
			Almacen.getBtn_Buscar().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == Almacen.getBtn_Eliminar()) {
			Almacen.getBtn_Eliminar().setBackground(VentanaPrincipal.getAzulClaro());
			Almacen.getBtn_Eliminar().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == Almacen.getBtn_Modificar()) {
			Almacen.getBtn_Modificar().setBackground(VentanaPrincipal.getAzulClaro());
			Almacen.getBtn_Modificar().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == Almacen.getBtn_Nuevo()) {
			Almacen.getBtn_Nuevo().setBackground(VentanaPrincipal.getAzulClaro());
			Almacen.getBtn_Nuevo().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == Almacen.getBtn_Realizar_Lista_Compra()) {
			Almacen.getBtn_Realizar_Lista_Compra().setBackground(VentanaPrincipal.getAzulClaro());
			Almacen.getBtn_Realizar_Lista_Compra().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == Almacen.getBtn_todos_los_Productos()) {
			Almacen.getBtn_todos_los_Productos().setBackground(VentanaPrincipal.getAzulClaro());
			Almacen.getBtn_todos_los_Productos().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == Almacen.getBtn_Ver_Listas_Compras()) {
			Almacen.getBtn_Ver_Listas_Compras().setBackground(VentanaPrincipal.getAzulClaro());
			Almacen.getBtn_Ver_Listas_Compras().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == Almacen.getBtn_Volver()) {
			Almacen.getBtn_Volver().setBackground(VentanaPrincipal.getAzulClaro());
			Almacen.getBtn_Volver().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		
	}

	public static boolean isNuevoProducto() {
		return nuevoProducto;
	}

	public static void setNuevoProducto(boolean nuevoProducto) {
		ControladorAlmacen.nuevoProducto = nuevoProducto;
	}


}