package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import controlador.ControladorRecetario;
import modelo.BbddVentas;
import modelo.ModeloCliente;
import modelo.ModeloReceta;


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
	
	private int ancho = 800;
	private int alto = 600;
	private int posicionPanel_x = 100;
	private int posicionPanel_y = 50;

//	private static JList listaRecetas;
    private static JScrollPane scrollRecetas;
    
    private static ArrayList<ModeloReceta> arrayRecetas;
//    private static DefaultListModel modeloListaReceta;
    
    
	//**************************************************************************************************
    
	private static JTable tablaRecetas;
    private static DefaultTableModel modeloRecetas = null;
	private static String recetasSeleccionado;

	//**************************************************************************************************	
	
	public Recetario() {
		super();
		inicializarComponentes();	
		establecerManejador();
		
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
		
		//**************************************************************************************************	
		
				tablaRecetas = new JTable();
				scrollRecetas = new JScrollPane(tablaRecetas);
				
		//**************************************************************************************************			
		
		
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
/*
	    listaRecetas = new JList();
	    listaRecetas.setLayout(null);
	    listaRecetas.setVisible(true);		
		
	    scrollRecetas = new JScrollPane(listaRecetas);	
	    scrollRecetas.setBounds(10, 76, 384, 130);
	    scrollRecetas.setViewportView(listaRecetas);
	    panelRecetario.add(scrollRecetas);
	    
*/	    
	    
	    
	    scrollRecetas.setBounds(10, 76, 384, 130);
	    panelRecetario.add(scrollRecetas);
	    
	    
	    
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
//		listaRecetas.addMouseListener(controlador);

		tablaRecetas.addMouseListener(controlador);
	}
	
	
	
	public static void datosReceta () {
		arrayRecetas = new ArrayList<ModeloReceta>();
        modeloRecetas = new DefaultTableModel(0,0);
        BbddVentas.listarClientes();
        arrayRecetas = BbddVentas.getArrayRecetas();
        Iterator<ModeloReceta> it = arrayRecetas.iterator();
        modeloRecetas.addColumn("NOMBRE RRECETA");
        modeloRecetas.addColumn("ESTADO");
        while (it.hasNext()) {
        	modeloRecetas.addRow(new Object[] {it.next().getReceta()});
		}

        tablaRecetas.setModel(modeloRecetas);
        modeloRecetas.fireTableDataChanged();

    }

	 public static int recetaSeleccionado() throws NullPointerException {
		 int indiceSeleccionado = tablaRecetas.getSelectedRow();
	
		return indiceSeleccionado;		 
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

/*
	public static ArrayList<ModeloCliente> creaListaRecetas() {
		BbddVentas.listarClientes();
		arrayRecetas = BbddVentas.getArrayClientes();
		modeloListaReceta = new DefaultListModel();
		for (ModeloCliente c : arrayRecetas) {
			modeloListaReceta.addElement(c.toString());
		}
		listaRecetas.setModel(modeloListaReceta);
		return arrayRecetas;
	}
		
	 public static int clienteSeleccionado() throws NullPointerException {
		 int indiceSeleccionado = listaRecetas.getSelectedIndex();
		return indiceSeleccionado;		 
	 }
	*/
	
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
