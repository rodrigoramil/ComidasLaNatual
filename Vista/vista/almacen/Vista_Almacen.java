package vista.almacen;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Vista_Almacen extends JFrame {

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
					Vista_Almacen frame = new Vista_Almacen();
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
	public Vista_Almacen() {
		setTitle("Almac\u00E9n");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_todos_los_Productos = new JButton("Todos los productos");
		btn_todos_los_Productos.setBounds(10, 11, 142, 23);
		contentPane.add(btn_todos_los_Productos);
		
		textField = new JTextField();
		textField.setBounds(10, 45, 177, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btn_Buscar = new JButton("Buscar");
		btn_Buscar.setBounds(193, 44, 89, 23);
		contentPane.add(btn_Buscar);
		
		JButton btn_Volver = new JButton("Volver");
		btn_Volver.setBounds(378, 11, 69, 23);
		contentPane.add(btn_Volver);
		
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
				"Productos", "Actual", "M\u00EDnimo", "M\u00E1ximo"
			}
		));
		table.setBounds(10, 76, 437, 141);
		contentPane.add(table);
		
		JButton btn_Realizar_Lista_Compra = new JButton("Realizar lista de la compra");
		btn_Realizar_Lista_Compra.setBounds(10, 236, 157, 23);
		contentPane.add(btn_Realizar_Lista_Compra);
		
		JButton btn_Ver_Listas_Compras = new JButton("Ver listas de la compra");
		btn_Ver_Listas_Compras.setBounds(178, 236, 142, 23);
		contentPane.add(btn_Ver_Listas_Compras);
		
		JButton btn_Modificar = new JButton("Modificar");
		btn_Modificar.setBounds(368, 228, 79, 23);
		contentPane.add(btn_Modificar);
		
		JButton btn_Nuevo = new JButton("Nuevo");
		btn_Nuevo.setBounds(368, 263, 79, 23);
		contentPane.add(btn_Nuevo);
	}

}
