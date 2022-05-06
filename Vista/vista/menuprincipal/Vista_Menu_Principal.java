package vista.menuprincipal;

import javax.swing.JFrame;
import controlador.menuprincipal.Controlador_Menu_Principal;
import vista.login.Vista_Login;
import javax.swing.JButton;
import java.awt.Component;


public class Vista_Menu_Principal extends JFrame {


	private static final long serialVersionUID = 1L;
	private JButton btn_Contabilidad;
	private JButton btn_Ventas;
	private JButton btn_Recetario;
	private JButton btn_Almacen;
	private JButton btn_Gestion_Usuario;
	private JButton btn_Cerrar_Sesion;


	public Vista_Menu_Principal() {		
		

		setTitle(Vista_Login.getTituloVentana()+"Men\u00FA Principal");
		getContentPane().setLayout(null);
		
		btn_Contabilidad = new JButton("Contabilidad");
		btn_Contabilidad.setEnabled(false);
		btn_Contabilidad.setBounds(337, 148, 91, 23);
		getContentPane().add(btn_Contabilidad);
		
		btn_Ventas = new JButton("Ventas");
		btn_Ventas.setBounds(16, 148, 91, 23);
		getContentPane().add(btn_Ventas);
		
		btn_Recetario = new JButton("Recetario");
		btn_Recetario.setEnabled(false);
		btn_Recetario.setBounds(123, 148, 91, 23);
		getContentPane().add(btn_Recetario);
		
		btn_Almacen = new JButton("Almac\u00E9n");
		btn_Almacen.setEnabled(false);
		btn_Almacen.setBounds(230, 148, 91, 23);
		getContentPane().add(btn_Almacen);
		
		btn_Gestion_Usuario = new JButton("Gesti\u00F3n de usuarios");
		btn_Gestion_Usuario.setEnabled(false);
		btn_Gestion_Usuario.setBounds(444, 148, 136, 23);
		getContentPane().add(btn_Gestion_Usuario);
		
		btn_Cerrar_Sesion = new JButton("Cerrar Sesi\u00F3n");
		btn_Cerrar_Sesion.setBounds(230, 255, 97, 23);
		getContentPane().add(btn_Cerrar_Sesion);

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
	
	
	
	public JButton getBtn_Contabilidad() {
		return btn_Contabilidad;
	}


	public void setBtn_Contabilidad(JButton btn_Contabilidad) {
		this.btn_Contabilidad = btn_Contabilidad;
	}


	public JButton getBtn_Ventas() {
		return btn_Ventas;
	}


	public void setBtn_Ventas(JButton btn_Ventas) {
		this.btn_Ventas = btn_Ventas;
	}


	public JButton getBtn_Recetario() {
		return btn_Recetario;
	}


	public void setBtn_Recetario(JButton btn_Recetario) {
		this.btn_Recetario = btn_Recetario;
	}


	public Component getBtn_Almacen() {
		return btn_Almacen;
	}


	public void setBtn_Almacen(JButton btn_Almacen) {
		this.btn_Almacen = btn_Almacen;
	}


	public JButton getBtn_Gestion_Usuario() {
		return btn_Gestion_Usuario;
	}


	public void setBtn_Gestion_Usuario(JButton btn_Gestion_Usuario) {
		this.btn_Gestion_Usuario = btn_Gestion_Usuario;
	}


	public JButton getBtn_Cerrar_Sesion() {
		return btn_Cerrar_Sesion;
	}


	public void setBtn_Cerrar_Sesion(JButton btn_Cerrar_Sesion) {
		this.btn_Cerrar_Sesion = btn_Cerrar_Sesion;
	}
	
	
	
	
	

}
