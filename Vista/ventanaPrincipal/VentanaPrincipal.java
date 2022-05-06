package ventanaPrincipal;

import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vista.login.Vista_Login;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3544609316086588704L;
//	private JPanel contentPane;
	private static JPanel contentPane;
	private static String tituloVista;
	private int ancho = 800;
	private int alto = 600;

	
	
	public VentanaPrincipal() {
		
		setResizable(false); // fina el tamaño de la ventana
		setTitle("Comidas La Natural" + tituloVista );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(ancho, alto);	// tamaño de la ventana
		setLocationRelativeTo(null); // ventana en el centro de la pantalla
		setLayout(null); // desactiva el organizador de objetos de la ventana
//		setIconImage(Toolkit.getDefaultToolkit().getImage("img/imagenicono.jpg"));
//		inicializarComponentes();
		setVisible(true);
		
		Vista_Login vista_Login= new Vista_Login();
		
		/*
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
//		contentPane = new Vista_Login();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		*/
		
		
		
		
		
		/*
		setResizable(false); // fina el tamaño de la ventana
		setTitle("Comidas La Natural" + tituloVista );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(ancho, alto);	// tamaño de la ventana
		setLocationRelativeTo(null); // ventana en el centro de la pantalla
		setLayout(null); // desactiva el organizador de objetos de la ventana
//		setIconImage(Toolkit.getDefaultToolkit().getImage("img/imagenicono.jpg"));
		inicializarComponentes();
		setVisible(true);
		
		*/

		
/*		
 		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
*/		

	}
	
	
	public void crearPanel() {
		
	}
	
	
	/*
	private void inicializarComponentes() {

		vistaLogin = new Vista_Login();
		vistaLogin.setVisible(true);
		this.add(vistaLogin);

/*
		panel_menu_principal = new Panel_menu_principal(this.getWidth(), this.getHeight());
		this.add(panel_menu_principal);

		panel_gestion_usuarios = new Panel_gestion_usuarios(this.getWidth(), this.getHeight());
		this.add(panel_gestion_usuarios);

		panel_usuario = new Panel_usuario(this.getWidth(), this.getHeight());
		this.add(panel_usuario);

		panel_productos_almacen = new Panel_productos_almacen(this.getWidth(), this.getHeight());
		this.add(panel_productos_almacen);		

		panel_recetario = new Panel_recetario(this.getWidth(), this.getHeight());
		this.add(panel_recetario);
		
		panel_receta = new Panel_receta(this.getWidth(), this.getHeight());
		this.add(panel_receta);

		panel_cliente = new Panel_cliente(this.getWidth(), this.getHeight());
		this.add(panel_cliente);
		
		panel_pedido = new Panel_pedido(this.getWidth(), this.getHeight());
		this.add(panel_pedido);

		panel_contabilidad = new Panel_contabilidad(this.getWidth(), this.getHeight());
		this.add(panel_contabilidad);

		panel_lista_facturacion = new Panel_lista_facturacion(this.getWidth(), this.getHeight());
		this.add(panel_lista_facturacion);
				
		panel_detalle_gastos = new Panel_detalle_gastos(this.getWidth(), this.getHeight());
		this.add(panel_detalle_gastos);
		
		panel_detalle_factura = new Panel_detalle_factura(this.getWidth(), this.getHeight());
		this.add(panel_detalle_factura);

		panel_lista_gastos = new Panel_lista_gastos(this.getWidth(), this.getHeight()); 
		this.add(panel_lista_gastos);
		
		panel_calculo_gastos = new Panel_calculo_gastos(this.getWidth(), this.getHeight()); 
		this.add(panel_calculo_gastos);
		
		panel_gestion_pedidos = new Panel_gestion_pedidos(this.getWidth(), this.getHeight()); 
		this.add(panel_gestion_pedidos);
		
		panel_buscar_comida_bebida = new Panel_buscar_comida_bebida(this.getWidth(), this.getHeight());
		this.add(panel_buscar_comida_bebida);
		
		panel_facturar = new Panel_facturar(this.getWidth(), this.getHeight());
		this.add(panel_facturar);
		
		panel_lista_compra = new Panel_lista_compra(this.getWidth(), this.getHeight());
		this.add(panel_lista_compra);

		panel_gestion_listas_compra = new Panel_gestion_listas_compra(this.getWidth(), this.getHeight());
		this.add(panel_gestion_listas_compra);
		
		panel_almacen = new Panel_almacen(this.getWidth(), this.getHeight());
		this.add(panel_almacen);
		
		panel_producto_almacen = new Panel_producto_almacen(this.getWidth(), this.getHeight());
		this.add(panel_producto_almacen);
		
}
		
*/
	public void addEvent ( MouseListener controlador) {
/*
		vistaLogin.addMouseListener(controlador);
		
		
		panel_menu_principal.establecerManejador();
		panel_gestion_usuarios.establecerManejador();
		panel_usuario.establecerManejador();
		panel_productos_almacen.establecerManejador();
		panel_recetario.establecerManejador();
		panel_receta.establecerManejador();
		panel_cliente.establecerManejador();
		panel_pedido.establecerManejador();
		panel_gestion_pedidos.establecerManejador();
		panel_buscar_comida_bebida.establecerManejador();
		panel_facturar.establecerManejador();
		panel_calculo_gastos.establecerManejador();
		panel_contabilidad.establecerManejador();
		panel_detalle_factura.establecerManejador();
		panel_detalle_gastos.establecerManejador();
		panel_lista_gastos.establecerManejador();
		panel_lista_facturacion.establecerManejador();
		panel_lista_compra.establecerManejador();
		panel_gestion_listas_compra.establecerManejador();
		panel_almacen.establecerManejador();
		panel_producto_almacen.establecerManejador();
*/
	}
/*
	public static String getTituloVista() {
		return tituloVista;
	}

	public static void setTituloVista(String tituloVista) {
		VentanaPrincipal.tituloVista = tituloVista;
	}
	
	*/
	
	
	

}
