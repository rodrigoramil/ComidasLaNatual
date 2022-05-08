package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controladorcliente;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Cliente extends JPanel {

	private static JPanel panelcliente;
	private static JTextField tfd_nombre;
	private static JTextField tfd_telefono;
	private static JLabel lbl_nombre;
	private static JLabel lbl_telefono;
	private static JButton btn_Aceptar;
	private static JButton btn_volver;
	
	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;

	public Cliente() {

		panelcliente = new JPanel();
		lbl_nombre = new JLabel("Nombre");
		lbl_telefono = new JLabel("Telefono");
		btn_Aceptar = new JButton("Aceptar");
		btn_volver = new JButton("Volver");
		tfd_nombre = new JTextField();
		tfd_telefono = new JTextField();

		establecerManejador();		
		panelcliente.setVisible(false);
	}

	public static JPanel inicializarComponentes() {
		
		panelcliente.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelcliente.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		panelcliente.setLayout(null);
		
		lbl_nombre.setBounds(59, 51, 46, 14);
		panelcliente.add(lbl_nombre);
		
		lbl_telefono.setBounds(59, 89, 46, 14);
		panelcliente.add(lbl_telefono);

		tfd_nombre.setBounds(115, 48, 229, 20);
		panelcliente.add(tfd_nombre);
		tfd_nombre.setColumns(10);
		
		tfd_telefono.setToolTipText("");
		tfd_telefono.setColumns(10);
		tfd_telefono.setBounds(115, 86, 229, 20);
		panelcliente.add(tfd_telefono);

		btn_Aceptar.setBounds(166, 127, 89, 23);
		panelcliente.add(btn_Aceptar);

		btn_volver.setBounds(361, 11, 63, 23);
		panelcliente.add(btn_volver);
		
		return panelcliente;
	}

	public void establecerManejador() {			
		Controladorcliente controlador = new Controladorcliente(this);
		
		btn_Aceptar.addActionListener(controlador);
		btn_volver.addActionListener(controlador);
	}

	public static JButton getBtn_Aceptar() {
		return btn_Aceptar;
	}

	public static JButton getBtn_volver() {
		return btn_volver;
	}
	
	
		
}
