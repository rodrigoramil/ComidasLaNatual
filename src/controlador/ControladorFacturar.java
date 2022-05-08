package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import vista.Facturar;
import vista.VentanaPrincipal;

public class ControladorFacturar implements ActionListener, MouseListener{

	private Facturar panelFacturar;
	
	public ControladorFacturar(Facturar panelFacturar) {
		this.panelFacturar = panelFacturar;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == Facturar.getBtn_volver()) {
			VentanaPrincipal.getPanelFacturar().setVisible(false);
			VentanaPrincipal.getPanelPedido().setVisible(true);
		}
		
		if (e.getSource() == Facturar.getBtn_pagado()) {
			
		}
		
		if (e.getSource() == Facturar.getBtn_pago_tarjeta()) {
			
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

		
	}

	@Override
	public void mouseExited(MouseEvent e) { //al salir el raton de encima

		
	}
		
	
	
	
	
}
