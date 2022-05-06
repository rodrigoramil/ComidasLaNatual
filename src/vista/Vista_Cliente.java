package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Vista_Cliente extends JFrame {

	private JPanel contentPane;
	private JTextField tfd_nombre;
	private JTextField tfd_telefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista_Cliente frame = new Vista_Cliente();
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
	public Vista_Cliente() {
		setTitle("Cliente");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 208);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_nombre = new JLabel("Nombre");
		lbl_nombre.setBounds(59, 51, 46, 14);
		contentPane.add(lbl_nombre);
		
		JLabel lbl_telefono = new JLabel("Telefono");
		lbl_telefono.setBounds(59, 89, 46, 14);
		contentPane.add(lbl_telefono);
		
		tfd_nombre = new JTextField();
		tfd_nombre.setBounds(115, 48, 229, 20);
		contentPane.add(tfd_nombre);
		tfd_nombre.setColumns(10);
		
		tfd_telefono = new JTextField();
		tfd_telefono.setToolTipText("");
		tfd_telefono.setColumns(10);
		tfd_telefono.setBounds(115, 86, 229, 20);
		contentPane.add(tfd_telefono);
		
		JButton btn_Aceptar = new JButton("Aceptar");
		btn_Aceptar.setBounds(166, 127, 89, 23);
		contentPane.add(btn_Aceptar);
		
		JButton btn_volver = new JButton("Volver");
		btn_volver.setBounds(361, 11, 63, 23);
		contentPane.add(btn_volver);
	}

}
