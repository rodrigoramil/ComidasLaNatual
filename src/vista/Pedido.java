package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import controlador.ControladorPedido;
import modelo.ModeloPedido;
import modelo.ModeloReceta;
import modelo_bbdd.BbddVentas;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

public class Pedido extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1676364911491454052L;
	
	private static JPanel panelPedido;
	private static JLabel lbl_Num_Mesa;
	private static JButton btn_Guardar;
	private static JButton btn_Volver;
	private static JButton btn_Modificar;
	private static JButton btn_Nuevo;
	private static JButton btn_Eliminar;
	private static JButton btn_Facturar;
	private static JTable tabla;
    private static JScrollPane scroll;
	private static Pedido pedido;
	private static ArrayList<ModeloPedido> arrayPedidos;
	private static String dato;
    
    
    public Pedido() {
		super();
		inicializarComponentes();
		establecerManejador();

	}

	public void inicializarComponentes() {
		
		arrayPedidos = new ArrayList<ModeloPedido>();
		
		panelPedido = VentanaPrincipal.parametrosPanel(800,600);
		
		lbl_Num_Mesa = VentanaPrincipal.parametrosJlabel("Mesa 1",150, 30, 300, 40);
		lbl_Num_Mesa.setFont(new Font("Manche Condensed",Font.BOLD,(int)(15*VentanaPrincipal.getCordenadaY())));
		lbl_Num_Mesa.setForeground(Color.orange);
		panelPedido.add(lbl_Num_Mesa);
		
		btn_Guardar = VentanaPrincipal.parametrosJButton("Guardar",550, 40, 120,30);
		panelPedido.add(btn_Guardar);
		
		
		btn_Volver = VentanaPrincipal.parametrosJButton("Volver", 710, 20, 70, 20);
		panelPedido.add(btn_Volver);
		
		btn_Nuevo = VentanaPrincipal.parametrosJButton("Nuevo",50, 520, 120, 20);
		panelPedido.add(btn_Nuevo);
		
		btn_Modificar = VentanaPrincipal.parametrosJButton("Modificar cantidad",200, 520, 120, 20);
		panelPedido.add(btn_Modificar);
				
		
		btn_Eliminar = VentanaPrincipal.parametrosJButton("Eliminar",350, 520, 120, 20);
		panelPedido.add(btn_Eliminar);
		
		btn_Facturar = VentanaPrincipal.parametrosJButton("Facturar",600, 550, 120, 20);
		btn_Facturar.setBackground(Color.ORANGE);
		panelPedido.add(btn_Facturar);
		
		tabla = new JTable();
		scroll = VentanaPrincipal.parametrosJScrollPane(50, 100, 700, 400);
		scroll.setViewportView(tabla);
	    panelPedido.add(scroll);	    
	    panelPedido.setVisible(false);
  
	}
	
	
	public static void establecerManejador() {			
		ControladorPedido controlador = new ControladorPedido(pedido);
		
		btn_Guardar.addActionListener(controlador);
		btn_Volver.addActionListener(controlador);
		btn_Modificar.addActionListener(controlador);
		btn_Nuevo.addActionListener(controlador);
		btn_Eliminar.addActionListener(controlador);
		btn_Facturar.addActionListener(controlador);
		tabla.addMouseListener(controlador);
		
	}

	public static void listarPedido (ArrayList<ModeloPedido> arrayTabla) {
		
        arrayPedidos = arrayTabla;
        DefaultTableModel modelo =new DefaultTableModel(){
		    @Override
		    public boolean isCellEditable(int row, int column) {	
		       return false;
		    }
		}; 
        modelo.addColumn("COMIDA/BEBIDA");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("PRECIO");
        
        Object filaDato[] = new Object[3];     
        for (int i = 0; i < arrayPedidos.size(); i++) {
        	filaDato[0] = arrayPedidos.get(i).getNombreReceta();
        	filaDato[1] = arrayPedidos.get(i).getCantidadRecetaVenta();
        	filaDato[2] = arrayPedidos.get(i).getPrecioVenta(); 
        	modelo.addRow(filaDato);
    	}
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
        tabla = VentanaPrincipal.formatoTabla(tabla);
        
        tabla.getColumnModel().getColumn(0).setPreferredWidth(550);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(50);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(0).setResizable(false);
        tabla.getColumnModel().getColumn(1).setResizable(false);
        tabla.getColumnModel().getColumn(2).setResizable(false);
    }
	
	/**
	 * Da el dato de la celda selecionada en la columna 0 
	 * @return
	 */
	 public static String datoSeleccionadoTabla() {	
		try {
			dato=String.valueOf(tabla.getModel().getValueAt(tabla.getSelectedRow(),0));
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(panelPedido, "Debes de selecionar algo de la lista antes");
		}
		return dato;		
	}

	 public static int productoSeleccionado() throws NullPointerException {
		 int indiceSeleccionado = tabla.getSelectedRow();
		 return indiceSeleccionado;	
	 }
 
	 
	public static JPanel getPanelPedido() {
		return panelPedido;
	}

	public static JButton getBtn_Guardar() {
		return btn_Guardar;
	}

	public static JButton getBtn_Volver() {
		return btn_Volver;
	}

	public static JButton getBtn_Modificar() {
		return btn_Modificar;
	}

	public static JButton getBtn_Nuevo() {
		return btn_Nuevo;
	}

	public static JButton getBtn_Eliminar() {
		return btn_Eliminar;
	}

	public static JButton getBtn_Facturar() {
		return btn_Facturar;
	}

	public static JLabel getLbl_Num_Mesa() {
		return lbl_Num_Mesa;
	}

	public static void setLbl_Num_Mesa(JLabel lbl_Num_Mesa) {
		Pedido.lbl_Num_Mesa = lbl_Num_Mesa;
	}
	

	
}
