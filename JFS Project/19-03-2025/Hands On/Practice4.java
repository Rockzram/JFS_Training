package practice;

import java.sql.*;

public class Practice4 {

	public static void main(String[] args) {
		String query = "Select * from users;";
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "root");
			PreparedStatement p = c.prepareStatement(query);
			ResultSet r = p.executeQuery(query);
			while (r.next()) {
				System.out.println(r.getInt("userid") + " " +
						r.getString("username") + " " +
						r.getString("gmail") + " " +
						r.getString("userpass")); 

			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
