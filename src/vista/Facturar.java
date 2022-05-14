package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorFacturar;
import modelo.ModeloPRUEBA;
import modelo_bbdd.BbddVentas;


public class Facturar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7174555621388070151L;
	
	private static JPanel panelFacturar;
	private static JButton btn_volver;
	private static JButton btn_pagado;
	private static JButton btn_pago_tarjeta;
	private static JTextField caja_abonado;
	private static JLabel lbl_mesa;
	private static JLabel lbl_IVA;
	private static JLabel lbl_total;
	private static JLabel lbl_abonado;
	private static JLabel lbl_devolver;
	private static JLabel lbl_valor_total;
	private static JLabel lbl_valor_devolver;
	private static JLabel lbl_valor_IVA;

	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;
	
	private static JTable tabla;
    private static JScrollPane scroll;

	private static ArrayList<ModeloPRUEBA> arrayFacturas;

    
	public Facturar() {
		super();
		inicializarComponentes();
		establecerManejador();
		factura();
	}


	public void inicializarComponentes() {
		
		panelFacturar = new JPanel();
		lbl_mesa = new JLabel("Mesa 0");
		btn_volver = new JButton("Volver");
		tabla = new JTable();		
		btn_pagado = new JButton("Pagado");
		btn_pago_tarjeta = new JButton("Pago con tarjeta");
		caja_abonado = new JTextField();
		lbl_total = new JLabel("Total");
		lbl_IVA = new JLabel("Total + IVA(21%):");
		lbl_abonado = new JLabel("Abonono");
		lbl_devolver = new JLabel("A devolver:");
		lbl_valor_total = new JLabel("0,00");
		lbl_valor_IVA = new JLabel("0,00");		
		lbl_valor_devolver = new JLabel("0,00");
		
		panelFacturar.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelFacturar.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		panelFacturar.setLayout(null);
		panelFacturar.setVisible(false);
		
		lbl_mesa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_mesa.setBounds(25, 35, 63, 14);
		panelFacturar.add(lbl_mesa);

		btn_volver.setBounds(335, 11, 89, 23);
		panelFacturar.add(btn_volver);

		btn_pagado.setBounds(25, 278, 89, 23);
		panelFacturar.add(btn_pagado);

		btn_pago_tarjeta.setBounds(25, 245, 113, 23);
		panelFacturar.add(btn_pago_tarjeta);

		lbl_total.setBounds(324, 245, 31, 14);
		panelFacturar.add(lbl_total);

		lbl_IVA.setBounds(261, 270, 98, 14);
		panelFacturar.add(lbl_IVA);

		lbl_abonado.setBounds(309, 295, 46, 14);
		panelFacturar.add(lbl_abonado);

		lbl_devolver.setBounds(294, 320, 56, 14);
		panelFacturar.add(lbl_devolver);

		lbl_valor_total.setBounds(365, 245, 46, 14);
		panelFacturar.add(lbl_valor_total);

		lbl_valor_IVA.setBounds(365, 270, 46, 14);
		panelFacturar.add(lbl_valor_IVA);

		caja_abonado.setBounds(365, 295, 46, 14);
		panelFacturar.add(caja_abonado);

		lbl_valor_devolver.setBounds(360, 320, 46, 14);
		panelFacturar.add(lbl_valor_devolver);

	    scroll = new JScrollPane(tabla);
	    scroll.setViewportView(tabla);
	    scroll.setBounds(25, 63, 399, 171);
	    panelFacturar.add(scroll);	
		
	}
	
	public void establecerManejador() {			
		ControladorFacturar controlador = new ControladorFacturar(this);
		
		tabla.addMouseListener(controlador);
		lbl_valor_total.addMouseListener(controlador);
		lbl_valor_devolver.addMouseListener(controlador);
		lbl_valor_IVA.addMouseListener(controlador);
		
		btn_volver.addActionListener(controlador);
		btn_pagado.addActionListener(controlador);
		btn_pago_tarjeta.addActionListener(controlador);
		
	}
	
	public static void factura () {
		arrayFacturas = new ArrayList<ModeloPRUEBA>();			// <-- modificar el tipo de array al modelo objeto que corresponda
        BbddVentas.listarClientes();							// <-- modificar el método para que llame a la sentencia SQL que corresponda y y cargue los datos
        arrayFacturas = BbddVentas.getArrayRecetas();			// <-- crear y modificar el metodo GET que trae los datos del array que corresponda
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.addColumn("COMIDA/BEBIDA");
        modelo.addColumn("PRECIO UNIDAD");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("PRECIO");
        
        Object filaDato[] = new Object[4];     
        for (int i = 0; i < arrayFacturas.size(); i++) {
        	filaDato[0] = arrayFacturas.get(i).getReceta();	// <-- llamar el dato que corresponda del objeto modelo
        	filaDato[1] = arrayFacturas.get(i).getEstado();  	// <-- llamar el dato que corresponda del objeto modelo
        	filaDato[2] = arrayFacturas.get(i).getEstado();  	// <-- llamar el dato que corresponda del objeto modelo
        	filaDato[3] = arrayFacturas.get(i).getEstado();  	// <-- llamar el dato que corresponda del objeto modelo
        	modelo.addRow(filaDato);
    	}
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
    }
	

	 public static int productoSeleccionado() throws NullPointerException {			// <-- modificar el nombre del metodo
		 int indiceSeleccionado = tabla.getSelectedRow();
		 return indiceSeleccionado;	
	 }

	public static JLabel getLbl_valor_total() {
		return lbl_valor_total;
	}


	public static void setLbl_valor_total(JLabel lbl_valor_total) {
		Facturar.lbl_valor_total = lbl_valor_total;
	}


	public static JLabel getLbl_valor_devolver() {
		return lbl_valor_devolver;
	}


	public static void setLbl_valor_devolver(JLabel lbl_valor_devolver) {
		Facturar.lbl_valor_devolver = lbl_valor_devolver;
	}


	public static JLabel getLbl_valor_IVA() {
		return lbl_valor_IVA;
	}


	public static void setLbl_valor_IVA(JLabel lbl_valor_IVA) {
		Facturar.lbl_valor_IVA = lbl_valor_IVA;
	}


	public static JPanel getPanelFacturar() {
		return panelFacturar;
	}


	public static JButton getBtn_volver() {
		return btn_volver;
	}


	public static JButton getBtn_pagado() {
		return btn_pagado;
	}


	public static JButton getBtn_pago_tarjeta() {
		return btn_pago_tarjeta;
	}


	public static JTextField getCaja_abonado() {
		return caja_abonado;
	}	
	
	
}
