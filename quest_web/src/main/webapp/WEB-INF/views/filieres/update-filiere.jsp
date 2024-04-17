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
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<h3 id="titreMaTable">Fiche Filiere ${filiere.id}</h3>

		<!-- Affichage de la saisie de filière-->



		<form:form action="filiere/${filiere.id}" method="post"
			modelAttribute="filiere">
			<form:hidden path="id" />
			<div class="form-Filiere">
			<div class="form-group">
				<table>
						<form:label path="libelle">Libellé de la Filière : :</form:label>
						<form:input path="libelle" type="text" />
						<form:errors path="libelle" style="color:red"></form:errors>

						<form:label path="debut">Date Début de la Matière  :</form:label>
						<form:input path="debut" type="date" />
						<form:errors path="debut" style="color:red"></form:errors>

						<form:label path="fin">Date Fin de la Matière :</form:label>
						<form:input path="fin" type="date" />
						<form:errors path="fin" style="color:red"></form:errors>
				</table>
				</div>
			</div>

			<input class="btn btn-warning" type="submit" value="Modifier">
			<a href="filiere"><input type="button" class="btn btn-info"
				value="Retour"></a>
		</form:form>


	</div>

</body>
</html>