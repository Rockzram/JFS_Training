package practice;

import java.sql.*;

public class Practice6 {

	public static void main(String[] args) {
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "root");
			System.out.println("Connection Established");
			DatabaseMetaData dm = c.getMetaData();
			System.out.println(dm.getDriverName());
			System.out.println(dm.getDriverVersion());
			System.out.println(dm.getUserName());
			System.out.println(dm.getDatabaseProductName());
			System.out.println(dm.getDatabaseProductVersion());

		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
