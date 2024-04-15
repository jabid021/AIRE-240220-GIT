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
		<form action="stagiaire/${stagiaire.id}" method="POST">
			<fieldset>
				<legend>
					<b>Modifier un stagiaire</b>
					<input type="hidden" value="${stagiaire.id}" name="id">
				</legend>
				<table>
					<tbody>

						<tr>
							<td>Mail :</td>
						</tr>
						<tr>
							<td><input style="width: 80%" required name="email"
								placeholder="Saisir votre email" type="email"></td>
						</tr>


						<tr>
							<td>Password :</td>
						</tr>
						<tr>
							<td><input style="width: 80%" maxlength="8" required name="password"
								placeholder="Saisir votre password" type="password"></td>
						</tr>

						<tr>
							<td>Nom :</td>
						</tr>
						<tr>
							<td><input style="width: 80%" required name="nom"
								placeholder="Saisir votre nom" type="text"></td>
						</tr>

						<tr>
							<td>Prenom :</td>
						</tr>
						<tr>
							<td><input style="width: 80%"
								placeholder="Saisir votre prenom" required name="prenom" type="text"></td>
						</tr>

						<tr>
							<td>Numero :</td>
						</tr>
						<tr>
							<td><input style="width: 80%" required name="adresse.numero"
								placeholder="Saisir votre numero d'adresse" type="text"></td>
						</tr>

						<tr>
							<td>Voie :</td>
						</tr>
						<tr>
							<td><input style="width: 80%"
								placeholder="Saisir votre voie d'adresse" required name="adresse.voie"
								type="text"></td>
						</tr>


						<tr>
							<td>Ville :</td>
						</tr>
						<tr>
							<td><input style="width: 80%" required name="adresse.ville"
								placeholder="Saisir votre ville" type="text"></td>
						</tr>

						<tr>
							<td>Cp:</td>
						</tr>
						<tr>
							<td><input style="width: 80%" required name="adresse.cp"
								placeholder="Saisir votre code postal" type="text"></td>
						</tr>

						<tr>
							<td>Filiere :</td>
						</tr>
						<tr>
							<td><select name="filiere.id" required>
									<option value="">Choisir une filière</option>
									<c:forEach items="${filieres}" var="filiere">
										<option value="${filiere.id}">${filiere.id}-${filiere.libelle}</option>
									</c:forEach>
									<%-- >option value="1">1 - AIRE</option>
									<option value="2">2 - POEI JAVA</option>
									<option value="3">3 - POEI COBOL</option--%>
							</select></td>
						</tr>
					</tbody>
				</table>
			</fieldset>
			<button type="submit" class="btn btn-success">Modifier</button>
		</form>
	</main>



</body>
</html>
