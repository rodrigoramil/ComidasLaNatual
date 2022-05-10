
package vista;


import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlador.ControladorMenuPrincipal;
import javax.swing.JButton;


public class MenuPrincipal extends JPanel {

	private static final long serialVersionUID = 1426442970510327864L;
	
	private static JPanel panelMenuPrincipal;
	private static JButton btn_Contabilidad;
	private static JButton btn_Ventas;
	private static JButton btn_Recetario;
	private static JButton btn_Almacen;
	private static JButton btn_Gestion_Usuario;
	private static JButton btn_Cerrar_Sesion;
	
	private int ancho = 800;
	private int alto = 600;
	private int posicionPanel_x = 100;
	private int posicionPanel_y = 50;

	public MenuPrincipal() {
		super();
		inicializarComponentes();
		establecerManejador();		
	}

	
	public void inicializarComponentes() {
		
		panelMenuPrincipal = new JPanel();		
		panelMenuPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelMenuPrincipal.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		panelMenuPrincipal.setLayout(null);
		panelMenuPrincipal.setVisible(false);
		
		btn_Contabilidad = new JButton("Contabilidad");	
		btn_Contabilidad.setEnabled(true);
		btn_Contabilidad.setBounds(337, 148, 91, 23);
		panelMenuPrincipal.add(btn_Contabilidad);
		
		btn_Ventas = new JButton("Ventas");
		btn_Ventas.setBounds(16, 148, 91, 23);
		panelMenuPrincipal.add(btn_Ventas);
		
		btn_Recetario = new JButton("Recetario");
		btn_Recetario.setEnabled(true);
		btn_Recetario.setBounds(123, 148, 91, 23);
		panelMenuPrincipal.add(btn_Recetario);
		
		btn_Almacen = new JButton("Almac\u00E9n");	
		btn_Almacen.setEnabled(true);
		btn_Almacen.setBounds(230, 148, 91, 23);
		panelMenuPrincipal.add(btn_Almacen);
		
		btn_Gestion_Usuario = new JButton("Gesti\u00F3n de usuarios");	
		btn_Gestion_Usuario.setEnabled(true);
		btn_Gestion_Usuario.setBounds(444, 148, 136, 23);
		panelMenuPrincipal.add(btn_Gestion_Usuario);
		
		btn_Cerrar_Sesion = new JButton("Cerrar Sesi\u00F3n");
		btn_Cerrar_Sesion.setBounds(230, 255, 97, 23);
		panelMenuPrincipal.add(btn_Cerrar_Sesion);		
		
	}
	

	public void establecerManejador() {			
		ControladorMenuPrincipal controlador = new ControladorMenuPrincipal(this);
		btn_Contabilidad.addActionListener(controlador);
		btn_Ventas.addActionListener(controlador);
		btn_Recetario.addActionListener(controlador);
		btn_Almacen.addActionListener(controlador);
		btn_Gestion_Usuario.addActionListener(controlador);
		btn_Cerrar_Sesion.addActionListener(controlador);
	
	}



	public static JPanel getPanelMenuPrincipal() {
		return panelMenuPrincipal;
	}


	public static JButton getBtn_Contabilidad() {
		return btn_Contabilidad;
	}


	public static JButton getBtn_Ventas() {
		return btn_Ventas;
	}


	public static JButton getBtn_Recetario() {
		return btn_Recetario;
	}


	public static JButton getBtn_Almacen() {
		return btn_Almacen;
	}


	public static JButton getBtn_Gestion_Usuario() {
		return btn_Gestion_Usuario;
	}


	public static JButton getBtn_Cerrar_Sesion() {
		return btn_Cerrar_Sesion;
	}
	
}
