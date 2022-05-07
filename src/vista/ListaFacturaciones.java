package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class ListaFacturaciones extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaFacturaciones frame = new ListaFacturaciones();
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
	public ListaFacturaciones() {
		setTitle("Lista de facturaciones");
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

}
