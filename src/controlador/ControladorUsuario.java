package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo_bbdd.BbddLogin;
import modelo_bbdd.BbddVentas;
import vista.Cliente;
import vista.GestionPedidos;
import vista.GestionUsuarios;
import vista.Usuario;
import vista.VentanaPrincipal;

public class ControladorUsuario implements ActionListener {
	
	private Usuario panelUsuario;
	private boolean nuevoUsuario;
	private String nombreUsuario;
	private String rolUsuario;
	private boolean rolAdmin;
	private boolean rolCocina;
	private boolean rolVenta;
	private String pass1;
	private String pass2;
	
	
	
	public ControladorUsuario(Usuario panelUsuario) {
		this.panelUsuario = panelUsuario;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Usuario.getBtn_volver()) {
			VentanaPrincipal.getPanelGestionUsuarios().setVisible(true);
			VentanaPrincipal.getPanelUsuario().setVisible(false);
			GestionUsuarios.getTabla().clearSelection();
			ControladorGestionUsuarios.setNuevoUsuario(false);
		}
		
		
		if (e.getSource() == Usuario.getBtn_Aceptar()) {

			nuevoUsuario = ControladorGestionUsuarios.isNuevoUsuario();	
			nombreUsuario = Usuario.getCaja_nombre().getText();
			rolUsuario = "Ventas";
			rolAdmin = Usuario.getRdbtn_admin().isSelected();
			rolCocina = Usuario.getRdbtn_Cocina().isSelected();
			rolVenta = Usuario.getRdbtn_ventas().isSelected();	
			pass1 = Usuario.getCaja_pass_1().getText();
			pass2 = Usuario.getCaja_pass_2().getText();
			
			if (nuevoUsuario) {	
				if (pass1.equals(pass2)) {			
					if (rolAdmin) {
						rolUsuario= "Administrador";
					} 
					else if (rolCocina){
						rolUsuario= "Cocina";
					}
					else if (rolVenta) {
						rolUsuario= "Venta";
					}
					BbddLogin.nuevoUsuario(nombreUsuario, pass1, rolUsuario );

				}
				else {
					JOptionPane.showMessageDialog(panelUsuario, "Las contraseñas introducidas no coinciden");
				}
				
				
			} else {				
				if (pass1.equals(pass2)) {			
					if (rolAdmin) {
						rolUsuario= "Administrador";
					} 
					else if (rolCocina){
						rolUsuario= "Cocina";
					}
					else if (rolVenta) {
						rolUsuario= "Venta";
					}
					BbddLogin.edotarUsuario(nombreUsuario, pass1, rolUsuario );

				}
				else {
					JOptionPane.showMessageDialog(panelUsuario, "Las contraseñas introducidas no coinciden");
				}			
			}
			VentanaPrincipal.getPanelUsuario().setVisible(false);
			VentanaPrincipal.getPanelGestionUsuarios().setVisible(true);
			Usuario.getCaja_nombre().setText("");
			Usuario.getCaja_pass_1().setText("");
			Usuario.getCaja_pass_2().setText("");
			GestionUsuarios.getTabla().clearSelection();	
			ControladorGestionUsuarios.setNuevoUsuario(false);
		}

	}
	

}
