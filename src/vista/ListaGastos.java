package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
	private static JTable table;
	private static JButton btn_Volver;
	private static JButton btn_Ver;
	private static JButton btn_Calcular_Gastos;
	
	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;

	public ListaGastos() {
		
		panelListaGastos = new JPanel();
		table = new JTable();	
		btn_Volver = new JButton("Volver");
		btn_Ver = new JButton("Ver");
		btn_Calcular_Gastos = new JButton("Calcular gastos");
		
		establecerManejador();		
		panelListaGastos.setVisible(false);
	}

	public static JPanel inicializarComponentes() {
	
		panelListaGastos.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelListaGastos.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		panelListaGastos.setLayout(null);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"N\u00BA", "Fecha", "Compra hecha", "Gasto", "Usuario"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Boolean.class, Float.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(2).setPreferredWidth(106);
		table.setBounds(65, 45, 330, 159);
		panelListaGastos.add(table);
		
		btn_Volver.setBounds(335, 11, 89, 23);
		panelListaGastos.add(btn_Volver);
		
		btn_Ver.setBounds(75, 215, 89, 23);
		panelListaGastos.add(btn_Ver);
		
		btn_Calcular_Gastos.setBounds(242, 215, 112, 23);
		panelListaGastos.add(btn_Calcular_Gastos);
		
		
		return panelListaGastos;
	}
	
	public void establecerManejador() {			
		ControladorListaGastos controlador = new ControladorListaGastos(this);
		
		table.addMouseListener(controlador);
		btn_Volver.addActionListener(controlador);
		btn_Ver.addActionListener(controlador);
		btn_Calcular_Gastos.addActionListener(controlador);
		
	}

	public static JTable getTable() {
		return table;
	}

	public static void setTable(JTable table) {
		ListaGastos.table = table;
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
