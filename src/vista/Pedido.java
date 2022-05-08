package vista;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controlador.ControladorPedido;
import java.awt.Color;

public class Pedido extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1676364911491454052L;
	
	private static JPanel panelPedido;
	private static JTable table;
	private static JLabel lbl_Num_Mesa;
	private static JButton btn_Guardar;
	private static JButton btn_Volver;
	private static JButton btn_Modificar;
	private static JButton btn_Nuevo;
	private static JButton btn_Eliminar;
	private static JButton btn_Facturar;

	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;
	
	public Pedido() {
		
		panelPedido = new JPanel();
		table = new JTable();
		lbl_Num_Mesa = new JLabel("Mesa 1");
		btn_Guardar = new JButton("Guardar");
		btn_Volver = new JButton("Volver");
		btn_Modificar = new JButton("Modificar cantidad");
		btn_Nuevo = new JButton("Nuevo");
		btn_Eliminar = new JButton("Eliminar");
		btn_Facturar = new JButton("Facturar");

		establecerManejador();		
		panelPedido.setVisible(false);
	}

	public static JPanel inicializarComponentes() {
		
		panelPedido.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelPedido.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		panelPedido.setLayout(null);
		
		lbl_Num_Mesa.setBounds(26, 35, 46, 14);
		panelPedido.add(lbl_Num_Mesa);

		btn_Guardar.setBounds(220, 23, 89, 31);
		panelPedido.add(btn_Guardar);

		btn_Volver.setBounds(335, 11, 89, 23);
		panelPedido.add(btn_Volver);

		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table.setBounds(26, 74, 398, 112);
		panelPedido.add(table);

		btn_Modificar.setBounds(99, 213, 119, 23);
		panelPedido.add(btn_Modificar);

		btn_Nuevo.setBounds(26, 213, 63, 23);
		panelPedido.add(btn_Nuevo);

		btn_Eliminar.setBounds(228, 213, 89, 23);
		panelPedido.add(btn_Eliminar);

		btn_Facturar.setBackground(Color.ORANGE);
		btn_Facturar.setBounds(335, 227, 89, 23);
		panelPedido.add(btn_Facturar);
		
		return panelPedido;
	}
	
	
	public void establecerManejador() {			
		ControladorPedido controlador = new ControladorPedido(this);
		
		table.addMouseListener(controlador);
		btn_Guardar.addActionListener(controlador);
		btn_Volver.addActionListener(controlador);
		btn_Modificar.addActionListener(controlador);
		btn_Nuevo.addActionListener(controlador);
		btn_Eliminar.addActionListener(controlador);
		btn_Facturar.addActionListener(controlador);
	
	}

	public static JTable getTable() {
		return table;
	}

	public static void setTable(JTable table) {
		Pedido.table = table;
	}

	public static JPanel getPanelPedido() {
		return panelPedido;
	}

	public static JButton getBtn_Guardar() {
		return btn_Guardar;
	}

	public static JButton getBtn_Volver() {
		return btn_Volver;
	}

	public static JButton getBtn_Modificar() {
		return btn_Modificar;
	}

	public static JButton getBtn_Nuevo() {
		return btn_Nuevo;
	}

	public static JButton getBtn_Eliminar() {
		return btn_Eliminar;
	}

	public static JButton getBtn_Facturar() {
		return btn_Facturar;
	}

	
}
