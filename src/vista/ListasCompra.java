package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorListasCompra;

public class ListasCompra extends JPanel {

	private static JPanel panelListasCompra;
	
	private static JButton btn_Volver;
	private static JButton btn_Ver;
	
	private static JList listaListasCompra;
    private static JScrollPane scrollListasCompra;
	
	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;

	public ListasCompra() {
		super();
		inicializarComponentes();
		establecerManejador();		
	}


	public void inicializarComponentes() {

		panelListasCompra = new JPanel();

		btn_Volver = new JButton("Volver");			
		btn_Ver = new JButton("Ver");
		
		panelListasCompra.setVisible(false);
		panelListasCompra.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelListasCompra.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		panelListasCompra.setLayout(null);
		
		btn_Volver.setBounds(335, 11, 89, 23);
		panelListasCompra.add(btn_Volver);
		
		btn_Ver.setBounds(159, 197, 89, 23);
		panelListasCompra.add(btn_Ver);

	    listaListasCompra = new JList();
	    listaListasCompra.setLayout(null);
	    listaListasCompra.setVisible(true);		
		
	    scrollListasCompra = new JScrollPane(listaListasCompra);	
	    scrollListasCompra.setBounds(35, 50, 367, 119);
	    scrollListasCompra.setViewportView(listaListasCompra);
	    panelListasCompra.add(scrollListasCompra);	

	}
	
	public void establecerManejador() {			
		ControladorListasCompra controlador = new ControladorListasCompra(this);
		
		listaListasCompra.addMouseListener(controlador);
		btn_Volver.addActionListener(controlador);
		btn_Ver.addActionListener(controlador);
		
	}



	public static JPanel getPanelListasCompra() {
		return panelListasCompra;
	}


	public static JButton getBtn_Volver() {
		return btn_Volver;
	}


	public static JButton getBtn_Ver() {
		return btn_Ver;
	}
	
	
	
	
}
