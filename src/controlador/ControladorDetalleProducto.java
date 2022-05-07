package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		}
		
		
		
		
	}
		
}

