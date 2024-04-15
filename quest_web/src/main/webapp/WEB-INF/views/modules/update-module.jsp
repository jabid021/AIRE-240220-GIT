<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

  <%--  <%@ include file="includes.jsp"%>--%>


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
	
	<div class="container">
		<div class="md-medium">
			<b>Modifier  module</b>
		</div>
		<form:form action="module/${module.id}" method="POST" modelAttribute="module">
			
			<form:hidden path="id"/>
			<div class="mb-3">
				<form:label path="debut" class="form-label">Debut</form:label> <form:input  value="${module.debut}"  type="date"
					class="form-control" path="debut"/>
			</div>
			<div class="mb-3">
				<form:label path="fin" class="form-label">Fin</form:label> <form:input  value="${module.fin}" type="date" class="form-control" path="fin"/>
			</div>
			<div class="mb-3">
				<form:label path="quest" class="form-label">Quest</form:label> <form:input type="number"
					class="form-control" path="quest" required="required"/>
			</div>
			<form:hidden path="filiere.id"/>
			<div class="mb-3">
				<form:label path="matiere.id" class="form-label">Matiere</form:label> 
				<form:select path="matiere.id" required="required">
				<form:option value="">Choisir une matiere</form:option>
				<form:options items="${matieres}"  itemValue="id" itemLabel="infoSelect"/>
				</form:select>
			</div>
			<div class="mb-3">
				<label for="inputformateur" class="form-label">Formateur</label> 
				<form:select path="formateur.id">
					<form:option value="">Pas de formateur</form:option>
					<form:options items="${formateurs}" itemValue="id" itemLabel="infoSelect"/>
				</form:select>
			</div>
			<div>
				<input style="width: 100%" class="btn btn-success" type="submit"
					value="Modifier">
			</div>
		</form:form>
	</div>
</body>
</html>