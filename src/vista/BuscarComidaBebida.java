package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorBuscarComidaBebida;
import modelo.BbddVentas;
import modelo.ModeloReceta;

public class BuscarComidaBebida extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7593766909336348960L;
	
	private static JPanel panelBuscarComidaBebida;
	private static JTextField caja_buscar;
	private static JButton btn_comidas_disponibles;
	private static JButton btn_bebidas_disponibles;
	private static JButton btn_listar_todo;
	private static JButton btn_volver;
	private static JButton btn_buscar;
	private static JButton btn_anadir;
	private static JButton btn_ver_receta;

	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;

	private static JTable tabla;
    private static JScrollPane scroll;

	private static ArrayList<ModeloReceta> arrayComidaBebida;

    
	public BuscarComidaBebida() {

		inicializarComponentes();
		establecerManejador();		
		
	}


	public void inicializarComponentes() {
		
		panelBuscarComidaBebida = new JPanel();
		btn_comidas_disponibles = new JButton("Comidas Disponibles");
		btn_bebidas_disponibles = new JButton("Bebidas Disponibles");
		btn_listar_todo = new JButton("Listar todo");
		btn_volver = new JButton("Volver");
		btn_buscar = new JButton("Buscar");
		caja_buscar = new JTextField();
		btn_anadir = new JButton("A\u00F1adir");
		btn_ver_receta = new JButton("Ver receta");
		tabla = new JTable();
		
		panelBuscarComidaBebida.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelBuscarComidaBebida.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		panelBuscarComidaBebida.setLayout(null);
		panelBuscarComidaBebida.setVisible(false);
		
		btn_comidas_disponibles.setBounds(28, 21, 145, 23);
		panelBuscarComidaBebida.add(btn_comidas_disponibles);

		btn_bebidas_disponibles.setBounds(183, 21, 131, 23);
		panelBuscarComidaBebida.add(btn_bebidas_disponibles);

		btn_listar_todo.setBounds(324, 21, 89, 23);
		panelBuscarComidaBebida.add(btn_listar_todo);

		btn_volver.setBounds(514, 21, 89, 23);
		panelBuscarComidaBebida.add(btn_volver);

		btn_buscar.setBounds(337, 55, 65, 23);
		panelBuscarComidaBebida.add(btn_buscar);

		caja_buscar.setBounds(28, 55, 287, 20);
		panelBuscarComidaBebida.add(caja_buscar);
		caja_buscar.setColumns(10);
		
		btn_anadir.setBounds(28, 222, 89, 23);
		panelBuscarComidaBebida.add(btn_anadir);

		btn_ver_receta.setBounds(461, 222, 89, 23);
		panelBuscarComidaBebida.add(btn_ver_receta);

	    
		scroll = new JScrollPane(tabla);	

	    scroll.setBounds(38, 89, 531, 122);
	    scroll.setViewportView(tabla);
		panelBuscarComidaBebida.add(scroll);

	}
	
	public void establecerManejador() {			
		ControladorBuscarComidaBebida controlador = new ControladorBuscarComidaBebida(this);
		
		tabla.addMouseListener(controlador);
		btn_comidas_disponibles.addActionListener(controlador);
		btn_bebidas_disponibles.addActionListener(controlador);
		btn_listar_todo.addActionListener(controlador);
		btn_volver.addActionListener(controlador);
		btn_buscar.addActionListener(controlador);
		btn_anadir.addActionListener(controlador);
		btn_ver_receta.addActionListener(controlador);
		
	
	}

	public static void pedidos () {
		arrayComidaBebida = new ArrayList<ModeloReceta>(); 		// <-- modificar el tipo de array al modelo objeto que corresponda
        BbddVentas.listarRecetas();							// <-- modificar el método para que llame a la sentencia SQL que corresponda y y cargue los datos
        arrayComidaBebida = BbddVentas.getArrayRecetas();		// <-- crear y modificar el metodo GET que trae los datos del array que corresponda
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.addColumn("COMIDA/BEBIDA");
        modelo.addColumn("PRECIO");
        modelo.addColumn("ESTADO");
        
        Object filaDato[] = new Object[3];     
        for (int i = 0; i < arrayComidaBebida.size(); i++) {
        	filaDato[0] = arrayComidaBebida.get(i).getReceta();		// <-- llamar el dato que corresponda del objeto modelo
        	filaDato[1] = arrayComidaBebida.get(i).getEstado();  	// <-- llamar el dato que corresponda del objeto modelo
        	filaDato[2] = arrayComidaBebida.get(i).getEstado(); 	// <-- llamar el dato que corresponda del objeto modelo
        	modelo.addRow(filaDato);
    	}
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
    }
	

	 public static int productoSeleccionado() throws NullPointerException {
		 int indiceSeleccionado = tabla.getSelectedRow();
		 return indiceSeleccionado;	
	 }


	public static JPanel getPanelBuscarComidaBebida() {
		return panelBuscarComidaBebida;
	}


	public static JButton getBtn_comidas_disponibles() {
		return btn_comidas_disponibles;
	}


	public static JButton getBtn_bebidas_disponibles() {
		return btn_bebidas_disponibles;
	}


	public static JButton getBtn_listar_todo() {
		return btn_listar_todo;
	}


	public static JButton getBtn_volver() {
		return btn_volver;
	}


	public static JButton getBtn_buscar() {
		return btn_buscar;
	}


	public static JButton getBtn_anadir() {
		return btn_anadir;
	}


	public static JButton getBtn_ver_receta() {
		return btn_ver_receta;
	}
	
	
	
	
	
}
