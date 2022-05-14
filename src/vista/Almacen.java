package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorAlmacen;
import modelo.BbddVentas;
import modelo.ModeloReceta;

public class Almacen extends JPanel {

	private static JPanel panelAlmacen;
	private static JTextField textField;
	private static JButton btn_todos_los_Productos;
	private static JButton btn_Buscar;
	private static JButton btn_Volver;
	private static JButton btn_Realizar_Lista_Compra;
	private static JButton btn_Ver_Listas_Compras;
	private static JButton btn_Modificar;
	private static JButton btn_Nuevo;

	private int ancho = 800;
	private int alto = 600;
	private int posicionPanel_x = 180;
	private int posicionPanel_y = 80;
	
	private static JTable tabla;
    private static JScrollPane scroll;
	private static ArrayList<ModeloReceta> arrayProductos;
    
	public Almacen() {
		
		super();
		inicializarComponentes();		
		establecerManejador();		
		listarProductos();
	}

	public void inicializarComponentes() {
		
		panelAlmacen = VentanaPrincipal.parametrosPanel(800,600);
		
		
		btn_todos_los_Productos = VentanaPrincipal.parametrosJButton("Todos los productos",50, 30, 150, 20);
		panelAlmacen.add(btn_todos_los_Productos);
		
		btn_Volver = VentanaPrincipal.parametrosJButton("Volver", 710, 20, 70, 20);
		panelAlmacen.add(btn_Volver);
		
		
		textField = VentanaPrincipal.parametrosJTextField(50, 65, 287, 20);
		panelAlmacen.add(textField);
		
		btn_Buscar = VentanaPrincipal.parametrosJButton("Buscar",350, 65, 65, 20);
		panelAlmacen.add(btn_Buscar);
		
		btn_Realizar_Lista_Compra = VentanaPrincipal.parametrosJButton("Realizar lista de la compra",50, 520, 240, 20);
		panelAlmacen.add(btn_Realizar_Lista_Compra);
		
		btn_Ver_Listas_Compras = VentanaPrincipal.parametrosJButton("Ver listas de la compra",320, 520, 240, 20);
		panelAlmacen.add(btn_Ver_Listas_Compras);
		
		btn_Modificar = VentanaPrincipal.parametrosJButton("Modificar",630, 520, 120, 20);
		panelAlmacen.add(btn_Modificar);
		
		btn_Nuevo = VentanaPrincipal.parametrosJButton("Nuevo",630, 560, 120, 20);
		panelAlmacen.add(btn_Nuevo);
		
		tabla = new JTable();
		scroll = VentanaPrincipal.parametrosJScrollPane(50, 100, 700, 400);
	    scroll.setViewportView(tabla);
	    panelAlmacen.add(scroll);
	    
		
	    panelAlmacen.setVisible(false);
		
		
		
	}
	
	public void establecerManejador() {	
		
		ControladorAlmacen controlador = new ControladorAlmacen(this);	
		textField.addActionListener(controlador);
		
		btn_todos_los_Productos.addActionListener(controlador);
		btn_Buscar.addActionListener(controlador);
		btn_Volver.addActionListener(controlador);
		btn_Realizar_Lista_Compra.addActionListener(controlador);
		btn_Ver_Listas_Compras.addActionListener(controlador);
		btn_Modificar.addActionListener(controlador);
		btn_Nuevo.addActionListener(controlador);
		tabla.addMouseListener(controlador);
	
	}

	
	//*******
	
	public static void listarProductos () {
		arrayProductos = new ArrayList<ModeloReceta>();			// <-- modificar el tipo de array al modelo objeto que corresponda
        BbddVentas.listarClientes();							// <-- modificar el método para que llame a la sentencia SQL que corresponda y y cargue los datos
        arrayProductos = BbddVentas.getArrayRecetas();			// <-- crear y modificar el metodo GET que trae los datos del array que corresponda
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.addColumn("PRODUCTOS");
        modelo.addColumn("ACTUAL");
        modelo.addColumn("MÍNIMO");
        modelo.addColumn("MAXIMO");
        
        Object filaDato[] = new Object[4];     
        for (int i = 0; i < arrayProductos.size(); i++) {
        	filaDato[0] = arrayProductos.get(i).getReceta();	// <-- llamar el dato que corresponda del objeto modelo
        	filaDato[1] = arrayProductos.get(i).getEstado();  	// <-- llamar el dato que corresponda del objeto modelo
        	filaDato[2] = arrayProductos.get(i).getReceta();	// <-- llamar el dato que corresponda del objeto modelo
        	filaDato[3] = arrayProductos.get(i).getEstado();  	// <-- llamar el dato que corresponda del objeto modelo
        	
        	modelo.addRow(filaDato);
    	}
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
    }
	

	 public static int productoSeleccionado() throws NullPointerException {			// <-- modificar el nombre del metodo
		 int indiceSeleccionado = tabla.getSelectedRow();
		 return indiceSeleccionado;	
	 }
	
	//*******	
	
	
	
	
	
	
	
	
	
	
	public static JTextField getTextField() {
		return textField;
	}

	public static void setTextField(JTextField textField) {
		Almacen.textField = textField;
	}

	public static JPanel getPanelAlmacen() {
		return panelAlmacen;
	}

	public static JButton getBtn_todos_los_Productos() {
		return btn_todos_los_Productos;
	}

	public static JButton getBtn_Buscar() {
		return btn_Buscar;
	}

	public static JButton getBtn_Volver() {
		return btn_Volver;
	}

	public static JButton getBtn_Realizar_Lista_Compra() {
		return btn_Realizar_Lista_Compra;
	}

	public static JButton getBtn_Ver_Listas_Compras() {
		return btn_Ver_Listas_Compras;
	}

	public static JButton getBtn_Modificar() {
		return btn_Modificar;
	}

	public static JButton getBtn_Nuevo() {
		return btn_Nuevo;
	}

	
	
	
	
}
