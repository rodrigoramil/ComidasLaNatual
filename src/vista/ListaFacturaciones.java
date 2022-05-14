package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.ArrayList;
import javax.swing.JButton;
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
		
		btn_Volver.addActionListener(controlador);
		btn_Ver.addActionListener(controlador);
		btn_Calcular_Ganancias.addActionListener(controlador);
	}
	
	public static void listarFacturaciones () {
		arrayListaFacturaciones = new ArrayList<ModeloPRUEBA>();
        BbddVentas.listarClientes();
        arrayListaFacturaciones = BbddVentas.getArrayRecetas();
		tabla = new JTable();
		scroll.setViewportView(tabla);
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.addColumn("Nº");
        modelo.addColumn("FECHA-HORA");
        modelo.addColumn("GANANCIA");
        modelo.addColumn("USUARIO");
        
        Object filaDato[] = new Object[4];     
        for (int i = 0; i < arrayListaFacturaciones.size(); i++) {
        	filaDato[0] = arrayListaFacturaciones.get(i).getReceta();
        	filaDato[1] = arrayListaFacturaciones.get(i).getEstado();
        	filaDato[2] = arrayListaFacturaciones.get(i).getEstado();
        	filaDato[3] = arrayListaFacturaciones.get(i).getEstado();
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
