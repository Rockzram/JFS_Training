package project2;

import java.util.*;
import java.sql.*;

public class Project {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/testdb";
		try {
			Connection c = DriverManager.getConnection(url, "root", "root");
			System.out.println("Connection Established Successfully");
			System.out.println("Enter A Mail ID to create a new Account :");
			String mail = sc.next();
			String query = "Select * from users_data where gmail = '" + mail + "';";
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery(query);
			if (r.next()) {
				System.out.println("Gmail already exist ,Please try again!");
			} else {
				System.out.println("Enter a new password for the entered account :");
				String p = sc.next();
				String query1 = "Insert into users_data(gmail,pass) values ('" + mail + "','" + p + "');";
				int update = s.executeUpdate(query1);
				if (update > 0) {
					System.out.println("Account Created Successfully");
				} else {
					System.out.println("Account Failed to Create");
				}
			}
			s.close();
			r.close();
			c.close();
		} catch (SQLException e) {
			System.out.println("Failed to Connect");
		}

	}

}
