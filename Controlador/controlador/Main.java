package controlador;

import java.awt.EventQueue;

import modelo.CreacionBBDD;
import vista.login.Vista_Login;

public class Main {

	public static void main(String[] args) {
		
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						CreacionBBDD creacionBBDD = new CreacionBBDD();
						creacionBBDD.creacionBBDD();
						Vista_Login frame = new Vista_Login();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

	

}
