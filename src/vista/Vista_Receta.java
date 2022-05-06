package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

public class Vista_Receta extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista_Receta frame = new Vista_Receta();
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
	public Vista_Receta() {
		setTitle("Receta");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Nombre_Receta = new JLabel("Nombre de la receta");
		lbl_Nombre_Receta.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_Nombre_Receta.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Nombre_Receta.setBounds(89, 0, 424, 35);
		contentPane.add(lbl_Nombre_Receta);
		
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
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Nombre", "Cantidad"
			}
		));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(15, 51, 217, 268);
		contentPane.add(table);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(331, 51, 217, 268);
		contentPane.add(textPane);
		
		JLabel lbl_ingredientes = new JLabel("Ingredientes");
		lbl_ingredientes.setBounds(89, 35, 61, 14);
		contentPane.add(lbl_ingredientes);
		
		JLabel lblNewLabel = new JLabel("Elaboraci\u00F3n");
		lblNewLabel.setBounds(409, 35, 61, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Nuevo ingrediente");
		btnNewButton.setBounds(10, 341, 123, 23);
		contentPane.add(btnNewButton);
		
		JButton btn_Modificar_cantidad = new JButton("Modificar cantidad");
		btn_Modificar_cantidad.setBounds(159, 341, 123, 23);
		contentPane.add(btn_Modificar_cantidad);
		
		JButton btn_borrar_ingrediente = new JButton("Borrar ingrediente");
		btn_borrar_ingrediente.setBounds(308, 341, 123, 23);
		contentPane.add(btn_borrar_ingrediente);
		
		JButton btn_guardar = new JButton("Guardar");
		btn_guardar.setBounds(457, 341, 91, 39);
		contentPane.add(btn_guardar);
		
		JButton btn_volver = new JButton("Volver");
		btn_volver.setBounds(473, 7, 89, 23);
		contentPane.add(btn_volver);
	}
}
