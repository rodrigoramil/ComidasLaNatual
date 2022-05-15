package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import controlador.ControladorDetalleFactura;
import modelo.ModeloPRUEBA;
import modelo_bbdd.BbddVentas;

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
	private static ArrayList<ModeloPRUEBA> arrayDetalleFactura;

	public DetalleFactura() {
		super();
		inicializarComponentes();
		establecerManejador();		
		listarDetalleFactura();
	}

	public void inicializarComponentes() {
		
		panelDetalleFactura = VentanaPrincipal.parametrosPanel(800,600);

		lbl_Num_Mesa = VentanaPrincipal.parametrosJlabel("Mesa 1",50, 15, 300, 40);
		lbl_Num_Mesa.setFont(new Font("Manche Condensed",Font.BOLD,(int)(15*VentanaPrincipal.getCordenadaY())));
		lbl_Num_Mesa.setForeground(Color.orange);
		panelDetalleFactura.add(lbl_Num_Mesa);
				
		lbl_Detalle_Factura = VentanaPrincipal.parametrosJlabel("Facturada el dia 05/05/2022 a las 14:08 h por pepe",50, 60, 300, 40);
		lbl_Detalle_Factura.setForeground(Color.black);
		panelDetalleFactura.add(lbl_Detalle_Factura);
		
		btn_Volver = VentanaPrincipal.parametrosJButton("Volver", 710, 20, 70, 20);
		panelDetalleFactura.add(btn_Volver);
		
		btn_Imprimir = VentanaPrincipal.parametrosJButton("Imprimir",50, 520, 120, 20);
		panelDetalleFactura.add(btn_Imprimir);

		lbl_Total = VentanaPrincipal.parametrosJlabel("Total:",500, 520, 120, 20);
		lbl_Total.setHorizontalAlignment(SwingConstants.RIGHT);
		panelDetalleFactura.add(lbl_Total);
		
		lbl_IVA = VentanaPrincipal.parametrosJlabel("Total + IVA(21%):",500, 540, 120, 20);
		lbl_IVA.setHorizontalAlignment(SwingConstants.RIGHT);
		panelDetalleFactura.add(lbl_IVA);

		lbl_Cantidad_Total = VentanaPrincipal.parametrosJlabel("0,00 €",630,520, 120, 20);
		lbl_Cantidad_Total.setHorizontalAlignment(SwingConstants.CENTER);
		panelDetalleFactura.add(lbl_Cantidad_Total);
		
		lbl_Cantidad_Total_IVA = VentanaPrincipal.parametrosJlabel("0,00 €",630, 540, 120, 20);
		lbl_Cantidad_Total_IVA.setHorizontalAlignment(SwingConstants.CENTER);
		panelDetalleFactura.add(lbl_Cantidad_Total_IVA);

		tabla = new JTable();
	    scroll = VentanaPrincipal.parametrosJScrollPane(50, 100, 700, 400);
	    panelDetalleFactura.add(scroll);	
		
	    panelDetalleFactura.setVisible(false);
	}

	
	public void establecerManejador() {			
		ControladorDetalleFactura controlador = new ControladorDetalleFactura(this);
		
		lbl_Detalle_Factura.addMouseListener(controlador);
		lbl_Cantidad_Total.addMouseListener(controlador);
		lbl_Cantidad_Total_IVA.addMouseListener(controlador);
		lbl_Num_Mesa.addMouseListener(controlador);
		btn_Volver.addActionListener(controlador);
		btn_Imprimir.addActionListener(controlador);


	}
	
	public static void listarDetalleFactura () {
		arrayDetalleFactura = new ArrayList<ModeloPRUEBA>();
        BbddVentas.listarClientes();						
        arrayDetalleFactura = BbddVentas.getArrayRecetas();	
		tabla = new JTable();
		scroll.setViewportView(tabla);
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.addColumn("COMIDA/BEBIDA");
        modelo.addColumn("PRECIO UNIDAD");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("PRECIO FINAL");
        
        Object filaDato[] = new Object[4];     
        for (int i = 0; i < arrayDetalleFactura.size(); i++) {
        	filaDato[0] = arrayDetalleFactura.get(i).getReceta();
        	filaDato[1] = arrayDetalleFactura.get(i).getEstado();
        	filaDato[2] = arrayDetalleFactura.get(i).getReceta();
        	filaDato[3] = arrayDetalleFactura.get(i).getEstado();
        	modelo.addRow(filaDato);
    	}
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
        tabla = VentanaPrincipal.formatoTabla(tabla);
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
