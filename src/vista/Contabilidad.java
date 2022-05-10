package vista;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlador.ControladorContabilidad;
import javax.swing.JButton;

public class Contabilidad extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5004678058994074860L;
	
	private static JPanel panelContabilidad;
	private static JButton btn_Gastos;
	private static JButton btn_volver;
	private static JButton btn_Facturacion;
	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;

	public Contabilidad() {
		super();
		inicializarComponentes();
		establecerManejador();		
	
	}
	
	
	public void inicializarComponentes() {
		
		panelContabilidad = new JPanel();	
		btn_Gastos = new JButton("Gastos");
		btn_volver = new JButton("Volver");
		btn_Facturacion = new JButton("Facturacion");
		
		panelContabilidad.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelContabilidad.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		panelContabilidad.setLayout(null);
		panelContabilidad.setVisible(false);
		
		btn_Gastos.setBounds(134, 78, 163, 43);
		panelContabilidad.add(btn_Gastos);
		
		btn_volver.setBounds(335, 23, 89, 23);
		panelContabilidad.add(btn_volver);
		
		btn_Facturacion.setBounds(134, 133, 163, 43);
		panelContabilidad.add(btn_Facturacion);		

	}

	
	public void establecerManejador() {			
		ControladorContabilidad controlador = new ControladorContabilidad(this);
		btn_Gastos.addActionListener(controlador);
		btn_Facturacion.addActionListener(controlador);
		btn_volver.addActionListener(controlador);
		
	}


	public static JPanel getPanelContabilidad() {
		return panelContabilidad;
	}


	public static JButton getBtn_Gastos() {
		return btn_Gastos;
	}


	public static JButton getBtn_volver() {
		return btn_volver;
	}


	public static JButton getBtn_Facturacion() {
		return btn_Facturacion;
	}	
	
	
	
	
	
	
}
