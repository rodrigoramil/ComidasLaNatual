package controlador;

import java.awt.EventQueue;

import modelo_bbdd.CreacionBBDD;
import vista.VentanaPrincipal;

public class Main {

	public static void main(String[] args) {

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreacionBBDD creacionBBDD = new CreacionBBDD();
					creacionBBDD.creacionBBDD();
					VentanaPrincipal ventana = new VentanaPrincipal();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
