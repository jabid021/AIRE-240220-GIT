<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<title>Stagiaires</title>


</head>

<style>
body {
	background-color: rgb(243, 243, 243);
}

table {
	border-collapse: collapse;
	width: 100%;
	margin-top: 30px;
}

.table_border th, .table_border td {
	border: 2px solid black;
	padding: 8px;
}

th.actions {
	width: 100px;
}

.btn-group {
	display: flex;
	justify-content: space-between;
}

.btn {
	flex: 1;
	margin: 0 5px;
}

form table {
	width: 100%;
}

form th, form td {
	text-align: left;
	margin: 30px;
}

.btn-success {
	width: 100%;
	margin-top: 20px;
}

legend {
	color: yellowgreen;
}

dd {
	text-transform: uppercase;
	font-size: 40px;
	text-align: center;
	margin-top: 30px;
}
</style>

<body>

	<h1>Fiche du Stagiaire ${stagiaire.id}</h1>
	<main>
		<form:form  action="stagiaire/${stagiaire.id}" method="POST" modelAttribute="stagiaire">
			<fieldset>
				<legend>
					<<b>Modifier un stagiaire</b>
				</legend>
				<table>
					<tbody>

						<tr>
							<td>Mail :</td>
						</tr>
						<tr>
							<td>
							<form:label path="email"></form:label>
							
							<form:input style="width: 80%" required="required" path="email"
								placeholder="Saisir votre email" type="email"/>
							<form:errors path="email" style= "color: red" ></form:errors>
								</td>
						</tr>


						<tr>
							<td>Password :</td>
						</tr>
						<tr>
							<td>
							<form:label path="password"></form:label>
							<form:input style="width: 80%" required="required" path="password"
								placeholder="Saisir votre password" type="password"/>
								<form:errors path="password" style= "color: red" ></form:errors>
								</td>
						</tr>

						<tr>
							<td>Nom :</td>
						</tr>
						<tr>
							<td>
							<form:label path="nom"></form:label>
							<form:input style="width: 80%" required="required" path="nom"
								placeholder="Saisir votre nom" type="text"/>
								<form:errors path="nom" style= "color: red" ></form:errors>
								</td>
						</tr>

						<tr>
							<td>Prenom :</td>
						</tr>
						<tr>
							<td>
							<form:label path="prenom"></form:label>
							<form:input style="width: 80%"
								placeholder="Saisir votre prenom" required="required" path="prenom" type="text"/>
								<form:errors path="prenom" style= "color: red" ></form:errors>
								</td>
						</tr>

						<tr>
							<td>Numero :</td>
						</tr>
						<tr>
							<td>
							<form:label path="adresse.numero"></form:label>
							<form:input style="width: 80%" required="required" path="adresse.numero"
								placeholder="Saisir votre numero d'adresse" type="text"/>
								<form:errors path="adresse.numero" style= "color: red" ></form:errors>
								</td>
						</tr>

						<tr>
							<td>Voie :</td>
						</tr>
						<tr>
							<td>
							<form:label path="adresse.voie"></form:label>
							<form:input style="width: 80%"
								placeholder="Saisir votre voie d'adresse" required="required" path="adresse.voie"
								type="text"/>
								<form:errors path="adresse.voie" style= "color: red" ></form:errors>
								</td>
						</tr>


						<tr>
							<td>Ville :</td>
						</tr>
						<tr>
							<td>
							<form:label path="adresse.ville"></form:label>
							<form:input style="width: 80%" required="required" path="adresse.ville"
								placeholder="Saisir votre ville" type="text"/>
								<form:errors path="adresse.ville" style= "color: red" ></form:errors>
								</td>
						</tr>

						<tr>
							<td>Cp:</td>
						</tr>
						<tr>
							<td>
							<form:label path="adresse.cp"></form:label>
							<form:input style="width: 80%" required="required" path="adresse.cp"
								placeholder="Saisir votre code postal" type="text"/>
								<form:errors path="adresse.cp" style= "color: red" ></form:errors>
								</td>
						</tr>

						<tr>
							<td>Filiere :</td>
						</tr>
						<tr>
							<td>
							<form:label path="filiere.id"></form:label>
							<form:select path="filiere.id" required="required">
									<form:option value="">Choisir une filière</form:option>
									<form:options items="${filieres}" itemValue="id" itemLabel="infos"/>
									<form:errors path="filiere.id" style= "color: red" ></form:errors>
										
							</form:select></td>
						</tr>
					</tbody>
				</table>
			</fieldset>
			<input class ="btn btn-success" type="submit" value="Modifier">
		</form:form>
	</main>



</body>
</html>
