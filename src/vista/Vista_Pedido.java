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
import java.awt.Color;

public class Vista_Pedido extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista_Pedido frame = new Vista_Pedido();
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
	public Vista_Pedido() {
		setResizable(false);
		setTitle("Pedido");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Num_Mesa = new JLabel("Mesa 1");
		lbl_Num_Mesa.setBounds(26, 35, 46, 14);
		contentPane.add(lbl_Num_Mesa);
		
		JButton btn_Guardar = new JButton("Guardar");
		btn_Guardar.setBounds(220, 23, 89, 31);
		contentPane.add(btn_Guardar);
		
		JButton btn_Volver = new JButton("Volver");
		btn_Volver.setBounds(335, 11, 89, 23);
		contentPane.add(btn_Volver);
		
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
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table.setBounds(26, 74, 398, 112);
		contentPane.add(table);
		
		JButton btn_Modificar = new JButton("Modificar cantidad");
		btn_Modificar.setBounds(99, 213, 119, 23);
		contentPane.add(btn_Modificar);
		
		JButton btn_Nuevo = new JButton("Nuevo");
		btn_Nuevo.setBounds(26, 213, 63, 23);
		contentPane.add(btn_Nuevo);
		
		JButton btn_Eliminar = new JButton("Eliminar");
		btn_Eliminar.setBounds(228, 213, 89, 23);
		contentPane.add(btn_Eliminar);
		
		JButton btn_Facturar = new JButton("Facturar");
		btn_Facturar.setBackground(Color.ORANGE);
		btn_Facturar.setBounds(335, 227, 89, 23);
		contentPane.add(btn_Facturar);
	}
}
