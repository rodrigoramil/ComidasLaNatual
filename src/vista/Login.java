package vista;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
// import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controlador.ControladorLogin;

public class Login extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private static JLabel lbl_Usuario;
	private static JLabel lbl_Contraseña;
	private static JTextField jtf_Entrada_Nombre;
	private static JPasswordField jtf_Entrada_Contrasena;
	private static JButton btn_Aceptar;
	private static JButton btn_Borrar;
	private static JPanel panelLogin;
	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 180;
	private static int posicionPanel_y = 80;
	
//**********************************************************************************************
	private static Color verdeOscuro = new Color(3,36,9);
	private LineBorder borde1 = new LineBorder(verdeOscuro,2);
//**********************************************************************************************	
	
	public Login() {		
	

		panelLogin = new JPanel();

		btn_Aceptar = new JButton("Aceptar");
		btn_Borrar = new JButton("Borrar");
		jtf_Entrada_Nombre = new JTextField();
		jtf_Entrada_Contrasena = new JPasswordField();
		lbl_Usuario = new JLabel("Usuario");
		lbl_Contraseña = new JLabel("Contrase\u00F1a");
		
		establecerManejador();
		panelLogin.setVisible(true);
	}



	public static JPanel inicializarComponentes() {		

//**********************************************************************************************		
//		panelLogin.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		panelLogin.setBorder(new LineBorder(verdeOscuro,3));
//**********************************************************************************************	
		panelLogin.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		panelLogin.setLayout(null);
				
		btn_Aceptar.setBounds(93, 200, 90, 23);
		panelLogin.add(btn_Aceptar);
		
		btn_Borrar.setBounds(246, 200, 90, 23);
		panelLogin.add(btn_Borrar);
		
		jtf_Entrada_Nombre.setBounds(190, 80, 100, 20);
		panelLogin.add(jtf_Entrada_Nombre);
		jtf_Entrada_Nombre.setColumns(10);
		
		jtf_Entrada_Contrasena.setBounds(190, 120, 100, 20);
		panelLogin.add(jtf_Entrada_Contrasena);
		
		lbl_Usuario.setBounds(105, 83, 66, 14);
		panelLogin.add(lbl_Usuario);
		
		lbl_Contraseña.setBounds(105, 125, 66, 14);
		panelLogin.add(lbl_Contraseña);
		
		return panelLogin;
	}
	
	public void establecerManejador() {			
			ControladorLogin controlador = new ControladorLogin(this);	
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

}
