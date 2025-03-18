package package1;
import java.sql.*; 
public class Practice {

	public static void main(String[] args) {
	String query="Select gmail,pass from users_data where user_id=513;";	
	String url="jdbc:mysql://localhost:3306/testdb";
	String user="root";
	String password="root";
	try {
		Connection c=DriverManager.getConnection(url, user, password);
		System.out.println("Connection established successfully");
		Statement s = c.createStatement();
		ResultSet r = s.executeQuery(query);
		while(r.next()){
//			int id = r.getInt("user_id");
			String em = r.getString("gmail");
			String p = r.getString("pass");
			System.out.println(" "+em+" "+p);
		}
	} catch (SQLException e) {
		System.out.println("Connection error");
	}
	}

}
