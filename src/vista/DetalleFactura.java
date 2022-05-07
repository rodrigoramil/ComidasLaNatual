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

public class DetalleFactura extends JPanel {

	private JPanel contentPane;
	private JTable table;


	public DetalleFactura() {
	
		JLabel lbl_Num_Mesa = new JLabel("Mesa 1");
		lbl_Num_Mesa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_Num_Mesa.setBounds(31, 32, 46, 14);
		contentPane.add(lbl_Num_Mesa);
		
		JButton btn_Volver = new JButton("Volver");
		btn_Volver.setBounds(348, 11, 76, 23);
		contentPane.add(btn_Volver);
		
		JLabel lbl_Detalle_Factura = new JLabel("Facturada el dia 05/05/2022 a las 14:08 h por pepe");
		lbl_Detalle_Factura.setBounds(41, 56, 298, 14);
		contentPane.add(lbl_Detalle_Factura);
		
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
		contentPane.add(table);
		
		JButton btn_Imprimir = new JButton("Imprimir");
		btn_Imprimir.setBounds(39, 227, 76, 23);
		contentPane.add(btn_Imprimir);
		
		JLabel lblNewLabel = new JLabel("Total:");
		lblNewLabel.setBounds(295, 212, 28, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lbl_Total_Factura = new JLabel("19.5");
		lbl_Total_Factura.setBounds(333, 212, 46, 14);
		contentPane.add(lbl_Total_Factura);
		
		JLabel lbl_IVA = new JLabel("Total + IVA(21%):");
		lbl_IVA.setBounds(233, 231, 90, 14);
		contentPane.add(lbl_IVA);
		
		JLabel lbl_Num_IVA = new JLabel("23.60");
		lbl_Num_IVA.setBounds(333, 231, 37, 14);
		contentPane.add(lbl_Num_IVA);
	}

	public static JPanel inicializarComponentes() {
		// TODO Auto-generated method stub
		return null;
	}

}
