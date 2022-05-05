package vista.usuarios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Choice;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Vista_Usuarios extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista_Usuarios frame = new Vista_Usuarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vista_Usuarios() {
		setTitle("Usuario");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Nombre = new JLabel("Nombre");
		lbl_Nombre.setBounds(10, 67, 65, 14);
		contentPane.add(lbl_Nombre);
		
		JLabel lbl_contrasena = new JLabel("Contrasena");
		lbl_contrasena.setBounds(10, 103, 65, 14);
		contentPane.add(lbl_contrasena);
		
		JLabel lbl_repetir_Contrasena = new JLabel("Repita la contrase\u00F1a");
		lbl_repetir_Contrasena.setBounds(10, 139, 113, 14);
		contentPane.add(lbl_repetir_Contrasena);
		
		JLabel lbl_rol = new JLabel("Rol");
		lbl_rol.setBounds(10, 175, 46, 14);
		contentPane.add(lbl_rol);
		
		JButton btn_Aceptar = new JButton("Aceptar");
		btn_Aceptar.setBounds(10, 211, 89, 23);
		contentPane.add(btn_Aceptar);
		
		JRadioButton rdbtn_admin = new JRadioButton("Administrador");
		rdbtn_admin.setBounds(79, 166, 109, 23);
		contentPane.add(rdbtn_admin);
		
		JRadioButton rdbtn_Cocina = new JRadioButton("Cocinas");
		rdbtn_Cocina.setBounds(204, 166, 109, 23);
		contentPane.add(rdbtn_Cocina);
		
		JRadioButton rdbtn_ventas = new JRadioButton("Ventas");
		rdbtn_ventas.setSelected(true);
		rdbtn_ventas.setBounds(319, 166, 109, 23);
		contentPane.add(rdbtn_ventas);
		
		textField = new JTextField();
		textField.setBounds(85, 64, 312, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(118, 101, 280, 17);
		contentPane.add(passwordField);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(118, 137, 280, 17);
		contentPane.add(passwordField_2);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.setBounds(342, 11, 71, 23);
		contentPane.add(btnNewButton);
	}
}
