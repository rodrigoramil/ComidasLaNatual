package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo_bbdd.BbddGestionUsuario;
import modelo_bbdd.BbddLogin;
import vista.GestionUsuarios;
import vista.MenuPrincipal;
import vista.Recetario;
import vista.Usuario;
import vista.VentanaPrincipal;

public class ControladorGestionUsuarios implements ActionListener, MouseListener  {


	private GestionUsuarios panelGestionUsuarios;
	private String usuarioSelecionado;
	private static boolean nuevoUsuario = false;
	
	public ControladorGestionUsuarios(GestionUsuarios panelGestionUsuarios) {
		this.panelGestionUsuarios = panelGestionUsuarios;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == GestionUsuarios.getBtn_volver()) {
			VentanaPrincipal.getPanelMenuPrincipal().setVisible(true);
			VentanaPrincipal.getPanelGestionUsuarios().setVisible(false);
			GestionUsuarios.getTabla().clearSelection();
		}
		if (e.getSource() == GestionUsuarios.getBtn_nuevo()) {
			nuevoUsuario = true;
			Usuario.getRdbtn_ventas().setSelected(true);			
			VentanaPrincipal.getPanelGestionUsuarios().setVisible(false);
			VentanaPrincipal.getPanelUsuario().setVisible(true);			
			Usuario.getCaja_nombre().setText("");
			Usuario.getCaja_pass_1().setText("");
			Usuario.getCaja_pass_2().setText("");
		
		}
		
		
		
		
		if (e.getSource() == GestionUsuarios.getBtn_Modificar()) {
			nuevoUsuario = false;
			try {
				usuarioSelecionado = GestionUsuarios.datoSeleccionadoTabla();
				comprobarUsuario();
				
				VentanaPrincipal.getPanelGestionUsuarios().setVisible(false);
				VentanaPrincipal.getPanelUsuario().setVisible(true);
				
			} catch (NullPointerException errorSelectorVacio) {				
				JOptionPane.showMessageDialog(panelGestionUsuarios, "Selecciona cliente a editar");
			}	
		}
		
		
		
		
		if (e.getSource() == GestionUsuarios.getBtn_eliminar()) {
				
			try {	
				usuarioSelecionado = GestionUsuarios.datoSeleccionadoTabla();
				comprobarUsuario();
				 // si = 0 / no = 1 / cancelar = 2 / X = -1
				int respuestaEliminar = JOptionPane.showConfirmDialog(panelGestionUsuarios, "Quiere eleminar el usuario "+usuarioSelecionado);
				if (respuestaEliminar == 0) {
					
					try {						
						BbddGestionUsuario.borrarUsuario();
						GestionUsuarios.listarUsuarios(BbddGestionUsuario.listarUsuarios());
						GestionUsuarios.getBtn_Modificar().setEnabled(false);
						GestionUsuarios.getBtn_eliminar().setEnabled(false);
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(panelGestionUsuarios, "Error con la Base de Datos");
					}					
				}				
			} catch (NullPointerException errorSelectorVacio) {				
				JOptionPane.showMessageDialog(panelGestionUsuarios, "Selecciona cliente a eliminar");
			}	
			
			GestionUsuarios.getTabla().clearSelection();
			
		}
		
	}
	


	private void comprobarUsuario() {
		for (int i = 0; i < BbddGestionUsuario.getArrayUsuarios().size(); i++) {		
			if (usuarioSelecionado.equals(BbddGestionUsuario.getArrayUsuarios().get(i).getNombreUsuario())) {	
				Usuario.getCaja_nombre().setText(usuarioSelecionado);
				String usuarioRol = BbddGestionUsuario.getArrayUsuarios().get(i).getRol();				
				if (usuarioRol.equals("Administrador")) {
					Usuario.getRdbtn_admin().setSelected(true);
				} 
				else if (usuarioRol.equals("Cocina")){
					Usuario.getRdbtn_Cocina().setSelected(true);
				}
				else if (usuarioRol.equals("Venta")) {
					Usuario.getRdbtn_ventas().setSelected(true);
				}
			}			
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) { // Al hacer clic con el raton

		
	}

	@Override
	public void mousePressed(MouseEvent e) { // Al pulsar raton
		
		if (e.getSource() == GestionUsuarios.getTabla()) {			
			GestionUsuarios.getBtn_Modificar().setEnabled(true);
			GestionUsuarios.getBtn_eliminar().setEnabled(true);
		}
		

	}

	@Override
	public void mouseReleased(MouseEvent e) { // al no interactuar con el

		
	}

	@Override
	public void mouseEntered(MouseEvent e) { // al tener el raton encima
		if (e.getSource() == GestionUsuarios.getBtn_eliminar()) {
			GestionUsuarios.getBtn_eliminar().setBackground(VentanaPrincipal.getAzulOscuro());
			GestionUsuarios.getBtn_eliminar().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == GestionUsuarios.getBtn_Modificar()) {
			GestionUsuarios.getBtn_Modificar().setBackground(VentanaPrincipal.getAzulOscuro());
			GestionUsuarios.getBtn_Modificar().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == GestionUsuarios.getBtn_nuevo()) {
			GestionUsuarios.getBtn_nuevo().setBackground(VentanaPrincipal.getAzulOscuro());
			GestionUsuarios.getBtn_nuevo().setForeground(VentanaPrincipal.getAzulClaro());;
		}
		if (e.getSource() == GestionUsuarios.getBtn_volver()) {
			GestionUsuarios.getBtn_volver().setBackground(VentanaPrincipal.getAzulOscuro());
			GestionUsuarios.getBtn_volver().setForeground(VentanaPrincipal.getAzulClaro());;
		}
	}

	@Override
	public void mouseExited(MouseEvent e) { //al salir el raton de encima
		if (e.getSource() == GestionUsuarios.getBtn_eliminar()) {
			GestionUsuarios.getBtn_eliminar().setBackground(VentanaPrincipal.getAzulClaro());
			GestionUsuarios.getBtn_eliminar().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == GestionUsuarios.getBtn_Modificar()) {
			GestionUsuarios.getBtn_Modificar().setBackground(VentanaPrincipal.getAzulClaro());
			GestionUsuarios.getBtn_Modificar().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == GestionUsuarios.getBtn_nuevo()) {
			GestionUsuarios.getBtn_nuevo().setBackground(VentanaPrincipal.getAzulClaro());
			GestionUsuarios.getBtn_nuevo().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
		if (e.getSource() == GestionUsuarios.getBtn_volver()) {
			GestionUsuarios.getBtn_volver().setBackground(VentanaPrincipal.getAzulClaro());
			GestionUsuarios.getBtn_volver().setForeground(VentanaPrincipal.getAzulOscuro());;
		}
	}


	public static boolean isNuevoUsuario() {
		return nuevoUsuario;
	}


	public static void setNuevoUsuario(boolean nuevoUsuario) {
		ControladorGestionUsuarios.nuevoUsuario = nuevoUsuario;
	}





		

}
