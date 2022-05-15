package vista;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controlador.ControladorRecetario;
import modelo.ModeloCliente;
import modelo.ModeloRecetario;
import modelo_bbdd.BbddRecetario;
import modelo_bbdd.BbddVentas;


public class Recetario extends JPanel {
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
    private static JTable tabla;
    
	private int ancho = 800;
	private int alto = 600;
	private int posicionPanel_x = 100;
	private int posicionPanel_y = 50;


    private static ArrayList<ModeloRecetario> arrayRecetas;
	private static String recetasSeleccionado;


	public Recetario() {
		super();
		inicializarComponentes();	
		establecerManejador();
		listarRecetas();
	}
	
	public void inicializarComponentes() {
		
		panelRecetario = VentanaPrincipal.parametrosPanel(800,600);
		

		btn_listadoRecetas = VentanaPrincipal.parametrosJButton("Lista de todas las recetas",50, 30, 150, 20);
		panelRecetario.add(btn_listadoRecetas);
		
		btn_volver = VentanaPrincipal.parametrosJButton("Volver", 710, 20, 70, 20);
		panelRecetario.add(btn_volver);
		
		
		caja_nombre_receta = VentanaPrincipal.parametrosJTextField(50, 65, 287, 20);
		panelRecetario.add(caja_nombre_receta);
		
		btn_buscar = VentanaPrincipal.parametrosJButton("Buscar",350, 65, 65, 20);
		panelRecetario.add(btn_buscar);
		
		btn_ver_recetas = VentanaPrincipal.parametrosJButton("Ver",50, 520, 120, 20);
		panelRecetario.add(btn_ver_recetas);
		
		btn_nueva_receta = VentanaPrincipal.parametrosJButton("Nuevo",200, 520, 120, 20);
		panelRecetario.add(btn_nueva_receta);
		
		btn_modificar_receta = VentanaPrincipal.parametrosJButton("Modificar",350, 520, 120, 20);
		panelRecetario.add(btn_modificar_receta);
		
		btn_cambiar_estado = VentanaPrincipal.parametrosJButton("Cambiar Estado",630, 520, 120, 20);
		panelRecetario.add(btn_cambiar_estado);
		
		tabla = new JTable();
		scroll = VentanaPrincipal.parametrosJScrollPane(50, 100, 700, 400);
	    panelRecetario.add(scroll);
	    panelRecetario.setVisible(false);    
	    
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

	}
		
	
	public static void listarRecetas () {
		arrayRecetas = new ArrayList<ModeloRecetario>();
		BbddRecetario.listarRecetas();
        arrayRecetas = BbddRecetario.getarrayRecetario();
		tabla = new JTable();
		scroll.setViewportView(tabla);
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
        tabla = VentanaPrincipal.formatoTabla(tabla);
    }

	

	 public static int recetaSeleccionada() throws NullPointerException {
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

	public static ArrayList<ModeloRecetario> getArrayRecetas() {
		return arrayRecetas;
	}

}
