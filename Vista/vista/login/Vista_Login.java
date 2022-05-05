package vista.login;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Vista_Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtf_Entrada_Nombre;
	private JPasswordField jtf_Entrada_Contrasena;

	public Vista_Login() {
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_Aceptar = new JButton("Aceptar");
	
		btn_Aceptar.setBounds(93, 198, 89, 23);
		contentPane.add(btn_Aceptar);
		
		JButton btn_Borrar = new JButton("Borrar");
		btn_Borrar.setBounds(246, 198, 89, 23);
		contentPane.add(btn_Borrar);
		
		jtf_Entrada_Nombre = new JTextField();
		jtf_Entrada_Nombre.setBounds(139, 81, 86, 20);
		contentPane.add(jtf_Entrada_Nombre);
		jtf_Entrada_Nombre.setColumns(10);
		
		jtf_Entrada_Contrasena = new JPasswordField();
		jtf_Entrada_Contrasena.setBounds(139, 123, 86, 20);
		contentPane.add(jtf_Entrada_Contrasena);
		
		JLabel lbl_Error_Usuario = new JLabel("Usuario incorrecto");
		lbl_Error_Usuario.setEnabled(false);
		lbl_Error_Usuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_Error_Usuario.setForeground(Color.RED);
		lbl_Error_Usuario.setBounds(252, 84, 126, 14);
		contentPane.add(lbl_Error_Usuario);
		
		JLabel lbl_Error_Contrasena = new JLabel("Contrase\u00F1a incorrecta");
		lbl_Error_Contrasena.setEnabled(false);
		lbl_Error_Contrasena.setForeground(Color.RED);
		lbl_Error_Contrasena.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_Error_Contrasena.setBounds(252, 126, 126, 14);
		contentPane.add(lbl_Error_Contrasena);
		
		JLabel lbl_Usuario = new JLabel("Usuario");
		lbl_Usuario.setBounds(53, 84, 66, 14);
		contentPane.add(lbl_Usuario);
		
		JLabel lbl_Contraseña = new JLabel("Contrase\u00F1a");
		lbl_Contraseña.setBounds(53, 126, 66, 14);
		contentPane.add(lbl_Contraseña);
	}
	
public void establecerManejador() {
		
		
//		Controlador_menu_principal controlador = new Controlador_menu_principal(this);
//
//		btn_Aceptar.addActionListener(controlador);
//		boton_principal_recetario.addActionListener(controlador);
//		boton_principal_almacen.addActionListener(controlador);
//		boton_principal_contabilidad.addActionListener(controlador);
//		boton_principal_usuario.addActionListener(controlador);
//		boton_principal_salir.addActionListener(controlador);
		
	}
}
