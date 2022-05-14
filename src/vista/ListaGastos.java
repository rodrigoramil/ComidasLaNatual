package vista;

import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import controlador.ControladorListaGastos;
import modelo.ModeloListaGastos;
import modelo_bbdd.BbddListaGastos;

public class ListaGastos extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6019873536027225543L;
	
	private static JPanel panelListaGastos;
	private static JButton btn_Volver;
	private static JButton btn_Ver;
	private static JButton btn_Calcular_Gastos;

	private static JTable tabla;
    private static JScrollPane scroll;

	private static ArrayList<ModeloListaGastos> arrayListaGastos;

	public ListaGastos() {
		super();
		inicializarComponentes();		
		establecerManejador();
		listarGastos();
	}

	
	public void inicializarComponentes() {
		
		
		panelListaGastos = VentanaPrincipal.parametrosPanel(800,600);
		
		btn_Volver = VentanaPrincipal.parametrosJButton("Volver", 710, 20, 70, 20);
		panelListaGastos.add(btn_Volver);
		
		btn_Ver = VentanaPrincipal.parametrosJButton("Ver",200, 550, 120, 20);
		panelListaGastos.add(btn_Ver);
		
		btn_Calcular_Gastos = VentanaPrincipal.parametrosJButton("Calcular gastos",480, 550, 120, 20);
		panelListaGastos.add(btn_Calcular_Gastos);

		tabla = new JTable();
		scroll = VentanaPrincipal.parametrosJScrollPane(50, 100, 700, 400);	    
		panelListaGastos.add(scroll);
	    
		panelListaGastos.setVisible(false);
		
				
	}
	
	public void establecerManejador() {			
		ControladorListaGastos controlador = new ControladorListaGastos(this);

		btn_Volver.addActionListener(controlador);
		btn_Ver.addActionListener(controlador);
		btn_Calcular_Gastos.addActionListener(controlador);
		
	}

	public static void listarGastos () {

		arrayListaGastos = new ArrayList<ModeloListaGastos>();
		BbddListaGastos.listarListaGastos();					
		arrayListaGastos = BbddListaGastos.getArrayListaGastos();
		tabla = new JTable();
		scroll.setViewportView(tabla);
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.addColumn("Nº");
        modelo.addColumn("FECHA");
        modelo.addColumn("COMPRA HECHA");
        modelo.addColumn("GASTO");
        modelo.addColumn("USUARIO");
        
        Object filaDato[] = new Object[5];     
        for (int i = 0; i < arrayListaGastos.size(); i++) {
        	filaDato[0] = arrayListaGastos.get(i).getIdCompraProductos();
        	filaDato[1] = arrayListaGastos.get(i).getFechaCompra();
        	if (arrayListaGastos.get(i).isCompraHecha()==true) {
        		filaDato[2] = "Si";
        	} else {
        		filaDato[2] = "No";
        	}
        	filaDato[3] = arrayListaGastos.get(i).getGastoCompra();
        	filaDato[4] = arrayListaGastos.get(i).getNombreUsuario();
        	modelo.addRow(filaDato);
    	}
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
    }
	

	 public static int indiceSeleccionado() throws NullPointerException {
		 int indiceSeleccionado = tabla.getSelectedRow();
		 return indiceSeleccionado;	
	 }
	
	public static JPanel getPanelListaGastos() {
		return panelListaGastos;
	}

	public static JButton getBtn_Volver() {
		return btn_Volver;
	}

	public static JButton getBtn_Ver() {
		return btn_Ver;
	}

	public static JButton getBtn_Calcular_Gastos() {
		return btn_Calcular_Gastos;
	}

	
}
