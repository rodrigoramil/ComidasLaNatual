package vista;

import javax.swing.*;
import java.awt.*;

public class FondoMenuPrincipal extends javax.swing.JPanel {

	public FondoMenuPrincipal(int x, int y) {
		this.setBounds(0, 0, x, y);
	}

	//se crea un m�todo cuyo par�metro debe ser un objeto Graphics

	public void paint(Graphics grafico) {
		Dimension height = getSize();
		//Se selecciona la imagen que tenemos en el paquete de la //ruta del programa

		ImageIcon Img = new ImageIcon("img/Menu.png");

		//Se dibuja la imagen que tenemos en el paquete img dentro de un panel
		int tama�oX = Math.round(800 * VentanaPrincipal.getCordenadaX());
		int tama�oY = Math.round(800 * VentanaPrincipal.getCordenadaY());
		grafico.drawImage(Img.getImage(), 0, 0, tama�oX, tama�oY, null);

		setOpaque(false);
		super.paintComponent(grafico);
	}
}
