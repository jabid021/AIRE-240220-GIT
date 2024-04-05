<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Appli Quest</title>
<style>#navbar{display:none;} .error{color:red;}</style>
</head>
<body>


<h1>Appli QUEST</h1>

<form action="home" method="POST">
	<input type="email" placeholder="Saisir votre email" name="email" required>
	<input type="password" placeholder="Saisir votre password" name="password" required>
	<input type="submit" value="Se connecter">
	<div class="error">${error}</div>
</form>




</body>
</html>
