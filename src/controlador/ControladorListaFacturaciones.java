package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;

import modelo_bbdd.BbddCalculoGanancias;
import modelo_bbdd.BbddPedido;
import vista.CalculoGanancias;
import vista.DetalleFactura;
import vista.ListaFacturaciones;
import vista.MenuPrincipal;
import vista.VentanaPrincipal;

public class ControladorListaFacturaciones implements ActionListener, MouseListener {

private ListaFacturaciones panelListaFacturaciones;
	
	public ControladorListaFacturaciones(ListaFacturaciones panelListaFacturaciones) {
		this.panelListaFacturaciones = panelListaFacturaciones;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == ListaFacturaciones.getBtn_Volver()) {
			VentanaPrincipal.getPanelListaFacturaciones().setVisible(false);
			VentanaPrincipal.getPanelContabilidad().setVisible(true);			
		}
		
		if (e.getSource() == ListaFacturaciones.getBtn_Ver()) {
			VentanaPrincipal.getPanelListaFacturaciones().setVisible(false);
			VentanaPrincipal.getPanelDetalleFactura().setVisible(true);
			double totalFactura = 0;
			double totalFacturaIva = 0;
			int idPedidoTabla= Integer.parseInt(ListaFacturaciones.datoSeleccionadoTabla());
			for (int i = 0; i < BbddCalculoGanancias.getArrayCalculoGanancias().size(); i++) {
				if (BbddCalculoGanancias.getArrayCalculoGanancias().get(i).getIdPedido()== idPedidoTabla) {
					BbddPedido.setIdPedido(idPedidoTabla);
					DetalleFactura.listarDetalleFactura(BbddPedido.listarPedido());
					totalFacturaIva = BbddCalculoGanancias.getArrayCalculoGanancias().get(i).getGananciaPedido();
				}
			}			
			totalFactura = totalFacturaIva-totalFacturaIva*0.21;
			DecimalFormat dosDecimales = new DecimalFormat("#.00");
			
			DetalleFactura.getLbl_Cantidad_Total().setText(String.valueOf(dosDecimales.format(totalFactura))+" €");
			DetalleFactura.getLbl_Cantidad_Total_IVA().setText(String.valueOf(dosDecimales.format(totalFacturaIva))+" €");
			
			
			
			
			
		}
		
		if (e.getSource() == ListaFacturaciones.getBtn_Calcular_Ganancias()) {
			VentanaPrincipal.getPanelListaFacturaciones().setVisible(false);
			VentanaPrincipal.getPanelCalculoGanancias().setVisible(true);	
			
			CalculoGanancias.listarGanancias(BbddCalculoGanancias.listarCalculoGanancias());
			
			float sumaGanancias = 0;
			for (int i = 0; i < BbddCalculoGanancias.getArrayCalculoGanancias().size(); i++) {
				sumaGanancias = sumaGanancias+BbddCalculoGanancias.getArrayCalculoGanancias().get(i).getGananciaPedido();
			}			
			CalculoGanancias.getLbl_Calculo_Ganancias().setText(String.valueOf(sumaGanancias)+" €");
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
		if (e.getSource() == ListaFacturaciones.getBtn_Calcular_Ganancias()) {
			ListaFacturaciones.getBtn_Calcular_Ganancias().setBackground(VentanaPrincipal.getAzulOscuro());
			ListaFacturaciones.getBtn_Calcular_Ganancias().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == ListaFacturaciones.getBtn_Ver()) {
			ListaFacturaciones.getBtn_Ver().setBackground(VentanaPrincipal.getAzulOscuro());
			ListaFacturaciones.getBtn_Ver().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == ListaFacturaciones.getBtn_Volver()) {
			ListaFacturaciones.getBtn_Volver().setBackground(VentanaPrincipal.getAzulOscuro());
			ListaFacturaciones.getBtn_Volver().setForeground(VentanaPrincipal.getAzulClaro());;
		}
	}

	@Override
	public void mouseExited(MouseEvent e) { //al salir el raton de encima
		if (e.getSource() == ListaFacturaciones.getBtn_Calcular_Ganancias()) {
			ListaFacturaciones.getBtn_Calcular_Ganancias().setBackground(VentanaPrincipal.getAzulClaro());
			ListaFacturaciones.getBtn_Calcular_Ganancias().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == ListaFacturaciones.getBtn_Ver()) {
			ListaFacturaciones.getBtn_Ver().setBackground(VentanaPrincipal.getAzulClaro());
			ListaFacturaciones.getBtn_Ver().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == ListaFacturaciones.getBtn_Volver()) {
			ListaFacturaciones.getBtn_Volver().setBackground(VentanaPrincipal.getAzulClaro());
			ListaFacturaciones.getBtn_Volver().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
	}
		
}
