package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class Vista_Recetario extends JFrame {

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
					Vista_Recetario frame = new Vista_Recetario();
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
	public Vista_Recetario() {
		setResizable(false);
		setTitle("Recetario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 45, 169, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btn_listadoRecetas = new JButton("Lista de todas las recetas");
		btn_listadoRecetas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_listadoRecetas.setBounds(10, 11, 156, 23);
		contentPane.add(btn_listadoRecetas);
		
		JButton btn_buscar = new JButton("Buscar");
		btn_buscar.setBounds(189, 44, 65, 23);
		contentPane.add(btn_buscar);
		
		JButton btn_volver = new JButton("Volver");
		btn_volver.setBounds(359, 11, 65, 23);
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
				"Recetas", "Estado"
			}
		));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(10, 76, 384, 130);
		contentPane.add(table);
		
		JButton btn_ver_recetas = new JButton("Ver");
		btn_ver_recetas.setBounds(10, 227, 57, 23);
		contentPane.add(btn_ver_recetas);
		
		JButton btnNewButton = new JButton("Nuevo");
		btnNewButton.setBounds(77, 227, 65, 23);
		contentPane.add(btnNewButton);
		
		JButton btn_Modificar_Receta = new JButton("Modificar");
		btn_Modificar_Receta.setBounds(154, 227, 75, 23);
		contentPane.add(btn_Modificar_Receta);
		
		JButton btn_Cambiar_Estado = new JButton("Cambiar Estado");
		btn_Cambiar_Estado.setBounds(287, 227, 107, 23);
		contentPane.add(btn_Cambiar_Estado);
	
	}
}
