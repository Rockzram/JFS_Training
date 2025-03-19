package practice;

import java.sql.*;

public class Practice3 {

	public static void main(String[] args) {
		String query = "Update users set username = ?,gmail = ?,userpass = ? where userid = ?;";

		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "root");
			System.out.println("Connection Established Successfully");
			PreparedStatement p = c.prepareStatement(query);
			p.setString(1, "Eswaran");
			p.setString(2, "eswaran@gmail.com");
			p.setString(3, "password@135");
			p.setInt(4, 17);
			int update = p.executeUpdate();
			System.out.println(update + "rows affected");
			if (update > 0) {
				System.out.println("Updated Successfully");
			} else {
				System.out.println("Updating Failed");

			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}