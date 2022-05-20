package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.text.Normalizer;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controlador.ControladorBuscarComidaBebida;
import modelo.ModeloComidaBebida;




public class BuscarComidaBebida extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7593766909336348960L;
	
	private static JPanel panelBuscarComidaBebida;
	private static JTextField caja_buscar;
	private static JButton btn_comidas_disponibles;
	private static JButton btn_bebidas_disponibles;
	private static JButton btn_listar_todo;
	private static JButton btn_volver;
	private static JButton btn_buscar;
	private static JButton btn_anadir;
	private static JButton btn_ver_receta;
	private static JTable tabla;
    private static JScrollPane scroll;
	private static ArrayList<ModeloComidaBebida> arrayComidaBebida;
	private static BuscarComidaBebida buscarComidaBebida;

	private static String dato;


    
	public BuscarComidaBebida() {
		inicializarComponentes();
		establecerManejador();
	}


	public void inicializarComponentes() {
		
		arrayComidaBebida = new ArrayList<ModeloComidaBebida>();  
		
		panelBuscarComidaBebida = VentanaPrincipal.parametrosPanel(800,600);

		btn_comidas_disponibles = VentanaPrincipal.parametrosJButton("Comidas Disponibles",50, 30, 150, 20);
		panelBuscarComidaBebida.add(btn_comidas_disponibles);

		btn_bebidas_disponibles = VentanaPrincipal.parametrosJButton("Bebidas Disponibles",220, 30, 150, 20);
		panelBuscarComidaBebida.add(btn_bebidas_disponibles);
		
		btn_listar_todo = VentanaPrincipal.parametrosJButton("Listar todo",390, 30, 89, 20);
		panelBuscarComidaBebida.add(btn_listar_todo);

		btn_volver = VentanaPrincipal.parametrosJButton("Volver", 710, 20, 70, 20);
		panelBuscarComidaBebida.add(btn_volver);
		
		caja_buscar = VentanaPrincipal.parametrosJTextField(50, 65, 287, 20);
		panelBuscarComidaBebida.add(caja_buscar);
		
		btn_buscar = VentanaPrincipal.parametrosJButton("Buscar",350, 65, 65, 20);
		panelBuscarComidaBebida.add(btn_buscar);
		
		btn_anadir = VentanaPrincipal.parametrosJButton("A\u00F1adir",50, 520, 120, 20);
		panelBuscarComidaBebida.add(btn_anadir);
		
		btn_ver_receta = VentanaPrincipal.parametrosJButton("Ver receta",600, 550, 120, 20);
		panelBuscarComidaBebida.add(btn_ver_receta);
		
		tabla = new JTable();
		scroll = VentanaPrincipal.parametrosJScrollPane(50, 100, 700, 400);
		scroll.setViewportView(tabla);
		panelBuscarComidaBebida.add(scroll);		
		panelBuscarComidaBebida.setVisible(false);
	}
	

	public static void establecerManejador() {			
		ControladorBuscarComidaBebida controlador = new ControladorBuscarComidaBebida(buscarComidaBebida);		
		btn_comidas_disponibles.addActionListener(controlador);
		btn_bebidas_disponibles.addActionListener(controlador);
		btn_listar_todo.addActionListener(controlador);
		btn_volver.addActionListener(controlador);
		btn_buscar.addActionListener(controlador);
		btn_anadir.addActionListener(controlador);
		btn_ver_receta.addActionListener(controlador);
		
		tabla.addMouseListener(controlador);
		btn_comidas_disponibles.addMouseListener(controlador);
		btn_bebidas_disponibles.addMouseListener(controlador);
		btn_listar_todo.addMouseListener(controlador);
		btn_volver.addMouseListener(controlador);
		btn_buscar.addMouseListener(controlador);
		btn_anadir.addMouseListener(controlador);
		btn_ver_receta.addMouseListener(controlador);
	}

	public static void listarPedido (ArrayList<ModeloComidaBebida> arrayTabla) {
		 

        arrayComidaBebida = arrayTabla;
        DefaultTableModel modelo =new DefaultTableModel(){
		    @Override
		    public boolean isCellEditable(int row, int column) {	
		       return false;
		    }
		};
        modelo.addColumn("COMIDA/BEBIDA");
        modelo.addColumn("PRECIO");
        modelo.addColumn("ESTADO");
        
        Object filaDato[] = new Object[3];     
        for (int i = 0; i < arrayComidaBebida.size(); i++) {
        	if (ControladorBuscarComidaBebida.isBebida()) {        		
				if (arrayComidaBebida.get(i).getTipo().equals("Bebida")) {
					filaDato[0] = arrayComidaBebida.get(i).getNombreReceta();
					filaDato[1] = arrayComidaBebida.get(i).getPrecioVenta();
					filaDato[2] = arrayComidaBebida.get(i).getEstado();
					modelo.addRow(filaDato);
				}    
        		
			} else if (ControladorBuscarComidaBebida.isComida()) {				
				if (ControladorBuscarComidaBebida.isComida()) {
					
					if (arrayComidaBebida.get(i).getTipo().equals("Comida")) {
						filaDato[0] = arrayComidaBebida.get(i).getNombreReceta();
						filaDato[1] = arrayComidaBebida.get(i).getPrecioVenta();
						filaDato[2] = arrayComidaBebida.get(i).getEstado();
						modelo.addRow(filaDato);
					}
				}			
				
			} else if (ControladorBuscarComidaBebida.isBuscar()) {
					
				if (compruebaMayusculasTildes (caja_buscar.getText()).contains(
						compruebaMayusculasTildes (arrayComidaBebida.get(i).getNombreReceta()))) {	
					filaDato[0] = arrayComidaBebida.get(i).getNombreReceta();
					filaDato[1] = arrayComidaBebida.get(i).getPrecioVenta();
					filaDato[2] = arrayComidaBebida.get(i).getEstado();
					modelo.addRow(filaDato);					
				}	
			}			
			else {
				filaDato[0] = arrayComidaBebida.get(i).getNombreReceta();
				filaDato[1] = arrayComidaBebida.get(i).getPrecioVenta();
				filaDato[2] = arrayComidaBebida.get(i).getEstado();
				modelo.addRow(filaDato);
			}
        	
		}
        ControladorBuscarComidaBebida.setBuscar(false);
    	ControladorBuscarComidaBebida.setComida(false);
    	ControladorBuscarComidaBebida.setBebida(false);
    	
    	
    	
    	
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
        tabla = VentanaPrincipal.formatoTabla(tabla);
        
        tabla.getColumnModel().getColumn(0).setPreferredWidth(550);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(50);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(100);
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
			JOptionPane.showMessageDialog(panelBuscarComidaBebida, "Debes de selecionar algo de la lista antes");
		}
		return dato;		
	}
	
	// Metodo que pasa las letras a minusculas y llama al metodo que elimina Tildes
	public static String compruebaMayusculasTildes (String palabra) {
		String datoLimpio = borrarTilde(palabra);
		datoLimpio=datoLimpio.toLowerCase();
		return datoLimpio;		
	}

	// Metodo para eliminar las tildes
    public static String borrarTilde(String texto) {    	
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");        
        return texto;
    } 
	
	public static JPanel getPanelBuscarComidaBebida() {
		return panelBuscarComidaBebida;
	}


	public static JButton getBtn_comidas_disponibles() {
		return btn_comidas_disponibles;
	}


	public static JButton getBtn_bebidas_disponibles() {
		return btn_bebidas_disponibles;
	}


	public static JButton getBtn_listar_todo() {
		return btn_listar_todo;
	}


	public static JButton getBtn_volver() {
		return btn_volver;
	}


	public static JButton getBtn_buscar() {
		return btn_buscar;
	}


	public static JButton getBtn_anadir() {
		return btn_anadir;
	}


	public static JButton getBtn_ver_receta() {
		return btn_ver_receta;
	}

	public static JTable getTabla() {
		return tabla;
	}
	
}
