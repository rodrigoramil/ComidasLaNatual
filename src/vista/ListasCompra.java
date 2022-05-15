package vista;

import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controlador.ControladorListasCompra;
import modelo.ModeloListasCompra;
import modelo_bbdd.BbddListasCompra;


public class ListasCompra extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4874909740114522589L;

	private static JPanel panelListasCompra;	
	private static JButton btn_Volver;
	private static JButton btn_Ver;	
	private static JTable tabla;
    private static JScrollPane scroll;

	private static ArrayList<ModeloListasCompra> arrayListasCompra;

	public ListasCompra() {
		super();
		inicializarComponentes();
		establecerManejador();
		listarCompras();
	}

	public void inicializarComponentes() {

		panelListasCompra = VentanaPrincipal.parametrosPanel(800,600);

		btn_Volver = VentanaPrincipal.parametrosJButton("Volver", 710, 20, 70, 20);
		panelListasCompra.add(btn_Volver);
		
		btn_Ver = VentanaPrincipal.parametrosJButton("Ver",340, 550, 120, 20);
		panelListasCompra.add(btn_Ver);

		tabla = new JTable();
		scroll = VentanaPrincipal.parametrosJScrollPane(50, 100, 700, 400);
	    
		panelListasCompra.add(scroll);
		panelListasCompra.setVisible(false);
		
	}
	
	public void establecerManejador() {			
		ControladorListasCompra controlador = new ControladorListasCompra(this);
		
		btn_Volver.addActionListener(controlador);
		btn_Ver.addActionListener(controlador);
		
	}


	public static void listarCompras () {
		arrayListasCompra = new ArrayList<ModeloListasCompra>();
        BbddListasCompra.listarListasCompra();	
        arrayListasCompra = BbddListasCompra.getArrayListasCompra();
		tabla = new JTable();
		scroll.setViewportView(tabla);
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.addColumn("Nº");
        modelo.addColumn("FECHA");
        modelo.addColumn("COMPRA HECHA");
        
        Object filaDato[] = new Object[3];     
        for (int i = 0; i < arrayListasCompra.size(); i++) {
        	filaDato[0] = arrayListasCompra.get(i).getIdCompraProductos();
        	filaDato[1] = arrayListasCompra.get(i).getFechaCompra();   	
        	if (arrayListasCompra.get(i).getCompraHecha()==true) {
        		filaDato[2] = "Si";
        	} else {
        		filaDato[2] = "No";
        	}
        	modelo.addRow(filaDato);
    	}
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
        tabla = VentanaPrincipal.formatoTabla(tabla);
    }
	

	 public static int indiceSeleccionado() throws NullPointerException {
		 int indiceSeleccionado = tabla.getSelectedRow();
		 return indiceSeleccionado;	
	 }

	public static JPanel getPanelListasCompra() {
		return panelListasCompra;
	}


	public static JButton getBtn_Volver() {
		return btn_Volver;
	}


	public static JButton getBtn_Ver() {
		return btn_Ver;
	}
	
	
	
	
}
