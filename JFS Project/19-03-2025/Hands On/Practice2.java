package practice;

import java.sql.*;

public class Practice2 {

	public static void main(String[] args) {
		String query = "Delete from users where userid=?;";

		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "root");
			System.out.println("Connection Established Successfully");
			PreparedStatement p = c.prepareStatement(query);
			p.setInt(1, 15);
			int delete = p.executeUpdate();
			System.out.println(delete + "rows affected");
			if (delete > 0) {
				System.out.println("Deleted Successfully");
			} else {
				System.out.println("Deletion Failed");

			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}