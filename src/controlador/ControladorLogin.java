package controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.SentenciasSQL;
import vista.Login;
import vista.Vista_Menu_Principal;

public class ControladorLogin implements ActionListener {

	private Vista_Menu_Principal vistaMenuPrincipal;
	private String entrada_usuario;
	private String entrada_contrasena;
	private Component vistaLogin;

	public ControladorLogin(Login vista_Login) {
		this.vistaLogin = vista_Login;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Login.getBtn_Aceptar()) {
			entrada_usuario = Login.getJtf_Entrada_Nombre().getText();
			entrada_contrasena = Login.getJtf_Entrada_Contrasena().getText();

			String estado = SentenciasSQL.iniciar_Sesion(entrada_usuario, entrada_contrasena);

			if (estado.equals("Administrador")) {
				vistaMenuPrincipal = new Vista_Menu_Principal();
				vistaMenuPrincipal.setVisible(true);
				vistaMenuPrincipal.getBtn_Recetario().setEnabled(true);
				vistaMenuPrincipal.getBtn_Almacen().setEnabled(true);
				vistaMenuPrincipal.getBtn_Gestion_Usuario().setEnabled(true);
				vistaMenuPrincipal.getBtn_Contabilidad().setEnabled(true);

			} else if (estado.equals("Cocina")) {
				vistaMenuPrincipal = new Vista_Menu_Principal();
				vistaMenuPrincipal.setVisible(true);
				vistaMenuPrincipal.getBtn_Almacen().setEnabled(true);
				vistaMenuPrincipal.getBtn_Recetario().setEnabled(true);
				
				System.out.println(estado);
			} else if (estado.equals("Venta")) {
				vistaMenuPrincipal = new Vista_Menu_Principal();
				vistaMenuPrincipal.getBtn_Ventas().setEnabled(true);
				vistaMenuPrincipal.setVisible(true);

			}else {
				JOptionPane.showMessageDialog(vistaLogin, "Error de credenciales");
			}

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
}
