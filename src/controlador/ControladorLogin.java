package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.SentenciasSQL;
import vista.VentanaPrincipal;
import vista.Login;
import vista.MenuPrincipal;

public class ControladorLogin implements ActionListener{
	private Login panelLogin;
	private String entrada_usuario;
	private String entrada_contrasena;

	private String rolUsuario = "Admin";
	
	
	public ControladorLogin(Login panelLogin) {
		this.panelLogin = panelLogin;
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Login.getBtn_Aceptar()) {
			
			
			 entrada_usuario = Login.getJtf_Entrada_Nombre().getText();
			 entrada_contrasena = Login.getJtf_Entrada_Contrasena().getText();

				boolean estado = SentenciasSQL.iniciar_Sesion(entrada_usuario, entrada_contrasena );
				
				if (estado) {
					comprobarRolUsuario(rolUsuario);
					VentanaPrincipal.getPanelLogin().setVisible(false);
					VentanaPrincipal.getPanelMenuPrincipal().setVisible(true);
					
					
				}else {
					JOptionPane.showMessageDialog(panelLogin, "Nombre de usuario o contraseña incorrectas.");
				}
				
			borrarCajaTexto ();
			
		}
		
		if (e.getSource() == Login.getBtn_Borrar()) {
			borrarCajaTexto ();

		}
	}
	

	
	private void comprobarRolUsuario(String rolUsuario) {
		
		
		if ("Admin".equals(rolUsuario)) {
			MenuPrincipal.getBtn_Ventas().setEnabled(true);
			MenuPrincipal.getBtn_Recetario().setEnabled(true);
			MenuPrincipal.getBtn_Almacen().setEnabled(true);
			MenuPrincipal.getBtn_Contabilidad().setEnabled(true);
			MenuPrincipal.getBtn_Gestion_Usuario().setEnabled(true);
		} 
		else if ("Cocina".equals(rolUsuario)) {
			MenuPrincipal.getBtn_Ventas().setEnabled(false);
			MenuPrincipal.getBtn_Recetario().setEnabled(true);
			MenuPrincipal.getBtn_Almacen().setEnabled(true);
			MenuPrincipal.getBtn_Contabilidad().setEnabled(false);
			MenuPrincipal.getBtn_Gestion_Usuario().setEnabled(false);

		} else {
			MenuPrincipal.getBtn_Ventas().setEnabled(true);
			MenuPrincipal.getBtn_Recetario().setEnabled(true);
			MenuPrincipal.getBtn_Almacen().setEnabled(false);
			MenuPrincipal.getBtn_Contabilidad().setEnabled(false);
			MenuPrincipal.getBtn_Gestion_Usuario().setEnabled(false);
		}
		
	}



	public void borrarCajaTexto () {		
		Login.getJtf_Entrada_Nombre().setText("");
		Login.getJtf_Entrada_Contrasena().setText("");		
	}
}
