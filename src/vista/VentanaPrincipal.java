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
	private static JPanel panelProducto;
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
	private static JPanel panelProductosAlmacen;
	private static JPanel panelReceta;
	private static JPanel panelRecetario;
	private static JPanel panelUsuario;
	
	private int ancho = 800;
	private int alto = 600;

	/**
	 * Creamos la ventana principal que contendr� todos los paneles
	 */
	public VentanaPrincipal() {
		
		setResizable(false); // fina el tama�o de la ventana
		setTitle("Comidas La Natural");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(ancho, alto);	// tama�o de la ventana
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
		
		//--
		/*
		panelPrepararCompra = new PrepararCompra();
		panelPrepararCompra = PrepararCompra.inicializarComponentes();
		
		panelProducto = new Producto();
		panelProducto = Producto.inicializarComponentes();
		
		panelBuscarComidaBebida = new BuscarComidaBebida();
		panelBuscarComidaBebida = BuscarComidaBebida.inicializarComponentes();
		
		panelCalculoGanancias = new CalculoGanancias();
		panelCalculoGanancias = CalculoGanancias.inicializarComponentes();
		
		panelCalculoGastos = new CalculoGastos();
		panelCalculoGastos = CalculoGastos.inicializarComponentes();
		
		panelCliente = new Cliente();
		panelCliente = Cliente.inicializarComponentes();
		
		panelContabilidad = new Contabilidad();
		panelContabilidad = Contabilidad.inicializarComponentes();
		
		panelDetalleFactura = new DetalleFactura();
		panelDetalleFactura = DetalleFactura.inicializarComponentes();
		
		panelDetalleGasto = new DetalleGasto();
		panelDetalleGasto = DetalleGasto.inicializarComponentes();
	
		panelFacturar = new Facturar();
		panelFacturar = Facturar.inicializarComponentes();
		
		
		panelGestionUsuarios = new GestionUsuarios();
		panelGestionUsuarios = GestionUsuarios.inicializarComponentes();
		
		panelListaGastos = new ListaGastos();
		panelListaGastos = ListaGastos.inicializarComponentes();
		
		panelListasCompra = new ListasCompra();
		panelListasCompra = ListasCompra.inicializarComponentes();
		
		panelListaFacturaciones = new ListaFacturaciones();
		panelListaFacturaciones = ListaFacturaciones.inicializarComponentes();
		
		panelPedido = new Pedido();
		panelPedido = Pedido.inicializarComponentes();
		
		panelProductosAlmacen = new ProductosAlmacen();
		panelProductosAlmacen = ProductosAlmacen.inicializarComponentes();
		
		panelReceta = new Receta();
		panelReceta = Receta.inicializarComponentes();
		
		panelUsuario = new Usuario();
		panelUsuario = Usuario.inicializarComponentes();
		

		/**
		 * A�adimos todos los paneles al panel que contiene todos los paneles
		 */
		
		panelContenedor.add(panelLogin);
		panelContenedor.add(panelMenuPrincipal);
		panelContenedor.add(panelGestionPedidos);
		panelContenedor.add(panelRecetario);
		panelContenedor.add(panelAlmacen);
		panelContenedor.add(panelContabilidad);	
		/*
		panelContenedor.add(panelPrepararCompra);
		
		panelContenedor.add(panelProducto);		
		panelContenedor.add(panelBuscarComidaBebida);
		panelContenedor.add(panelCalculoGanancias);
		panelContenedor.add(panelCalculoGastos);
		panelContenedor.add(panelCliente);
		panelContenedor.add(panelDetalleFactura);
		panelContenedor.add(panelDetalleGasto);
		panelContenedor.add(panelFacturar);
		panelContenedor.add(panelGestionUsuarios);
		panelContenedor.add(panelListaGastos);
		panelContenedor.add(panelListasCompra);
		panelContenedor.add(panelListaFacturaciones);
		panelContenedor.add(panelPedido);
		panelContenedor.add(panelProductosAlmacen);
		panelContenedor.add(panelReceta);
		panelContenedor.add(panelUsuario);
	*/
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


	public static JPanel getPanelProductosAlmacen() {
		return panelProductosAlmacen;
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

