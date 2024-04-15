<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="container">
    <h3 id="titreMaTable">Fiche Filiere ${filiere.id}</h3>

    <!-- Affichage de la saisie de filière-->
    <form action="filiere/${filiere.id}" method="POST">
    <div class="form-Filiere">
    <h3>   Fiche Matiere ${filiere.id} </h3>
      <input type="hidden" value="${filiere.id}" name="id">
      <div class="form-group">
        <label for="libelle">Libellé de la Filière :</label>
        <input type="text" id="libelle" value="${filiere.libelle}" name="libelle">
        
        <label for="libelle">Date Début de la Matière :</label>
        <input type="text" id="libelle" value="$filiere.debut}" name="libelle">
        
        <label for="libelle">Date Fin de la Matière :</label>
        <input type="text" id="libelle" value="${filiere.fin}" name="libelle">
        
        <input type="submit" value="Modifier">
      </div>
    </div>
  </form>

  </div>

</body>
</html>