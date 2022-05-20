package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controlador.ControladorAlmacen;
import modelo.ModeloAlmacen;


public class Almacen extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2638510831684047682L;
	private static JPanel panelAlmacen;
	private static JTextField textField;
	private static JButton btn_todos_los_Productos;
	private static JButton btn_Buscar;
	private static JButton btn_Volver;
	private static JButton btn_Realizar_Lista_Compra;
	private static JButton btn_Ver_Listas_Compras;
	private static JButton btn_Modificar;
	private static JButton btn_Nuevo;
	private static JButton btn_Eliminar;
	private static JTable tabla;
    private static JScrollPane scroll;
	private static ArrayList<ModeloAlmacen> arrayAlmacen;
	private static Almacen almacen;
	private static String dato;
	
	public Almacen() {
		
		super();
		inicializarComponentes();		
		establecerManejador();		
	}

	public void inicializarComponentes() {
		arrayAlmacen = new ArrayList<ModeloAlmacen>();
		
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
		
		btn_Ver_Listas_Compras = VentanaPrincipal.parametrosJButton("Ver listas de la compra",50, 550, 240, 20);
		panelAlmacen.add(btn_Ver_Listas_Compras);
		
		btn_Nuevo = VentanaPrincipal.parametrosJButton("Nuevo",330, 530, 120, 20);
		panelAlmacen.add(btn_Nuevo);
		
		btn_Modificar = VentanaPrincipal.parametrosJButton("Modificar",480, 530, 120, 20);
		panelAlmacen.add(btn_Modificar);
		
		btn_Eliminar = VentanaPrincipal.parametrosJButton("Eliminar",630, 530, 120, 20);
		panelAlmacen.add(btn_Eliminar);
		
		tabla = new JTable();
		scroll = VentanaPrincipal.parametrosJScrollPane(50, 100, 700, 400);
		scroll.setViewportView(tabla);
	    panelAlmacen.add(scroll);
	    tabla.setVisible(true);
	    scroll.setVisible(true);
	    panelAlmacen.setVisible(false);

	}
	
	public static void establecerManejador() {	
		
		ControladorAlmacen controlador = new ControladorAlmacen(almacen);	
		
		textField.addActionListener(controlador);		
		btn_todos_los_Productos.addActionListener(controlador);
		btn_Buscar.addActionListener(controlador);
		btn_Volver.addActionListener(controlador);
		btn_Realizar_Lista_Compra.addActionListener(controlador);
		btn_Ver_Listas_Compras.addActionListener(controlador);
		btn_Modificar.addActionListener(controlador);
		btn_Eliminar.addActionListener(controlador);
		btn_Nuevo.addActionListener(controlador);
		
		tabla.addMouseListener(controlador);
		btn_todos_los_Productos.addMouseListener(controlador);
		btn_Buscar.addMouseListener(controlador);
		btn_Volver.addMouseListener(controlador);
		btn_Realizar_Lista_Compra.addMouseListener(controlador);
		btn_Ver_Listas_Compras.addMouseListener(controlador);
		btn_Modificar.addMouseListener(controlador);
		btn_Eliminar.addMouseListener(controlador);
		btn_Nuevo.addMouseListener(controlador);
		
	}

	

	public static void listarProductos (ArrayList<ModeloAlmacen> arrayTabla) {

        arrayAlmacen = arrayTabla;	
        DefaultTableModel modelo =new DefaultTableModel(){
		    @Override
		    public boolean isCellEditable(int row, int column) {	
		       return false;
		    }
		};
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
			JOptionPane.showMessageDialog(panelAlmacen, "Debes de selecionar algo de la lista antes");
		}
		return dato;		
	}
	 
	 public static int indiceSeleccionado() throws NullPointerException {
		 int indiceSeleccionado = tabla.getSelectedRow();
		 return indiceSeleccionado;	
	 }

	/**
	 * Gets y Sets
	 * @return
	 */

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

	public static JTable getTabla() {
		return tabla;
	}

	public static JButton getBtn_Eliminar() {
		return btn_Eliminar;
	}

	
}
