package vista;


import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlador.Controlador_Menu_Principal;
import javax.swing.JButton;


public class Vista_Menu_Principal extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private static JPanel vistaMenuPrincipal;
	private static JButton btn_Contabilidad;
	private static JButton btn_Ventas;
	private static JButton btn_Recetario;
	private static JButton btn_Almacen;
	private static JButton btn_Gestion_Usuario;
	private static JButton btn_Cerrar_Sesion;
	
	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;

	public Vista_Menu_Principal() {			
		
		vistaMenuPrincipal = new JPanel();		
		btn_Contabilidad = new JButton("Contabilidad");		
		btn_Ventas = new JButton("Ventas");
		btn_Recetario = new JButton("Recetario");		
		btn_Almacen = new JButton("Almac\u00E9n");		
		btn_Gestion_Usuario = new JButton("Gesti\u00F3n de usuarios");		
		btn_Cerrar_Sesion = new JButton("Cerrar Sesi\u00F3n");
		
		establecerManejador();		
		vistaMenuPrincipal.setVisible(false);
	}

	
	
	
	public static JPanel inicializarComponentes() {
		
		vistaMenuPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		vistaMenuPrincipal.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		vistaMenuPrincipal.setLayout(null);

		btn_Contabilidad.setEnabled(true);
		btn_Contabilidad.setBounds(337, 148, 91, 23);
		vistaMenuPrincipal.add(btn_Contabilidad);
		
		btn_Ventas.setBounds(16, 148, 91, 23);
		vistaMenuPrincipal.add(btn_Ventas);
		
		btn_Recetario.setEnabled(true);
		btn_Recetario.setBounds(123, 148, 91, 23);
		vistaMenuPrincipal.add(btn_Recetario);
		
		btn_Almacen.setEnabled(true);
		btn_Almacen.setBounds(230, 148, 91, 23);
		vistaMenuPrincipal.add(btn_Almacen);
		
		btn_Gestion_Usuario.setEnabled(true);
		btn_Gestion_Usuario.setBounds(444, 148, 136, 23);
		vistaMenuPrincipal.add(btn_Gestion_Usuario);
		
		btn_Cerrar_Sesion.setBounds(230, 255, 97, 23);
		vistaMenuPrincipal.add(btn_Cerrar_Sesion);
		
		
		return vistaMenuPrincipal;
	}
	

	public void establecerManejador() {			
		Controlador_Menu_Principal controlador = new Controlador_Menu_Principal(this);
		btn_Contabilidad.addActionListener(controlador);
		btn_Ventas.addActionListener(controlador);
		btn_Recetario.addActionListener(controlador);
		btn_Almacen.addActionListener(controlador);
		btn_Gestion_Usuario.addActionListener(controlador);
		btn_Cerrar_Sesion.addActionListener(controlador);
	
	}




	public static JPanel getVistaMenuPrincipal() {
		return vistaMenuPrincipal;
	}




	public static void setVistaMenuPrincipal(JPanel vistaMenuPrincipal) {
		Vista_Menu_Principal.vistaMenuPrincipal = vistaMenuPrincipal;
	}




	public static JButton getBtn_Contabilidad() {
		return btn_Contabilidad;
	}




	public static void setBtn_Contabilidad(JButton btn_Contabilidad) {
		Vista_Menu_Principal.btn_Contabilidad = btn_Contabilidad;
	}




	public static JButton getBtn_Ventas() {
		return btn_Ventas;
	}




	public static void setBtn_Ventas(JButton btn_Ventas) {
		Vista_Menu_Principal.btn_Ventas = btn_Ventas;
	}




	public static JButton getBtn_Recetario() {
		return btn_Recetario;
	}




	public static void setBtn_Recetario(JButton btn_Recetario) {
		Vista_Menu_Principal.btn_Recetario = btn_Recetario;
	}




	public static JButton getBtn_Almacen() {
		return btn_Almacen;
	}




	public static void setBtn_Almacen(JButton btn_Almacen) {
		Vista_Menu_Principal.btn_Almacen = btn_Almacen;
	}




	public static JButton getBtn_Gestion_Usuario() {
		return btn_Gestion_Usuario;
	}




	public static void setBtn_Gestion_Usuario(JButton btn_Gestion_Usuario) {
		Vista_Menu_Principal.btn_Gestion_Usuario = btn_Gestion_Usuario;
	}




	public static JButton getBtn_Cerrar_Sesion() {
		return btn_Cerrar_Sesion;
	}




	public static void setBtn_Cerrar_Sesion(JButton btn_Cerrar_Sesion) {
		Vista_Menu_Principal.btn_Cerrar_Sesion = btn_Cerrar_Sesion;
	}
	
	
	

	

}
