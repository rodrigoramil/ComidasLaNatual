package vista;

import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import controlador.ControladorListaGastos;
import modelo.ModeloListaGastos;

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
    private static ListaGastos listaGastos;
	private static ArrayList<ModeloListaGastos> arrayListaGastos;

	private static String dato;

	public ListaGastos() {
		super();
		inicializarComponentes();		
		establecerManejador();
	}

	
	public void inicializarComponentes() {
		arrayListaGastos = new ArrayList<ModeloListaGastos>();
		
		panelListaGastos = VentanaPrincipal.parametrosPanel(800,600);
		
		btn_Volver = VentanaPrincipal.parametrosJButton("Volver", 710, 20, 70, 20);
		panelListaGastos.add(btn_Volver);
		
		btn_Ver = VentanaPrincipal.parametrosJButton("Ver",200, 550, 120, 20);
		panelListaGastos.add(btn_Ver);
		
		btn_Calcular_Gastos = VentanaPrincipal.parametrosJButton("Calcular gastos",480, 550, 120, 20);
		panelListaGastos.add(btn_Calcular_Gastos);

		tabla = new JTable();
		scroll = VentanaPrincipal.parametrosJScrollPane(50, 100, 700, 400);	
		scroll.setViewportView(tabla);
		panelListaGastos.add(scroll);	    
		panelListaGastos.setVisible(false);
		
				
	}
	
	public static void establecerManejador() {			
		ControladorListaGastos controlador = new ControladorListaGastos(listaGastos);
		btn_Volver.addActionListener(controlador);
		btn_Ver.addActionListener(controlador);
		btn_Calcular_Gastos.addActionListener(controlador);
		tabla.addMouseListener(controlador);
		btn_Volver.addMouseListener(controlador);
		btn_Ver.addMouseListener(controlador);
		btn_Calcular_Gastos.addMouseListener(controlador);
	}

	public static void listarGastos (ArrayList<ModeloListaGastos> arrayTabla) {
				
		arrayListaGastos = arrayTabla;
        DefaultTableModel modelo =new DefaultTableModel(){
		    @Override
		    public boolean isCellEditable(int row, int column) {	
		       return false;
		    }
		};
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
        tabla = VentanaPrincipal.formatoTabla(tabla);
        
        tabla.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(150);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(150);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(150);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(150);
        tabla.getColumnModel().getColumn(0).setResizable(false);
        tabla.getColumnModel().getColumn(1).setResizable(false);
        tabla.getColumnModel().getColumn(2).setResizable(false);
        tabla.getColumnModel().getColumn(3).setResizable(false);
        tabla.getColumnModel().getColumn(4).setResizable(false);
        
    }
	
	/**
	 * Da el dato de la celda selecionada en la columna 0 
	 * @return
	 */
	 public static String datoSeleccionadoTabla() {	
		try {
			dato=String.valueOf(tabla.getModel().getValueAt(tabla.getSelectedRow(),0));
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(panelListaGastos, "Debes de selecionar algo de la lista antes");
		}
		return dato;		
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
