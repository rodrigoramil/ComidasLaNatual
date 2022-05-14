package vista;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import controlador.ControladorRecetario;
import modelo.ModeloRecetario;
import modelo_bbdd.BbddRecetario;


public class Recetario extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3846625552235103376L;
	
	private static JPanel panelRecetario;
	private static JTextField caja_nombre_receta;
	private static JButton btn_cambiar_estado;
	private static JButton btn_modificar_receta;
	private static JButton btn_nueva_receta;
	private static JButton btn_ver_recetas;
	private static JButton btn_listadoRecetas;
	private static JButton btn_buscar;
	private static JButton btn_volver;
	private static JScrollPane scroll;    
//    private static ArrayList<ModeloReceta> arrayRecetas;
    private static JTable tabla;
    
	private int ancho = 800;
	private int alto = 600;
	private int posicionPanel_x = 100;
	private int posicionPanel_y = 50;


//	private static JList listaRecetas;
//    private static JScrollPane scroll;
    
    private static ArrayList<ModeloRecetario> arrayRecetas;
//    private static DefaultListModel modeloListaReceta;
    
    
	//**************************************************************************************************
    
//	private static JTable tabla;
//    private static DefaultTableModel modelo = null;
	private static String recetasSeleccionado;


	public Recetario() {
		super();
		inicializarComponentes();	
		establecerManejador();
		listarRecetas();
	}
	
	public void inicializarComponentes() {
		
		panelRecetario= new JPanel();
		caja_nombre_receta = new JTextField();
		btn_listadoRecetas = new JButton("Lista de todas las recetas");
		btn_buscar = new JButton("Buscar");
		btn_volver = new JButton("Volver");
		btn_ver_recetas = new JButton("Ver");
		btn_nueva_receta = new JButton("Nuevo");
		btn_modificar_receta = new JButton("Modificar");
		btn_cambiar_estado = new JButton("Cambiar Estado");
		tabla = new JTable();
		scroll = new JScrollPane(tabla);
	
		panelRecetario.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelRecetario.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		panelRecetario.setLayout(null);
		panelRecetario.setVisible(false);
		
		caja_nombre_receta.setBounds(10, 45, 169, 20);
		panelRecetario.add(caja_nombre_receta);
		caja_nombre_receta.setColumns(10);
		
		btn_listadoRecetas.setBounds(10, 11, 156, 23);
		panelRecetario.add(btn_listadoRecetas);
		
	
		btn_buscar.setBounds(189, 44, 65, 23);
		panelRecetario.add(btn_buscar);
		
		btn_volver.setBounds(359, 11, 65, 23);
		panelRecetario.add(btn_volver);
				
		btn_ver_recetas.setBounds(10, 227, 57, 23);
		panelRecetario.add(btn_ver_recetas);
		
		btn_nueva_receta.setBounds(77, 227, 65, 23);
		panelRecetario.add(btn_nueva_receta);
		
		btn_modificar_receta.setBounds(154, 227, 75, 23);
		panelRecetario.add(btn_modificar_receta);
		
		btn_cambiar_estado.setBounds(287, 227, 107, 23);
		panelRecetario.add(btn_cambiar_estado);
	    
	    scroll.setViewportView(tabla);
	    scroll.setBounds(10, 76, 384, 130);
	    panelRecetario.add(scroll);
	    
	    
	    
	}
	
	public void establecerManejador() {		
		ControladorRecetario controlador = new ControladorRecetario(this);
		
		caja_nombre_receta.addActionListener(controlador);
		btn_cambiar_estado.addActionListener(controlador);
		btn_modificar_receta.addActionListener(controlador);
		btn_nueva_receta.addActionListener(controlador);
		btn_ver_recetas.addActionListener(controlador);
		btn_listadoRecetas.addActionListener(controlador);
		btn_buscar.addActionListener(controlador);
		btn_volver.addActionListener(controlador);
		tabla.addMouseListener(controlador);
	}
		
	
	public static void listarRecetas () {
		arrayRecetas = new ArrayList<ModeloRecetario>();
		BbddRecetario.listarRecetas();
        arrayRecetas = BbddRecetario.getarrayRecetario();
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.addColumn("NOMBRE RECETA");
        modelo.addColumn("ESTADO");
        
        Object filaDato[] = new Object[2];     
        for (int i = 0; i < arrayRecetas.size(); i++) {
        	filaDato[0] = arrayRecetas.get(i).getNombreReceta();
        	filaDato[1] = arrayRecetas.get(i).getEstado();  
        	modelo.addRow(filaDato);
    	}
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
    }
	

	 public static int recetaSeleccionado() throws NullPointerException {
		 int indiceSeleccionado = tabla.getSelectedRow();
		 return indiceSeleccionado;	
	 }
	

	public static JPanel getPanelRecetario() {
		return panelRecetario;
	}

	public static void setPanelRecetario(JPanel panelRecetario) {
		Recetario.panelRecetario = panelRecetario;
	}

	public static JTextField getCaja_nombre_receta() {
		return caja_nombre_receta;
	}

	public static void setCaja_nombre_receta(JTextField caja_nombre_receta) {
		Recetario.caja_nombre_receta = caja_nombre_receta;
	}


	public static JButton getBtn_cambiar_estado() {
		return btn_cambiar_estado;
	}

	public static void setBtn_cambiar_estado(JButton btn_cambiar_estado) {
		Recetario.btn_cambiar_estado = btn_cambiar_estado;
	}

	public static JButton getBtn_modificar_receta() {
		return btn_modificar_receta;
	}

	public static void setBtn_modificar_receta(JButton btn_modificar_receta) {
		Recetario.btn_modificar_receta = btn_modificar_receta;
	}

	public static JButton getBtn_nueva_receta() {
		return btn_nueva_receta;
	}

	public static void setBtn_nueva_receta(JButton btn_nueva_receta) {
		Recetario.btn_nueva_receta = btn_nueva_receta;
	}

	public static JButton getBtn_ver_recetas() {
		return btn_ver_recetas;
	}

	public static void setBtn_ver_recetas(JButton btn_ver_recetas) {
		Recetario.btn_ver_recetas = btn_ver_recetas;
	}

	public static JButton getBtn_listadoRecetas() {
		return btn_listadoRecetas;
	}

	public static void setBtn_listadoRecetas(JButton btn_listadoRecetas) {
		Recetario.btn_listadoRecetas = btn_listadoRecetas;
	}

	public static JButton getBtn_buscar() {
		return btn_buscar;
	}

	public static void setBtn_buscar(JButton btn_buscar) {
		Recetario.btn_buscar = btn_buscar;
	}

	public static JButton getBtn_volver() {
		return btn_volver;
	}

	public static void setBtn_volver(JButton btn_volver) {
		Recetario.btn_volver = btn_volver;
	}

}
