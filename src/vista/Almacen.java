package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorAlmacen;

public class Almacen extends JPanel {

	private static JPanel panelAlmacen;
	private static JTextField textField;
	private static JTable table;
	private static JButton btn_todos_los_Productos;
	private static JButton btn_Buscar;
	private static JButton btn_Volver;
	private static JButton btn_Realizar_Lista_Compra;
	private static JButton btn_Ver_Listas_Compras;
	private static JButton btn_Modificar;
	private static JButton btn_Nuevo;

	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 180;
	private static int posicionPanel_y = 80;
	
	
	public Almacen() {
		
		panelAlmacen = new JPanel();	
		btn_todos_los_Productos = new JButton("Todos los productos");
		textField = new JTextField();
		btn_Buscar = new JButton("Buscar");
		btn_Volver = new JButton("Volver");
		table = new JTable();
		btn_Realizar_Lista_Compra = new JButton("Realizar lista de la compra");
		btn_Ver_Listas_Compras = new JButton("Ver listas de la compra");
		btn_Modificar = new JButton("Modificar");
		btn_Nuevo = new JButton("Nuevo");
		
		establecerManejador();		
		panelAlmacen.setVisible(false);
	}

	public static JPanel inicializarComponentes() {
		
		panelAlmacen.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelAlmacen.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		panelAlmacen.setLayout(null);

		btn_todos_los_Productos.setBounds(10, 11, 142, 23);
		panelAlmacen.add(btn_todos_los_Productos);
		
		textField.setBounds(10, 45, 177, 20);
		panelAlmacen.add(textField);
		textField.setColumns(10);
		
		btn_Buscar.setBounds(193, 44, 89, 23);
		panelAlmacen.add(btn_Buscar);
		
		btn_Volver.setBounds(378, 11, 69, 23);
		panelAlmacen.add(btn_Volver);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Productos", "Actual", "M\u00EDnimo", "M\u00E1ximo"
			}
		));
		table.setBounds(10, 76, 437, 141);
		panelAlmacen.add(table);
		
		btn_Realizar_Lista_Compra.setBounds(10, 236, 157, 23);
		panelAlmacen.add(btn_Realizar_Lista_Compra);
		
		btn_Ver_Listas_Compras.setBounds(178, 236, 142, 23);
		panelAlmacen.add(btn_Ver_Listas_Compras);
		
		btn_Modificar.setBounds(368, 228, 79, 23);
		panelAlmacen.add(btn_Modificar);
		
		btn_Nuevo.setBounds(368, 263, 79, 23);
		panelAlmacen.add(btn_Nuevo);
		
		return panelAlmacen;				
	}
	
	public void establecerManejador() {	
		
		ControladorAlmacen controlador = new ControladorAlmacen(this);	
		textField.addActionListener(controlador);
		table.addMouseListener(controlador);
		btn_todos_los_Productos.addActionListener(controlador);
		btn_Buscar.addActionListener(controlador);
		btn_Volver.addActionListener(controlador);
		btn_Realizar_Lista_Compra.addActionListener(controlador);
		btn_Ver_Listas_Compras.addActionListener(controlador);
		btn_Modificar.addActionListener(controlador);
		btn_Nuevo.addActionListener(controlador);

	
	}

	public static JPanel getPanelAlmacen() {
		return panelAlmacen;
	}

	public static JTextField getTextField() {
		return textField;
	}

	public static JTable getTable() {
		return table;
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
