package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ComidaBebida extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComidaBebida frame = new ComidaBebida();
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
	public ComidaBebida() {
		setTitle("Buscar comida / bebida");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_Comidas_Disponibles = new JButton("Comidas Disponibles");
		btn_Comidas_Disponibles.setBounds(28, 21, 145, 23);
		contentPane.add(btn_Comidas_Disponibles);
		
		JButton btn_Bebidas_Disponibles = new JButton("Bebidas Disponibles");
		btn_Bebidas_Disponibles.setBounds(183, 21, 131, 23);
		contentPane.add(btn_Bebidas_Disponibles);
		
		JButton btn_Listar_Todo = new JButton("Listar todo");
		btn_Listar_Todo.setBounds(324, 21, 89, 23);
		contentPane.add(btn_Listar_Todo);
		
		JButton btn_Volver = new JButton("Volver");
		btn_Volver.setBounds(514, 21, 89, 23);
		contentPane.add(btn_Volver);
		
		JButton btnNewButton_3 = new JButton("Buscar");
		btnNewButton_3.setBounds(337, 55, 65, 23);
		contentPane.add(btnNewButton_3);
		
		textField = new JTextField();
		textField.setBounds(28, 55, 287, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		table = new JTable();
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
			},
			new String[] {
				" Comida / Bebida", "Precio", "Estado"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Float.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(109);
		table.getColumnModel().getColumn(1).setPreferredWidth(58);
		table.setBounds(38, 89, 531, 122);
		contentPane.add(table);
		
		JButton btn_anadir = new JButton("A\u00F1adir");
		btn_anadir.setBounds(28, 222, 89, 23);
		contentPane.add(btn_anadir);
		
		JButton btn_ver_receta = new JButton("Ver receta");
		btn_ver_receta.setBounds(461, 222, 89, 23);
		contentPane.add(btn_ver_receta);
	}
}
