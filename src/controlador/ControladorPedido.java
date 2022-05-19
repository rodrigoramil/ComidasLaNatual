package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo_bbdd.BbddComidaBebida;
import modelo_bbdd.BbddPedido;
import vista.BuscarComidaBebida;
import vista.Facturar;
import vista.GestionPedidos;
import vista.Pedido;
import vista.Recetario;
import vista.VentanaPrincipal;

public class ControladorPedido  implements ActionListener, MouseListener {

	private Pedido panelPedido;
	private static int cantidad;
	private static float total;
	private static double totalIva;
	private static double abonado = 0;
	private static double aDevolver;
	
	public ControladorPedido (Pedido panelPedido) {
		this.panelPedido = panelPedido;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == Pedido.getBtn_Volver()) {			
			VentanaPrincipal.getPanelGestionPedidos().setVisible(true);
			VentanaPrincipal.getPanelPedido().setVisible(false);
			GestionPedidos.getBtn_Editar_Cliente().setEnabled(false);
			GestionPedidos.getBtn_Ver_Pedido().setEnabled(false);
		}

		if (e.getSource() == Pedido.getBtn_Nuevo()) {
			VentanaPrincipal.getPanelPedido().setVisible(false);
			VentanaPrincipal.getPanelBuscarComidaBebida().setVisible(true);	
			
			BuscarComidaBebida.listarPedido(BbddComidaBebida.listarComidaBebida());

			
		}
		
		if (e.getSource() == Pedido.getBtn_Modificar()) {
			cantidad=0;
			String respuesta = JOptionPane.showInputDialog("¿Que cantidad quieres introducir?");
			if (respuesta != null) {
				if (!respuesta.equals("")) {
					try {	
						cantidad = Integer.parseInt(respuesta);
					} catch (NumberFormatException e2) {
						cantidad=1;
						JOptionPane.showMessageDialog(panelPedido, "No ha introducido un número, por defecto será uno");
					}
				}
				else {
					cantidad=1;
				}
			}
			System.out.println("cantidad modificada --> "+cantidad);
			
			
			
			int idReceta = 0;			
			String ComidaBebidaSeleccionada = Pedido.datoSeleccionadoTabla();			
			for (int i = 0; i < BbddPedido.getArrayPedido().size(); i++) {
				if (BbddPedido.getArrayPedido().get(i).getNombreReceta().equals(ComidaBebidaSeleccionada)) {
					idReceta = BbddPedido.getArrayPedido().get(i).getIdReceta();					
				}
			}

			try {
				BbddPedido.editarPedido(idReceta, cantidad);
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(panelPedido, "Error al modificar la cantidad del producto selecionado");
				e1.printStackTrace();
			}
			Pedido.listarPedido(BbddPedido.listarPedido());
			Pedido.getBtn_Modificar().setEnabled(false);
			Pedido.getBtn_Eliminar().setEnabled(false);		
		}
		
		
		if (e.getSource() == Pedido.getBtn_Eliminar()) {
			 // si = 0 / no = 1 / cancelar = 2 / X = -1
			int respuestaEliminar = JOptionPane.showConfirmDialog(panelPedido, "¿Esta seguro de que quiere eliminar la receta selecionada?");
			if (respuestaEliminar == 0) {				
				int idReceta = 0;			
				String ComidaBebidaSeleccionada = Pedido.datoSeleccionadoTabla();			
				for (int i = 0; i < BbddPedido.getArrayPedido().size(); i++) {
					if (BbddPedido.getArrayPedido().get(i).getNombreReceta().equals(ComidaBebidaSeleccionada)) {
						idReceta = BbddPedido.getArrayPedido().get(i).getIdReceta();
					}
				}			
				try {
					BbddPedido.borrarComidaBebida(idReceta);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(panelPedido, "Error al borrar el producto selecionado");
					e1.printStackTrace();
				}
				Pedido.listarPedido(BbddPedido.listarPedido());
			}
			Pedido.getBtn_Modificar().setEnabled(false);
			Pedido.getBtn_Eliminar().setEnabled(false);
		}
		
		if (e.getSource() == Pedido.getBtn_Facturar()) {
			VentanaPrincipal.getPanelPedido().setVisible(false);
			VentanaPrincipal.getPanelFacturar().setVisible(true);	
			
			Facturar.factura(BbddPedido.listarPedido());
			Facturar.calcularFactura();
			
		}
		
	}
	
	
		
	

	@Override
	public void mouseClicked(MouseEvent e) { // Al hacer clic con el raton

		
	}

	@Override
	public void mousePressed(MouseEvent e) { // Al pulsar raton
		
		if (e.getSource() == Pedido.getTabla()) {			
			Pedido.getBtn_Modificar().setEnabled(true);
			Pedido.getBtn_Eliminar().setEnabled(true);
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

	public static double getAbonado() {
		return abonado;
	}

	public static void setAbonado(double abonado) {
		ControladorPedido.abonado = abonado;
	}

	public static double getaDevolver() {
		return aDevolver;
	}

	public static void setaDevolver(double aDevolver) {
		ControladorPedido.aDevolver = aDevolver;
	}

	public static double getTotalIva() {
		return totalIva;
	}

	
	
}
