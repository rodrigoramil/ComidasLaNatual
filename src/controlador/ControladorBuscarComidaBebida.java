package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import modelo.ModeloPedido;
import modelo_bbdd.BbddAlmacen;
import modelo_bbdd.BbddCalculoGanancias;
import modelo_bbdd.BbddComidaBebida;
import modelo_bbdd.BbddPedido;
import modelo_bbdd.BbddReceta;
import modelo_bbdd.BbddRecetario;
import modelo_bbdd.BbddVentas;
import vista.BuscarComidaBebida;
import vista.GestionPedidos;
import vista.MenuPrincipal;
import vista.Pedido;
import vista.Receta;
import vista.VentanaPrincipal;

public class ControladorBuscarComidaBebida implements ActionListener, MouseListener  {

	private BuscarComidaBebida panelBuscarComidaBebida;
	private ArrayList<String> arrayBebida;
	private static int indiceSeleccionado;
	private static boolean buscar = false;
	private static boolean comida = false;
	private static boolean bebida = false;
	private static boolean desdeVentas;
	private int cantidad;
	private int idCliente;
	private int idReceta;
	
	public ControladorBuscarComidaBebida(BuscarComidaBebida panelBuscarComidaBebida) {
		this.panelBuscarComidaBebida = panelBuscarComidaBebida;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == BuscarComidaBebida.getBtn_volver()) {
			VentanaPrincipal.getPanelBuscarComidaBebida().setVisible(false);
			VentanaPrincipal.getPanelPedido().setVisible(true);
			Pedido.getBtn_Modificar().setEnabled(false);
			Pedido.getBtn_Eliminar().setEnabled(false);
		}
		if (e.getSource() == BuscarComidaBebida.getBtn_anadir()) {
			cantidad=0;
			String respuesta = JOptionPane.showInputDialog("¿Que cantidad desea añadir?");
			System.out.println(respuesta);
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
				String ComidaBebidaSeleccionada = BuscarComidaBebida.datoSeleccionadoTabla();
				
				for (int i = 0; i < BbddComidaBebida.getArrayComidaBebida().size(); i++) {
					if (BbddComidaBebida.getArrayComidaBebida().get(i).getNombreReceta().equals(ComidaBebidaSeleccionada)) {
						idReceta = BbddComidaBebida.getArrayComidaBebida().get(i).getIdReceta();					
					}
				}
						
				for (int i = 0; i < BbddVentas.listarClientes().size(); i++) {
					if (BbddVentas.getArrayClientes().get(i).getNombre().equals(Pedido.getLbl_Num_Mesa().getText())) {
						idCliente = BbddVentas.getArrayClientes().get(i).getId();					
					}				
				}

				try {
					BbddPedido.addComidaBebida(idCliente, idReceta, cantidad);
					BbddPedido.listarTodosPedidos();
					for (int i = 0; i < BbddPedido.getArrayPedido().size(); i++) {		
						if (idCliente==BbddPedido.getArrayPedido().get(i).getIdCliente()) {
							ControladorGestionPedidos.setIdPedido(BbddPedido.getArrayPedido().get(i).getIdPedido());
						}
					}
					Pedido.listarPedido(BbddPedido.listarPedido());
					
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(panelBuscarComidaBebida, "Error al añadir el producto selecionado");
				}
				VentanaPrincipal.getPanelBuscarComidaBebida().setVisible(false);
				VentanaPrincipal.getPanelPedido().setVisible(true);
			}
			
			
		}

		if (e.getSource() == BuscarComidaBebida.getBtn_bebidas_disponibles()) {
			bebida = true;
			BuscarComidaBebida.listarPedido(BbddComidaBebida.getArrayComidaBebida());			
		}
		
		if (e.getSource() == BuscarComidaBebida.getBtn_comidas_disponibles()) {
			comida = true;
			BuscarComidaBebida.listarPedido(BbddComidaBebida.getArrayComidaBebida());
		}
		
		if (e.getSource() == BuscarComidaBebida.getBtn_listar_todo()) {
			BuscarComidaBebida.listarPedido(BbddComidaBebida.getArrayComidaBebida());
		}
	
		if (e.getSource() == BuscarComidaBebida.getBtn_buscar()) {
			buscar = true;
			BuscarComidaBebida.listarPedido(BbddComidaBebida.getArrayComidaBebida());
		}
	
		if (e.getSource() == BuscarComidaBebida.getBtn_ver_receta()) {
			VentanaPrincipal.getPanelBuscarComidaBebida().setVisible(false);
			VentanaPrincipal.getPanelReceta().setVisible(true);
			Receta.getBtn_nuevo_ingrediente().setEnabled(false);
			Receta.getBtn_modificar_cantidad().setEnabled(false);
			Receta.getBtn_borrar_ingrediente().setEnabled(false);
			Receta.getBtn_guardar().setEnabled(false);
			desdeVentas = true;
			
			String nombreRecetaSelecionada = BuscarComidaBebida.datoSeleccionadoTabla();
			
			BbddReceta.setNombreRecetaSeleccionada(nombreRecetaSelecionada);
			Receta.listarReceta(BbddReceta.listarRecetas());
			
			for (int i = 0; i < BbddRecetario.getarrayRecetario().size(); i++) {
				if (BbddRecetario.getarrayRecetario().get(i).getNombreReceta().equals(nombreRecetaSelecionada)) {
					
					String elaboracion = BbddRecetario.getarrayRecetario().get(i).getElaboracion();
					Receta.getTexto_elaboracion().setText(elaboracion);
					
					String precioVenta = String.valueOf(BbddRecetario.getarrayRecetario().get(i).getPrecioVenta());					
					Receta.getPrecio_receta().setText(precioVenta);
				}
				
				
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
		if (e.getSource() == BuscarComidaBebida.getBtn_anadir()) {
			BuscarComidaBebida.getBtn_anadir().setBackground(VentanaPrincipal.getAzulOscuro());
			BuscarComidaBebida.getBtn_anadir().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == BuscarComidaBebida.getBtn_bebidas_disponibles()) {
			BuscarComidaBebida.getBtn_bebidas_disponibles().setBackground(VentanaPrincipal.getAzulOscuro());
			BuscarComidaBebida.getBtn_bebidas_disponibles().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == BuscarComidaBebida.getBtn_buscar()) {
			BuscarComidaBebida.getBtn_buscar().setBackground(VentanaPrincipal.getAzulOscuro());
			BuscarComidaBebida.getBtn_buscar().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == BuscarComidaBebida.getBtn_comidas_disponibles()) {
			BuscarComidaBebida.getBtn_comidas_disponibles().setBackground(VentanaPrincipal.getAzulOscuro());
			BuscarComidaBebida.getBtn_comidas_disponibles().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == BuscarComidaBebida.getBtn_listar_todo()) {
			BuscarComidaBebida.getBtn_listar_todo().setBackground(VentanaPrincipal.getAzulOscuro());
			BuscarComidaBebida.getBtn_listar_todo().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == BuscarComidaBebida.getBtn_ver_receta()) {
			BuscarComidaBebida.getBtn_ver_receta().setBackground(VentanaPrincipal.getAzulOscuro());
			BuscarComidaBebida.getBtn_ver_receta().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == BuscarComidaBebida.getBtn_volver()) {
			BuscarComidaBebida.getBtn_volver().setBackground(VentanaPrincipal.getAzulOscuro());
			BuscarComidaBebida.getBtn_volver().setForeground(VentanaPrincipal.getAzulClaro());;
		}
	}

	@Override
	public void mouseExited(MouseEvent e) { //al salir el raton de encima
		if (e.getSource() == BuscarComidaBebida.getBtn_anadir()) {
			BuscarComidaBebida.getBtn_anadir().setBackground(VentanaPrincipal.getAzulClaro());
			BuscarComidaBebida.getBtn_anadir().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == BuscarComidaBebida.getBtn_bebidas_disponibles()) {
			BuscarComidaBebida.getBtn_bebidas_disponibles().setBackground(VentanaPrincipal.getAzulClaro());
			BuscarComidaBebida.getBtn_bebidas_disponibles().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == BuscarComidaBebida.getBtn_buscar()) {
			BuscarComidaBebida.getBtn_buscar().setBackground(VentanaPrincipal.getAzulClaro());
			BuscarComidaBebida.getBtn_buscar().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == BuscarComidaBebida.getBtn_comidas_disponibles()) {
			BuscarComidaBebida.getBtn_comidas_disponibles().setBackground(VentanaPrincipal.getAzulClaro());
			BuscarComidaBebida.getBtn_comidas_disponibles().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == BuscarComidaBebida.getBtn_listar_todo()) {
			BuscarComidaBebida.getBtn_listar_todo().setBackground(VentanaPrincipal.getAzulClaro());
			BuscarComidaBebida.getBtn_listar_todo().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == BuscarComidaBebida.getBtn_ver_receta()) {
			BuscarComidaBebida.getBtn_ver_receta().setBackground(VentanaPrincipal.getAzulClaro());
			BuscarComidaBebida.getBtn_ver_receta().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == BuscarComidaBebida.getBtn_volver()) {
			BuscarComidaBebida.getBtn_volver().setBackground(VentanaPrincipal.getAzulClaro());
			BuscarComidaBebida.getBtn_volver().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
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