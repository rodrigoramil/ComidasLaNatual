package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import controlador.ControladorReceta;
import modelo.ModeloReceta;
import modelo_bbdd.BbddReceta;

public class Receta extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8189623319602485236L;

	private static JPanel panelReceta;	
	private static JTextArea texto_elaboracion;
	private static JLabel lbl_ingredientes;
	private static JLabel lbl_elaboracion;
	private static JButton btn_nuevo_ingrediente;
	private static JButton btn_modificar_cantidad;
	private static JButton btn_borrar_ingrediente;
	private static JButton btn_guardar;
	private static JButton btn_volver;
	private static JTextField nombre_receta;
	private static JTable tabla;
    private static JScrollPane scrollReceta;
	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;

	private static ArrayList<ModeloReceta> arrayIngredientes;


	
	public Receta() {		
		super();
		inicializarComponentes();
		establecerManejador();		
		listarRecetas();
	}

	public void inicializarComponentes() {

		panelReceta = new JPanel();
		nombre_receta = new JTextField("Nombre de la receta");
	
		texto_elaboracion = new JTextArea();		
		lbl_ingredientes = new JLabel("Ingredientes");		
		lbl_elaboracion = new JLabel("Elaboraci\u00F3n");		
		btn_nuevo_ingrediente = new JButton("Nuevo ingrediente");		
		btn_modificar_cantidad = new JButton("Modificar cantidad");		
		btn_borrar_ingrediente = new JButton("Borrar ingrediente");		
		btn_guardar = new JButton("Guardar");		
		btn_volver = new JButton("Volver");
		tabla = new JTable();
		
		panelReceta.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelReceta.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		panelReceta.setLayout(null);
		panelReceta.setVisible(false);
		
		nombre_receta.setFont(new Font("Tahoma", Font.BOLD, 16));
		nombre_receta.setHorizontalAlignment(SwingConstants.CENTER);
		nombre_receta.setBounds(89, 0, 424, 35);
		panelReceta.add(nombre_receta);
		
		
		texto_elaboracion.setBounds(331, 51, 217, 268);
		panelReceta.add(texto_elaboracion);
		
		lbl_ingredientes.setBounds(89, 35, 61, 14);
		panelReceta.add(lbl_ingredientes);
		
		lbl_elaboracion.setBounds(409, 35, 61, 14);
		panelReceta.add(lbl_elaboracion);
		
		btn_nuevo_ingrediente.setBounds(10, 341, 123, 23);
		panelReceta.add(btn_nuevo_ingrediente);

		btn_modificar_cantidad.setBounds(159, 341, 123, 23);
		panelReceta.add(btn_modificar_cantidad);

		btn_borrar_ingrediente.setBounds(308, 341, 123, 23);
		panelReceta.add(btn_borrar_ingrediente);

		btn_guardar.setBounds(457, 341, 91, 39);
		panelReceta.add(btn_guardar);

		btn_volver.setBounds(473, 7, 89, 23);
		panelReceta.add(btn_volver);
		
		
	    scrollReceta = new JScrollPane(tabla);	
	    scrollReceta.setBounds(15, 51, 217, 268);
	    panelReceta.add(scrollReceta);	

	}
	

	private void establecerManejador() {
		ControladorReceta controlador = new ControladorReceta(this);
		
		texto_elaboracion.addMouseListener(controlador);
		btn_nuevo_ingrediente.addActionListener(controlador);
		btn_modificar_cantidad.addActionListener(controlador);
		btn_borrar_ingrediente.addActionListener(controlador);
		btn_guardar.addActionListener(controlador);
		btn_volver.addActionListener(controlador);
		nombre_receta.addActionListener(controlador);
		tabla.addMouseListener(controlador);
	}
	
	
	
	public static void listarRecetas () {
		arrayIngredientes = new ArrayList<ModeloReceta>();
		BbddReceta.listarRecetas();
		arrayIngredientes = BbddReceta.getArrayVentanaReceta();
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.addColumn("NOMBRE");
        modelo.addColumn("CANTIDAD");
        
        Object filaDato[] = new Object[2];     
        for (int i = 0; i < arrayIngredientes.size(); i++) {
        	filaDato[0] = arrayIngredientes.get(i).getIngrediente();
        	filaDato[1] = arrayIngredientes.get(i).getCantidad();  
        	modelo.addRow(filaDato);
    	}
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
    }


	 public static int recetaSeleccionado() throws NullPointerException {
		 int indiceSeleccionado = tabla.getSelectedRow();
		 return indiceSeleccionado;	
	 }
	
	
	
	/**
	 * Gets y Sets
	 * @return
	 */

	public static JPanel getPanelReceta() {
		return panelReceta;
	}

	public static void setPanelReceta(JPanel panelReceta) {
		Receta.panelReceta = panelReceta;
	}


	public static JTextArea getTexto_elaboracion() {
		return texto_elaboracion;
	}

	public static void setTexto_elaboracion(JTextArea texto_elaboracion) {
		Receta.texto_elaboracion = texto_elaboracion;
	}

	public static JButton getBtn_nuevo_ingrediente() {
		return btn_nuevo_ingrediente;
	}

	public static void setBtn_nuevo_ingrediente(JButton btn_nuevo_ingrediente) {
		Receta.btn_nuevo_ingrediente = btn_nuevo_ingrediente;
	}

	public static JButton getBtn_modificar_cantidad() {
		return btn_modificar_cantidad;
	}

	public static void setBtn_modificar_cantidad(JButton btn_modificar_cantidad) {
		Receta.btn_modificar_cantidad = btn_modificar_cantidad;
	}

	public static JButton getBtn_borrar_ingrediente() {
		return btn_borrar_ingrediente;
	}

	public static void setBtn_borrar_ingrediente(JButton btn_borrar_ingrediente) {
		Receta.btn_borrar_ingrediente = btn_borrar_ingrediente;
	}

	public static JButton getBtn_guardar() {
		return btn_guardar;
	}

	public static void setBtn_guardar(JButton btn_guardar) {
		Receta.btn_guardar = btn_guardar;
	}

	public static JButton getBtn_volver() {
		return btn_volver;
	}

	public static void setBtn_volver(JButton btn_volver) {
		Receta.btn_volver = btn_volver;
	}

	public static JTextField getNombre_receta() {
		return nombre_receta;
	}

	public static void setNombre_receta(JTextField nombre_receta) {
		Receta.nombre_receta = nombre_receta;
	}

	
	
	
	
	

}
