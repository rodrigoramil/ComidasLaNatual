package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Choice;
import java.awt.Label;
import java.awt.Button;

public class Vista_Productos_Almacen extends JFrame {

	private JPanel contentPane;
	private JTextField tfd_Nombre;
	private JTextField tfd_Actual;
	private JTextField tfd_Minimo;
	private JTextField tfd_Maximo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista_Productos_Almacen frame = new Vista_Productos_Almacen();
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
	public Vista_Productos_Almacen() {
		setTitle("Producto Almacen");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Nombre = new JLabel("Nombre");
		lbl_Nombre.setBounds(10, 42, 51, 14);
		contentPane.add(lbl_Nombre);
		
		tfd_Nombre = new JTextField();
		tfd_Nombre.setBounds(71, 42, 284, 20);
		contentPane.add(tfd_Nombre);
		tfd_Nombre.setColumns(10);
		
		JButton btn_Nombre = new JButton("Volver");
		btn_Nombre.setBounds(335, 11, 89, 23);
		contentPane.add(btn_Nombre);
		
		JLabel lbl_tipo = new JLabel("Tipo");
		lbl_tipo.setBounds(10, 81, 46, 14);
		contentPane.add(lbl_tipo);
		
		tfd_Actual = new JTextField();
		tfd_Actual.setBounds(71, 127, 72, 20);
		contentPane.add(tfd_Actual);
		tfd_Actual.setColumns(10);
		
		JLabel lbl_Actual = new JLabel("Actual");
		lbl_Actual.setBounds(10, 127, 35, 14);
		contentPane.add(lbl_Actual);
		
		Choice choice = new Choice();
		choice.setBounds(71, 84, 72, 20);
		contentPane.add(choice);
		
		tfd_Minimo = new JTextField();
		tfd_Minimo.setBounds(71, 167, 62, 20);
		contentPane.add(tfd_Minimo);
		tfd_Minimo.setColumns(10);
		
		Label lbl_Minimo = new Label("M\u00EDnimo");
		lbl_Minimo.setBounds(10, 165, 62, 22);
		contentPane.add(lbl_Minimo);
		
		Label lbl_Maximo = new Label("M\u00E1ximo");
		lbl_Maximo.setBounds(182, 167, 62, 22);
		contentPane.add(lbl_Maximo);
		
		tfd_Maximo = new JTextField();
		tfd_Maximo.setBounds(248, 167, 86, 20);
		contentPane.add(tfd_Maximo);
		tfd_Maximo.setColumns(10);
		
		Button btn_Aceptar = new Button("Aceptar");
		btn_Aceptar.setBounds(157, 212, 70, 22);
		contentPane.add(btn_Aceptar);
	}
}
