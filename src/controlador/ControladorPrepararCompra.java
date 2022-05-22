package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PrinterException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo_bbdd.BbddAlmacen;
import modelo_bbdd.BbddListaGastos;
import vista.Almacen;
import vista.MenuPrincipal;
import vista.PrepararCompra;
import vista.VentanaPrincipal;

public class ControladorPrepararCompra implements ActionListener, MouseListener  {

	private PrepararCompra panelPrepararCompra;
	
	public ControladorPrepararCompra(PrepararCompra panelPrepararCompra) {
		this.panelPrepararCompra = panelPrepararCompra;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == PrepararCompra.getBtn_volver()) {
			VentanaPrincipal.getPanelAlmacen().setVisible(true);
			VentanaPrincipal.getPanelPrepararCompra().setVisible(false);
			Almacen.getBtn_Modificar().setEnabled(false);
			Almacen.getBtn_Eliminar().setEnabled(false);
		}
		
		if (e.getSource() == PrepararCompra.getBtn_Guardar()) {
			VentanaPrincipal.getPanelAlmacen().setVisible(true);
			VentanaPrincipal.getPanelPrepararCompra().setVisible(false);
			Almacen.getBtn_Modificar().setEnabled(false);
			Almacen.getBtn_Eliminar().setEnabled(false);

			try {
				BbddListaGastos.addGasto();
				BbddAlmacen.listarProductosAlmacen();
				for (int i = 0; i < BbddAlmacen.getArrayAlmacen().size(); i++) {
					int idProducto = BbddAlmacen.listarProductosAlmacen().get(i).getIdProducto();
					float cantidadCompraProducto = BbddAlmacen.listarProductosAlmacen().get(i).getCantidadMaxima()-BbddAlmacen.listarProductosAlmacen().get(i).getCantidadActual();
					BbddListaGastos.addCompraProductos(idProducto,cantidadCompraProducto);
				}
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			
		}
		
		if (e.getSource() == PrepararCompra.getBtn_Imprimir()) {
			
			try {				
				panelPrepararCompra.getTabla().print();
				
			} catch (PrinterException e1) {
				JOptionPane.showMessageDialog(panelPrepararCompra, "Error al imprimir la lista de la compra");
				System.out.println("Error al imprimir la lista de la compra");
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
		if (e.getSource() == PrepararCompra.getBtn_Guardar()) {
			PrepararCompra.getBtn_Guardar().setBackground(VentanaPrincipal.getAzulOscuro());
			PrepararCompra.getBtn_Guardar().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == PrepararCompra.getBtn_Imprimir()) {
			PrepararCompra.getBtn_Imprimir().setBackground(VentanaPrincipal.getAzulOscuro());
			PrepararCompra.getBtn_Imprimir().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == PrepararCompra.getBtn_volver()) {
			PrepararCompra.getBtn_volver().setBackground(VentanaPrincipal.getAzulOscuro());
			PrepararCompra.getBtn_volver().setForeground(VentanaPrincipal.getAzulClaro());;
		}
	}

	@Override
	public void mouseExited(MouseEvent e) { //al salir el raton de encima
		if (e.getSource() == PrepararCompra.getBtn_Guardar()) {
			PrepararCompra.getBtn_Guardar().setBackground(VentanaPrincipal.getAzulClaro());
			PrepararCompra.getBtn_Guardar().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == PrepararCompra.getBtn_Imprimir()) {
			PrepararCompra.getBtn_Imprimir().setBackground(VentanaPrincipal.getAzulClaro());
			PrepararCompra.getBtn_Imprimir().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == PrepararCompra.getBtn_volver()) {
			PrepararCompra.getBtn_volver().setBackground(VentanaPrincipal.getAzulClaro());
			PrepararCompra.getBtn_volver().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
	}

	
	
	
}
