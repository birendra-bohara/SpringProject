<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://www.google.com/recaptcha/api.js" async defer></script>
<link rel="stylesheet" href="resources/css/style.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="login">
		<div class="login-triangle"></div>

		<h2 class="login-header">Log in</h2>

		<form class="login-container" action="userlogin" method="post">
			<p style="color: red">${error}</p>
			<p>
				<input type="text" name="username" placeholder="Username">
			</p>
			<p>
				<input type="password" name="password" placeholder="Password">
			</p>

			<div class="g-recaptcha"
				data-sitekey="6LcmyK4UAAAAAE3k2KITcLMXmysA7EAYtJj4_iHm"></div>
			<p>
				<input type="submit" value="Log in">
			</p>

			<a href="facebook">LoginwithFacebook</a>

			<p>
				<a href="usersignup">Sigup</a>
			</p>
		</form>
	</div>
</body>
</html>