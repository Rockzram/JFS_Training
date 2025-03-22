<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"rel="stylesheet"integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"crossorigin="anonymous">
<title>All User's List</title>
	<style>
		.center {
			display: flex;
			flex-direction: column;
			align-items: center;
			padding-top: 50px;
			height: 100vh;
				}
	</style>
</head>
<body>
	<div class="center">
		<%@page import="java.sql.*" %>
		<%@page import="com.mysql.jdbc.Driver"%>
		<h3>All Users</h3>
		<table class="table table-bordered table-sm" style="width: 50%;">
			<thead>
				<tr>
					<th>User Name</th>
					<th>User Email</th>
					<th>User Password</th>
		<tbody>
			<%
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","root");
				Statement s = c.createStatement();
				ResultSet r = s.executeQuery("select * from users_data1");
				while(r.next()){
					String username = r.getString("username");
					String email = r.getString("gmail");
					String userpass = r.getString("userpass");
					%>
					  	<tr>
								<td><%=username %></td>
								<td><%=email %></td>
								<td><%=userpass %></td>
							</tr>
					<% } 
						}
			catch(Exception e){
				System.out.println(e);
			}
			%>
		</tbody>
		</table>	
	</div>
</body>
</html>