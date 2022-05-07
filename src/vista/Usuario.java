package vista;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlador.ControladorUsuario;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Usuario extends JPanel {

	/**
	 * 
	 */
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
	private static JButton btn_volver;
	
	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;


	public Usuario() {
		
		panelUsuario = new JPanel();
		lbl_nombre = new JLabel("Nombre");		
		lbl_pass = new JLabel("Contrasena");		
		lbl_repetir_pass = new JLabel("Repita la contrase\u00F1a");
		lbl_rol = new JLabel("Rol");
		btn_Aceptar = new JButton("Aceptar");		
		rdbtn_admin = new JRadioButton("Administrador");	
		rdbtn_Cocina = new JRadioButton("Cocinas");	
		rdbtn_ventas = new JRadioButton("Ventas");
		btn_volver = new JButton("Volver");
		caja_nombre = new JTextField();
		caja_pass_1 = new JPasswordField();		
		caja_pass_2 = new JPasswordField();		
		
		establecerManejador();		
		panelUsuario.setVisible(false);
		
	}

	public static JPanel inicializarComponentes() {
		
		panelUsuario.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelUsuario.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		panelUsuario.setLayout(null);

		lbl_nombre.setBounds(10, 67, 65, 14);
		panelUsuario.add(lbl_nombre);
		
		lbl_pass.setBounds(10, 103, 65, 14);
		panelUsuario.add(lbl_pass);
		
		lbl_repetir_pass.setBounds(10, 139, 113, 14);
		panelUsuario.add(lbl_repetir_pass);
		
		lbl_rol.setBounds(10, 175, 46, 14);
		panelUsuario.add(lbl_rol);
		
		btn_Aceptar.setBounds(10, 211, 89, 23);
		panelUsuario.add(btn_Aceptar);
		
		rdbtn_admin.setBounds(79, 166, 109, 23);
		panelUsuario.add(rdbtn_admin);
		
		rdbtn_Cocina.setBounds(204, 166, 109, 23);
		panelUsuario.add(rdbtn_Cocina);
		
		rdbtn_ventas.setSelected(true);
		rdbtn_ventas.setBounds(319, 166, 109, 23);
		panelUsuario.add(rdbtn_ventas);
		
		caja_nombre.setBounds(85, 64, 312, 20);
		panelUsuario.add(caja_nombre);
		caja_nombre.setColumns(10);
		
		caja_pass_1.setBounds(118, 101, 280, 17);
		panelUsuario.add(caja_pass_1);
		
		caja_pass_2.setBounds(118, 137, 280, 17);
		panelUsuario.add(caja_pass_2);
		
		btn_volver.setBounds(342, 11, 71, 23);
		panelUsuario.add(btn_volver);
		
		return panelUsuario;
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
