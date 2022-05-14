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
	private boolean nuevoUsuario = false;

	public ControladorUsuario(Usuario panelUsuario) {
		this.panelUsuario = panelUsuario;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Usuario.getBtn_volver()) {
			VentanaPrincipal.getPanelGestionUsuarios().setVisible(true);
			VentanaPrincipal.getPanelUsuario().setVisible(false);
			nuevoUsuario  = false;
			
			try {
				for (int i = 0; i < BbddLogin.getArrayUsuarios().size(); i++) {
					String usuarioSelecionado = GestionUsuarios.usuarioSeleccionado();
					String usuarioBBDD = BbddLogin.getArrayUsuarios().get(i).getNombreUsuario();					
					
					if (usuarioSelecionado.equals(usuarioBBDD)) {	
						System.out.println("usuarioSelecionado -> "+usuarioSelecionado+" usuarioBBDD -> "+usuarioBBDD); // <-- BORRAR
						Usuario.getCaja_nombre().setText(BbddLogin.getArrayUsuarios().get(i).getNombreUsuario());
						Usuario.getRdbtn_admin().setSelected(true);
					}
				}											
			} catch (NullPointerException errorSelectorVacio) {				
				JOptionPane.showMessageDialog(panelUsuario, "Selecciona cliente a editar");
			}	
			
			
			
			
			
		}
		
		if (e.getSource() == Usuario.getBtn_Aceptar()) {
			VentanaPrincipal.getPanelGestionUsuarios().setVisible(true);
			VentanaPrincipal.getPanelUsuario().setVisible(false);
			Usuario.getCaja_nombre().setText("");
			Usuario.getCaja_pass_1().setText("");
			Usuario.getCaja_pass_2().setText("");
			GestionUsuarios.getTabla().clearSelection();			
			nuevoUsuario  = true;
			
			if (Usuario.getRdbtn_ventas().isSelected()) {
				usuarioVentas="Ventas";
			}
			if (Usuario.getRdbtn_Cocina().isSelected()) {
				usuarioCocina="Cocina";
			}
			if (Usuario.getRdbtn_admin().isSelected()) {
				usuarioAdmin="Administrador";
			}
			
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

	public boolean getNuevoUsuario() {
		return nuevoUsuario;
	}
	
	
	
	

}
