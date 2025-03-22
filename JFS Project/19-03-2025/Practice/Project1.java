package task;

import java.sql.*; 
import java.util.*;

public class Project1 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try{
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/eventsdb","root","root");
//			System.out.println("Connected Successfully");
			System.out.println("Welcome To Raider Event \n To Continue On Please Select From The Given Options:");
			System.out.println(" 1.Sign Up As New Student \n 2.Login As Existing Student \n 3.Login As the Teacher \n 4.Exit ");
			int choice = sc.nextInt();
			if(choice == 1){
				System.out.println(" Thank You For Participating In Raider Events \n To Continue, Please Enter The Required Details In The Given Fields");
				String query = "Insert into user_details (part_regno,part_name,part_no,part_event,part_team,part_mail,part_college,part_pass) values (?,?,?,?,?,?,?,?);";
				PreparedStatement p = c.prepareStatement(query);
				System.out.println(" Enter Your Register Number :");
				int part_reg = sc.nextInt();
				p.setInt(1, part_reg);
				System.out.println(" Enter Your Name :");
				String part_name = sc.next();
				p.setString(2, part_name);
				System.out.println(" Enter Your Particpation No :");
				int part_no = sc.nextInt();
				p.setInt(3, part_no);
				System.out.println(" Enter The Event You Are Participating :");
				String part_event = sc.next();
				p.setString(4, part_event);
				System.out.println(" Enter Your Team Name :");
				String part_team = sc.next();
				p.setString(5, part_team);
				System.out.println(" Enter Your Email :");
				String part_mail = sc.next();
				p.setString(6, part_mail);
				System.out.println(" Enter Your College Name :");
				String part_college = sc.next();
				p.setString(7, part_college);
				System.out.println(" Enter A Password To Secure Your Account : ");
				String part_pass = sc.next();
				p.setString(8, part_pass);
				int inserted = p.executeUpdate();
				if(inserted > 0){
					System.out.println(" Thank You For Signing Up For The Event. See You At The Event");
				}else{
					System.out.println(" Sorry, There Was An Error. Please Try Again.");
				}
			}
			else if (choice == 2){
				System.out.println(" Welcome Contestant \n To Login To Your Account, Please Enter Your Regno :");
				int log = sc.nextInt();
				String query1 ="Select * from user_details where part_regno = '" + log + "';";
				Statement s = c.createStatement();
				ResultSet r = s.executeQuery(query1);
				if(r.next()){
					String ps = r.getString("part_pass"); 
					System.out.println("Enter Your PassWord : ");
					String pass = sc.next();
					if(pass.equals(ps)){
						System.out.println("Welcome Back :"+ r.getString("part_name") );
						System.out.println("Here's All Your Details : " +r.getInt("part_no")+
											"\nThe Event You are Participating is:"+r.getString("part_event")+
											"\nThe Team You Are Part Of :"+r.getString("part_team")+
											"\nThe Mail You Have Registered is :" +r.getString("part_mail")+
											"\nThe College You Are Part Of :" +r.getString("part_college"));
						System.out.println(" To Edit Your Account, Please Type Yes or No");
						String choose = sc.next();
						if (choose.equalsIgnoreCase("yes")){
							System.out.println(" To Edit Your Profile \n Choose 1.Edit Your Register Number \n 2.Edit Your");
						}else{
							
						}
					}else{
						System.out.println(" Sorry, You Have Entered The Wrong Password..");
					}
				}
					else{
						System.out.println(" Sorry The Entered Regno Is Not In The Events, Please Try Again");
					}
				
			}
			else if(choice == 3){
				System.out.println(" Welcome To The Teacher's Login Page \n Please Enter Your Name: ");
				String log1 = sc.next();
				String query2 ="Select * from teacher_details where teach_regno = '" + log1 +"';";
				Statement s1 = c.createStatement();
				ResultSet r1 = s1.executeQuery(query2);
				if(r1.next()){
					String ps1 = r1.getString("teach_pass");
					System.out.println(" Enter Your PassWord :");
					String pass1 = sc.next();
					if(pass1.equals(ps1)){
						System.out.println("Welcome Back :" + r1.getString("teach_name"));
						System.out.println("Here's All Your Details : " +r1.getInt("teach_regno")+
									       "\nDepartment You Are From :"+r1.getString("teach_dept")+
									       "\nYour Email Id :"+r1.getString("teach_mail"));
						System.out.println(" To Update Your Email, Type Yes Or No : ");
						String Choice3 = sc.next();
					}else{
						System.out.println("You Have Entered The Wrong Password, Please Try Again..");
					}
				}else{
					System.out.println("Sorry The Entered Name Does Not Exist...");
				}
			}
			else{
				System.out.println("");
			}
		}catch(SQLException e){
			System.out.println(e);
		}

	}

}
