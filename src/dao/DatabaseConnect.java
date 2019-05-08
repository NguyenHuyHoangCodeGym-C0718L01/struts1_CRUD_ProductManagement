package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnect {

	public static Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/struts?autoReconnect=true&useSSL=false", "root", "ironman1969");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
