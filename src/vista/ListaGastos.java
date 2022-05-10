package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorListaGastos;

public class ListaGastos extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6019873536027225543L;
	
	private static JPanel panelListaGastos;
	private static JButton btn_Volver;
	private static JButton btn_Ver;
	private static JButton btn_Calcular_Gastos;
	
	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;
	
	private static JList listaListaGastos;
    private static JScrollPane scrollListaGastos;

	public ListaGastos() {
		super();
		inicializarComponentes();		
		establecerManejador();		
	}

	
	public void inicializarComponentes() {
		
		panelListaGastos = new JPanel();	
		btn_Volver = new JButton("Volver");
		btn_Ver = new JButton("Ver");
		btn_Calcular_Gastos = new JButton("Calcular gastos");
		
		panelListaGastos.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelListaGastos.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		panelListaGastos.setLayout(null);
		panelListaGastos.setVisible(false);
				
		btn_Volver.setBounds(335, 11, 89, 23);
		panelListaGastos.add(btn_Volver);
		
		btn_Ver.setBounds(75, 215, 89, 23);
		panelListaGastos.add(btn_Ver);
		
		btn_Calcular_Gastos.setBounds(242, 215, 112, 23);
		panelListaGastos.add(btn_Calcular_Gastos);
		
	    listaListaGastos = new JList();
	    listaListaGastos.setLayout(null);
	    listaListaGastos.setVisible(true);		
		
	    scrollListaGastos = new JScrollPane(listaListaGastos);	
	    scrollListaGastos.setBounds(65, 45, 330, 159);
	    scrollListaGastos.setViewportView(listaListaGastos);
	    panelListaGastos.add(scrollListaGastos);	

	}
	
	public void establecerManejador() {			
		ControladorListaGastos controlador = new ControladorListaGastos(this);
		
		listaListaGastos.addMouseListener(controlador);
		btn_Volver.addActionListener(controlador);
		btn_Ver.addActionListener(controlador);
		btn_Calcular_Gastos.addActionListener(controlador);
		
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
	
	public static JPanel getPanelListaGastos() {
		return panelListaGastos;
	}

	public static JButton getBtn_Volver() {
		return btn_Volver;
	}

	public static JButton getBtn_Ver() {
		return btn_Ver;
	}

	public static JButton getBtn_Calcular_Gastos() {
		return btn_Calcular_Gastos;
	}

	
	
	
	
}
