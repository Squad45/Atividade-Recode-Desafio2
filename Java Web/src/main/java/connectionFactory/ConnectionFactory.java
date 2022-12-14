package connectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/tecnologia_solidaria";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "084Lb21987JsR10k^";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	
	
	public static Connection createConnection() {
		try {
			Class.forName(DRIVER);
			System.out.println("Driver found.");
		}catch(ClassNotFoundException e) {
			System.out.println("Driver not found. " + e.getMessage());
		}
		try {
			Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			System.out.println("Connected to database.");
			return connection;
		}catch(SQLException e) {
			System.out.println("Not connected to database. "+ e.getMessage());
			return null;
		}
	}
}
