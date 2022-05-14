package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;


import java.awt.Color;
import java.awt.Font;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controlador.ControladorDetalleGasto;
import modelo.ModeloPRUEBA;
import modelo_bbdd.BbddVentas;


public class DetalleGasto extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5671748687027242086L;
	
	private static JPanel panelDetalleGasto;
	private static JLabel lbl_Num_Lista;
	private static JLabel lbl_detalle_lista;
	private static JLabel lbl_Total;
	private static JButton btn_Volver;
	private static JButton btn_Guardar;
	private static JButton btn_Imprimir;
	private static JTable tabla;
    private static JScrollPane scroll;
    
	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;

	private static ArrayList<ModeloPRUEBA> arrayDetalleGasto;
	

    
	public DetalleGasto() {
		super();
		inicializarComponentes();
		establecerManejador();		
		listarDetalleGasto();
	}

	public void inicializarComponentes() {
		
		panelDetalleGasto = VentanaPrincipal.parametrosPanel(800,600);
		
		lbl_Num_Lista = VentanaPrincipal.parametrosJlabel("Lista de la compra N\u00BA 5",50, 5, 300, 40);
		lbl_Num_Lista.setFont(new Font("Manche Condensed",Font.BOLD,(int)(20*VentanaPrincipal.getCordenadaY())));
		lbl_Num_Lista.setForeground(Color.orange);
		panelDetalleGasto.add(lbl_Num_Lista);
		
		lbl_detalle_lista = VentanaPrincipal.parametrosJlabel("Realizada el dia 05/05/2022 por Pepe",50, 60, 300, 40);
		lbl_detalle_lista.setForeground(Color.black);
		panelDetalleGasto.add(lbl_detalle_lista);
		
		btn_Volver = VentanaPrincipal.parametrosJButton("Volver", 710, 20, 70, 20);
		panelDetalleGasto.add(btn_Volver);
		
		lbl_Total = VentanaPrincipal.parametrosJlabel("Total: 143,1\u20AC",350, 500, 300, 40);
		lbl_Total.setFont(new Font("Manche Condensed",Font.BOLD,(int)(15*VentanaPrincipal.getCordenadaY())));
		panelDetalleGasto.add(lbl_Total);
		
		btn_Guardar = VentanaPrincipal.parametrosJButton("Guardar",200, 550, 120, 20);
		panelDetalleGasto.add(btn_Guardar);
		
		btn_Imprimir = VentanaPrincipal.parametrosJButton("Imprimir",480, 550, 120, 20);
		panelDetalleGasto.add(btn_Imprimir);
				
		
		
		tabla = new JTable();
		scroll = VentanaPrincipal.parametrosJScrollPane(50, 100, 700, 400);
		scroll.setViewportView(tabla);	    
		panelDetalleGasto.add(scroll);
	    
		panelDetalleGasto.setVisible(false);
	
	}
	
	public void establecerManejador() {			
		ControladorDetalleGasto controlador = new ControladorDetalleGasto(this);
		
		tabla.addMouseListener(controlador);
		lbl_Total.addMouseListener(controlador);
		lbl_detalle_lista.addMouseListener(controlador);
		lbl_Num_Lista.addMouseListener(controlador);
		btn_Volver.addActionListener(controlador);
		btn_Guardar.addActionListener(controlador);
		btn_Imprimir.addActionListener(controlador);

	}


	public static void listarDetalleGasto () {
		arrayDetalleGasto = new ArrayList<ModeloPRUEBA>();			// <-- modificar el tipo de array al modelo objeto que corresponda
        BbddVentas.listarClientes();								// <-- modificar el método para que llame a la sentencia SQL que corresponda y y cargue los datos
        arrayDetalleGasto = BbddVentas.getArrayRecetas();			// <-- crear y modificar el metodo GET que trae los datos del array que corresponda
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.addColumn("PRODUCTOS");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("GASTO");
        modelo.addColumn("PRECIO MEDIO");
        
        Object filaDato[] = new Object[4];     
        for (int i = 0; i < arrayDetalleGasto.size(); i++) {
        	filaDato[0] = arrayDetalleGasto.get(i).getReceta();		// <-- llamar el dato que corresponda del objeto modelo
        	filaDato[1] = arrayDetalleGasto.get(i).getEstado();  	// <-- llamar el dato que corresponda del objeto modelo
        	filaDato[2] = arrayDetalleGasto.get(i).getReceta();		// <-- llamar el dato que corresponda del objeto modelo
        	filaDato[3] = arrayDetalleGasto.get(i).getEstado();  	// <-- llamar el dato que corresponda del objeto modelo
        	modelo.addRow(filaDato);
    	}
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
    }
	

	 public static int productoSeleccionado() throws NullPointerException {			// <-- modificar el nombre del metodo
		 int indiceSeleccionado = tabla.getSelectedRow();
		 return indiceSeleccionado;	
	 }
	
	
	
	public static JPanel getPanelDetalleGasto() {
		return panelDetalleGasto;
	}

	public static JButton getBtn_Volver() {
		return btn_Volver;
	}

	public static JButton getBtn_Guardar() {
		return btn_Guardar;
	}

	public static JButton getBtn_Imprimir() {
		return btn_Imprimir;
	}

	public static JLabel getLbl_Total() {
		return lbl_Total;
	}

	public static void setLbl_Total(JLabel lbl_Total) {
		DetalleGasto.lbl_Total = lbl_Total;
	}

	public static JLabel getLbl_Num_Lista() {
		return lbl_Num_Lista;
	}

	public static void setLbl_Num_Lista(JLabel lbl_Num_Lista) {
		DetalleGasto.lbl_Num_Lista = lbl_Num_Lista;
	}

	public static JLabel getLbl_detalle_lista() {
		return lbl_detalle_lista;
	}

	public static void setLbl_detalle_lista(JLabel lbl_detalle_lista) {
		DetalleGasto.lbl_detalle_lista = lbl_detalle_lista;
	}

	
	
}
