package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorCalculoGastos;
import modelo.BbddVentas;
import modelo.ModeloReceta;

import java.util.ArrayList;

import javax.swing.JButton;

public class CalculoGastos extends JPanel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5172361613940509176L;
	
	private static JPanel paneCalculoGastos;
	private static JTextField caja_Desde;
	private static JTextField caja_Hasta;
	private static JLabel lbl_Desde;
	private static JLabel lbl_Hasta;
	private static JLabel lbl_Gastos;
	private static JLabel lbl_Cuenta_Gastos;
	private static JButton btn_Volver;
	private static JButton btn_Imprimir;
	private static JTable tabla;
    private static JScrollPane scroll;
    
	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;

	private static ArrayList<ModeloReceta> arrayGastos;


    
	public CalculoGastos() {
		super();
		inicializarComponentes();
		establecerManejador();	
	}

	public void inicializarComponentes() {
				paneCalculoGastos = new JPanel();
		lbl_Desde = new JLabel("Desde");
		lbl_Hasta = new JLabel("Hasta");
		caja_Desde = new JTextField();
		caja_Hasta = new JTextField();
		lbl_Gastos = new JLabel("Total gastos");
		lbl_Cuenta_Gastos = new JLabel("0,00 \u20AC");
		btn_Volver = new JButton("Volver");
		btn_Imprimir = new JButton("Imprimir");
		tabla = new JTable();
		
		paneCalculoGastos.setBorder(new EmptyBorder(5, 5, 5, 5));
		paneCalculoGastos.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		paneCalculoGastos.setLayout(null);		paneCalculoGastos.setVisible(false);		
		lbl_Desde.setBounds(30, 63, 46, 14);
		paneCalculoGastos.add(lbl_Desde);

		lbl_Hasta.setBounds(30, 88, 38, 14);
		paneCalculoGastos.add(lbl_Hasta);
		
		caja_Desde = new JTextField();
		caja_Desde.setBounds(78, 60, 86, 20);
		paneCalculoGastos.add(caja_Desde);
		caja_Desde.setColumns(10);
		
		caja_Hasta = new JTextField();
		caja_Hasta.setBounds(78, 85, 86, 20);
		paneCalculoGastos.add(caja_Hasta);
		caja_Hasta.setColumns(10);
		
		lbl_Gastos.setBounds(26, 170, 75, 14);
		paneCalculoGastos.add(lbl_Gastos);
		
		lbl_Cuenta_Gastos.setBounds(40, 195, 46, 14);
		paneCalculoGastos.add(lbl_Cuenta_Gastos);
		btn_Volver.setBounds(335, 11, 75, 23);
		paneCalculoGastos.add(btn_Volver);
		
		btn_Imprimir.setBounds(224, 227, 89, 23);
		paneCalculoGastos.add(btn_Imprimir);
		
	    scroll = new JScrollPane(tabla);
	    scroll.setViewportView(tabla);
	    scroll.setBounds(233, 63, 173, 146);
	    paneCalculoGastos.add(scroll);

	}

	public void establecerManejador() {			
		ControladorCalculoGastos controlador = new ControladorCalculoGastos(this);
				tabla.addMouseListener(controlador);
		lbl_Cuenta_Gastos.addMouseListener(controlador);
		caja_Desde.addActionListener(controlador);
		caja_Hasta.addActionListener(controlador);	
		btn_Volver.addActionListener(controlador);
		btn_Imprimir.addActionListener(controlador);
			
	}

	
	public static void listarGastos () {
		arrayGastos = new ArrayList<ModeloReceta>();			// <-- modificar el tipo de array al modelo objeto que corresponda
        BbddVentas.listarClientes();							// <-- modificar el método para que llame a la sentencia SQL que corresponda y y cargue los datos
        arrayGastos = BbddVentas.getArrayRecetas();				// <-- crear y modificar el metodo GET que trae los datos del array que corresponda
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.addColumn("Nº");
        modelo.addColumn("FECHA");
        modelo.addColumn("GASTO");
        
        Object filaDato[] = new Object[3];     
        for (int i = 0; i < arrayGastos.size(); i++) {
        	filaDato[0] = arrayGastos.get(i).getReceta();	// <-- llamar el dato que corresponda del objeto modelo
        	filaDato[1] = arrayGastos.get(i).getEstado();  	// <-- llamar el dato que corresponda del objeto modelo
        	filaDato[2] = arrayGastos.get(i).getEstado();  	// <-- llamar el dato que corresponda del objeto modelo
        	modelo.addRow(filaDato);
    	}
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
	}
	

	 public static int productoSeleccionado() throws NullPointerException {
		 int indiceSeleccionado = tabla.getSelectedRow();
		 return indiceSeleccionado;	
	 }
	 
	public static JTextField getCaja_Desde() {
		return caja_Desde;
	}
	
	public static void setCaja_Desde(JTextField caja_Desde) {
		CalculoGastos.caja_Desde = caja_Desde;
	}
	
	public static JTextField getCaja_Hasta() {
		return caja_Hasta;
	}
	
	public static void setCaja_Hasta(JTextField caja_Hasta) {
		CalculoGastos.caja_Hasta = caja_Hasta;
	}
	
	public static JLabel getLbl_Cuenta_Gastos() {
		return lbl_Cuenta_Gastos;
	}
	
	public static void setLbl_Cuenta_Gastos(JLabel lbl_Cuenta_Gastos) {
		CalculoGastos.lbl_Cuenta_Gastos = lbl_Cuenta_Gastos;
	}
	
	public static JPanel getPaneCalculoGastos() {
		return paneCalculoGastos;
	}
	
	public static JButton getBtn_Volver() {
		return btn_Volver;
	}
	
	public static JButton getBtn_Imprimir() {
		return btn_Imprimir;
	}
	
	public static void setPaneCalculoGastos(JPanel paneCalculoGastos) {
		CalculoGastos.paneCalculoGastos = paneCalculoGastos;
	}	
	
	
	
}
