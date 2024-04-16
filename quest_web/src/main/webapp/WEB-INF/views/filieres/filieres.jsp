<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Filieres</title>
</head>
<body>


<div  class="container">
    <br><br><br><br>
    <table class="table table-hover">
        <thead>
          <tr>
            <th scope="col">Id</th>
            <th scope="col">Libellé</th>
            <th scope="col">Date de Début</th>
            <th scope="col">Date de Fin</th>
            <th scope="col">Actions</th>

          </tr>
        </thead>
        <tbody>
          <c:forEach items="${ filieres }" var="filiere">
          <tr>
            <th scope="row">${filiere.id }</th>
            <td>${filiere.libelle }</td>
            <td>${filiere.debut }</td>
            <td>${filiere.fin }</td>
            <td><a href="filiere/${filiere.id}"><button type="button" class="btn btn-warning">Modifier</button></a></td>
            <td><a href="filiere/delete/${filiere.id}"><button type="button" class="btn btn-danger">Supprimer</button></a></td>
          	<td><a href="module/filiere-${filiere.id}"><button type="button" class="btn btn-info">Voir ses modules</button></a></td>
          </tr>
          </c:forEach>
          

        </tbody>
      </table>

</div>
<br>
<br>
<br>
<br>
<div  class="container">
    <div class="fw-medium">Ajouter nouvelle Fillière</div><br><br>
<form:form  action="filiere" method="post"  modelAttribute="filiere">
<form:hidden path="id" />
    <div class="mb-3">
      <form:label path="libelle"  class="form-label border">Libellé</form:label>
      <form:input path="libelle" type="text" class="form-control border"
                  required="required"/>
      <form:errors path="libelle" style="color:red"></form:errors>
    </div>
    <div class="mb-3">
        <form:label path="debut" class="form-label border">Date de Début</form:label>
        <form:input path="debut" type="date" class="form-control border" />
     </div>
     <div class="mb-3">
        <form:label path="fin" class="form-label border">Date de Fin</form:label>
        <form:input path="fin"  type="date" class="form-control border" name="fin" />
        
     </div>
    <button type="submit" class="btn btn-success btn-lg  border">Ajouter</button>
  </form:form>
</div>

</body>
</html>