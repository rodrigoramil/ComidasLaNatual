package vista;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controlador.ControladorRecetario;
import modelo.ModeloCliente;
import modelo.ModeloReceta;
import modelo.ModeloRecetario;
import modelo_bbdd.BbddRecetario;
import modelo_bbdd.BbddVentas;


public class Recetario extends JPanel {
	private static final long serialVersionUID = 3846625552235103376L;
	
	private static JPanel panelRecetario;
	private static JTextField caja_nombre_receta;
	private static JButton btn_cambiar_estado;
	private static JButton btn_modificar_receta;
	private static JButton btn_eliminar_receta;
	private static JButton btn_nueva_receta;
	private static JButton btn_ver_recetas;
	private static JButton btn_listar_todo;
	private static JButton btn_buscar;
	private static JButton btn_volver;
	private static JScrollPane scroll;    
    private static JTable tabla;

    private static ArrayList<ModeloRecetario> arrayRecetas;
	private static Recetario recetario;

	private static String dato;

	public Recetario() {
		super();
		inicializarComponentes();	
		establecerManejador();
		BbddRecetario.listarRecetas();
	}
	
	public void inicializarComponentes() {
		
		arrayRecetas = new ArrayList<ModeloRecetario>();
		
		panelRecetario = VentanaPrincipal.parametrosPanel(800,600);
		
		btn_listar_todo = VentanaPrincipal.parametrosJButton("Lista de todo",50, 30, 150, 20);
		panelRecetario.add(btn_listar_todo);
		
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
		
		btn_modificar_receta = VentanaPrincipal.parametrosJButton("Modificar",340, 520, 120, 20);
		panelRecetario.add(btn_modificar_receta);
		
		btn_eliminar_receta= VentanaPrincipal.parametrosJButton("Eliminar",480, 520, 120, 20);
		panelRecetario.add(btn_eliminar_receta);
		
		btn_cambiar_estado = VentanaPrincipal.parametrosJButton("Cambiar Estado",630, 520, 120, 20);
		panelRecetario.add(btn_cambiar_estado);
		
		tabla = new JTable();
		scroll = VentanaPrincipal.parametrosJScrollPane(50, 100, 700, 400);
		scroll.setViewportView(tabla);
	    panelRecetario.add(scroll);
	    panelRecetario.setVisible(false);    
	    
	}
	
	public static void establecerManejador() {		
		ControladorRecetario controlador = new ControladorRecetario(recetario);
		
		caja_nombre_receta.addActionListener(controlador);
		btn_cambiar_estado.addActionListener(controlador);
		btn_modificar_receta.addActionListener(controlador);
		btn_eliminar_receta.addActionListener(controlador);
		btn_nueva_receta.addActionListener(controlador);
		btn_ver_recetas.addActionListener(controlador);
		btn_listar_todo.addActionListener(controlador);
		btn_buscar.addActionListener(controlador);
		btn_volver.addActionListener(controlador);
		tabla.addMouseListener(controlador);
		btn_cambiar_estado.addMouseListener(controlador);
		btn_modificar_receta.addMouseListener(controlador);
		btn_eliminar_receta.addMouseListener(controlador);
		btn_nueva_receta.addMouseListener(controlador);
		btn_ver_recetas.addMouseListener(controlador);
		btn_listar_todo.addMouseListener(controlador);
		btn_buscar.addMouseListener(controlador);
		btn_volver.addMouseListener(controlador);

	}
		
	
	public static void listarRecetas (ArrayList<ModeloRecetario> arrayTabla) {
		
		arrayRecetas = arrayTabla;

		DefaultTableModel modelo =new DefaultTableModel(){
		    @Override
		    public boolean isCellEditable(int row, int column) {	
		       return false;
		    }
		};		
        modelo.addColumn("NOMBRE RECETA");
        modelo.addColumn("ESTADO");
        
        Object filaDato[] = new Object[2];     
        for (int i = 0; i < arrayRecetas.size(); i++) {
        	filaDato[0] = arrayRecetas.get(i).getNombreReceta();
        	filaDato[1] = arrayRecetas.get(i).getDisponibilidad();  
        	modelo.addRow(filaDato);
    	}
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
        tabla = VentanaPrincipal.formatoTabla(tabla);       
        tabla.getColumnModel().getColumn(0).setPreferredWidth(550);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(150);
        tabla.getColumnModel().getColumn(0).setResizable(false);
        tabla.getColumnModel().getColumn(1).setResizable(false);
        
        
	}

	
	/**
	 * Da el dato de la celda selecionada en la columna 0 
	 * @return
	 */
	 public static String datoSeleccionadoTabla() {	
		try {
			dato=String.valueOf(tabla.getModel().getValueAt(tabla.getSelectedRow(),0));
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(panelRecetario, "Debes de selecionar algo de la lista antes");
		}
		return dato;		
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

	public static JButton getBtn_listar_todo() {
		return btn_listar_todo;
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

	public static JTable getTabla() {
		return tabla;
	}

	public static JButton getBtn_eliminar_receta() {
		return btn_eliminar_receta;
	}

}
