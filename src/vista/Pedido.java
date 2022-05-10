package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTable;
import controlador.ControladorPedido;
import modelo.Cliente;
import modelo.SentenciasSQL;

import java.awt.Color;
import java.util.ArrayList;

public class Pedido extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1676364911491454052L;
	
	private static JPanel panelPedido;
	private static JTable table;
	private static JLabel lbl_Num_Mesa;
	private static JButton btn_Guardar;
	private static JButton btn_Volver;
	private static JButton btn_Modificar;
	private static JButton btn_Nuevo;
	private static JButton btn_Eliminar;
	private static JButton btn_Facturar;

	private static int ancho = 800;
	private static int alto = 600;
	private static int posicionPanel_x = 100;
	private static int posicionPanel_y = 50;
	
//************************** LISTA ****************************************************************
	private static JList lista;
    private static JScrollPane scroll;
    private static DefaultListModel modelo = null;
  //************************** LISTA ****************************************************************
	
//*************************** TABLA *******************************************************
	private static JScrollPane scrollTabla = null;
	private static JTable tabla = null;
    
//*****************************TABLA*************************************************************   
    
    
    
    public Pedido() {
		
		panelPedido = new JPanel();
		table = new JTable();
		lbl_Num_Mesa = new JLabel("Mesa 1");
		btn_Guardar = new JButton("Guardar");
		btn_Volver = new JButton("Volver");
		btn_Modificar = new JButton("Modificar cantidad");
		btn_Nuevo = new JButton("Nuevo");
		btn_Eliminar = new JButton("Eliminar");
		btn_Facturar = new JButton("Facturar");
		
//************************ LISTA ******************************************************************
		lista = new JList();
		scroll = new JScrollPane(lista);
//************************* LISTA *****************************************************************	
		
		
//***************************** TABLA *************************************************************
/*
		scrollTabla = new JScrollPane();
		tabla = new JTable();
		*/
//		construirTabla();
//************************** TABLA ****************************************************************
		
		establecerManejador();		
		panelPedido.setVisible(false);
		
		
	}

	public static JPanel inicializarComponentes() {
		
		panelPedido.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelPedido.setBounds(posicionPanel_x, posicionPanel_y, ancho, alto);
		panelPedido.setLayout(null);
		
		lbl_Num_Mesa.setBounds(26, 35, 46, 14);
		panelPedido.add(lbl_Num_Mesa);

		btn_Guardar.setBounds(220, 23, 89, 31);
		panelPedido.add(btn_Guardar);

		btn_Volver.setBounds(335, 11, 89, 23);
		panelPedido.add(btn_Volver);
	
		btn_Modificar.setBounds(99, 213, 119, 23);
		panelPedido.add(btn_Modificar);

		btn_Nuevo.setBounds(26, 213, 63, 23);
		panelPedido.add(btn_Nuevo);

		btn_Eliminar.setBounds(228, 213, 89, 23);
		panelPedido.add(btn_Eliminar);

		btn_Facturar.setBackground(Color.ORANGE);
		btn_Facturar.setBounds(335, 227, 89, 23);
		panelPedido.add(btn_Facturar);
		
		
		
//***************************** LISTA *************************************************************
		
        scroll.setBounds(26, 74, 398, 112);
        panelPedido.add(scroll);
        
//**************************** LISTA **************************************************************
		
        
        
        
        
//************************** TABLA ****************************************************************
        	
      		  /*  		
      		tabla.setBackground(Color.WHITE);
      		tabla.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
      		tabla.setOpaque(false);
     		scrollTabla.setViewportView(tabla);
			table.setModel(new DefaultTableModel(
					SentenciasSQL.listarTabla(),new String[] 
					{"Bebida/Comida", "Cantidad", "Precio"}));
			table.setBounds(47, 48, 343, 134);
			
        
 //       	tabla = crearTablaPedido();
        
			scrollTabla.add(tabla);      		
      		panelPedido.add(scrollTabla);  
      		*/

      		
//************************** TABLA ****************************************************************
  
        
        return panelPedido;
	}
	
	
	public void establecerManejador() {			
		ControladorPedido controlador = new ControladorPedido(this);
		
		btn_Guardar.addActionListener(controlador);
		btn_Volver.addActionListener(controlador);
		btn_Modificar.addActionListener(controlador);
		btn_Nuevo.addActionListener(controlador);
		btn_Eliminar.addActionListener(controlador);
		btn_Facturar.addActionListener(controlador);
		
		
		
//*************************** LISTA ***************************************************************
		lista.addMouseListener(controlador);	
//******************************* LISTA ***********************************************************
		
		
		
//************************** TABLA ****************************************************************
//		tabla.addMouseListener(controlador);
		
//************************** TABLA ****************************************************************
		
		
	}
	
//**************************** LISTA **************************************************************
	public static void datosClientes(ArrayList<Cliente> bbddDatos) {
        modelo = new DefaultListModel();
        Object[] rellenoDatos = bbddDatos.toArray();
        for (int i =0; i<rellenoDatos.length; i++) {        	
        	modelo.addElement(rellenoDatos[i]);        	
        }
        lista.setModel(modelo);
    }
	
	 public static int clienteSeleccionado() throws NullPointerException {
		 int indiceSeleccionado = lista.getSelectedIndex();
		return indiceSeleccionado;		 
	 }	 
	 
	 
	 
	 
//******************************** LISTA ********************************************************** 
	
	 
/*	 
	public static JTable crearTablaPedido () {
		
		try {
			tabla.setBackground(Color.WHITE);
	  		tabla.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
	  		tabla.setOpaque(false);
	 		scrollTabla.setViewportView(tabla);
			table.setModel(new DefaultTableModel(
				SentenciasSQL.listarTabla(),new String[] 
				{"Bebida/Comida", "Cantidad", "Precio"}));
			table.setBounds(47, 48, 343, 134);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return table;
		
	}
*/	 
	 
	 
	 
	
		public static JScrollPane getScrollTabla() {
		return scrollTabla;
	}
	
	public static JTable getTable() {
		return table;
	}

	public static void setTable(JTable table) {
		Pedido.table = table;
	}

	 
	public static JPanel getPanelPedido() {
		return panelPedido;
	}

	public static JButton getBtn_Guardar() {
		return btn_Guardar;
	}

	public static JButton getBtn_Volver() {
		return btn_Volver;
	}

	public static JButton getBtn_Modificar() {
		return btn_Modificar;
	}

	public static JButton getBtn_Nuevo() {
		return btn_Nuevo;
	}

	public static JButton getBtn_Eliminar() {
		return btn_Eliminar;
	}

	public static JButton getBtn_Facturar() {
		return btn_Facturar;
	}

	
}
