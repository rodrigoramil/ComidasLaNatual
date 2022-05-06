package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Vista_Calculo_Ganancias extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tfd_Desde;
	private JTextField tfd_hasta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista_Calculo_Ganancias frame = new Vista_Calculo_Ganancias();
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
	public Vista_Calculo_Ganancias() {
		setResizable(false);
		setTitle("Calculo de Ganancias");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_Volver = new JButton("Volver");
		btn_Volver.setBounds(348, 11, 76, 23);
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
				"N\u00BA", "Fecha", "Hora", "Ganancias"
			}
		));
		table.setBounds(185, 51, 228, 148);
		contentPane.add(table);
		
		JLabel lbl_Desde = new JLabel("Desde");
		lbl_Desde.setBounds(10, 64, 46, 14);
		contentPane.add(lbl_Desde);
		
		JLabel lbl_Hasta = new JLabel("Hasta");
		lbl_Hasta.setBounds(10, 95, 46, 14);
		contentPane.add(lbl_Hasta);
		
		tfd_Desde = new JTextField();
		tfd_Desde.setBounds(48, 61, 86, 20);
		contentPane.add(tfd_Desde);
		tfd_Desde.setColumns(10);
		
		tfd_hasta = new JTextField();
		tfd_hasta.setBounds(48, 92, 86, 20);
		contentPane.add(tfd_hasta);
		tfd_hasta.setColumns(10);
		
		JLabel lbl_Total_Ganancias = new JLabel("Total Ganancias");
		lbl_Total_Ganancias.setBounds(30, 161, 86, 14);
		contentPane.add(lbl_Total_Ganancias);
		
		JLabel lbl_Ganancias = new JLabel("284,76");
		lbl_Ganancias.setBounds(40, 186, 46, 14);
		contentPane.add(lbl_Ganancias);
		
		JButton btn_Imprimir = new JButton("Imprimir");
		btn_Imprimir.setBounds(185, 210, 76, 23);
		contentPane.add(btn_Imprimir);
	}

}
