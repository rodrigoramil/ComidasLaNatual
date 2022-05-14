package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
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
		
		panelFacturar = VentanaPrincipal.parametrosPanel(800,600);
		
		
		lbl_mesa = VentanaPrincipal.parametrosJlabel("Mesa 1",50, 15, 300, 40);
		lbl_mesa.setFont(new Font("Manche Condensed",Font.BOLD,(int)(15*VentanaPrincipal.getCordenadaY())));
		lbl_mesa.setForeground(Color.orange);
		panelFacturar.add(lbl_mesa);
		
		btn_volver = VentanaPrincipal.parametrosJButton("Volver", 710, 20, 70, 20);
		panelFacturar.add(btn_volver);
		
		btn_pago_tarjeta = VentanaPrincipal.parametrosJButton("Pago con tarjeta",50, 460, 120, 20);
		panelFacturar.add(btn_pago_tarjeta);
		
		btn_pagado = VentanaPrincipal.parametrosJButton("Pagado",50, 500, 120, 40);
		panelFacturar.add(btn_pagado);
		
		
		lbl_total = VentanaPrincipal.parametrosJlabel("Total",500, 460, 120, 20);
		lbl_total.setHorizontalAlignment(SwingConstants.RIGHT);
		panelFacturar.add(lbl_total);
		
		lbl_IVA = VentanaPrincipal.parametrosJlabel("Total + IVA(21%):",500, 490, 120, 20);
		lbl_IVA.setHorizontalAlignment(SwingConstants.RIGHT);
		panelFacturar.add(lbl_IVA);
		
		lbl_abonado = VentanaPrincipal.parametrosJlabel("Abonono",500, 520, 120, 20);
		lbl_abonado.setHorizontalAlignment(SwingConstants.RIGHT);
		panelFacturar.add(lbl_abonado);
		
		lbl_devolver = VentanaPrincipal.parametrosJlabel("A devolver:",500, 550, 120, 20);
		lbl_devolver.setHorizontalAlignment(SwingConstants.RIGHT);
		panelFacturar.add(lbl_devolver);
		
		lbl_valor_total = VentanaPrincipal.parametrosJlabel("0,00 €",630, 460, 120, 20);
		lbl_valor_total.setHorizontalAlignment(SwingConstants.CENTER);
		panelFacturar.add(lbl_valor_total);
		
		lbl_valor_IVA = VentanaPrincipal.parametrosJlabel("0,00 €",630, 490, 120, 20);
		lbl_valor_IVA.setHorizontalAlignment(SwingConstants.CENTER);
		panelFacturar.add(lbl_valor_IVA);

		caja_abonado = VentanaPrincipal.parametrosJTextField(630, 520, 120, 20);
		caja_abonado.setText("0,00 €");
		caja_abonado.setBackground(VentanaPrincipal.getAzulClaro());
		caja_abonado.setHorizontalAlignment(SwingConstants.CENTER);
		panelFacturar.add(caja_abonado);
		
		lbl_valor_devolver = VentanaPrincipal.parametrosJlabel("0,00 €",630, 550, 120, 20);
		lbl_valor_devolver.setHorizontalAlignment(SwingConstants.CENTER);
		panelFacturar.add(lbl_valor_devolver);
		
		tabla = new JTable();
	    scroll = VentanaPrincipal.parametrosJScrollPane(50, 50, 700, 400);
	    scroll.setViewportView(tabla);
	    panelFacturar.add(scroll);	
		
	    panelFacturar.setVisible(false);
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
