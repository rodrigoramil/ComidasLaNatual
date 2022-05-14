package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controlador.ControladorCalculoGastos;
import modelo.ModeloPRUEBA;
import modelo_bbdd.BbddVentas;
import java.awt.Font;
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

	private static ArrayList<ModeloPRUEBA> arrayGastos;


    
	public CalculoGastos() {
		super();
		inicializarComponentes();
		establecerManejador();
		listarGastos();
	}

	public void inicializarComponentes() {
		
		
		paneCalculoGastos = VentanaPrincipal.parametrosPanel(800,600);
		
		btn_Volver = VentanaPrincipal.parametrosJButton("Volver", 710, 20, 70, 20);
		paneCalculoGastos.add(btn_Volver);
		
		lbl_Desde = VentanaPrincipal.parametrosJlabel("Desde",40, 150, 100, 20);
		lbl_Desde.setHorizontalAlignment(SwingConstants.RIGHT);
		paneCalculoGastos.add(lbl_Desde); 	
		
		caja_Desde = VentanaPrincipal.parametrosJTextField(150, 150, 120, 20);
		paneCalculoGastos.add(caja_Desde);
		
		lbl_Hasta = VentanaPrincipal.parametrosJlabel("Hasta",40, 200, 100, 20);
		lbl_Hasta.setHorizontalAlignment(SwingConstants.RIGHT);
		paneCalculoGastos.add(lbl_Hasta); 	
		
		caja_Hasta = VentanaPrincipal.parametrosJTextField(150, 200, 120, 20);
		paneCalculoGastos.add(caja_Hasta);
		
		lbl_Gastos = VentanaPrincipal.parametrosJlabel("Total gastos",40, 360, 200, 40);
		lbl_Gastos.setFont(new Font("Manche Condensed",Font.BOLD,(int)(20*VentanaPrincipal.getCordenadaY())));
		paneCalculoGastos.add(lbl_Gastos);
				
		
		lbl_Cuenta_Gastos = VentanaPrincipal.parametrosJlabel("0,00 \u20AC",40, 400, 200, 40);
		lbl_Cuenta_Gastos.setFont(new Font("Manche Condensed",Font.BOLD,(int)(20*VentanaPrincipal.getCordenadaY())));
		paneCalculoGastos.add(lbl_Cuenta_Gastos);

		btn_Imprimir = VentanaPrincipal.parametrosJButton("Imprimir",340, 550, 120, 20);
		paneCalculoGastos.add(btn_Imprimir);

		tabla = new JTable();
		scroll = VentanaPrincipal.parametrosJScrollPane(400, 100, 350, 400);    
		paneCalculoGastos.add(scroll);
	    
		paneCalculoGastos.setVisible(false);

	}

	public void establecerManejador() {			
		ControladorCalculoGastos controlador = new ControladorCalculoGastos(this);

		lbl_Cuenta_Gastos.addMouseListener(controlador);
		caja_Desde.addActionListener(controlador);
		caja_Hasta.addActionListener(controlador);	
		btn_Volver.addActionListener(controlador);
		btn_Imprimir.addActionListener(controlador);
			
	}

	
	public static void listarGastos () {
		arrayGastos = new ArrayList<ModeloPRUEBA>();			// <-- modificar el tipo de array al modelo objeto que corresponda
        BbddVentas.listarClientes();							// <-- modificar el método para que llame a la sentencia SQL que corresponda y y cargue los datos
        arrayGastos = BbddVentas.getArrayRecetas();				// <-- crear y modificar el metodo GET que trae los datos del array que corresponda
		tabla = new JTable();
		scroll.setViewportView(tabla);
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
