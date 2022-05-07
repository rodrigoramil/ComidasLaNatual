package controlador;

import java.awt.EventQueue;

import modelo.CreacionBBDD;
import vista.VentanaPrincipal;

public class Main {

	public static void main(String[] args) {
<<<<<<< HEAD

		
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
=======
		
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
>>>>>>> alexis


}
