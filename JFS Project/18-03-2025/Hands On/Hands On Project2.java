package project;

import java.sql.*;
import java.util.*;

public class Project1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String url="jdbc:mysql://localhost:3306/testdb";
		System.out.println("Connection Established successfully");
		System.out.println("Enter the Email id : ");
		String mail = sc.next();
		String query = "Select * from users_data where gmail = '" + mail + "';"  ;
		try{
		
			Connection c = DriverManager.getConnection(url,"root","root");
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery(query);
			if (r.next()){
				System.out.println("User found");
				String p= r.getString("pass");
				System.out.println("Enter the password :");
				String pass = sc.next();
				if(pass.equals(p)){
					System.out.println("Welcome Back"+r.getInt("user_id"));
	
				}else{
					System.out.println("Incorrect password");
				}
			}
			else {
				System.out.println("User not found...");
			}
		} 
		catch (SQLException e) {
			System.out.println("Connection Error");;
		}
	}

}


