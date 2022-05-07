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

import controlador.ControladorPrepararCompra;

import javax.swing.JSpinner;

public class PrepararCompra extends JPanel {

	private static JPanel panelPrepararCompra;
	private static JTable table;
	private static JLabel lblNewLabel;
	private static JButton btn_volver;
	private static JButton btn_Guardar;
	private static JButton btn_Imprimir;
	
	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;


	public PrepararCompra() {

		panelPrepararCompra = new JPanel();
		lblNewLabel = new JLabel("Lista de la compra N\u00BAx");
		btn_volver = new JButton("Volver");
		table = new JTable();
		btn_Guardar = new JButton("Guardar");
		btn_Imprimir = new JButton("Imprimir");
		
		establecerManejador();		
		panelPrepararCompra.setVisible(false);

	}

	public static JPanel inicializarComponentes() {

		panelPrepararCompra.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelPrepararCompra.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		panelPrepararCompra.setLayout(null);

		lblNewLabel.setBounds(10, 24, 141, 14);
		panelPrepararCompra.add(lblNewLabel);
		
		btn_volver.setBounds(335, 7, 89, 23);
		panelPrepararCompra.add(btn_volver);
		
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
				"Productos", "Cantidad a comprar"
			}
		));
		table.setBounds(10, 51, 404, 166);
		panelPrepararCompra.add(table);
		
		btn_Guardar.setBounds(79, 227, 89, 23);
		panelPrepararCompra.add(btn_Guardar);
		

		btn_Imprimir.setBounds(233, 227, 89, 23);
		panelPrepararCompra.add(btn_Imprimir);
		
		
		return panelPrepararCompra;
	}
	
	
	public void establecerManejador() {			
		ControladorPrepararCompra controlador = new ControladorPrepararCompra(this);
		
		table.addMouseListener(controlador);
		btn_volver.addActionListener(controlador);
		btn_Guardar.addActionListener(controlador);
		btn_Imprimir.addActionListener(controlador);

		
	}

	public static JPanel getPanelPrepararCompra() {
		return panelPrepararCompra;
	}

	public static JButton getBtn_volver() {
		return btn_volver;
	}

	public static JButton getBtn_Guardar() {
		return btn_Guardar;
	}

	public static JButton getBtn_Imprimir() {
		return btn_Imprimir;
	}

	
	
	
	
	
	
}
