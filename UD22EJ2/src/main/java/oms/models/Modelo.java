package oms.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import oms.conectorDB.*;

public class Modelo {
	
	public Modelo(ConectorDB conector) {
		db = "UD22EJ2";
		conexion = conector;
		conexion.connectDB();
	}
	
	public void insertData(String sql_query) {
		try {
			if(sql_query.length()>=6 && sql_query.substring(0, 6).toUpperCase().equals("INSERT")) {
				String Querydb = "USE "+db+";";
				Statement stdb = conexion.getConnection().createStatement();
				stdb.executeUpdate(Querydb);
				
				String Query = sql_query;
				
				Statement st = conexion.getConnection().createStatement();
				st.executeUpdate(Query);
				System.out.println("Datos guardados");
			}
			else {
				System.out.println("No has entrado una orden de insercion correcta");
			}
		}
		catch(SQLException ex) {
			System.out.println("No se han podido guardar los datos: "+ex.getMessage());
		}
	}
	
	public ResultSet getValues(String sql_query) {
		try {
			if(sql_query.length()>=6 && sql_query.substring(0, 6).toUpperCase().equals("SELECT")) {
				String Querydb = "USE "+db+";";
				Statement stdb = conexion.getConnection().createStatement();
				stdb.executeUpdate(Querydb);
				
				String Query = sql_query;
				Statement st = conexion.getConnection().createStatement();
				ResultSet rs = st.executeQuery(Query);
				return rs;
			}
			else {
				System.out.println("No has entrado una orden de obtencion correcta");
				return null;
			}
		}
		catch(SQLException ex) {
			System.out.println("No se han podido obtener los datos: "+ex.getMessage());
			return null;
		}
	}
	
	public void updateData(String sql_query) {
		try {
			if(sql_query.length()>=6 && sql_query.substring(0, 6).toUpperCase().equals("UPDATE")) {
				String Querydb = "USE "+db+";";
				Statement stdb = conexion.getConnection().createStatement();
				stdb.executeUpdate(Querydb);
				
				String Query = sql_query;
				
				Statement st = conexion.getConnection().createStatement();
				st.executeUpdate(Query);
				System.out.println("Datos actualizados");
				
			}
			else {
				System.out.println("No has entrado una orden de actualizacion correcta");
			}
		}
		catch(SQLException ex) {
			System.out.println("No se han podido actualizar los datos: "+ex.getMessage());
		}
	}
	
	public void deleteRecord(String sql_query) {
		try {
			if(sql_query.length()>=6 && sql_query.substring(0, 6).toUpperCase().equals("DELETE")) {
				String Query = sql_query;
				Statement st = conexion.getConnection().createStatement();
				st.executeUpdate(Query);
				System.out.println("Datos eliminados");
			}
			else {
				System.out.println("No has entrado una orden de eliminacion correcta");
			}
		}
		catch(SQLException ex) {
			System.out.println("No se ha podido eliminar el elemento: "+ex.getMessage());
		}
	}

	
	private ConectorDB conexion;
	private String db;
}
