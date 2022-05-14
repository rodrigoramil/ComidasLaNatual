package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import controlador.ControladorProductosAlmacen;
import modelo.ModeloPRUEBA;
import modelo_bbdd.BbddVentas;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.util.ArrayList;

public class ProductosAlmacen extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6093653375171255892L;
	
	private static JPanel panelProductosAlmacen;
	private static JTextField caja_nombre_producto;	
	private static JButton btn_add_receta;;
	private static JButton btn_todos_productos;
	private static JButton btn_buscar;
	private static JButton btn_volver;
	private static JTable tabla;
    private static JScrollPane scroll;
    
	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;


private static ArrayList<ModeloPRUEBA> arrayProductos;
    
	public ProductosAlmacen() {
		super();
		inicializarComponentes();				
		establecerManejador();
		listarProductos();		
	}


	public void inicializarComponentes() {
		

		panelProductosAlmacen = VentanaPrincipal.parametrosPanel(800,600);
		
		btn_todos_productos = VentanaPrincipal.parametrosJButton("Todos los productos",50, 30, 150, 20);
		panelProductosAlmacen.add(btn_todos_productos);
		
		btn_volver = VentanaPrincipal.parametrosJButton("Volver", 710, 20, 70, 20);
		panelProductosAlmacen.add(btn_volver);
		
		
		caja_nombre_producto = VentanaPrincipal.parametrosJTextField(50, 65, 287, 20);
		panelProductosAlmacen.add(caja_nombre_producto);
		
		btn_buscar = VentanaPrincipal.parametrosJButton("Buscar",350, 65, 65, 20);
		panelProductosAlmacen.add(btn_buscar);
		
		btn_add_receta = VentanaPrincipal.parametrosJButton("Añadir a la receta",340, 520, 120, 20);
		panelProductosAlmacen.add(btn_add_receta);
		
		
		
		tabla = new JTable();
		scroll = VentanaPrincipal.parametrosJScrollPane(50, 100, 700, 400);
	    panelProductosAlmacen.add(scroll);
	    panelProductosAlmacen.setVisible(false);
		
	}
	
	public void establecerManejador() {		
		ControladorProductosAlmacen controlador = new ControladorProductosAlmacen(this);
		
		caja_nombre_producto.addActionListener(controlador);
		btn_add_receta.addActionListener(controlador);
		btn_todos_productos.addActionListener(controlador);
		btn_buscar.addActionListener(controlador);
		btn_volver.addActionListener(controlador);
//		tabla.addMouseListener(controlador);
			
		
	}

	
	public static void listarProductos () {
		arrayProductos = new ArrayList<ModeloPRUEBA>();
        BbddVentas.listarClientes();					
        arrayProductos = BbddVentas.getArrayRecetas();
		tabla = new JTable();
		scroll.setViewportView(tabla);
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.addColumn("PRODUCTOS");
        modelo.addColumn("STOCK ACTUAL");
        
        Object filaDato[] = new Object[2];     
        for (int i = 0; i < arrayProductos.size(); i++) {
        	filaDato[0] = arrayProductos.get(i).getReceta();
        	filaDato[1] = arrayProductos.get(i).getEstado();
        	modelo.addRow(filaDato);
    	}
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
    }
	

	 public static int productoSeleccionado() throws NullPointerException {
		 int indiceSeleccionado = tabla.getSelectedRow();
		 return indiceSeleccionado;	
	 }

	 
	public static JTextField getCaja_nombre_producto() {
		return caja_nombre_producto;
	}


	public static void setCaja_nombre_producto(JTextField caja_nombre_producto) {
		ProductosAlmacen.caja_nombre_producto = caja_nombre_producto;
	}


	public static JTable getTabla() {
		return tabla;
	}


	public static void setTabla(JTable tabla) {
		ProductosAlmacen.tabla = tabla;
	}


	public static JPanel getPanelProductosAlmacen() {
		return panelProductosAlmacen;
	}


	public static JButton getBtn_add_receta() {
		return btn_add_receta;
	}


	public static JButton getBtn_todos_productos() {
		return btn_todos_productos;
	}


	public static JButton getBtn_buscar() {
		return btn_buscar;
	}


	public static JButton getBtn_volver() {
		return btn_volver;
	}
	
	
	
	
	
	
}
