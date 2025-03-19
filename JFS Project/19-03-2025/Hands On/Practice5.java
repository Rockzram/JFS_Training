package practice;

import java.sql.*;

public class Practice5 {

	public static void main(String[] args) {
		String query = "Select * from users";
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "root");
			System.out.println("Connection Established");
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery(query);
			ResultSetMetaData m = r.getMetaData();
			System.out.println(m.getColumnCount());
			System.out.println(m.getColumnName(1));
			System.out.println(m.getColumnTypeName(1));
			System.out.println(m.getTableName(1));

		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
