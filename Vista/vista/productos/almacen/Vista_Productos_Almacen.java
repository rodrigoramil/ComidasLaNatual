package vista.productos.almacen;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Vista_Productos_Almacen extends JFrame {

	private JPanel contentPane;
	private JTextField jtf_buscar_productos;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista_Productos_Almacen frame = new Vista_Productos_Almacen();
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
	public Vista_Productos_Almacen() {
		setTitle("Productos del almacen");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_todoslosproductos = new JLabel("Todos los productos");
		lbl_todoslosproductos.setBounds(10, 11, 131, 14);
		contentPane.add(lbl_todoslosproductos);
		
		JButton btn_buscar = new JButton("Buscar");
		btn_buscar.setBounds(177, 35, 74, 23);
		contentPane.add(btn_buscar);
		
		jtf_buscar_productos = new JTextField();
		jtf_buscar_productos.setBounds(10, 36, 157, 20);
		contentPane.add(jtf_buscar_productos);
		jtf_buscar_productos.setColumns(10);
		
		JButton btn_volver = new JButton("Volver");
		btn_volver.setBounds(335, 7, 89, 23);
		contentPane.add(btn_volver);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, "Actual"},
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
				"Productos", "Actual"
			}
		));
		table.setBounds(10, 67, 403, 160);
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("A\u00F1adir a la receta");
		btnNewButton.setBounds(146, 238, 131, 23);
		contentPane.add(btnNewButton);
	}

}
