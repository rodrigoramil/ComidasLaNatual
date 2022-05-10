package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
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
	private static JPanel panelProductosAlmacen;	
	
	private static int resolucionBaseX = 800;
	private static int resolucionBaseY = 600;
	private static int resolucionX;
	private static int resolucionY;
	private static float cordenadaX;
	private static float cordenadaY;



//	private int ancho = 800;
//	private int alto = 600;

	/**
	 * Creamos la ventana principal que contendrá todos los paneles
	 */
	public VentanaPrincipal() {
		

		setResizable(false); // fija el tamaño de la ventana
		setTitle("Comidas La Natural");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculoResolucion();
		setSize(resolucionX, resolucionY);
		setExtendedState(MAXIMIZED_BOTH); //PANTALLA COMPLETA
		setLocationRelativeTo(null); // ventana en el centro de la pantalla
//		setIconImage(Toolkit.getDefaultToolkit().getImage("img/imagenicono.jpg"));		
		setVisible(true);				
		inicializarPaneles();

	}
	
	
	/**
	 * Inicializamos los objetos paneles
	 */
	private void inicializarPaneles() {	
		
		panelContenedor = new JPanel();
		panelContenedor.setBounds(0, 0, resolucionX,resolucionY);
		panelContenedor.setBackground(new Color(12,75,115));
		panelContenedor.setLayout(null);
		setContentPane(panelContenedor);
		
		panelLogin = new Login();
		panelLogin = Login.getPanelLogin();
		
		panelMenuPrincipal = new MenuPrincipal();
		panelMenuPrincipal = MenuPrincipal.getPanelMenuPrincipal();
		
		panelGestionPedidos = new GestionPedidos();
		panelGestionPedidos = GestionPedidos.getPanelGestionPedidos();

		panelRecetario = new Recetario();
		panelRecetario = Recetario.getPanelRecetario();
		
		panelAlmacen = new Almacen();
		panelAlmacen = Almacen.getPanelAlmacen();
			
		panelContabilidad = new Contabilidad();
		panelContabilidad = Contabilidad.getPanelContabilidad();
		
		panelGestionUsuarios = new GestionUsuarios();
		panelGestionUsuarios = GestionUsuarios.getPanelGestionUsuarios();
		
		panelUsuario = new Usuario();
		panelUsuario = Usuario.getPanelUsuario();
		
		panelReceta = new Receta();
		panelReceta = Receta.getPanelReceta();
		
		panelDetalleProducto = new DetalleProducto();
		panelDetalleProducto = DetalleProducto.getPanelDetalleProducto();
		
		panelPrepararCompra = new PrepararCompra();
		panelPrepararCompra = PrepararCompra.getPanelPrepararCompra();	
			
		panelListasCompra = new ListasCompra();

		panelListasCompra = ListasCompra.getPanelListasCompra();
		
		panelCliente = new Cliente();
		panelCliente = Cliente.getPanelcliente();
	
		panelPedido = new Pedido();
		panelPedido = Pedido.getPanelPedido();
		
		panelBuscarComidaBebida = new BuscarComidaBebida();
		panelBuscarComidaBebida = BuscarComidaBebida.getPanelBuscarComidaBebida();
		
		panelFacturar = new Facturar();
		panelFacturar = Facturar.getPanelFacturar();
		
		panelListaGastos = new ListaGastos();
		panelListaGastos = ListaGastos.getPanelListaGastos();
		
		panelListaFacturaciones = new ListaFacturaciones();
		panelListaFacturaciones = ListaFacturaciones.getPanelListaFacturaciones();
		
		panelDetalleGasto = new DetalleGasto();
		panelDetalleGasto = DetalleGasto.getPanelDetalleGasto();
		
		panelCalculoGastos = new CalculoGastos();
		panelCalculoGastos = CalculoGastos.getPaneCalculoGastos();
		
		panelDetalleFactura = new DetalleFactura();
		panelDetalleFactura = DetalleFactura.getPanelDetalleFactura();
		
		panelCalculoGanancias = new CalculoGanancias();
		panelCalculoGanancias = CalculoGanancias.getPanelCalculoGanancias();


		panelProductosAlmacen = new ProductosAlmacen();
		panelProductosAlmacen = ProductosAlmacen.getPanelProductosAlmacen();
	


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

public void calculoResolucion() {
		
		Dimension resolucion = Toolkit.getDefaultToolkit().getScreenSize(); //OBTENEMOS LA RESOLUCIÓN DE LA PANTALLA
		resolucionX = (int)resolucion.width;
		resolucionY = (int)resolucion.height;
		cordenadaX = ((float)resolucionX/resolucionBaseX);
		cordenadaY = ((float)resolucionY/resolucionBaseY);
		System.out.println(resolucionX+" "+cordenadaX);
		
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


	public static int getResolucionX() {
		return resolucionX;
	}


	public static int getResolucionY() {
		return resolucionY;
	}


	public static float getCordenadaX() {
		return cordenadaX;
	}


	public static float getCordenadaY() {
		return cordenadaY;
	}
	

}

