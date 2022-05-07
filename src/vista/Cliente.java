package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Cliente extends JPanel {

	private JPanel contentPane;
	private JTextField tfd_nombre;
	private JTextField tfd_telefono;


	public Cliente() {

		
		JLabel lbl_nombre = new JLabel("Nombre");
		lbl_nombre.setBounds(59, 51, 46, 14);
		contentPane.add(lbl_nombre);
		
		JLabel lbl_telefono = new JLabel("Telefono");
		lbl_telefono.setBounds(59, 89, 46, 14);
		contentPane.add(lbl_telefono);
		
		tfd_nombre = new JTextField();
		tfd_nombre.setBounds(115, 48, 229, 20);
		contentPane.add(tfd_nombre);
		tfd_nombre.setColumns(10);
		
		tfd_telefono = new JTextField();
		tfd_telefono.setToolTipText("");
		tfd_telefono.setColumns(10);
		tfd_telefono.setBounds(115, 86, 229, 20);
		contentPane.add(tfd_telefono);
		
		JButton btn_Aceptar = new JButton("Aceptar");
		btn_Aceptar.setBounds(166, 127, 89, 23);
		contentPane.add(btn_Aceptar);
		
		JButton btn_volver = new JButton("Volver");
		btn_volver.setBounds(361, 11, 63, 23);
		contentPane.add(btn_volver);
	}

	public static JPanel inicializarComponentes() {
		// TODO Auto-generated method stub
		return null;
	}

}
