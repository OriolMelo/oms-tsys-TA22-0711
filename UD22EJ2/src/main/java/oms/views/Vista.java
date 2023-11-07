package oms.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btnCreate;
	public JButton btnRead;
	public JButton btnUpdate;
	public JButton btnDelete;
	public JLabel lblNewLabel;
	public JTextArea textAreaOrden;
	private JPanel panelCreate;
	public JTable table;
	public DefaultTableModel model;
	private JScrollPane scrollPane;

	/**
	 * Create the frame.
	 */
	public Vista(DefaultTableModel modelo_tabla) {
		setBounds(100, 100, 860, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCreate = new JButton("Create");
		btnCreate.setBounds(10, 43, 89, 23);
		contentPane.add(btnCreate);
		
		btnRead = new JButton("Read");
		btnRead.setBounds(10, 77, 89, 23);
		contentPane.add(btnRead);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(114, 43, 89, 23);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(114, 77, 89, 23);
		contentPane.add(btnDelete);
		
		panelCreate = new JPanel();
		panelCreate.setBounds(10, 135, 224, 222);
		contentPane.add(panelCreate);
		panelCreate.setLayout(null);
		
		lblNewLabel = new JLabel("Entra la orden sql");
		lblNewLabel.setBounds(10, 0, 270, 14);
		panelCreate.add(lblNewLabel);

		textAreaOrden = new JTextArea();
		textAreaOrden.setBounds(10, 25, 204, 160);
		textAreaOrden.setLineWrap(true);
		textAreaOrden.setWrapStyleWord(true);
		panelCreate.add(textAreaOrden);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(245, 27, 579, 433);
		contentPane.add(scrollPane);
		model = modelo_tabla;
		table = new JTable(model);
		scrollPane.setViewportView(table);
	}
}
