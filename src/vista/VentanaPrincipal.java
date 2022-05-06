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
	
	private static JPanel panelContenedor;
	private static JPanel panelLogin;
	private static JPanel panelMenuPrincipal;
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
	private static JPanel panelProductosAlmacen;
	private static JPanel panelReceta;
	private static JPanel panelRecetario;
	private static JPanel panelUsuarios;
	
	private int ancho = 800;
	private int alto = 600;


	public VentanaPrincipal() {
		
//		contenedor = getContentPane();
		setResizable(false); // fina el tamaño de la ventana
		setTitle("Comidas La Natural");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(ancho, alto);	// tamaño de la ventana
		setLocationRelativeTo(null); // ventana en el centro de la pantalla
		setLayout(null); // desactiva el organizador de objetos de la ventana
//		setIconImage(Toolkit.getDefaultToolkit().getImage("img/imagenicono.jpg"));
		setVisible(true);
				
		inicializarPaneles();		
	}
	
	
	
	private void inicializarPaneles() {
		
		panelContenedor = new JPanel();
		panelContenedor.setBounds(0 , 0, ancho, alto);
		panelContenedor.setLayout(null);
		panelContenedor.setVisible(true);		
		setContentPane(panelContenedor);

		panelLogin = new Login();
		panelLogin = Login.inicializarComponentes();
		
		panelMenuPrincipal = new MenuPrincipal();
		panelMenuPrincipal = MenuPrincipal.inicializarComponentes();		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		panelContenedor.add(panelLogin);
		panelContenedor.add(panelMenuPrincipal);
		
	}



	public static JPanel getPanelLogin() {
		return panelLogin;
	}



	public static JPanel getPanelMenuPrincipal() {
		return panelMenuPrincipal;
	}


	
	

	
	

}

