<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	<title>Register Page</title>
	<style>
		.main{
			display: flex;
			flex-direction: column;
			align-items: center;
			justify-content: center;
			height: 100vh;
			}
			form > input , form > div{
				margin: 5px;
			}
			.btn{
				width: 100%;
			}
		}	
	</style>
</head>
<body>
	<div class="main">
	<h1>Welcome to the Register Page</h1>
	<form action="RegisterVerify.jsp" method="post">
		<label for="username">UserName</label>
		<br>
		<input type="text" name="username" placeholder="Enter a UserName" required> 
		<br>
		<label for="gmail">Email</label>
		<br>
		<input type="email" name="gmail" placeholder="Enter an Email" required>
		<br>
		<label for="userpass">Password</label>
		<br>
		<input type="password" name="userpass" placeholder="Enter a Password" required>
		<br>
		<div>
		<button type="submit" class="btn btn-primary btn-block">Create a New User</button>
		<br>
		<br>
		<button type="reset" class="btn btn-dark btn-block">Reset the fields</button>
		</div>
	</form>
	<a href="index.html">Login</a>
	</div>
</body>
</html>