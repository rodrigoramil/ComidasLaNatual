package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo_bbdd.BbddAlmacen;
import vista.Almacen;
import vista.DetalleProducto;
import vista.VentanaPrincipal;

public class ControladorDetalleProducto implements ActionListener {

	private DetalleProducto panelDetalleProductos;
	private float cantidadMaxima;
	private float cantidadMinima;
	private int IdunidadMedida;
	private float cantidadActual;
	private int idTipoProducto;
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
			try {
				nombreProducto = DetalleProducto.getTfd_Nombre().getText();
				idTipoProducto = DetalleProducto.getTipo().getSelectedIndex()+1;
				cantidadActual = Float.parseFloat(DetalleProducto.getTfd_Actual().getText());
				IdunidadMedida = DetalleProducto.getUnidadMedida().getSelectedIndex()+1;
				cantidadMinima = Float.parseFloat(DetalleProducto.getTfd_Minimo().getText());
				cantidadMaxima = Float.parseFloat(DetalleProducto.getTfd_Maximo().getText());
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(panelDetalleProductos, "Error em el fotmato de los números introducidos");
				System.out.println(e2.getMessage());
			}
	
			if (ControladorAlmacen.isNuevoProducto()) {
				try {
					BbddAlmacen.addPructoAlmacen(nombreProducto,  cantidadActual, IdunidadMedida,  cantidadMinima,  cantidadMaxima,  idTipoProducto);
					JOptionPane.showMessageDialog(panelDetalleProductos, "Se ha añadido el producto "+nombreProducto);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(panelDetalleProductos, "Error al acceder a la Base de Datos");
					System.out.println(e1.getMessage());
				}			
				limpiarCajaTexto ();
			} else if (!DetalleProducto.getTfd_Nombre().getText().equals("")) {
				try {
					BbddAlmacen.updatePructoAlmacen(nombreProducto,  cantidadActual, IdunidadMedida,  cantidadMinima,  cantidadMaxima,  idTipoProducto);
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
	}
		
}

