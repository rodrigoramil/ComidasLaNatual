package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorListaGastos;
import modelo.BbddVentas;
import modelo.ModeloReceta;

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
	
	private static JTable tabla;
    private static JScrollPane scroll;

	private static ArrayList<ModeloReceta> arrayListaGastos;

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
		tabla = new JTable();
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
		
	    scroll = new JScrollPane(tabla);
	    scroll.setViewportView(tabla);
	    scroll.setBounds(65, 45, 330, 159);
	    panelListaGastos.add(scroll);	

	}
	
	public void establecerManejador() {			
		ControladorListaGastos controlador = new ControladorListaGastos(this);
		
		tabla.addMouseListener(controlador);
		btn_Volver.addActionListener(controlador);
		btn_Ver.addActionListener(controlador);
		btn_Calcular_Gastos.addActionListener(controlador);
		
	}

	public static void listarGastos () {
		arrayListaGastos = new ArrayList<ModeloReceta>();			// <-- modificar el tipo de array al modelo objeto que corresponda
        BbddVentas.listarRecetas();							// <-- modificar el método para que llame a la sentencia SQL que corresponda y y cargue los datos
        arrayListaGastos = BbddVentas.getArrayRecetas();			// <-- crear y modificar el metodo GET que trae los datos del array que corresponda
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.addColumn("Nº");
        modelo.addColumn("FECHA");
        modelo.addColumn("COMPRA HECHA");
        modelo.addColumn("GASTO");
        modelo.addColumn("USUARIO");
        
        Object filaDato[] = new Object[5];     
        for (int i = 0; i < arrayListaGastos.size(); i++) {
        	filaDato[0] = arrayListaGastos.get(i).getReceta();	// <-- llamar el dato que corresponda del objeto modelo
        	filaDato[1] = arrayListaGastos.get(i).getEstado();  	// <-- llamar el dato que corresponda del objeto modelo
        	filaDato[2] = arrayListaGastos.get(i).getReceta();	// <-- llamar el dato que corresponda del objeto modelo
        	filaDato[3] = arrayListaGastos.get(i).getEstado();  	// <-- llamar el dato que corresponda del objeto modelo
        	filaDato[4] = arrayListaGastos.get(i).getReceta();	// <-- llamar el dato que corresponda del objeto modelo
        	modelo.addRow(filaDato);
    	}
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
    }
	

	 public static int productoSeleccionado() throws NullPointerException {			// <-- modificar el nombre del metodo
		 int indiceSeleccionado = tabla.getSelectedRow();
		 return indiceSeleccionado;	
	 }
	
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
