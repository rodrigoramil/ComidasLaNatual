package vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.Controlador_Login;

public class Vista_Login extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private static JLabel lbl_Usuario;
	private static JLabel lbl_Contraseña;
	private static JTextField jtf_Entrada_Nombre;
	private static JPasswordField jtf_Entrada_Contrasena;
	private static JButton btn_Aceptar;
	private static JButton btn_Borrar;
	
	private static String tituloVentana = "Login";
	private static int ancho = 450;
	private static int alto = 300;

	private static JPanel vistaLogin;


	public Vista_Login() {
		
	
		vistaLogin = new JPanel();
		btn_Aceptar = new JButton("Aceptar");
		btn_Borrar = new JButton("Borrar");
		jtf_Entrada_Nombre = new JTextField();
		jtf_Entrada_Contrasena = new JPasswordField();
		lbl_Usuario = new JLabel("Usuario");
		lbl_Contraseña = new JLabel("Contrase\u00F1a");

		establecerManejador();
		
	}


	public static JPanel inicializarComponentes() {
		
		
		
		vistaLogin.setBorder(new EmptyBorder(5, 5, 5, 5));
		vistaLogin.setBounds(0, 0, 450, 300);
		vistaLogin.setLayout(null);
		
		
		btn_Aceptar.setBounds(93, 200, 90, 23);
		vistaLogin.add(btn_Aceptar);
		
		btn_Borrar.setBounds(246, 200, 90, 23);
		vistaLogin.add(btn_Borrar);
		
		jtf_Entrada_Nombre.setBounds(190, 80, 100, 20);
		vistaLogin.add(jtf_Entrada_Nombre);
		jtf_Entrada_Nombre.setColumns(10);
		
		jtf_Entrada_Contrasena.setBounds(190, 120, 100, 20);
		vistaLogin.add(jtf_Entrada_Contrasena);
		
		lbl_Usuario.setBounds(105, 83, 66, 14);
		vistaLogin.add(lbl_Usuario);
		
		lbl_Contraseña.setBounds(105, 125, 66, 14);
		vistaLogin.add(lbl_Contraseña);
		
		return vistaLogin;
	}
	
	public void establecerManejador() {			
			Controlador_Login controlador = new Controlador_Login(this);	
			btn_Aceptar.addActionListener(controlador);
			btn_Borrar.addActionListener(controlador);
		
	}



	public static JTextField getJtf_Entrada_Nombre() {
		return jtf_Entrada_Nombre;
	}


	public static JPasswordField getJtf_Entrada_Contrasena() {
		return jtf_Entrada_Contrasena;
	}


	public static JButton getBtn_Aceptar() {
		return btn_Aceptar;
	}


	public static JButton getBtn_Borrar() {
		return btn_Borrar;
	}


	public static String getTituloVentana() {
		return tituloVentana;
	}


	public static void setTituloVentana(String tituloVentana) {
		Vista_Login.tituloVentana = tituloVentana;
	}




	

	

}
