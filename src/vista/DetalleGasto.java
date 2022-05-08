package vista;


import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorDetalleGasto;

public class DetalleGasto extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5671748687027242086L;
	
	private static JPanel panelDetalleGasto;
	private static JTable table;
	private static JLabel lbl_Num_Lista;
	private static JLabel lbl_detalle_lista;
	private static JLabel lbl_Total;
	private static JButton btn_Volver;
	private static JButton btn_Guardar;
	private static JButton btn_Imprimir;
	
	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;

	public DetalleGasto() {
		
		panelDetalleGasto = new JPanel();
		lbl_Num_Lista = new JLabel("Lista de la compra N\u00BA 5");
		table = new JTable();
		lbl_detalle_lista = new JLabel("Realizada el dia 05/05/2022 por Pepe");
		lbl_Total = new JLabel("Total: 143,1\u20AC");
		btn_Volver = new JButton("Volver");
		btn_Guardar = new JButton("Guardar");
		btn_Imprimir = new JButton("Imprimir");
		
		establecerManejador();		
		panelDetalleGasto.setVisible(false);
	}

	public static JPanel inicializarComponentes() {
		
		panelDetalleGasto.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelDetalleGasto.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		panelDetalleGasto.setLayout(null);

		lbl_Num_Lista.setBounds(10, 11, 132, 14);
		panelDetalleGasto.add(lbl_Num_Lista);

		btn_Volver.setBounds(335, 7, 89, 23);
		panelDetalleGasto.add(btn_Volver);

		lbl_detalle_lista.setBounds(10, 36, 325, 14);
		panelDetalleGasto.add(lbl_detalle_lista);

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
			},
			new String[] {
				"Productos", "Cantidad", "Gasto", "Precio medio"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Integer.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBounds(10, 76, 414, 123);
		panelDetalleGasto.add(table);

		lbl_Total.setBounds(175, 202, 110, 14);
		panelDetalleGasto.add(lbl_Total);

		btn_Guardar.setBounds(119, 227, 89, 23);
		panelDetalleGasto.add(btn_Guardar);

		btn_Imprimir.setBounds(224, 227, 89, 23);
		panelDetalleGasto.add(btn_Imprimir);
		
		return panelDetalleGasto;
	}
	
	public void establecerManejador() {			
		ControladorDetalleGasto controlador = new ControladorDetalleGasto(this);
		
		table.addMouseListener(controlador);
		lbl_Total.addMouseListener(controlador);
		lbl_detalle_lista.addMouseListener(controlador);
		lbl_Num_Lista.addMouseListener(controlador);
		btn_Volver.addActionListener(controlador);
		btn_Guardar.addActionListener(controlador);
		btn_Imprimir.addActionListener(controlador);

	}

	public static JTable getTable() {
		return table;
	}

	public static void setTable(JTable table) {
		DetalleGasto.table = table;
	}

	public static JPanel getPanelDetalleGasto() {
		return panelDetalleGasto;
	}

	public static JButton getBtn_Volver() {
		return btn_Volver;
	}

	public static JButton getBtn_Guardar() {
		return btn_Guardar;
	}

	public static JButton getBtn_Imprimir() {
		return btn_Imprimir;
	}

	public static JLabel getLbl_Total() {
		return lbl_Total;
	}

	public static void setLbl_Total(JLabel lbl_Total) {
		DetalleGasto.lbl_Total = lbl_Total;
	}

	public static JLabel getLbl_Num_Lista() {
		return lbl_Num_Lista;
	}

	public static void setLbl_Num_Lista(JLabel lbl_Num_Lista) {
		DetalleGasto.lbl_Num_Lista = lbl_Num_Lista;
	}

	public static JLabel getLbl_detalle_lista() {
		return lbl_detalle_lista;
	}

	public static void setLbl_detalle_lista(JLabel lbl_detalle_lista) {
		DetalleGasto.lbl_detalle_lista = lbl_detalle_lista;
	}	

	
	
}
