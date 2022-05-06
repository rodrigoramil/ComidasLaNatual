package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Vista_Contabilidad extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista_Contabilidad frame = new Vista_Contabilidad();
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
	public Vista_Contabilidad() {
		setResizable(false);
		setTitle("Contabilidad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_Gastos = new JButton("Gastos");
		btn_Gastos.setBounds(134, 78, 163, 43);
		contentPane.add(btn_Gastos);
		
		JButton btn_volver = new JButton("Volver");
		btn_volver.setBounds(335, 23, 89, 23);
		contentPane.add(btn_volver);
		
		JButton btn_Facturacion = new JButton("Facturacion");
		btn_Facturacion.setBounds(134, 133, 163, 43);
		contentPane.add(btn_Facturacion);
	}

}
