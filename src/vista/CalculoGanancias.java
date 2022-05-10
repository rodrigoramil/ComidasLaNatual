package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorCalculoGanancias;

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

	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;

	private static JList listaCalculoGanancias;
    private static JScrollPane scrollCalculoGanancias;
    
	public CalculoGanancias() {
		super();
		inicializarComponentes();
		establecerManejador();		
		
	}

	public void inicializarComponentes() {
		
		panelCalculoGanancias = new JPanel();
		btn_Volver = new JButton("Volver");
		lbl_Desde = new JLabel("Desde");		
		lbl_Hasta = new JLabel("Hasta");
		tfd_Desde = new JTextField();
		tfd_hasta = new JTextField();
		lbl_Total_Ganancias = new JLabel("Total Ganancias");
		lbl_Calculo_Ganancias = new JLabel("284,76");
		btn_Imprimir = new JButton("Imprimir");
		
		panelCalculoGanancias.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelCalculoGanancias.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		panelCalculoGanancias.setLayout(null);
		panelCalculoGanancias.setVisible(false);
		
		btn_Volver.setBounds(348, 11, 76, 23);
		panelCalculoGanancias.add(btn_Volver);

		lbl_Desde.setBounds(10, 64, 46, 14);
		panelCalculoGanancias.add(lbl_Desde);

		lbl_Hasta.setBounds(10, 95, 46, 14);
		panelCalculoGanancias.add(lbl_Hasta);

		tfd_Desde.setBounds(48, 61, 86, 20);
		panelCalculoGanancias.add(tfd_Desde);
		tfd_Desde.setColumns(10);

		tfd_hasta.setBounds(48, 92, 86, 20);
		panelCalculoGanancias.add(tfd_hasta);
		tfd_hasta.setColumns(10);

		lbl_Total_Ganancias.setBounds(30, 161, 86, 14);
		panelCalculoGanancias.add(lbl_Total_Ganancias);

		lbl_Calculo_Ganancias.setBounds(40, 186, 46, 14);
		panelCalculoGanancias.add(lbl_Calculo_Ganancias);

		btn_Imprimir.setBounds(185, 210, 76, 23);
		panelCalculoGanancias.add(btn_Imprimir);
		
		listaCalculoGanancias = new JList();
	    listaCalculoGanancias.setLayout(null);
	    listaCalculoGanancias.setVisible(true);		
		
	    scrollCalculoGanancias = new JScrollPane(listaCalculoGanancias);	
	    scrollCalculoGanancias.setBounds(185, 51, 228, 148);
	    scrollCalculoGanancias.setViewportView(listaCalculoGanancias);
	    panelCalculoGanancias.add(scrollCalculoGanancias);	
	}

	public void establecerManejador() {			
		ControladorCalculoGanancias controlador = new ControladorCalculoGanancias(this);
		
		listaCalculoGanancias.addMouseListener(controlador);
		tfd_Desde.addMouseListener(controlador);
		tfd_hasta.addMouseListener(controlador);
		lbl_Calculo_Ganancias.addMouseListener(controlador);		
		btn_Volver.addActionListener(controlador);
		btn_Imprimir.addActionListener(controlador);

	}

	/*	
 	// Hay que modificar el metodo que accede a los Usuarios de la BBDD

	public static ArrayList<ModeloUsuario> creaListaUsuarios() {
		SentenciasSQL.leerClientesBBDD();
		arrayUsuarios = SentenciasSQL.getArrayUsuarios();
		modelo = new DefaultListModel();
		for (ModeloUsuario c : arrayUsuarios) {
			modelo.addElement(c.toString());
		}
		listaGestionUsuarios.setModel(modelo);
		return arrayUsuarios;
	}
		
	 public static int usuarioSeleccionado() throws NullPointerException {
		 int indiceSeleccionado = listaUsuarios.getSelectedIndex();
		return indiceSeleccionado;		 
	 }
*/

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

	public static JList getListaCalculoGanancias() {
		return listaCalculoGanancias;
	}	
		
}
