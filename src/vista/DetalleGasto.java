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
import controlador.ControladorDetalleGasto;
import modelo.ModeloListasCompra;


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
    private static DetalleGasto detalleGasto;
	private static String dato;
	private static ArrayList<ModeloListasCompra> arrayDetalleGasto;

	public DetalleGasto() {
		super();
		inicializarComponentes();
		establecerManejador();		
	}

	public void inicializarComponentes() {
		arrayDetalleGasto = new ArrayList<ModeloListasCompra>();
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
	
	public static void establecerManejador() {			
		ControladorDetalleGasto controlador = new ControladorDetalleGasto(detalleGasto);

		lbl_Total.addMouseListener(controlador);
		lbl_detalle_lista.addMouseListener(controlador);
		lbl_Num_Lista.addMouseListener(controlador);
		btn_Volver.addActionListener(controlador);
		btn_Guardar.addActionListener(controlador);
		btn_Imprimir.addActionListener(controlador);
		tabla.addMouseListener(controlador);
		btn_Volver.addMouseListener(controlador);
		btn_Guardar.addMouseListener(controlador);
		btn_Imprimir.addMouseListener(controlador);
	}


	public static void listarDetalleGasto (ArrayList<ModeloListasCompra> arrayTabla) {
		arrayDetalleGasto = arrayTabla;
        DefaultTableModel modelo =new DefaultTableModel(){
		    @Override
		    public boolean isCellEditable(int row, int column) {	
		       return false;
		    }
		};
        modelo.addColumn("PRODUCTOS");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("GASTO");
        modelo.addColumn("PRECIO MEDIO");
        
        Object filaDato[] = new Object[4];     
        for (int i = 0; i < arrayDetalleGasto.size(); i++) {
        	filaDato[0] = arrayDetalleGasto.get(i).getIdCompraProductos();
        	filaDato[1] = arrayDetalleGasto.get(i).getCompraHecha();
        	filaDato[2] = arrayDetalleGasto.get(i).getCompraHecha();
        	filaDato[3] = arrayDetalleGasto.get(i).getCompraHecha();
        	modelo.addRow(filaDato);
    	}
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
        tabla = VentanaPrincipal.formatoTabla(tabla);
        
        tabla.getColumnModel().getColumn(0).setPreferredWidth(550);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(50);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(50);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(50);
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
			JOptionPane.showMessageDialog(panelDetalleGasto, "Debes de selecionar algo de la lista antes");
		}
		return dato;		
	}

	 public static int detalleSeleccionado() throws NullPointerException {	
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

	public static JTable getTabla() {
		return tabla;
	}

	
}
