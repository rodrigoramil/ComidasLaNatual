package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
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
//	private static JTable tabla;
    private static JScrollPane scroll;
    private static JScrollPane scrollTexto;
	private static ArrayList<ModeloReceta> arrayIngredientes;
	private static JTextField precio_receta;
	private static JLabel lbl_iprecio;
	
	//**************
	private static Receta receta;
	//**************
	
	public Receta() {		
		super();
		inicializarComponentes();
		establecerManejador();		
//		listarRecetas();
	}

	public void inicializarComponentes() {
		arrayIngredientes = new ArrayList<ModeloReceta>();
		//arrayIngredientes = BbddReceta.listarRecetas();

		
		panelReceta = VentanaPrincipal.parametrosPanel(800,600);
		
		
		precio_receta = VentanaPrincipal.parametrosJTextField(580, 40, 60, 20);
		precio_receta.setFont(new Font("Manche Condensed",Font.BOLD,(int)(14*VentanaPrincipal.getCordenadaY())));
		precio_receta.setBackground(VentanaPrincipal.getAzulClaro());
		precio_receta.setText("0,00");
		precio_receta.setHorizontalAlignment(SwingConstants.CENTER);
		panelReceta.add(precio_receta);
		
		lbl_iprecio = VentanaPrincipal.parametrosJlabel("Precio:",450, 33, 200, 30);
		lbl_iprecio.setFont(new Font("Manche Condensed",Font.BOLD,(int)(15*VentanaPrincipal.getCordenadaY())));
		lbl_iprecio.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_iprecio.setForeground(Color.ORANGE);
		panelReceta.add(lbl_iprecio);

		
		nombre_receta = VentanaPrincipal.parametrosJTextField(50, 30, 400, 40);
		nombre_receta.setFont(new Font("Manche Condensed",Font.BOLD,(int)(20*VentanaPrincipal.getCordenadaY())));
		nombre_receta.setBackground(VentanaPrincipal.getAzulClaro());
		nombre_receta.setText("Nombre de la receta");
		nombre_receta.setHorizontalAlignment(SwingConstants.CENTER);
		panelReceta.add(nombre_receta);
		
		btn_volver = VentanaPrincipal.parametrosJButton("Volver", 710, 20, 70, 20);
		panelReceta.add(btn_volver);
		
				
		lbl_ingredientes = VentanaPrincipal.parametrosJlabel("Ingredientes",50, 70, 300, 40);
		lbl_ingredientes.setFont(new Font("Manche Condensed",Font.BOLD,(int)(15*VentanaPrincipal.getCordenadaY())));
		lbl_ingredientes.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ingredientes.setForeground(Color.ORANGE);
		panelReceta.add(lbl_ingredientes);
		
		lbl_elaboracion = VentanaPrincipal.parametrosJlabel("Elaboraci\u00F3n",450, 70, 300, 40);
		lbl_elaboracion.setFont(new Font("Manche Condensed",Font.BOLD,(int)(15*VentanaPrincipal.getCordenadaY())));
		lbl_elaboracion.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_elaboracion.setForeground(Color.ORANGE);
		panelReceta.add(lbl_elaboracion);
		
		btn_nuevo_ingrediente = VentanaPrincipal.parametrosJButton("Nuevo ingrediente",50, 520, 120, 20);
		panelReceta.add(btn_nuevo_ingrediente);
		
		btn_modificar_cantidad = VentanaPrincipal.parametrosJButton("Modificar cantidad",200, 520, 120, 20);
		panelReceta.add(btn_modificar_cantidad);
		
		btn_borrar_ingrediente = VentanaPrincipal.parametrosJButton("Borrar ingrediente",350, 520, 120, 20);
		panelReceta.add(btn_borrar_ingrediente);
		
		btn_guardar = VentanaPrincipal.parametrosJButton("Guardar",600, 520, 120, 40);
		btn_guardar.setBackground(Color.ORANGE);
		panelReceta.add(btn_guardar);
		
		
//		tabla = new JTable();
		scroll = VentanaPrincipal.parametrosJScrollPane(50, 100, 300, 400);
		panelReceta.add(scroll);
		
		texto_elaboracion = new JTextArea();
		texto_elaboracion.setFont(VentanaPrincipal.getFuente());
		texto_elaboracion.setBorder(null);
		texto_elaboracion.setLineWrap(true); //las líneas se ajustarán si son demasiado largas
		texto_elaboracion.setWrapStyleWord(true);//líneas se ajustarán en los límites de palabra, no de los caracteres
		
		scrollTexto = new JScrollPane(texto_elaboracion);
		scrollTexto.setBounds(
				Math.round(450*VentanaPrincipal.getCordenadaX()), 		//posicion HORIZONTAL
				Math.round(100*VentanaPrincipal.getCordenadaY()),		//posicion VERTICAL
				Math.round(300*VentanaPrincipal.getCordenadaX()), 		//tamaño HORIZONTAL
				Math.round(400*VentanaPrincipal.getCordenadaY())); 		//tamaño VERTICAL
		scrollTexto.setVisible(true);
		panelReceta.add(scrollTexto);
		panelReceta.setVisible(false);
	}
	

	private static void establecerManejador() {
	//**************
		ControladorReceta controlador = new ControladorReceta(receta);	
	//**************
		
		btn_nuevo_ingrediente.addActionListener(controlador);
		btn_modificar_cantidad.addActionListener(controlador);
		btn_borrar_ingrediente.addActionListener(controlador);
		btn_guardar.addActionListener(controlador);
		btn_volver.addActionListener(controlador);
		precio_receta.addActionListener(controlador);
		nombre_receta.addActionListener(controlador);

	//*****************
//		tabla.addMouseListener(controlador);
	//******************
	}
	
	
	
	public static void listarRecetas (ArrayList<ModeloReceta> arrayTabla) {

        JTable tabla = new JTable();		
		arrayIngredientes = arrayTabla;
		
		nombre_receta.setText(BbddReceta.getNombreRecetaSeleccionada());
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.addColumn("NOMBRE");
        modelo.addColumn("CANTIDAD");
        
        Object filaDato[] = new Object[2];  
        for (int i = 0; i < arrayIngredientes.size(); i++) {
        	filaDato[0] = arrayIngredientes.get(i).getNombreProducto();
        	filaDato[1] = arrayIngredientes.get(i).getCantidad();  
        	modelo.addRow(filaDato);
        	texto_elaboracion.setText(arrayIngredientes.get(i).getElaboracion());
        	precio_receta.setText(String.valueOf(arrayIngredientes.get(i).getPrecioVenta()));
		}
   
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
        tabla = VentanaPrincipal.formatoTabla(tabla); 
        
        tabla = establecerManejadorTabla(tabla);
        scroll.setViewportView(tabla);
        
		int indiceSelecionado = tabla.getSelectedRow();
		System.out.println(indiceSelecionado);
        
    }

	private static JTable establecerManejadorTabla(JTable tabla) {
		ControladorReceta controlador = new ControladorReceta(receta);	
		tabla.addMouseListener(controlador);
		return tabla;
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
/*
	public static JTable getTabla() {
		return tabla;
	}
*/
	public static ArrayList<ModeloReceta> getArrayIngredientes() {
		return arrayIngredientes;
	}

	public static void setArrayIngredientes(ArrayList<ModeloReceta> arrayIngredientes) {
		Receta.arrayIngredientes = arrayIngredientes;
	}

	public static JTextField getPrecio_receta() {
		return precio_receta;
	}

	
	
	
	
	

}
