package vista;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

import javax.swing.JTable;
import javax.swing.UIManager;

import controlador.ControladorGestionPedidos;
import modelo.BbddVentas;
import modelo.ModeloCliente;



public class GestionPedidos extends JPanel {

	private static final long serialVersionUID = 1469803496498262897L;
	
	private static JPanel panelGestionPedidos;
	private static JLabel lbl_mesa;
	private static JLabel lbl_Para_llevar;
	private static JButton btn_Mesa_1;
	private static JButton btn_Mesa_2;
	private static JButton btn_Mesa_3;
	private static JButton btn_Mesa_4;
	private static JButton btn_Mesa_8;
	private static JButton btn_Mesa_7;
	private static JButton btn_Mesa_6;
	private static JButton btn_Mesa_5;	
	private static JButton btn_Nuevo_Cliente;
	private static JButton btn_Editar_Cliente;
	private static JButton btn_Ver_Pedido;
	private static JButton btn_volver;

	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;

//**************************************************************************************************
	private static JList listaCliente;
    private static JScrollPane scrollCliente;
    
    private static ArrayList<ModeloCliente> array_clientes;
    private static DefaultListModel modeloListaCliente;
    
//**************************************************************************************************
	
	public GestionPedidos() {
		super();
		inicializarComponentes();
		establecerManejador();
	}


	
	public void inicializarComponentes() {		
		
		panelGestionPedidos = new JPanel();
		panelGestionPedidos.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelGestionPedidos.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		panelGestionPedidos.setLayout(null);
		panelGestionPedidos.setVisible(false);

		btn_Mesa_1 = new JButton("Mesa 1 ");		
		btn_Mesa_1.setBounds(10, 70, 107, 23);
		panelGestionPedidos.add(btn_Mesa_1);
		
		btn_Mesa_2 = new JButton("Mesa 2");		
		btn_Mesa_2.setBounds(142, 70, 89, 23);
		panelGestionPedidos.add(btn_Mesa_2);
		
		btn_Mesa_3 = new JButton("Mesa 3");	
		btn_Mesa_3.setBounds(10, 110, 107, 23);
		panelGestionPedidos.add(btn_Mesa_3);
		
		btn_Mesa_4 = new JButton("Mesa 4");	
		btn_Mesa_4.setBounds(142, 110, 89, 23);
		panelGestionPedidos.add(btn_Mesa_4);

		
		btn_Mesa_7 = new JButton("Mesa 7");	
		btn_Mesa_7.setBounds(10, 192, 107, 23);
		panelGestionPedidos.add(btn_Mesa_7);
		
		btn_Mesa_6 = new JButton("Mesa 6");	
		btn_Mesa_6.setBounds(142, 152, 89, 23);
		panelGestionPedidos.add(btn_Mesa_6);
		
		btn_Mesa_5 = new JButton("Mesa 5");	
		btn_Mesa_5.setBounds(10, 152, 107, 23);
		panelGestionPedidos.add(btn_Mesa_5);
		
		btn_Mesa_8 = new JButton("Mesa 8");
		btn_Mesa_8.setBounds(142, 192, 89, 23);
		panelGestionPedidos.add(btn_Mesa_8);

		lbl_mesa = new JLabel("En mesa");
		lbl_mesa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_mesa.setBounds(83, 30, 70, 14);
		panelGestionPedidos.add(lbl_mesa);
		
		lbl_Para_llevar = new JLabel("Para llevar");
		lbl_Para_llevar.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_Para_llevar.setBounds(287, 30, 70, 14);
		panelGestionPedidos.add(lbl_Para_llevar);	
		
		btn_Nuevo_Cliente = new JButton("Nuevo Cliente");
		btn_Nuevo_Cliente.setBounds(278, 46, 107, 23);
		panelGestionPedidos.add(btn_Nuevo_Cliente);
		
		btn_Editar_Cliente = new JButton();
		btn_Editar_Cliente.setForeground(UIManager.getColor("Button.background"));
		btn_Editar_Cliente.setIcon(new ImageIcon("img/settings.png"));
		btn_Editar_Cliente.setBounds(395, 46, 26, 24);
		btn_Editar_Cliente.setEnabled(false);
		panelGestionPedidos.add(btn_Editar_Cliente);
		
		btn_volver = new JButton("Volver");
		btn_volver.setBounds(354, 9, 70, 19);
		panelGestionPedidos.add(btn_volver);		

		btn_Ver_Pedido = new JButton("Ver Pedido");
		btn_Ver_Pedido.setBounds(142, 254, 89, 23);
		panelGestionPedidos.add(btn_Ver_Pedido);

		listaCliente = new JList();
		listaCliente.setLayout(null);
		listaCliente.setVisible(true);		
		
		scrollCliente = new JScrollPane(listaCliente);	
        scrollCliente.setBounds(269, 74, 155, 145);
        scrollCliente.setViewportView(listaCliente);
        panelGestionPedidos.add(scrollCliente);	
	}
	
	public void establecerManejador() {			
		ControladorGestionPedidos controlador = new ControladorGestionPedidos(this);
		btn_Mesa_1.addActionListener(controlador);
		btn_Mesa_2.addActionListener(controlador);
		btn_Mesa_3.addActionListener(controlador);
		btn_Mesa_4.addActionListener(controlador);
		btn_Mesa_8.addActionListener(controlador);
		btn_Mesa_7.addActionListener(controlador);
		btn_Mesa_6.addActionListener(controlador);
		btn_Mesa_5.addActionListener(controlador);	
		btn_Nuevo_Cliente.addActionListener(controlador);
		btn_Editar_Cliente.addActionListener(controlador);
		btn_volver.addActionListener(controlador);

		btn_Ver_Pedido.addActionListener(controlador);		
		listaCliente.addMouseListener(controlador);
	}


	
	public static ArrayList<ModeloCliente> creaListaClientes() {
		BbddVentas.listarClientes();
		array_clientes = BbddVentas.getArrayClientes();
		modeloListaCliente = new DefaultListModel();

		for (ModeloCliente c : array_clientes) {
			System.out.println("IdCliente: "+c.getId()); // <-- BORRAR
			// no añadimos a la lista los primeros ID porque son mesas
			if (c.getId()>=9) {
				System.out.println(" NO es MESA ->  "+c.getId()); // <-- BORRAR
				modeloListaCliente.addElement(c.toString());
			}
		}	

		listaCliente.setModel(modeloListaCliente);
		return array_clientes;
	}
	
	
	 public static int clienteSeleccionado() throws NullPointerException {
		 int indiceSeleccionado = listaCliente.getSelectedIndex();
		return indiceSeleccionado;		 
	 }

	public static JButton getBtn_Mesa_1() {
		return btn_Mesa_1;
	}

	public static JButton getBtn_Mesa_2() {
		return btn_Mesa_2;
	}

	public static JButton getBtn_Mesa_3() {
		return btn_Mesa_3;
	}

	public static JButton getBtn_Mesa_4() {
		return btn_Mesa_4;
	}

	public static JButton getBtn_Mesa_8() {
		return btn_Mesa_8;
	}

	public static JButton getBtn_Mesa_7() {
		return btn_Mesa_7;
	}

	public static JButton getBtn_Mesa_6() {
		return btn_Mesa_6;
	}

	public static JButton getBtn_Mesa_5() {
		return btn_Mesa_5;
	}

	public static JButton getBtn_Nuevo_Cliente() {
		return btn_Nuevo_Cliente;
	}

	public static JButton getBtn_Editar_Cliente() {
		return btn_Editar_Cliente;
	}

	public static JButton getBtn_Ver_Pedido() {
		return btn_Ver_Pedido;
	}

	public static JButton getBtn_volver() {
		return btn_volver;
	}

	public static JPanel getPanelGestionPedidos() {
		return panelGestionPedidos;
	}


	public static JList getListaCliente() {
		return listaCliente;
	}
	
}