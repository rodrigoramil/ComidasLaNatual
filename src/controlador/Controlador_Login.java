package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.SentenciasSQL;
import vista.VentanaPrincipal;
import vista.Vista_Login;
import vista.Vista_Menu_Principal;
import vista.Vista_Pedido;

public class Controlador_Login implements ActionListener{
	private Vista_Login vistaLogin;
	private String entrada_usuario;
	private String entrada_contrasena;

	private String rolUsuario = "Admin";
	
	
	public Controlador_Login(Vista_Login vista_Login) {
		this.vistaLogin = vista_Login;
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Vista_Login.getBtn_Aceptar()) {
			
			
			 entrada_usuario = Vista_Login.getJtf_Entrada_Nombre().getText();
			 entrada_contrasena = Vista_Login.getJtf_Entrada_Contrasena().getText();

				boolean estado = SentenciasSQL.iniciar_Sesion(entrada_usuario, entrada_contrasena );
				
				if (estado) {
					comprobarRolUsuario(rolUsuario);
					VentanaPrincipal.getPanelLogin().setVisible(false);
					VentanaPrincipal.getPanelMenuPrincipal().setVisible(true);
					
					
				}else {
					JOptionPane.showMessageDialog(vistaLogin, "Nombre de usuario o contraseña incorrectas.");
				}
				
			borrarCajaTexto ();
			
		}
		
		if (e.getSource() == Vista_Login.getBtn_Borrar()) {
			borrarCajaTexto ();

		}
	}
	

	
	private void comprobarRolUsuario(String rolUsuario) {
		
		
		if ("Admin".equals(rolUsuario)) {
			Vista_Menu_Principal.getBtn_Ventas().setEnabled(true);
			Vista_Menu_Principal.getBtn_Recetario().setEnabled(true);
			Vista_Menu_Principal.getBtn_Almacen().setEnabled(true);
			Vista_Menu_Principal.getBtn_Contabilidad().setEnabled(true);
			Vista_Menu_Principal.getBtn_Gestion_Usuario().setEnabled(true);
		} 
		else if ("Cocina".equals(rolUsuario)) {
			Vista_Menu_Principal.getBtn_Ventas().setEnabled(false);
			Vista_Menu_Principal.getBtn_Recetario().setEnabled(true);
			Vista_Menu_Principal.getBtn_Almacen().setEnabled(true);
			Vista_Menu_Principal.getBtn_Contabilidad().setEnabled(false);
			Vista_Menu_Principal.getBtn_Gestion_Usuario().setEnabled(false);

		} else {
			Vista_Menu_Principal.getBtn_Ventas().setEnabled(true);
			Vista_Menu_Principal.getBtn_Recetario().setEnabled(true);
			Vista_Menu_Principal.getBtn_Almacen().setEnabled(false);
			Vista_Menu_Principal.getBtn_Contabilidad().setEnabled(false);
			Vista_Menu_Principal.getBtn_Gestion_Usuario().setEnabled(false);
		}
		
	}



	public void borrarCajaTexto () {		
		Vista_Login.getJtf_Entrada_Nombre().setText("");
		Vista_Login.getJtf_Entrada_Contrasena().setText("");		
	}
}
