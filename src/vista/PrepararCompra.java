package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controlador.ControladorPrepararCompra;
import modelo.ModeloPrepararCompra;


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
	private static JTable tabla;
    private static JScrollPane scroll;
    private static PrepararCompra prepararCompra;
	private static ArrayList<ModeloPrepararCompra> arrayPrepararCompra;

	private static String dato;


	public PrepararCompra() {
		super();
		inicializarComponentes();
		establecerManejador();		
	}

	
	public void inicializarComponentes() {
		arrayPrepararCompra = new ArrayList<ModeloPrepararCompra>();
		
		panelPrepararCompra = VentanaPrincipal.parametrosPanel(800,600);
		
		lblNewLabel = VentanaPrincipal.parametrosJlabel("LISTA DE LA COMPRA",150, 30, 300, 40);
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
	
	
	public static void establecerManejador() {			
		ControladorPrepararCompra controlador = new ControladorPrepararCompra(prepararCompra);
		
		btn_volver.addActionListener(controlador);
		btn_Guardar.addActionListener(controlador);
		btn_Imprimir.addActionListener(controlador);
		tabla.addMouseListener(controlador);
		btn_volver.addMouseListener(controlador);
		btn_Guardar.addMouseListener(controlador);
		btn_Imprimir.addMouseListener(controlador);
		
	}

	public static void listarProductos (ArrayList<ModeloPrepararCompra> arrayTabla) {

        arrayPrepararCompra = arrayTabla;	
        DefaultTableModel modelo =new DefaultTableModel(){
		    @Override
		    public boolean isCellEditable(int row, int column) {	
		       return false;
		    }
		}; 
		
        modelo.addColumn("PRODUCTOS");
        modelo.addColumn("CANTIDAD A COMPRAR");
        
        Object filaDato[] = new Object[2];     
        for (int i = 0; i < arrayPrepararCompra.size(); i++) {
        	filaDato[0] = arrayPrepararCompra.get(i).getProducto();
        	filaDato[1] = arrayPrepararCompra.get(i).getCantidadMaxima()-arrayPrepararCompra.get(i).getCantidadActual();
        	modelo.addRow(filaDato);
    	}
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
        tabla = VentanaPrincipal.formatoTabla(tabla);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(550);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(150);
        tabla.getColumnModel().getColumn(0).setResizable(false);
        tabla.getColumnModel().getColumn(1).setResizable(false);
    }
	
	/**
	 * Da el dato de la celda selecionada en la columna 0 
	 * @return
	 */
	 public static String datoSeleccionadoTabla() {	
		try {
			dato=String.valueOf(tabla.getModel().getValueAt(tabla.getSelectedRow(),0));
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(panelPrepararCompra, "Debes de selecionar algo de la lista antes");
		}
		return dato;		
	}
	 
	 public static int indiceSeleccionado() throws NullPointerException {
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


	public static JTable getTabla() {
		return tabla;
	}
	
}
