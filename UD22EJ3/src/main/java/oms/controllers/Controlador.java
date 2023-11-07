package oms.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import oms.models.Modelo;
import oms.views.Vista;

public class Controlador implements ActionListener{
	private Vista vista;
	private Modelo modelo;
	
	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.vista.btnCreate.addActionListener(this);
		this.vista.btnRead.addActionListener(this);
		this.vista.btnUpdate.addActionListener(this);
		this.vista.btnDelete.addActionListener(this);
	}
	
	public void iniciarVista() {
		vista.setTitle("Gestor");
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vista.setLocationRelativeTo(null);
		vista.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent evento) {
		String orden = vista.textAreaOrden.getText();
		if(vista.btnCreate==evento.getSource()) {
			modelo.insertData(orden);
		}
		else if(vista.btnRead==evento.getSource()) {
			ResultSet rs = modelo.getValues(orden);
			crearTablaMuestra(rs);
		}
		else if(vista.btnUpdate==evento.getSource()) {
			modelo.updateData(orden);
		}
		else if(vista.btnDelete==evento.getSource()) {
			modelo.deleteRecord(orden);
		}
	}
	
	public void crearTablaMuestra(ResultSet rs) {
		try {
			vista.model = new DefaultTableModel();
			ResultSetMetaData rsmd = rs.getMetaData();
			for (int i = 0; i < rsmd.getColumnCount(); i++) {
	
				vista.model.addColumn(rsmd.getColumnLabel(i+1));
	
			}
			vista.table.setModel(vista.model);
			int num_atributos = rsmd.getColumnCount();
			while(rs.next()) {
				Vector<String> fila = new Vector<String>();
				for(int i=0; i<num_atributos; i++) {
					String nombre_columna = rsmd.getColumnLabel(i+1);
					fila.add(rs.getString(nombre_columna));
				}
				vista.model.addRow(fila);
			}
		}
		catch(SQLException ex) {
			System.out.println("No se han podido obtener los datos: "+ex.getMessage());
		}
	}
}
