<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Verification</title>
<style>
.main {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	height: 100vh;
}
</style>
</head>
<body>
	<div class="main">
		<%@page import="java.sql.*"%>
		<%@page import="com.mysql.jdbc.Driver"%>
		<%
		try{
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","root");
			String username = request.getParameter("username");
			String email = request.getParameter("gmail");
			String userpass = request.getParameter("userpass");
			String query ="select * from users_data1 where gmail=?;";
			PreparedStatement p = c.prepareStatement(query);
			p.setString(1,email);
			ResultSet r = p.executeQuery();
			if(r.next()){%>
		<h2>User is already registered with an account</h2>
		<h3>Please Login again with registered account</h3>
		<a href="index.html">Login</a>
		<%}else{
				String query1 = "insert into users_data1(username,gmail,userpass) values (?,?,?);";
				p= c.prepareStatement(query1);
				p.setString(1,username);
				p.setString(2,email);
				p.setString(3,userpass);
				int update = p.executeUpdate();
				if(update > 0){%>
		<h3>User Added Successfully</h3>
		<a href="index.html">Go To Login</a>
		<%} 
				else { %>
		<h3>Failed to add the User</h3>
		<a href="index.html">Go To Login</a>
		<%}
			}
			}catch(SQLException e){
			System.out.println(e);
		}
		%>
	</div>
</body>
</html>