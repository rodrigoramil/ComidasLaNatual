package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controlador.ControladorAlmacen;
import modelo.ModeloAlmacen;
import modelo_bbdd.BbddAlmacen;


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
	private static ArrayList<ModeloAlmacen> arrayAlmacen;
    
	public Almacen() {
		
		super();
		inicializarComponentes();		
		establecerManejador();		
		listarProductos();
	}

	public void inicializarComponentes() {
		
		panelAlmacen = new JPanel();	
		btn_todos_los_Productos = new JButton("Todos los productos");
		textField = new JTextField();
		btn_Buscar = new JButton("Buscar");
		btn_Volver = new JButton("Volver");
		btn_Realizar_Lista_Compra = new JButton("Realizar lista de la compra");
		btn_Ver_Listas_Compras = new JButton("Ver listas de la compra");
		btn_Modificar = new JButton("Modificar");
		btn_Nuevo = new JButton("Nuevo");
		tabla = new JTable();
		
		panelAlmacen.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelAlmacen.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		panelAlmacen.setLayout(null);
		panelAlmacen.setVisible(false);

		btn_todos_los_Productos.setBounds(10, 11, 142, 23);
		panelAlmacen.add(btn_todos_los_Productos);
		
		textField.setBounds(10, 45, 177, 20);
		panelAlmacen.add(textField);
		textField.setColumns(10);
		
		btn_Buscar.setBounds(193, 44, 89, 23);
		panelAlmacen.add(btn_Buscar);
		
		btn_Volver.setBounds(378, 11, 69, 23);
		panelAlmacen.add(btn_Volver);
		
		btn_Realizar_Lista_Compra.setBounds(10, 236, 157, 23);
		panelAlmacen.add(btn_Realizar_Lista_Compra);
		
		btn_Ver_Listas_Compras.setBounds(178, 236, 142, 23);
		panelAlmacen.add(btn_Ver_Listas_Compras);
		
		btn_Modificar.setBounds(368, 228, 79, 23);
		panelAlmacen.add(btn_Modificar);
		
		btn_Nuevo.setBounds(368, 263, 79, 23);
		panelAlmacen.add(btn_Nuevo);

	    scroll = new JScrollPane(tabla);
	    scroll.setViewportView(tabla);
	    scroll.setBounds(10, 76, 437, 141);
	    panelAlmacen.add(scroll);	
				
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
		arrayAlmacen = new ArrayList<ModeloAlmacen>();
        BbddAlmacen.listarProductosAlmacen();
        arrayAlmacen = BbddAlmacen.getArrayAlmacen();	
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.addColumn("PRODUCTOS");
        modelo.addColumn("ACTUAL");
        modelo.addColumn("MÍNIMO");
        modelo.addColumn("MAXIMO");
        
        Object filaDato[] = new Object[4];     
        for (int i = 0; i < arrayAlmacen.size(); i++) {
        	filaDato[0] = arrayAlmacen.get(i).getNombreProducto();
        	filaDato[1] = arrayAlmacen.get(i).getCantidadActual();
        	filaDato[2] = arrayAlmacen.get(i).getCantidadMinima();
        	filaDato[3] = arrayAlmacen.get(i).getCantidadMaxima();
        	
        	modelo.addRow(filaDato);
    	}
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
    }
	

	 public static int indiceSeleccionado() throws NullPointerException {
		 int indiceSeleccionado = tabla.getSelectedRow();
		 return indiceSeleccionado;	
	 }

	
	
	
	
	
	
	
	
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
