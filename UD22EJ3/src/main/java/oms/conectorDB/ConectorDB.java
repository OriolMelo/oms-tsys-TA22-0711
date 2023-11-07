package oms.conectorDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConectorDB {
	
	public ConectorDB() {
		conexion = null;
	}
	
	public Connection connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306?useTimeZone=true&serverTimezone=UTC", "root", "password");
			System.out.println("Server Connected");
		}
		catch(SQLException | ClassNotFoundException ex) {
			System.out.println("No se ha podido conectar con mi base de datos");
			System.out.println(ex);
		}

		return conexion;
	}
	
	public void closeConnection() {
		try {
			conexion.close();
			JOptionPane.showMessageDialog(null, "Se ha finalizado la conexion con el servidor");
		}
		catch(SQLException ex) {
			System.out.println("Error al desconectar de la base de datos : "+ex.getMessage());
		}
	}
	
	public Connection getConnection() {
		return conexion;
	}
	
	private Connection conexion;
}
