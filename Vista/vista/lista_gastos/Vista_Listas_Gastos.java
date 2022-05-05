package vista.lista_gastos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class Vista_Listas_Gastos extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista_Listas_Gastos frame = new Vista_Listas_Gastos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vista_Listas_Gastos() {
		setTitle("Lista de gastos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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

}
