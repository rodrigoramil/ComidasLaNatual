package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo_bbdd.BbddGestionUsuario;
import modelo_bbdd.BbddLogin;
import modelo_bbdd.BbddVentas;
import vista.Cliente;
import vista.GestionPedidos;
import vista.GestionUsuarios;
import vista.MenuPrincipal;
import vista.Usuario;
import vista.VentanaPrincipal;

public class ControladorUsuario implements ActionListener, MouseListener {
	
	private Usuario panelUsuario;
	private boolean nuevoUsuario;
	private String nombreUsuario;
	private String rolUsuario;
	private boolean rolAdmin;
	private boolean rolCocina;
	private boolean rolVenta;
	private String pass1="";
	private String pass2="";
	
	
	
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
			GestionUsuarios.getBtn_Modificar().setEnabled(false);
			GestionUsuarios.getBtn_eliminar().setEnabled(false);
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
					try {
						BbddGestionUsuario.insertarUsuarios(nombreUsuario, pass1, rolUsuario);
						GestionUsuarios.listarUsuarios(BbddGestionUsuario.listarUsuarios());
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(panelUsuario, "Error con la Base de Datos");
					}
					cambiarVentana();
				}
				else {
					JOptionPane.showMessageDialog(panelUsuario, "Las contraseñas introducidas no coinciden");
					Usuario.getCaja_pass_1().setText("");
					Usuario.getCaja_pass_2().setText("");
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
					try {
						
						BbddGestionUsuario.editarUsuario(nombreUsuario, nombreUsuario, rolUsuario);
						GestionUsuarios.listarUsuarios(BbddGestionUsuario.listarUsuarios());
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(panelUsuario, "Error con la Base de Datos");
					}
					cambiarVentana();
				}
				else {
					JOptionPane.showMessageDialog(panelUsuario, "Las contraseñas introducidas no coinciden");
					Usuario.getCaja_pass_1().setText("");
					Usuario.getCaja_pass_2().setText("");
				}			
			}

		}

	}
	

	public void cambiarVentana() {
		GestionUsuarios.getBtn_Modificar().setEnabled(false);
		GestionUsuarios.getBtn_eliminar().setEnabled(false);
		VentanaPrincipal.getPanelUsuario().setVisible(false);
		VentanaPrincipal.getPanelGestionUsuarios().setVisible(true);
		Usuario.getCaja_nombre().setText("");
		Usuario.getCaja_pass_1().setText("");
		Usuario.getCaja_pass_2().setText("");
		GestionUsuarios.getTabla().clearSelection();	
		ControladorGestionUsuarios.setNuevoUsuario(false);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == Usuario.getBtn_Aceptar()) {
			Usuario.getBtn_Aceptar().setBackground(VentanaPrincipal.getAzulOscuro());
			Usuario.getBtn_Aceptar().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == Usuario.getBtn_volver()) {
			Usuario.getBtn_volver().setBackground(VentanaPrincipal.getAzulOscuro());
			Usuario.getBtn_volver().setForeground(VentanaPrincipal.getAzulClaro());;
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == Usuario.getBtn_Aceptar()) {
			Usuario.getBtn_Aceptar().setBackground(VentanaPrincipal.getAzulClaro());
			Usuario.getBtn_Aceptar().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == Usuario.getBtn_volver()) {
			Usuario.getBtn_volver().setBackground(VentanaPrincipal.getAzulClaro());
			Usuario.getBtn_volver().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
	}
}
