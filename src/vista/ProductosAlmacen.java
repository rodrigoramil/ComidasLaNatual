package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorProductosAlmacen;
import controlador.ControladorRecetario;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.Choice;
import java.awt.Label;
import java.awt.Button;

public class ProductosAlmacen extends JPanel {

	private static JPanel panelProductosAlmacen;
	private static JTextField caja_nombre_producto;	
	private static JTable table;
	private static JButton btn_add_receta;;
	private static JButton btn_todos_productos;
	private static JButton btn_buscar;
	private static JButton btn_volver;
	
	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;

	private static JList listaProductosAlmacen;
    private static JScrollPane scrollProductosAlmacen;
    
	public ProductosAlmacen() {
		super();
		inicializarComponentes();				
		establecerManejador();

		
	}


	public void inicializarComponentes() {
		
		panelProductosAlmacen= new JPanel();
		caja_nombre_producto = new JTextField();
		btn_todos_productos = new JButton("Todos los productos");
		btn_buscar = new JButton("Buscar");
		btn_volver = new JButton("Volver");
		table = new JTable();
		btn_add_receta = new JButton("Añadir a la receta");
		
		panelProductosAlmacen.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelProductosAlmacen.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		panelProductosAlmacen.setLayout(null);
		panelProductosAlmacen.setVisible(false);
		
		caja_nombre_producto.setBounds(10, 45, 169, 20);
		panelProductosAlmacen.add(caja_nombre_producto);
		caja_nombre_producto.setColumns(10);
		
	
		btn_todos_productos.setBounds(10, 11, 156, 23);
		panelProductosAlmacen.add(btn_todos_productos);
		
	
		btn_buscar.setBounds(189, 44, 65, 23);
		panelProductosAlmacen.add(btn_buscar);
		

		btn_volver.setBounds(359, 11, 65, 23);
		panelProductosAlmacen.add(btn_volver);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Recetas", "Estado"
			}
		));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(10, 76, 384, 130);
		panelProductosAlmacen.add(table);
				
		btn_add_receta.setBounds(77, 227, 65, 23);
		panelProductosAlmacen.add(btn_add_receta);
		
		listaProductosAlmacen = new JList();
	    listaProductosAlmacen.setLayout(null);
	    listaProductosAlmacen.setVisible(true);		
		
	    scrollProductosAlmacen = new JScrollPane(listaProductosAlmacen);	
	    scrollProductosAlmacen.setBounds(104, 79, 253, 128);
	    scrollProductosAlmacen.setViewportView(listaProductosAlmacen);
	    panelProductosAlmacen.add(scrollProductosAlmacen);
			
	
	}
	
	public void establecerManejador() {		
		ControladorProductosAlmacen controlador = new ControladorProductosAlmacen(this);
		
		caja_nombre_producto.addActionListener(controlador);
		btn_add_receta.addActionListener(controlador);
		btn_todos_productos.addActionListener(controlador);
		btn_buscar.addActionListener(controlador);
		btn_volver.addActionListener(controlador);
		listaProductosAlmacen.addMouseListener(controlador);
			
		
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
	
	public static JTextField getCaja_nombre_producto() {
		return caja_nombre_producto;
	}


	public static void setCaja_nombre_producto(JTextField caja_nombre_producto) {
		ProductosAlmacen.caja_nombre_producto = caja_nombre_producto;
	}


	public static JTable getTable() {
		return table;
	}


	public static void setTable(JTable table) {
		ProductosAlmacen.table = table;
	}


	public static JPanel getPanelProductosAlmacen() {
		return panelProductosAlmacen;
	}


	public static JButton getBtn_add_receta() {
		return btn_add_receta;
	}


	public static JButton getBtn_todos_productos() {
		return btn_todos_productos;
	}


	public static JButton getBtn_buscar() {
		return btn_buscar;
	}


	public static JButton getBtn_volver() {
		return btn_volver;
	}
	
	
	
	
	
	
}
