package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Facturar extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Facturar frame = new Facturar();
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
	public Facturar() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMesa = new JLabel("Mesa 2");
		lblMesa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMesa.setBounds(25, 35, 63, 14);
		contentPane.add(lblMesa);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(335, 11, 89, 23);
		contentPane.add(btnVolver);
		
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
				"Comida /Bebidda", "Precio unidad", "Cantidad", "Precio Final"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(236);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.setBounds(25, 63, 399, 171);
		contentPane.add(table);
		
		JButton btnPagado = new JButton("Pagado");
		btnPagado.setBounds(25, 278, 89, 23);
		contentPane.add(btnPagado);
		
		JButton btnConTarjeta = new JButton("Pago con tarjeta");
		btnConTarjeta.setBounds(25, 245, 113, 23);
		contentPane.add(btnConTarjeta);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(324, 245, 31, 14);
		contentPane.add(lblTotal);
		
		JLabel lblNewLabel = new JLabel("Total + IVA(21%):");
		lblNewLabel.setBounds(261, 270, 98, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblAbonado = new JLabel("Abonono");
		lblAbonado.setBounds(309, 295, 46, 14);
		contentPane.add(lblAbonado);
		
		JLabel lblNewLabel_1 = new JLabel("A devolver:");
		lblNewLabel_1.setBounds(294, 320, 56, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblvalortotal = new JLabel("19.50");
		lblvalortotal.setBounds(365, 245, 46, 14);
		contentPane.add(lblvalortotal);
		
		JLabel lblIVA = new JLabel("23,6");
		lblIVA.setBounds(365, 270, 46, 14);
		contentPane.add(lblIVA);
		
		JLabel lblAbonados = new JLabel("25");
		lblAbonados.setBounds(365, 295, 46, 14);
		contentPane.add(lblAbonados);
		
		JLabel lblADevolver = new JLabel("1.40");
		lblADevolver.setBounds(360, 320, 46, 14);
		contentPane.add(lblADevolver);
	}
}
