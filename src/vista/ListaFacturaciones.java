package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class ListaFacturaciones extends JPanel {

	private JPanel contentPane;
	private JTable table;


	public ListaFacturaciones() {

		
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
				"N\u00BA", "Fecha", "Hora", "Ganancia", "Usuario"
			}
		));
		table.setBounds(47, 48, 343, 134);
		contentPane.add(table);
		
		JButton btn_Volver = new JButton("Volver");
		btn_Volver.setBounds(335, 14, 89, 23);
		contentPane.add(btn_Volver);
		
		JButton btn_Ver = new JButton("Ver");
		btn_Ver.setBounds(47, 201, 89, 23);
		contentPane.add(btn_Ver);
		
		JButton btn_Calcular_Ganancias = new JButton("Calcular Ganancias");
		btn_Calcular_Ganancias.setBounds(245, 201, 123, 23);
		contentPane.add(btn_Calcular_Ganancias);
	}

	public static JPanel inicializarComponentes() {
		// TODO Auto-generated method stub
		return null;
	}

}
