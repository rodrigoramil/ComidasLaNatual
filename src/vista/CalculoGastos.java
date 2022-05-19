package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controlador.ControladorCalculoGastos;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import modelo.ModeloPRUEBA;

public class CalculoGastos extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5172361613940509176L;
	
	private static JPanel panelCalculoGastos;
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
    private static CalculoGastos calculoGastos;
	private static ArrayList<ModeloPRUEBA> arrayGastos;

	private static String dato;
    
	public CalculoGastos() {
		super();
		inicializarComponentes();
		establecerManejador();
	}

	public void inicializarComponentes() {
		
		arrayGastos = new ArrayList<ModeloPRUEBA>();
		
		panelCalculoGastos = VentanaPrincipal.parametrosPanel(800,600);
		
		btn_Volver = VentanaPrincipal.parametrosJButton("Volver", 710, 20, 70, 20);
		panelCalculoGastos.add(btn_Volver);
		
		lbl_Desde = VentanaPrincipal.parametrosJlabel("Desde",40, 150, 100, 20);
		lbl_Desde.setHorizontalAlignment(SwingConstants.RIGHT);
		panelCalculoGastos.add(lbl_Desde); 	
		
		caja_Desde = VentanaPrincipal.parametrosJTextField(150, 150, 120, 20);
		panelCalculoGastos.add(caja_Desde);
		
		lbl_Hasta = VentanaPrincipal.parametrosJlabel("Hasta",40, 200, 100, 20);
		lbl_Hasta.setHorizontalAlignment(SwingConstants.RIGHT);
		panelCalculoGastos.add(lbl_Hasta); 	
		
		caja_Hasta = VentanaPrincipal.parametrosJTextField(150, 200, 120, 20);
		panelCalculoGastos.add(caja_Hasta);
		
		lbl_Gastos = VentanaPrincipal.parametrosJlabel("Total gastos",40, 360, 200, 40);
		lbl_Gastos.setFont(new Font("Manche Condensed",Font.BOLD,(int)(20*VentanaPrincipal.getCordenadaY())));
		panelCalculoGastos.add(lbl_Gastos);
				
		
		lbl_Cuenta_Gastos = VentanaPrincipal.parametrosJlabel("0,00 \u20AC",40, 400, 200, 40);
		lbl_Cuenta_Gastos.setFont(new Font("Manche Condensed",Font.BOLD,(int)(20*VentanaPrincipal.getCordenadaY())));
		panelCalculoGastos.add(lbl_Cuenta_Gastos);

		btn_Imprimir = VentanaPrincipal.parametrosJButton("Imprimir",340, 550, 120, 20);
		panelCalculoGastos.add(btn_Imprimir);

		tabla = new JTable();
		scroll = VentanaPrincipal.parametrosJScrollPane(400, 100, 350, 400);
		scroll.setViewportView(tabla);
		panelCalculoGastos.add(scroll);
	    
		panelCalculoGastos.setVisible(false);

	}

	public static void establecerManejador() {			
		ControladorCalculoGastos controlador = new ControladorCalculoGastos(calculoGastos);

		lbl_Cuenta_Gastos.addMouseListener(controlador);
		caja_Desde.addActionListener(controlador);
		caja_Hasta.addActionListener(controlador);	
		btn_Volver.addActionListener(controlador);
		btn_Imprimir.addActionListener(controlador);
		tabla.addMouseListener(controlador);
		btn_Volver.addMouseListener(controlador);
		btn_Imprimir.addMouseListener(controlador);
	}

	
	public static void listarGastos (ArrayList<ModeloPRUEBA> arrayTabla) {
		arrayGastos = arrayTabla;
        DefaultTableModel modelo =new DefaultTableModel(){
		    @Override
		    public boolean isCellEditable(int row, int column) {	
		       return false;
		    }
		};
        modelo.addColumn("Nº");
        modelo.addColumn("FECHA");
        modelo.addColumn("GASTO");
        
        Object filaDato[] = new Object[3];     
        for (int i = 0; i < arrayGastos.size(); i++) {
        	filaDato[0] = arrayGastos.get(i).getReceta();
        	filaDato[1] = arrayGastos.get(i).getEstado();
        	filaDato[2] = arrayGastos.get(i).getEstado();
        	modelo.addRow(filaDato);
    	}
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
        tabla = VentanaPrincipal.formatoTabla(tabla);
        
        tabla.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(350);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(250);

        tabla.getColumnModel().getColumn(0).setResizable(false);
        tabla.getColumnModel().getColumn(1).setResizable(false);
        tabla.getColumnModel().getColumn(2).setResizable(false);

	}
	

	/**
	 * Da el dato de la celda selecionada en la columna 0 
	 * @return
	 */
	 public static String datoSeleccionadoTabla() {	
		try {
			dato=String.valueOf(tabla.getModel().getValueAt(tabla.getSelectedRow(),0));
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(panelCalculoGastos, "Debes de selecionar algo de la lista antes");
		}
		return dato;		
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
		return panelCalculoGastos;
	}
	
	public static JButton getBtn_Volver() {
		return btn_Volver;
	}
	
	public static JButton getBtn_Imprimir() {
		return btn_Imprimir;
	}
	
	public static void setPaneCalculoGastos(JPanel paneCalculoGastos) {
		CalculoGastos.panelCalculoGastos = paneCalculoGastos;
	}

	public static JTable getTabla() {
		return tabla;
	}	
	
	
	
}
