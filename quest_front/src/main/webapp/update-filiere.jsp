<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="container">
    <h3 id="titreMaTable">Fiche Filiere ${filiere.id}</h3>

    <!-- Affichage de la saisie de fili�re-->
    <form action="filiere" method="POST">
    <div class="form-Filiere">
    <h3>   Fiche Matiere ${filiiere.id} </h3>
      <input type="hidden" value="${filiere.id}" name="id">
      <div class="form-group">
        <label for="libelle">Libell� de la Fili�re :</label>
        <input type="text" id="libelle" value="${filiere.libelle}" name="libelle">
        
        <label for="libelle">Date D�but de la Mati�re :</label>
        <input type="text" id="libelle" value="$filiere.debut}" name="libelle">
        
        <label for="libelle">Date Fin de la Mati�re :</label>
        <input type="text" id="libelle" value="${filiere.fin}" name="libelle">
        
        <input type="submit" value="Modifier">
      </div>
    </div>
  </form>

  </div>

</body>
</html>