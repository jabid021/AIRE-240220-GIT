
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des filieres</title>
</head>
<body>


<div id="content">
<h1>Liste des Filieres</h1>
     <input id="btnAddFiliere" type="button" class ="btn btn-success" value="Ajouter">
     <a href="index.html"><input type="button" class ="btn btn-info" value="Retour"></a>

     <table class="table table-striped">
       <thead>
         <tr>
           <th>Id</th>
           <th>Libelle</th>
           <th>Debut</th>
           <th>Fin</th>
           <th>Actions</th>
           </tr>
       </thead>
       <tbody>
       <c:forEach items="${filieres}" var="filiere">
	         <tr>
	           <td>${filiere.id}</td>
	           <td>${filiere.libelle}</td>
	           <td>${filiere.debut}</td>
	           <td>${filiere.fin}</td>
	           <td>
	             <a href="filiere?id=${filiere.id}"><input type="button" class ="btn btn-warning" value="Modifier"></a>
	             <a href="filiere?id=${filiere.id}&delete"><input type="button" class ="btn btn-danger" value="Supprimer"></a>
	           </td>
	         </tr>
         </c:forEach>
       </tbody>
     </table>





     <div id="addFormFiliere" class="formAjout">
            <h3>Ajouter Filiere</h3>
            <form action="filiere" method="post">
            Libelle :<input name="libelle" type="text" placeholder="Saisir le libelle"><br>
            Debut :<input name="debut" type="date"><br>
            Fin :<input name="fin" type="date"><br>

              <input class ="btn btn-success" type="submit" value="Ajouter">
            </form>
        </div>

</div>

</body>
</html>

<script>

btnAddFiliere.onclick=function()
{
  addFormFiliere.style.display="block";
}

</script>