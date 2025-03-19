package practice;

import java.sql.*;

public class Practice {

	public static void main(String[] args) {
		String query = "Insert into users (username,gmail,userpass) values (?,?,?);";

		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "root");
			System.out.println("Connection Established Successfully");
			PreparedStatement p = c.prepareStatement(query);
			p.setString(1, "Eswar1");
			p.setString(2, "eswar123@gmail.com");
			p.setString(3, "Password564");
			int insert = p.executeUpdate();
			System.out.println(insert + "rows affected");
			if (insert > 0) {
				System.out.println("Inserted Successfully");
			} else {
				System.out.println("Inserting Failed");

			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
