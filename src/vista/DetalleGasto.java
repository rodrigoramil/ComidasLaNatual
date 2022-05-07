package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DetalleGasto extends JPanel {

	private JPanel contentPane;
	private JTable table;

	public DetalleGasto() {

		
		JLabel lbl_Num_Lista = new JLabel("Lista de la compra N\u00BA 5");
		lbl_Num_Lista.setBounds(10, 11, 132, 14);
		contentPane.add(lbl_Num_Lista);
		
		JButton btn_Volver = new JButton("Volver");
		btn_Volver.setBounds(335, 7, 89, 23);
		contentPane.add(btn_Volver);
		
		JLabel lbl_detalle_lista = new JLabel("Realizada el dia 05/05/2022 por Pepe");
		lbl_detalle_lista.setBounds(10, 36, 325, 14);
		contentPane.add(lbl_detalle_lista);
		
		table = new JTable();
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
		contentPane.add(table);
		
		JLabel lbl_Total = new JLabel("Total: 143,1\u20AC");
		lbl_Total.setBounds(175, 202, 110, 14);
		contentPane.add(lbl_Total);
		
		JButton btn_Guardar = new JButton("Guardar");
		btn_Guardar.setBounds(119, 227, 89, 23);
		contentPane.add(btn_Guardar);
		
		JButton btn_Imprimir = new JButton("Imprimir");
		btn_Imprimir.setBounds(224, 227, 89, 23);
		contentPane.add(btn_Imprimir);
	}

	public static JPanel inicializarComponentes() {
		// TODO Auto-generated method stub
		return null;
	}

}
