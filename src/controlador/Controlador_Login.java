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
	private Vista_Menu_Principal vistaMenuPrincipal;
	private String entrada_usuario;
	private String entrada_contrasena;

	
	
	public Controlador_Login(Vista_Login vista_Login) {
		this.vistaLogin = vista_Login;
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vistaLogin.getBtn_Aceptar()) {
			
			
			 entrada_usuario = vistaLogin.getJtf_Entrada_Nombre().getText();
			 entrada_contrasena = vistaLogin.getJtf_Entrada_Contrasena().getText();

				boolean estado = SentenciasSQL.iniciar_Sesion(entrada_usuario, entrada_contrasena );
				
				if (estado) {

					VentanaPrincipal.getPanelLogin().setVisible(false);
//					vistaMenuPrincipal = new Vista_Menu_Principal();
//					vistaMenuPrincipal.setVisible(true);
					
					
				}else {
					JOptionPane.showMessageDialog(vistaLogin, "Nombre de usuario o contraseña incorrectas.");
				}
				
			borrarCajaTexto ();
			
		}
		
		if (e.getSource() == vistaLogin.getBtn_Borrar()) {
			borrarCajaTexto ();

		}
	}
	

	
	public void borrarCajaTexto () {		
		vistaLogin.getJtf_Entrada_Nombre().setText("");
		vistaLogin.getJtf_Entrada_Contrasena().setText("");		
	}
}
