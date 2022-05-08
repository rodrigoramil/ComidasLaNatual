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
	private static JPanel panelPrepararCompra;	
	private static JPanel panelAlmacen;
	private static JPanel panelBuscarComidaBebida;
	private static JPanel panelCalculoGanancias;
	private static JPanel panelCalculoGastos;
	private static JPanel panelCliente;
	private static JPanel panelContabilidad;
	private static JPanel panelDetalleFactura;
	private static JPanel panelDetalleGasto;
	private static JPanel panelFacturar;
	private static JPanel panelGestionUsuarios;
	private static JPanel panelListaGastos;
	private static JPanel panelListasCompra;
	private static JPanel panelListaFacturaciones;
	private static JPanel panelPedido;
	private static JPanel panelReceta;
	private static JPanel panelRecetario;
	private static JPanel panelUsuario;
	private static JPanel panelDetalleProducto;
	
	private static JPanel panelProductosAlmacen;	// <- clase no implementada
	
	
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

		panelRecetario = new Recetario();
		panelRecetario = Recetario.inicializarComponentes();
		
		panelAlmacen = new Almacen();
		panelAlmacen = Almacen.inicializarComponentes();
			
		panelContabilidad = new Contabilidad();
		panelContabilidad = Contabilidad.inicializarComponentes();
		
		panelGestionUsuarios = new GestionUsuarios();
		panelGestionUsuarios = GestionUsuarios.inicializarComponentes();
		
		panelUsuario = new Usuario();
		panelUsuario = Usuario.inicializarComponentes();
		
		panelReceta = new Receta();
		panelReceta = Receta.inicializarComponentes();
		
		panelDetalleProducto = new DetalleProducto();
		panelDetalleProducto = DetalleProducto.inicializarComponentes();
		
		panelPrepararCompra = new PrepararCompra();
		panelPrepararCompra = PrepararCompra.inicializarComponentes();	
			
		panelListasCompra = new ListasCompra();
		panelListasCompra = ListasCompra.inicializarComponentes();
		
		panelCliente = new Cliente();
		panelCliente = Cliente.inicializarComponentes();
	
		panelPedido = new Pedido();
		panelPedido = Pedido.inicializarComponentes();
		
		panelBuscarComidaBebida = new BuscarComidaBebida();
		panelBuscarComidaBebida = BuscarComidaBebida.inicializarComponentes();
		
		panelFacturar = new Facturar();
		panelFacturar = Facturar.inicializarComponentes();
		
		panelListaGastos = new ListaGastos();
		panelListaGastos = ListaGastos.inicializarComponentes();
		
		panelListaFacturaciones = new ListaFacturaciones();
		panelListaFacturaciones = ListaFacturaciones.inicializarComponentes();
		
		panelDetalleGasto = new DetalleGasto();
		panelDetalleGasto = DetalleGasto.inicializarComponentes();
		
		panelCalculoGastos = new CalculoGastos();
		panelCalculoGastos = CalculoGastos.inicializarComponentes();
		
		panelDetalleFactura = new DetalleFactura();
		panelDetalleFactura = DetalleFactura.inicializarComponentes();
		
		panelCalculoGanancias = new CalculoGanancias();
		panelCalculoGanancias = CalculoGanancias.inicializarComponentes();


		panelProductosAlmacen = new ProductosAlmacen();
		panelProductosAlmacen = ProductosAlmacen.inicializarComponentes();
	


		/**
		 * Añadimos todos los paneles al panel que contiene todos los paneles
		 */
		
		panelContenedor.add(panelLogin);
		panelContenedor.add(panelMenuPrincipal);
		panelContenedor.add(panelGestionPedidos);
		panelContenedor.add(panelRecetario);
		panelContenedor.add(panelAlmacen);		
		panelContenedor.add(panelContabilidad);	
		panelContenedor.add(panelGestionUsuarios);
		panelContenedor.add(panelUsuario);
		panelContenedor.add(panelReceta);
		panelContenedor.add(panelDetalleProducto);
		panelContenedor.add(panelPrepararCompra);
		panelContenedor.add(panelListasCompra);
		panelContenedor.add(panelCliente);
		panelContenedor.add(panelPedido);
		panelContenedor.add(panelBuscarComidaBebida);
		panelContenedor.add(panelFacturar);
		panelContenedor.add(panelListaGastos);
		panelContenedor.add(panelListaFacturaciones);
		panelContenedor.add(panelDetalleGasto);
		panelContenedor.add(panelCalculoGastos);
		panelContenedor.add(panelDetalleFactura);
		panelContenedor.add(panelCalculoGanancias);
		panelContenedor.add(panelProductosAlmacen);

		
	}


	/**
	 * Get y Set
	 * @return
	 */

	public static JPanel getPanelContenedor() {
		return panelContenedor;
	}


	public static JPanel getPanelLogin() {
		return panelLogin;
	}


	public static JPanel getPanelMenuPrincipal() {
		return panelMenuPrincipal;
	}


	public static JPanel getPanelGestionPedidos() {
		return panelGestionPedidos;
	}


	public static JPanel getPanelPrepararCompra() {
		return panelPrepararCompra;
	}


	public static JPanel getPanelProductosAlmacen() {
		return panelProductosAlmacen;
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


	public static JPanel getPanelDetalleGasto() {
		return panelDetalleGasto;
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


	public static JPanel getPanelListasCompra() {
		return panelListasCompra;
	}


	public static JPanel getPanelListaFacturaciones() {
		return panelListaFacturaciones;
	}


	public static JPanel getPanelPedido() {
		return panelPedido;
	}


	public static JPanel getPanelDetalleProducto() {
		return panelDetalleProducto;
	}


	public static JPanel getPanelReceta() {
		return panelReceta;
	}


	public static JPanel getPanelRecetario() {
		return panelRecetario;
	}


	public static JPanel getPanelUsuario() {
		return panelUsuario;
	}

}

