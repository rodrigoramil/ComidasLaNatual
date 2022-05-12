package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorListasCompra;
import modelo.BbddVentas;
import modelo.ModeloReceta;

public class ListasCompra extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4874909740114522589L;

	private static JPanel panelListasCompra;	
	private static JButton btn_Volver;
	private static JButton btn_Ver;	
    private static JScrollPane scrollListasCompra;
	private static JTable tabla;
    private static JScrollPane scroll;
    
	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;

	private static ArrayList<ModeloReceta> arrayListasCompra;

	public ListasCompra() {
		super();
		inicializarComponentes();
		establecerManejador();		
	}


	public void inicializarComponentes() {

		panelListasCompra = new JPanel();

		btn_Volver = new JButton("Volver");			
		btn_Ver = new JButton("Ver");
		
		panelListasCompra.setVisible(false);
		panelListasCompra.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelListasCompra.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		panelListasCompra.setLayout(null);
		tabla = new JTable();
		
		btn_Volver.setBounds(335, 11, 89, 23);
		panelListasCompra.add(btn_Volver);
		
		btn_Ver.setBounds(159, 197, 89, 23);
		panelListasCompra.add(btn_Ver);

	    scroll = new JScrollPane(tabla);
	    scroll.setViewportView(tabla);		
	    scroll.setBounds(35, 50, 367, 119);
	    panelListasCompra.add(scroll);	

	}
	
	public void establecerManejador() {			
		ControladorListasCompra controlador = new ControladorListasCompra(this);
		
		tabla.addMouseListener(controlador);
		btn_Volver.addActionListener(controlador);
		btn_Ver.addActionListener(controlador);
		
	}


	public static void listarCompras () {
		arrayListasCompra = new ArrayList<ModeloReceta>();			// <-- modificar el tipo de array al modelo objeto que corresponda
        BbddVentas.listarClientes();							// <-- modificar el método para que llame a la sentencia SQL que corresponda y y cargue los datos
        arrayListasCompra = BbddVentas.getArrayRecetas();			// <-- crear y modificar el metodo GET que trae los datos del array que corresponda
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.addColumn("Nº");
        modelo.addColumn("FECHA");
        modelo.addColumn("COMPRA HECHA");
        
        Object filaDato[] = new Object[3];     
        for (int i = 0; i < arrayListasCompra.size(); i++) {
        	filaDato[0] = arrayListasCompra.get(i).getReceta();	// <-- llamar el dato que corresponda del objeto modelo
        	filaDato[1] = arrayListasCompra.get(i).getEstado();  	// <-- llamar el dato que corresponda del objeto modelo
        	filaDato[2] = arrayListasCompra.get(i).getEstado();  	// <-- llamar el dato que corresponda del objeto modelo
        	modelo.addRow(filaDato);
    	}
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
    }
	

	 public static int productoSeleccionado() throws NullPointerException {			// <-- modificar el nombre del metodo
		 int indiceSeleccionado = tabla.getSelectedRow();
		 return indiceSeleccionado;	
	 }
	
	

	public static JPanel getPanelListasCompra() {
		return panelListasCompra;
	}


	public static JButton getBtn_Volver() {
		return btn_Volver;
	}


	public static JButton getBtn_Ver() {
		return btn_Ver;
	}
	
	
	
	
}
