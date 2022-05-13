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
import modelo.ModeloReceta;

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

	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;
	
//	private static JList listaPedidos;
	private static JTable tabla;
    private static JScrollPane scroll;

	private static ArrayList<ModeloReceta> arrayPedidos;
    
    
    public Pedido() {
		super();
		inicializarComponentes();
		establecerManejador();
		pedidos();
	}

	public void inicializarComponentes() {
		
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
		arrayPedidos = new ArrayList<ModeloReceta>();
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
