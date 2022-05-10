package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorListasCompra;

public class ListasCompra extends JPanel {

	private static JPanel panelListasCompra;
	private static JTable table;
	private static JButton btn_Volver;
	private static JButton btn_Ver;
	
	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;

	public ListasCompra() {
		
		panelListasCompra = new JPanel();
		table = new JTable();	
		btn_Volver = new JButton("Volver");			
		btn_Ver = new JButton("Ver");
		inicializarComponentes();
		establecerManejador();		
		panelListasCompra.setVisible(false);
	}


	public static JPanel inicializarComponentes() {

		panelListasCompra.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelListasCompra.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		panelListasCompra.setLayout(null);
		
		btn_Volver.setBounds(335, 11, 89, 23);
		panelListasCompra.add(btn_Volver);
		

		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, Boolean.FALSE},
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
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"N\u00BA", "Fecha", "New column"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Object.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBounds(35, 50, 367, 119);
		panelListasCompra.add(table);
		

		btn_Ver.setBounds(159, 197, 89, 23);
		panelListasCompra.add(btn_Ver);
		
		
		return panelListasCompra;
	}
	
	public void establecerManejador() {			
		ControladorListasCompra controlador = new ControladorListasCompra(this);
		
		table.addMouseListener(controlador);
		btn_Volver.addActionListener(controlador);
		btn_Ver.addActionListener(controlador);
		
	}


	public static JTable getTable() {
		return table;
	}


	public static void setTable(JTable table) {
		ListasCompra.table = table;
	}


	public static JButton getBtn_Volver() {
		return btn_Volver;
	}


	public static JButton getBtn_Ver() {
		return btn_Ver;
	}
	
	
	
	
}
