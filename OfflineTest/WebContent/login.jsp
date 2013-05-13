<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org   /TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cache Test</title>
</head>
<body>
	<form action="ControllerServlet" method="post">
		<table>
			<tr>
				<td>User Id:</td>
				<td><input type="text" name="user_id" /><br></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"><br>
				</td>
			</tr>
			<br>
		</table>
		<br> <input type="hidden" name="form_action" value="login" /> <input
			type="submit" value="submit" /><br>
	</form>
</body>
</html>