<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
		<title>User Page</title>
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
<%
String username = (String)session.getAttribute("username");
if(username  != null && username != " " ){
	%>
	<h3>Welcome Back ,<%=username%></h3>
	<a href="Logout.jsp">Logout</a>
<%	}
else{%>
	<h3>Session Expired</h3>
	<a href="index.html">Go back</a>
<%}
%>
</div>
</body>
</html>