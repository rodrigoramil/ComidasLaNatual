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
import javax.swing.table.DefaultTableModel;

import controlador.ControladorDetalleFactura;
import modelo.BbddVentas;
import modelo.ModeloReceta;

public class DetalleFactura extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5869503885016901049L;
	
	private static JPanel panelDetalleFactura;
	private static JLabel lbl_Num_Mesa;
	private static JLabel lbl_Detalle_Factura;
	private static JLabel lbl_Total;
	private static JLabel lbl_Cantidad_Total;
	private static JLabel lbl_IVA;
	private static JLabel lbl_Cantidad_Total_IVA;
	private static JButton btn_Volver;
	private static JButton btn_Imprimir;
	private static JTable tabla;
    private static JScrollPane scroll;
	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;

	private static ArrayList<ModeloReceta> arrayDetalleFactura;


    
	public DetalleFactura() {
		super();
		inicializarComponentes();
		establecerManejador();		
		listarDetalleFactura();
	}

	public void inicializarComponentes() {
		
		panelDetalleFactura = new JPanel();
		lbl_Num_Mesa = new JLabel("Mesa 1");
		btn_Volver = new JButton("Volver");
		lbl_Detalle_Factura = new JLabel("Facturada el dia 05/05/2022 a las 14:08 h por pepe");	
		btn_Imprimir = new JButton("Imprimir");	
		lbl_Total = new JLabel("Total:");		
		lbl_Cantidad_Total = new JLabel("0,00");		
		lbl_IVA = new JLabel("Total + IVA(21%):");	
		lbl_Cantidad_Total_IVA = new JLabel("0,00");
		tabla = new JTable();
		
		panelDetalleFactura.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelDetalleFactura.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		panelDetalleFactura.setLayout(null);
		panelDetalleFactura.setVisible(false);
		
		lbl_Num_Mesa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_Num_Mesa.setBounds(31, 32, 46, 14);
		panelDetalleFactura.add(lbl_Num_Mesa);
		
		btn_Volver.setBounds(348, 11, 76, 23);
		panelDetalleFactura.add(btn_Volver);

		lbl_Detalle_Factura.setBounds(41, 56, 298, 14);
		panelDetalleFactura.add(lbl_Detalle_Factura);
		
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
		
	    scroll = new JScrollPane(tabla);
	    scroll.setViewportView(tabla);
	    scroll.setBounds(41, 81, 362, 120);
	    panelDetalleFactura.add(scroll);	
        
	}

	
	public void establecerManejador() {			
		ControladorDetalleFactura controlador = new ControladorDetalleFactura(this);
		
		tabla.addMouseListener(controlador);
		lbl_Detalle_Factura.addMouseListener(controlador);
		lbl_Cantidad_Total.addMouseListener(controlador);
		lbl_Cantidad_Total_IVA.addMouseListener(controlador);
		lbl_Num_Mesa.addMouseListener(controlador);

		btn_Volver.addActionListener(controlador);
		btn_Imprimir.addActionListener(controlador);


	}
	
	public static void listarDetalleFactura () {
		arrayDetalleFactura = new ArrayList<ModeloReceta>();			// <-- modificar el tipo de array al modelo objeto que corresponda
        BbddVentas.listarRecetas();									// <-- modificar el método para que llame a la sentencia SQL que corresponda y y cargue los datos
        arrayDetalleFactura = BbddVentas.getArrayRecetas();				// <-- crear y modificar el metodo GET que trae los datos del array que corresponda
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.addColumn("COMIDA/BEBIDA");
        modelo.addColumn("PRECIO UNIDAD");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("PRECIO FINAL");
        
        Object filaDato[] = new Object[4];     
        for (int i = 0; i < arrayDetalleFactura.size(); i++) {
        	filaDato[0] = arrayDetalleFactura.get(i).getReceta();	// <-- llamar el dato que corresponda del objeto modelo
        	filaDato[1] = arrayDetalleFactura.get(i).getEstado();  	// <-- llamar el dato que corresponda del objeto modelo
        	filaDato[2] = arrayDetalleFactura.get(i).getReceta();	// <-- llamar el dato que corresponda del objeto modelo
        	filaDato[3] = arrayDetalleFactura.get(i).getEstado();  	// <-- llamar el dato que corresponda del objeto modelo
        	modelo.addRow(filaDato);
    	}
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
    }
	

	 public static int productoSeleccionado() throws NullPointerException {
		 int indiceSeleccionado = tabla.getSelectedRow();
		 return indiceSeleccionado;	
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
