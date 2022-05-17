package vista;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlador.ControladorUsuario;
import javax.swing.JLabel;


import java.awt.Choice;
import java.awt.Font;

import javax.swing.ButtonGroup;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class Usuario extends JPanel {

	private static final long serialVersionUID = -386891114278475647L;
	
	private static JPanel panelUsuario;
	private static JTextField caja_nombre;
	private static JPasswordField caja_pass_1;
	private static JPasswordField caja_pass_2;
	private static JLabel lbl_nombre;
	private static JLabel lbl_pass;
	private static JLabel lbl_repetir_pass;
	private static JLabel lbl_rol;
	private static JButton btn_Aceptar;
	private static JRadioButton rdbtn_admin;
	private static JRadioButton rdbtn_Cocina;
	private static JRadioButton rdbtn_ventas;
	private static ButtonGroup grupoRol;
	private static JButton btn_volver;

	public Usuario() {
		super();
		inicializarComponentes();
		establecerManejador();		
		
	}

	public void inicializarComponentes() {
		grupoRol=new ButtonGroup();
		panelUsuario = VentanaPrincipal.parametrosPanel(400, 400);
		
		btn_volver = VentanaPrincipal.parametrosJButton("Volver", 310, 20, 70, 20);
		panelUsuario.add(btn_volver);
		
		
		//NOMBRE
		lbl_nombre = VentanaPrincipal.parametrosJlabel("Nombre",5, 60, 45,20);
		lbl_nombre.setHorizontalAlignment(SwingConstants.RIGHT);
		panelUsuario.add(lbl_nombre); 												
		
		caja_nombre = VentanaPrincipal.parametrosJTextField(70, 60, 325,20);
		panelUsuario.add(caja_nombre);												
		
		//PASSWORD
		lbl_pass = VentanaPrincipal.parametrosJlabel("Contrasena",5, 120, 45,20);
		lbl_pass.setHorizontalAlignment(SwingConstants.RIGHT);
		panelUsuario.add(lbl_pass); 												
		
		caja_pass_1 = new JPasswordField();
		caja_pass_1.setFont(new Font("Manche Condensed",Font.BOLD,(int)(12*VentanaPrincipal.getCordenadaY())));
		caja_pass_1.setHorizontalAlignment(SwingConstants.CENTER);
		caja_pass_1.setBorder(null);
		caja_pass_1.setBounds(
								Math.round(70*VentanaPrincipal.getCordenadaX()), 		//posicion HORIZONTAL
								Math.round(120*VentanaPrincipal.getCordenadaY()),		//posicion VERTICAL 
								Math.round(325*VentanaPrincipal.getCordenadaX()),  		//tamaño HORIZONTAL
								Math.round(20*VentanaPrincipal.getCordenadaY())); 		//tamaño VERTICAL
		panelUsuario.add(caja_pass_1);	
		
		//REPIT PASSWORD
		lbl_repetir_pass = VentanaPrincipal.parametrosJlabel("Repita la contrase\u00F1a",5, 180, 45,20);
		lbl_repetir_pass.setHorizontalAlignment(SwingConstants.RIGHT);
		panelUsuario.add(lbl_repetir_pass); 												
		
		caja_pass_2 = new JPasswordField();
		caja_pass_2.setFont(new Font("Manche Condensed",Font.BOLD,(int)(12*VentanaPrincipal.getCordenadaY())));
		caja_pass_2.setHorizontalAlignment(SwingConstants.CENTER);
		caja_pass_2.setBorder(null);
		caja_pass_2.setBounds(
								Math.round(70*VentanaPrincipal.getCordenadaX()), 		//posicion HORIZONTAL
								Math.round(180*VentanaPrincipal.getCordenadaY()),		//posicion VERTICAL 
								Math.round(325*VentanaPrincipal.getCordenadaX()),  		//tamaño HORIZONTAL
								Math.round(20*VentanaPrincipal.getCordenadaY())); 		//tamaño VERTICAL
		panelUsuario.add(caja_pass_2);
		
						
		//ROL
		lbl_rol = VentanaPrincipal.parametrosJlabel("Rol",5, 240, 45,20);
		lbl_rol.setHorizontalAlignment(SwingConstants.RIGHT);
		panelUsuario.add(lbl_rol);
		
		rdbtn_admin = new JRadioButton("Administrador");
		rdbtn_admin.setFont(new Font("Manche Condensed",Font.BOLD,(int)(12*VentanaPrincipal.getCordenadaY())));
		rdbtn_admin.setBackground(VentanaPrincipal.getAzulNormal());
		rdbtn_admin.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtn_admin.setBorder(null);
		rdbtn_admin.setBounds(
								Math.round(70*VentanaPrincipal.getCordenadaX()), 		//posicion HORIZONTAL
								Math.round(240*VentanaPrincipal.getCordenadaY()),		//posicion VERTICAL 
								Math.round(100*VentanaPrincipal.getCordenadaX()),  		//tamaño HORIZONTAL
								Math.round(20*VentanaPrincipal.getCordenadaY())); 		//tamaño VERTICAL
		panelUsuario.add(rdbtn_admin);
		grupoRol.add(rdbtn_admin);
		
		rdbtn_Cocina = new JRadioButton("Cocinas");
		rdbtn_Cocina.setFont(new Font("Manche Condensed",Font.BOLD,(int)(12*VentanaPrincipal.getCordenadaY())));
		rdbtn_Cocina.setBackground(VentanaPrincipal.getAzulNormal());
		rdbtn_Cocina.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtn_Cocina.setBorder(null);
		rdbtn_Cocina.setBounds(
								Math.round(190*VentanaPrincipal.getCordenadaX()), 		//posicion HORIZONTAL
								Math.round(240*VentanaPrincipal.getCordenadaY()),		//posicion VERTICAL 
								Math.round(100*VentanaPrincipal.getCordenadaX()),  		//tamaño HORIZONTAL
								Math.round(20*VentanaPrincipal.getCordenadaY())); 		//tamaño VERTICAL
		panelUsuario.add(rdbtn_Cocina);
		grupoRol.add(rdbtn_Cocina);
		
		rdbtn_ventas = new JRadioButton("Ventas");
		rdbtn_ventas.setFont(new Font("Manche Condensed",Font.BOLD,(int)(12*VentanaPrincipal.getCordenadaY())));
		rdbtn_ventas.setBackground(VentanaPrincipal.getAzulNormal());
		rdbtn_ventas.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtn_ventas.setBorder(null);
		rdbtn_ventas.setBounds(
								Math.round(300*VentanaPrincipal.getCordenadaX()), 		//posicion HORIZONTAL
								Math.round(240*VentanaPrincipal.getCordenadaY()),		//posicion VERTICAL 
								Math.round(100*VentanaPrincipal.getCordenadaX()),  		//tamaño HORIZONTAL
								Math.round(20*VentanaPrincipal.getCordenadaY())); 		//tamaño VERTICAL
		panelUsuario.add(rdbtn_ventas);
		grupoRol.add(rdbtn_ventas);
		
		
		//ACEPTAR
		btn_Aceptar = VentanaPrincipal.parametrosJButton("Aceptar",140,300,120,40);
		panelUsuario.add(btn_Aceptar);

		panelUsuario.setVisible(false);
				

	}
	
	private void establecerManejador() {
		
		ControladorUsuario controlador = new ControladorUsuario(this);
		
		btn_Aceptar.addActionListener(controlador);		
		rdbtn_admin.addActionListener(controlador);	
		rdbtn_Cocina.addActionListener(controlador);	
		rdbtn_ventas.addActionListener(controlador);	
		caja_nombre.addActionListener(controlador);
		caja_pass_1.addActionListener(controlador);	
		caja_pass_2.addActionListener(controlador);		
		btn_volver.addActionListener(controlador);
		
	}

	/**
	 * Gets y Set
	 * @return
	 */
	
	public static JPanel getPanelUsuario() {
		return panelUsuario;
	}

	public static void setPanelUsuario(JPanel panelUsuario) {
		Usuario.panelUsuario = panelUsuario;
	}

	public static JTextField getCaja_nombre() {
		return caja_nombre;
	}

	public static void setCaja_nombre(JTextField caja_nombre) {
		Usuario.caja_nombre = caja_nombre;
	}

	public static JPasswordField getCaja_pass_1() {
		return caja_pass_1;
	}

	public static void setCaja_pass_1(JPasswordField caja_pass_1) {
		Usuario.caja_pass_1 = caja_pass_1;
	}

	public static JPasswordField getCaja_pass_2() {
		return caja_pass_2;
	}

	public static void setCaja_pass_2(JPasswordField caja_pass_2) {
		Usuario.caja_pass_2 = caja_pass_2;
	}

	public static JButton getBtn_Aceptar() {
		return btn_Aceptar;
	}

	public static void setBtn_Aceptar(JButton btn_Aceptar) {
		Usuario.btn_Aceptar = btn_Aceptar;
	}

	public static JRadioButton getRdbtn_admin() {
		return rdbtn_admin;
	}

	public static void setRdbtn_admin(JRadioButton rdbtn_admin) {
		Usuario.rdbtn_admin = rdbtn_admin;
	}

	public static JRadioButton getRdbtn_Cocina() {
		return rdbtn_Cocina;
	}

	public static void setRdbtn_Cocina(JRadioButton rdbtn_Cocina) {
		Usuario.rdbtn_Cocina = rdbtn_Cocina;
	}

	public static JRadioButton getRdbtn_ventas() {
		return rdbtn_ventas;
	}

	public static void setRdbtn_ventas(JRadioButton rdbtn_ventas) {
		Usuario.rdbtn_ventas = rdbtn_ventas;
	}

	public static JButton getBtn_volver() {
		return btn_volver;
	}

	public static void setBtn_volver(JButton btn_volver) {
		Usuario.btn_volver = btn_volver;
	}

	
	
	
	
}
