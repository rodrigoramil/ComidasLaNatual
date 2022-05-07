package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PrepararCompra extends JPanel {

	private JPanel contentPane;
	private JTable table;


	public PrepararCompra() {

		JButton btn_Volver = new JButton("Volver");
		btn_Volver.setBounds(335, 11, 89, 23);
		contentPane.add(btn_Volver);
		
		table = new JTable();
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
		contentPane.add(table);
		
		JButton btn_Ver = new JButton("Ver");
		btn_Ver.setBounds(159, 197, 89, 23);
		contentPane.add(btn_Ver);
	}


	public static JPanel inicializarComponentes() {
		// TODO Auto-generated method stub
		return null;
	}

}
