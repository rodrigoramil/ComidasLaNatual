package ventanaPrincipal;

import java.awt.Container;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import vista.login.Vista_Login;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3544609316086588704L;
	
	private static String tituloVentana =Vista_Login.getTituloVentana() ;
	private int ancho = 450;
	private int alto = 300;

	private Container contenedor;


	private JPanel panelLogin;

	public VentanaPrincipal() {
		
		contenedor = getContentPane();
		setResizable(false); // fina el tamaño de la ventana
		setTitle("Comidas La Natural - " + tituloVentana);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(ancho, alto);	// tamaño de la ventana
		setLocationRelativeTo(null); // ventana en el centro de la pantalla
		contenedor.setLayout(null); // desactiva el organizador de objetos de la ventana
//		setIconImage(Toolkit.getDefaultToolkit().getImage("img/imagenicono.jpg"));
		setVisible(true);
				
		inicializarPaneles();
		establecerManejador();
		
	}
	
	
	
	private void inicializarPaneles() {
		

		panelLogin = new Vista_Login();
		panelLogin = Vista_Login.inicializarComponentes();		
		setContentPane(panelLogin);	
		panelLogin.setVisible(true);
		
		
	}
	
	
	
	
	
	
	public void establecerManejador() {	
		/*
		Controlador_Login controlador = new Controlador_Login(this);	
		btn_Aceptar.addActionListener(controlador);
		btn_Borrar.addActionListener(controlador);
	*/
	}



	public static String getTituloVentana() {
		return tituloVentana;
	}



	public static void setTituloVentana(String tituloVentana) {
		VentanaPrincipal.tituloVentana = tituloVentana;
	}
	
	
	

}




/*
 
 	
	
	public Controlador_Login(Vista_Login vista_Login) {
		this.vistaLogin = vista_Login;
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vistaLogin.getBtn_Aceptar()) {
*/
