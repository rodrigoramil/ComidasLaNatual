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
import javax.swing.JSpinner;

public class ListasCompra extends JPanel {

	private JPanel contentPane;
	private JTable table;

	public ListasCompra() {

		
		JLabel lblNewLabel = new JLabel("Lista de la compra N\u00BAx");
		lblNewLabel.setBounds(10, 24, 141, 14);
		contentPane.add(lblNewLabel);
		
		JButton btn_volver = new JButton("Volver");
		btn_volver.setBounds(335, 7, 89, 23);
		contentPane.add(btn_volver);
		
		table = new JTable();
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
				"Productos", "Cantidad a comprar"
			}
		));
		table.setBounds(10, 51, 404, 166);
		contentPane.add(table);
		
		JButton btn_Guardar = new JButton("Guardar");
		btn_Guardar.setBounds(79, 227, 89, 23);
		contentPane.add(btn_Guardar);
		
		JButton btn_Imprimir = new JButton("Imprimir");
		btn_Imprimir.setBounds(233, 227, 89, 23);
		contentPane.add(btn_Imprimir);
	}

	public static JPanel inicializarComponentes() {
		// TODO Auto-generated method stub
		return null;
	}
}
