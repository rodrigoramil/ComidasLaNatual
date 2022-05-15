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
	private static JTable tabla;
    private static JScrollPane scroll;
	private static ArrayList<ModeloReceta> arrayIngredientes;


	
	public Receta() {		
		super();
		inicializarComponentes();
		establecerManejador();		
		listarRecetas();
	}

	public void inicializarComponentes() {

		panelReceta = VentanaPrincipal.parametrosPanel(800,600);
		
		
		nombre_receta = VentanaPrincipal.parametrosJTextField(175, 30, 450, 40);
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
		
		
		tabla = new JTable();
		scroll = VentanaPrincipal.parametrosJScrollPane(50, 100, 300, 400);
		panelReceta.add(scroll);
		
		texto_elaboracion = new JTextArea();
		texto_elaboracion.setFont(VentanaPrincipal.getFuente());
		texto_elaboracion.setBorder(null);
		texto_elaboracion.setBounds(
				Math.round(450*VentanaPrincipal.getCordenadaX()), 		//posicion HORIZONTAL
				Math.round(100*VentanaPrincipal.getCordenadaY()),		//posicion VERTICAL
				Math.round(300*VentanaPrincipal.getCordenadaX()), 		//tamaño HORIZONTAL
				Math.round(400*VentanaPrincipal.getCordenadaY())); 		//tamaño VERTICAL
		panelReceta.add(texto_elaboracion);
			
		panelReceta.setVisible(false);
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
	}
	
	
	
	public static void listarRecetas () {
		arrayIngredientes = new ArrayList<ModeloReceta>();
		BbddReceta.listarRecetas();
		arrayIngredientes = BbddReceta.getArrayVentanaReceta();
		tabla = new JTable();
		scroll.setViewportView(tabla);
		nombre_receta.setText(BbddReceta.getNombreRecetaSeleccionada());
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.addColumn("NOMBRE");
        modelo.addColumn("CANTIDAD");
        
        Object filaDato[] = new Object[2];   
        if (arrayIngredientes.size()<=0) {
        	texto_elaboracion.setText("");
        }
        for (int i = 0; i < arrayIngredientes.size(); i++) {
        	filaDato[0] = arrayIngredientes.get(i).getIngrediente();
        	filaDato[1] = arrayIngredientes.get(i).getCantidad();  
        	modelo.addRow(filaDato);
        	System.out.println("arrayIngredientes - "+arrayIngredientes.size());
        	texto_elaboracion.setText(arrayIngredientes.get(i).getElaboracion());
		}
    	        	
	
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
        tabla = VentanaPrincipal.formatoTabla(tabla);
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
