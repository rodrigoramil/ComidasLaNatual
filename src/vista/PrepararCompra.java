package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorPrepararCompra;

import javax.swing.JSpinner;

public class PrepararCompra extends JPanel {

	private static JPanel panelPrepararCompra;

	private static JLabel lblNewLabel;
	private static JButton btn_volver;
	private static JButton btn_Guardar;
	private static JButton btn_Imprimir;
	
	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;
	
	private static JList listaPrepararCompra;
    private static JScrollPane scrollPrepararCompra;

	public PrepararCompra() {
		super();
		inicializarComponentes();
		establecerManejador();		
		

	}

	public void inicializarComponentes() {
		
		panelPrepararCompra = new JPanel();
		lblNewLabel = new JLabel("Lista de la compra N\u00BAx");
		btn_volver = new JButton("Volver");
		btn_Guardar = new JButton("Guardar");
		btn_Imprimir = new JButton("Imprimir");		
		panelPrepararCompra.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelPrepararCompra.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		panelPrepararCompra.setLayout(null);
		panelPrepararCompra.setVisible(false);
		
		lblNewLabel.setBounds(10, 24, 141, 14);
		panelPrepararCompra.add(lblNewLabel);
		
		btn_volver.setBounds(335, 7, 89, 23);
		panelPrepararCompra.add(btn_volver);
				
		btn_Guardar.setBounds(79, 227, 89, 23);
		panelPrepararCompra.add(btn_Guardar);
		

		btn_Imprimir.setBounds(233, 227, 89, 23);
		panelPrepararCompra.add(btn_Imprimir);
		
	    listaPrepararCompra = new JList();
	    listaPrepararCompra.setLayout(null);
	    listaPrepararCompra.setVisible(true);		
		
	    scrollPrepararCompra = new JScrollPane(listaPrepararCompra);	
	    scrollPrepararCompra.setBounds(10, 51, 404, 166);
	    scrollPrepararCompra.setViewportView(listaPrepararCompra);
	    panelPrepararCompra.add(scrollPrepararCompra);

	}
	
	
	public void establecerManejador() {			
		ControladorPrepararCompra controlador = new ControladorPrepararCompra(this);
		
		listaPrepararCompra.addMouseListener(controlador);
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

	public static JList getListaPrepararCompra() {
		return listaPrepararCompra;
	}

	public static JScrollPane getScrollPrepararCompra() {
		return scrollPrepararCompra;
	}


	
	
	
	
	
	
}
