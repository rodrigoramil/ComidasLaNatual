package vista;

import javax.swing.JPanel;
import controlador.ControladorDetalleProducto;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Choice;
import java.awt.Font;

public class DetalleProducto extends JPanel {

	private static JPanel panelDetalleProducto;
	private static JTextField tfd_Nombre;
	private static JTextField tfd_Actual;
	private static JTextField tfd_Minimo;
	private static JTextField tfd_Maximo;
	private static JLabel lbl_Nombre;
	private static JLabel lbl_UnidadMedida;
	private static Choice tipo;	
	private static Choice unidadMedida;	
	private static JLabel lbl_tipo;
	private static JLabel lbl_Actual;
	private static JLabel lbl_Minimo;	
	private static JLabel lbl_Maximo;
	private static JButton btn_volver;
	private static JButton btn_Aceptar;

	public DetalleProducto() {
		super();
		inicializarComponentes();
		establecerManejador();
		
	}

	public void inicializarComponentes() {

		panelDetalleProducto = VentanaPrincipal.parametrosPanel(400, 400);
		
		btn_volver = VentanaPrincipal.parametrosJButton("Volver", 310, 20, 70, 20);
		panelDetalleProducto.add(btn_volver);

		lbl_Nombre = VentanaPrincipal.parametrosJlabel("Nombre",5, 60, 45,20);
		lbl_Nombre.setHorizontalAlignment(SwingConstants.RIGHT);
		panelDetalleProducto.add(lbl_Nombre); 												
		
		tfd_Nombre = VentanaPrincipal.parametrosJTextField(70, 60, 325,20);
		panelDetalleProducto.add(tfd_Nombre);												

		lbl_tipo = VentanaPrincipal.parametrosJlabel("Tipo",5, 120, 45,20);
		lbl_tipo.setHorizontalAlignment(SwingConstants.RIGHT);
		panelDetalleProducto.add(lbl_tipo);
		
		tipo = new Choice();
		tipo.setBounds(
				Math.round(70*VentanaPrincipal.getCordenadaX()), 		//posicion HORIZONTAL
				Math.round(120*VentanaPrincipal.getCordenadaY()),		//posicion VERTICAL
				Math.round(100*VentanaPrincipal.getCordenadaX()), 		//tamaño HORIZONTAL
				Math.round(20*VentanaPrincipal.getCordenadaY())); 		//tamaño VERTICAL
		tipo.setFont(new Font("Manche Condensed",Font.BOLD,(int)(15*VentanaPrincipal.getCordenadaY())));
		panelDetalleProducto.add(tipo);
		tipo.select("");
		tipo.add("Comida");
		tipo.add("Bebida");
		
		
		lbl_Actual = VentanaPrincipal.parametrosJlabel("Actual",5, 180, 45,20);
		lbl_Actual.setHorizontalAlignment(SwingConstants.RIGHT);
		panelDetalleProducto.add(lbl_Actual); 												
		
		tfd_Actual = VentanaPrincipal.parametrosJTextField(70, 180, 70, 20);
		panelDetalleProducto.add(tfd_Actual);

		lbl_Minimo = VentanaPrincipal.parametrosJlabel("M\u00EDnimo",5, 240, 45,20);
		lbl_Minimo.setHorizontalAlignment(SwingConstants.RIGHT);
		panelDetalleProducto.add(lbl_Minimo);
		
		tfd_Minimo = VentanaPrincipal.parametrosJTextField(70, 240, 70, 20);
		panelDetalleProducto.add(tfd_Minimo);

		lbl_UnidadMedida = VentanaPrincipal.parametrosJlabel("U. medida",200, 120, 70,20);
		panelDetalleProducto.add(lbl_UnidadMedida);
		
		unidadMedida = new Choice();
		unidadMedida.setBounds(
				Math.round(275*VentanaPrincipal.getCordenadaX()), 		//posicion HORIZONTAL
				Math.round(120*VentanaPrincipal.getCordenadaY()),		//posicion VERTICAL
				Math.round(100*VentanaPrincipal.getCordenadaX()), 		//tamaño HORIZONTAL
				Math.round(20*VentanaPrincipal.getCordenadaY())); 		//tamaño VERTICAL
		unidadMedida.setFont(new Font("Manche Condensed",Font.BOLD,(int)(15*VentanaPrincipal.getCordenadaY())));
		panelDetalleProducto.add(unidadMedida);
		unidadMedida.select("");
		unidadMedida.add("Kg");
		unidadMedida.add("L");
		unidadMedida.add("Ud");

		lbl_Maximo = VentanaPrincipal.parametrosJlabel("M\u00E1ximo",200, 240, 70,20);
		panelDetalleProducto.add(lbl_Maximo);
		
		tfd_Maximo = VentanaPrincipal.parametrosJTextField(275, 240, 70, 20);
		panelDetalleProducto.add(tfd_Maximo);

		btn_Aceptar = VentanaPrincipal.parametrosJButton("Aceptar",140,300,120,40);
		panelDetalleProducto.add(btn_Aceptar);

		panelDetalleProducto.setVisible(false);

	}
	
	
	private void establecerManejador() {
		ControladorDetalleProducto controlador = new ControladorDetalleProducto(this);
		
		btn_volver.addActionListener(controlador);
		btn_Aceptar.addActionListener(controlador);	
		btn_volver.addMouseListener(controlador);
		btn_Aceptar.addMouseListener(controlador);

	}

	public static JPanel getPanelDetalleProducto() {
		return panelDetalleProducto;
	}

	public static void setPanelDetalleProducto(JPanel panelDetalleProducto) {
		DetalleProducto.panelDetalleProducto = panelDetalleProducto;
	}

	public static JButton getBtn_volver() {
		return btn_volver;
	}

	public static void setBtn_volver(JButton btn_volver) {
		DetalleProducto.btn_volver = btn_volver;
	}

	public static JButton getBtn_Aceptar() {
		return btn_Aceptar;
	}

	public static void setBtn_Aceptar(JButton btn_Aceptar) {
		DetalleProducto.btn_Aceptar = btn_Aceptar;
	}

	public static JTextField getTfd_Nombre() {
		return tfd_Nombre;
	}

	public static JTextField getTfd_Actual() {
		return tfd_Actual;
	}

	public static JTextField getTfd_Minimo() {
		return tfd_Minimo;
	}

	public static JTextField getTfd_Maximo() {
		return tfd_Maximo;
	}

	public static Choice getTipo() {
		return tipo;
	}

	public static Choice getUnidadMedida() {
		return unidadMedida;
	}
	
}
