package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo_bbdd.BbddAlmacen;
import vista.Almacen;
import vista.DetalleProducto;
import vista.MenuPrincipal;
import vista.VentanaPrincipal;

public class ControladorDetalleProducto implements ActionListener, MouseListener {

	private DetalleProducto panelDetalleProductos;
	private float cantidadMaxima;
	private float cantidadMinima;
	private int unidadMedida;
	private float cantidadActual;
	private int tipoProducto;
	private String nombreProducto;

	public ControladorDetalleProducto(DetalleProducto panelDetalleProductos) {
		this.panelDetalleProductos = panelDetalleProductos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == DetalleProducto.getBtn_volver()) {
			VentanaPrincipal.getPanelAlmacen().setVisible(true);
			VentanaPrincipal.getPanelDetalleProducto().setVisible(false);
			limpiarCajaTexto ();			
		}
		
		
		
		if (e.getSource() == DetalleProducto.getBtn_Aceptar()) {
			VentanaPrincipal.getPanelAlmacen().setVisible(true);
			VentanaPrincipal.getPanelDetalleProducto().setVisible(false);
			Almacen.getBtn_Modificar().setEnabled(false);
			Almacen.getBtn_Eliminar().setEnabled(false);
			try {
				nombreProducto = DetalleProducto.getTfd_Nombre().getText();
				tipoProducto = DetalleProducto.getTipo().getSelectedIndex()+1;
				cantidadActual = Float.parseFloat(DetalleProducto.getTfd_Actual().getText());
				unidadMedida = DetalleProducto.getUnidadMedida().getSelectedIndex()+1;
				cantidadMinima = Float.parseFloat(DetalleProducto.getTfd_Minimo().getText());
				cantidadMaxima = Float.parseFloat(DetalleProducto.getTfd_Maximo().getText());
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(panelDetalleProductos, "Error em el fotmato de los n�meros introducidos");
				System.out.println(e2.getMessage());
			}
	
			if (ControladorAlmacen.isNuevoProducto()) {
				try {
					BbddAlmacen.addPructoAlmacen(nombreProducto,  cantidadActual, unidadMedida,  cantidadMinima,  cantidadMaxima,  tipoProducto);
					Almacen.listarProductos(BbddAlmacen.listarProductosAlmacen());
					JOptionPane.showMessageDialog(panelDetalleProductos, "Se ha a�adido el producto "+nombreProducto);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(panelDetalleProductos, "Error al acceder a la Base de Datos");
					System.out.println(e1.getMessage());
				}			
				limpiarCajaTexto ();
			} else if (!DetalleProducto.getTfd_Nombre().getText().equals("")) {
				try {
					BbddAlmacen.updatePructoAlmacen(nombreProducto,  cantidadActual, unidadMedida,  cantidadMinima,  cantidadMaxima,  tipoProducto);
					Almacen.listarProductos(BbddAlmacen.listarProductosAlmacen());
					JOptionPane.showMessageDialog(panelDetalleProductos, "Se ha actualizado el producto "+nombreProducto);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(panelDetalleProductos, "Error al acceder a la Base de Datos");
					System.out.println(e1.getMessage());
				}
				
			}	
			Almacen.listarProductos(BbddAlmacen.listarProductosAlmacen());
			limpiarCajaTexto ();
		}

	}
	
	public void limpiarCajaTexto () {
		DetalleProducto.getTfd_Nombre().setText("");
		DetalleProducto.getTfd_Actual().setText("");
		DetalleProducto.getTfd_Minimo().setText("");
		DetalleProducto.getTfd_Maximo().setText("");
		ControladorAlmacen.setNuevoProducto(false);
		Almacen.getBtn_Modificar().setEnabled(false);
		Almacen.getBtn_Eliminar().setEnabled(false);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == DetalleProducto.getBtn_Aceptar()) {
			DetalleProducto.getBtn_Aceptar().setBackground(VentanaPrincipal.getAzulOscuro());
			DetalleProducto.getBtn_Aceptar().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == DetalleProducto.getBtn_volver()) {
			DetalleProducto.getBtn_volver().setBackground(VentanaPrincipal.getAzulOscuro());
			DetalleProducto.getBtn_volver().setForeground(VentanaPrincipal.getAzulClaro());;
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == DetalleProducto.getBtn_Aceptar()) {
			DetalleProducto.getBtn_Aceptar().setBackground(VentanaPrincipal.getAzulClaro());
			DetalleProducto.getBtn_Aceptar().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == DetalleProducto.getBtn_volver()) {
			DetalleProducto.getBtn_volver().setBackground(VentanaPrincipal.getAzulClaro());
			DetalleProducto.getBtn_volver().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
	}
		
}

