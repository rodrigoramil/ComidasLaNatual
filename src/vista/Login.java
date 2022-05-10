package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
// import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controlador.ControladorLogin;

public class Login extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7704498207380599407L;
	
	private static JPanel panelLogin;
	private static JLabel lbl_Usuario;
	private static JTextField jtf_Entrada_Nombre;
	private static JLabel lbl_Contraseña;	
	private static JPasswordField jtf_Entrada_Contrasena;
	private static JButton btn_Aceptar;
	private static JButton btn_Borrar;

	private static  Color verdeOscuro = new Color(3,36,9);
	
	public Login() {
		super();		
		inicializarComponentes();
	}

	public void inicializarComponentes() {

		//inicializamos PANEL
		panelLogin = new JPanel();
		
		//inicializamos USUARIO
		lbl_Usuario = new JLabel("USUARIO");
		jtf_Entrada_Nombre = new JTextField();
		
		//inicializamos CONTRASEÑA
		lbl_Contraseña = new JLabel("CONTRASE\u00d1A");
		jtf_Entrada_Contrasena = new JPasswordField();
		
		//inicializamos ACEPTAR BORRAR
		btn_Aceptar = new JButton("Aceptar");
		btn_Borrar = new JButton("Borrar");
		
		//eventos y visible
		establecerManejador();
		panelLogin.setVisible(true);
		
		//situacion PANEL
		panelLogin.setBackground(new Color(52,131,179));
		
		//calculamos inicialmente el tamaño del panel para saber su posicion central
		int xPanelLogin = Math.round(300*VentanaPrincipal.getCordenadaX());				//utilizamos la resolucion base 800 pixeles horizontales como medida
		int yPanelLogin = Math.round(300*VentanaPrincipal.getCordenadaY());				//utilizamos la resolucion base 600 pixeles verticales como medida
		int x = (VentanaPrincipal.getResolucionX()-xPanelLogin)/2;
		int y = (VentanaPrincipal.getResolucionY()-yPanelLogin)/2;
		
		panelLogin.setBounds(
								x,														//posicion HORIZONTAL
								y, 														//posicion VERTICAL
								xPanelLogin,											//tamaño HORIZONTA
								yPanelLogin);											//tamaño VERTICAL
		panelLogin.setLayout(null);
		
		//situacion USUARIO
		panelLogin.add(lbl_Usuario); 												//añadimos al panel
		lbl_Usuario.setFont(new Font("Manche Condensed",Font.BOLD,(int)(10*VentanaPrincipal.getCordenadaY())));
		lbl_Usuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_Usuario.setForeground(new Color(192,227,247));
		lbl_Usuario.setBounds(
								Math.round(20*VentanaPrincipal.getCordenadaX()), 		//posicion HORIZONTAL
								Math.round(83*VentanaPrincipal.getCordenadaY()),		//posicion VERTICAL
								Math.round(80*VentanaPrincipal.getCordenadaX()), 		//tamaño HORIZONTAL
								Math.round(14*VentanaPrincipal.getCordenadaY())); 		//tamaño VERTICAL
		
		panelLogin.add(jtf_Entrada_Nombre);											//añadimos al panel
		jtf_Entrada_Nombre.setFont(new Font("Manche Condensed",Font.BOLD,(int)(10*VentanaPrincipal.getCordenadaY())));
		jtf_Entrada_Nombre.setHorizontalAlignment(SwingConstants.CENTER);
		jtf_Entrada_Nombre.setBorder(null);
		jtf_Entrada_Nombre.setBounds(
								Math.round(110*VentanaPrincipal.getCordenadaX()), 		//posicion HORIZONTAL
								Math.round(80*VentanaPrincipal.getCordenadaY()),		//posicion VERTICAL 
								Math.round(160*VentanaPrincipal.getCordenadaX()),  		//tamaño HORIZONTAL
								Math.round(20*VentanaPrincipal.getCordenadaY())); 		//tamaño VERTICAL
		
		
		//situacion CONTRASEÑA
		panelLogin.add(lbl_Contraseña);												//añadimos al panel
		lbl_Contraseña.setFont(new Font("Manche Condensed",Font.BOLD,(int)(10*VentanaPrincipal.getCordenadaY())));
		lbl_Contraseña.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_Contraseña.setForeground(new Color(192,227,247));
		lbl_Contraseña.setBounds(
								Math.round(20*VentanaPrincipal.getCordenadaX()), 		//posicion HORIZONTAL
								Math.round(125*VentanaPrincipal.getCordenadaY()),		//posicion VERTICAL 
								Math.round(80*VentanaPrincipal.getCordenadaX()),  		//tamaño HORIZONTAL
								Math.round(14*VentanaPrincipal.getCordenadaY())); 		//tamaño VERTICAL
		
		panelLogin.add(jtf_Entrada_Contrasena);										//añadimos al panel
		jtf_Entrada_Contrasena.setFont(new Font("Manche Condensed",Font.BOLD,(int)(10*VentanaPrincipal.getCordenadaY())));
		jtf_Entrada_Contrasena.setHorizontalAlignment(SwingConstants.CENTER);
		jtf_Entrada_Contrasena.setBorder(null);
		jtf_Entrada_Contrasena.setBounds(
								Math.round(110*VentanaPrincipal.getCordenadaX()), 		//posicion HORIZONTAL
								Math.round(120*VentanaPrincipal.getCordenadaY()),		//posicion VERTICAL 
								Math.round(160*VentanaPrincipal.getCordenadaX()),  		//tamaño HORIZONTAL
								Math.round(20*VentanaPrincipal.getCordenadaY())); 		//tamaño VERTICAL
		

		
		
		//localizacion ACEPTAR BORRAR
		panelLogin.add(btn_Aceptar);												//añadimos al panel
		btn_Aceptar.setBackground(new Color(192,227,247));
		btn_Aceptar.setFont(new Font("Manche Condensed",Font.BOLD,(int)(12*VentanaPrincipal.getCordenadaY())));
		btn_Aceptar.setBorder(null);
		btn_Aceptar.setBounds(
								Math.round(40*VentanaPrincipal.getCordenadaX()), 		//posicion HORIZONTAL
								Math.round(200*VentanaPrincipal.getCordenadaY()),		//posicion VERTICAL 
								Math.round(90*VentanaPrincipal.getCordenadaX()),  		//tamaño HORIZONTAL
								Math.round(23*VentanaPrincipal.getCordenadaY())); 		//tamaño VERTICAL
		
		panelLogin.add(btn_Borrar);													//añadimos al panel
		btn_Borrar.setBackground(new Color(192,227,247));
		btn_Borrar.setFont(new Font("Manche Condensed",Font.BOLD,(int)(12*VentanaPrincipal.getCordenadaY())));
		btn_Borrar.setBorder(null);
		btn_Borrar.setBounds(
								Math.round(170*VentanaPrincipal.getCordenadaX()),  		//posicion HORIZONTAL
								Math.round(200*VentanaPrincipal.getCordenadaY()), 		//posicion VERTICAL 
								Math.round(90*VentanaPrincipal.getCordenadaX()),  		//tamaño HORIZONTAL
								Math.round(23*VentanaPrincipal.getCordenadaY())); 		//tamaño VERTICAL
		

		establecerManejador();
	}
	
	public void establecerManejador() {			
			ControladorLogin controlador = new ControladorLogin(this);	
			btn_Aceptar.addActionListener(controlador);
			btn_Borrar.addActionListener(controlador);
		
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
