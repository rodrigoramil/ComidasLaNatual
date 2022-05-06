package controlador;

import java.awt.EventQueue;

import modelo.CreacionBBDD;
//	import vista.login.Vista_Login;
import ventanaPrincipal.VentanaPrincipal;

public class Main {

	public static void main(String[] args) {

			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						CreacionBBDD creacionBBDD = new CreacionBBDD();
						creacionBBDD.creacionBBDD();
						VentanaPrincipal ventana = new VentanaPrincipal();
//						ventana.setVisible(true);

					} catch (Exception e) {
						e.printStackTrace();
						System.out.print("test");
					}
				}
			});
		}



}
