package vista;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorDetalleFactura;

public class DetalleFactura extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5869503885016901049L;
	
	private static JPanel panelDetalleFactura;
	private static JTable table;
	private static JLabel lbl_Num_Mesa;
	private static JLabel lbl_Detalle_Factura;
	private static JLabel lbl_Total;
	private static JLabel lbl_Cantidad_Total;
	private static JLabel lbl_IVA;
	private static JLabel lbl_Cantidad_Total_IVA;
	private static JButton btn_Volver;
	private static JButton btn_Imprimir;

	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;

	public DetalleFactura() {
	
		panelDetalleFactura = new JPanel();
		lbl_Num_Mesa = new JLabel("Mesa 1");
		btn_Volver = new JButton("Volver");
		lbl_Detalle_Factura = new JLabel("Facturada el dia 05/05/2022 a las 14:08 h por pepe");
		table = new JTable();		
		btn_Imprimir = new JButton("Imprimir");	
		lbl_Total = new JLabel("Total:");		
		lbl_Cantidad_Total = new JLabel("0,00");		
		lbl_IVA = new JLabel("Total + IVA(21%):");	
		lbl_Cantidad_Total_IVA = new JLabel("0,00");
		
		establecerManejador();		
		panelDetalleFactura.setVisible(false);
	}

	public static JPanel inicializarComponentes() {
		
		panelDetalleFactura.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelDetalleFactura.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		panelDetalleFactura.setLayout(null);

		lbl_Num_Mesa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_Num_Mesa.setBounds(31, 32, 46, 14);
		panelDetalleFactura.add(lbl_Num_Mesa);
		
		btn_Volver.setBounds(348, 11, 76, 23);
		panelDetalleFactura.add(btn_Volver);

		lbl_Detalle_Factura.setBounds(41, 56, 298, 14);
		panelDetalleFactura.add(lbl_Detalle_Factura);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, "", null},
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
				"Comida / Bebida", "Precio unidad", "Cantidad", "Precio Final"
			}
		));
		table.setBounds(41, 81, 362, 120);
		panelDetalleFactura.add(table);
		
		btn_Imprimir.setBounds(39, 227, 76, 23);
		panelDetalleFactura.add(btn_Imprimir);
		
		lbl_Total.setBounds(295, 212, 28, 14);
		panelDetalleFactura.add(lbl_Total);

		lbl_Cantidad_Total.setBounds(333, 212, 46, 14);
		panelDetalleFactura.add(lbl_Cantidad_Total);

		lbl_IVA.setBounds(233, 231, 90, 14);
		panelDetalleFactura.add(lbl_IVA);

		lbl_Cantidad_Total_IVA.setBounds(333, 231, 37, 14);
		panelDetalleFactura.add(lbl_Cantidad_Total_IVA);
		
		return panelDetalleFactura;
	}

	
	public void establecerManejador() {			
		ControladorDetalleFactura controlador = new ControladorDetalleFactura(this);
		
		table.addMouseListener(controlador);
		lbl_Detalle_Factura.addMouseListener(controlador);
		lbl_Cantidad_Total.addMouseListener(controlador);
		lbl_Cantidad_Total_IVA.addMouseListener(controlador);
		lbl_Num_Mesa.addMouseListener(controlador);

		btn_Volver.addActionListener(controlador);
		btn_Imprimir.addActionListener(controlador);


	}

	public static JTable getTable() {
		return table;
	}

	public static void setTable(JTable table) {
		DetalleFactura.table = table;
	}

	public static JLabel getLbl_Num_Mesa() {
		return lbl_Num_Mesa;
	}

	public static void setLbl_Num_Mesa(JLabel lbl_Num_Mesa) {
		DetalleFactura.lbl_Num_Mesa = lbl_Num_Mesa;
	}

	public static JLabel getLbl_Detalle_Factura() {
		return lbl_Detalle_Factura;
	}

	public static void setLbl_Detalle_Factura(JLabel lbl_Detalle_Factura) {
		DetalleFactura.lbl_Detalle_Factura = lbl_Detalle_Factura;
	}

	public static JLabel getLbl_Cantidad_Total() {
		return lbl_Cantidad_Total;
	}

	public static void setLbl_Cantidad_Total(JLabel lbl_Cantidad_Total) {
		DetalleFactura.lbl_Cantidad_Total = lbl_Cantidad_Total;
	}

	public static JLabel getLbl_Cantidad_Total_IVA() {
		return lbl_Cantidad_Total_IVA;
	}

	public static void setLbl_Cantidad_Total_IVA(JLabel lbl_Cantidad_Total_IVA) {
		DetalleFactura.lbl_Cantidad_Total_IVA = lbl_Cantidad_Total_IVA;
	}

	public static JPanel getPanelDetalleFactura() {
		return panelDetalleFactura;
	}

	public static JButton getBtn_Volver() {
		return btn_Volver;
	}

	public static JButton getBtn_Imprimir() {
		return btn_Imprimir;
	}	
	
	
	
}
