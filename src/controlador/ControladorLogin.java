package controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.SentenciasSQL;
import vista.Login;
import vista.MenuPrincipal;
import vista.VentanaPrincipal;

public class ControladorLogin implements ActionListener {

	private String entrada_usuario;
	private String entrada_contrasena;
	private Login panelLogin;


	public ControladorLogin(Login panelLogin) {
		this.panelLogin = panelLogin;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Login.getBtn_Aceptar()) {
			entrada_usuario = Login.getJtf_Entrada_Nombre().getText();
			entrada_contrasena = Login.getJtf_Entrada_Contrasena().getText();

		String estado = SentenciasSQL.iniciar_Sesion(entrada_usuario, entrada_contrasena);
	
		
			if (estado.equals("Administrador")) {				
				cambiarMenuPrincipal ();

			} else if (estado.equals("Cocina")) {
				cambiarMenuPrincipal ();				

				MenuPrincipal.getBtn_Ventas().setEnabled(false);
				MenuPrincipal.getBtn_Contabilidad().setEnabled(false);
				MenuPrincipal.getBtn_Gestion_Usuario().setEnabled(false);				
				

			} else if (estado.equals("Venta")) {
				cambiarMenuPrincipal ();
				MenuPrincipal.getBtn_Almacen().setEnabled(false);
				MenuPrincipal.getBtn_Gestion_Usuario().setEnabled(false);
				MenuPrincipal.getBtn_Contabilidad().setEnabled(false);

			}else {
				JOptionPane.showMessageDialog(panelLogin, "Error de credenciales");
			}
			System.out.println(estado);
		}
		borrarCajaTexto();
		if (e.getSource() == Login.getBtn_Borrar()) {
			borrarCajaTexto();

		}
	}

	public void borrarCajaTexto() {
		Login.getJtf_Entrada_Nombre().setText("");
		Login.getJtf_Entrada_Contrasena().setText("");
	}
	
	private void cambiarMenuPrincipal () {
		VentanaPrincipal.getPanelLogin().setVisible(false);
		VentanaPrincipal.getPanelMenuPrincipal().setVisible(true);
		MenuPrincipal.getBtn_Ventas().setEnabled(true);
		MenuPrincipal.getBtn_Recetario().setEnabled(true);
		MenuPrincipal.getBtn_Almacen().setEnabled(true);
		MenuPrincipal.getBtn_Gestion_Usuario().setEnabled(true);
		MenuPrincipal.getBtn_Contabilidad().setEnabled(true);

	}
	
}
