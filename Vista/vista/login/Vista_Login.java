package vista.login;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.login.Controlador_Login;

public class Vista_Login extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private static JPanel contentPane;
	private JLabel lbl_Usuario;
	private JLabel lbl_Contraseña;
	private JTextField jtf_Entrada_Nombre;
	private JPasswordField jtf_Entrada_Contrasena;
	private JButton btn_Aceptar;
	private JButton btn_Borrar;
	private static String tituloVentana = "Comidas La Natural - ";
	private int ancho = 450;
	private int alto = 300;

	public Vista_Login() {
		
		
		setResizable(false); // fina el tamaño de la ventana
		setTitle(tituloVentana + "Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(ancho, alto);	// tamaño de la ventana
		setLocationRelativeTo(null); // ventana en el centro de la pantalla
		getContentPane().setLayout(null); // desactiva el organizador de objetos de la ventana
//		setIconImage(Toolkit.getDefaultToolkit().getImage("img/imagenicono.jpg"));

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		inicializarComponentes();
		setVisible(true);
		establecerManejador();
	}


	public void inicializarComponentes() {
		

		
		btn_Aceptar = new JButton("Aceptar");
	
		btn_Aceptar.setBounds(93, 200, 90, 23);
		contentPane.add(btn_Aceptar);
		
		btn_Borrar = new JButton("Borrar");
		btn_Borrar.setBounds(246, 200, 90, 23);
		contentPane.add(btn_Borrar);
		
		jtf_Entrada_Nombre = new JTextField();
		jtf_Entrada_Nombre.setBounds(190, 80, 100, 20);
		contentPane.add(jtf_Entrada_Nombre);
		jtf_Entrada_Nombre.setColumns(10);
		
		jtf_Entrada_Contrasena = new JPasswordField();
		jtf_Entrada_Contrasena.setBounds(190, 120, 100, 20);
		contentPane.add(jtf_Entrada_Contrasena);
		
		lbl_Usuario = new JLabel("Usuario");
		lbl_Usuario.setBounds(105, 83, 66, 14);
		contentPane.add(lbl_Usuario);
		
		lbl_Contraseña = new JLabel("Contrase\u00F1a");
		lbl_Contraseña.setBounds(105, 125, 66, 14);
		contentPane.add(lbl_Contraseña);
	}
	
	public void establecerManejador() {			
			Controlador_Login controlador = new Controlador_Login(this);	
			btn_Aceptar.addActionListener(controlador);
			btn_Borrar.addActionListener(controlador);
		
	}



	public JLabel getLbl_Usuario() {
		return lbl_Usuario;
	}


	public void setLbl_Usuario(JLabel lbl_Usuario) {
		this.lbl_Usuario = lbl_Usuario;
	}


	public JLabel getLbl_Contraseña() {
		return lbl_Contraseña;
	}


	public void setLbl_Contraseña(JLabel lbl_Contraseña) {
		this.lbl_Contraseña = lbl_Contraseña;
	}


	public JTextField getJtf_Entrada_Nombre() {
		return jtf_Entrada_Nombre;
	}


	public void setJtf_Entrada_Nombre(JTextField jtf_Entrada_Nombre) {
		this.jtf_Entrada_Nombre = jtf_Entrada_Nombre;
	}


	public JPasswordField getJtf_Entrada_Contrasena() {
		return jtf_Entrada_Contrasena;
	}


	public void setJtf_Entrada_Contrasena(JPasswordField jtf_Entrada_Contrasena) {
		this.jtf_Entrada_Contrasena = jtf_Entrada_Contrasena;
	}


	public JButton getBtn_Aceptar() {
		return btn_Aceptar;
	}


	public void setBtn_Aceptar(JButton btn_Aceptar) {
		this.btn_Aceptar = btn_Aceptar;
	}


	public JButton getBtn_Borrar() {
		return btn_Borrar;
	}


	public void setBtn_Borrar(JButton btn_Borrar) {
		this.btn_Borrar = btn_Borrar;
	}

	public static String getTituloVentana() {
		return tituloVentana;
	}


	public static void setTituloVentana(String tituloVentana) {
		Vista_Login.tituloVentana = tituloVentana;
	}


	public int getAncho() {
		return ancho;
	}


	public void setAncho(int ancho) {
		this.ancho = ancho;
	}


	public int getAlto() {
		return alto;
	}


	public void setAlto(int alto) {
		this.alto = alto;
	}



}
