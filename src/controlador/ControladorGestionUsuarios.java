package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import modelo_bbdd.BbddLogin;
import vista.GestionUsuarios;
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

			String nuevoNombre = Usuario.getCaja_nombre().getText();
			String pass1 = Usuario.getCaja_pass_1().getText();
			String pass2 = Usuario.getCaja_pass_2().getText();
			if (pass1.equals(pass2)) {
				
				/* Falta implementar el método en la clase Login que realice una sentencia SQL con un INSERT INTO */
				
				System.out.println("nuevoNombre: "+nuevoNombre+" - pass1: "+pass1+" - pass2: "+pass1);
				
				
			}

		}
		
		
		
		
		if (e.getSource() == GestionUsuarios.getBtn_Modificar()) {
			nuevoUsuario = false;
			try {
				usuarioSelecionado = GestionUsuarios.usuarioSeleccionado();
				comprobarUsuario();
				
				VentanaPrincipal.getPanelGestionUsuarios().setVisible(false);
				VentanaPrincipal.getPanelUsuario().setVisible(true);
				
			} catch (NullPointerException errorSelectorVacio) {				
				JOptionPane.showMessageDialog(panelGestionUsuarios, "Selecciona cliente a editar");
			}	
		}
		
		
		
		
		if (e.getSource() == GestionUsuarios.getBtn_eliminar()) {
				
			try {	
				usuarioSelecionado = GestionUsuarios.usuarioSeleccionado();
				comprobarUsuario();
				
	//			String eliminaUsuario = "Manolete";
				JOptionPane.showConfirmDialog(panelGestionUsuarios, "Quiere eleminar el usuario "+usuarioSelecionado);

				
			} catch (NullPointerException errorSelectorVacio) {				
				JOptionPane.showMessageDialog(panelGestionUsuarios, "Selecciona cliente a eliminar");
			}	
			
			GestionUsuarios.getTabla().clearSelection();
			
		}
		
	}
	


	private void comprobarUsuario() {
		
		for (int i = 0; i < BbddLogin.getArrayUsuarios().size(); i++) {			
			String usuarioNombreBBDD = BbddLogin.getArrayUsuarios().get(i).getNombreUsuario();				
			if (usuarioSelecionado.equals(usuarioNombreBBDD)) {	
				Usuario.getCaja_nombre().setText(BbddLogin.getArrayUsuarios().get(i).getNombreUsuario());				
				String usuarioRolBBDD = BbddLogin.getArrayUsuarios().get(i).getRol();
				
				System.out.println("usuarioSelecionado -> "+usuarioSelecionado+" usuarioBBDD -> "+usuarioNombreBBDD); 	// <------- BORRAR
				System.out.println("Rol - "+usuarioRolBBDD);															 // <------ BORRAR
				
				if (usuarioRolBBDD.equals("Administrador")) {
					Usuario.getRdbtn_admin().setSelected(true);
				} 
				else if (usuarioRolBBDD.equals("Cocina")){
					Usuario.getRdbtn_Cocina().setSelected(true);
				}
				else {
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


	}

	@Override
	public void mouseReleased(MouseEvent e) { // al no interactuar con el

		
	}

	@Override
	public void mouseEntered(MouseEvent e) { // al tener el raton encima

		
	}

	@Override
	public void mouseExited(MouseEvent e) { //al salir el raton de encima

		
	}


	public static boolean isNuevoUsuario() {
		return nuevoUsuario;
	}


	public static void setNuevoUsuario(boolean nuevoUsuario) {
		ControladorGestionUsuarios.nuevoUsuario = nuevoUsuario;
	}





		

}
