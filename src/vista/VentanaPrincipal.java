package vista;

import java.awt.Container;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3544609316086588704L;
	
	private int ancho = 450;
	private int alto = 300;

	private Container contenedor;


	private static JPanel panelLogin;
	private static JPanel panelMenuprincipal;
	private static JPanel panelListadoListaCompra;
	private static JPanel panelProducto;
	private static JPanel panelAlmacen;
	private static JPanel panelBuscarComidaBebida;
	private static JPanel panelCalculoGanancias;
	private static JPanel panelCalculoGastos;
	private static JPanel panelCliente;
	private static JPanel panelContabilidad;
	private static JPanel panelDetalleFactura;
	private static JPanel panelDetalleBasto;
	private static JPanel panelFacturar;
	private static JPanel panelGestionPedidos;
	private static JPanel panelGestionUsuarios;
	private static JPanel panelListaGastos;
	private static JPanel panelListaCompra;
	private static JPanel panelListaFacturaciones;
	private static JPanel panelPedido;
	private static JPanel _panelProductosAlmacen;
	private static JPanel panelReceta;
	private static JPanel panelRecetario;
	private static JPanel panelUsuarios;

	public VentanaPrincipal() {
		
		contenedor = getContentPane();
		setResizable(false); // fina el tamaño de la ventana
		setTitle("Comidas La Natural");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(ancho, alto);	// tamaño de la ventana
		setLocationRelativeTo(null); // ventana en el centro de la pantalla
		contenedor.setLayout(null); // desactiva el organizador de objetos de la ventana
//		setIconImage(Toolkit.getDefaultToolkit().getImage("img/imagenicono.jpg"));
		setVisible(true);
				
		inicializarPaneles();		
	}
	
	
	
	private void inicializarPaneles() {
		

		panelLogin = new Vista_Login();
		panelLogin = Vista_Login.inicializarComponentes();		
		setContentPane(panelLogin);	
		panelLogin.setVisible(true);
		
		
	}



	public static JPanel getPanelLogin() {
		return panelLogin;
	}



	public static void setPanelLogin(JPanel panelLogin) {
		VentanaPrincipal.panelLogin = panelLogin;
	}
	
	
	

	
	

}

