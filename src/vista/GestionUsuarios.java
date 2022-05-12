package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JList;
import controlador.ControladorGestionUsuarios;
import modelo.BbddLogin;
import modelo.BbddVentas;
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
		
		panelGestionUsuarios = new JPanel();		
		lbl_lista_usuarios = new JLabel("Lista de Usuarios");			
		btn_nuevo = new JButton("Nuevo");		
		btn_Modificar = new JButton("Modificar");		
		btn_eliminar = new JButton("Eliminar");		
		btn_volver = new JButton("Volver");
		tabla = new JTable();
		
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

	    scroll = new JScrollPane(tabla);
	    scroll.setViewportView(tabla);
	    scroll.setBounds(104, 79, 253, 128);
        panelGestionUsuarios.add(scroll);	
	}
	
	private void establecerManejador() {
		
		ControladorGestionUsuarios controlador = new ControladorGestionUsuarios(this);
		
		tabla.addMouseListener(controlador);
		btn_Modificar.addActionListener(controlador);
		btn_nuevo.addActionListener(controlador);
		btn_eliminar.addActionListener(controlador);
		btn_volver.addActionListener(controlador);

		
	}
	
	public static void listarUsuarios () {
		arrayUsuarios = new ArrayList<ModeloUsuario>();			// <-- modificar el tipo de array al modelo objeto que corresponda
        BbddLogin.listarUsuarios();								// <-- modificar el método para que llame a la sentencia SQL que corresponda y y cargue los datos
        arrayUsuarios = BbddLogin.getArrayUsuarios();			// <-- crear y modificar el metodo GET que trae los datos del array que corresponda
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.addColumn("USUARIO");
        modelo.addColumn("ROL");
        
        Object filaDato[] = new Object[2];     
        for (int i = 0; i < arrayUsuarios.size(); i++) {
        	filaDato[0] = arrayUsuarios.get(i).getNombreUsuario();	// <-- llamar el dato que corresponda del objeto modelo
        	filaDato[1] = arrayUsuarios.get(i).getRol();  	// <-- llamar el dato que corresponda del objeto modelo
        	modelo.addRow(filaDato);
    	}
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
    }
	

	 public static int productoSeleccionado() throws NullPointerException {
		 int indiceSeleccionado = tabla.getSelectedRow();
		 return indiceSeleccionado;	
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
	
	
	
	
}
