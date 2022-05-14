package vista;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import controlador.ControladorCalculoGanancias;
import modelo.ModeloCalculoGanancias;
import modelo_bbdd.BbddCalculoGanancias;

public class CalculoGanancias extends JPanel {

	private static JPanel panelCalculoGanancias;
	private static JTextField tfd_Desde;
	private static JTextField tfd_hasta;
	private static JButton btn_Volver;
	private static JLabel lbl_Desde;
	private static JLabel lbl_Hasta;
	private static JLabel lbl_Total_Ganancias;
	private static JLabel lbl_Calculo_Ganancias;
	private static JButton btn_Imprimir;
	private static JTable tabla;
    private static JScrollPane scroll;

	private static ArrayList<ModeloCalculoGanancias> arrayGanancias;

    
	public CalculoGanancias() {
		super();
		inicializarComponentes();
		establecerManejador();		
		listarGanancias();
	}

	public void inicializarComponentes() {
		
		panelCalculoGanancias = VentanaPrincipal.parametrosPanel(800,600);
		
		btn_Volver = VentanaPrincipal.parametrosJButton("Volver", 710, 20, 70, 20);
		panelCalculoGanancias.add(btn_Volver);
		
		lbl_Desde = VentanaPrincipal.parametrosJlabel("Desde",40, 150, 100, 20);
		lbl_Desde.setHorizontalAlignment(SwingConstants.RIGHT);
		panelCalculoGanancias.add(lbl_Desde); 	
		
		tfd_Desde = VentanaPrincipal.parametrosJTextField(150, 150, 120, 20);
		panelCalculoGanancias.add(tfd_Desde);
		
		lbl_Hasta = VentanaPrincipal.parametrosJlabel("Hasta",40, 200, 100, 20);
		lbl_Hasta.setHorizontalAlignment(SwingConstants.RIGHT);
		panelCalculoGanancias.add(lbl_Hasta); 	
		
		tfd_hasta = VentanaPrincipal.parametrosJTextField(150, 200, 120, 20);
		panelCalculoGanancias.add(tfd_hasta);
		
		lbl_Total_Ganancias = VentanaPrincipal.parametrosJlabel("Total Ganancias",40, 360, 200, 40);
		lbl_Total_Ganancias.setFont(new Font("Manche Condensed",Font.BOLD,(int)(20*VentanaPrincipal.getCordenadaY())));
		panelCalculoGanancias.add(lbl_Total_Ganancias);
				
		
		lbl_Calculo_Ganancias = VentanaPrincipal.parametrosJlabel("284,76 \u20AC",40, 400, 200, 40);
		lbl_Calculo_Ganancias.setFont(new Font("Manche Condensed",Font.BOLD,(int)(20*VentanaPrincipal.getCordenadaY())));
		panelCalculoGanancias.add(lbl_Calculo_Ganancias);

		btn_Imprimir = VentanaPrincipal.parametrosJButton("Imprimir",340, 550, 120, 20);
		panelCalculoGanancias.add(btn_Imprimir);

		tabla = new JTable();
		scroll = VentanaPrincipal.parametrosJScrollPane(400, 100, 350, 400);    
		panelCalculoGanancias.add(scroll);
	    
		panelCalculoGanancias.setVisible(false);
	}

	public void establecerManejador() {			
		ControladorCalculoGanancias controlador = new ControladorCalculoGanancias(this);
		
		tfd_Desde.addMouseListener(controlador);
		tfd_hasta.addMouseListener(controlador);
		lbl_Calculo_Ganancias.addMouseListener(controlador);		
		btn_Volver.addActionListener(controlador);
		btn_Imprimir.addActionListener(controlador);

	}

	public static void listarGanancias () {
		arrayGanancias = new ArrayList<ModeloCalculoGanancias>();
        BbddCalculoGanancias.listarCalculoGanancias();
        arrayGanancias = BbddCalculoGanancias.getArrayCalculoGanancias();
		tabla = new JTable();
		scroll.setViewportView(tabla);
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.addColumn("Nº");
        modelo.addColumn("FECHA-HORA");
        modelo.addColumn("GANANCIA");
        
        Object filaDato[] = new Object[3];     
        for (int i = 0; i < arrayGanancias.size(); i++) {
        	filaDato[0] = arrayGanancias.get(i).getIdPedido();
        	filaDato[1] = arrayGanancias.get(i).getFechaPedido();
        	filaDato[2] = arrayGanancias.get(i).getGananciaPedido();
        	modelo.addRow(filaDato);
    	}
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
    }

	 public static int indiceSeleccionado() throws NullPointerException {
		 int indiceSeleccionado = tabla.getSelectedRow();
		 return indiceSeleccionado;	
	 }

	public static JTextField getTfd_Desde() {
		return tfd_Desde;
	}

	public static void setTfd_Desde(JTextField tfd_Desde) {
		CalculoGanancias.tfd_Desde = tfd_Desde;
	}

	public static JTextField getTfd_hasta() {
		return tfd_hasta;
	}

	public static void setTfd_hasta(JTextField tfd_hasta) {
		CalculoGanancias.tfd_hasta = tfd_hasta;
	}

	public static JLabel getLbl_Calculo_Ganancias() {
		return lbl_Calculo_Ganancias;
	}

	public static void setLbl_Calculo_Ganancias(JLabel lbl_Calculo_Ganancias) {
		CalculoGanancias.lbl_Calculo_Ganancias = lbl_Calculo_Ganancias;
	}

	public static JPanel getPanelCalculoGanancias() {
		return panelCalculoGanancias;
	}

	public static JButton getBtn_Volver() {
		return btn_Volver;
	}

	public static JButton getBtn_Imprimir() {
		return btn_Imprimir;
	}

		
}
