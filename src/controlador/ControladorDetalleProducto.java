package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import modelo_bbdd.BbddAlmacen;
import vista.DetalleProducto;
import vista.VentanaPrincipal;

public class ControladorDetalleProducto implements ActionListener {

	private DetalleProducto panelDetalleProductos;

	public ControladorDetalleProducto(DetalleProducto panelDetalleProductos) {
		this.panelDetalleProductos = panelDetalleProductos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == DetalleProducto.getBtn_volver()) {
			VentanaPrincipal.getPanelAlmacen().setVisible(true);
			VentanaPrincipal.getPanelDetalleProducto().setVisible(false);
		}
		if (e.getSource() == DetalleProducto.getBtn_Aceptar()) {
			VentanaPrincipal.getPanelAlmacen().setVisible(true);
			VentanaPrincipal.getPanelDetalleProducto().setVisible(false);
			

			String nombreProducto = DetalleProducto.getTfd_Nombre().getText();
			int tipoProducto = DetalleProducto.getTipo().getSelectedIndex();
			float cantidadActual = Float.parseFloat(DetalleProducto.getTfd_Actual().getText());
			int unidadMedida = DetalleProducto.getUnidadMedida().getSelectedIndex();
			float cantidadMinima = Float.parseFloat(DetalleProducto.getTfd_Minimo().getText());
			float cantidadMaxima = Float.parseFloat(DetalleProducto.getTfd_Maximo().getText());
						
			BbddAlmacen.addPructoAlmacen(nombreProducto, cantidadActual, cantidadMinima, cantidadMaxima, tipoProducto, unidadMedida);
			
			
		}
		
		
		
		
	}
		
}

