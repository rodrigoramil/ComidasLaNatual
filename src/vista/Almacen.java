package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controlador.ControladorAlmacen;
import modelo.ModeloAlmacen;
import modelo_bbdd.BbddAlmacen;


public class Almacen extends JPanel {

	private static JPanel panelAlmacen;
	private static JTextField textField;
	private static JButton btn_todos_los_Productos;
	private static JButton btn_Buscar;
	private static JButton btn_Volver;
	private static JButton btn_Realizar_Lista_Compra;
	private static JButton btn_Ver_Listas_Compras;
	private static JButton btn_Modificar;
	private static JButton btn_Nuevo;
	private static JTable tabla;
    private static JScrollPane scroll;
	private static ArrayList<ModeloAlmacen> arrayAlmacen;
    
	public Almacen() {
		
		super();
		inicializarComponentes();		
		establecerManejador();		
		listarProductos();
	}

	public void inicializarComponentes() {
		
		panelAlmacen = VentanaPrincipal.parametrosPanel(800,600);

		btn_todos_los_Productos = VentanaPrincipal.parametrosJButton("Todos los productos",50, 30, 150, 20);
		panelAlmacen.add(btn_todos_los_Productos);
		
		btn_Volver = VentanaPrincipal.parametrosJButton("Volver", 710, 20, 70, 20);
		panelAlmacen.add(btn_Volver);

		textField = VentanaPrincipal.parametrosJTextField(50, 65, 287, 20);
		panelAlmacen.add(textField);
		
		btn_Buscar = VentanaPrincipal.parametrosJButton("Buscar",350, 65, 65, 20);
		panelAlmacen.add(btn_Buscar);
		
		btn_Realizar_Lista_Compra = VentanaPrincipal.parametrosJButton("Realizar lista de la compra",50, 520, 240, 20);
		panelAlmacen.add(btn_Realizar_Lista_Compra);
		
		btn_Ver_Listas_Compras = VentanaPrincipal.parametrosJButton("Ver listas de la compra",320, 520, 240, 20);
		panelAlmacen.add(btn_Ver_Listas_Compras);
		
		btn_Modificar = VentanaPrincipal.parametrosJButton("Modificar",630, 520, 120, 20);
		panelAlmacen.add(btn_Modificar);
		
		btn_Nuevo = VentanaPrincipal.parametrosJButton("Nuevo",630, 560, 120, 20);
		panelAlmacen.add(btn_Nuevo);
		
		tabla = new JTable();
		scroll = VentanaPrincipal.parametrosJScrollPane(50, 100, 700, 400);
	    panelAlmacen.add(scroll);

	    panelAlmacen.setVisible(false);

	}
	
	public void establecerManejador() {	
		
		ControladorAlmacen controlador = new ControladorAlmacen(this);	
		
		textField.addActionListener(controlador);		
		btn_todos_los_Productos.addActionListener(controlador);
		btn_Buscar.addActionListener(controlador);
		btn_Volver.addActionListener(controlador);
		btn_Realizar_Lista_Compra.addActionListener(controlador);
		btn_Ver_Listas_Compras.addActionListener(controlador);
		btn_Modificar.addActionListener(controlador);
		btn_Nuevo.addActionListener(controlador);
	
	}

	

	public static void listarProductos () {
		arrayAlmacen = new ArrayList<ModeloAlmacen>();
        BbddAlmacen.listarProductosAlmacen();
        arrayAlmacen = BbddAlmacen.getArrayAlmacen();	
		tabla = new JTable();
		scroll.setViewportView(tabla);
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.addColumn("PRODUCTOS");
        modelo.addColumn("ACTUAL");
        modelo.addColumn("MÍNIMO");
        modelo.addColumn("MAXIMO");        
        Object filaDato[] = new Object[4];     
        for (int i = 0; i < arrayAlmacen.size(); i++) {
        	filaDato[0] = arrayAlmacen.get(i).getNombreProducto();
        	filaDato[1] = arrayAlmacen.get(i).getCantidadActual();
        	filaDato[2] = arrayAlmacen.get(i).getCantidadMinima();
        	filaDato[3] = arrayAlmacen.get(i).getCantidadMaxima();        	
        	modelo.addRow(filaDato);
    	}
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
    }
	
	 public static int indiceSeleccionado() throws NullPointerException {
		 int indiceSeleccionado = tabla.getSelectedRow();
		 return indiceSeleccionado;	
	 }

	 
	public static JTextField getTextField() {
		return textField;
	}

	public static void setTextField(JTextField textField) {
		Almacen.textField = textField;
	}

	public static JPanel getPanelAlmacen() {
		return panelAlmacen;
	}

	public static JButton getBtn_todos_los_Productos() {
		return btn_todos_los_Productos;
	}

	public static JButton getBtn_Buscar() {
		return btn_Buscar;
	}

	public static JButton getBtn_Volver() {
		return btn_Volver;
	}

	public static JButton getBtn_Realizar_Lista_Compra() {
		return btn_Realizar_Lista_Compra;
	}

	public static JButton getBtn_Ver_Listas_Compras() {
		return btn_Ver_Listas_Compras;
	}

	public static JButton getBtn_Modificar() {
		return btn_Modificar;
	}

	public static JButton getBtn_Nuevo() {
		return btn_Nuevo;
	}

	
	
	
	
}
