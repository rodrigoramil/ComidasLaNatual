package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import controlador.ControladorGestionUsuarios;
import modelo.ModeloUsuario;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
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

	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;
	
	private static JList listaGestionUsuarios;
    private static JScrollPane scrollGestionUsuarios;
    
    private static ArrayList<ModeloUsuario> arrayUsuarios;
    private static DefaultListModel modelo;
    
	public GestionUsuarios() {		
		super();
		inicializarComponentes();
		establecerManejador();		
	}


	public void inicializarComponentes() {
		
		panelGestionUsuarios = new JPanel();		
		lbl_lista_usuarios = new JLabel("Lista de Usuarios");			
		btn_nuevo = new JButton("Nuevo");		
		btn_Modificar = new JButton("Modificar");		
		btn_eliminar = new JButton("Eliminar");		
		btn_volver = new JButton("Volver");
		
		panelGestionUsuarios.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelGestionUsuarios.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		panelGestionUsuarios.setLayout(null);
		panelGestionUsuarios.setVisible(false);
		
		lbl_lista_usuarios.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_lista_usuarios.setBounds(171, 51, 143, 14);
		panelGestionUsuarios.add(lbl_lista_usuarios);
			
		btn_nuevo.setBounds(33, 221, 89, 23);
		panelGestionUsuarios.add(btn_nuevo);
		
		btn_Modificar.setBounds(171, 221, 89, 23);
		panelGestionUsuarios.add(btn_Modificar);
		
		btn_eliminar.setBounds(299, 221, 89, 23);
		panelGestionUsuarios.add(btn_eliminar);
		
		btn_volver.setBounds(335, 11, 89, 23);
		panelGestionUsuarios.add(btn_volver);

	    listaGestionUsuarios = new JList();
	    listaGestionUsuarios.setLayout(null);
	    listaGestionUsuarios.setVisible(true);		
		
	    scrollGestionUsuarios = new JScrollPane(listaGestionUsuarios);	
	    scrollGestionUsuarios.setBounds(104, 79, 253, 128);
	    scrollGestionUsuarios.setViewportView(listaGestionUsuarios);
        panelGestionUsuarios.add(scrollGestionUsuarios);	
	}
	
	private void establecerManejador() {
		
		ControladorGestionUsuarios controlador = new ControladorGestionUsuarios(this);
		
		listaGestionUsuarios.addMouseListener(controlador);
		btn_Modificar.addActionListener(controlador);
		btn_nuevo.addActionListener(controlador);
		btn_eliminar.addActionListener(controlador);
		btn_volver.addActionListener(controlador);

		
	}
/*	
 	// Hay que modificar el metodo que accede a los Usuarios de la BBDD

	public static ArrayList<ModeloUsuario> creaListaUsuarios() {
		SentenciasSQL.leerClientesBBDD();
		arrayUsuarios = SentenciasSQL.getArrayUsuarios();
		modelo = new DefaultListModel();
		for (ModeloUsuario c : arrayUsuarios) {
			modelo.addElement(c.toString());
		}
		listaGestionUsuarios.setModel(modelo);
		return arrayUsuarios;
	}
		
	 public static int usuarioSeleccionado() throws NullPointerException {
		 int indiceSeleccionado = listaUsuarios.getSelectedIndex();
		return indiceSeleccionado;		 
	 }
*/
	 
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
	
	
	
	
}
