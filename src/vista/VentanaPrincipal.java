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
	private static JPanel panelGestionPedidos;
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

	/**
	 * Creamos la ventana principal que contendrá todos los paneles
	 */
	public VentanaPrincipal() {
		
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
	
	
	/**
	 * Inicializamos los objetos paneles
	 */
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
		
		panelGestionPedidos = new GestionPedidos();
		panelGestionPedidos = GestionPedidos.inicializarComponentes();

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		panelContenedor.add(panelLogin);
		panelContenedor.add(panelMenuPrincipal);
		panelContenedor.add(panelGestionPedidos);
		
	}


	/**
	 * Get y Set
	 * @return
	 */

	public static JPanel getPanelLogin() {
		return panelLogin;
	}



	public static JPanel getPanelMenuPrincipal() {
		return panelMenuPrincipal;
	}



	public static JPanel getPanelContenedor() {
		return panelContenedor;
	}



	public static JPanel getPanelGestionPedidos() {
		return panelGestionPedidos;
	}



	public static JPanel getPanelListadoListaCompra() {
		return panelListadoListaCompra;
	}



	public static JPanel getPanelProducto() {
		return panelProducto;
	}



	public static JPanel getPanelAlmacen() {
		return panelAlmacen;
	}



	public static JPanel getPanelBuscarComidaBebida() {
		return panelBuscarComidaBebida;
	}



	public static JPanel getPanelCalculoGanancias() {
		return panelCalculoGanancias;
	}



	public static JPanel getPanelCalculoGastos() {
		return panelCalculoGastos;
	}



	public static JPanel getPanelCliente() {
		return panelCliente;
	}



	public static JPanel getPanelContabilidad() {
		return panelContabilidad;
	}



	public static JPanel getPanelDetalleFactura() {
		return panelDetalleFactura;
	}



	public static JPanel getPanelDetalleBasto() {
		return panelDetalleBasto;
	}



	public static JPanel getPanelFacturar() {
		return panelFacturar;
	}



	public static JPanel getPanelGestionUsuarios() {
		return panelGestionUsuarios;
	}



	public static JPanel getPanelListaGastos() {
		return panelListaGastos;
	}



	public static JPanel getPanelListaCompra() {
		return panelListaCompra;
	}



	public static JPanel getPanelListaFacturaciones() {
		return panelListaFacturaciones;
	}



	public static JPanel getPanelPedido() {
		return panelPedido;
	}



	public static JPanel getPanelProductosAlmacen() {
		return panelProductosAlmacen;
	}



	public static JPanel getPanelReceta() {
		return panelReceta;
	}



	public static JPanel getPanelRecetario() {
		return panelRecetario;
	}



	public static JPanel getPanelUsuarios() {
		return panelUsuarios;
	}


	
	

	
	

}

