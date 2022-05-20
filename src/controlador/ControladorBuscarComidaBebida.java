package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import vista.BuscarComidaBebida;
import vista.Receta;
import vista.VentanaPrincipal;

public class ControladorBuscarComidaBebida implements ActionListener, MouseListener  {

	private BuscarComidaBebida panelBuscarComidaBebida;
	private int cantidad;
	private ArrayList<String> arrayBebida;
	private static int indiceSeleccionado;
	private static boolean buscar = false;
	private static boolean comida = false;
	private static boolean bebida = false;
	private static boolean desdeVentas;

	public ControladorBuscarComidaBebida(BuscarComidaBebida panelBuscarComidaBebida) {
		this.panelBuscarComidaBebida = panelBuscarComidaBebida;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == BuscarComidaBebida.getBtn_volver()) {
			VentanaPrincipal.getPanelBuscarComidaBebida().setVisible(false);
			VentanaPrincipal.getPanelPedido().setVisible(true);
		}
		if (e.getSource() == BuscarComidaBebida.getBtn_anadir()) {
			cantidad=0;
			String respuesta = JOptionPane.showInputDialog("¿Que cantidad desea añadir?");
			if (respuesta != null) {
				if (!respuesta.equals("")) {
					try {	
						cantidad = Integer.parseInt(respuesta);

					} catch (NumberFormatException e2) {
						cantidad=1;
						JOptionPane.showMessageDialog(panelBuscarComidaBebida, "No ha introducido un número, por defecto se a añadido uno");
					}
				}
				else {
					cantidad=1;
				}
			}

			VentanaPrincipal.getPanelBuscarComidaBebida().setVisible(false);
			VentanaPrincipal.getPanelPedido().setVisible(true);
		}
		
		if (e.getSource() == BuscarComidaBebida.getBtn_bebidas_disponibles()) {
			bebida = true;
			BuscarComidaBebida.pedidos();			
		}
		
		if (e.getSource() == BuscarComidaBebida.getBtn_comidas_disponibles()) {
			comida = true;
			BuscarComidaBebida.pedidos();
		}
		
		if (e.getSource() == BuscarComidaBebida.getBtn_listar_todo()) {
			BuscarComidaBebida.pedidos();
		}
	
		if (e.getSource() == BuscarComidaBebida.getBtn_buscar()) {
			buscar = true;
			
			
			BuscarComidaBebida.pedidos();
		}
	
		if (e.getSource() == BuscarComidaBebida.getBtn_ver_receta()) {
			VentanaPrincipal.getPanelBuscarComidaBebida().setVisible(false);
			VentanaPrincipal.getPanelReceta().setVisible(true);
			Receta.getBtn_nuevo_ingrediente().setEnabled(false);
			Receta.getBtn_modificar_cantidad().setEnabled(false);
			Receta.getBtn_borrar_ingrediente().setEnabled(false);
			Receta.getBtn_guardar().setEnabled(false);
			desdeVentas = true;
		}
	
	}

	@Override
	public void mouseClicked(MouseEvent e) { // Al hacer clic con el raton

		
	}

	@Override
	public void mousePressed(MouseEvent e) { // Al pulsar raton

		 indiceSeleccionado = BuscarComidaBebida.getTabla().getSelectedRow();
		 System.out.println("indiceSeleccionado -> "+indiceSeleccionado);

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
	
	
	public static boolean getDesdeVentas() {
		return desdeVentas;
	}

	public static void setDesdeVentas(boolean desdeVentas) {
		ControladorBuscarComidaBebida.desdeVentas = desdeVentas;
	}

	public ArrayList<String> getArrayBebida() {
		return arrayBebida;
	}

	public static boolean isBebida() {
		return bebida;
	}

	public static void setBebida(boolean bebida) {
		ControladorBuscarComidaBebida.bebida = bebida;
	}

	public static boolean isComida() {
		return comida;
	}

	public static void setComida(boolean comida) {
		ControladorBuscarComidaBebida.comida = comida;
	}

	public static boolean isBuscar() {
		return buscar;
	}

	public static void setBuscar(boolean buscar) {
		ControladorBuscarComidaBebida.buscar = buscar;
	}

	public static int getIndiceSeleccionado() {
		return indiceSeleccionado;
	}

}