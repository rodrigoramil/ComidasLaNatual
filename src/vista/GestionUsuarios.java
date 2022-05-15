package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import controlador.ControladorGestionUsuarios;
import modelo.ModeloUsuario;
import modelo_bbdd.BbddLogin;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

public class GestionUsuarios extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3656793065573268429L;
	
	private static JPanel panelGestionUsuarios;
	private static JLabel lbl_lista_usuarios;
	private static JButton btn_nuevo;
	private static JButton btn_Modificar;
	private static JButton btn_eliminar;
	private static JButton btn_volver;
	private static JTable tabla;
    private static JScrollPane scroll;
	private static ArrayList<ModeloUsuario> arrayUsuarios;    
    
	public GestionUsuarios() {		
		super();
		inicializarComponentes();
		establecerManejador();
		listarUsuarios();
	}


	public void inicializarComponentes() {
		
		
		panelGestionUsuarios = VentanaPrincipal.parametrosPanel(800,600);
		
		btn_volver = VentanaPrincipal.parametrosJButton("Volver", 710, 20, 70, 20);
		panelGestionUsuarios.add(btn_volver);
				
		lbl_lista_usuarios = VentanaPrincipal.parametrosJlabel("Lista de Usuarios",150, 30, 300, 40);
		lbl_lista_usuarios.setFont(new Font("Manche Condensed",Font.BOLD,(int)(15*VentanaPrincipal.getCordenadaY())));
		lbl_lista_usuarios.setForeground(Color.orange);
		panelGestionUsuarios.add(lbl_lista_usuarios);
		
		btn_nuevo = VentanaPrincipal.parametrosJButton("Nuevo",170, 520, 120, 20);
		panelGestionUsuarios.add(btn_nuevo);
		
		btn_Modificar = VentanaPrincipal.parametrosJButton("Modificar",340, 520, 120, 20);
		panelGestionUsuarios.add(btn_Modificar);
				
		btn_eliminar = VentanaPrincipal.parametrosJButton("Eliminar",510, 520, 120, 20);
		panelGestionUsuarios.add(btn_eliminar);
		
		tabla = new JTable();
		scroll = VentanaPrincipal.parametrosJScrollPane(50, 100, 700, 400);    
		panelGestionUsuarios.add(scroll);
	    
		panelGestionUsuarios.setVisible(false);
		
		
	}
	
	private void establecerManejador() {
		
		ControladorGestionUsuarios controlador = new ControladorGestionUsuarios(this);
		
		btn_Modificar.addActionListener(controlador);
		btn_nuevo.addActionListener(controlador);
		btn_eliminar.addActionListener(controlador);
		btn_volver.addActionListener(controlador);
	}
	
	public static void listarUsuarios () {
		tabla.removeAll();
		arrayUsuarios = new ArrayList<ModeloUsuario>();
        BbddLogin.listarUsuarios();
        arrayUsuarios = BbddLogin.getArrayUsuarios();
		tabla = new JTable();
		scroll.setViewportView(tabla);
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.addColumn("USUARIO");
        modelo.addColumn("ROL");
        
        Object filaDato[] = new Object[2];
        for (int i = 0; i < arrayUsuarios.size(); i++) {
        	filaDato[0] = arrayUsuarios.get(i).getNombreUsuario();
        	filaDato[1] = arrayUsuarios.get(i).getRol();
        	modelo.addRow(filaDato);
    	}
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
        tabla = VentanaPrincipal.formatoTabla(tabla);
    }
	

	 public static String usuarioSeleccionado() throws NullPointerException {
		 int indiceSeleccionado = tabla.getSelectedRow();
		 String usuarioSelecionado = null;
		 for (int i = 0; i < arrayUsuarios.size(); i++) {
			if (indiceSeleccionado==i) {
				usuarioSelecionado = arrayUsuarios.get(i).getNombreUsuario();
				return usuarioSelecionado;
			}
		}
		return usuarioSelecionado;
	 }
	 
	public static JPanel getPanelGestionUsuarios() {
		return panelGestionUsuarios;
	}

	public static JButton getBtn_nuevo() {
		return btn_nuevo;
	}


	public static JButton getBtn_Modificar() {
		return btn_Modificar;
	}


	public static JButton getBtn_eliminar() {
		return btn_eliminar;
	}


	public static JButton getBtn_volver() {
		return btn_volver;
	}


	public static JTable getTabla() {
		return tabla;
	}
	
	
	
	
}
