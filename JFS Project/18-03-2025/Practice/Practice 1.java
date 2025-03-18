package project1;

import java.sql.*;
import java.util.*;

public class project {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/testdb";
		try{
			Connection c = DriverManager.getConnection(url,"root", "root");
			System.out.println("Connected to the server successfully");
			System.out.println("Enter the Email to acces the Account :");
			String mail = sc.next();
			String query = "Select * from users_data where gmail='" + mail + "';";
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery(query);
			if(r.next()){
				String pass = r.getString("pass");
				System.out.println("UserName Found Please Enter the Password :");
				String p = sc.next();
				if (p.equals(pass)){
					System.out.println("Deleting the user from database...");
					String query1 = "Delete from users_data where gmail = '"+mail+"';";
					int delete = s.executeUpdate(query1);
					if(delete > 0){
						System.out.println("Account Deleted Successfully");
					}else{
						System.out.println("Account Deletion Failed");
					}
				}else{
					System.out.println("Wrong Password");
				}
			}else{
				System.out.println("Account Not Found");
			}
			s.close();
			r.close();
			c.close();
		}catch(SQLException e){
			System.out.println("Failed to Connect to Server");
		}

	}

}
