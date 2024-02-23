import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
	static Connection conn;
	
	public static Connection getConnection() {
		String connectionUrl = "jdbc:mysql://localhost:3306/mydb";
		try {
			conn = DriverManager.getConnection(connectionUrl,"root","HoneyPinky@123");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
