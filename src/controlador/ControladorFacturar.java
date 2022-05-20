package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PrinterException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo_bbdd.BbddCalculoGanancias;
import modelo_bbdd.BbddPedido;
import vista.DetalleGasto;
import vista.Facturar;
import vista.MenuPrincipal;
import vista.Pedido;
import vista.VentanaPrincipal;

public class ControladorFacturar implements ActionListener, MouseListener, KeyListener{

	private Facturar panelFacturar;
	float totalIva;
	public ControladorFacturar(Facturar panelFacturar) {
		this.panelFacturar = panelFacturar;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == Facturar.getBtn_volver()) {
			Pedido.getBtn_Modificar().setEnabled(false);
			Pedido.getBtn_Eliminar().setEnabled(false);
			VentanaPrincipal.getPanelFacturar().setVisible(false);
			VentanaPrincipal.getPanelPedido().setVisible(true);
			Facturar.getCaja_abonado().setText("");
		}
		
		if (e.getSource() == Facturar.getBtn_pagado()) {
			
			VentanaPrincipal.getPanelFacturar().setVisible(false);
			VentanaPrincipal.getPanelGestionPedidos().setVisible(true);
			Facturar.getCaja_abonado().setText("");
			try {
				BbddCalculoGanancias.addGanancia(totalIva);				
				// BbddPedido.borrarPedido(); <--- da fallo
				JOptionPane.showMessageDialog(panelFacturar, "Factura pagada");
			} catch (SQLException | NullPointerException e1) {
				JOptionPane.showMessageDialog(panelFacturar, "Error al guardar el pago");
			}
		}
		
		if (e.getSource() == Facturar.getBtn_imprimir_factura()) {
			
			// Imprime solo la Tabla, debería imprimir el panel completo	
			
			try {				
			DetalleGasto.getTabla().print();				
			} catch (PrinterException e1) {
				JOptionPane.showMessageDialog(panelFacturar, "Error al imprimir la Factura");
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
		if (e.getSource() == Facturar.getBtn_imprimir_factura()) {
			Facturar.getBtn_imprimir_factura().setBackground(VentanaPrincipal.getAzulOscuro());
			Facturar.getBtn_imprimir_factura().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == Facturar.getBtn_pagado()) {
			Facturar.getBtn_pagado().setBackground(VentanaPrincipal.getAzulOscuro());
			Facturar.getBtn_pagado().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == Facturar.getBtn_volver()) {
			Facturar.getBtn_volver().setBackground(VentanaPrincipal.getAzulOscuro());
			Facturar.getBtn_volver().setForeground(VentanaPrincipal.getAzulClaro());;
		}
	}

	@Override
	public void mouseExited(MouseEvent e) { //al salir el raton de encima
		if (e.getSource() == Facturar.getBtn_imprimir_factura()) {
			Facturar.getBtn_imprimir_factura().setBackground(VentanaPrincipal.getAzulClaro());
			Facturar.getBtn_imprimir_factura().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == Facturar.getBtn_pagado()) {
			Facturar.getBtn_pagado().setBackground(VentanaPrincipal.getAzulClaro());
			Facturar.getBtn_pagado().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == Facturar.getBtn_volver()) {
			Facturar.getBtn_volver().setBackground(VentanaPrincipal.getAzulClaro());
			Facturar.getBtn_volver().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		try {
			String abonado = Facturar.getCaja_abonado().getText();
			
			float abonadoNum = Float.parseFloat(abonado);
			totalIva = (float) Facturar.calcularFactura();
			double aDevolver = abonadoNum - totalIva;		

			Facturar.getLbl_valor_devolver().setText(String.format("%.2f", aDevolver)+" €");

		} catch (NumberFormatException e2) {
			JOptionPane.showMessageDialog(panelFacturar, "No has introducido un número");
		}

	}

	public float getTotalIva() {
		return totalIva;
	}
		
	
	
	
	
}
