package vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import controlador.ControladorLogin;

public class Login extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7704498207380599407L;
	
	private static JPanel panelLogin;
	private static JLabel lbl_Usuario;
	private static JTextField jtf_Entrada_Nombre;
	private static JLabel lbl_Contrase�a;	
	private static JPasswordField jtf_Entrada_Contrasena;
	private static JButton btn_Aceptar;
	private static JButton btn_Borrar;
	
	public Login() {
		super();		
		inicializarComponentes();
		establecerManejador();
	}

	public void inicializarComponentes() {

		//inicializamos PANEL
		panelLogin = VentanaPrincipal.parametrosPanel(300,300);
		
		//inicializamos USUARIO
		lbl_Usuario = VentanaPrincipal.parametrosJlabel("USUARIO",15, 83, 90,14);
		lbl_Usuario.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLogin.add(lbl_Usuario); 												//a�adimos al panel
		
		
		jtf_Entrada_Nombre = VentanaPrincipal.parametrosJTextField(115, 80, 160, 20);
		jtf_Entrada_Nombre.setHorizontalAlignment(SwingConstants.CENTER);
		panelLogin.add(jtf_Entrada_Nombre);												//a�adimos al panel
		
		//inicializamos CONTRASE�A
		lbl_Contrase�a = VentanaPrincipal.parametrosJlabel("CONTRASE\u00d1A",15, 125, 90,14);
		lbl_Contrase�a.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLogin.add(lbl_Contrase�a);													//a�adimos al panel
		
		jtf_Entrada_Contrasena = new JPasswordField();
		jtf_Entrada_Contrasena.setFont(new Font("Manche Condensed",Font.BOLD,(int)(12*VentanaPrincipal.getCordenadaY())));
		jtf_Entrada_Contrasena.setHorizontalAlignment(SwingConstants.CENTER);
		jtf_Entrada_Contrasena.setBorder(null);
		jtf_Entrada_Contrasena.setBounds(
								Math.round(115*VentanaPrincipal.getCordenadaX()), 		//posicion HORIZONTAL
								Math.round(120*VentanaPrincipal.getCordenadaY()),		//posicion VERTICAL 
								Math.round(160*VentanaPrincipal.getCordenadaX()),  		//tama�o HORIZONTAL
								Math.round(20*VentanaPrincipal.getCordenadaY())); 		//tama�o VERTICAL
		panelLogin.add(jtf_Entrada_Contrasena);											//a�adimos al panel
		

		//localizacion ACEPTAR BORRAR
		btn_Aceptar = VentanaPrincipal.parametrosJButton("Aceptar",40,200,90,23);
		panelLogin.add(btn_Aceptar);													//a�adimos al panel
		
		
		btn_Borrar = VentanaPrincipal.parametrosJButton("Borrar", 170, 200, 90, 23);
		panelLogin.add(btn_Borrar);														//a�adimos al panel
		
		
		panelLogin.setVisible(true);
	}
	
	
	public void establecerManejador() {			
			ControladorLogin controlador = new ControladorLogin(this);	
			btn_Aceptar.addMouseListener(controlador);
			btn_Borrar.addMouseListener(controlador);
		
	}

	public static JPanel getPanelLogin() {
		return panelLogin;
	}
	
	public JButton getBtn_Aceptar() {
		return btn_Aceptar;
	}

	public JButton getBtn_Borrar() {
		return btn_Borrar;
	}


	public JTextField getJtf_Entrada_Nombre() {
		return jtf_Entrada_Nombre;
	}

	public JPasswordField getJtf_Entrada_Contrasena() {
		return jtf_Entrada_Contrasena;
	}
}
