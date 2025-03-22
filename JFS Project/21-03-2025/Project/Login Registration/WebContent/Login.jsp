<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
		<title>Login Page</title>
		<style>
		.main{
			display: flex;
			flex-direction: column; 
			align-items: center;
			justify-content: center;
			height: 100vh;
		}
		</style>
	</head>
	<body>
	<div class=main>
<%@page import = " java.sql.* "%>
<%
try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","root");
//	out.println("Connection Established Successfully");
	String usermail = request.getParameter("Usermail");
	String userpass = request.getParameter("Userpass");
	String query ="Select * from users_data1 where gmail=? and userpass=?;";
	PreparedStatement p = c.prepareStatement(query);
	p.setString(1, usermail);
	p.setString(2, userpass);
	ResultSet r = p.executeQuery();
	if(r.next()){
		session.setAttribute("userid",r.getInt("userid"));
		session.setAttribute("username",r.getString("username"));
//		session.setAttribute("usermail",usermail);
//		session.setAttribute("userpass",userpass);
		response.sendRedirect("Success.jsp");
		
	}else{%>
		<h3>User not found</h3>
		<a href='index.html'>Login</a>
		<%
	}
}catch(SQLException e){
	System.out.println(e);
}
%>
</div>
</body>
</html>