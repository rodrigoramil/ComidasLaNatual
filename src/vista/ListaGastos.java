package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class ListaGastos extends JPanel {

	private JPanel contentPane;
	private JTable table;

	public ListaGastos() {
		
		table = new JTable();
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
		contentPane.add(table);
		
		JButton btn_Volver = new JButton("Volver");
		btn_Volver.setBounds(335, 11, 89, 23);
		contentPane.add(btn_Volver);
		
		JButton btn_Ver = new JButton("Ver");
		btn_Ver.setBounds(75, 215, 89, 23);
		contentPane.add(btn_Ver);
		
		JButton btn_Calcular_Gastos = new JButton("Calcular gastos");
		btn_Calcular_Gastos.setBounds(242, 215, 112, 23);
		contentPane.add(btn_Calcular_Gastos);
	}

	public static JPanel inicializarComponentes() {
		// TODO Auto-generated method stub
		return null;
	}

}
