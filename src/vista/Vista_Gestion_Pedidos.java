package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

public class Vista_Gestion_Pedidos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	JLabel lbl_mesa = new JLabel("En mesa");
	JButton btn_Mesa_1 = new JButton("Mesa 1 ");
	JButton btn_Mesa_2 = new JButton("Mesa 2");
	JButton btn_Mesa_3 = new JButton("Mesa 3");
	JButton btn_Mesa_4 = new JButton("Mesa 4");
	JButton btn_Mesa_5 = new JButton("Mesa 5");
	JButton btn_Mesa_6 = new JButton("Mesa 6");
	JButton btn_Mesa_7 = new JButton("Mesa 7");
	JButton btn_Mesa_8 = new JButton("Mesa 8");
	JButton btn_Nuevo_Cliente = new JButton("Nuevo Cliente");
	JButton btn_ajustes = new JButton("");
	JButton btn_volver = new JButton("Volver");
	JLabel lbl_Para_llevar = new JLabel("Para llevar");
	JButton btn_Pedido = new JButton("Ver Pedido");


	
	

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Vista_Gestion_Pedidos frame = new Vista_Gestion_Pedidos();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Vista_Gestion_Pedidos() {
		setTitle("Gestion de Pedidos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		btn_Mesa_1.setBounds(10, 70, 107, 23);
		contentPane.add(btn_Mesa_1);
		
		
		btn_Mesa_2.setBounds(142, 70, 89, 23);
		contentPane.add(btn_Mesa_2);
		
		btn_Mesa_4.setBounds(142, 110, 89, 23);
		contentPane.add(btn_Mesa_4);
		
		
		btn_Mesa_3.setBounds(10, 110, 107, 23);
		contentPane.add(btn_Mesa_3);
		
		
		btn_Mesa_8.setBounds(142, 192, 89, 23);
		contentPane.add(btn_Mesa_8);
		
		
		btn_Mesa_7.setBounds(10, 192, 107, 23);
		contentPane.add(btn_Mesa_7);
		
		
		btn_Mesa_6.setBounds(142, 152, 89, 23);
		contentPane.add(btn_Mesa_6);
		
		
		btn_Mesa_5.setBounds(10, 152, 107, 23);
		contentPane.add(btn_Mesa_5);
		
		
		lbl_mesa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_mesa.setBounds(83, 30, 70, 14);
		contentPane.add(lbl_mesa);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"New column"
			}
		));
		table.setBounds(269, 74, 155, 145);
		contentPane.add(table);
		
		
		btn_Nuevo_Cliente.setBounds(278, 46, 107, 23);
		contentPane.add(btn_Nuevo_Cliente);
		
		
		btn_ajustes.setForeground(UIManager.getColor("Button.background"));
		btn_ajustes.setIcon(new ImageIcon("img\settings.png"));
		btn_ajustes.setBounds(395, 46, 26, 24);
		contentPane.add(btn_ajustes);
		
		btn_volver.setBounds(354, 9, 70, 19);
		contentPane.add(btn_volver);
		
		lbl_Para_llevar.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_Para_llevar.setBounds(287, 30, 70, 14);
		contentPane.add(lbl_Para_llevar);
		
		btn_Pedido.setBounds(142, 254, 89, 23);
		contentPane.add(btn_Pedido);
	}

}
