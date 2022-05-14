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

import controlador.ControladorPrepararCompra;
import modelo.BbddVentas;
import modelo.ModeloReceta;


public class PrepararCompra extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5924949977958580722L;

	private static JPanel panelPrepararCompra;

	private static JLabel lblNewLabel;
	private static JButton btn_volver;
	private static JButton btn_Guardar;
	private static JButton btn_Imprimir;
	
	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;
	private static JTable tabla;
    private static JScrollPane scroll;

	private static ArrayList<ModeloReceta> arrayProductos;


	public PrepararCompra() {
		super();
		inicializarComponentes();
		establecerManejador();		
		listarProductos();
	}

	
	public void inicializarComponentes() {
		
		panelPrepararCompra = VentanaPrincipal.parametrosPanel(800,600);
		
		lblNewLabel = VentanaPrincipal.parametrosJlabel("Lista de la compra N\u00BAx",150, 30, 300, 40);
		lblNewLabel.setFont(new Font("Manche Condensed",Font.BOLD,(int)(15*VentanaPrincipal.getCordenadaY())));
		lblNewLabel.setForeground(Color.orange);
		panelPrepararCompra.add(lblNewLabel);
		
		
		btn_volver = VentanaPrincipal.parametrosJButton("Volver", 710, 20, 70, 20);
		panelPrepararCompra.add(btn_volver);
		
		btn_Guardar = VentanaPrincipal.parametrosJButton("Guardar",200, 550, 120, 20);
		panelPrepararCompra.add(btn_Guardar);
		
		btn_Imprimir = VentanaPrincipal.parametrosJButton("Imprimir",480, 550, 120, 20);
		panelPrepararCompra.add(btn_Imprimir);
				
		
		
		tabla = new JTable();
		scroll = VentanaPrincipal.parametrosJScrollPane(50, 100, 700, 400);
		scroll.setViewportView(tabla);	    
		panelPrepararCompra.add(scroll);
	    
		panelPrepararCompra.setVisible(false);
	    
	    
	}
	
	
	public void establecerManejador() {			
		ControladorPrepararCompra controlador = new ControladorPrepararCompra(this);
		
		tabla.addMouseListener(controlador);
		btn_volver.addActionListener(controlador);
		btn_Guardar.addActionListener(controlador);
		btn_Imprimir.addActionListener(controlador);

		
	}

	public static void listarProductos () {
		arrayProductos = new ArrayList<ModeloReceta>();			// <-- modificar el tipo de array al modelo objeto que corresponda
        BbddVentas.listarClientes();							// <-- modificar el método para que llame a la sentencia SQL que corresponda y y cargue los datos
        arrayProductos = BbddVentas.getArrayRecetas();			// <-- crear y modificar el metodo GET que trae los datos del array que corresponda
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.addColumn("PRODUCTOS");
        modelo.addColumn("CANTIDAD A COMPRAR");
        
        Object filaDato[] = new Object[2];     
        for (int i = 0; i < arrayProductos.size(); i++) {
        	filaDato[0] = arrayProductos.get(i).getReceta();	// <-- llamar el dato que corresponda del objeto modelo
        	filaDato[1] = arrayProductos.get(i).getEstado();  	// <-- llamar el dato que corresponda del objeto modelo
        	modelo.addRow(filaDato);
    	}
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
    }
	

	 public static int productoSeleccionado() throws NullPointerException {			// <-- modificar el nombre del metodo
		 int indiceSeleccionado = tabla.getSelectedRow();
		 return indiceSeleccionado;	
	 }
	
	
	
	
	public static JPanel getPanelPrepararCompra() {
		return panelPrepararCompra;
	}

	public static JButton getBtn_volver() {
		return btn_volver;
	}

	public static JButton getBtn_Guardar() {
		return btn_Guardar;
	}

	public static JButton getBtn_Imprimir() {
		return btn_Imprimir;
	}


	
	
	
	
	
	
}
