package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;
import controlador.ControladorListaFacturaciones;
import modelo.ModeloPRUEBA;
import modelo_bbdd.BbddVentas;


public class ListaFacturaciones extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7034925440369387336L;
	
	private static JPanel panelListaFacturaciones;

	private static JButton btn_Volver;
	private static JButton btn_Ver;
	private static JButton btn_Calcular_Ganancias;
	private static JTable tabla;
    private static JScrollPane scroll;
    
	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;

	private static ArrayList<ModeloPRUEBA> arrayListaFacturaciones;

	public ListaFacturaciones() {
		super();
		inicializarComponentes();
		establecerManejador();		
		listarFacturaciones();
	}

	public static void inicializarComponentes() {
		
		panelListaFacturaciones = VentanaPrincipal.parametrosPanel(800,600);
		
		btn_Volver = VentanaPrincipal.parametrosJButton("Volver", 710, 20, 70, 20);
		panelListaFacturaciones.add(btn_Volver);
				
		
		
		
		btn_Ver = VentanaPrincipal.parametrosJButton("Ver",200, 550, 120, 20);
		panelListaFacturaciones.add(btn_Ver);
		
		btn_Calcular_Ganancias = VentanaPrincipal.parametrosJButton("Calcular Ganancias",480, 550, 120, 20);
		panelListaFacturaciones.add(btn_Calcular_Ganancias);
				
		
		
		tabla = new JTable();
		scroll = VentanaPrincipal.parametrosJScrollPane(50, 100, 700, 400);
		scroll.setViewportView(tabla);	    
		panelListaFacturaciones.add(scroll);
	    
		panelListaFacturaciones.setVisible(false);
		
		
	}

	public void establecerManejador() {			
		ControladorListaFacturaciones controlador = new ControladorListaFacturaciones(this);
		
		tabla.addMouseListener(controlador);
		btn_Volver.addActionListener(controlador);
		btn_Ver.addActionListener(controlador);
		btn_Calcular_Ganancias.addActionListener(controlador);
		
	}
	
	public static void listarFacturaciones () {
		arrayListaFacturaciones = new ArrayList<ModeloPRUEBA>();			// <-- modificar el tipo de array al modelo objeto que corresponda
        BbddVentas.listarClientes();							// <-- modificar el método para que llame a la sentencia SQL que corresponda y y cargue los datos
        arrayListaFacturaciones = BbddVentas.getArrayRecetas();			// <-- crear y modificar el metodo GET que trae los datos del array que corresponda
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.addColumn("Nº");
        modelo.addColumn("FECHA-HORA");
        modelo.addColumn("GANANCIA");
        modelo.addColumn("USUARIO");
        
        Object filaDato[] = new Object[4];     
        for (int i = 0; i < arrayListaFacturaciones.size(); i++) {
        	filaDato[0] = arrayListaFacturaciones.get(i).getReceta();	// <-- llamar el dato que corresponda del objeto modelo
        	filaDato[1] = arrayListaFacturaciones.get(i).getEstado();  	// <-- llamar el dato que corresponda del objeto modelo
        	filaDato[2] = arrayListaFacturaciones.get(i).getEstado();  	// <-- llamar el dato que corresponda del objeto modelo
        	filaDato[3] = arrayListaFacturaciones.get(i).getEstado();  	// <-- llamar el dato que corresponda del objeto modelo
        	modelo.addRow(filaDato);
    	}
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
    }
	

	 public static int productoSeleccionado() throws NullPointerException {
		 int indiceSeleccionado = tabla.getSelectedRow();
		 return indiceSeleccionado;	
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
