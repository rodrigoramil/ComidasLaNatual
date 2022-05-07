package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class CalculoGastos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculoGastos frame = new CalculoGastos();
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
	public CalculoGastos() {
		setResizable(false);
		setTitle("Calculo de gastos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Desde = new JLabel("Desde");
		lbl_Desde.setBounds(30, 63, 46, 14);
		contentPane.add(lbl_Desde);
		
		JLabel lbl_Hasta = new JLabel("Hasta");
		lbl_Hasta.setBounds(30, 88, 38, 14);
		contentPane.add(lbl_Hasta);
		
		textField = new JTextField();
		textField.setBounds(78, 60, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(78, 85, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lbl_gastos = new JLabel("Total gastos");
		lbl_gastos.setBounds(26, 170, 75, 14);
		contentPane.add(lbl_gastos);
		
		JLabel lbl_Cuenta_Gastos = new JLabel("770,30 \u20AC");
		lbl_Cuenta_Gastos.setBounds(40, 195, 46, 14);
		contentPane.add(lbl_Cuenta_Gastos);
		
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
			},
			new String[] {
				"N\u00BA", "Fecha", "Gasto"
			}
		));
		table.setBounds(233, 63, 173, 146);
		contentPane.add(table);
		
		JButton btn_Volver = new JButton("Volver");
		btn_Volver.setBounds(335, 11, 75, 23);
		contentPane.add(btn_Volver);
	}

}
