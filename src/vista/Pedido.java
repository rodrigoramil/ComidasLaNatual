package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import controlador.ControladorPedido;
import modelo.BbddVentas;
import modelo.ModeloPRUEBA;


import java.awt.Color;
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

	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;
	
//	private static JList listaPedidos;
	private static JTable tabla;
    private static JScrollPane scroll;

	private static ArrayList<ModeloPRUEBA> arrayPedidos;
    
    
    public Pedido() {
		super();
		inicializarComponentes();
		establecerManejador();
		pedidos();
	}

	public void inicializarComponentes() {
		
		panelPedido = new JPanel();
		lbl_Num_Mesa = new JLabel("Mesa 1");
		btn_Guardar = new JButton("Guardar");
		btn_Volver = new JButton("Volver");
		btn_Modificar = new JButton("Modificar cantidad");
		btn_Nuevo = new JButton("Nuevo");
		btn_Eliminar = new JButton("Eliminar");
		btn_Facturar = new JButton("Facturar");	
		tabla = new JTable();
		
		panelPedido.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelPedido.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		panelPedido.setLayout(null);
		panelPedido.setVisible(false);
		
		lbl_Num_Mesa.setBounds(26, 35, 46, 14);
		panelPedido.add(lbl_Num_Mesa);

		btn_Guardar.setBounds(220, 23, 89, 31);
		panelPedido.add(btn_Guardar);

		btn_Volver.setBounds(335, 11, 89, 23);
		panelPedido.add(btn_Volver);
	
		btn_Modificar.setBounds(99, 213, 119, 23);
		panelPedido.add(btn_Modificar);

		btn_Nuevo.setBounds(26, 213, 63, 23);
		panelPedido.add(btn_Nuevo);

		btn_Eliminar.setBounds(228, 213, 89, 23);
		panelPedido.add(btn_Eliminar);

		btn_Facturar.setBackground(Color.ORANGE);
		btn_Facturar.setBounds(335, 227, 89, 23);
		panelPedido.add(btn_Facturar);

		scroll = new JScrollPane(tabla);
//	    scrollPedidos = new JScrollPane(listaPedidos);	
		scroll.setBounds(26, 74, 398, 112);
//	    scrollPedidos.setViewportView(listaPedidos);
	    panelPedido.add(scroll);	
  
	}
	
	
	public void establecerManejador() {			
		ControladorPedido controlador = new ControladorPedido(this);
		
		btn_Guardar.addActionListener(controlador);
		btn_Volver.addActionListener(controlador);
		btn_Modificar.addActionListener(controlador);
		btn_Nuevo.addActionListener(controlador);
		btn_Eliminar.addActionListener(controlador);
		btn_Facturar.addActionListener(controlador);
		tabla.addMouseListener(controlador);	

		
	}

	public static void pedidos () {
		arrayPedidos = new ArrayList<ModeloPRUEBA>();
        BbddVentas.listarClientes();
        arrayPedidos = BbddVentas.getArrayRecetas();
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.addColumn("COMIDA/BEBIDA");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("PRECIO");
        
        Object filaDato[] = new Object[3];     
        for (int i = 0; i < arrayPedidos.size(); i++) {
        	filaDato[0] = arrayPedidos.get(i).getReceta();
        	filaDato[1] = arrayPedidos.get(i).getEstado();
        	filaDato[2] = arrayPedidos.get(i).getEstado(); 
        	modelo.addRow(filaDato);
    	}
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
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
