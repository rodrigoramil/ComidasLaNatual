
package vista;


import javax.swing.*;
import controlador.ControladorMenuPrincipal;
import java.awt.*;


public class MenuPrincipal extends JPanel {

	private static final long serialVersionUID = 1426442970510327864L;
	
	private static JPanel panelMenuPrincipal;
	private static JButton btn_Contabilidad;
	private static JButton btn_Ventas;
	private static JButton btn_Recetario;
	private static JButton btn_Almacen;
	private static JButton btn_Gestion_Usuario;
	private static JButton btn_Cerrar_Sesion;
	private static Color azulFondoBotonCerrar = new Color(50,100,255);
	private static Color azulLetrasBotonCerrar = new Color(192,227,247);
	
	public MenuPrincipal() {
		super();
		inicializarComponentes();
		establecerManejador();		
	}

	
	public void inicializarComponentes() {
		
		//inicializamos PANEL
		panelMenuPrincipal = new JPanel();
		panelMenuPrincipal.setLayout(null);
		int tamañoX = Math.round(800*VentanaPrincipal.getCordenadaX());
		int tamañoY = Math.round(800*VentanaPrincipal.getCordenadaY());
		panelMenuPrincipal.setBounds(
								0,														//posicion HORIZONTAL
								0, 														//posicion VERTICAL
								tamañoX,												//tamaño HORIZONTA
								tamañoY);												//tamaño VERTICAL
		
		panelMenuPrincipal.setOpaque(false);
		panelMenuPrincipal.setVisible(false);
		
		//inicializamos VENTAS
		btn_Ventas = VentanaPrincipal.parametrosJButton("Ventas",380,50,200,50);
		panelMenuPrincipal.add(btn_Ventas);
		
		//inicializamos RECETARIO
		btn_Recetario = VentanaPrincipal.parametrosJButton("Recetario",355,150,200,50);
		panelMenuPrincipal.add(btn_Recetario);
		
		
		//inicializamos ALMACEN
		btn_Almacen = VentanaPrincipal.parametrosJButton("Almac\u00E9n",330,250,200,50);
		panelMenuPrincipal.add(btn_Almacen);
		
		
		//inicializamos CONTABILIDAD
		btn_Contabilidad = VentanaPrincipal.parametrosJButton("Contabilidad",305,350,200,50);
		panelMenuPrincipal.add(btn_Contabilidad);
		
		//inicializamos GESTION DE USUARIO
		btn_Gestion_Usuario = VentanaPrincipal.parametrosJButton("Gesti\u00F3n de usuarios",280,450,200,50);
		panelMenuPrincipal.add(btn_Gestion_Usuario);
		
		
		//inicializamos CERRAR SESION
		btn_Cerrar_Sesion = VentanaPrincipal.parametrosJButton("Cerrar Sesi\u00F3n",640,550,150,30);
		btn_Cerrar_Sesion.setEnabled(true);
		btn_Cerrar_Sesion.setBackground(azulFondoBotonCerrar);
		btn_Cerrar_Sesion.setForeground(azulLetrasBotonCerrar);
		panelMenuPrincipal.add(btn_Cerrar_Sesion);
		
		Imagen imagen = new Imagen(tamañoX,tamañoY);
		panelMenuPrincipal.add(imagen);
	}
	

	public void establecerManejador() {			
		ControladorMenuPrincipal controlador = new ControladorMenuPrincipal(this);
		btn_Contabilidad.addActionListener(controlador);
		btn_Ventas.addActionListener(controlador);
		btn_Recetario.addActionListener(controlador);
		btn_Almacen.addActionListener(controlador);
		btn_Gestion_Usuario.addActionListener(controlador);
		btn_Cerrar_Sesion.addActionListener(controlador);
	
		btn_Contabilidad.addMouseListener(controlador);
		btn_Ventas.addMouseListener(controlador);
		btn_Recetario.addMouseListener(controlador);
		btn_Almacen.addMouseListener(controlador);
		btn_Gestion_Usuario.addMouseListener(controlador);
		btn_Cerrar_Sesion.addMouseListener(controlador);
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


	public static Color getAzulFondoBotonCerrar() {
		return azulFondoBotonCerrar;
	}


	public static Color getAzulLetrasBotonCerrar() {
		return azulLetrasBotonCerrar;
	}
	
}
