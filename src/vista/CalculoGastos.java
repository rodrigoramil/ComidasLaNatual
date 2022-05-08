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

import controlador.ControladorCalculoGastos;

import javax.swing.JButton;

public class CalculoGastos extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5487305966660378713L;
	
	private static JPanel paneCalculoGastos;
	private static JTextField caja_Desde;
	private static JTextField caja_Hasta;
	private static JTable table;
	private static JLabel lbl_Desde;
	private static JLabel lbl_Hasta;
	private static JLabel lbl_Gastos;
	private static JLabel lbl_Cuenta_Gastos;
	private static JButton btn_Volver;
	private static JButton btn_Imprimir;
	
	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;

	public CalculoGastos() {
		
		paneCalculoGastos = new JPanel();
		table = new JTable();
		lbl_Desde = new JLabel("Desde");
		lbl_Hasta = new JLabel("Hasta");
		caja_Desde = new JTextField();
		caja_Hasta = new JTextField();
		lbl_Gastos = new JLabel("Total gastos");
		lbl_Cuenta_Gastos = new JLabel("0,00 \u20AC");
		btn_Volver = new JButton("Volver");
		btn_Imprimir = new JButton("Imprimir");
		
		establecerManejador();		
		paneCalculoGastos.setVisible(false);
	}

	public static JPanel inicializarComponentes() {

		paneCalculoGastos.setBorder(new EmptyBorder(5, 5, 5, 5));
		paneCalculoGastos.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		paneCalculoGastos.setLayout(null);
		
		lbl_Desde.setBounds(30, 63, 46, 14);
		paneCalculoGastos.add(lbl_Desde);

		lbl_Hasta.setBounds(30, 88, 38, 14);
		paneCalculoGastos.add(lbl_Hasta);
		
		caja_Desde = new JTextField();
		caja_Desde.setBounds(78, 60, 86, 20);
		paneCalculoGastos.add(caja_Desde);
		caja_Desde.setColumns(10);
		
		caja_Hasta = new JTextField();
		caja_Hasta.setBounds(78, 85, 86, 20);
		paneCalculoGastos.add(caja_Hasta);
		caja_Hasta.setColumns(10);
		
		lbl_Gastos.setBounds(26, 170, 75, 14);
		paneCalculoGastos.add(lbl_Gastos);
		
		lbl_Cuenta_Gastos.setBounds(40, 195, 46, 14);
		paneCalculoGastos.add(lbl_Cuenta_Gastos);
		
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
		paneCalculoGastos.add(table);
		
		btn_Volver.setBounds(335, 11, 75, 23);
		paneCalculoGastos.add(btn_Volver);
		
		btn_Imprimir.setBounds(224, 227, 89, 23);
		paneCalculoGastos.add(btn_Imprimir);
		
		return paneCalculoGastos;
	}

	public void establecerManejador() {			
		ControladorCalculoGastos controlador = new ControladorCalculoGastos(this);
		
		table.addMouseListener(controlador);
		lbl_Cuenta_Gastos.addMouseListener(controlador);
		caja_Desde.addActionListener(controlador);
		caja_Hasta.addActionListener(controlador);	
		btn_Volver.addActionListener(controlador);
		btn_Imprimir.addActionListener(controlador);
			
	}

	public static JTextField getCaja_Desde() {
		return caja_Desde;
	}

	public static void setCaja_Desde(JTextField caja_Desde) {
		CalculoGastos.caja_Desde = caja_Desde;
	}

	public static JTextField getCaja_Hasta() {
		return caja_Hasta;
	}

	public static void setCaja_Hasta(JTextField caja_Hasta) {
		CalculoGastos.caja_Hasta = caja_Hasta;
	}

	public static JTable getTable() {
		return table;
	}

	public static void setTable(JTable table) {
		CalculoGastos.table = table;
	}

	public static JLabel getLbl_Cuenta_Gastos() {
		return lbl_Cuenta_Gastos;
	}

	public static void setLbl_Cuenta_Gastos(JLabel lbl_Cuenta_Gastos) {
		CalculoGastos.lbl_Cuenta_Gastos = lbl_Cuenta_Gastos;
	}

	public static JPanel getPaneCalculoGastos() {
		return paneCalculoGastos;
	}

	public static JButton getBtn_Volver() {
		return btn_Volver;
	}

	public static JButton getBtn_Imprimir() {
		return btn_Imprimir;
	}

	public static void setPaneCalculoGastos(JPanel paneCalculoGastos) {
		CalculoGastos.paneCalculoGastos = paneCalculoGastos;
	}	
	
	
	
}
