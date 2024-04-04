<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fiche Fournisseur ${fournisseur.id}</title>
</head>
<body>

<h1>Informations du fournisseur : </h1>
<!--  id, nom, prenom, adresse (numero,voie,ville,cp), societe -->

<p> ${fournisseur.id} - ${fournisseur.nom} -${fournisseur.prenom}</p>
<p>${fournisseur.adresse.numero} ${fournisseur.adresse.voie}, ${fournisseur.adresse.cp} ${fournisseur.adresse.ville}
<p>${fournisseur.societe}</p>
<!-- Form qui permet de saisir  nom, prenom, adresse (numero,voie,ville,cp), societe -->


<form action="fournisseur" method="POST">

<input required type="text" name="nom" placeholder="Saisir votre nom"><br>
<input required type="text" name="prenom" placeholder="Saisir votre prenom"><br>
<input required type="text" name="adresse.numero" placeholder="Saisir votre numero"><br>
<input required type="text" name="adresse.voie" placeholder="Saisir votre voie"><br>
<input required type="text" name="adresse.ville" placeholder="Saisir votre ville"><br>
<input required type="text" name="adresse.cp" placeholder="Saisir votre cp"><br>
<input required type="text" name="societe" placeholder="Saisir votre societe"><br>


<input type="submit" value="Ajouter fournisseur">
</form>

</body>
</html>