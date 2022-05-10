package vista;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorListaFacturaciones;
import modelo.SentenciasSQL;

public class ListaFacturaciones extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7034925440369387336L;
	
	private static JPanel panelListaFacturaciones;
	private static JTable table;
	private static JButton btn_Volver;
	private static JButton btn_Ver;
	private static JButton btn_Calcular_Ganancias;
	
	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;

	public ListaFacturaciones() {

		panelListaFacturaciones = new JPanel();
		table = new JTable();
		btn_Volver = new JButton("Volver");
		btn_Ver = new JButton("Ver");
		btn_Calcular_Ganancias = new JButton("Calcular Ganancias");
		
		establecerManejador();		
		panelListaFacturaciones.setVisible(false);
	}

	public static JPanel inicializarComponentes() {
		
		panelListaFacturaciones.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelListaFacturaciones.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		panelListaFacturaciones.setLayout(null);
	
//		table = new JTable();
//		table.setModel(new DefaultTableModel(
//				SentenciasSQL.listarTabla()
				
//			new Object[][] {
//				{null, null, null, null, null},
//				{null, null, null, null, null},
//				{null, null, null, null, null},
//				{null, null, null, null, null},
//				{null, null, null, null, null},
//				{null, null, null, null, null},
//				{null, null, null, null, null},
//				{null, null, null, null, null},
//				{null, null, null, null, null},
//				{null, null, null, null, null},
//				{null, null, null, null, null},
//				{null, null, null, null, null},
//				{null, null, null, null, null},
//				{null, null, null, null, null},
//				{null, null, null, null, null},
//				{null, null, null, null, null},
//				{null, null, null, null, null},
//				{null, null, null, null, null},
//				{null, null, null, null, null},
//				{null, null, null, null, null},}
			
//			,new String[] {"N\u00BA", "Fecha", "Hora", "Ganancia", "Usuario"}
//		));
		table.setBounds(47, 48, 343, 134);
		panelListaFacturaciones.add(table);
		
		btn_Volver.setBounds(335, 14, 89, 23);
		panelListaFacturaciones.add(btn_Volver);
		
		btn_Ver.setBounds(47, 201, 89, 23);
		panelListaFacturaciones.add(btn_Ver);
		
		btn_Calcular_Ganancias.setBounds(245, 201, 123, 23);
		panelListaFacturaciones.add(btn_Calcular_Ganancias);
		
		return panelListaFacturaciones;
	}

	public void establecerManejador() {			
		ControladorListaFacturaciones controlador = new ControladorListaFacturaciones(this);
		
		table.addMouseListener(controlador);
		btn_Volver.addActionListener(controlador);
		btn_Ver.addActionListener(controlador);
		btn_Calcular_Ganancias.addActionListener(controlador);
		
	}

	public static JTable getTable() {
		return table;
	}

	public static void setTable(JTable table) {
		ListaFacturaciones.table = table;
	}

	public static JPanel getPanelListaFacturaciones() {
		return panelListaFacturaciones;
	}

	public static JButton getBtn_Volver() {
		return btn_Volver;
	}

	public static JButton getBtn_Ver() {
		return btn_Ver;
	}

	public static JButton getBtn_Calcular_Ganancias() {
		return btn_Calcular_Ganancias;
	}
	
	
	
}
