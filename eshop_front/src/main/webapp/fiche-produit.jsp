<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fiche du Produit ${prod.id} </title>
</head>
<body>
<table>


<tr><th>ID</th><th>Libelle</th><th>Prix</th></tr>
<tr><td>${prod.id}</td><td>${prod.libelle}</td><td>${prod.prix}€</td></tr>


</table>


<form action="produit" method="POST">
	<input type="text" name="libelle">
	<input type="number" name="prix" step="0.01">
	<input type="submit" value="Ajouter Produit">
</form>
</body>
</html>