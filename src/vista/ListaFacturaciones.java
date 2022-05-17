package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import controlador.ControladorListaFacturaciones;
import modelo.ModeloCalculoGanancias;


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
    private static ListaFacturaciones listaFacturaciones;
	private static ArrayList<ModeloCalculoGanancias> arrayListaFacturaciones;

	private static String dato;
	
	
	public ListaFacturaciones() {
		super();
		inicializarComponentes();
		establecerManejador();
	}

	public static void inicializarComponentes() {
			
		arrayListaFacturaciones = new ArrayList<ModeloCalculoGanancias>();	
		
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

	public static void establecerManejador() {			
		ControladorListaFacturaciones controlador = new ControladorListaFacturaciones(listaFacturaciones);		
		btn_Volver.addActionListener(controlador);
		btn_Ver.addActionListener(controlador);
		btn_Calcular_Ganancias.addActionListener(controlador);
		tabla.addMouseListener(controlador);
	}
	
	public static void listarFacturaciones (ArrayList<ModeloCalculoGanancias> arrayTabla) {

        arrayListaFacturaciones = arrayTabla;
        DefaultTableModel modelo =new DefaultTableModel(){
 		    @Override
 		    public boolean isCellEditable(int row, int column) {	
 		       return false;
 		    }
 		};
        modelo.addColumn("Nº");
        modelo.addColumn("FECHA-HORA");
        modelo.addColumn("GANANCIA");
        modelo.addColumn("USUARIO");
        
        Object filaDato[] = new Object[4];     
        for (int i = 0; i < arrayListaFacturaciones.size(); i++) {
        	filaDato[0] = arrayListaFacturaciones.get(i).getIdPedido();
        	filaDato[1] = arrayListaFacturaciones.get(i).getFechaPedido();
        	filaDato[2] = arrayListaFacturaciones.get(i).getGananciaPedido();
        	filaDato[3] = arrayListaFacturaciones.get(i).getUsuario();
        	modelo.addRow(filaDato);
    	}
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
        tabla = VentanaPrincipal.formatoTabla(tabla);
        
        tabla.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(0).setResizable(false);
        tabla.getColumnModel().getColumn(1).setResizable(false);
        tabla.getColumnModel().getColumn(2).setResizable(false);
        tabla.getColumnModel().getColumn(3).setResizable(false);
    }
	
	/**
	 * Da el dato de la celda selecionada en la columna 0 
	 * @return
	 */
	 public static String datoSeleccionadoTabla() {	
		try {
			dato=String.valueOf(tabla.getModel().getValueAt(tabla.getSelectedRow(),0));
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(panelListaFacturaciones, "Debes de selecionar algo de la lista antes");
		}
		return dato;		
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
