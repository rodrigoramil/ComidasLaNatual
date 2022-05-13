package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorPrepararCompra;
import modelo.BbddVentas;
import modelo.ModeloReceta;


public class PrepararCompra extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5924949977958580722L;

	private static JPanel panelPrepararCompra;

	private static JLabel lblNewLabel;
	private static JButton btn_volver;
	private static JButton btn_Guardar;
	private static JButton btn_Imprimir;
	
	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;
	private static JTable tabla;
    private static JScrollPane scroll;

	private static ArrayList<ModeloReceta> arrayProductos;


	public PrepararCompra() {
		super();
		inicializarComponentes();
		establecerManejador();		
		

	}

	public void inicializarComponentes() {
		
		panelPrepararCompra = new JPanel();
		lblNewLabel = new JLabel("Lista de la compra N\u00BAx");
		btn_volver = new JButton("Volver");
		btn_Guardar = new JButton("Guardar");
		btn_Imprimir = new JButton("Imprimir");		
		panelPrepararCompra.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelPrepararCompra.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		panelPrepararCompra.setLayout(null);
		panelPrepararCompra.setVisible(false);
		tabla = new JTable();
		
		lblNewLabel.setBounds(10, 24, 141, 14);
		panelPrepararCompra.add(lblNewLabel);
		
		btn_volver.setBounds(335, 7, 89, 23);
		panelPrepararCompra.add(btn_volver);
				
		btn_Guardar.setBounds(79, 227, 89, 23);
		panelPrepararCompra.add(btn_Guardar);
		

		btn_Imprimir.setBounds(233, 227, 89, 23);
		panelPrepararCompra.add(btn_Imprimir);
		
	    scroll = new JScrollPane(tabla);
	    scroll.setViewportView(tabla);
	    scroll.setBounds(10, 51, 404, 166);
	    panelPrepararCompra.add(scroll);

	}
	
	
	public void establecerManejador() {			
		ControladorPrepararCompra controlador = new ControladorPrepararCompra(this);
		
		tabla.addMouseListener(controlador);
		btn_volver.addActionListener(controlador);
		btn_Guardar.addActionListener(controlador);
		btn_Imprimir.addActionListener(controlador);

		
	}

	public static void listarProductos () {
		arrayProductos = new ArrayList<ModeloReceta>();			// <-- modificar el tipo de array al modelo objeto que corresponda
        BbddVentas.listarRecetas();							// <-- modificar el método para que llame a la sentencia SQL que corresponda y y cargue los datos
        arrayProductos = BbddVentas.getArrayRecetas();			// <-- crear y modificar el metodo GET que trae los datos del array que corresponda
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.addColumn("PRODUCTOS");
        modelo.addColumn("CANTIDAD A COMPRAR");
        
        Object filaDato[] = new Object[2];     
        for (int i = 0; i < arrayProductos.size(); i++) {
        	filaDato[0] = arrayProductos.get(i).getReceta();	// <-- llamar el dato que corresponda del objeto modelo
        	filaDato[1] = arrayProductos.get(i).getEstado();  	// <-- llamar el dato que corresponda del objeto modelo
        	modelo.addRow(filaDato);
    	}
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
    }
	

	 public static int productoSeleccionado() throws NullPointerException {			// <-- modificar el nombre del metodo
		 int indiceSeleccionado = tabla.getSelectedRow();
		 return indiceSeleccionado;	
	 }
	
	
	
	
	public static JPanel getPanelPrepararCompra() {
		return panelPrepararCompra;
	}

	public static JButton getBtn_volver() {
		return btn_volver;
	}

	public static JButton getBtn_Guardar() {
		return btn_Guardar;
	}

	public static JButton getBtn_Imprimir() {
		return btn_Imprimir;
	}


	
	
	
	
	
	
}
