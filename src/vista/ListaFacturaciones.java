package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorListaFacturaciones;

public class ListaFacturaciones extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7034925440369387336L;
	
	private static JPanel panelListaFacturaciones;

	private static JButton btn_Volver;
	private static JButton btn_Ver;
	private static JButton btn_Calcular_Ganancias;
	
	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;
	
	private static JList listaListaFacturaciones;
    private static JScrollPane scrollListaFacturaciones;
	public ListaFacturaciones() {
		super();
		inicializarComponentes();
		establecerManejador();		

	}

	public static void inicializarComponentes() {
		panelListaFacturaciones = new JPanel();
		btn_Volver = new JButton("Volver");
		btn_Ver = new JButton("Ver");
		btn_Calcular_Ganancias = new JButton("Calcular Ganancias");
		
		panelListaFacturaciones.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelListaFacturaciones.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		panelListaFacturaciones.setLayout(null);
		panelListaFacturaciones.setVisible(false);
		
		
		btn_Volver.setBounds(335, 14, 89, 23);
		panelListaFacturaciones.add(btn_Volver);
		
		btn_Ver.setBounds(47, 201, 89, 23);
		panelListaFacturaciones.add(btn_Ver);
		
		btn_Calcular_Ganancias.setBounds(245, 201, 123, 23);
		panelListaFacturaciones.add(btn_Calcular_Ganancias);

		listaListaFacturaciones = new JList();
		listaListaFacturaciones.setLayout(null);
		listaListaFacturaciones.setVisible(true);		
		
	    scrollListaFacturaciones = new JScrollPane(listaListaFacturaciones);	
	    scrollListaFacturaciones.setBounds(47, 48, 343, 134);
	    scrollListaFacturaciones.setViewportView(listaListaFacturaciones);
	    panelListaFacturaciones.add(scrollListaFacturaciones);
	}

	public void establecerManejador() {			
		ControladorListaFacturaciones controlador = new ControladorListaFacturaciones(this);
		
		listaListaFacturaciones.addMouseListener(controlador);
		btn_Volver.addActionListener(controlador);
		btn_Ver.addActionListener(controlador);
		btn_Calcular_Ganancias.addActionListener(controlador);
		
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
	
	public static JPanel getPanelListaFacturaciones() {
		return panelListaFacturaciones;
	}

	public static JButton getBtn_Volver() {
		return btn_Volver;
	}

	public static JButton getBtn_Ver() {
		return btn_Ver;
	}

	public static JButton getBtn_Calcular_Ganancias() {
		return btn_Calcular_Ganancias;
	}
	
	
	
}
