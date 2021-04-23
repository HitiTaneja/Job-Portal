<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout</title>
</head>
<body>
	<%     
         session.removeAttribute("userId");
         session.removeAttribute("password");
         session.invalidate();
     %>
	<div style="text-align: center">
		<h1>You have successfully logged out</h1>
		To Login again <a href="S_Login.html">click here</a>.
	</div>
</body>
</html>