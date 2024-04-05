<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="includes.jsp"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Module</title>

<style>
table {
	width: 90%;
	margin: auto;
}

th, td {
	padding: 10px;
	text-align: center;
}

h2 {
	text-align: center;
}

.btn-modifier {
	background-color: blue;
	color: white;
	border: none;
	padding: 8px 16px;
	border-radius: 4px;
	cursor: pointer;
}

.btn-supprimer {
	background-color: red;
	color: white;
	border: none;
	padding: 8px 16px;
	border-radius: 4px;
	cursor: pointer;
}

.btn-modifier:hover {
	background-color: lightblue;
}

.btn-supprimer:hover {
	background-color: lightgrey;
}

legend {
	color: grey;
}
</style>
</head>
<body>
	<h2>Table des modules de la filiere ${filiere.id}
		-${filiere.libelle}</h2>
	<div class="container">
		<table>
			<thead>
				<tr>
					<th context="col">Debut</th>
					<th context="col">Fin</th>
					<th context="col">Quest</th>
					<th context="col">Matiere</th>
					<th context="col">Formateur</th>
					<th context="col" align="center" colspan="2">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${modules.isEmpty()}"><tr><td colspan="7">PAS ENCORE DE MODULE</td></tr></c:if>
				<c:forEach items="${modules}" var="module">
					<tr>
						<td>${module.debut}</td>
						<td>${module.fin}</td>
						<td>${module.quest}</td>
						<td>${module.matiere.libelle}</td>
						<c:choose>
							<c:when test="${module.formateur==null}">
								<td>Pas de formateur</td>
							</c:when>

							<c:otherwise>
								<td>${module.formateur.prenom} ${module.formateur.nom}</td>
							</c:otherwise>
						</c:choose>
						<td colspan="2">
							<a href="module?id=${module.id}"><button disabled class="btn-modifier">Modifier</button></a>
							<a href="module?filiere=${filiere.id}&id=${module.id}&delete"><button class="btn-supprimer">Supprimer</button></a>
						</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
		<br> <br>
	</div>
	<div class="container">
		<div class="md-medium">
			<b>Ajouter un nouveau module</b>
		</div>
		<form action="module" method="POST">
			<div class="mb-3">
				<label for="debut" class="form-label">Debut</label> <input
					type="date" class="form-control" id="debut" name="debut">
			</div>
			<div class="mb-3">
				<label for="fin" class="form-label">Fin</label> <input type="date"
					class="form-control" id="fin" name="fin">
			</div>
			<div class="mb-3">
				<label for="inputquest" class="form-label">Quest</label> <input
					type="text" class="form-control" id="inputLibelle" name="quest"
					required>
			</div>
			<input type="hidden" value="${filiere.id}" name="filiere.id">
			<div class="mb-3">
				<label for="inputmatiere" class="form-label">Matiere</label> 
				<select name="matiere.id" required>
					<option value="">Choisir une matiere</option>
					<c:forEach items="${matieres}" var="matiere">
						<option value="${matiere.id}">${matiere.id}-${matiere.libelle}</option>
					</c:forEach>
				</select>
			</div>
			<div class="mb-3">
				<label for="inputformateur" class="form-label">Formateur</label> 
				<select name="formateur.id">
					<option value="">Pas de formateur</option>
					<c:forEach items="${formateurs}" var="formateur">
						<option value="${formateur.id}">${formateur.id}-${formateur.prenom} ${formateur.nom}</option>
					</c:forEach>
				</select>
			</div>
			<div>
				<input style="width: 100%" class="btn btn-success" type="submit"
					value="Ajouter">
			</div>
		</form>
	</div>
</body>
</html>