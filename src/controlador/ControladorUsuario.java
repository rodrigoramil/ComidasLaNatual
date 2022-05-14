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
	private String usuarioVentas;
	private String usuarioCocina;
	private String usuarioAdmin;
	private boolean nuevoUsuario;
	
	
	
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
			VentanaPrincipal.getPanelGestionUsuarios().setVisible(true);
			VentanaPrincipal.getPanelUsuario().setVisible(false);
			Usuario.getCaja_nombre().setText("");
			Usuario.getCaja_pass_1().setText("");
			Usuario.getCaja_pass_2().setText("");
					
			nuevoUsuario = ControladorGestionUsuarios.isNuevoUsuario();
			
			System.out.println("nuevoUsuario: "+nuevoUsuario);
			
			if (nuevoUsuario) {
				/* Falta implementar el método en la clase Login que realice una sentencia SQL con un INSERT INTO */
				
				
			} else {
				/* Falta implementar el método en la clase Login que realice una sentencia SQL con un UPDATE */
				
				
			}
			
			
			
			
			
			
			
			

			
			GestionUsuarios.getTabla().clearSelection();	
			ControladorGestionUsuarios.setNuevoUsuario(false);
		}

	}

	public String getUsuarioVentas() {
		return usuarioVentas;
	}

	public String getUsuarioCocina() {
		return usuarioCocina;
	}

	public String getUsuarioAdmin() {
		return usuarioAdmin;
	}

	
	
	

}
