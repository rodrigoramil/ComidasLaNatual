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

public class Vista_Lista_Compra extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista_Lista_Compra frame = new Vista_Lista_Compra();
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
	public Vista_Lista_Compra() {
		setTitle("Lista de la compra");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
}
